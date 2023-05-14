package Botones;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.*;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Pandemic.*;

public class BotonNuevaPartida extends JLabel {
	
	public BotonNuevaPartida(JF_PanelMenu JF_PanelMenu) {
		
		cambiarImg img = new cambiarImg();
		
		//JF_PanelMenu.screenSize.getWidth();
		//screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		
		setIcon(img.tamaño(new ImageIcon("botones/bottonNuevaPartida-1.png"), ((int)(cambiarImg.screenSize.getWidth()/5)), ((int)(cambiarImg.screenSize.getWidth()/20))));
		
		addMouseListener(new MouseListener() {	
			
			
			public void mouseEntered(MouseEvent e) {
				setIcon(img.tamaño(new ImageIcon("botones/bottonNuevaPartida-2.png"),((int)(cambiarImg.screenSize.getWidth()/5)) , ((int)(cambiarImg.screenSize.getWidth()/20))));
			}
			public void mouseExited(MouseEvent a) {
				setIcon(img.tamaño(new ImageIcon("botones/bottonNuevaPartida-1.png"),((int)(cambiarImg.screenSize.getWidth()/5)), ((int)(cambiarImg.screenSize.getWidth()/20))));
			}

			public void mousePressed(MouseEvent i) {
				setIcon(img.tamaño(new ImageIcon("botones/bottonNuevaPartida-3.png"),((int)(cambiarImg.screenSize.getWidth()/5)), ((int)(cambiarImg.screenSize.getWidth()/20))));
			}
			public void mouseClicked(MouseEvent e) {
				JF_PanelMenu.irPanelPartidaDificultad();
			}
			public void mouseReleased(MouseEvent e) {
				// TODO Apéndice de método generado automáticamente
				
			}
		});
	}
}
