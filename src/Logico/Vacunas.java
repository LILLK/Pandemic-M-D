//Mehdi Tahrat && David hola
package Logico;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Pandemic.JF_PanelPartidaPanel2;

/**
 * Esta classe se encarga de crear los objeto vacuna.
 * @author DAME
 */
public class Vacunas {
	/**
	 * nombre de la vacuna
	 */
	public String nombre;
	/**
	 * color de la vacuna
	 */
	public String color;
	/**
	 * desarollo de la vacuna
	 */
	public int desarollo;

/**
 * Este constructor genera las vacunas desde los archivos locales 
 * @param  idVirus - int  - id de vacuna
 */
	public Vacunas(int idVirus) {
		ArrayList<String> datos = new ArrayList<>();
		ArchivosIO.leerCCP(datos, null, false);
		// datos = "id nombre color"
		this.nombre = datos.get(idVirus).split(" ")[1];
		this.color = datos.get(idVirus).split(" ")[2];
		this.desarollo = 0;
	}
	/**
	 * Este constructor genera las vacunas desde la BD
	 * @param  idVirus - int  - id de vacuna
	 * @param desarrollo - int - dessarollo de la vacuna
	 * @param color - String - color de la vacuna 
	 */
	public Vacunas(int idVirus,int desarrollo,String color) {
		ArrayList<String> datos = new ArrayList<>();
		ArchivosIO.leerCCP(datos, null, false);
		// datos = "id nombre color"
		this.nombre = datos.get(idVirus).split(" ")[1];
		this.color = color;
		this.desarollo = desarrollo;
	}

/**
 * Esta funcion crea las vacunas y las anyade a la lista 
 */
	public static void generarVacunas() {
		for (int i = 0; i < 4 ; i++) {
			Vacunas vacuna = new Vacunas(i);
			Partida.vacunas.add(vacuna);
		}
	}
/**
 * Esta funcion recorre todas las vacunas y devuelve verdaero si todas estan all 100% de desarollo
 * @return boolean
 */
	public static boolean vacunasDescubiertas() {
		boolean aux = true;
		for (Vacunas vacuna : Partida.vacunas) {
			if (vacuna.desarollo < 100)
				aux = false;
		}
		return aux;
	}
/**
 * Esta funcion desarolla la vacuna un 10% mas si se puede desarollar.
 * @param  id - int - id de vacuna a desarollar
 */
	public static void desarollar(int id) {
		
		if(Partida.vacunas.get(id).desarollo >=100) {

			JOptionPane.showMessageDialog(new JFrame(), "Ya esta desarollado al tope!!!");
		}else {
			JF_PanelPartidaPanel2.updateLog("------------");
			Partida.vacunas.get(id).desarollo += Parametros.porcentajeCura;
			JF_PanelPartidaPanel2.updateLog("Se ha desarollado un "+Parametros.porcentajeCura+"% la vacuna: "+Partida.vacunas.get(id).color);
			JF_PanelPartidaPanel2.restarAcciones();	
			Partida.Puntuacion+=200;
			if (Partida.vacunas.get(id).desarollo >=100) {
				Partida.Puntuacion+=2000;
			}
			JF_PanelPartidaPanel2.updateLog("------------");
		}
	}

}
