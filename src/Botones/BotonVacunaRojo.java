//Mehdi Tahrat && David hola
package Botones;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

import Logico.*;

import Pandemic.*;
/**
 * Esta calsse define los contructores del boton vacuna rojo.
 * Amuenta el desarollo de la vacuna
 * @author DAME
 */
public class BotonVacunaRojo extends JLabel {
	

	/**
	 * tamanyoX = 80
	 */
	int tamanyoX = 80;
	/**
	 * tamanyoY = 80;
	 */
	int tamanyoY = 80;
	/**
	 * idVirus = 1;
	 */
	int  idVirus = 1;
	/**
	 * Constructor del boton vacuna Rojo
	 * Amuenta el desarollo de la vacuna
	 * @param {@link JF_PanelPartidaVacunas }
	 * @param {@link JF_PanelPartida }
	 */
	public BotonVacunaRojo(JF_PanelPartidaVacunas panel,JF_PanelPartida pPartida) {
		setIcon(cambiarImg.tamanyo(new ImageIcon("botones/virus_rojo_0.png"), tamanyoX, tamanyoY));
		
		
		addMouseListener((MouseListener) new MouseListener() {
			public void mouseEntered(MouseEvent e) {
				setIcon(cambiarImg.tamanyo(new ImageIcon("botones/virus_rojo_0_entered.png"), tamanyoX, tamanyoY));
			}

			public void mouseExited(MouseEvent a) {
				setIcon(cambiarImg.tamanyo(new ImageIcon("botones/virus_rojo_0.png"), tamanyoX, tamanyoY));
			}

			public void mousePressed(MouseEvent i) {}

			public void mouseClicked(MouseEvent e) {
				Vacunas.desarollar(idVirus);
				panel.updateBarraVacunaRojo();
				Partida.jugarPartida(pPartida);
			}

			public void mouseReleased(MouseEvent e) {}
		});

	}
	
	

	
	
	


}
