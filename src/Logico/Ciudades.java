//Mehdi Tahrat && David hola
package Logico;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import Botones.BotonCiudad;
import Pandemic.JF_PanelPartida;
import Pandemic.JF_PanelPartidaPanel2;

/**
 * Esta classe contiene el objeto ciudades.
 * Esta tiene los metodos de generaccion y 
 * las acciones de estas.
 * +String nombre - nombre de la ciudad
 * +int idVirus - id de virus de la ciudad
 * +int posicionX - posision x de la ciudad
 * +int posicionY - posision y de la ciudad 
 * +ArrayList<String> colindantes - lista de nombres de las ciudades colindantes
 * +boolean brote - estado de brote
 * +int nEnfermedades - numero de enfermedades de la ciudad
 * +boolean infeccionRonda - cuando se tiene que infectar a las ciudades, 
 * se marca esta flag para no infectarla otra vez
 * @author DAME
 *
 */
public class Ciudades {
	public String nombre;
	public int idVirus;
	public int posicionX;
	public int posicionY;
	public ArrayList<String> colindantes;
	public boolean brote;
	public int nEnfermedades;

	public boolean infeccionRonda;

	////////////////////////////////////
	/////////// constructores //////////
	////////////////////////////////////
	/**
	 * Este constructor genera la ciudad con todos sus atributos desde los archivos locales
	 * @param String nombre
	 * @param int posicionX
	 * @param int posicionY
	 * @param int idVirus
	 */
	public Ciudades(String nombre, int posicionX, int posicionY, int idVirus) {
		this.nombre = nombre;
		this.posicionX = posicionX;
		this.posicionY = posicionY;
		this.idVirus = idVirus;
		colindantes = new ArrayList<String>();
		this.nEnfermedades = 0;
		this.brote = false;
		this.colindantes = generarColindantes(this.nombre);
		this.infeccionRonda = false;
	}
	/**
	 * Este constructor genera la ciudad con todos sus atributos desde la BD
	 * @param String nombre
	 * @param int posicionX
	 * @param int posicionY
	 * @param int idVirus
	 */
	public Ciudades(String nombre, int infeccion, int idVirus, boolean brote) {
		int[] xy = new int[2];
		xy = posicionxy(nombre);
		this.nombre = nombre;
		this.posicionX = xy[0];
		this.posicionY = xy[1];
		this.idVirus = idVirus;
		colindantes = new ArrayList<String>();
		this.nEnfermedades = infeccion;
		this.brote = brote;
		this.colindantes = generarColindantes(this.nombre);
		this.infeccionRonda = false;
	}
	////////////////////////////////////
	////////////// metodos /////////////
	////////////////////////////////////

	/**
	 * Este metodo infecta a la ciudad y genera un brote si es necesario,
	 * infectando a todas las colindantes.
	 * Si ocurre un brote se restara 500 de puntuacion.
	 * Si ocurre una infeccion se restara 100 de puntuacion.
	 */
	public void infectar() {
		JF_PanelPartidaPanel2.updateLog("-----------------");
		JF_PanelPartidaPanel2.updateLog("Se a infectado la ciudad: " + this.nombre);
		if (this.nEnfermedades < 3) {// si es mas pequeño de 3
			this.nEnfermedades++;
			Partida.Puntuacion-=100;
			// si tiene 3 enfermedades y no tiene un brote, se generara uno
		} else if (this.nEnfermedades == 3 && !this.brote) {
			this.infeccionRonda = true;
			JF_PanelPartidaPanel2.updateLog("BROTE GENERADO EN: " + this.nombre + "!!!!!!!!!!!");
			this.brote = true;
			Partida.brotes++;
			Partida.Puntuacion-=500;
			// recorremos las ciudades colindantes a esta
			for (String ciudadColindante : this.colindantes) {
				// si no a sido infectada en esta ronda
				if (!JF_PanelPartida.botonesCiudad.get(getIdXnombre(ciudadColindante)).ciudad.infeccionRonda)
					// se infecta la ciudad
					JF_PanelPartida.botonesCiudad.get(getIdXnombre(ciudadColindante)).ciudad.infectar();
			}
			// si ya tiene brote esta infectara a las colindantes
		} else if (this.brote) {
			this.infeccionRonda = true;
			Partida.Puntuacion-=500;
			JF_PanelPartidaPanel2.updateLog("BROTE GENERADO EN: " + this.nombre + "!!!!!!!!!!!");
			// recorremos las ciudades colindantes a esta
			for (String ciudadColindante : this.colindantes) {
				// si no a sido infectada en esta ronda
				if (!JF_PanelPartida.botonesCiudad.get(getIdXnombre(ciudadColindante)).ciudad.infeccionRonda)
					// se infecta la ciudad
					JF_PanelPartida.botonesCiudad.get(getIdXnombre(ciudadColindante)).ciudad.infectar();
			}
		}

		JF_PanelPartida.botonesCiudad.get(getIdXnombre(this.nombre)).establecerIcono(
				JF_PanelPartida.botonesCiudad.get(getIdXnombre(this.nombre)).tamañoX,
				JF_PanelPartida.botonesCiudad.get(getIdXnombre(this.nombre)).tamañoY);
		JF_PanelPartidaPanel2.updateLog("-----------------");

	}

	/**
	 * Este metodo cura a la ciudad x enfermedades dependiendo del estado de las vacunas.
	 */
	public void curar() {
		//si las enfermedades son 0 o menos 
		if (this.nEnfermedades <= 0) {
			//mostrar error
			JOptionPane.showMessageDialog(new JFrame(), "No se puede curar la ciudad: " + this.nombre);
		} else {
			JF_PanelPartidaPanel2.updateLog("-----------------");
			// si el id de virus de la ciudad es el mismo que la vacuna y la hemos
			// desarollado
			if (Partida.vacunas.get(this.idVirus).desarollo >= 100) {
				// curar ciudad elejida completamente
				this.nEnfermedades = 0;
				Partida.Puntuacion+=300;
			} else {
				// sino se restara una enfermedad
				this.nEnfermedades -= 1;
				Partida.Puntuacion+=100;
			}
			// si teiene estado de brote se quita
			if (this.brote) {
				Partida.Puntuacion+=750;
				this.brote = false;
				JF_PanelPartidaPanel2.updateLog("brote curado en :" + this.nombre);

			}
			JF_PanelPartidaPanel2.restarAcciones();
			JF_PanelPartidaPanel2.updateLog("Se ha curado la ciudad: "+this.nombre);
			JF_PanelPartidaPanel2.updateLog("nº Enfermedades"+String.valueOf(nEnfermedades));
			JF_PanelPartidaPanel2.updateLog("-----------------");
		}
	}

	/////////////////////////////////////
	///////////// Funciones ////////////
	////////////////////////////////////

	/**
	 * Esta funcion busca la id(posicion) de la ciudad segun su nombre
	 * @param String nombre
	 * @return int
	 */
	public static int getIdXnombre(String nombre) {
		int aux = 0;
		// recorre todas las ciudades
		for (int i = 0; i < Partida.ciudades.size(); i++) {
			// si encuentra el nombre con la ciudad enviada
			if (Partida.ciudades.get(i).nombre.contains(nombre))
				aux = i;
		}
		return aux;// devuelve su posicion en la lista
	}

	//////////////////////////////////////////////////////////////////////////////////////
	// - generarCiudades
	// 
	/////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Esta funcion rellena la lista de Partida.ciudades con ciudades generadas con los archivos.
	 */
	public static void generarCiudades() {
		String nombre;
		int idVirus;
		int[] posicion = new int[2];
		ArrayList<String> listaCiudades = ArchivosIO.leerCiudades();
		// por cada linea se recogen los datos y pasan a ser los constructores de
		// ciudades
		for (String lin : listaCiudades) {
			// lin = " nombre;idVirus;pos1,pos2;colindante1,colindante2...; "
			// extraer los datos de la String
			nombre = lin.split(";")[0];
			idVirus = Integer.parseInt(lin.split(";")[1]);
			posicion[0] = Integer.parseInt(lin.split(";")[2].split(",")[0]);
			posicion[1] = Integer.parseInt(lin.split(";")[2].split(",")[1]);
			// Construccion de todas las ciudades
			Ciudades ciudad = new Ciudades(nombre, posicion[0], posicion[1], idVirus);
			// Se añade en la lista global Partida.ciudades
			Partida.ciudades.add(ciudad);
		}

		// Mientras haya menos brotes que los necesarios para empezar
		while (Partida.brotes < Parametros.brotesInicio) {
			// busca una ciudad aleatoria y la infecta 3 veces para generar un brote
			int random = (int) (Math.random() * Partida.ciudades.size());
			// si no a tenido bruto la ciudad elejida random
			if (!Partida.ciudades.get(random).brote) {
				// se genera un brote
				for (int i = 0; i < 3; i++) {
					Partida.ciudades.get(random).nEnfermedades++;
				}
				Partida.ciudades.get(random).brote=true;
				Partida.brotes++;
			}

		}

	}
/**+
 * Esta funcion devuelve la posicion(x,y) de la ciudad segun el nombre
 * @param String nombreC
 * @return int[]
 */
	public static int[] posicionxy(String nombreC) {
		int[] xy = new int[2];
		ArrayList<String> listaCiudades = ArchivosIO.leerCiudades();
		// por cada linea se recogen los datos y pasan a ser los constructores de
		// ciudades
		for (String lin : listaCiudades) {
			if (nombreC.equals(lin.split(";")[0])) {
				xy[0] = Integer.parseInt(lin.split(";")[2].split(",")[0]);
				xy[1] = Integer.parseInt(lin.split(";")[2].split(",")[1]);
			}
		}
		return xy;
	}

	//////////////////////////////////////////////////////////////////////////////////////
	// - generarColindantes
	// 	/////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Esta funcion devuelve una lista con las ciudades colindandtes
	 * @param String nombre
	 * @return ArrayList<String>
	 */
	public static ArrayList<String> generarColindantes(String nombre) {
		ArrayList<String> colindantes = null;
		ArrayList<String> listaCiudades = ArchivosIO.leerCiudades();
		for (String lin : listaCiudades) {
			// lin = " nombre;idVirus;pos1,pos2;colindante1,colindante2...; "
			if (lin.split(";")[0].equals(nombre)) {// si encuentra el nombre enviado lee las colindantes
				colindantes = new ArrayList<String>(Arrays.asList(lin.split(";")[3].split(",")));
			}
		}
		return colindantes;
	}

	////////////////////////////////////
	/////////// setters&getters//////////
	////////////////////////////////////

/**
 * Setter infeccionRonda
 * @param boolean infeccionRonda
 */
	public void setInfeccionRonda(boolean infeccionRonda) {
		this.infeccionRonda = infeccionRonda;
	}
/*
 * Esta funcion establece todas las ciudas con estado falso en el atributo infeccionRonda
 */
	public static void setInfeccionRondaFalse() {
		for (BotonCiudad btnCiudad : JF_PanelPartida.botonesCiudad) {
			btnCiudad.ciudad.setInfeccionRonda(false);
		}
	}
}
