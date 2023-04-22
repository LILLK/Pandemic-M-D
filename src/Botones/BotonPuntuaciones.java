package Botones;
import java.awt.event.*;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Pandemic.*;

public class BotonPuntuaciones extends JLabel {
	
	
	public BotonPuntuaciones(JF_PanelMenu JF_PanelMenu) {
		
		setIcon(new ImageIcon("botones/bottonPuntuaciones-1.png"));
		addMouseListener(new MouseListener() {	
			public void mouseEntered(MouseEvent e) {
				setIcon(new ImageIcon("botones/bottonPuntuaciones-2.png"));
			}
			public void mouseExited(MouseEvent a) {
				setIcon(new ImageIcon("botones/bottonPuntuaciones-1.png"));
			}

			public void mousePressed(MouseEvent i) {
				setIcon(new ImageIcon("botones/bottonPuntuaciones-3.png"));
			}
			public void mouseClicked(MouseEvent e) {
			}
			public void mouseReleased(MouseEvent e) {
				// TODO Apéndice de método generado automáticamente
				
			}
		});
	}
}