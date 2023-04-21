package Pandemic;
import java.util.ArrayList;

//Mehdi Tahrat && David hola


public class Ciudades {
	String nombre;
	boolean infectado;
	int[] posicion = new int [2];
	int idVirus;
	int nBrotes;
	ArrayList<String> colindantes;

	////////////////////////////////////
	/////////// constructores //////////
	////////////////////////////////////
	public Ciudades(String nombre, boolean infectado, int[] posicion, int idVirus) {
		this.nombre = nombre;
		this.infectado = infectado;
		this.posicion = posicion;
		this.idVirus = idVirus;
		this.nBrotes = 0;
		colindantes = new ArrayList<String>();
	}
	////////////////////////////////////
	////////////// metodos /////////////
	////////////////////////////////////

	public  void infectar() {
		this.nBrotes++;
	}
	/////////////////////////////////////
	///////////// Funciones ////////////
	////////////////////////////////////
	/*
	 * 
	 */
	////////////////////////////////////
	/////////// setters&getters//////////
	////////////////////////////////////

	
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public boolean isInfectado() {
		return infectado;
	}
	
	public void setInfectado(boolean infectado) {
		this.infectado = infectado;
	}
	
	public int[] getPosicion() {
		return posicion;
	}
	
	public void setPosicion(int[] posicion) {
		this.posicion = posicion;
	}
	
	public int getIdVirus() {
		return idVirus;
	}
	
	public void setIdVirus(int idVirus) {
		this.idVirus = idVirus;
	}
	
	public int getnBrotes() {
		return nBrotes;
	}
	
	public void setnBrotes(int nBrotes) {
		this.nBrotes = nBrotes;
	}
}
