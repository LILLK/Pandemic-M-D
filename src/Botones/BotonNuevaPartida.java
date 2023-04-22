package Botones;
import java.awt.event.*;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Pandemic.*;

public class BotonNuevaPartida extends JLabel {
	
	
	public BotonNuevaPartida() {
		
		setIcon(new ImageIcon("botones/bottonNuevaPartida-1.png"));
		
		addMouseListener(new MouseListener() {	
			public void mouseEntered(MouseEvent e) {
				setIcon(new ImageIcon("botones/bottonNuevaPartida-2.png"));
			}
			public void mouseExited(MouseEvent a) {
				setIcon(new ImageIcon("botones/bottonNuevaPartida-1.png"));
			}

			public void mousePressed(MouseEvent i) {
				setIcon(new ImageIcon("botones/bottonNuevaPartida-3.png"));
			}
			public void mouseClicked(MouseEvent e) {
				
			}
			public void mouseReleased(MouseEvent e) {
				// TODO Apéndice de método generado automáticamente
				
			}
		});
	}
}
