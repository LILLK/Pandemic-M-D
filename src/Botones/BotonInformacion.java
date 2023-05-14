package Botones;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.*;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Pandemic.*;

public class BotonInformacion extends JLabel {
	
	public BotonInformacion(JF_PanelMenu JF_PanelMenu) {
		
		
		setIcon(cambiarImg.tamaño(new ImageIcon("botones/bottonInformacion-1.png"), ((int)(cambiarImg.screenSize.getWidth()/5)), ((int)(cambiarImg.screenSize.getWidth()/20))) );
		
		addMouseListener(new MouseListener() {	
			public void mouseEntered(MouseEvent e) {
				setIcon(cambiarImg.tamaño(new ImageIcon("botones/bottonInformacion-2.png"), ((int)(cambiarImg.screenSize.getWidth()/5)), ((int)(cambiarImg.screenSize.getWidth()/20))) );
			}
			public void mouseExited(MouseEvent a) {
				setIcon(cambiarImg.tamaño(new ImageIcon("botones/bottonInformacion-1.png"), ((int)(cambiarImg.screenSize.getWidth()/5)), ((int)(cambiarImg.screenSize.getWidth()/20))) );
			}

			public void mousePressed(MouseEvent i) {
				setIcon(cambiarImg.tamaño(new ImageIcon("botones/bottonInformacion-3.png"), ((int)(cambiarImg.screenSize.getWidth()/5)), ((int)(cambiarImg.screenSize.getWidth()/20))) );
			}
			public void mouseClicked(MouseEvent e) {
				JF_PanelMenu.irPanelInformacion();
			}
			public void mouseReleased(MouseEvent e) {
				// TODO Apéndice de método generado automáticamente
				
			}
		});
	}
}
