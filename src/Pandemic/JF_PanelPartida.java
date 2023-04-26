package Pandemic;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JF_PanelPartida extends JPanel {
	
	public JF_PanelPartida() {
		
		cambiarImg img = new cambiarImg();
		JLabel mapa = new JLabel();
		
		mapa.setIcon(img.tamaño(new ImageIcon("imagenes/mapa_mundo.png"), 1550, 850));
		mapa.setBounds(0, 0, 1550, 850);
		mapa.setVisible(true);
		mapa.setOpaque(true);
		add(mapa);
	}
	public void paint(Graphics g) {
		BufferedImage imgFondo;
		try {
			Dimension size =getSize();
			imgFondo = ImageIO.read(new File("imagenes/imagenPandemic6.png"));
			g.drawImage(imgFondo, 0, 0, size.width, size.height,null);
			setOpaque(false);
			super.paint(g);
		} catch (IOException e) {
			System.out.print("Error IMGfondo JF_PanelMenuMenu");
		}
		
	}
}


