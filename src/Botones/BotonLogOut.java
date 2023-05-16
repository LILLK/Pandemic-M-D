package Botones;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import Pandemic.*;

/**
 * Esta classe define los contructores del Boton Log Out
 * Regresa desde el menu a iniciar sesion
 * @author DAME
 *
 */

public class BotonLogOut extends JLabel {

		/**
		 * Constructor del boton log out
		 * Regresa desde el menu a iniciar sesion
		 * @param {@link  JF_PanelMenu}
		 */
	public BotonLogOut(JF_PanelMenu JF_PanelMenu) {
		

		setIcon(cambiarImg.tamaño(new ImageIcon("botones/log-out.png"),cambiarImg.screenSize.height/10, cambiarImg.screenSize.width/14));
		
		addMouseListener((MouseListener) new MouseListener() {	
			public void mouseEntered(MouseEvent e) {
				setIcon(cambiarImg.tamaño(new ImageIcon("botones/log-out-2.png"),cambiarImg.screenSize.height/10, cambiarImg.screenSize.width/14));

			}
			public void mouseExited(MouseEvent a) {
				setIcon(cambiarImg.tamaño(new ImageIcon("botones/log-out.png"),cambiarImg.screenSize.height/10, cambiarImg.screenSize.width/14));

			}

			public void mousePressed(MouseEvent i) {
				
			}
			public void mouseClicked(MouseEvent e) {
				JF_PanelMenu.irPanelIniciarSesion();
			}
			public void mouseReleased(MouseEvent e) {				
			}
		});
	
	}
	

}
