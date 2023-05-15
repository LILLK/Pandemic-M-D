package Botones;


import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.*;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Pandemic.*;
/**
 * Esta classe define los constructores del boton version
 * Este cambia del panel {@link JF_PanelMenu} al panel {@link JF_PanelVersion}
 * @author DAME
 *
 */
public class BotonVersion extends JLabel {
	
/**
 * Constructor del boton Virus
 * Este cambia del panel {@link JF_PanelMenu} al panel {@link JF_PanelVersion}
 * @param {@link JF_PanelMenu}
 */
	public BotonVersion(JF_PanelMenu JF_PanelMenu) {
		

		setIcon(cambiarImg.tamaño(new ImageIcon("botones/bottonVersion-1.png"), ((int)(cambiarImg.screenSize.getWidth()/5)), ((int)(cambiarImg.screenSize.getWidth()/20))) );
		addMouseListener(new MouseListener() {	
			public void mouseEntered(MouseEvent e) {
				setIcon(cambiarImg.tamaño(new ImageIcon("botones/bottonVersion-2.png"), ((int)(cambiarImg.screenSize.getWidth()/5)), ((int)(cambiarImg.screenSize.getWidth()/20))) );
			}
			public void mouseExited(MouseEvent a) {
				setIcon(cambiarImg.tamaño(new ImageIcon("botones/bottonVersion-1.png"), ((int)(cambiarImg.screenSize.getWidth()/5)), ((int)(cambiarImg.screenSize.getWidth()/20))) );
			}

			public void mousePressed(MouseEvent i) {
				setIcon(cambiarImg.tamaño(new ImageIcon("botones/bottonVersion-3.png"), ((int)(cambiarImg.screenSize.getWidth()/5)), ((int)(cambiarImg.screenSize.getWidth()/20))) );
			}
			public void mouseClicked(MouseEvent e) {
				//Cambia al panel version
				JF_PanelMenu.irPanelVersion();
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
}