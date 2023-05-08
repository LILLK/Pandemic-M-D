package Pandemic;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.plaf.basic.BasicScrollBarUI;

import Botones.BotonAtras;
import Logico.PartidasGuardadas;

public class JF_PanelCargarPartida extends JPanel {
	
	BotonAtras Atras;
	Dimension screenSize;
	ArrayList<PartidasGuardadas> partGuar;
	
	public JF_PanelCargarPartida(){
		
		setLayout(null);
		this.screenSize = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
		JScrollPane scroll = new JScrollPane();
		JPanel panel = new JPanel();
		this.partGuar = new ArrayList<PartidasGuardadas>();
		
		
		scroll.setBounds((this.screenSize.width/2)-410,100,820,450);
		scroll.getVerticalScrollBar().setUI(new BasicScrollBarUI());
		scroll.setViewportView(panel);
		
		
		
		
		panel.setPreferredSize(new Dimension(800,100*8));
		this.Atras = new BotonAtras(this);
		Atras.setBounds(0,(this.screenSize.height-((screenSize.width/20)+4)),this.screenSize.width,(screenSize.width/25));
		add(this.Atras);
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
		
		
	} 	public void irMenu() {
		JFrame marcoP = (JFrame)SwingUtilities.getWindowAncestor(this);	
		marcoP.remove(this);
		marcoP.add(new JF_PanelMenu());
		marcoP.setVisible(true);
	}

}
