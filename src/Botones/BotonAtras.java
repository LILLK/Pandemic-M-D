//Mehdi Tahrat && David hola
package Botones;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
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
			 * @param JF_PanelAutores {@link JF_PanelAutores} 
			 * 
			 */
		public BotonAtras(JF_PanelAutores JF_PanelAutores) {
			setIcon(cambiarImg.tamanyo(new ImageIcon("botones/bottonAtras-1.png"), cambiarImg.screenSize.width, (cambiarImg.screenSize.width/30)) );			
			/**
			 * Listener con funcion de cambiar icono al hacer hoover, y ir al menu
			 */
			addMouseListener(new MouseListener() {	
				public void mouseEntered(MouseEvent e) {
					setIcon(cambiarImg.tamanyo(new ImageIcon("botones/bottonAtras-2.png"), cambiarImg.screenSize.width, (cambiarImg.screenSize.width/30)) );
				}
				public void mouseExited(MouseEvent a) {
					setIcon(cambiarImg.tamanyo(new ImageIcon("botones/bottonAtras-1.png"), cambiarImg.screenSize.width, (cambiarImg.screenSize.width/30)) );
				}

				public void mousePressed(MouseEvent i) {
					setIcon(cambiarImg.tamanyo(new ImageIcon("botones/bottonAtras-3.png"), cambiarImg.screenSize.width, (cambiarImg.screenSize.width/30)) );
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
		 * @param JF_PanelInfo {@link JF_PanelInfo }
		 */
		public BotonAtras(JF_PanelInfo JF_PanelInfo) {
			
			

			setIcon(cambiarImg.tamanyo(new ImageIcon("botones/bottonAtras-1.png"), cambiarImg.screenSize.width, (cambiarImg.screenSize.width/30)) );
			
			addMouseListener(new MouseListener() {	
				public void mouseEntered(MouseEvent e) {
					setIcon(cambiarImg.tamanyo(new ImageIcon("botones/bottonAtras-2.png"), cambiarImg.screenSize.width, (cambiarImg.screenSize.width/30)) );
				}
				public void mouseExited(MouseEvent a) {
					setIcon(cambiarImg.tamanyo(new ImageIcon("botones/bottonAtras-1.png"), cambiarImg.screenSize.width, (cambiarImg.screenSize.width/30)) );
				}

				public void mousePressed(MouseEvent i) {
					setIcon(cambiarImg.tamanyo(new ImageIcon("botones/bottonAtras-3.png"), cambiarImg.screenSize.width, (cambiarImg.screenSize.width/30)) );
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
		 * @param  JF_PanelVersion {@link JF_PanelVersion }
		 */
		public BotonAtras(JF_PanelVersion JF_PanelVersion) {
		
			

			setIcon(cambiarImg.tamanyo(new ImageIcon("botones/bottonAtras-1.png"), cambiarImg.screenSize.width, (cambiarImg.screenSize.width/30)) );
			
			addMouseListener(new MouseListener() {	
				public void mouseEntered(MouseEvent e) {
					setIcon(cambiarImg.tamanyo(new ImageIcon("botones/bottonAtras-2.png"), cambiarImg.screenSize.width, (cambiarImg.screenSize.width/30)) );
				}
				public void mouseExited(MouseEvent a) {
					setIcon(cambiarImg.tamanyo(new ImageIcon("botones/bottonAtras-1.png"), cambiarImg.screenSize.width, (cambiarImg.screenSize.width/30)) );
				}

				public void mousePressed(MouseEvent i) {
					setIcon(cambiarImg.tamanyo(new ImageIcon("botones/bottonAtras-3.png"), cambiarImg.screenSize.width, (cambiarImg.screenSize.width/30)) );
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
		 * @param JF_PanelPuntuaciones {@link JF_PanelPuntuaciones }
		 */
		public BotonAtras(JF_PanelPuntuaciones JF_PanelPuntuaciones) {
		setIcon(cambiarImg.tamanyo(new ImageIcon("botones/bottonAtras-1.png"), cambiarImg.screenSize.width, (cambiarImg.screenSize.width/30)) );
			
			addMouseListener(new MouseListener() {	
				public void mouseEntered(MouseEvent e) {
					setIcon(cambiarImg.tamanyo(new ImageIcon("botones/bottonAtras-2.png"), cambiarImg.screenSize.width, (cambiarImg.screenSize.width/30)) );
				}
				public void mouseExited(MouseEvent a) {
					setIcon(cambiarImg.tamanyo(new ImageIcon("botones/bottonAtras-1.png"), cambiarImg.screenSize.width, (cambiarImg.screenSize.width/30)) );
				}

				public void mousePressed(MouseEvent i) {
					setIcon(cambiarImg.tamanyo(new ImageIcon("botones/bottonAtras-3.png"), cambiarImg.screenSize.width, (cambiarImg.screenSize.width/30)) );
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
		 * @param JF_PanelCargarPartida {@link JF_PanelCargarPartida }
		 */
		public BotonAtras(JF_PanelCargarPartida JF_PanelCargarPartida) {
			

			setIcon(cambiarImg.tamanyo(new ImageIcon("botones/bottonAtras-1.png"), cambiarImg.screenSize.width, (cambiarImg.screenSize.width/30)) );
			
			addMouseListener(new MouseListener() {	
				public void mouseEntered(MouseEvent e) {
					setIcon(cambiarImg.tamanyo(new ImageIcon("botones/bottonAtras-2.png"), cambiarImg.screenSize.width, (cambiarImg.screenSize.width/30)) );
				}
				public void mouseExited(MouseEvent a) {
					setIcon(cambiarImg.tamanyo(new ImageIcon("botones/bottonAtras-1.png"), cambiarImg.screenSize.width, (cambiarImg.screenSize.width/30)) );
				}

				public void mousePressed(MouseEvent i) {
					setIcon(cambiarImg.tamanyo(new ImageIcon("botones/bottonAtras-3.png"), cambiarImg.screenSize.width, (cambiarImg.screenSize.width/30)) );
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
		 * @param panel {@link JF_PanelPartidaDificultad }
		 */
		public BotonAtras(JF_PanelPartidaDificultad panel) {
			

			setIcon(cambiarImg.tamanyo(new ImageIcon("botones/bottonAtras-1.png"), cambiarImg.screenSize.width, (cambiarImg.screenSize.width/30)) );
			
			addMouseListener(new MouseListener() {	
				public void mouseEntered(MouseEvent e) {
					setIcon(cambiarImg.tamanyo(new ImageIcon("botones/bottonAtras-2.png"), cambiarImg.screenSize.width, (cambiarImg.screenSize.width/30)) );
				}
				public void mouseExited(MouseEvent a) {
					setIcon(cambiarImg.tamanyo(new ImageIcon("botones/bottonAtras-1.png"), cambiarImg.screenSize.width, (cambiarImg.screenSize.width/30)) );
				}

				public void mousePressed(MouseEvent i) {
					setIcon(cambiarImg.tamanyo(new ImageIcon("botones/bottonAtras-3.png"), cambiarImg.screenSize.width, (cambiarImg.screenSize.width/30)) );
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
		 * @param panel {@link JF_PanelPartida }
		 */
		public BotonAtras(JF_PanelPartida panel) {
			

			
			addMouseListener(new MouseListener() {	
				public void mouseEntered(MouseEvent e) {
					setIcon(cambiarImg.tamanyo(new ImageIcon("botones/salir_partida_entered.png"), 50, 50) );
				}
				public void mouseExited(MouseEvent a) {
					setIcon(cambiarImg.tamanyo(new ImageIcon("botones/salir_partida.png"), 50, 50) );
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

