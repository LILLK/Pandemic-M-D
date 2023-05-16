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
	 * 	tamanyoX=150
	 */
	public int tamanyoX=150;
	/**
	 * tamanyoY=100
	 */
	public int tamanyoY=100;
	/**
	 * Constructor del boton mostrar nombres
	 * muestra la etiqueta de todas las ciudades
	 */
	public BotonMostrarNombres(){
		
		setIcon(cambiarImg.tamanyo(new ImageIcon("botones/ojo_cerrado.png"), tamanyoX, tamanyoY));
		this.setOpaque(false);
		this.setBounds(40, 650, tamanyoX, tamanyoY);
		
		addMouseListener((MouseListener) new MouseListener() {
			public void mouseReleased(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}			
			public void mouseExited(MouseEvent e) {
				setIcon(cambiarImg.tamanyo(new ImageIcon("botones/ojo_cerrado.png"), tamanyoX, tamanyoY));
				BotonCiudad.ocultarNombres();
			}			
			public void mouseEntered(MouseEvent e) {
				setIcon(cambiarImg.tamanyo(new ImageIcon("botones/ojo_abierto.png"), tamanyoX, tamanyoY));
				BotonCiudad.mostrarNombres();

			}			
			public void mouseClicked(MouseEvent e) {}
		});
	}

}
