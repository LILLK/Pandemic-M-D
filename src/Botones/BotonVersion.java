package Botones;


import java.awt.event.*;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Pandemic.*;

public class BotonVersion extends JLabel {
	
	
	public BotonVersion(JF_PanelMenu JF_PanelMenu) {
		
		cambiarImg img = new cambiarImg();

		setIcon(img.tamaño(new ImageIcon("botones/bottonVersion-1.png"), 300, 75) );
		addMouseListener(new MouseListener() {	
			public void mouseEntered(MouseEvent e) {
				setIcon(img.tamaño(new ImageIcon("botones/bottonVersion-2.png"), 300, 75) );
			}
			public void mouseExited(MouseEvent a) {
				setIcon(img.tamaño(new ImageIcon("botones/bottonVersion-1.png"), 300, 75) );
			}

			public void mousePressed(MouseEvent i) {
				setIcon(img.tamaño(new ImageIcon("botones/bottonVersion-3.png"), 300, 75) );
			}
			public void mouseClicked(MouseEvent e) {
				JF_PanelMenu.irPanelVersion();
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
}