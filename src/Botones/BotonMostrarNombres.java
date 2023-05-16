package Botones;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Pandemic.cambiarImg;


/**
 * Esta classe define los contructores del boton mostrar nombres
 * muestra la etiqueta de todas las ciudades
 
 * @author DAME
 *
 */
public class BotonMostrarNombres extends JLabel  {
	/**
	 * 	tamañoX=150
	 */
	public int tamañoX=150;
	/**
	 * tamañoY=100
	 */
	public int tamañoY=100;
	/**
	 * Constructor del boton mostrar nombres
	 * muestra la etiqueta de todas las ciudades
	 */
	public BotonMostrarNombres(){
		
		setIcon(cambiarImg.tamanyo(new ImageIcon("botones/ojo_cerrado.png"), tamañoX, tamañoY));
		this.setOpaque(false);
		this.setBounds(40, 650, tamañoX, tamañoY);
		
		addMouseListener((MouseListener) new MouseListener() {
			public void mouseReleased(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}			
			public void mouseExited(MouseEvent e) {
				setIcon(cambiarImg.tamanyo(new ImageIcon("botones/ojo_cerrado.png"), tamañoX, tamañoY));
				BotonCiudad.ocultarNombres();
			}			
			public void mouseEntered(MouseEvent e) {
				setIcon(cambiarImg.tamanyo(new ImageIcon("botones/ojo_abierto.png"), tamañoX, tamañoY));
				BotonCiudad.mostrarNombres();

			}			
			public void mouseClicked(MouseEvent e) {}
		});
	}

}
