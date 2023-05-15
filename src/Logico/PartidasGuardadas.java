package Logico;
/**
 * Esta classe crea el aloja este objeto, que sirve para cargar los datos de la partida 
* @author DAME
 *
 */
public class PartidasGuardadas {
	/**
	 * Id de partida 
	 */
	public int idPartida;
	/**
	 * Brotes de la partida
	 */
	public int brotes;
	/**
	 * Ronda de la partida
	 */
	public int ronda;
	/**
	 * Puntuacion de la partida
	 */
	public int puntuacion;
	/**
	 * Dificultad de la partida
	 */
	public int dificultadPartida;
	/**
	 * numero de acciones en la partida
	 */
	public int acciones;
	/**
	 * Constructror del objeto {@link PartidasGuardadas}
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
