package Botones;

import java.awt.event.*;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Pandemic.*;

public class BotonSalir extends JLabel {
	
	
	public BotonSalir() {
		
		cambiarImg img = new cambiarImg();
		
		setIcon(img.tamaño(new ImageIcon("botones/bottonSalir-1.png"), ((int)(JF_PanelMenu.screenSize.getWidth()/5)), ((int)(JF_PanelMenu.screenSize.getWidth()/20))) );
		addMouseListener(new MouseListener() {	
			public void mouseEntered(MouseEvent e) {
				setIcon(img.tamaño(new ImageIcon("botones/bottonSalir-2.png"), ((int)(JF_PanelMenu.screenSize.getWidth()/5)), ((int)(JF_PanelMenu.screenSize.getWidth()/20))) );
			}
			public void mouseExited(MouseEvent a) {
				setIcon(img.tamaño(new ImageIcon("botones/bottonSalir-1.png"), ((int)(JF_PanelMenu.screenSize.getWidth()/5)), ((int)(JF_PanelMenu.screenSize.getWidth()/20))) );
			}

			public void mousePressed(MouseEvent i) {
				setIcon(img.tamaño(new ImageIcon("botones/bottonSalir-3.png"), ((int)(JF_PanelMenu.screenSize.getWidth()/5)), ((int)(JF_PanelMenu.screenSize.getWidth()/20))) );
			}
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
			public void mouseReleased(MouseEvent e) {
				// TODO Apéndice de método generado automáticamente
				
			}
		});
	}
}