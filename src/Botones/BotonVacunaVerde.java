package Botones;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;

import Logico.Ciudades;
import Logico.Jugador;
import Logico.Partida;
import Pandemic.*;

public class BotonVacunaVerde extends JLabel {
	
	Dimension screenSize;
	cambiarImg img;


	public BotonVacunaVerde(JF_PanelPartidaVacunas panel) {
		int idVirus = 2;
		int tamañoX = 40;
		int tamañoY = 40;
		this.screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setIcon(img.tamaño(new ImageIcon("botones/virus_verde_0.png"), 40, tamañoY));
		
		
		addMouseListener((MouseListener) new MouseListener() {
			public void mouseEntered(MouseEvent e) {
				setIcon(img.tamaño(new ImageIcon("botones/virus_verde_0_entered.png"), 40, tamañoY));
			}

			public void mouseExited(MouseEvent a) {
				setIcon(img.tamaño(new ImageIcon("botones/virus_verde_0.png"), 40, tamañoY));
			}

			public void mousePressed(MouseEvent i) {}

			public void mouseClicked(MouseEvent e) {
				Jugador.desarollar(idVirus);
				panel.updateBarraVacunaVerde();
			}

			public void mouseReleased(MouseEvent e) {}
		});

	}
	
	

	
	
	


}
