//Mehdi Tahrat && David hola
package Logico;
/**
 * Esta classe crea el aloja este objeto, que sirve para cargar los datos del ranking
 * @author DAME
 */
public class Rankings {
	/**
	 * Numero de brotes de la partida
	 */
	public int brotes;
	/**
	 * numero de rondas de la partida
	 */
	public int ronda;
	/**
	 * puntuacion de la partida
	 */
	public int puntuacion;
	/**
	 * nivel de dificultad de la partida
	 */
	public int dificultad;
	/**
	 * Nombre del usuario
	 */
	public String nomb_us;
	
	/**
	 * Crea el objeto {@link Rankings}
	 * @param brotes - int 
	 * @param ronda - int 
	 * @param puntuacion - int 
	 * @param dificultad - int 
	 * @param nomb_us - int 
	 */
	public Rankings(int brotes, int ronda,  int puntuacion, int dificultad,String nomb_us) {
		this.brotes = brotes;
		this.ronda = ronda;
		this.puntuacion = puntuacion;
		this.dificultad = dificultad;
		this.nomb_us = nomb_us;
	}
}
