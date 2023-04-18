import java.util.ArrayList;

//Mehdi Tahrat&&David Hola

public class main {


	public static void main(String[] args) {
		Vacunas vacunas = new Vacunas(0);
		Partida.brotes=0;
		Parametros.brotesInicio = 4;
		Partida.ciudades = new ArrayList<Ciudades>();
		Ciudades.generarCiudades();
		//System.out.println(Partida.ciudades);
		for (Ciudades ciudad : Partida.ciudades) {
			System.out.println("----------------");
			System.out.println(ciudad.nombre);
			System.out.println(ciudad.idVirus);
			System.out.println(ciudad.nEnfermedades);
			System.out.println("----------------");
		}
	
	}
	
	
	/////////////////////////////////////////////////////
	// - funcion iniciSension
	// Recive el jugador y establece su nombre
	/////////////////////////////////////////////////////
	public static void iniciSension() {

	}
	/////////////////////////////////////////////////////
	// - funcion menu
	// Direcciona el usuario por el menu
	/////////////////////////////////////////////////////
	public static void menu() {
		
	}
	/////////////////////////////////////////////////////
	// - funcion cerrarPrograma
	// Passos finales del usuario antes de cerrar el programa
	/////////////////////////////////////////////////////
	public static void cerrarPrograma() {

	}

}