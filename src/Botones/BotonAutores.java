//Mehdi Tahrat && David hola
package Botones;

import java.awt.event.*;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Pandemic.*;
/**
 * Esta classe define los contructores del Boton Autores
 * El boton autores sirve para abrir el panel de autores donde
 * hay informacion sobre los autores de este programa
 * @author DAME
 *
 */

public class BotonAutores extends JLabel {
	
	
	/**
		 * Contructor del Boton Autores en {@link JF_PanelMenu }
		 * @param JF_PanelMenu {@link JF_PanelMenu }
		 */
	public BotonAutores(JF_PanelMenu JF_PanelMenu) {
		

		
		setIcon(cambiarImg.tamanyo(new ImageIcon("botones/bottonAutores-1.png"), ((int)(cambiarImg.screenSize.getWidth()/5)), ((int)(cambiarImg.screenSize.getWidth()/20))) );
		/**
		 * Listener con funcion de cambiar icono al hacer hoover, y ir al panel autores
		 */
		addMouseListener(new MouseListener() {	
			public void mouseEntered(MouseEvent e) {
				setIcon(cambiarImg.tamanyo(new ImageIcon("botones/bottonAutores-2.png"), ((int)(cambiarImg.screenSize.getWidth()/5)), ((int)(cambiarImg.screenSize.getWidth()/20))) );
			}
			public void mouseExited(MouseEvent a) {
				setIcon(cambiarImg.tamanyo(new ImageIcon("botones/bottonAutores-1.png"), ((int)(cambiarImg.screenSize.getWidth()/5)), ((int)(cambiarImg.screenSize.getWidth()/20))) );
			}

			public void mousePressed(MouseEvent i) {
				setIcon(cambiarImg.tamanyo(new ImageIcon("botones/bottonAutores-3.png"), ((int)(cambiarImg.screenSize.getWidth()/5)), ((int)(cambiarImg.screenSize.getWidth()/20))) );
			}
			public void mouseClicked(MouseEvent e) {
				JF_PanelMenu.irPanelAutores();
			}
			public void mouseReleased(MouseEvent e) {
				// TODO Apéndice de método generado automáticamente
				
			}
		});
	}


}
