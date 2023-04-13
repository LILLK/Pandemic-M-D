import java.util.ArrayList;
import java.util.Scanner;

public class Parametros {

	//determina la cantidad de brotes necesarios para perder
	static int brotesTotal;
	//determina cuantas ciudades se infectan en una ronda
	static int infeccionRonda;
	//determina el porcentaje que se aumenta para obtener la cura
	static int porcentajeCura;
	//determina el numero de acciones que puede hacer el jugador 
	static int acciones;


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

	public static void cambiarParametros() {
		int brotesTotal,infeccionRonda,porcentajeCura,acciones;
		Scanner teclado = new Scanner(System.in);
		System.out.println("Cambiar brotesTotal");
		brotesTotal = teclado.nextInt();
		System.out.println("Cambiar infeccionRonda");
		infeccionRonda = teclado.nextInt();
		System.out.println("Cambiar porcentajeCura");
		porcentajeCura = teclado.nextInt();
		System.out.println("Cambiar acciones");
		acciones = teclado.nextInt();
		teclado.close();
		ArchivosIO.escribirParametros(brotesTotal, infeccionRonda, porcentajeCura,acciones);
		establecerParametros();
	}
	public static void establecerParametros() {
		ArrayList<Integer> parametros = ArchivosIO.leerParametros();
		Parametros.brotesTotal = parametros.get(0);
		Parametros.infeccionRonda =parametros.get(1);
		Parametros.porcentajeCura = parametros.get(2);
		Parametros.acciones = parametros.get(3);

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

	public static int getAcciones() {
		return acciones;
	}

	public static void setAcciones(int acciones) {
		Parametros.acciones = acciones;
	}
	

}
