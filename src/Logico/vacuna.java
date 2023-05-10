package Logico;

public class vacuna {
	String nomb_us; 
	int id;
	public vacuna(String nomb_us, int id) {
		this.nomb_us = nomb_us;
		this.id = id;
	}
	public vacuna(Object object) {
		// TODO Apéndice de constructor generado automáticamente
	}
	public int getBrotes() {
		return id;
	}
	public void setBrotes(int brotes) {
		this.id = brotes;
	}

	public String getNombreU() {
		return nomb_us;
	}
	public void setNombreU(String nomb_us) {
		this.nomb_us = nomb_us;
	}
}
