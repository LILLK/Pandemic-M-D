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

public class BotonIniciarSesion extends JLabel {

	cambiarImg img;
	
	static JF_PanelMenu JF_PanelMenu;
	
	public BotonIniciarSesion(JF_PanelInicioSesion JF_PanelInicioSesion) {
		
		

		setIcon(img.tamaño(new ImageIcon("botones/iniciar sesion.png"),(cambiarImg.screenSize.width / 7)/2, (cambiarImg.screenSize.width / 55)) );
		
		addMouseListener((MouseListener) new MouseListener() {	
			public void mouseEntered(MouseEvent e) {
				setIcon(img.tamaño(new ImageIcon("botones/iniciar sesion-1.png"),(cambiarImg.screenSize.width / 7)/2, (cambiarImg.screenSize.width / 55)) );

			}
			public void mouseExited(MouseEvent a) {
				setIcon(img.tamaño(new ImageIcon("botones/iniciar sesion.png"),(cambiarImg.screenSize.width / 7)/2, (cambiarImg.screenSize.width / 55)) );
			}

			public void mousePressed(MouseEvent i) {
				setIcon(img.tamaño(new ImageIcon("botones/iniciar sesion-2.png"),(cambiarImg.screenSize.width / 7)/2, (cambiarImg.screenSize.width / 55)) );

			}
			public void mouseClicked(MouseEvent e) {
				Connection con = ConexionBD.conectarBaseDatos();
				
				if(ConexionBD.existeUsuario(con, JF_PanelInicioSesion.getJTFUsuario(), JF_PanelInicioSesion.getJTFContraseña())) {
					JF_PanelInicioSesion.irMenu();
				}else {
					JF_PanelInicioSesion.usuContError();
				}
			}
			public void mouseReleased(MouseEvent e) {
				// TODO Apéndice de método generado automáticamente
				
			}
		});
	
	}
	
	public BotonIniciarSesion(JF_PanelRegistrarse JF_PanelRegistrarse) {
		

		setIcon(img.tamaño(new ImageIcon("botones/iniciar sesion.png"),(cambiarImg.screenSize.width / 7)/2, (cambiarImg.screenSize.width / 55)) );
		
		addMouseListener((MouseListener) new MouseListener() {	
			public void mouseEntered(MouseEvent e) {
			}
			public void mouseExited(MouseEvent a) {
			}

			public void mousePressed(MouseEvent i) {
				
			}
			public void mouseClicked(MouseEvent e) {

				JF_PanelRegistrarse.irPanelIniciarSesion();

			}
			public void mouseReleased(MouseEvent e) {
				// TODO Apéndice de método generado automáticamente
				
			}
		});
	
	}
	
}
