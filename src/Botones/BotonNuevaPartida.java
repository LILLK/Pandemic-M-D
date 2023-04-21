package Botones;
import java.awt.event.*;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Pandemic.*;

public class BotonNuevaPartida extends JLabel implements MouseMotionListener{
	
	
	public BotonNuevaPartida() {
		
		setIcon(new ImageIcon("botones/bottonNuevaPartida-1.png"));
		
		/*addMouseListener(new MouseAdapter() {
			public void mouseExited(MouseEvent e) {
				setIcon(new ImageIcon("botones/bottonNuevaPartida-1.png"));
			}
			public void mouseEntred(MouseEvent e) {
				setIcon(new ImageIcon("botones/bottonNuevaPartida-0.png"));
			}

			public void mousePressed(MouseEvent e) {
				setIcon(new ImageIcon("botones/bottonNuevaPartida-2.png"));
			}

		});*/
		
		/*addComponentListener((ComponentListener) new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Apéndice de método generado automáticamente
				
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				setIcon(new ImageIcon("botones/bottonNuevaPartida-0.png"));				
			}
			public void mousePressed(MouseEvent e) {
				setIcon(new ImageIcon("botones/bottonNuevaPartida-2.png"));
			}
			public void mouseExited(MouseEvent e) {
				setIcon(new ImageIcon("botones/bottonNuevaPartida-1.png"));
			}
		});*/
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Apéndice de método generado automáticamente
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Apéndice de método generado automáticamente
		setIcon(new ImageIcon("botones/bottonNuevaPartida-0.png"));				

	}
	
}
