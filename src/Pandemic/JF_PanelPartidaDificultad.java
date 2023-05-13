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
	BotonAtras Atras;


	public JF_PanelPartidaDificultad() {
		cambiarImg img = new cambiarImg();
		screenSize = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
		setLayout(null);
		
		JLabel normal = new JLabel();
		JLabel facil = new JLabel();
		JLabel dificil = new JLabel();
		Atras = new BotonAtras(this);


		normal.setBounds(((this.screenSize.width/2)-(this.screenSize.width/10)),(this.screenSize.height/6),(this.screenSize.width/5),(this.screenSize.width/20));
		normal.setIcon(img.tamaño(new ImageIcon("botones/BottonDif_normal-1.png"), ((int)(screenSize.getWidth()/5)), ((int)(screenSize.getWidth()/20))));
		normal.addMouseListener(new MouseListener() {	
			public void mouseEntered(MouseEvent e) {
				normal.setIcon(img.tamaño(new ImageIcon("botones/BottonDif_normal-2.png"), ((int)(screenSize.getWidth()/5)), ((int)(screenSize.getWidth()/20))));
			}
			public void mouseExited(MouseEvent a) {
				normal.setIcon(img.tamaño(new ImageIcon("botones/BottonDif_normal-1.png"), ((int)(screenSize.getWidth()/5)), ((int)(screenSize.getWidth()/20))));
			}
			public void mousePressed(MouseEvent i) {}
			public void mouseClicked(MouseEvent e) {
				dificultad = 1;
				irPanelPartida();

			}
			public void mouseReleased(MouseEvent e) {}
		});	
		
		
		facil.setText("facil");
		facil.setBounds(((this.screenSize.width/2)-(this.screenSize.width/10)),((this.screenSize.height/6)+(this.screenSize.width/18)),(this.screenSize.width/5),(this.screenSize.width/20));
		facil.setIcon(img.tamaño(new ImageIcon("botones/BottonDif_facil-1.png"), ((int)(screenSize.getWidth()/5)), ((int)(screenSize.getWidth()/20))));
		facil.addMouseListener(new MouseListener() {	
			public void mouseEntered(MouseEvent e) {
				facil.setIcon(img.tamaño(new ImageIcon("botones/BottonDif_facil-2.png"), ((int)(screenSize.getWidth()/5)), ((int)(screenSize.getWidth()/20))));
			}
			public void mouseExited(MouseEvent a) {
				facil.setIcon(img.tamaño(new ImageIcon("botones/BottonDif_facil-1.png"), ((int)(screenSize.getWidth()/5)), ((int)(screenSize.getWidth()/20))));
			}
			public void mousePressed(MouseEvent i) {}
			public void mouseClicked(MouseEvent e) {
				dificultad = 0;
				irPanelPartida();

			}
			public void mouseReleased(MouseEvent e) {}
		});
		
		
		dificil.setIcon(img.tamaño(new ImageIcon("botones/BottonDif_dificil-1.png"), ((int)(screenSize.getWidth()/5)), ((int)(screenSize.getWidth()/20))));
		dificil.setText("dificil");
		dificil.setBounds(((this.screenSize.width/2)-(this.screenSize.width/10)),(this.screenSize.height/6+((this.screenSize.width/18)*2)),(this.screenSize.width/5),(this.screenSize.width/20));
		dificil.addMouseListener(new MouseListener() {	
			public void mouseEntered(MouseEvent e) {
				dificil.setIcon(img.tamaño(new ImageIcon("botones/BottonDif_dificil-2.png"), ((int)(screenSize.getWidth()/5)), ((int)(screenSize.getWidth()/20))));
			}
			public void mouseExited(MouseEvent a) {
				dificil.setIcon(img.tamaño(new ImageIcon("botones/BottonDif_dificil-1.png"), ((int)(screenSize.getWidth()/5)), ((int)(screenSize.getWidth()/20))));
			}
			public void mousePressed(MouseEvent i) {}
			public void mouseClicked(MouseEvent e) {
				dificultad = 2;
				irPanelPartida();
			}
			public void mouseReleased(MouseEvent e) {}
		});
		
		Atras.setBounds(0,(this.screenSize.height-((screenSize.width/20)-3)),this.screenSize.width,(screenSize.width/25));
		
		add(this.Atras);
		add(dificil);
		add(facil);
		add(normal);
	}

	public void paint(Graphics g) {
		BufferedImage imgFondo;
		try {
			Dimension size = getSize();
			imgFondo = ImageIO.read(new File("imagenes/imagenPandemic6.png"));
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
	
	public void irMenu() {
		JFrame marcoP = (JFrame)SwingUtilities.getWindowAncestor(this);	
		marcoP.remove(this);
		marcoP.add(new JF_PanelMenu());
		marcoP.setVisible(true);
	}
}