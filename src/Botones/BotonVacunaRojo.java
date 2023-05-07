package Botones;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;

import Logico.Ciudades;
import Logico.Partida;
import Pandemic.*;

public class BotonVacunaRojo extends JLabel {
	
	Dimension screenSize;
	cambiarImg img;


	public BotonVacunaRojo(JF_PanelPartidaVacunas panel) {
		
		int tamañoX = 40;
		int tamañoY = 40;
		this.screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setIcon(img.tamaño(new ImageIcon("botones/virus_rojo_0.png"), 40, tamañoY));
		
		
		addMouseListener((MouseListener) new MouseListener() {
			public void mouseEntered(MouseEvent e) {
				setIcon(img.tamaño(new ImageIcon("botones/virus_rojo_0_entered.png"), 40, tamañoY));
			}

			public void mouseExited(MouseEvent a) {
				setIcon(img.tamaño(new ImageIcon("botones/virus_rojo_0.png"), 40, tamañoY));
			}

			public void mousePressed(MouseEvent i) {}

			public void mouseClicked(MouseEvent e) {}

			public void mouseReleased(MouseEvent e) {}
		});

	}
	
	

	
	
	


}