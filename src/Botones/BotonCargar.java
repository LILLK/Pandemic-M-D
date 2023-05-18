//Mehdi Tahrat && David hola
package Botones;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Pandemic.JF_PanelCargarPartida;
import Pandemic.cambiarImg;
/**
 * Esta classe define los contructores del Boton Cargar
 * El boton Cargar sirve para cargar los datos de la partida
 * elejida y continuarla
 * + int idp - Id de partida
 * @author DAME
 *
 */
public class BotonCargar extends JLabel {
	/**
	 * Es el id de partida
	 */
	public int idP;
	/**
	 * Constructor del boton Cargar en {@link JF_PanelCargarPartida }
	 * @param idP - int -ID de partida
	 * @param jf_PanelCargarPartida {@link JF_PanelCargarPartida }
	 * 
	 */
	public BotonCargar(int idP, JF_PanelCargarPartida jf_PanelCargarPartida) {
		this.idP= idP;
		setIcon(cambiarImg.tamanyo(new ImageIcon("botones/cargarPartida.png"), 100, 100));

		/**
		 * Listener con funcion de cambiar icono al hacer hoover, y carga la partida deseada
		 */
		addMouseListener(new MouseListener() {	
			public void mouseEntered(MouseEvent e) {
				setIcon(cambiarImg.tamanyo(new ImageIcon("botones/cargarPartida-1.png"),100,100 ));
			}
			public void mouseExited(MouseEvent a) {
				setIcon(cambiarImg.tamanyo(new ImageIcon("botones/cargarPartida.png"),100, 100));
			}

			public void mousePressed(MouseEvent i) {
				setIcon(cambiarImg.tamanyo(new ImageIcon("botones/cargarPartida-2.png"), 100, 100 ));
			}
			public void mouseClicked(MouseEvent e) {
				//construlle la partida con el id partida enviado 
				jf_PanelCargarPartida.irPanelPartida(BotonCargar.this.idP);
			}
			public void mouseReleased(MouseEvent e) {				
			}
		});
	}
	
}
