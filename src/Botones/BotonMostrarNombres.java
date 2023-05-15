package Botones;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;

import Pandemic.cambiarImg;
/**
 * Esta classe define los contructores del boton mostrar nombres
 * muestra la etiqueta de todas las ciudades
 * @author LIL_LK
 *
 */
public class BotonMostrarNombres extends JLabel  {
		int tamañoX=150;
		int tamañoY=100;
		cambiarImg img;
	/**
	 * Constructor del boton mostrar nombres
	 * muestra la etiqueta de todas las ciudades
	 */
	public BotonMostrarNombres(){
		
		setIcon(img.tamaño(new ImageIcon("botones/ojo_cerrado.png"), tamañoX, tamañoY));
		this.setOpaque(false);
		this.setBounds(40, 650, tamañoX, tamañoY);
		
		addMouseListener((MouseListener) new MouseListener() {
			public void mouseReleased(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}			
			public void mouseExited(MouseEvent e) {
				setIcon(img.tamaño(new ImageIcon("botones/ojo_cerrado.png"), tamañoX, tamañoY));
				BotonCiudad.ocultarNombres();
			}			
			public void mouseEntered(MouseEvent e) {
				setIcon(img.tamaño(new ImageIcon("botones/ojo_abierto.png"), tamañoX, tamañoY));
				BotonCiudad.mostrarNombres();

			}			
			public void mouseClicked(MouseEvent e) {}
		});
	}

}
