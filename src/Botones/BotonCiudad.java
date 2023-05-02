package Botones;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;

import Logico.Ciudades;
import Logico.Partida;
import Pandemic.*;

public class BotonCiudad extends JLabel {

	Dimension screenSize;
	cambiarImg img;

	static JF_PanelMenu JF_PanelMenu;

	public BotonCiudad(JF_PanelPartida JF_PanelPartida, int virusID) {
		this.screenSize = Toolkit.getDefaultToolkit().getScreenSize();


		addMouseListener((MouseListener) new MouseListener() {
			public void mouseEntered(MouseEvent e) {
				setIcon(img.tamaño(new ImageIcon("imagenes/ciudad_amarillo_0_brote_entered.png"), 60, 40));

			}

			public void mouseExited(MouseEvent a) {
				setIcon(img.tamaño(new ImageIcon("imagenes/ciudad_amarillo_0_brote.png"), 60, 40));

			}

			public void mousePressed(MouseEvent i) {

			}

			public void mouseClicked(MouseEvent e) {

			}

			public void mouseReleased(MouseEvent e) {
				// TODO Apéndice de método generado automáticamente

			}
		});

	}

	

}
