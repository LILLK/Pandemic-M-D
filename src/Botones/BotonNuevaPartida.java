package Botones;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.*;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Pandemic.*;
/**
 * Esta classe define los constructores del boton Nueva partida.
 * Este cambia el panel, donde se podra elejir la dificultad de la nueva partida
 * @author DAME
 */
public class BotonNuevaPartida extends JLabel {
	/**
	 * Este es el constructor de boton Nueva partida en {@link JF_PanelMenu} .
	 * Este cambia el panel, donde se podra elejir la dificultad de la nueva partida
	 * @param {@link JF_PanelMenu}
	 */
	public BotonNuevaPartida(JF_PanelMenu JF_PanelMenu) {
		
		
		setIcon(cambiarImg.tamaño(new ImageIcon("botones/bottonNuevaPartida-1.png"), ((int)(cambiarImg.screenSize.getWidth()/5)), ((int)(cambiarImg.screenSize.getWidth()/20))));
		
		addMouseListener(new MouseListener() {	
			
			
			public void mouseEntered(MouseEvent e) {
				setIcon(cambiarImg.tamaño(new ImageIcon("botones/bottonNuevaPartida-2.png"),((int)(cambiarImg.screenSize.getWidth()/5)) , ((int)(cambiarImg.screenSize.getWidth()/20))));
			}
			public void mouseExited(MouseEvent a) {
				setIcon(cambiarImg.tamaño(new ImageIcon("botones/bottonNuevaPartida-1.png"),((int)(cambiarImg.screenSize.getWidth()/5)), ((int)(cambiarImg.screenSize.getWidth()/20))));
			}

			public void mousePressed(MouseEvent i) {
				setIcon(cambiarImg.tamaño(new ImageIcon("botones/bottonNuevaPartida-3.png"),((int)(cambiarImg.screenSize.getWidth()/5)), ((int)(cambiarImg.screenSize.getWidth()/20))));
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
