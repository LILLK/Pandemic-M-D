
//Mehdi Tahrat && David hola
package Logico;

import java.util.ArrayList;

import Pandemic.JF_PanelPartida;
import Pandemic.JF_PanelPartidaPanel1;
import Pandemic.JF_PanelPartidaPanel2;
import Pandemic.JF_PanelPartidaVacunas;
/**
 * Esta classe se encarga del apartado logico en una partida, entre otras cosas
 * @author DAME
 *
 */
public class Partida {
	/**
	 * id de la Partida
	 */
	public static int idP;
	/**
	 * id del jugador
	 */
	public static int idJ;
	/**
	 *  Puntuacion de la partida
	 */
	public static int Puntuacion;
	/**
	 *  Brotes de la partida
	 */
	public static int brotes;
	/**
	 *  Numero de rondas de la partida
	 */
	public static int ronda;
	/**
	 *  numero de acciones de la ronda 
	 */
	public static int accionesRonda;
	/**
	 *  Dificultad de la partida
	 */
	public static int dificultad;
	/**
	 *  Lista de todas las ciudades con sus atributos
	 */
	public static ArrayList<Ciudades> ciudades= new ArrayList<Ciudades>();
	/**
	 *  Lista de todas las Vacunas con sus atributos
	 */
	public static ArrayList<Vacunas> vacunas = new ArrayList<Vacunas>();;

	/**
	 * Esta funcion es donde se ejecuta el juego.
	 * Esta funcion es llamada al finalizar cada accion y actualiza el estado de toda la partida
	 * @param JF_PanelPartida 
	 */
	public static void jugarPartida(JF_PanelPartida pPartida) {
		if (Partida.accionesRonda<=0) {
			Partida.accionesRonda=4;
			Partida.ronda++;
			Partida.Puntuacion-=10;
			Partida.infectar();
		}
		update();
		if (Partida.fin()!=0) {
			pPartida.acabarParida(Partida.fin());
			ConexionBD.guardarPartida(true);
		}
	}

	/**
	 * Esta funcion infecta las ciudaes al final de la ronda.
	 */
	public static void infectar() {
		for (int i = 0; i < Parametros.infeccionRonda; i++) {
			int random = (int) (Math.random() * JF_PanelPartida.botonesCiudad.size());			
			JF_PanelPartida.botonesCiudad.get(random).ciudad.infectar();
		}
		Ciudades.setInfeccionRondaFalse();
		// esto impide que las ciudades se infecte la misma ciudad 2 veces en una ronda
	}
/**
 * Esta funcion crea una nueva partida.
 */
	public static void nuevaPartida() {
		// Incicializa las variables necesarias para empezar partida
		// empieza la partida
		iniciarNuevaPartida(0);
		ConexionBD.iniciarPartida();
		Partida.jugarPartida(null);
	}

	/**
	 * Esta funcion determina si la partida a acabado por victoria(return 1) o derrota(return 2).
	 * Si la partida sigue devuelve 0. 
	 * @return int
	 */
	public static int fin() {
		int aux = 0;
		//0 = sigue el juego, 1 = victoria , 2 = derrota 
		// si se llega al numero de brotes necesrio para perder
		if (Partida.brotes > Parametros.brotesTotal) {
			Partida.Puntuacion-=50000;
			return 2;
			// si todas las ciudades han sidio limpiadas
		}
		// si han sido todas las vacunas descubiertas
		else if (Vacunas.vacunasDescubiertas()) {
			Partida.Puntuacion+=50000;
			return 1;
		}
		return aux;
	}
/**
 * Esta funcion inicia las variables para una nueva partida
 * @param int dificultad
 */
	public static void iniciarNuevaPartida(int dificultad) {
		Partida.brotes = 0;
		Partida.Puntuacion = 0;
		Partida.ronda = 0;
		Partida.accionesRonda = 4;
		Parametros.establecerParametros(dificultad);
		Partida.vacunas = new ArrayList<Vacunas>();
		Partida.ciudades = new ArrayList<Ciudades>();
		Ciudades.generarCiudades();
		Vacunas.generarVacunas();
		ConexionBD.iniciarPartida();
		ConexionBD.idPartida();
	}
	/**
	 * Esta funcion actualiza los datos de la partida
	 */
	public static void update() {
		JF_PanelPartidaPanel2.updateAcciones();
		JF_PanelPartidaPanel1.updateBrotes();
		JF_PanelPartidaPanel1.updateRonda();
		JF_PanelPartidaPanel1.updatePuntuacion();
	}



}
