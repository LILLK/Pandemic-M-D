package Pandemic;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JF_PanelPartida extends JPanel {
	Dimension screenSize;
	public JF_PanelPartida() {
		screenSize = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());

		cambiarImg img = new cambiarImg();
	
		
		JLabel mapa = new JLabel();
		
		mapa.setIcon(img.tamaño(new ImageIcon("imagenes/mapa_mundo.png"), 1550, 850));
		mapa.setBounds(this.screenSize.width/2-(1550/2),
				this.screenSize.height/2-(850/2), 
				1550, 
				850);
		mapa.setVisible(true);
		mapa.setOpaque(true);
		
		JLabel izquierda = new JLabel();

		izquierda.setIcon(img.tamaño(new ImageIcon("imagenes/empty.png"), this.screenSize.width/2-850/2, this.screenSize.height));
		izquierda.setBackground(Color.DARK_GRAY);
		izquierda.setBounds(10,10,10,10);
		izquierda.setOpaque(true);
		izquierda.setVisible(true);
		
		add(izquierda);
	}
	

	public void paint(Graphics g) {
		BufferedImage imgFondo;
		try {
			Dimension size = getSize();
			imgFondo = ImageIO.read(new File("imagenes/white.png"));
			//g.drawImage(imgFondo, 0, 0, size.width, size.height, null);
			g.fillRect(0, 0, size.width, size.height);
			setOpaque(false);
			super.paint(g);
		} catch (IOException e) {
			System.out.print("Error IMGfondo JF_PanelInicio");
		}

	}

	
}


