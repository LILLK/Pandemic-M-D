package Pandemic;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;

import Botones.*;
import Logico.Ciudades;
import Logico.Parametros;
import Logico.Partida;

public class JF_PanelPartidaDificultad extends JPanel {

	Dimension screenSize;
	int dificultad;

	public JF_PanelPartidaDificultad() {
		cambiarImg img = new cambiarImg();
		screenSize = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
		setLayout(null);
		
		JLabel normal = new JLabel();
		
		normal.addMouseListener(new MouseListener() {	
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent a) {}
			public void mousePressed(MouseEvent i) {}
			public void mouseClicked(MouseEvent e) {
				dificultad = 1;
				irPanelPartida();

			}
			public void mouseReleased(MouseEvent e) {}
		});	
		
		JLabel facil = new JLabel();
		facil.addMouseListener(new MouseListener() {	
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent a) {}
			public void mousePressed(MouseEvent i) {}
			public void mouseClicked(MouseEvent e) {
				dificultad = 0;
				irPanelPartida();

			}
			public void mouseReleased(MouseEvent e) {}
		});
		
		
		JLabel dificil = new JLabel();
		dificil.addMouseListener(new MouseListener() {	
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent a) {}
			public void mousePressed(MouseEvent i) {}
			public void mouseClicked(MouseEvent e) {
				dificultad = 2;
				irPanelPartida();
			}
			public void mouseReleased(MouseEvent e) {}
		});
		
		
	}

	public void paint(Graphics g) {
		BufferedImage imgFondo;
		try {
			Dimension size = getSize();
			imgFondo = ImageIO.read(new File("imagenes/white.png"));
			g.drawImage(imgFondo, 0, 0, size.width, size.height, null);
			setOpaque(false);
			super.paint(g);
		} catch (IOException e) {
			System.out.print("Error IMGfondo JF_PanelInicio");
		}

	}
	
	public void irPanelPartida() {
		Partida.iniciarNuevaPartida(dificultad);
		JFrame marcoP = (JFrame)SwingUtilities.getWindowAncestor(this);	
		marcoP.remove(this);
		marcoP.add(new JF_PanelPartida());
		marcoP.setVisible(true); 
	}
}