//Mehdi Tahrat && David hola
package Pandemic;

import java.util.ArrayList;

import javax.swing.*;
import Botones.*;
import Logico.Ciudades;
import Logico.ConexionBD;
import Logico.Partida;
/**
 * Esta es la classe del panel que se encarga de gestionar la partida
 * @author DAME
 *
 */
public class JF_PanelPartida extends JPanel {

	public static ArrayList<BotonCiudad> botonesCiudad;
	public BotonMostrarNombres btnNombres;

	/**
	 * Label debajo del mapa
	 */
	JF_PanelPartidaVacunas panelVacunas;
	/**
	 * Label derecha arriba
	 */
	JF_PanelPartidaPanel1 panel1 ;
	/**
	 * Label derecha abajo
	 */
	JF_PanelPartidaPanel2 panel2 ;
	
	/**
	 * Este es constructor del panel partida.
	 * Contiene otros 3 paneles que se encargar de divir la informacion de la partida y gestionar las vacunas
	 */
	public JF_PanelPartida() {
		cambiarImg img = new cambiarImg();
		setLayout(null);
		JF_PanelPartida.botonesCiudad = genrarBotonesCiudad();


		// labels//
		JLabel mapa = new JLabel();
		BotonAtras botonAtras = new BotonAtras(this);
		btnNombres = new BotonMostrarNombres();
		panel1 = new JF_PanelPartidaPanel1();
		panel2 = new JF_PanelPartidaPanel2();
		panelVacunas = new JF_PanelPartidaVacunas(this);
		
		mapa.setIcon(img.tamanyo(new ImageIcon("imagenes/mapa_2.png"), 1550, 850));
		mapa.setBounds(1, 1, 1550, 850);
		botonAtras.setIcon(img.tamanyo(new ImageIcon("botones/salir_partida.png"), 50, 50) );
		botonAtras.setBounds(1450, 50, 50, 50);
		botonAtras.setOpaque(false);
		
		for (BotonCiudad botonCiudad : botonesCiudad) {
			botonCiudad.JLNombreCiudad.setBounds(botonCiudad.ciudad.posicionX - (50), botonCiudad.ciudad.posicionY + (20), 100, 20);
			add(botonCiudad.JLNombreCiudad);	
		}
		
		for (BotonCiudad botonCiudad : botonesCiudad) {
			botonCiudad.setBounds(botonCiudad.ciudad.posicionX - (botonCiudad.tamanyoX / 2), botonCiudad.ciudad.posicionY - (botonCiudad.tamanyoY / 2), botonCiudad.tamanyoX,botonCiudad.tamanyoY);
			add(botonCiudad);	
		}
		add(botonAtras);
		add(btnNombres);
		add(panel1);
		add(panel2);
		add(panelVacunas);
		add(mapa);
		


	}

	/**
	 * Este metodo devuelve una lista con todos los botones de ciudad generados
	 * @return ArrayList<BotonCiudad>
	 */
	public ArrayList<BotonCiudad> genrarBotonesCiudad() {
		ArrayList<BotonCiudad> array = new ArrayList<>();
		for (Ciudades ciudad : Partida.ciudades) {
			BotonCiudad btn = new BotonCiudad( this , ciudad);
			array.add(btn);
		}
		return array;
	}
	/**
	 * Este metodo cambia el panel {@link JF_PanelPartida } por el panel {@link JF_PanelMenu} y guarda el estado de la partida
	 */
	public void irMenu() {
		JFrame marcoP = (JFrame)SwingUtilities.getWindowAncestor(this);	
		marcoP.remove(this);
		marcoP.add(new JF_PanelMenu());
		marcoP.setVisible(true);
		ConexionBD.guardarPartida(false);
	}
	/**
	 * Esta funcion acaba la partida dependiendo del estado de esta, y muestra e mensaje final.
	 * @param int estado
	 */
	public void acabarParida(int estado) {
		JFrame marcoP = (JFrame)SwingUtilities.getWindowAncestor(this);	
		marcoP.remove(this);
		switch (estado) {
			case 1:
				JOptionPane.showMessageDialog(new JFrame(), "Victoria!"+"\n Puntuacion :"+Partida.Puntuacion+"\n Rondas :"+Partida.ronda);
				marcoP.add(new JF_PanelMenu());
				break;
			case 2:
				JOptionPane.showMessageDialog(new JFrame(), "Derota!"+"\n Puntuacion :"+Partida.Puntuacion+"\n Rondas :"+Partida.ronda);
				marcoP.add(new JF_PanelMenu());
				break;
		}
		marcoP.setVisible(true);
	}
}
