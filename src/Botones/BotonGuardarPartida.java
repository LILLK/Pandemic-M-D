package Botones;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import javax.swing.border.Border;

import Pandemic.*;

public class BotonGuardarPartida extends JLabel {

	Dimension  screenSize;
	cambiarImg img;
	
	
	public BotonGuardarPartida(JF_PanelPartidaPanel2 panel) {
		this.screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		Border borde = BorderFactory.createLineBorder(Color.BLACK, 3);
		this.setBounds((panel.getWidth()/2)-((panel.getWidth()/2)/2),
				((panel.getHeight()/16)*14),
				panel.getWidth()/2,
				panel.getHeight()/15);
		setIcon(img.tamaño(new ImageIcon("botones/guardar_partida.png"),panel.getWidth()/2, panel.getHeight()/15));
		this.setBackground(Color.WHITE);
		this.setVisible(true);
		this.setBorder(borde);
		this.setOpaque(true);
		this.setText("guardar");
		
		

	
		
		addMouseListener((MouseListener) new MouseListener() {	
			public void mouseEntered(MouseEvent e) {
				setIcon(img.tamaño(new ImageIcon("botones/guardar_partida_entered.png"),panel.getWidth()/2, panel.getHeight()/15));

			}
			public void mouseExited(MouseEvent a) {
				setIcon(img.tamaño(new ImageIcon("botones/guardar_partida.png"),panel.getWidth()/2, panel.getHeight()/15));

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
