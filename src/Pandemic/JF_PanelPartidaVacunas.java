package Pandemic;

import java.awt.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import Botones.*;
import Logico.Partida;

public class JF_PanelPartidaVacunas extends JPanel {

	JLabel barraVacunaAzul;
	JLabel barraVacunaRojo;
	JLabel barraVacunaVerde;
	JLabel barraVacunaAmarillo;
	BotonCiudad BotonCiudad;
	BotonVacunaVerde botonVacunaVerde;
	BotonVacunaRojo botonVacunaRojo;
	BotonVacunaAzul botonVacunaAzul;
	BotonVacunaAmarillo botonVacunaAmarillo;

	cambiarImg img = new cambiarImg();

	public JF_PanelPartidaVacunas(JF_PanelPartida panel) {
		//tamaño de los componentes de este panel
		int tamañoX = 80;
		int tamañoY = 80;

		setLayout(null);
		this.setBounds(1, 850, 1550, (cambiarImg.screenSize.height - 850 - 23));

		barraVacunaAzul = new JLabel();
		barraVacunaRojo = new JLabel();
		barraVacunaVerde = new JLabel();
		barraVacunaAmarillo = new JLabel();
		botonVacunaAzul = new BotonVacunaAzul(this,panel );
		botonVacunaVerde = new BotonVacunaVerde(this,panel);
		botonVacunaRojo = new BotonVacunaRojo(this,panel);
		botonVacunaAmarillo = new BotonVacunaAmarillo(this, panel);

		updateBarraVacunaAzul();
		barraVacunaAzul.setBounds((this.getWidth() / 30), ((this.getHeight() / 5)), ((this.getWidth() / 5) * 2),(tamañoY));
		barraVacunaAzul.setOpaque(false);
		
		updateBarraVacunaRojo();
		barraVacunaRojo.setBounds((this.getWidth() / 30), ((this.getHeight() / 5) * 3), ((this.getWidth() / 5) * 2),(tamañoY));
		barraVacunaRojo.setOpaque(false);
		
		updateBarraVacunaVerde();
		barraVacunaVerde.setBounds((this.getWidth() / 20 * 11), ((this.getHeight() / 5) * 3),((this.getWidth() / 5) * 2), (tamañoY));
		barraVacunaVerde.setOpaque(false);
		
		updateBarraVacunaAmarillo();
		barraVacunaAmarillo.setBounds((this.getWidth() / 20 * 11), ((this.getHeight() / 5)),	((this.getWidth() / 5) * 2), (tamañoY));
		barraVacunaAmarillo.setOpaque(false);
		
		botonVacunaAzul.setBounds((this.getWidth() / 10 * 4 +50), ((this.getHeight() / 5)), (tamañoX), (tamañoY));
		botonVacunaRojo.setBounds((this.getWidth() / 10 * 4 +50), ((this.getHeight() / 5) * 3), (tamañoX), (tamañoY));
		botonVacunaVerde.setBounds((this.getWidth() / 10 * 4 + 70 + tamañoX), ((this.getHeight() / 5) * 3), (tamañoX),(tamañoY));
		botonVacunaAmarillo.setBounds((this.getWidth() / 10 * 4 + 70 + tamañoX), ((this.getHeight() / 5)), (tamañoX),(tamañoY));

		add(barraVacunaAzul);
		add(barraVacunaRojo);
		add(barraVacunaVerde);
		add(barraVacunaAmarillo);
		add(botonVacunaAzul);
		add(botonVacunaRojo);
		add(botonVacunaVerde);
		add(botonVacunaAmarillo);

	}

	public void paint(Graphics g) {
		BufferedImage imgFondo;
		try {
			Dimension size =getSize();
			imgFondo = ImageIO.read(new File("imagenes/fondo_3.png"));
			g.drawImage(imgFondo, 0, 0, size.width, size.height,null);
			setOpaque(false);
			super.paint(g);
		} catch (IOException e) {
			System.out.print("Error IMGfondo JF_PanelPartidaPanel1");
		}
	}
	
	
	///////////////////////////////////
	//-updateBarraVacuna"color"
	//Actualiza la imagen de las barras vacuna de cada color
	///////////////////////////////////
	public void updateBarraVacunaAzul() {
		int tamañoX = 40;
		int tamañoY = 80;
		switch (Partida.vacunas.get(0).desarollo/10) {
		case 0:
			barraVacunaAzul.setIcon(img.tamaño(new ImageIcon("botones/barras_vacunas_0_azul.png"), (this.getWidth() / 5) * 2, tamañoY));
			break;
		case 1:
			barraVacunaAzul.setIcon(img.tamaño(new ImageIcon("botones/barras_vacunas_1_azul.png"), (this.getWidth() / 5) * 2, tamañoY));	
			break;
		case 2:
			barraVacunaAzul.setIcon(img.tamaño(new ImageIcon("botones/barras_vacunas_2_azul.png"), (this.getWidth() / 5) * 2, tamañoY));
			break;
		case 3:
			barraVacunaAzul.setIcon(img.tamaño(new ImageIcon("botones/barras_vacunas_3_azul.png"), (this.getWidth() / 5) * 2, tamañoY));
			break;
		case 4:
			barraVacunaAzul.setIcon(img.tamaño(new ImageIcon("botones/barras_vacunas_4_azul.png"), (this.getWidth() / 5) * 2, tamañoY));
			break;
		case 5:
			barraVacunaAzul.setIcon(img.tamaño(new ImageIcon("botones/barras_vacunas_5_azul.png"), (this.getWidth() / 5) * 2, tamañoY));
			break;
		case 6:
			barraVacunaAzul.setIcon(img.tamaño(new ImageIcon("botones/barras_vacunas_6_azul.png"), (this.getWidth() / 5) * 2, tamañoY));
			break;
		case 7:
			barraVacunaAzul.setIcon(img.tamaño(new ImageIcon("botones/barras_vacunas_7_azul.png"), (this.getWidth() / 5) * 2, tamañoY));
			break;
		case 8:
			barraVacunaAzul.setIcon(img.tamaño(new ImageIcon("botones/barras_vacunas_8_azul.png"), (this.getWidth() / 5) * 2, tamañoY));
			break;
		case 9:
			barraVacunaAzul.setIcon(img.tamaño(new ImageIcon("botones/barras_vacunas_9_azul.png"), (this.getWidth() / 5) * 2, tamañoY));
			break;
		case 10:
			barraVacunaAzul.setIcon(img.tamaño(new ImageIcon("botones/barras_vacunas_10_azul.png"), (this.getWidth() / 5) * 2, tamañoY));
			break;
		}
	}
	public void updateBarraVacunaRojo() {
		int tamañoX = 40;
		int tamañoY = 80;
		switch (Partida.vacunas.get(1).desarollo/10) {
		case 0:
			barraVacunaRojo.setIcon(img.tamaño(new ImageIcon("botones/barras_vacunas_0_rojo.png"), (this.getWidth() / 5) * 2, tamañoY));
			break;
		case 1:
			barraVacunaRojo.setIcon(img.tamaño(new ImageIcon("botones/barras_vacunas_1_rojo.png"), (this.getWidth() / 5) * 2, tamañoY));
			break;
		case 2:
			barraVacunaRojo.setIcon(img.tamaño(new ImageIcon("botones/barras_vacunas_2_rojo.png"), (this.getWidth() / 5) * 2, tamañoY));
			break;
		case 3:
			barraVacunaRojo.setIcon(img.tamaño(new ImageIcon("botones/barras_vacunas_3_rojo.png"), (this.getWidth() / 5) * 2, tamañoY));
			break;
		case 4:
			barraVacunaRojo.setIcon(img.tamaño(new ImageIcon("botones/barras_vacunas_4_rojo.png"), (this.getWidth() / 5) * 2, tamañoY));
			break;
		case 5:
			barraVacunaRojo.setIcon(img.tamaño(new ImageIcon("botones/barras_vacunas_5_rojo.png"), (this.getWidth() / 5) * 2, tamañoY));
			break;
		case 6:
			barraVacunaRojo.setIcon(img.tamaño(new ImageIcon("botones/barras_vacunas_6_rojo.png"), (this.getWidth() / 5) * 2, tamañoY));
			break;
		case 7:
			barraVacunaRojo.setIcon(img.tamaño(new ImageIcon("botones/barras_vacunas_7_rojo.png"), (this.getWidth() / 5) * 2, tamañoY));
			break;
		case 8:
			barraVacunaRojo.setIcon(img.tamaño(new ImageIcon("botones/barras_vacunas_8_rojo.png"), (this.getWidth() / 5) * 2, tamañoY));
			break;
		case 9:
			barraVacunaRojo.setIcon(img.tamaño(new ImageIcon("botones/barras_vacunas_9_rojo.png"), (this.getWidth() / 5) * 2, tamañoY));
			break;
		case 10:
			barraVacunaRojo.setIcon(img.tamaño(new ImageIcon("botones/barras_vacunas_10_rojo.png"), (this.getWidth() / 5) * 2, tamañoY));
			break;
		}
	}
	public void updateBarraVacunaVerde() {
		int tamañoX = 40;
		int tamañoY = 80;
		switch (Partida.vacunas.get(2).desarollo/10) {
		case 0:
			barraVacunaVerde.setIcon(img.tamaño(new ImageIcon("botones/barras_vacunas_0_verde.png"), (this.getWidth() / 5) * 2, tamañoY));
			break;
		case 1:
			barraVacunaVerde.setIcon(img.tamaño(new ImageIcon("botones/barras_vacunas_1_verde.png"), (this.getWidth() / 5) * 2, tamañoY));
			break;
		case 2:
			barraVacunaVerde.setIcon(img.tamaño(new ImageIcon("botones/barras_vacunas_2_verde.png"), (this.getWidth() / 5) * 2, tamañoY));
			break;
		case 3:
			barraVacunaVerde.setIcon(img.tamaño(new ImageIcon("botones/barras_vacunas_3_verde.png"), (this.getWidth() / 5) * 2, tamañoY));
			break;
		case 4:
			barraVacunaVerde.setIcon(img.tamaño(new ImageIcon("botones/barras_vacunas_4_verde.png"), (this.getWidth() / 5) * 2, tamañoY));
			break;
		case 5:
			barraVacunaVerde.setIcon(img.tamaño(new ImageIcon("botones/barras_vacunas_5_verde.png"), (this.getWidth() / 5) * 2, tamañoY));
			break;
		case 6:
			barraVacunaVerde.setIcon(img.tamaño(new ImageIcon("botones/barras_vacunas_6_verde.png"), (this.getWidth() / 5) * 2, tamañoY));
			break;
		case 7:
			barraVacunaVerde.setIcon(img.tamaño(new ImageIcon("botones/barras_vacunas_7_verde.png"), (this.getWidth() / 5) * 2, tamañoY));
			break;
		case 8:
			barraVacunaVerde.setIcon(img.tamaño(new ImageIcon("botones/barras_vacunas_8_verde.png"), (this.getWidth() / 5) * 2, tamañoY));
			break;
		case 9:
			barraVacunaVerde.setIcon(img.tamaño(new ImageIcon("botones/barras_vacunas_9_verde.png"), (this.getWidth() / 5) * 2, tamañoY));
			break;
		case 10:
			barraVacunaVerde.setIcon(img.tamaño(new ImageIcon("botones/barras_vacunas_10_verde.png"), (this.getWidth() / 5) * 2, tamañoY));
			break;
		}
	}
	public void updateBarraVacunaAmarillo() {
		int tamañoX = 40;
		int tamañoY = 80;
		switch (Partida.vacunas.get(3).desarollo/10) {
		case 0:
			barraVacunaAmarillo.setIcon(img.tamaño(new ImageIcon("botones/barras_vacunas_0_amarillo.png"),(this.getWidth() / 5) * 2, tamañoY));
			break;
		case 1:
			barraVacunaAmarillo.setIcon(img.tamaño(new ImageIcon("botones/barras_vacunas_1_amarillo.png"),(this.getWidth() / 5) * 2, tamañoY));
			break;
		case 2:
			barraVacunaAmarillo.setIcon(img.tamaño(new ImageIcon("botones/barras_vacunas_2_amarillo.png"),(this.getWidth() / 5) * 2, tamañoY));
			break;
		case 3:
			barraVacunaAmarillo.setIcon(img.tamaño(new ImageIcon("botones/barras_vacunas_3_amarillo.png"),(this.getWidth() / 5) * 2, tamañoY));
			break;
		case 4:
			barraVacunaAmarillo.setIcon(img.tamaño(new ImageIcon("botones/barras_vacunas_4_amarillo.png"),(this.getWidth() / 5) * 2, tamañoY));
			break;
		case 5:
			barraVacunaAmarillo.setIcon(img.tamaño(new ImageIcon("botones/barras_vacunas_5_amarillo.png"),(this.getWidth() / 5) * 2, tamañoY));
			break;
		case 6:
			barraVacunaAmarillo.setIcon(img.tamaño(new ImageIcon("botones/barras_vacunas_6_amarillo.png"),(this.getWidth() / 5) * 2, tamañoY));
			break;
		case 7:
			barraVacunaAmarillo.setIcon(img.tamaño(new ImageIcon("botones/barras_vacunas_7_amarillo.png"),(this.getWidth() / 5) * 2, tamañoY));
			break;
		case 8:
			barraVacunaAmarillo.setIcon(img.tamaño(new ImageIcon("botones/barras_vacunas_8_amarillo.png"),(this.getWidth() / 5) * 2, tamañoY));
			break;
		case 9:
			barraVacunaAmarillo.setIcon(img.tamaño(new ImageIcon("botones/barras_vacunas_9_amarillo.png"),(this.getWidth() / 5) * 2, tamañoY));
			break;
		case 10:
			barraVacunaAmarillo.setIcon(img.tamaño(new ImageIcon("botones/barras_vacunas_10_amarillo.png"),(this.getWidth() / 5) * 2, tamañoY));
			break;
		}
	}
	
	
	public void update() {
		updateBarraVacunaAzul();
		updateBarraVacunaAmarillo();
		updateBarraVacunaRojo();
		updateBarraVacunaVerde();
	}
}
