//Mehdi Tahrat && David hola
package Botones;

import java.awt.event.*;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Pandemic.*;
/**
 * Esta classe define los contructores del Boton CargarPartida
 * El boton CargarPartida cambia al panel CargarPartida
 * @author DAME
 *
 */
public class BotonCargarPartida extends JLabel {
	
/**
 * Constructor del Boton CargarPartida en {@link JF_PanelMenu}
 * @param JF_PanelMenu {@link JF_PanelMenu}
 */	

	public BotonCargarPartida(JF_PanelMenu JF_PanelMenu) {
		
		/**
		 * Listener con funcion de cambiar icono al hacer hoover, y ir al panel cargar partida
		 */
		setIcon(cambiarImg.tamanyo(new ImageIcon("botones/bottonCargarPartida-1.png"), ((int)(cambiarImg.screenSize.getWidth()/5)), ((int)(cambiarImg.screenSize.getWidth()/20))));
		addMouseListener(new MouseListener() {	
			public void mouseEntered(MouseEvent e) {
				setIcon(cambiarImg.tamanyo(new ImageIcon("botones/bottonCargarPartida-2.png"), ((int)(cambiarImg.screenSize.getWidth()/5)), ((int)(cambiarImg.screenSize.getWidth()/20))));
			}
			public void mouseExited(MouseEvent a) {
				setIcon(cambiarImg.tamanyo(new ImageIcon("botones/bottonCargarPartida-1.png"), ((int)(cambiarImg.screenSize.getWidth()/5)), ((int)(cambiarImg.screenSize.getWidth()/20))));
			}

			public void mousePressed(MouseEvent i) {
				setIcon(cambiarImg.tamanyo(new ImageIcon("botones/bottonCargarPartida-3.png"), ((int)(cambiarImg.screenSize.getWidth()/5)), ((int)(cambiarImg.screenSize.getWidth()/20))));
				
			}
			public void mouseClicked(MouseEvent e) {
				JF_PanelMenu.irPanelCargarPartida();
			}
			public void mouseReleased(MouseEvent e) {
				// TODO Apéndice de método generado automáticamente
				
			}
		});
	}
}