package Logico;
/**
 * Esta classe crea el aloja este objeto, que sirve para cargar los datos de la partida 
 * @author DAME
 * 	+ int idPartida
*	+ int brotes
*	+ int ronda
*	+ int puntuacion
*	+ int dificultadPartida
*	+ int acciones
 *
 */
public class PartidasGuardadas {
	public int idPartida;
	public int brotes;
	public int ronda;
	public int puntuacion;
	public int dificultadPartida;
	public int acciones;
	/**
	 * Constructror del objeto {@linkPartidasGuardadas}
	 * @param int idP
	 * @param int brotes
	 * @param int ronda
	 * @param int puntuacion
	 * @param int dificultad
	 * @param int acciones
	 */
	public PartidasGuardadas(int idP,int brotes, int ronda,  int puntuacion, int dificultad,int acciones) {
		this.idPartida = idP;
		this.brotes = brotes;
		this.ronda = ronda;
		this.puntuacion = puntuacion;
		this.dificultadPartida = dificultad;
		this.acciones = acciones;
	}
}
