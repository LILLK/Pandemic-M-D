package Botones;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.*;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Pandemic.*;

public class BotonCargarPartida extends JLabel {
	

	public BotonCargarPartida(JF_PanelMenu JF_PanelMenu) {
		
		cambiarImg img = new cambiarImg();
		
		setIcon(img.tamaño(new ImageIcon("botones/bottonCargarPartida-1.png"), ((int)(cambiarImg.screenSize.getWidth()/5)), ((int)(cambiarImg.screenSize.getWidth()/20))));
		addMouseListener(new MouseListener() {	
			public void mouseEntered(MouseEvent e) {
				setIcon(img.tamaño(new ImageIcon("botones/bottonCargarPartida-2.png"), ((int)(cambiarImg.screenSize.getWidth()/5)), ((int)(cambiarImg.screenSize.getWidth()/20))));
			}
			public void mouseExited(MouseEvent a) {
				setIcon(img.tamaño(new ImageIcon("botones/bottonCargarPartida-1.png"), ((int)(cambiarImg.screenSize.getWidth()/5)), ((int)(cambiarImg.screenSize.getWidth()/20))));
			}

			public void mousePressed(MouseEvent i) {
				setIcon(img.tamaño(new ImageIcon("botones/bottonCargarPartida-3.png"), ((int)(cambiarImg.screenSize.getWidth()/5)), ((int)(cambiarImg.screenSize.getWidth()/20))));
				
			}
			public void mouseClicked(MouseEvent e) {
				JF_PanelMenu.irPanelCargarPartida();
			}
			public void mouseReleased(MouseEvent e) {
				// TODO Apéndice de método generado automáticamente
				
			}
		});
	}
}