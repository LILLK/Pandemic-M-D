package Logico;
import java.util.ArrayList;
/**
 * Esta classe establece los paramaetros en una partida
 * public static int brotesTotal -  determina la cantidad de brotes necesarios para perder
	public static int infeccionRonda - determina cuantas ciudades se infectan en una ronda
	public static int porcentajeCura - determina el porcentaje que se aumenta para obtener la cura
	static int brotesInicio - determina el numero de brotes al empezar la partida Inicio
 * @author Dame
 *
 */
public class Parametros {
	/**
	 *  determina la cantidad de brotes necesarios para perder
	 */
	public static int brotesTotal;
	/**
	 *  determina cuantas ciudades se infectan en una ronda
	 */
	public static int infeccionRonda;
	/**
	 *  determina el porcentaje que se aumenta para obtener la cura
	 */
	public static int porcentajeCura;
	/**
	 *  determina el numero de brotes al empezar la partida Inicio
	 */
	static int brotesInicio;

	/**
	 * Esta funcion establece los parametros en partida
	 * @param int dificultad
	 */
	public static void establecerParametros(int dificultad) {
		//extraer los datos a una lista 
		ArrayList<Integer> parametros = ArchivosIO.leerParametros();
		Parametros.brotesTotal = parametros.get(0) - dificultad; 
		Parametros.infeccionRonda = parametros.get(1) + dificultad ;
		Parametros.porcentajeCura = parametros.get(2) ;
		Parametros.brotesInicio = parametros.get(3) + dificultad;
	}

}
