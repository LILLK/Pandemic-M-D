package Botones;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;

import Logico.Ciudades;
import Logico.Partida;
import Logico.Vacunas;
import Pandemic.*;
/**
 * Esta calsse define los contructores del boton vacuna verde
 * Amuenta el desarollo de la vacuna
 * + int tamañoX
 * + int tamañoY
 * + int idVirus
 * @author DAME
 */
public class BotonVacunaVerde extends JLabel {
	

	int idVirus = 2;
	int tamañoX = 80;
	int tamañoY = 80;
	/**
	 * Constructor del boton vacuna Rojo
	 * Amuenta el desarollo de la vacuna
	 * @param {@link JF_PanelPartidaVacunas }
	 * @param {@link JF_PanelPartida }
	 */
	public BotonVacunaVerde(JF_PanelPartidaVacunas panel,JF_PanelPartida pPartida) {
		setIcon(cambiarImg.tamaño(new ImageIcon("botones/virus_verde_0.png"), tamañoX, tamañoY));
		
		
		addMouseListener((MouseListener) new MouseListener() {
			public void mouseEntered(MouseEvent e) {
				setIcon(cambiarImg.tamaño(new ImageIcon("botones/virus_verde_0_entered.png"), tamañoX, tamañoY));
			}

			public void mouseExited(MouseEvent a) {
				setIcon(cambiarImg.tamaño(new ImageIcon("botones/virus_verde_0.png"), tamañoX, tamañoY));
			}

			public void mousePressed(MouseEvent i) {}

			public void mouseClicked(MouseEvent e) {
				Vacunas.desarollar(idVirus);
				panel.updateBarraVacunaVerde();
				Partida.jugarPartida(pPartida);

			}

			public void mouseReleased(MouseEvent e) {}
		});

	}
	
	

	
	
	


}
