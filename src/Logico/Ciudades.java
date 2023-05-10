package Logico;

import java.util.ArrayList;
import java.util.Arrays;

import Botones.BotonCiudad;
import Pandemic.JF_PanelPartida;
import Pandemic.JF_PanelPartidaPanel2;

//Mehdi Tahrat && David hola

public class Ciudades {
	public String nombre;
	public int idVirus;
	public int posicionX;
	public int posicionY;
	public ArrayList<String> colindantes;
	public boolean brote;
	public int nEnfermedades;

	// cuando se tiene que infectar a las ciudades, se marca esta flag para no
	// infectarla otra vez
	boolean infeccionRonda;

	////////////////////////////////////
	/////////// constructores //////////
	////////////////////////////////////
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
	////////////////////////////////////
	////////////// metodos /////////////
	////////////////////////////////////

	////////////////////////////////////
	// -Infectar
	//
	////////////////////////////////////
	public void infectar() {
		this.infeccionRonda = true;
		/*
		 * System.out.println("////////////////////////////////////");
		 * System.out.println("infecto:  " + this.nombre); for (String string :
		 * colindantes) { System.out.println("colindante: " + string); }
		 * System.out.println("////////////////////////////////////");
		 */
		if (this.nEnfermedades < 3) {// si es mas pequeño de 3
			this.nEnfermedades++;
			// si tiene 3 enfermedades y no tiene un brote, se generara uno
		} else if (this.nEnfermedades == 3 && !this.brote) {
			this.brote = true;
			Partida.brotes++;
			/*
			 * System.out.println("////////////////");
			 * System.out.println("brote en: "+this.nombre);
			 * System.out.println("////////////////");
			 */

			// recorremos las ciudades colindantes a esta
			for (String ciudadColindante : this.colindantes) {
				// si no a sido infectada en esta ronda
				if (!JF_PanelPartida.botonesCiudad.get(getIdXnombre(ciudadColindante)).ciudad.infeccionRonda)
					// se infecta la ciudad
					JF_PanelPartida.botonesCiudad.get(getIdXnombre(ciudadColindante)).ciudad.infectar();
			}
			// si ya tiene brote esta infectara a las colindantes
		} else if (this.brote) {
			// recorremos las ciudades colindantes a esta
			for (String ciudadColindante : this.colindantes) {
				// si no a sido infectada en esta ronda
				if (!JF_PanelPartida.botonesCiudad.get(getIdXnombre(ciudadColindante)).ciudad.infeccionRonda)
					// se infecta la ciudad
					JF_PanelPartida.botonesCiudad.get(getIdXnombre(ciudadColindante)).ciudad.infectar();
			}
		}
	}

	/////////////////////////////////////
	///////////// Funciones ////////////
	////////////////////////////////////

	//////////////////////////////////////////////////////////////////////////////////////
	// - getIdXnombre
	// devuelve la posicion en la lista segun el nombre
	/////////////////////////////////////////////////////////////////////////////////////
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
	// rellena la lista de Partida.ciudades
	/////////////////////////////////////////////////////////////////////////////////////
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
				Partida.ciudades.get(random).setBrote(true);
				Partida.brotes++;
			}

		}

	}

	//////////////////////////////////////////////////////////////////////////////////////
	// - generarColindantes
	// devuelve una lista con las colindandtes
	/////////////////////////////////////////////////////////////////////////////////////
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
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isBrote() {
		return brote;
	}

	public void setBrote(boolean brote) {
		this.brote = brote;
	}

	public int getIdVirus() {
		return idVirus;
	}

	public void setIdVirus(int idVirus) {
		this.idVirus = idVirus;
	}

	public int getnBrotes() {
		return nEnfermedades;
	}

	public void setnBrotes(int nBrotes) {
		this.nEnfermedades = nBrotes;
	}

	public int getnEnfermedades() {
		return nEnfermedades;
	}

	public void setnEnfermedades(int nEnfermedades) {
		this.nEnfermedades = nEnfermedades;
	}

	public boolean isInfeccionRonda() {
		return infeccionRonda;
	}

	public void setInfeccionRonda(boolean infeccionRonda) {
		this.infeccionRonda = infeccionRonda;
	}

	public static void setInfeccionRondaFalse() {
		for (BotonCiudad btnCiudad : JF_PanelPartida.botonesCiudad) {
			btnCiudad.ciudad.setInfeccionRonda(false);
		}
	}
}
