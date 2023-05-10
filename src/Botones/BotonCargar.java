package Botones;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Logico.ConexionBD;
import Logico.Jugador;
import Logico.Partida;
import Pandemic.JF_PanelCargarPartida;
import Pandemic.cambiarImg;

public class BotonCargar extends JLabel {
	
	public int idP;
	Dimension screenSize = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
	
	public BotonCargar(int idP, JF_PanelCargarPartida jf_PanelCargarPartida) {
		
		this.idP= idP;
		
		setIcon(cambiarImg.tamaño(new ImageIcon("botones/cargarPartida.png"), 100, 100));

		addMouseListener(new MouseListener() {	
			public void mouseEntered(MouseEvent e) {
				setIcon(cambiarImg.tamaño(new ImageIcon("botones/cargarPartida.png"),100,100 ));
			}
			public void mouseExited(MouseEvent a) {
				setIcon(cambiarImg.tamaño(new ImageIcon("botones/cargarPartida.png"),100, 100));
			}

			public void mousePressed(MouseEvent i) {
				setIcon(cambiarImg.tamaño(new ImageIcon("botones/cargarPartida.png"), 100, 100 ));
			}
			public void mouseClicked(MouseEvent e) {
				ConexionBD.cargarPartida(ConexionBD.con, Jugador.id, idP);
				jf_PanelCargarPartida.irPanelPartida();
			}
			public void mouseReleased(MouseEvent e) {
				// TODO Apéndice de método generado automáticamente
				
			}
		});
	}
	public int getBrotes() {
		return idP;
	}
	public void setBrotes(int idP) {
		this.idP = idP;
	}
}
