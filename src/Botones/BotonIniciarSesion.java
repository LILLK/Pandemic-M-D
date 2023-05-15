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


/**
 * Esta classe define los contructores del Boton Iniciar sesion
 * Inicia la sesion y da paso al menu 
 * @author DAME
 *
 */
public class BotonIniciarSesion extends JLabel {


	/**
	 * Este es el constructor del Boton Iniciar sesion en {@link JF_PanelInicioSesion}
	 * @param {@link JF_PanelInicioSesion}
	 */
	public BotonIniciarSesion(JF_PanelInicioSesion JF_PanelInicioSesion) {
		
		

		setIcon(cambiarImg.tamaño(new ImageIcon("botones/iniciar sesion.png"),((cambiarImg.screenSize.width / 12)), (cambiarImg.screenSize.width / 45)) );
		
		addMouseListener((MouseListener) new MouseListener() {	
			public void mouseEntered(MouseEvent e) {
				setIcon(cambiarImg.tamaño(new ImageIcon("botones/iniciar sesion-1.png"),((cambiarImg.screenSize.width / 12)), (cambiarImg.screenSize.width / 45)) );

			}
			public void mouseExited(MouseEvent a) {
				setIcon(cambiarImg.tamaño(new ImageIcon("botones/iniciar sesion.png"),((cambiarImg.screenSize.width / 12)), (cambiarImg.screenSize.width / 45)) );
			}

			public void mousePressed(MouseEvent i) {
				setIcon(cambiarImg.tamaño(new ImageIcon("botones/iniciar sesion-2.png"),((cambiarImg.screenSize.width / 12)), (cambiarImg.screenSize.width / 45)) );

			}
			public void mouseClicked(MouseEvent e) {

				
				if(ConexionBD.existeUsuario(ConexionBD.con, JF_PanelInicioSesion.getJTFUsuario(), JF_PanelInicioSesion.getJTFContraseña())) {
					JF_PanelInicioSesion.irMenu();
				}else {
					JOptionPane.showMessageDialog(new JFrame(), "Nombre o constraseña erroneos " );
				}
			}
			public void mouseReleased(MouseEvent e) {
				// TODO Apéndice de método generado automáticamente
				
			}
		});
	
	}
	/**
	 * Este es el constructor del Boton Iniciar sesion en {@link JF_PanelRegistrarse}
	 * @param {@link JF_PanelRegistrarse}
	 */
	public BotonIniciarSesion(JF_PanelRegistrarse JF_PanelRegistrarse) {
		

		setIcon(cambiarImg.tamaño(new ImageIcon("botones/iniciar sesion.png"),((cambiarImg.screenSize.width / 12)), (cambiarImg.screenSize.width / 45)) );
		
		addMouseListener((MouseListener) new MouseListener() {	
			public void mouseEntered(MouseEvent e) {
				setIcon(cambiarImg.tamaño(new ImageIcon("botones/iniciar sesion-1.png"),((cambiarImg.screenSize.width / 12)), (cambiarImg.screenSize.width / 45)) );

			}
			public void mouseExited(MouseEvent a) {
				setIcon(cambiarImg.tamaño(new ImageIcon("botones/iniciar sesion.png"),((cambiarImg.screenSize.width / 12)), (cambiarImg.screenSize.width / 45)) );

			}

			public void mousePressed(MouseEvent i) {
				setIcon(cambiarImg.tamaño(new ImageIcon("botones/iniciar sesion-2.png"),((cambiarImg.screenSize.width / 12)), (cambiarImg.screenSize.width / 45)) );
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
