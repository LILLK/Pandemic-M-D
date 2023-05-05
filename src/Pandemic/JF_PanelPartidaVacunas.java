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

public class JF_PanelPartidaVacunas extends JPanel {

	
	BotonCiudad BotonCiudad;
	BotonVacunaVerde botonVacunaVerde;
	BotonVacunaRojo botonVacunaRojo;
	BotonVacunaAzul botonVacunaAzul;
	BotonVacunaAmarillo botonVacunaAmarillo;
	Dimension screenSize;
	
	
	

	public JF_PanelPartidaVacunas() {
		
		
		
		int tamañoX = 40;
		int tamañoY = 40;

		cambiarImg img = new cambiarImg();

		Color color =new Color(71, 161, 197);
		Border borde = BorderFactory.createLineBorder(Color.BLACK,3);
		screenSize = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
		setLayout(null);
		this.setBounds(1,
				(850),
				(1550),
				(this.screenSize.height-850-23));
		this.setBorder(borde);
		this.setBackground(color);
		
		
		
		JLabel barraVacunaAzul = new  JLabel();
		barraVacunaAzul.setIcon(img.tamaño(new ImageIcon("botones/barras_vacunas_0_azul.png"), (this.getWidth()/10)*2, tamañoY));
		barraVacunaAzul.setBounds((this.getWidth()/10),
				((this.getHeight()/5)),
				((this.getWidth()/10)*2),
				(tamañoY));
		barraVacunaAzul.setOpaque(false);
		this.add(barraVacunaAzul);
		
		
		JLabel barraVacunaRojo = new  JLabel();
		barraVacunaRojo.setIcon(img.tamaño(new ImageIcon("botones/barras_vacunas_0_rojo.png"), (this.getWidth()/10)*2, tamañoY));
		barraVacunaRojo.setBounds((this.getWidth()/10),
				((this.getHeight()/5)*3),
				((this.getWidth()/10)*2),
				(tamañoY));
		barraVacunaRojo.setOpaque(false);
		this.add(barraVacunaRojo);
		
		
		JLabel barraVacunaVerde = new  JLabel();
		barraVacunaVerde.setIcon(img.tamaño(new ImageIcon("botones/barras_vacunas_0_verde.png"), (this.getWidth()/10)*2, tamañoY));
		barraVacunaVerde.setBounds((this.getWidth()/10*7),
				((this.getHeight()/5)*3),
				((this.getWidth()/10)*2),
				(tamañoY));
		barraVacunaVerde.setOpaque(false);
		this.add(barraVacunaVerde);
		
		

		JLabel barraVacunaAmarillo = new  JLabel();
		barraVacunaAmarillo.setIcon(img.tamaño(new ImageIcon("botones/barras_vacunas_0_amarillo.png"), (this.getWidth()/10)*2, tamañoY));
		barraVacunaAmarillo.setBounds((this.getWidth()/10*7),
				((this.getHeight()/5)),
				((this.getWidth()/10)*2),
				(tamañoY));
		barraVacunaAmarillo.setOpaque(false);
		this.add(barraVacunaAmarillo);
		
		
		botonVacunaAzul = new  BotonVacunaAzul(this);
		botonVacunaAzul.setBounds((this.getWidth()/10*3+10),
				((this.getHeight()/5)),
				(tamañoX),
				(tamañoY));
		this.add(botonVacunaAzul);
		
		
		botonVacunaRojo = new  BotonVacunaRojo(this);
		botonVacunaRojo.setBounds((this.getWidth()/10*3+10),
				((this.getHeight()/5)*3),
				(tamañoX),
				(tamañoY));
		this.add(botonVacunaRojo);
		
		
		
		
		botonVacunaVerde = new BotonVacunaVerde(this);
		botonVacunaVerde.setBounds((this.getWidth()/10*7 - 10-tamañoX),
				((this.getHeight()/5)*3),
				(tamañoX),
				(tamañoY));
		this.add(botonVacunaVerde);
		
		

		botonVacunaAmarillo = new  BotonVacunaAmarillo(this);
		botonVacunaAmarillo.setBounds((this.getWidth()/10*7 - 10-tamañoX),
				((this.getHeight()/5)),
				(tamañoX),
				(tamañoY));
		this.add(botonVacunaAmarillo);
		
		
		
		
	
		
		
		
		
	}
	

	

}
