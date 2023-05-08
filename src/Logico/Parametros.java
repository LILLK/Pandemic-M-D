package Logico;
import java.util.ArrayList;
import java.util.Scanner;

public class Parametros {

	// determina la cantidad de brotes necesarios para perder
	public static int brotesTotal;
	// determina cuantas ciudades se infectan en una ronda
	public static int infeccionRonda;
	// determina el porcentaje que se aumenta para obtener la cura
	public static int porcentajeCura;
	// determina el numero de brotes al empezar la partida Inicio
	static int brotesInicio;



	////////////////////////////////////
	/////////// constructores //////////
	////////////////////////////////////
	public Parametros() {

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

	/////////////////////////////////////////////////////////////////////
	// - cambiarParametros
	// Permite cambiar los parametros desde la consola
	///////////////////////////////////////////////////////////////////////
	public static void cambiarParametrosSyso() {
		int brotesTotal, infeccionRonda, porcentajeCura, brotesInicio;
		Scanner teclado = new Scanner(System.in);
		System.out.println("Cambiar brotes totales:");
		brotesTotal = teclado.nextInt();
		System.out.println("Cambiar infecciones por ronda:");
		infeccionRonda = teclado.nextInt();
		System.out.println("Cambiar porcentaje cura:");
		porcentajeCura = teclado.nextInt();
		System.out.println("Cambiar brotes inicio:");
		brotesInicio = teclado.nextInt();
		teclado.close();
		//guarda los nuevos datos en el archivo 
		ArchivosIO.escribirParametros(brotesTotal, infeccionRonda, porcentajeCura, brotesInicio);
		// y en el programa
		establecerParametros(0);
	}
	/////////////////////////////////////////////////////////////////////
	// - establecerParametros
	// Da valor a las variables usando los datos de Parametros.xml
	///////////////////////////////////////////////////////////////////////
	public static void establecerParametros(int dificultad) {
		//extraer los datos a una lista 
		ArrayList<Integer> parametros = ArchivosIO.leerParametros();
		Parametros.brotesTotal = parametros.get(0) - dificultad; 
		Parametros.infeccionRonda = parametros.get(1) + dificultad ;
		Parametros.porcentajeCura = parametros.get(2) ;
		Parametros.brotesInicio = parametros.get(3) + dificultad;
	}

	////////////////////////////////////
	/////////// setters&getters//////////
	////////////////////////////////////
	public int getBrotesTotal() {
		return brotesTotal;
	}

	public void setBrotesTotal(int brotesTotal) {
		Parametros.brotesTotal = brotesTotal;
	}

	public int getInfeccionRonda() {
		return infeccionRonda;
	}

	public void setInfeccionRonda(int infeccionRonda) {
		Parametros.infeccionRonda = infeccionRonda;
	}

	public int getPorcentajeCura() {
		return porcentajeCura;
	}

	public void setPorcentajeCura(int porcentajeCura) {
		Parametros.porcentajeCura = porcentajeCura;
	}

	public static int getbrotesInicio() {
		return brotesInicio;
	}

	public static void setbrotesInicio(int brotesInicio) {
		Parametros.brotesInicio = brotesInicio;
	}

}
