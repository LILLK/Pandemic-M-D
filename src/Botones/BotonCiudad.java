package Botones;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;

import Logico.Ciudades;
import Logico.Partida;
import Pandemic.*;

public class BotonCiudad extends JLabel {

	public JLabel JLNombreCiudad;
	public Ciudades ciudad;
	Dimension screenSize;
	cambiarImg img;

	public BotonCiudad(JF_PanelPartida JF_PanelPartida,Ciudades ciudad) {
		Border borde = BorderFactory.createLineBorder(Color.BLACK, 3);
		int tamañoX = 30;
		int tamañoY = 20;
		this.screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.establecerIcono(tamañoX, tamañoY);
		this.setVisible(true);
		this.setOpaque(false);
		this.ciudad= ciudad;
		this.JLNombreCiudad = new JLabel();
		this.JLNombreCiudad.setVisible(false);
		this.JLNombreCiudad.setText(ciudad.nombre);
		this.JLNombreCiudad.setBorder(borde);
		this.JLNombreCiudad.setBackground(Color.WHITE);
		this.JLNombreCiudad.setOpaque(true);

		addMouseListener((MouseListener) new MouseListener() {
			public void mouseEntered(MouseEvent e) {
				JLNombreCiudad.setVisible(true);
				switch (ciudad.idVirus) {
				case 0:
					setIcon(img.tamaño(new ImageIcon("botones/ciudad_azul_0_sano_entered.png"), tamañoX, tamañoY));
					break;
				case 1:
					setIcon(img.tamaño(new ImageIcon("botones/ciudad_rojo_0_sano_entered.png"), tamañoX, tamañoY));
					break;
				case 2:
					setIcon(img.tamaño(new ImageIcon("botones/ciudad_verde_0_sano_entered.png"), tamañoX, tamañoY));
					break;
				case 3:
					setIcon(img.tamaño(new ImageIcon("botones/ciudad_amarillo_0_sano_entered.png"), tamañoX, tamañoY));
					break;
				default:
					break;
				}
			}
			public void mouseExited(MouseEvent a) {
				JLNombreCiudad.setVisible(false);
				switch (ciudad.idVirus) {
				case 0:
					setIcon(img.tamaño(new ImageIcon("botones/ciudad_azul_0_sano.png"), tamañoX, tamañoY));
					break;
				case 1:
					setIcon(img.tamaño(new ImageIcon("botones/ciudad_rojo_0_sano.png"), tamañoX, tamañoY));
					break;
				case 2:
					setIcon(img.tamaño(new ImageIcon("botones/ciudad_verde_0_sano.png"), tamañoX, tamañoY));
					break;
				case 3:
					setIcon(img.tamaño(new ImageIcon("botones/ciudad_amarillo_0_sano.png"), tamañoX, tamañoY));
					break;
				default:
					break;
				}
			}
			public void mousePressed(MouseEvent i) {}
			public void mouseClicked(MouseEvent e) {
				 JF_PanelPartidaPanel2.updateLog(ciudad.nombre);
			}
			public void mouseReleased(MouseEvent e) {}
		});

	}


	public void establecerIcono( int tamañoX, int tamañoY) {

		switch (this.ciudad.idVirus) {
		case 0:
			setIcon(img.tamaño(new ImageIcon("botones/ciudad_azul_0_sano.png"), tamañoX, tamañoY));

			break;

		case 1:
			setIcon(img.tamaño(new ImageIcon("botones/ciudad_rojo_0_sano.png"), tamañoX, tamañoY));

			break;
		case 2:
			setIcon(img.tamaño(new ImageIcon("botones/ciudad_verde_0_sano.png"), tamañoX, tamañoY));

			break;
		case 3:
			setIcon(img.tamaño(new ImageIcon("botones/ciudad_amarillo_0_sano.png"), tamañoX, tamañoY));
			break;

		default:
			break;
		}

	}

}
