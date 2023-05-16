//Mehdi Tahrat && David hola
package Logico;
/**
 * Esta classe crea el aloja este objeto, que sirve para cargar los datos del ranking
 * @author DAME
 * 	+ int idPartida
*	+ int brotes
*	+ int ronda
*	+ int puntuacion
*	+ int dificultadPartida
*	+ int acciones
 */
public class Rankings {
	
	public int brotes;
	public int ronda;
	public int puntuacion;
	public int dificultad;
	public String nomb_us;
	
	/**
	 * Crea el objeto {@link Rankings}
	 * @param int brotes
	 * @param int ronda
	 * @param int puntuacion
	 * @param int dificultad
	 * @param int nomb_us
	 */
	public Rankings(int brotes, int ronda,  int puntuacion, int dificultad,String nomb_us) {
		this.brotes = brotes;
		this.ronda = ronda;
		this.puntuacion = puntuacion;
		this.dificultad = dificultad;
		this.nomb_us = nomb_us;
	}
}
