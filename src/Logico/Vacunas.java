package Logico;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Pandemic.JF_PanelPartidaPanel2;

//Mehdi Tahrat && David hola

public class Vacunas {

	public String nombre;
	public String color;
	public int desarollo;

	////////////////////////////////////
	/////////// constructores //////////
	////////////////////////////////////
	public Vacunas(int idVirus) {
		ArrayList<String> datos = new ArrayList<>();
		ArchivosIO.leerCCP(datos, null, false);
		// datos = "id nombre color"
		this.nombre = datos.get(idVirus).split(" ")[1];
		this.color = datos.get(idVirus).split(" ")[2];
		this.desarollo = 0;
	}
	public Vacunas(int idVirus,int desarrollo,String color) {
		ArrayList<String> datos = new ArrayList<>();
		ArchivosIO.leerCCP(datos, null, false);
		// datos = "id nombre color"
		this.nombre = datos.get(idVirus).split(" ")[1];
		this.color = color;
		this.desarollo = desarrollo;
	}

	////////////////////////////////////
	////////////// metodos /////////////
	////////////////////////////////////

	/*
	* 
	*/
	/////////////////////////////////////
	///////////// Funciones ////////////
	////////////////////////////////////

	//////////////////////////////////////////////////////////////////////////////////////
	// -vacunasDescubiertas
	// recorre todas las vacunas y devuelve verdaero si todas estan all 100% de
	////////////////////////////////////////////////////////////////////////////////////// desarollo
	/////////////////////////////////////////////////////////////////////////////////////
	public static boolean vacunasDescubiertas() {
		boolean aux = true;
		for (Vacunas vacuna : Partida.vacunas) {
			if (vacuna.desarollo < 100)
				aux = false;
		}
		return aux;
	}

	////////////////////////////////////
	// -desarollar
	// aumenta el desarollo de la cura
	////////////////////////////////////
	public static void desarollar(int id) {
		
		if(Partida.vacunas.get(id).desarollo >=100) {
			JF_PanelPartidaPanel2.updateLog(" ");

			JOptionPane.showMessageDialog(new JFrame(), "Ya esta desarollado al tope!!!");
		}else {
			Partida.vacunas.get(id).desarollo += Parametros.porcentajeCura;
			JF_PanelPartidaPanel2.updateLog("Se ha desarollado un "+Parametros.porcentajeCura+"% la vacuna: "+Partida.vacunas.get(id).color);
			JF_PanelPartidaPanel2.restarAcciones();	
			Partida.Puntuacion+=200;
			if (Partida.vacunas.get(id).desarollo >=100) {
				Partida.Puntuacion+=2000;
			}
		}
		JF_PanelPartidaPanel2.updateLog(" ");
	}
	////////////////////////////////////
	/////////// setters&getters//////////
	////////////////////////////////////

}
