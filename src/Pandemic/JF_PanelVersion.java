package Pandemic;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import Botones.BotonAtras;

public class JF_PanelVersion extends JPanel {
	BotonAtras Atras;


	
	JF_PanelVersion() {
	
		setLayout(null);

		
		this.Atras = new BotonAtras(this);
		JLabel Version = new JLabel();

		String s= "Version 1.5";
		Version.setBounds(((cambiarImg.screenSize.width/2)-276),50,552,100);
		Version.setText(s);
		Version.setForeground(Color.BLACK);
		Version.setFont(new Font("Stika Text",Font.BOLD,100));
		Version.setBackground(cambiarImg.color1);
		Version.setBorder(cambiarImg.bordeN);
		Version.setOpaque(true);
		Version.setVisible(true);
		Atras.setBounds(0,(cambiarImg.screenSize.height-((cambiarImg.screenSize.width/20)+4)),cambiarImg.screenSize.width,(cambiarImg.screenSize.width/25));
		add(this.Atras);
		
		add(Version);
		
	}
	public void irMenu() {
		JFrame marcoP = (JFrame)SwingUtilities.getWindowAncestor(this);	
		marcoP.remove(this);
		marcoP.add(new JF_PanelMenu());
		marcoP.setVisible(true);
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
