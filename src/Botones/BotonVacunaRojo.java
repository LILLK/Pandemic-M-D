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

public class BotonVacunaRojo extends JLabel {
	
	cambiarImg img;


	public BotonVacunaRojo(JF_PanelPartidaVacunas panel,JF_PanelPartida pPartida) {
		int idVirus = 1;
		int tamañoX = 80;
		int tamañoY = 80;
		setIcon(img.tamaño(new ImageIcon("botones/virus_rojo_0.png"), tamañoX, tamañoY));
		
		
		addMouseListener((MouseListener) new MouseListener() {
			public void mouseEntered(MouseEvent e) {
				setIcon(img.tamaño(new ImageIcon("botones/virus_rojo_0_entered.png"), tamañoX, tamañoY));
			}

			public void mouseExited(MouseEvent a) {
				setIcon(img.tamaño(new ImageIcon("botones/virus_rojo_0.png"), tamañoX, tamañoY));
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
