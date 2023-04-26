package Logico;
import java.util.Scanner;

//Mehdi Tahrat && David hola

public class Jugador {

<<<<<<< HEAD:src/Logico/Jugador.java
	
=======
	public static int id;
>>>>>>> 830fb87339dc66b19f64715bbc5e5b547dc64b93:src/Jugador.java
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
	// -
	//
	////////////////////////////////////
	public static void acciones(int tipoAcccion  ) {

		switch (tipoAcccion) {
		case 1:
			System.out.println("curar");
				curar();
			break;
		case 2:
			System.out.println("desarollar");
			desarollar();
			break;
		}
	}

////////////////////////////////////
// -curar
// resta 1 enefrmedad a la ciudad elejida
////////////////////////////////////
	public static void curar() {
		Scanner scn = new Scanner(System.in);
		String ciudad = null;
		int id;
		do {
			System.out.println("ciudad a curar: ");
			ciudad = scn.nextLine();
			// recogemos el id de la ciudad a currar
			id = Ciudades.getIdXnombre(ciudad);
			// si tenen 0 o menos enfermedades no se podra curar
			if (Partida.ciudades.get(id).nEnfermedades <= 0) {
				System.out.println("no se puede curar esta ciudad ");
			}
		} while (Partida.ciudades.get(id).nEnfermedades <= 0);
		//si el id de virus de la ciudad que queremos,  hemos desarollado su vacuna 
		if (Partida.vacunas.get(Partida.ciudades.get(id).idVirus).desarollo >= 100)
			// curar ciudad elejida 
			Partida.ciudades.get(id).nEnfermedades = 0;
		else
			//sino se restara una enfermedad
			Partida.ciudades.get(id).nEnfermedades -= 1;
		// si teiene estado de brote se quita
		if (Partida.ciudades.get(id).brote)
			Partida.ciudades.get(id).setBrote(false);
		// scn.close();
	}

	////////////////////////////////////
	// -desarollar
	// aumenta el desarollo de la cura
	////////////////////////////////////
	public static void desarollar() {
		Scanner scn = new Scanner(System.in);
		int id;
		do {
			System.out.println("vacuna a desarollar (0-3): ");
			id = scn.nextInt();
			if (Partida.vacunas.get(id).desarollo >= 100) {
				System.out.println("ya a sido desarollada ");
			}
		} while (Partida.vacunas.get(id).desarollo >= 100);

		Partida.vacunas.get(id).desarollo += Parametros.porcentajeCura;
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
