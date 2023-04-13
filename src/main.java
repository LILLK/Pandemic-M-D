import java.util.ArrayList;

//Mehdi Tahrat&&David Hola

public class main {


	public static void main(String[] args) {
		// parametros {brotesTotal, infeccionRonda , porcentajeCura, acciones}
		ArrayList<Integer> parametros = ArchivosIO.leerParametros();
		System.out.println(parametros);
		Parametros.cambiarParametros();
		parametros.clear();
		parametros.addAll(ArchivosIO.leerParametros());
		System.out.println(parametros);
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