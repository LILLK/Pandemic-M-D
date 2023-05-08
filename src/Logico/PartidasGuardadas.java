package Logico;

public class PartidasGuardadas {
	public int idP;
	public int brotes;
	public int ronda;
	public int puntuacion;
	public int dificultad;
	public String nomb_us;
	
	public PartidasGuardadas(int idP,int brotes, int ronda,  int puntuacion, int dificultad,String nomb_us) {
		this.brotes = idP;
		this.brotes = brotes;
		this.ronda = ronda;
		this.puntuacion = puntuacion;
		this.dificultad = dificultad;
		this.nomb_us = nomb_us;
	}
	public int getBrotes() {
		return brotes;
	}
	public void setBrotes(int brotes) {
		this.brotes = brotes;
	}
	public int getRonda() {
		return ronda;
	}
	public void setRonda(int ronda) {
		this.ronda = ronda;
	}	
	public int getPuntuacion() {
		return puntuacion;
	}
	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}	
	public int getDificultad() {
		return dificultad;
	}
	public void setDificultad(int dificultad) {
		this.dificultad = dificultad;
	}
	public String getNombreU() {
		return nomb_us;
	}
	public void setNombreU(String nomb_us) {
		this.nomb_us = nomb_us;
	}
}
