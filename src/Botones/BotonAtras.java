package Botones;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import Logico.ConexionBD;
import Pandemic.*;

/**
 * Esta classe define los contructores del Boton Atras
 * El boton atras sirve para vuelver al ultimo panel
 * @author DAME
 *
 */

	public class BotonAtras extends JLabel {
			
		/**
			 * Contructor del boton atras en {@link JF_PanelAutores}
			 * @param {@link JF_PanelAutores} 
			 * @author DAME
			 * 
			 */
		public BotonAtras(JF_PanelAutores JF_PanelAutores) {

			setIcon(cambiarImg.tamaño(new ImageIcon("botones/bottonAtras-1.png"), cambiarImg.screenSize.width, (cambiarImg.screenSize.width/30)) );		
					
			addMouseListener(new MouseListener() {	
				public void mouseEntered(MouseEvent e) {
					setIcon(cambiarImg.tamaño(new ImageIcon("botones/bottonAtras-2.png"), cambiarImg.screenSize.width, (cambiarImg.screenSize.width/30)) );
				}
				public void mouseExited(MouseEvent a) {
					setIcon(cambiarImg.tamaño(new ImageIcon("botones/bottonAtras-1.png"), cambiarImg.screenSize.width, (cambiarImg.screenSize.width/30)) );
				}

				public void mousePressed(MouseEvent i) {
					setIcon(cambiarImg.tamaño(new ImageIcon("botones/bottonAtras-3.png"), cambiarImg.screenSize.width, (cambiarImg.screenSize.width/30)) );
				}
				public void mouseClicked(MouseEvent e) {
					JF_PanelAutores.irMenu();
				}
				public void mouseReleased(MouseEvent e) {
					// TODO Apéndice de método generado automáticamente
					
				}
			});
		}

		/**
		 * Contructor del boton atras en {@link JF_PanelInfo }
		 * @param {@link JF_PanelInfo }
		 * @author DAME
		 */
		public BotonAtras(JF_PanelInfo JF_PanelInfo) {
			
			

			setIcon(cambiarImg.tamaño(new ImageIcon("botones/bottonAtras-1.png"), cambiarImg.screenSize.width, (cambiarImg.screenSize.width/30)) );
			
			addMouseListener(new MouseListener() {	
				public void mouseEntered(MouseEvent e) {
					setIcon(cambiarImg.tamaño(new ImageIcon("botones/bottonAtras-2.png"), cambiarImg.screenSize.width, (cambiarImg.screenSize.width/30)) );
				}
				public void mouseExited(MouseEvent a) {
					setIcon(cambiarImg.tamaño(new ImageIcon("botones/bottonAtras-1.png"), cambiarImg.screenSize.width, (cambiarImg.screenSize.width/30)) );
				}

				public void mousePressed(MouseEvent i) {
					setIcon(cambiarImg.tamaño(new ImageIcon("botones/bottonAtras-3.png"), cambiarImg.screenSize.width, (cambiarImg.screenSize.width/30)) );
				}
				public void mouseClicked(MouseEvent e) {
					JF_PanelInfo.irMenu();					
				}
				public void mouseReleased(MouseEvent e) {
					// TODO Apéndice de método generado automáticamente
					
				}
			});
		}

		/**
		 * Contructor del boton atras en {@link JF_PanelVersion }
		 * @param {@link JF_PanelVersion }
		 * @author DAME
		 */
		public BotonAtras(JF_PanelVersion JF_PanelVersion) {
		
			

			setIcon(cambiarImg.tamaño(new ImageIcon("botones/bottonAtras-1.png"), cambiarImg.screenSize.width, (cambiarImg.screenSize.width/30)) );
			
			addMouseListener(new MouseListener() {	
				public void mouseEntered(MouseEvent e) {
					setIcon(cambiarImg.tamaño(new ImageIcon("botones/bottonAtras-2.png"), cambiarImg.screenSize.width, (cambiarImg.screenSize.width/30)) );
				}
				public void mouseExited(MouseEvent a) {
					setIcon(cambiarImg.tamaño(new ImageIcon("botones/bottonAtras-1.png"), cambiarImg.screenSize.width, (cambiarImg.screenSize.width/30)) );
				}

				public void mousePressed(MouseEvent i) {
					setIcon(cambiarImg.tamaño(new ImageIcon("botones/bottonAtras-3.png"), cambiarImg.screenSize.width, (cambiarImg.screenSize.width/30)) );
				}
				public void mouseClicked(MouseEvent e) {
					
					JF_PanelVersion.irMenu();
				}
				public void mouseReleased(MouseEvent e) {
					// TODO Apéndice de método generado automáticamente
					
				}
			});
		}
		
		/**
		 * Contructor del boton atras en {@link JF_PanelPuntuaciones }
		 * @param {@link JF_PanelPuntuaciones }
		 * @author DAME
		 */
		public BotonAtras(JF_PanelPuntuaciones JF_PanelPuntuaciones) {
		setIcon(cambiarImg.tamaño(new ImageIcon("botones/bottonAtras-1.png"), cambiarImg.screenSize.width, (cambiarImg.screenSize.width/30)) );
			
			addMouseListener(new MouseListener() {	
				public void mouseEntered(MouseEvent e) {
					setIcon(cambiarImg.tamaño(new ImageIcon("botones/bottonAtras-2.png"), cambiarImg.screenSize.width, (cambiarImg.screenSize.width/30)) );
				}
				public void mouseExited(MouseEvent a) {
					setIcon(cambiarImg.tamaño(new ImageIcon("botones/bottonAtras-1.png"), cambiarImg.screenSize.width, (cambiarImg.screenSize.width/30)) );
				}

				public void mousePressed(MouseEvent i) {
					setIcon(cambiarImg.tamaño(new ImageIcon("botones/bottonAtras-3.png"), cambiarImg.screenSize.width, (cambiarImg.screenSize.width/30)) );
				}
				public void mouseClicked(MouseEvent e) {
					
					JF_PanelPuntuaciones.irMenu();
				}
				public void mouseReleased(MouseEvent e) {
					// TODO Apéndice de método generado automáticamente
					
				}
			});
		}

		/**
		 * Contructor del boton atras en {@link JF_PanelCargarPartida }
		 * @param {@link JF_PanelCargarPartida }
		 * @author DAME
		 */
		public BotonAtras(JF_PanelCargarPartida JF_PanelCargarPartida) {
			

			setIcon(cambiarImg.tamaño(new ImageIcon("botones/bottonAtras-1.png"), cambiarImg.screenSize.width, (cambiarImg.screenSize.width/30)) );
			
			addMouseListener(new MouseListener() {	
				public void mouseEntered(MouseEvent e) {
					setIcon(cambiarImg.tamaño(new ImageIcon("botones/bottonAtras-2.png"), cambiarImg.screenSize.width, (cambiarImg.screenSize.width/30)) );
				}
				public void mouseExited(MouseEvent a) {
					setIcon(cambiarImg.tamaño(new ImageIcon("botones/bottonAtras-1.png"), cambiarImg.screenSize.width, (cambiarImg.screenSize.width/30)) );
				}

				public void mousePressed(MouseEvent i) {
					setIcon(cambiarImg.tamaño(new ImageIcon("botones/bottonAtras-3.png"), cambiarImg.screenSize.width, (cambiarImg.screenSize.width/30)) );
				}
				public void mouseClicked(MouseEvent e) {
					
					JF_PanelCargarPartida.irMenu();
				}
				public void mouseReleased(MouseEvent e) {
					// TODO Apéndice de método generado automáticamente
					
				}
			});
		}
		
		/**
		 * Contructor del boton atras en {@link JF_PanelPartidaDificultad }
		 * @param {@link JF_PanelPartidaDificultad }
		 * @author DAME
		 */
		public BotonAtras(JF_PanelPartidaDificultad panel) {
			

			setIcon(cambiarImg.tamaño(new ImageIcon("botones/bottonAtras-1.png"), cambiarImg.screenSize.width, (cambiarImg.screenSize.width/30)) );
			
			addMouseListener(new MouseListener() {	
				public void mouseEntered(MouseEvent e) {
					setIcon(cambiarImg.tamaño(new ImageIcon("botones/bottonAtras-2.png"), cambiarImg.screenSize.width, (cambiarImg.screenSize.width/30)) );
				}
				public void mouseExited(MouseEvent a) {
					setIcon(cambiarImg.tamaño(new ImageIcon("botones/bottonAtras-1.png"), cambiarImg.screenSize.width, (cambiarImg.screenSize.width/30)) );
				}

				public void mousePressed(MouseEvent i) {
					setIcon(cambiarImg.tamaño(new ImageIcon("botones/bottonAtras-3.png"), cambiarImg.screenSize.width, (cambiarImg.screenSize.width/30)) );
				}
				public void mouseClicked(MouseEvent e) {
					
					panel.irMenu();
				}
				public void mouseReleased(MouseEvent e) {
					// TODO Apéndice de método generado automáticamente
					
				}
			});
		
			
		}

		/**
		 * Contructor del boton atras en {@link JF_PanelPartida }
		 * @param {@link JF_PanelPartida }
		 * @author DAME
		 */
		public BotonAtras(JF_PanelPartida panel) {
			

			
			addMouseListener(new MouseListener() {	
				public void mouseEntered(MouseEvent e) {
					setIcon(cambiarImg.tamaño(new ImageIcon("botones/salir_partida_entered.png"), 50, 50) );
				}
				public void mouseExited(MouseEvent a) {
					setIcon(cambiarImg.tamaño(new ImageIcon("botones/salir_partida.png"), 50, 50) );
				}

				public void mousePressed(MouseEvent i) {
				}
				public void mouseClicked(MouseEvent e) {
					
					panel.irMenu();
				}
				public void mouseReleased(MouseEvent e) {
					// TODO Apéndice de método generado automáticamente
					
				}
			});
		
			
		}

		


	}

