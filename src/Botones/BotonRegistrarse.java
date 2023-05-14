package Botones;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.*;

import Logico.ConexionBD;
import Pandemic.*;

public class BotonRegistrarse extends JLabel {

	cambiarImg img;
	
	static JF_PanelMenu JF_PanelMenu;
	
	public BotonRegistrarse(JF_PanelInicioSesion JF_PanelInicioSesion) {
		

		setIcon(img.tamaño(new ImageIcon("botones/registrar.png"),((cambiarImg.screenSize.width / 12)), (cambiarImg.screenSize.width / 45)) );
		
		addMouseListener((MouseListener) new MouseListener() {	
			public void mouseEntered(MouseEvent e) {
				setIcon(img.tamaño(new ImageIcon("botones/registrar-1.png"),((cambiarImg.screenSize.width / 12)), (cambiarImg.screenSize.width / 45)) );
			}
			public void mouseExited(MouseEvent a) {
				setIcon(img.tamaño(new ImageIcon("botones/registrar.png"),((cambiarImg.screenSize.width / 12)), (cambiarImg.screenSize.width / 45)) );

			}

			public void mousePressed(MouseEvent i) {
				setIcon(img.tamaño(new ImageIcon("botones/registrar-2.png"),((cambiarImg.screenSize.width / 12)), (cambiarImg.screenSize.width / 45)) );
				
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

		

		setIcon(img.tamaño(new ImageIcon("botones/registrar.png"),((cambiarImg.screenSize.width / 12)), (cambiarImg.screenSize.width / 45)) );
		
		addMouseListener((MouseListener) new MouseListener() {	
			public void mouseEntered(MouseEvent e) {
				setIcon(img.tamaño(new ImageIcon("botones/registrar-1.png"),((cambiarImg.screenSize.width / 12)), (cambiarImg.screenSize.width / 45)) );
			}
			public void mouseExited(MouseEvent a) {
				setIcon(img.tamaño(new ImageIcon("botones/registrar.png"),((cambiarImg.screenSize.width / 12)), (cambiarImg.screenSize.width / 45)) );
			}

			public void mousePressed(MouseEvent i) {
				setIcon(img.tamaño(new ImageIcon("botones/registrar-2.png"),((cambiarImg.screenSize.width / 12)), (cambiarImg.screenSize.width / 45)) );
			}
			public void mouseClicked(MouseEvent e) {
				

				if(JF_PanelRegistrarse.getJTFContraseña().equals(JF_PanelRegistrarse.getJTFRepContraseña())) {
					if((ConexionBD.crearUsuario(ConexionBD.con, JF_PanelRegistrarse.getJTFUsuario(), JF_PanelRegistrarse.getJTFContraseña()))){
						JF_PanelRegistrarse.irMenu();
						
					}else {
						JOptionPane.showMessageDialog(new JFrame(), "El usuario ya existe" );
					}
				}else {
					JOptionPane.showMessageDialog(new JFrame(), "Contraseñas Diferentes " );
				}
				
				

			}
			public void mouseReleased(MouseEvent e) {
				// TODO Apéndice de método generado automáticamente
				
			}
		});
	
	}


}
