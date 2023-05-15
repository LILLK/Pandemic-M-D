package Botones;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import javax.swing.border.Border;

import Logico.ConexionBD;
import Pandemic.*;
/**
 * Esta classe define los constructores del boton GuardarPartida
 * Este boton guarda la partida en medio de esta
 * @author LIL_LK
 *
 */
public class BotonGuardarPartida extends JLabel {
/**
 * Este es el constructor del boton Guardar en {@link JF_PanelPartidaPanel2 }
 * Guarda el estado de la partida en la BD
 * @param {@link JF_PanelPartidaPanel2 }
 */
	public BotonGuardarPartida(JF_PanelPartidaPanel2 panel) {
		Border borde = BorderFactory.createLineBorder(Color.BLACK, 3);
		this.setBounds((panel.getWidth()/2)-((panel.getWidth()-50)/2),((panel.getHeight()/16)*14),panel.getWidth()-50,panel.getHeight()/10);
		setIcon(cambiarImg.tamaño(new ImageIcon("botones/guardar_partida.png"),panel.getWidth()-50, panel.getHeight()/10));
		this.setBackground(Color.WHITE);
		this.setVisible(true);
		this.setBorder(borde);
		this.setOpaque(true);
		this.setText("guardar");
		
		addMouseListener((MouseListener) new MouseListener() {	
			public void mouseEntered(MouseEvent e) {
				setIcon(cambiarImg.tamaño(new ImageIcon("botones/guardar_partida_entered.png"),panel.getWidth()-50, panel.getHeight()/10));
			}
			public void mouseExited(MouseEvent a) {
				setIcon(cambiarImg.tamaño(new ImageIcon("botones/guardar_partida.png"),panel.getWidth()-50, panel.getHeight()/10));
			}
			public void mousePressed(MouseEvent i) {
			}
			public void mouseClicked(MouseEvent e) {
				ConexionBD.guardarPartida(false);
				JOptionPane.showMessageDialog(new JFrame(), "Partida Guardada !");
			}
			public void mouseReleased(MouseEvent e) {				
			}
		});
	
	
	}
	

}
