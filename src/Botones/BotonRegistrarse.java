//Mehdi Tahrat && David hola
package Botones;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

import Logico.ConexionBD;
import Pandemic.*;
/**
 * Esta classe define los contructores del Boton registrarse
 * Este registra una nueva cuenta si puede a la BD
 * @author DAME
 *
 */
public class BotonRegistrarse extends JLabel {

	
	/**
	 * Este es el cotructor del boton Registrarse desde {@link JF_PanelInicioSesion }
	 * Cambia al panel {@link JF_PanelRegistrarse}
	 * @param {@link JF_PanelInicioSesion }
	 */
	public BotonRegistrarse(JF_PanelInicioSesion JF_PanelInicioSesion) {
	
		setIcon(cambiarImg.tamanyo(new ImageIcon("botones/registrar.png"),((cambiarImg.screenSize.width / 12)), (cambiarImg.screenSize.width / 45)) );		
		addMouseListener((MouseListener) new MouseListener() {	
			public void mouseEntered(MouseEvent e) {
				setIcon(cambiarImg.tamanyo(new ImageIcon("botones/registrar-1.png"),((cambiarImg.screenSize.width / 12)), (cambiarImg.screenSize.width / 45)) );
			}
			public void mouseExited(MouseEvent a) {
				setIcon(cambiarImg.tamanyo(new ImageIcon("botones/registrar.png"),((cambiarImg.screenSize.width / 12)), (cambiarImg.screenSize.width / 45)) );
			}
			public void mousePressed(MouseEvent i) {
				setIcon(cambiarImg.tamanyo(new ImageIcon("botones/registrar-2.png"),((cambiarImg.screenSize.width / 12)), (cambiarImg.screenSize.width / 45)) );				
			}
			public void mouseClicked(MouseEvent e) {
				
				JF_PanelInicioSesion.irPanelRegistrarse();
			}
			public void mouseReleased(MouseEvent e) {				
			}
		});
	
	}
	
	/**
	 * Este es el cotructor del boton Registrarse desde {@link JF_PanelRegistrarse }
	 * Este registra una nueva cuenta si puede a la BD
	 * @param {@link JF_PanelRegistrarse }
	 */
	public BotonRegistrarse(JF_PanelRegistrarse JF_PanelRegistrarse) {

		

		setIcon(cambiarImg.tamanyo(new ImageIcon("botones/registrar.png"),((cambiarImg.screenSize.width / 12)), (cambiarImg.screenSize.width / 45)) );
		
		addMouseListener((MouseListener) new MouseListener() {	
			public void mouseEntered(MouseEvent e) {
				setIcon(cambiarImg.tamanyo(new ImageIcon("botones/registrar-1.png"),((cambiarImg.screenSize.width / 12)), (cambiarImg.screenSize.width / 45)) );
			}
			public void mouseExited(MouseEvent a) {
				setIcon(cambiarImg.tamanyo(new ImageIcon("botones/registrar.png"),((cambiarImg.screenSize.width / 12)), (cambiarImg.screenSize.width / 45)) );
			}

			public void mousePressed(MouseEvent i) {
				setIcon(cambiarImg.tamanyo(new ImageIcon("botones/registrar-2.png"),((cambiarImg.screenSize.width / 12)), (cambiarImg.screenSize.width / 45)) );
			}
			public void mouseClicked(MouseEvent e) {
				

				if(JF_PanelRegistrarse.getJTFContrasenya().equals(JF_PanelRegistrarse.getJTFRepContrasenya())) {
					if((ConexionBD.crearUsuario( JF_PanelRegistrarse.getJTFUsuario(), JF_PanelRegistrarse.getJTFContrasenya()))){
						JF_PanelInfo.NombreJ=JF_PanelRegistrarse.getJTFUsuario();
						JF_PanelRegistrarse.irMenu();
						ConexionBD.idJugador();
					}else {
						JOptionPane.showMessageDialog(new JFrame(), "El usuario ya existe" );
					}
				}else {
					JOptionPane.showMessageDialog(new JFrame(), "Contrasenyas Diferentes " );
				}
				
				

			}
			public void mouseReleased(MouseEvent e) {
				// TODO Apéndice de método generado automáticamente
				
			}
		});
	
	}
}
