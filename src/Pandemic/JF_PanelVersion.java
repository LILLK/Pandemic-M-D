package Pandemic;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import Botones.BotonAtras;

public class JF_PanelVersion extends JPanel {
	BotonAtras Atras;

	Dimension screenSize;
	
	JF_PanelVersion() {
	
		setLayout(null);
		this.screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		
		this.Atras = new BotonAtras(this);
		JLabel Version = new JLabel("Version 1.0");
		
		Atras.setBounds(0,(this.screenSize.height-((screenSize.width/20)+4)),this.screenSize.width,(screenSize.width/25));
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
			imgFondo = ImageIO.read(new File("imagenes/imagenPandemic.png"));
			g.drawImage(imgFondo, 0, 0, size.width, size.height,null);
			setOpaque(false);
			super.paint(g);
		} catch (IOException e) {
			System.out.print("Error IMGfondo JF_PanelMenuMenu");
		}
		
		
	} 

	
	}
