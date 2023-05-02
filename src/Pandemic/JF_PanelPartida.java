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
		mapa.setBounds(this.screenSize.width/2-(1550/2), this.screenSize.height/2-(850/2), 1550, 850);
		mapa.setVisible(true);
		mapa.setOpaque(true);
		
		JPanel arriba = new JPanel();
		arriba.setBackground(Color.black);
		arriba.setBounds(1550,1550,1550,1550);
		
		//add(mapa);
		add(arriba);
	}
	
}


