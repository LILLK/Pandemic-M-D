package Pandemic;

import java.awt.*;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import Botones.*;
import Logico.Partida;

public class JF_PanelPartidaDificultad extends JPanel {



	BotonAtras Atras;


	public JF_PanelPartidaDificultad() {
		cambiarImg img = new cambiarImg();

		setLayout(null);
		
		JLabel normal = new JLabel();
		JLabel facil = new JLabel();
		JLabel dificil = new JLabel();
		Atras = new BotonAtras(this);


		normal.setBounds(((cambiarImg.screenSize.width/2)-(cambiarImg.screenSize.width/10)),(cambiarImg.screenSize.height/6),(cambiarImg.screenSize.width/5),(cambiarImg.screenSize.width/20));
		normal.setIcon(img.tamaño(new ImageIcon("botones/BottonDif_normal-1.png"), ((int)(cambiarImg.screenSize.getWidth()/5)), ((int)(cambiarImg.screenSize.getWidth()/20))));
		normal.addMouseListener(new MouseListener() {	
			public void mouseEntered(MouseEvent e) {
				normal.setIcon(img.tamaño(new ImageIcon("botones/BottonDif_normal-2.png"), ((int)(cambiarImg.screenSize.getWidth()/5)), ((int)(cambiarImg.screenSize.getWidth()/20))));
			}
			public void mouseExited(MouseEvent a) {
				normal.setIcon(img.tamaño(new ImageIcon("botones/BottonDif_normal-1.png"), ((int)(cambiarImg.screenSize.getWidth()/5)), ((int)(cambiarImg.screenSize.getWidth()/20))));
			}
			public void mousePressed(MouseEvent i) {}
			public void mouseClicked(MouseEvent e) {
				Partida.dificultad = 1;
				irPanelPartida();

			}
			public void mouseReleased(MouseEvent e) {}
		});	
		
		
		facil.setText("facil");
		facil.setBounds(((cambiarImg.screenSize.width/2)-(cambiarImg.screenSize.width/10)),((cambiarImg.screenSize.height/6)+(cambiarImg.screenSize.width/18)),(cambiarImg.screenSize.width/5),(cambiarImg.screenSize.width/20));
		facil.setIcon(img.tamaño(new ImageIcon("botones/BottonDif_facil-1.png"), ((int)(cambiarImg.screenSize.getWidth()/5)), ((int)(cambiarImg.screenSize.getWidth()/20))));
		facil.addMouseListener(new MouseListener() {	
			public void mouseEntered(MouseEvent e) {
				facil.setIcon(img.tamaño(new ImageIcon("botones/BottonDif_facil-2.png"), ((int)(cambiarImg.screenSize.getWidth()/5)), ((int)(cambiarImg.screenSize.getWidth()/20))));
			}
			public void mouseExited(MouseEvent a) {
				facil.setIcon(img.tamaño(new ImageIcon("botones/BottonDif_facil-1.png"), ((int)(cambiarImg.screenSize.getWidth()/5)), ((int)(cambiarImg.screenSize.getWidth()/20))));
			}
			public void mousePressed(MouseEvent i) {}
			public void mouseClicked(MouseEvent e) {
				Partida.dificultad = 0;
				irPanelPartida();

			}
			public void mouseReleased(MouseEvent e) {}
		});
		
		
		dificil.setIcon(img.tamaño(new ImageIcon("botones/BottonDif_dificil-1.png"), ((int)(cambiarImg.screenSize.getWidth()/5)), ((int)(cambiarImg.screenSize.getWidth()/20))));
		dificil.setText("dificil");
		dificil.setBounds(((cambiarImg.screenSize.width/2)-(cambiarImg.screenSize.width/10)),(cambiarImg.screenSize.height/6+((cambiarImg.screenSize.width/18)*2)),(cambiarImg.screenSize.width/5),(cambiarImg.screenSize.width/20));
		dificil.addMouseListener(new MouseListener() {	
			public void mouseEntered(MouseEvent e) {
				dificil.setIcon(img.tamaño(new ImageIcon("botones/BottonDif_dificil-2.png"), ((int)(cambiarImg.screenSize.getWidth()/5)), ((int)(cambiarImg.screenSize.getWidth()/20))));
			}
			public void mouseExited(MouseEvent a) {
				dificil.setIcon(img.tamaño(new ImageIcon("botones/BottonDif_dificil-1.png"), ((int)(cambiarImg.screenSize.getWidth()/5)), ((int)(cambiarImg.screenSize.getWidth()/20))));
			}
			public void mousePressed(MouseEvent i) {}
			public void mouseClicked(MouseEvent e) {
				Partida.dificultad = 2;
				irPanelPartida();
			}
			public void mouseReleased(MouseEvent e) {}
		});
		
		Atras.setBounds(0,(cambiarImg.screenSize.height-((cambiarImg.screenSize.width/20)-3)),cambiarImg.screenSize.width,(cambiarImg.screenSize.width/25));
		
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
			System.out.print("Error IMGfondo JF_PanelPartidaDificultad");
		}

	}
	
	public void irPanelPartida() {
		Partida.iniciarNuevaPartida(Partida.dificultad);
		JFrame marcoP = (JFrame)SwingUtilities.getWindowAncestor(this);	
		marcoP.remove(this);
		if (cambiarImg.screenSize.width<1920 && cambiarImg.screenSize.height < 1080) {
			JOptionPane.showMessageDialog(new JFrame(), "No se puede jugar con una resulucion menor a 1920x1080");
			marcoP.add(new JF_PanelMenu());
		}else {
			marcoP.add(new JF_PanelPartida());
		}		marcoP.setVisible(true);
	}
	
	public void irMenu() {
		JFrame marcoP = (JFrame)SwingUtilities.getWindowAncestor(this);	
		marcoP.remove(this);
		marcoP.add(new JF_PanelMenu());
		marcoP.setVisible(true);
	}
}