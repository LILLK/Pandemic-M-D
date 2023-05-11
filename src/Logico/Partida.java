
package Logico;

//Mehdi Tahrat && David hola
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import Botones.BotonCiudad;
import Pandemic.JF_PanelPartida;
import Pandemic.JF_PanelPartidaPanel2;

public class Partida {
	
	//id de la Partida
	public static int idP;
	// Puntuacion de la partida
	public static int Puntuacion;
	// Brotes de la partida
	public static int brotes;
	// Enfermedades en la partida
	public static int enfermedades;
	// rondas de la partida
	public static int ronda;
	// acciones de la ronda 
	public static int accionesRonda;
	//Dificultad de la partida
	public static int dificultad;
	// Lista de todas las ciudades con sus atributos
	public static ArrayList<Ciudades> ciudades= new ArrayList<Ciudades>();
	// Lista de todas las Vacunas con sus atributos
	public static ArrayList<Vacunas> vacunas = new ArrayList<Vacunas>();;
	// Lista de todas las Viruses con sus atributos
	public static ArrayList<Viruses> viruses = new ArrayList<Viruses>();
	


	////////////////////////////////////
	/////////// constructores //////////
	////////////////////////////////////

	public Partida() {

	}

	////////////////////////////////////
	////////////// metodos /////////////
	////////////////////////////////////

	/*
	 * 
	 */

	////////////////////////////////////
	///////////// Funciones ////////////
	////////////////////////////////////

	
	/////////////////////////////////////////
	// -jugarPartida
	// es dode se ejecuta la partida 
	////////////////////////////////////////
	public static void jugarPartida(JF_PanelPartida pPartida) {
		JF_PanelPartidaPanel2.updateAcciones();
		if (Partida.accionesRonda<=0) {
			Partida.accionesRonda=4;
			JF_PanelPartidaPanel2.updateAcciones();
			Partida.infectar();
		}
		if (Partida.fin()) {
			pPartida.irMenu();
			ConexionBD.guardarPartida(ConexionBD.con, true);
		}
	}
	
	//////////////////////////////////////////////////////////////////////////////////////
	// -infectar
	//Las acciones del programa despues de las del jugador 
	/////////////////////////////////////////////////////////////////////////////////////
	public static void infectar() {
		for (int i = 0; i < Parametros.infeccionRonda; i++) {
			int random = (int) (Math.random() * JF_PanelPartida.botonesCiudad.size());			
			JF_PanelPartida.botonesCiudad.get(random).ciudad.infectar();
		}
		Ciudades.setInfeccionRondaFalse();
		// esto impide que las ciudades se infecten infinitamente proibiendo infectarse
		// 2 o mas por ronda
		updatePartida();

	}
	
	/////////////////////////////////////////
	// -nuevaPartida
	// Empieza una nueva partida
	////////////////////////////////////////
	public static void nuevaPartida() {
		// Incicializa las variables necesarias para empezar partida
		// empieza la partida
		iniciarNuevaPartida(0);
		ConexionBD.iniciarPartida(ConexionBD.con);
		Partida.jugarPartida(null);

		
	}



	//////////////////////////////////////////////////////////////////////////////////////
	// -fin
	// determina si la partida a acabado por victoria o derrota
	/////////////////////////////////////////////////////////////////////////////////////
	public static boolean fin() {
		boolean aux = false;
		// si se llega al numero de brotes necesrio para perder
		if (Partida.brotes > Parametros.brotesTotal) {
			System.out.println("llega al numero de brotes necesrio ");
			return true;
			// si todas las ciudades han sidio limpiadas
		} /*else if (Partida.enfermedades == 0) {
			System.out.println();
			return true;
		}*/
		// si han sido todas las vacunas descubiertas
		else if (Vacunas.vacunasDescubiertas()) {
			return true;
		}
		return aux;
	}

	//////////////////////////////////////////////////////////////////////////////////////
	// -iniciarNuevaPartida 	
	// - rellena y inicializa las variables, listas y objetos necesarios
	/////////////////////////////////////////////////////////////////////////////////////
	public static void iniciarNuevaPartida(int dificultad) {
		Partida.brotes = 0;
		Partida.Puntuacion = 0;
		Partida.enfermedades = 0;
		Partida.ronda = 0;
		Partida.accionesRonda = 4;
		Parametros.establecerParametros(dificultad);
		Partida.viruses = new ArrayList<Viruses>();
		Partida.vacunas = new ArrayList<Vacunas>();
		Partida.ciudades = new ArrayList<Ciudades>();
		Ciudades.generarCiudades();
		Viruses.generarVirus();
		ConexionBD.iniciarPartida(ConexionBD.con);
		ConexionBD.idPartida(ConexionBD.con);
	}

	//////////////////////////////////////////////////////////////////////////////////////
	// - genrarViruses
	// rellena la lista de viruses
	/////////////////////////////////////////////////////////////////////////////////////
	public static void guardarPartida() {

	}

	//////////////////////////////////////////////////////////////////////////////////////
	// - genrarViruses
	// rellena la lista de viruses
	/////////////////////////////////////////////////////////////////////////////////////
	public static void registrarParametros() {

	}

	//////////////////////////////////////////////////////////////////////////////////////
	// - distanciaEntre2Puntos
	// Calcula la distancia que hay entre dos ciudades
	/////////////////////////////////////////////////////////////////////////////////////
	public static int distanciaEntre2Puntos(int[] xy1, int[] xy2) {
		return (int) Math.sqrt((Math.pow((xy2[0] - xy1[0]), 2) + (Math.pow((xy2[1] - xy1[1]), 2))));
	}

	////////////////////////////////////
	/////////// setters&getters//////////
	////////////////////////////////////

	public static int getPuntuacion() {
		return Puntuacion;
	}

	public static void setPuntuacion(int puntuacion) {
		Partida.Puntuacion = puntuacion;
	}

	public static int getBrotes() {
		return brotes;
	}

	public static void setBrotes(int brotes) {
		Partida.brotes = brotes;
	}

	public static int enfermedades() {
		return enfermedades;
	}

	//////////////////////////////////////////////////////////////////////////////////////
	// - updateEnfermedades
	// actualiza las enfermedades en el juego
	/////////////////////////////////////////////////////////////////////////////////////
	public static void updateEnfermedades() {
		Partida.enfermedades = 0;
		for (BotonCiudad btnCiudad : JF_PanelPartida.botonesCiudad) {
			Partida.enfermedades += btnCiudad.ciudad.nEnfermedades;
		}
	}


	/////////////////////////////////////////////
	// - updatePuntuacion
	// actualiza la puntuacion en el juego
	////////////////////////////////////////////
	public static void updatePuntuacion() {
		Partida.Puntuacion = (((((Partida.ciudades.size() * 3) - Partida.enfermedades)) / (Partida.brotes+ Partida.ronda))*Parametros.brotesTotal/Parametros.brotesInicio);
	}

	/////////////////////////////////////////////
	// - updatePartida
	// actualiza los datos en la partida
	////////////////////////////////////////////
	public static void updatePartida() {
		updateEnfermedades();
		// acabar de hacer puntuacion
		updatePuntuacion();
	}

}
