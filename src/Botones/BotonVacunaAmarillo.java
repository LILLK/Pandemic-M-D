package Botones;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;

import Logico.Ciudades;
import Logico.Jugador;
import Logico.Partida;
import Logico.Vacunas;
import Pandemic.*;
/**
 * Esta calsse define los contructores del boton vacuna amarillo
 * Amuenta el desarollo de la vacuna
 * + int tamañoX
 * + int tamañoY
 * + int idVirus
 * @author DAME
 */
public class BotonVacunaAmarillo extends JLabel {
	
	int tamañoX = 80;
	int tamañoY = 80;
	int  idVirus = 3;
/**
 * Constructor del boton vacuna amarillo
 * Amuenta el desarollo de la vacuna
 * @param {@link JF_PanelPartidaVacunas }
 * @param {@link JF_PanelPartida }
 */
	public BotonVacunaAmarillo(JF_PanelPartidaVacunas panel,JF_PanelPartida pPartida) {
		setIcon(cambiarImg.tamaño(new ImageIcon("botones/virus_amarillo_0.png"), tamañoX, tamañoY));
		addMouseListener((MouseListener) new MouseListener() {
			public void mouseEntered(MouseEvent e) {
				setIcon(cambiarImg.tamaño(new ImageIcon("botones/virus_amarillo_0_entered.png"), tamañoX, tamañoY));
			}
			public void mouseExited(MouseEvent a) {
				setIcon(cambiarImg.tamaño(new ImageIcon("botones/virus_amarillo_0.png"), tamañoX, tamañoY));
			}
			public void mousePressed(MouseEvent i) {
				
			}
			public void mouseClicked(MouseEvent e) {
				Vacunas.desarollar(idVirus);
				panel.updateBarraVacunaAmarillo();
				Partida.jugarPartida(pPartida);
			}

			public void mouseReleased(MouseEvent e) {}
		});

	}

}
