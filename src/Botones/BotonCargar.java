package Botones;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Logico.*;
import Logico.Parametros;
import Logico.Partida;
import Pandemic.JF_PanelCargarPartida;
import Pandemic.JF_PanelMenu;
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
	//Es el id de partida
	public int idP;
	/**
	 * Constructor del boton Cargar en {@link JF_PanelCargarPartida }
	 * @param {@link JF_PanelCargarPartida }
	 * @param idP - ID de partida
	 * @author DAME
	 * 
	 */
	public BotonCargar(int idP, JF_PanelCargarPartida jf_PanelCargarPartida) {
		this.idP= idP;
		setIcon(cambiarImg.tamaño(new ImageIcon("botones/cargarPartida.png"), 100, 100));

		addMouseListener(new MouseListener() {	
			public void mouseEntered(MouseEvent e) {
				setIcon(cambiarImg.tamaño(new ImageIcon("botones/cargarPartida-1.png"),100,100 ));
			}
			public void mouseExited(MouseEvent a) {
				setIcon(cambiarImg.tamaño(new ImageIcon("botones/cargarPartida.png"),100, 100));
			}

			public void mousePressed(MouseEvent i) {
				setIcon(cambiarImg.tamaño(new ImageIcon("botones/cargarPartida-2.png"), 100, 100 ));
			}
			public void mouseClicked(MouseEvent e) {
				//construlle la partida con el id partida enviado 
				jf_PanelCargarPartida.irPanelPartida(idP);
			}
			public void mouseReleased(MouseEvent e) {				
			}
		});
	}
	
}
