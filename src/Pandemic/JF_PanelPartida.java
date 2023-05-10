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

	public static ArrayList<BotonCiudad> botonesCiudad;
	Dimension screenSize;
	//Label debajo del mapa
	JF_PanelPartidaVacunas panelVacunas;
	//Label derecha arriba
	JF_PanelPartidaPanel1 panel1 ;
	//Label derecha abajo
	JF_PanelPartidaPanel2 panel2 ;

	public JF_PanelPartida() {
		int tamañoX = 30;
		int tamañoY = 20;
		cambiarImg img = new cambiarImg();
		screenSize = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
		setLayout(null);
		JF_PanelPartida.botonesCiudad = genrarBotonesCiudad();


		// labels//
		JLabel mapa = new JLabel();
		panel1 = new JF_PanelPartidaPanel1();
		panel2 = new JF_PanelPartidaPanel2();
		panelVacunas = new JF_PanelPartidaVacunas(this);
		
		mapa.setIcon(img.tamaño(new ImageIcon("imagenes/mapa_2.png"), 1550, 850));
		mapa.setBounds(1, 1, 1550, 850);
		
		
		for (BotonCiudad botonCiudad : botonesCiudad) {
			botonCiudad.JLNombreCiudad.setBounds(botonCiudad.ciudad.posicionX - (50), botonCiudad.ciudad.posicionY + (20), 100, 20);
			add(botonCiudad.JLNombreCiudad);	
		}
		
		for (BotonCiudad botonCiudad : botonesCiudad) {
			botonCiudad.setBounds(botonCiudad.ciudad.posicionX - (tamañoX / 2), botonCiudad.ciudad.posicionY - (tamañoY / 2), tamañoX,tamañoY);
			add(botonCiudad);	
		}
		
		add(panel1);
		add(panel2);
		add(panelVacunas);
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
	
	public ArrayList<BotonCiudad> genrarBotonesCiudad() {
		ArrayList<BotonCiudad> array = new ArrayList<>();
		for (Ciudades ciudad : Partida.ciudades) {
			BotonCiudad btn = new BotonCiudad( this , ciudad);
			array.add(btn);
		}
		return array;
	}
	
	
	public void irMenu() {
		JFrame marcoP = (JFrame)SwingUtilities.getWindowAncestor(this);	
		marcoP.remove(this);
		marcoP.add(new JF_PanelMenu());
		marcoP.setVisible(true);
	}
}
