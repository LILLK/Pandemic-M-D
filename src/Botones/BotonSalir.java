package Botones;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.*;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Pandemic.*;
/**
 * Esta classe define los constructores del boton salir
 * este sirve para cerrar el programa
 * @author LIL_LK
 *
 */
public class BotonSalir extends JLabel {
	
/**
 * Este es el contructor del boton salir,
 * sale del programa.
 */
	public BotonSalir() {
		
		cambiarImg img = new cambiarImg();
		
		setIcon(img.tamaño(new ImageIcon("botones/bottonSalir-1.png"), ((int)(cambiarImg.screenSize.getWidth()/5)), ((int)(cambiarImg.screenSize.getWidth()/20))) );
		addMouseListener(new MouseListener() {	
			public void mouseEntered(MouseEvent e) {
				setIcon(img.tamaño(new ImageIcon("botones/bottonSalir-2.png"), ((int)(cambiarImg.screenSize.getWidth()/5)), ((int)(cambiarImg.screenSize.getWidth()/20))) );
			}
			public void mouseExited(MouseEvent a) {
				setIcon(img.tamaño(new ImageIcon("botones/bottonSalir-1.png"), ((int)(cambiarImg.screenSize.getWidth()/5)), ((int)(cambiarImg.screenSize.getWidth()/20))) );
			}

			public void mousePressed(MouseEvent i) {
				setIcon(img.tamaño(new ImageIcon("botones/bottonSalir-3.png"), ((int)(cambiarImg.screenSize.getWidth()/5)), ((int)(cambiarImg.screenSize.getWidth()/20))) );
			}
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
			public void mouseReleased(MouseEvent e) {
				// TODO Apéndice de método generado automáticamente
				
			}
		});
	}
}