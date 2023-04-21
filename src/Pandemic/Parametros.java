package Pandemic;
import java.util.Scanner;

public class Parametros {

	//determina la cantidad de brotes necesarios para perder
	static int brotesTotal;
	//determina cuantas ciudades se infectan en una ronda
	static int infeccionRonda;
	//determina el porcentaje que se aumenta para obtener la cura
	static int porcentajeCura;

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
	public static void editar() {
		Scanner teclado = new Scanner(System.in);
		System.out.println("brotesTotal");
		Parametros.brotesTotal = teclado.nextInt();
		System.out.println("infeccionRonda");
		Parametros.infeccionRonda = teclado.nextInt();
		System.out.println("porcentajeCura");
		Parametros.porcentajeCura = teclado.nextInt();
		teclado.close();
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

}
