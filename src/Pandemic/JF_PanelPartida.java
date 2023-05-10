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
	JF_PanelPartidaPanel1 panelLabel1 ;
	//Label derecha abajo
	JF_PanelPartidaPanel2 panelLabel2 ;

	public JF_PanelPartida() {
		int tamañoX = 30;
		int tamañoY = 20;
		cambiarImg img = new cambiarImg();
		screenSize = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
		setLayout(null);
		JF_PanelPartida.botonesCiudad = genrarBotonesCiudad();


		// labels//
		JLabel mapa = new JLabel();
		panelLabel1 = new JF_PanelPartidaPanel1();
		panelVacunas = new JF_PanelPartidaVacunas();
		panelLabel2 = new JF_PanelPartidaPanel2();
		
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
		
		add(panelLabel2);
		add(panelLabel1);
		add(panelVacunas);
		add(mapa);
		
		while(!Partida.fin()) {
			Partida.accionesRonda=4;
			while (Partida.accionesRonda!=0) {
				
			}
		}

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

}
