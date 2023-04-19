import java.util.Scanner;

//Mehdi Tahrat && David hola

public class Jugador {

	static String usuario;
	static boolean logged;

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
	//-
	//
	////////////////////////////////////
	public static void acciones(int a) {
		Scanner scn = Scanner(System.in);
		String ciudad = null;
		String vacuna;
		int id;
		switch (a) {
		case 1:
			System.out.println("curar");
			System.out.println("ciudad a curar: ");
			ciudad  = scn.nextLine();
			 id = Ciudades.getIdXnombre(ciudad);
			Partida.ciudades.get(id).nEnfermedades = - 1 ;
			break;
		case 2:
			System.out.println("desarollar");
			System.out.println("vacuna a curar: ");
			
			break;
		}
	}
	
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
