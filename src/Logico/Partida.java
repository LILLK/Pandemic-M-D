package Logico;

//Mehdi Tahrat && David hola
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

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
	//Dificultad de la partida
	public static int dificultad;
	// Lista de todas las ciudades con sus atributos
	public static ArrayList<Ciudades> ciudades;
	// Lista de todas las Vacunas con sus atributos
	public static ArrayList<Vacunas> vacunas;
	// Lista de todas las Viruses con sus atributos
	public static ArrayList<Viruses> viruses;

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
	public static void jugarPartida() {
		updatePartida();
		ejecutar.imprimir();
		while (!fin()) {
			Partida.ronda++;
			ronda();
			if (!fin()) {
				infectar();
			}
			ejecutar.imprimir();
		}
	}
	//////////////////////////////////////////////////////////////////////////////////////
	// -ronda
	// Las acciones del jugador en la ronda
	/////////////////////////////////////////////////////////////////////////////////////
	public static void ronda() {
		Scanner scn = new Scanner(System.in);
		int intput;
		System.out.println("Ronda: " + Partida.ronda);
		for (int i = 1; i < 5; i++) {
			System.out.println("Acciones restantes: "+(5-i));
			System.out.println("1 curar - 2 desarollar");
			intput = scn.nextInt();
			Jugador.acciones(intput);
			updatePartida();
		}
	}
	//////////////////////////////////////////////////////////////////////////////////////
	// -infectar
	//Las acciones del programa despues de las del jugador 
	/////////////////////////////////////////////////////////////////////////////////////
	public static void infectar() {
		for (int i = 0; i < Parametros.infeccionRonda; i++) {
			int random = (int) (Math.random() * Partida.ciudades.size());
			
			Partida.ciudades.get(random).infectar();
			
			
			System.out.println("se a infectado la ciudad: "+ Partida.ciudades.get(random).nombre);
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
		iniciarNuevaPartida();
		Partida.jugarPartida();

		
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
		} else if (Partida.enfermedades == 0) {
			System.out.println();
			return true;
		}
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
	public static void iniciarNuevaPartida() {
		Partida.brotes = 0;
		Partida.Puntuacion = 0;
		Partida.enfermedades = 0;
		Partida.ronda = 0;
		Parametros.establecerParametros();
		Partida.viruses = new ArrayList<Viruses>();
		Partida.vacunas = new ArrayList<Vacunas>();
		Partida.ciudades = new ArrayList<Ciudades>();
		Ciudades.generarCiudades();
		Viruses.generarVirus();
	}

	//////////////////////////////////////////////////////////////////////////////////////
	// - genrarViruses
	// rellena la lista de viruses
	/////////////////////////////////////////////////////////////////////////////////////
	public static void cargarPartida() {
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
		for (Ciudades ciudad : Partida.ciudades) {
			Partida.enfermedades += ciudad.nEnfermedades;
		}
	}

	//////////////////////////////////////////////////////////////////////////////////////
	// - updateBrotes
	// actualiza los brotes en el juego
	/////////////////////////////////////////////////////////////////////////////////////
	public static void updateBrotes() {
		Partida.brotes = 0;
		for (Ciudades ciudad : Partida.ciudades) {
			if (ciudad.nEnfermedades == 3) {
				Partida.brotes++;
			}
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
		updatePuntuacion();
	}

}
