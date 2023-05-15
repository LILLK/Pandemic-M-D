package Botones;
import java.awt.event.*;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Pandemic.*;

/**
 * Esta clase define los contructores del botonPuntuacion
 * Este boton cambia del {@link JF_PanelMenu} al {@index JF_PanelPuntuaciones} 
 * @author DAME
 */
public class BotonPuntuaciones extends JLabel {
/**
 * Este es el contructor del boton
 * Este boton cambia del {@link JF_PanelMenu} al {@index JF_PanelPuntuaciones} 
 * @param {@link JF_PanelMenu}
 */
	public BotonPuntuaciones(JF_PanelMenu JF_PanelMenu) {
		

		
		setIcon(cambiarImg.tamaño(new ImageIcon("botones/bottonPuntuaciones-1.png"), ((int)(cambiarImg.screenSize.getWidth()/5)), ((int)(cambiarImg.screenSize.getWidth()/20))));
		addMouseListener(new MouseListener() {	
			public void mouseEntered(MouseEvent e) {
				setIcon(cambiarImg.tamaño(new ImageIcon("botones/bottonPuntuaciones-2.png"), ((int)(cambiarImg.screenSize.getWidth()/5)), ((int)(cambiarImg.screenSize.getWidth()/20))));
			}
			public void mouseExited(MouseEvent a) {
				setIcon(cambiarImg.tamaño(new ImageIcon("botones/bottonPuntuaciones-1.png"), ((int)(cambiarImg.screenSize.getWidth()/5)), ((int)(cambiarImg.screenSize.getWidth()/20))));
			}

			public void mousePressed(MouseEvent i) {
				setIcon(cambiarImg.tamaño(new ImageIcon("botones/bottonPuntuaciones-3.png"), ((int)(cambiarImg.screenSize.getWidth()/5)), ((int)(cambiarImg.screenSize.getWidth()/20))));
			}
			public void mouseClicked(MouseEvent e) {
				JF_PanelMenu.irPanelPuntuacion();
			}
			public void mouseReleased(MouseEvent e) {				
			}
		});
	}
}