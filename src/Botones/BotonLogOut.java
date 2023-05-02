package Botones;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import Pandemic.*;

public class BotonLogOut extends JLabel {

	Dimension  screenSize;
	cambiarImg img;
	
	static JF_PanelMenu JF_PanelMenu;
	
	public BotonLogOut(JF_PanelMenu JF_PanelMenu) {
		this.screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		

		setIcon(img.tamaño(new ImageIcon("botones/log-out.png"),screenSize.height/10, screenSize.width/14));
		
		addMouseListener((MouseListener) new MouseListener() {	
			public void mouseEntered(MouseEvent e) {
				setIcon(img.tamaño(new ImageIcon("botones/log-out-2.png"),screenSize.height/10, screenSize.width/14));

			}
			public void mouseExited(MouseEvent a) {
				setIcon(img.tamaño(new ImageIcon("botones/log-out.png"),screenSize.height/10, screenSize.width/14));

			}

			public void mousePressed(MouseEvent i) {
				
			}
			public void mouseClicked(MouseEvent e) {
				JF_PanelMenu.irPanelIniciarSesion();
			}
			public void mouseReleased(MouseEvent e) {
				// TODO Apéndice de método generado automáticamente
				
			}
		});
	
	}
	

}
