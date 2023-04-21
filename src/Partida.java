
//Mehdi Tahrat && David hola
import java.util.ArrayList;
import java.util.Scanner;

public class Partida {

	static int Puntuacion;
	static int brotes;
	static int enfermedades;
	static ArrayList<Ciudades> ciudades;
	static ArrayList<Vacunas> vacunas;
	static ArrayList<Viruses> viruses;

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

	//////////////////////////////////////////////////////////////////////////////////////
	// -nuevaPartida
	//
	/////////////////////////////////////////////////////////////////////////////////////
	public static void nuevaPartida() {
		
		iniciarNuevaPartida();
		
		while (!fin()) {
			
			//ronda();
			updateEnfermedades();
			if (!fin()) {
				infectar();
			}
			updateEnfermedades();

		}
	}

	//////////////////////////////////////////////////////////////////////////////////////
	// -ronda
	//
	/////////////////////////////////////////////////////////////////////////////////////
	/*public static void ronda() {
		Scanner scn = new Scanner(System.in);
		int intput ;
		System.out.println("1 curar - 2 desarollar");
		intput=scn.nextInt();
		Jugador.acciones(intput);
		for (Ciudades ciudad : Partida.ciudades) {
			System.out.print(ciudad.nombre);
			System.out.print("| |");
			System.out.print(ciudad.idVirus);
			System.out.print("| |");

			System.out.print(ciudad.nEnfermedades);
			System.out.print("| |");

			System.out.print(ciudad.brote);
			System.out.print("|---|");

		}
		System.out.println();
		System.out.println("----------------");

		for (Vacunas string : Partida.vacunas) {
			System.out.println(string.nombre);
			System.out.println(string.color);
			System.out.println(string.desarollo + "%");
			System.out.println("----------------");
		}
	}
*/
	//////////////////////////////////////////////////////////////////////////////////////
	// -infectar
	//
	/////////////////////////////////////////////////////////////////////////////////////
	public static void infectar() {
		for (Ciudades ciudad : Partida.ciudades) {
			ciudad.infectar();
		}
	}

	//////////////////////////////////////////////////////////////////////////////////////
	// -fin
	// determina si la partida a acabado por victoria o derrota
	/////////////////////////////////////////////////////////////////////////////////////
	public static boolean fin() {

		boolean aux = false;
		// si se llega al numero de brotes necesrio para perder
		if (Partida.brotes >= Parametros.brotesTotal) {
			return true;
			// si se llega al numero de enfermedades necesrio para perder
		} else if (Partida.enfermedades >= Parametros.enfermedadesTotal) {
			return true;
			// si todas las ciudades han sidio limpiadas
		} else if (Ciudades.nEnfermedadesPartida() == 0) {
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

	public static void enfermedades(int enfermedades) {
		Partida.enfermedades = enfermedades;
	}

}
