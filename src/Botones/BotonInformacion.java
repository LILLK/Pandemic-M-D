package Botones;

import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Pandemic.*;

/**
 * Esta classe define los contructores del Boton Informacion
 * Cambia el panel al Panel Informacion, donde se explican las normas
 * @author DAME
 *
 */
public class BotonInformacion extends JLabel {
	/**
	 *Constructor del boton en el panel menu, {@link JF_PanelMenu}
	 *Al ser pulsado, cambia al panel {@link JF_PanelInfo}
	 * @param {@link JF_PanelMenu}
	 *
	 */
	public BotonInformacion(JF_PanelMenu JF_PanelMenu) {
		//establece el icono
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
				//cambiar al panel informacion
				JF_PanelMenu.irPanelInformacion();
			}
			public void mouseReleased(MouseEvent e) {				
			}
		});
	}
}
