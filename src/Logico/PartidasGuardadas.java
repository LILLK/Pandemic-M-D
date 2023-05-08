package Logico;

public class PartidasGuardadas {
	public int idPartida;
	public int brotes;
	public int ronda;
	public int puntuacion;
	public int dificultadPartida;
	
	public PartidasGuardadas(int idP,int brotes, int ronda,  int puntuacion, int dificultad) {
		this.idPartida = idP;
		this.brotes = brotes;
		this.ronda = ronda;
		this.puntuacion = puntuacion;
		this.dificultadPartida = dificultad;
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
		return dificultadPartida;
	}
	public void setDificultad(int dificultad) {
		this.dificultadPartida = dificultad;
	}

}
