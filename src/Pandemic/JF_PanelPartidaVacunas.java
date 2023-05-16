//Mehdi Tahrat && David hola
package Pandemic;

import java.awt.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import Botones.*;
import Logico.Partida;
/**
 * Esta classe crea el panel Partida vacunas
 * En este panel se alojan las barras que indican el estado de la bacuna y botones para desarollarla
 * @author DAME
 *
 */
public class JF_PanelPartidaVacunas extends JPanel {
	/**
	 * Label de la barra de estado de la vacuna azul
	 */
	JLabel barraVacunaAzul;
	/**
	 * Label de la barra de estado de la vacuna rojo
	 */
	JLabel barraVacunaRojo;
	/**
	 * Label de la barra de estado de la vacuna verde
	 */
	JLabel barraVacunaVerde;
	/**
	 * Label de la barra de estado de la vacuna amarillo
	 */
	JLabel barraVacunaAmarillo;
	/**
	 * {@link BotonVacunaAzul}
	 */
	BotonVacunaVerde botonVacunaVerde;
	/**
	 * {@link BotonVacunaRojo}
	 */
	BotonVacunaRojo botonVacunaRojo;
	/**
	 * {@link BotonVacunaAzul}
	 */
	BotonVacunaAzul botonVacunaAzul;
	/**
	 * {@link BotonVacunaAmarillo}
	 */
	BotonVacunaAmarillo botonVacunaAmarillo;
	/**
	 * tamanyo de los componentes de este panel
	 */
	int tamanyoX = 80;
	/**
	 * tamanyo de los componentes de este panel
	 */
	int tamanyoY = 80;
/**
 * Este constructor genera el panel Partida Vacuna 
 * En este panel se alojan las barras que indican el estado de la bacuna y botones para desarollarla
 * @param a {@link JF_PanelPartida}
 */
	public JF_PanelPartidaVacunas(JF_PanelPartida panel) {


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
		barraVacunaAzul.setBounds((this.getWidth() / 30), ((this.getHeight() / 5)), ((this.getWidth() / 5) * 2),(tamanyoY));
		barraVacunaAzul.setOpaque(false);
		
		updateBarraVacunaRojo();
		barraVacunaRojo.setBounds((this.getWidth() / 30), ((this.getHeight() / 5) * 3), ((this.getWidth() / 5) * 2),(tamanyoY));
		barraVacunaRojo.setOpaque(false);
		
		updateBarraVacunaVerde();
		barraVacunaVerde.setBounds((this.getWidth() / 20 * 11), ((this.getHeight() / 5) * 3),((this.getWidth() / 5) * 2), (tamanyoY));
		barraVacunaVerde.setOpaque(false);
		
		updateBarraVacunaAmarillo();
		barraVacunaAmarillo.setBounds((this.getWidth() / 20 * 11), ((this.getHeight() / 5)),	((this.getWidth() / 5) * 2), (tamanyoY));
		barraVacunaAmarillo.setOpaque(false);
		
		botonVacunaAzul.setBounds((this.getWidth() / 10 * 4 +50), ((this.getHeight() / 5)), (tamanyoX), (tamanyoY));
		botonVacunaRojo.setBounds((this.getWidth() / 10 * 4 +50), ((this.getHeight() / 5) * 3), (tamanyoX), (tamanyoY));
		botonVacunaVerde.setBounds((this.getWidth() / 10 * 4 + 70 + tamanyoX), ((this.getHeight() / 5) * 3), (tamanyoX),(tamanyoY));
		botonVacunaAmarillo.setBounds((this.getWidth() / 10 * 4 + 70 + tamanyoX), ((this.getHeight() / 5)), (tamanyoX),(tamanyoY));

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
		BufferedImage cambiarImgFondo;
		try {
			Dimension size =getSize();
			cambiarImgFondo = ImageIO.read(new File("imagenes/fondo_3.png"));
			g.drawImage(cambiarImgFondo, 0, 0, size.width, size.height,null);
			setOpaque(false);
			super.paint(g);
		} catch (IOException e) {
			System.out.print("Error IMGfondo JF_PanelPartidaPanel1");
		}
	}
	
	
	/**
	 * Actualiza la imagen de las barras vacuna de cada color
	 */
	public void updateBarraVacunaAzul() {
	
		switch (Partida.vacunas.get(0).desarollo/10) {
		case 0:
			barraVacunaAzul.setIcon(cambiarImg.tamanyo(new ImageIcon("botones/barras_vacunas_0_azul.png"), (this.getWidth() / 5) * 2, tamanyoY));
			break;
		case 1:
			barraVacunaAzul.setIcon(cambiarImg.tamanyo(new ImageIcon("botones/barras_vacunas_1_azul.png"), (this.getWidth() / 5) * 2, tamanyoY));	
			break;
		case 2:
			barraVacunaAzul.setIcon(cambiarImg.tamanyo(new ImageIcon("botones/barras_vacunas_2_azul.png"), (this.getWidth() / 5) * 2, tamanyoY));
			break;
		case 3:
			barraVacunaAzul.setIcon(cambiarImg.tamanyo(new ImageIcon("botones/barras_vacunas_3_azul.png"), (this.getWidth() / 5) * 2, tamanyoY));
			break;
		case 4:
			barraVacunaAzul.setIcon(cambiarImg.tamanyo(new ImageIcon("botones/barras_vacunas_4_azul.png"), (this.getWidth() / 5) * 2, tamanyoY));
			break;
		case 5:
			barraVacunaAzul.setIcon(cambiarImg.tamanyo(new ImageIcon("botones/barras_vacunas_5_azul.png"), (this.getWidth() / 5) * 2, tamanyoY));
			break;
		case 6:
			barraVacunaAzul.setIcon(cambiarImg.tamanyo(new ImageIcon("botones/barras_vacunas_6_azul.png"), (this.getWidth() / 5) * 2, tamanyoY));
			break;
		case 7:
			barraVacunaAzul.setIcon(cambiarImg.tamanyo(new ImageIcon("botones/barras_vacunas_7_azul.png"), (this.getWidth() / 5) * 2, tamanyoY));
			break;
		case 8:
			barraVacunaAzul.setIcon(cambiarImg.tamanyo(new ImageIcon("botones/barras_vacunas_8_azul.png"), (this.getWidth() / 5) * 2, tamanyoY));
			break;
		case 9:
			barraVacunaAzul.setIcon(cambiarImg.tamanyo(new ImageIcon("botones/barras_vacunas_9_azul.png"), (this.getWidth() / 5) * 2, tamanyoY));
			break;
		case 10:
			barraVacunaAzul.setIcon(cambiarImg.tamanyo(new ImageIcon("botones/barras_vacunas_10_azul.png"), (this.getWidth() / 5) * 2, tamanyoY));
			break;
		}
	}
	/**
	 * Actualiza la imagen de las barras vacuna de cada color
	 */
	public void updateBarraVacunaRojo() {
	
		switch (Partida.vacunas.get(1).desarollo/10) {
		case 0:
			barraVacunaRojo.setIcon(cambiarImg.tamanyo(new ImageIcon("botones/barras_vacunas_0_rojo.png"), (this.getWidth() / 5) * 2, tamanyoY));
			break;
		case 1:
			barraVacunaRojo.setIcon(cambiarImg.tamanyo(new ImageIcon("botones/barras_vacunas_1_rojo.png"), (this.getWidth() / 5) * 2, tamanyoY));
			break;
		case 2:
			barraVacunaRojo.setIcon(cambiarImg.tamanyo(new ImageIcon("botones/barras_vacunas_2_rojo.png"), (this.getWidth() / 5) * 2, tamanyoY));
			break;
		case 3:
			barraVacunaRojo.setIcon(cambiarImg.tamanyo(new ImageIcon("botones/barras_vacunas_3_rojo.png"), (this.getWidth() / 5) * 2, tamanyoY));
			break;
		case 4:
			barraVacunaRojo.setIcon(cambiarImg.tamanyo(new ImageIcon("botones/barras_vacunas_4_rojo.png"), (this.getWidth() / 5) * 2, tamanyoY));
			break;
		case 5:
			barraVacunaRojo.setIcon(cambiarImg.tamanyo(new ImageIcon("botones/barras_vacunas_5_rojo.png"), (this.getWidth() / 5) * 2, tamanyoY));
			break;
		case 6:
			barraVacunaRojo.setIcon(cambiarImg.tamanyo(new ImageIcon("botones/barras_vacunas_6_rojo.png"), (this.getWidth() / 5) * 2, tamanyoY));
			break;
		case 7:
			barraVacunaRojo.setIcon(cambiarImg.tamanyo(new ImageIcon("botones/barras_vacunas_7_rojo.png"), (this.getWidth() / 5) * 2, tamanyoY));
			break;
		case 8:
			barraVacunaRojo.setIcon(cambiarImg.tamanyo(new ImageIcon("botones/barras_vacunas_8_rojo.png"), (this.getWidth() / 5) * 2, tamanyoY));
			break;
		case 9:
			barraVacunaRojo.setIcon(cambiarImg.tamanyo(new ImageIcon("botones/barras_vacunas_9_rojo.png"), (this.getWidth() / 5) * 2, tamanyoY));
			break;
		case 10:
			barraVacunaRojo.setIcon(cambiarImg.tamanyo(new ImageIcon("botones/barras_vacunas_10_rojo.png"), (this.getWidth() / 5) * 2, tamanyoY));
			break;
		}
	}
	/**
	 * Actualiza la imagen de las barras vacuna de cada color
	 */
	public void updateBarraVacunaVerde() {
	
		switch (Partida.vacunas.get(2).desarollo/10) {
		case 0:
			barraVacunaVerde.setIcon(cambiarImg.tamanyo(new ImageIcon("botones/barras_vacunas_0_verde.png"), (this.getWidth() / 5) * 2, tamanyoY));
			break;
		case 1:
			barraVacunaVerde.setIcon(cambiarImg.tamanyo(new ImageIcon("botones/barras_vacunas_1_verde.png"), (this.getWidth() / 5) * 2, tamanyoY));
			break;
		case 2:
			barraVacunaVerde.setIcon(cambiarImg.tamanyo(new ImageIcon("botones/barras_vacunas_2_verde.png"), (this.getWidth() / 5) * 2, tamanyoY));
			break;
		case 3:
			barraVacunaVerde.setIcon(cambiarImg.tamanyo(new ImageIcon("botones/barras_vacunas_3_verde.png"), (this.getWidth() / 5) * 2, tamanyoY));
			break;
		case 4:
			barraVacunaVerde.setIcon(cambiarImg.tamanyo(new ImageIcon("botones/barras_vacunas_4_verde.png"), (this.getWidth() / 5) * 2, tamanyoY));
			break;
		case 5:
			barraVacunaVerde.setIcon(cambiarImg.tamanyo(new ImageIcon("botones/barras_vacunas_5_verde.png"), (this.getWidth() / 5) * 2, tamanyoY));
			break;
		case 6:
			barraVacunaVerde.setIcon(cambiarImg.tamanyo(new ImageIcon("botones/barras_vacunas_6_verde.png"), (this.getWidth() / 5) * 2, tamanyoY));
			break;
		case 7:
			barraVacunaVerde.setIcon(cambiarImg.tamanyo(new ImageIcon("botones/barras_vacunas_7_verde.png"), (this.getWidth() / 5) * 2, tamanyoY));
			break;
		case 8:
			barraVacunaVerde.setIcon(cambiarImg.tamanyo(new ImageIcon("botones/barras_vacunas_8_verde.png"), (this.getWidth() / 5) * 2, tamanyoY));
			break;
		case 9:
			barraVacunaVerde.setIcon(cambiarImg.tamanyo(new ImageIcon("botones/barras_vacunas_9_verde.png"), (this.getWidth() / 5) * 2, tamanyoY));
			break;
		case 10:
			barraVacunaVerde.setIcon(cambiarImg.tamanyo(new ImageIcon("botones/barras_vacunas_10_verde.png"), (this.getWidth() / 5) * 2, tamanyoY));
			break;
		}
	}
	/**
	 * Actualiza la imagen de las barras vacuna de cada color
	 */
	public void updateBarraVacunaAmarillo() {
	
		switch (Partida.vacunas.get(3).desarollo/10) {
		case 0:
			barraVacunaAmarillo.setIcon(cambiarImg.tamanyo(new ImageIcon("botones/barras_vacunas_0_amarillo.png"),(this.getWidth() / 5) * 2, tamanyoY));
			break;
		case 1:
			barraVacunaAmarillo.setIcon(cambiarImg.tamanyo(new ImageIcon("botones/barras_vacunas_1_amarillo.png"),(this.getWidth() / 5) * 2, tamanyoY));
			break;
		case 2:
			barraVacunaAmarillo.setIcon(cambiarImg.tamanyo(new ImageIcon("botones/barras_vacunas_2_amarillo.png"),(this.getWidth() / 5) * 2, tamanyoY));
			break;
		case 3:
			barraVacunaAmarillo.setIcon(cambiarImg.tamanyo(new ImageIcon("botones/barras_vacunas_3_amarillo.png"),(this.getWidth() / 5) * 2, tamanyoY));
			break;
		case 4:
			barraVacunaAmarillo.setIcon(cambiarImg.tamanyo(new ImageIcon("botones/barras_vacunas_4_amarillo.png"),(this.getWidth() / 5) * 2, tamanyoY));
			break;
		case 5:
			barraVacunaAmarillo.setIcon(cambiarImg.tamanyo(new ImageIcon("botones/barras_vacunas_5_amarillo.png"),(this.getWidth() / 5) * 2, tamanyoY));
			break;
		case 6:
			barraVacunaAmarillo.setIcon(cambiarImg.tamanyo(new ImageIcon("botones/barras_vacunas_6_amarillo.png"),(this.getWidth() / 5) * 2, tamanyoY));
			break;
		case 7:
			barraVacunaAmarillo.setIcon(cambiarImg.tamanyo(new ImageIcon("botones/barras_vacunas_7_amarillo.png"),(this.getWidth() / 5) * 2, tamanyoY));
			break;
		case 8:
			barraVacunaAmarillo.setIcon(cambiarImg.tamanyo(new ImageIcon("botones/barras_vacunas_8_amarillo.png"),(this.getWidth() / 5) * 2, tamanyoY));
			break;
		case 9:
			barraVacunaAmarillo.setIcon(cambiarImg.tamanyo(new ImageIcon("botones/barras_vacunas_9_amarillo.png"),(this.getWidth() / 5) * 2, tamanyoY));
			break;
		case 10:
			barraVacunaAmarillo.setIcon(cambiarImg.tamanyo(new ImageIcon("botones/barras_vacunas_10_amarillo.png"),(this.getWidth() / 5) * 2, tamanyoY));
			break;
		}
	}

}
