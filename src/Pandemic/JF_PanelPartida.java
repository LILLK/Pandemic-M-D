package Pandemic;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;

import Botones.*;
import Logico.Ciudades;
import Logico.Partida;

public class JF_PanelPartida extends JPanel {

	BotonCiudad BotonCiudad;
	Dimension screenSize;
	//Label debajo del mapa
	JF_PanelPartidaVacunas panelVacunas;
	//Label derecha arriba
	JF_PanelPartidaPanel1 panelLabel1 ;
	//Label derecha abajo
	JF_PanelPartidaPanel2 panelLabel2 ;

	public JF_PanelPartida() {

		cambiarImg img = new cambiarImg();

		Color color = new Color(71, 161, 197);
		Border borde = BorderFactory.createLineBorder(Color.BLACK, 3);
		screenSize = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
		setLayout(null);

		// labels//
		JLabel mapa = new JLabel();
		panelLabel1 = new JF_PanelPartidaPanel1();
		panelVacunas = new JF_PanelPartidaVacunas();
		panelLabel2 = new JF_PanelPartidaPanel2();
		
		mapa.setIcon(img.tamaño(new ImageIcon("imagenes/mapa_2.png"), 1550, 850));
		mapa.setBounds(1, 1, 1550, 850);
		
		
		
		establecerBotonesCiudades();
		for (Ciudades ciudad : Partida.ciudades) {
			add(ciudad.boton.JLNombreCiudad);
		}
		for (Ciudades ciudad : Partida.ciudades) {
			add(ciudad.boton);
		}
		add(panelLabel2);
		add(panelVacunas);
		add(panelLabel1);
		add(mapa);


	}



	public void paint(Graphics g) {
		BufferedImage imgFondo;
		try {
			Dimension size = getSize();
			imgFondo = ImageIO.read(new File("imagenes/white.png"));
			g.drawImage(imgFondo, 0, 0, size.width, size.height, null);
			setOpaque(false);
			super.paint(g);
		} catch (IOException e) {
			System.out.print("Error IMGfondo JF_PanelInicio");
		}

	}

	public void irPanelRegistrarse() {
		JFrame marcoP = (JFrame) SwingUtilities.getWindowAncestor(this);
		marcoP.remove(this);
		marcoP.add(new JF_PanelRegistrarse());
		marcoP.setVisible(true);
	}

	public void irMenu() {
		JFrame marcoP = (JFrame) SwingUtilities.getWindowAncestor(this);
		marcoP.remove(this);
		marcoP.add(new JF_PanelMenu());
		marcoP.setVisible(true);
	}

	/////////////////////////////////////////////////////////////////////////
	/// -establecerBotonesCiudades
	/// Coloca las ciudades en su lugar
	////////////////////////////////////////////////////////////////////////
	public static void establecerBotonesCiudades() {
		int tamañoX = 30;
		int tamañoY = 20;
		for (Ciudades ciudad : Partida.ciudades) {
			ciudad.boton.setBounds(ciudad.posicionX - (tamañoX / 2), ciudad.posicionY - (tamañoY / 2), tamañoX,
					tamañoY);
			ciudad.boton.setVisible(true);
			ciudad.boton.setOpaque(false);
			ciudad.boton.JLNombreCiudad.setBounds(ciudad.posicionX - (50), ciudad.posicionY + (20), 100, 20);
			
		}
	}

}
