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

	Dimension  screenSize;
	cambiarImg img;
	
	static JF_PanelMenu JF_PanelMenu;
	private static final String USER = "DAW_PNDC22_23_DAME";
	private static final String PWD = "DM123";
	// Si estáis desde casa, la url será oracle.ilerna.com y no 192.168.3.26
	private static final String URL = "jdbc:oracle:thin:@oracle.ilerna.com:1521:xe";
	
	public BotonIniciarSesion(JF_PanelInicioSesion JF_PanelInicioSesion) {
		this.screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		
		

		setIcon(img.tamaño(new ImageIcon("botones/iniciar sesion.png"),(this.screenSize.width / 7)/2, (this.screenSize.width / 55)) );
		
		addMouseListener((MouseListener) new MouseListener() {	
			public void mouseEntered(MouseEvent e) {
			}
			public void mouseExited(MouseEvent a) {
			}

			public void mousePressed(MouseEvent i) {
				
			}
			public void mouseClicked(MouseEvent e) {
				Connection con = conectarBaseDatos();
				
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
		this.screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		

		setIcon(img.tamaño(new ImageIcon("botones/iniciar sesion.png"),(this.screenSize.width / 7)/2, (this.screenSize.width / 55)) );
		
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
	private static Connection conectarBaseDatos() {
		Connection con = null;

		System.out.println("Intentando conectarse a la base de datos");

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(URL, USER, PWD);
			System.out.println("Conectados a la base de datos");
		} catch (ClassNotFoundException e) {
			System.out.println("No se ha encontrado el driver " + e);
		} catch (SQLException e) {
			System.out.println("Error en las credenciales o en la URL " + e);
		}
		

		//System.out.println("Conectados a la base de datos");

		return con;
	}

}
