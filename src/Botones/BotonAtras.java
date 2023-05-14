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


	public class BotonAtras extends JLabel {
		
		cambiarImg img;
		
		static JF_PanelMenu JF_PanelMenu;
		
		public BotonAtras(JF_PanelAutores JF_PanelAutores) {
			
			
		
		
			

			setIcon(img.tamaño(new ImageIcon("botones/bottonAtras-1.png"), cambiarImg.screenSize.width, (cambiarImg.screenSize.width/30)) );
			
			
			
			
			addMouseListener(new MouseListener() {	
				public void mouseEntered(MouseEvent e) {
					setIcon(img.tamaño(new ImageIcon("botones/bottonAtras-2.png"), cambiarImg.screenSize.width, (cambiarImg.screenSize.width/30)) );
				}
				public void mouseExited(MouseEvent a) {
					setIcon(img.tamaño(new ImageIcon("botones/bottonAtras-1.png"), cambiarImg.screenSize.width, (cambiarImg.screenSize.width/30)) );
				}

				public void mousePressed(MouseEvent i) {
					setIcon(img.tamaño(new ImageIcon("botones/bottonAtras-3.png"), cambiarImg.screenSize.width, (cambiarImg.screenSize.width/30)) );
				}
				public void mouseClicked(MouseEvent e) {
					
					JF_PanelAutores.irMenu();
				}
				public void mouseReleased(MouseEvent e) {
					// TODO Apéndice de método generado automáticamente
					
				}
			});
		}

		public BotonAtras(JF_PanelInfo JF_PanelInfo) {
			
			

			setIcon(img.tamaño(new ImageIcon("botones/bottonAtras-1.png"), cambiarImg.screenSize.width, (cambiarImg.screenSize.width/30)) );
			
			addMouseListener(new MouseListener() {	
				public void mouseEntered(MouseEvent e) {
					setIcon(img.tamaño(new ImageIcon("botones/bottonAtras-2.png"), cambiarImg.screenSize.width, (cambiarImg.screenSize.width/30)) );
				}
				public void mouseExited(MouseEvent a) {
					setIcon(img.tamaño(new ImageIcon("botones/bottonAtras-1.png"), cambiarImg.screenSize.width, (cambiarImg.screenSize.width/30)) );
				}

				public void mousePressed(MouseEvent i) {
					setIcon(img.tamaño(new ImageIcon("botones/bottonAtras-3.png"), cambiarImg.screenSize.width, (cambiarImg.screenSize.width/30)) );
				}
				public void mouseClicked(MouseEvent e) {
					JF_PanelInfo.irMenu();					
				}
				public void mouseReleased(MouseEvent e) {
					// TODO Apéndice de método generado automáticamente
					
				}
			});
		}

		public BotonAtras(JF_PanelVersion JF_PanelVersion) {
		
			

			setIcon(img.tamaño(new ImageIcon("botones/bottonAtras-1.png"), cambiarImg.screenSize.width, (cambiarImg.screenSize.width/30)) );
			
			addMouseListener(new MouseListener() {	
				public void mouseEntered(MouseEvent e) {
					setIcon(img.tamaño(new ImageIcon("botones/bottonAtras-2.png"), cambiarImg.screenSize.width, (cambiarImg.screenSize.width/30)) );
				}
				public void mouseExited(MouseEvent a) {
					setIcon(img.tamaño(new ImageIcon("botones/bottonAtras-1.png"), cambiarImg.screenSize.width, (cambiarImg.screenSize.width/30)) );
				}

				public void mousePressed(MouseEvent i) {
					setIcon(img.tamaño(new ImageIcon("botones/bottonAtras-3.png"), cambiarImg.screenSize.width, (cambiarImg.screenSize.width/30)) );
				}
				public void mouseClicked(MouseEvent e) {
					
					JF_PanelVersion.irMenu();
				}
				public void mouseReleased(MouseEvent e) {
					// TODO Apéndice de método generado automáticamente
					
				}
			});
		}
		public BotonAtras(JF_PanelPuntuaciones JF_PanelPuntuaciones) {
			
			

			setIcon(img.tamaño(new ImageIcon("botones/bottonAtras-1.png"), cambiarImg.screenSize.width, (cambiarImg.screenSize.width/30)) );
			
			addMouseListener(new MouseListener() {	
				public void mouseEntered(MouseEvent e) {
					setIcon(img.tamaño(new ImageIcon("botones/bottonAtras-2.png"), cambiarImg.screenSize.width, (cambiarImg.screenSize.width/30)) );
				}
				public void mouseExited(MouseEvent a) {
					setIcon(img.tamaño(new ImageIcon("botones/bottonAtras-1.png"), cambiarImg.screenSize.width, (cambiarImg.screenSize.width/30)) );
				}

				public void mousePressed(MouseEvent i) {
					setIcon(img.tamaño(new ImageIcon("botones/bottonAtras-3.png"), cambiarImg.screenSize.width, (cambiarImg.screenSize.width/30)) );
				}
				public void mouseClicked(MouseEvent e) {
					
					JF_PanelPuntuaciones.irMenu();
				}
				public void mouseReleased(MouseEvent e) {
					// TODO Apéndice de método generado automáticamente
					
				}
			});
		}

		public BotonAtras(JF_PanelCargarPartida JF_PanelCargarPartida) {
			

			setIcon(img.tamaño(new ImageIcon("botones/bottonAtras-1.png"), cambiarImg.screenSize.width, (cambiarImg.screenSize.width/30)) );
			
			addMouseListener(new MouseListener() {	
				public void mouseEntered(MouseEvent e) {
					setIcon(img.tamaño(new ImageIcon("botones/bottonAtras-2.png"), cambiarImg.screenSize.width, (cambiarImg.screenSize.width/30)) );
				}
				public void mouseExited(MouseEvent a) {
					setIcon(img.tamaño(new ImageIcon("botones/bottonAtras-1.png"), cambiarImg.screenSize.width, (cambiarImg.screenSize.width/30)) );
				}

				public void mousePressed(MouseEvent i) {
					setIcon(img.tamaño(new ImageIcon("botones/bottonAtras-3.png"), cambiarImg.screenSize.width, (cambiarImg.screenSize.width/30)) );
				}
				public void mouseClicked(MouseEvent e) {
					
					JF_PanelCargarPartida.irMenu();
				}
				public void mouseReleased(MouseEvent e) {
					// TODO Apéndice de método generado automáticamente
					
				}
			});
		}
		
		public BotonAtras(JF_PanelPartidaDificultad panel) {
			

			setIcon(img.tamaño(new ImageIcon("botones/bottonAtras-1.png"), cambiarImg.screenSize.width, (cambiarImg.screenSize.width/30)) );
			
			addMouseListener(new MouseListener() {	
				public void mouseEntered(MouseEvent e) {
					setIcon(img.tamaño(new ImageIcon("botones/bottonAtras-2.png"), cambiarImg.screenSize.width, (cambiarImg.screenSize.width/30)) );
				}
				public void mouseExited(MouseEvent a) {
					setIcon(img.tamaño(new ImageIcon("botones/bottonAtras-1.png"), cambiarImg.screenSize.width, (cambiarImg.screenSize.width/30)) );
				}

				public void mousePressed(MouseEvent i) {
					setIcon(img.tamaño(new ImageIcon("botones/bottonAtras-3.png"), cambiarImg.screenSize.width, (cambiarImg.screenSize.width/30)) );
				}
				public void mouseClicked(MouseEvent e) {
					
					panel.irMenu();
				}
				public void mouseReleased(MouseEvent e) {
					// TODO Apéndice de método generado automáticamente
					
				}
			});
		
			
		}


		public BotonAtras(JF_PanelPartida panel) {
			

			
			addMouseListener(new MouseListener() {	
				public void mouseEntered(MouseEvent e) {
					setIcon(img.tamaño(new ImageIcon("botones/salir_partida_entered.png"), 50, 50) );
				}
				public void mouseExited(MouseEvent a) {
					setIcon(img.tamaño(new ImageIcon("botones/salir_partida.png"), 50, 50) );
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

