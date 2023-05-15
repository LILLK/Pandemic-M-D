package Botones;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import Logico.Partida;
import Logico.Vacunas;
import Pandemic.*;

/**
 * Esta calsse define los contructores del boton vacuna azul
 * Amuenta el desarollo de la vacuna
 * + int tamañoX
 * + int tamañoY
 * + int idVirus
 * @author DAME
 */
public class BotonVacunaAzul extends JLabel {
	

	int idVirus = 0;
	int tamañoX = 80;
	int tamañoY = 80;
	/**
	 * Constructor del boton vacuna azul
	 * Amuenta el desarollo de la vacuna
	 * @param {@link JF_PanelPartidaVacunas }
	 * @param {@link JF_PanelPartida }
	 */
	public BotonVacunaAzul(JF_PanelPartidaVacunas panel,JF_PanelPartida pPartida) {
		setIcon(cambiarImg.tamaño(new ImageIcon("botones/virus_azul_0.png"), tamañoX, tamañoY));
		
		
		addMouseListener((MouseListener) new MouseListener() {
			public void mouseEntered(MouseEvent e) {
				setIcon(cambiarImg.tamaño(new ImageIcon("botones/virus_azul_0_entered.png"), tamañoX, tamañoY));
			}

			public void mouseExited(MouseEvent a) {
				setIcon(cambiarImg.tamaño(new ImageIcon("botones/virus_azul_0.png"), tamañoX, tamañoY));
			}

			public void mousePressed(MouseEvent i) {}

			public void mouseClicked(MouseEvent e) {
				Vacunas.desarollar(idVirus);
				panel.updateBarraVacunaAzul();
				Partida.jugarPartida(pPartida);

			}

			public void mouseReleased(MouseEvent e) {}
		});

	}
	
	

	
	
	


}
