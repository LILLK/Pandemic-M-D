package Botones;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import Pandemic.*;

public class BotonRegistrarse extends JLabel {

	Dimension  screenSize;
	cambiarImg img;
	
	static JF_PanelMenu JF_PanelMenu;
	
	public BotonRegistrarse(JF_PanelInicioSesion JF_PanelInicioSesion) {
		this.screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		

		setIcon(img.tamaño(new ImageIcon("botones/registrar.png"),(this.screenSize.width / 7)/2, (this.screenSize.width / 55)) );
		
		addMouseListener((MouseListener) new MouseListener() {	
			public void mouseEntered(MouseEvent e) {
			}
			public void mouseExited(MouseEvent a) {
			}

			public void mousePressed(MouseEvent i) {
				
			}
			public void mouseClicked(MouseEvent e) {
				JF_PanelInicioSesion.irPanelRegistrarse();
			}
			public void mouseReleased(MouseEvent e) {
				// TODO Apéndice de método generado automáticamente
				
			}
		});
	
	}
	
	public BotonRegistrarse(JF_PanelRegistrarse JF_PanelRegistrarse) {
		this.screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		

		setIcon(img.tamaño(new ImageIcon("botones/registrar.png"),(this.screenSize.width / 7)/2, (this.screenSize.width / 55)) );
		
		addMouseListener((MouseListener) new MouseListener() {	
			public void mouseEntered(MouseEvent e) {
			}
			public void mouseExited(MouseEvent a) {
			}

			public void mousePressed(MouseEvent i) {
				
			}
			public void mouseClicked(MouseEvent e) {
				System.out.println(JF_PanelRegistrarse.getJTFUsuario());
				System.out.println(JF_PanelRegistrarse.getJTFContraseña());
				JF_PanelRegistrarse.irMenu();

			}
			public void mouseReleased(MouseEvent e) {
				// TODO Apéndice de método generado automáticamente
				
			}
		});
	
	}

}
