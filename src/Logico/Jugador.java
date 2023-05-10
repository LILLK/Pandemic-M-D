package Logico;
import java.util.Scanner;

//Mehdi Tahrat && David hola

public class Jugador {

	public static int id;
	public static String usuario;
	public static boolean logged;

	////////////////////////////////////
	/////////// constructores //////////
	////////////////////////////////////
	public Jugador() {

	}

	////////////////////////////////////
	////////////// metodos /////////////
	////////////////////////////////////

	/*
	 * 
	 */
	/////////////////////////////////////
	///////////// Funciones ////////////
	////////////////////////////////////





	

	////////////////////////////////////
	/////////// setters&getters//////////
	////////////////////////////////////

	public static String getNombre() {
		return usuario;
	}

	public static void setNombre(String nombre) {
		Jugador.usuario = nombre;
	}

	public static boolean isLogged() {
		return logged;
	}

	public static void setLogged(boolean logged) {
		Jugador.logged = logged;
	}

}
