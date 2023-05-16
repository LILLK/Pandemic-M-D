//Mehdi Tahrat && David hola
package Botones;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import Logico.Partida;
import Logico.Vacunas;
import Pandemic.*;

/**
 * Esta calsse define los contructores del boton vacuna azul.
 * Amuenta el desarollo de la vacuna
 * @author DAME
 */
public class BotonVacunaAzul extends JLabel {
	

	/**
	 * tamanyoX = 80
	 */
	int tamanyoX = 80;
	/**
	 * tamanyoY = 80;
	 */
	int tamanyoY = 80;
	/**
	 * idVirus = 0;
	 */
	int  idVirus = 0;
	/**
	 * Constructor del boton vacuna azul
	 * Amuenta el desarollo de la vacuna
	 * @param {@link JF_PanelPartidaVacunas }
	 * @param {@link JF_PanelPartida }
	 */
	public BotonVacunaAzul(JF_PanelPartidaVacunas panel,JF_PanelPartida pPartida) {
		setIcon(cambiarImg.tamanyo(new ImageIcon("botones/virus_azul_0.png"), tamanyoX, tamanyoY));
		
		
		addMouseListener((MouseListener) new MouseListener() {
			public void mouseEntered(MouseEvent e) {
				setIcon(cambiarImg.tamanyo(new ImageIcon("botones/virus_azul_0_entered.png"), tamanyoX, tamanyoY));
			}

			public void mouseExited(MouseEvent a) {
				setIcon(cambiarImg.tamanyo(new ImageIcon("botones/virus_azul_0.png"), tamanyoX, tamanyoY));
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
