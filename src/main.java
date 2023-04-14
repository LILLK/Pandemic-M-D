import java.util.ArrayList;

//Mehdi Tahrat&&David Hola

public class main {


	public static void main(String[] args) {
		ArrayList<Integer> parametros = ArchivosIO.leerParametros();
		System.out.println("lista de parametros antes: ");
		System.out.println(parametros);
		System.out.println("\n-Cambiar parametros-");		
		Parametros.cambiarParametrosSyso();
		parametros.clear();
		parametros.addAll(ArchivosIO.leerParametros());
		System.out.println("\nlista de parametros Despues: ");
		System.out.println(parametros);
		System.out.println("\nParametros: ");
		System.out.println("Parametros.brotesTotal: "+Parametros.brotesTotal);
		System.out.println("Parametros.infeccionRonda: "+Parametros.infeccionRonda);
		System.out.println("Parametros.porcentajeCura: "+Parametros.porcentajeCura);
		System.out.println("Parametros.brotesInicio: "+ Parametros.brotesInicio);
		System.out.println("Parametros.nEnfermedades: "+ Parametros.nEnfermedades);

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