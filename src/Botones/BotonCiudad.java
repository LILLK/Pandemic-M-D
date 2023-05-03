package Botones;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;

import Logico.Ciudades;
import Logico.Partida;
import Pandemic.*;

public class BotonCiudad extends JLabel {

	Dimension screenSize;
	cambiarImg img;


	public BotonCiudad(JF_PanelPartida JF_PanelPartida, int virusID) {
		
		int tamañoX = 30;
		int tamañoY = 20;
		
		this.screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		switch (virusID) {
		case 0:
			setIcon(img.tamaño(new ImageIcon("imagenes/ciudad_azul_0_sano.png"), tamañoX, tamañoY));

			break;

		case 1:
			setIcon(img.tamaño(new ImageIcon("imagenes/ciudad_rojo_0_sano.png"), tamañoX, tamañoY));

			break;
		case 2:
			setIcon(img.tamaño(new ImageIcon("imagenes/ciudad_verde_0_sano.png"), tamañoX, tamañoY));

			break;
		case 3:
			setIcon(img.tamaño(new ImageIcon("imagenes/ciudad_amarillo_0_sano.png"), tamañoX, tamañoY));
			break;

		default:
			break;
		}

		addMouseListener((MouseListener) new MouseListener() {
			public void mouseEntered(MouseEvent e) {
				switch (virusID) {
				case 0:
					setIcon(img.tamaño(new ImageIcon("imagenes/ciudad_azul_0_sano_entered.png"), tamañoX, tamañoY));

					break;

				case 1:
					setIcon(img.tamaño(new ImageIcon("imagenes/ciudad_rojo_0_sano_entered.png"), tamañoX, tamañoY));

					break;
				case 2:
					setIcon(img.tamaño(new ImageIcon("imagenes/ciudad_verde_0_sano_entered.png"), tamañoX, tamañoY));

					break;
				case 3:
					setIcon(img.tamaño(new ImageIcon("imagenes/ciudad_amarillo_0_sano_entered.png"), tamañoX, tamañoY));
					break;

				default:
					break;
				}
			}

			public void mouseExited(MouseEvent a) {
				
				
				switch (virusID) {
				case 0:
					setIcon(img.tamaño(new ImageIcon("imagenes/ciudad_azul_0_sano.png"), tamañoX, tamañoY));

					break;

				case 1:
					setIcon(img.tamaño(new ImageIcon("imagenes/ciudad_rojo_0_sano.png"), tamañoX, tamañoY));

					break;
				case 2:
					setIcon(img.tamaño(new ImageIcon("imagenes/ciudad_verde_0_sano.png"), tamañoX, tamañoY));

					break;
				case 3:
					setIcon(img.tamaño(new ImageIcon("imagenes/ciudad_amarillo_0_sano.png"), tamañoX, tamañoY));
					break;

				default:
					break;
				}
				
				
			}

			public void mousePressed(MouseEvent i) {

			}

			public void mouseClicked(MouseEvent e) {

			}

			public void mouseReleased(MouseEvent e) {
				// TODO Apéndice de método generado automáticamente

			}
		});

	}

}
