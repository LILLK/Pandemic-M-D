package Botones;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Pandemic.cambiarImg;

public class BotonCargar extends JLabel {
	
	public int idP;
	Dimension screenSize = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
	
	public BotonCargar(int idP) {
		
		this.idP= idP;
		
		setIcon(cambiarImg.tamaño(new ImageIcon("botones/bottonInformacion-1.png"), ((int)(screenSize.getWidth()/5)), ((int)(screenSize.getWidth()/20))) );

		addMouseListener(new MouseListener() {	
			public void mouseEntered(MouseEvent e) {
				setIcon(cambiarImg.tamaño(new ImageIcon("botones/bottonInformacion-2.png"), ((int)(screenSize.getWidth()/5)), ((int)(screenSize.getWidth()/20))) );
			}
			public void mouseExited(MouseEvent a) {
				setIcon(cambiarImg.tamaño(new ImageIcon("botones/bottonInformacion-1.png"), ((int)(screenSize.getWidth()/5)), ((int)(screenSize.getWidth()/20))) );
			}

			public void mousePressed(MouseEvent i) {
				setIcon(cambiarImg.tamaño(new ImageIcon("botones/bottonInformacion-3.png"), ((int)(screenSize.getWidth()/5)), ((int)(screenSize.getWidth()/20))) );
			}
			public void mouseClicked(MouseEvent e) {
				//JF_PanelMenu.irPanelInformacion();
			}
			public void mouseReleased(MouseEvent e) {
				// TODO Apéndice de método generado automáticamente
				
			}
		});
	}
	public int getBrotes() {
		return idP;
	}
	public void setBrotes(int idP) {
		this.idP = idP;
	}
}
