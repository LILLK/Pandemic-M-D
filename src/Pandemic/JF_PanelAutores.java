package Pandemic;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import Botones.BotonAtras;

public class JF_PanelAutores extends JPanel  {
	BotonAtras Atras;
	JLabel imagenDavid;
	Dimension screenSize;
	JF_PanelMenu JF_PanelMenu;
	
	public JF_PanelAutores()  {
	
		setLayout(null);

		this.screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		cambiarImg img = new cambiarImg();
		
		this.Atras = new BotonAtras(this);
		
		JLabel imagenDavid = new JLabel();
		JLabel imgDavidDesc = new JLabel();
		JLabel imagenMehdi = new JLabel();
		JLabel imgMehdiDesc = new JLabel();

		
		
		imagenDavid.setIcon(img.tamaño(new ImageIcon("imagenes/fotoDavid.png"),300,200));
		imgDavidDesc.setIcon(img.tamaño(new ImageIcon("imagenes/imgDavidDesc.png"),300,400));
		imagenMehdi.setIcon(img.tamaño(new ImageIcon("imagenes/imagenMehdi.png"), 300, 200));
		imgMehdiDesc.setIcon(img.tamaño(new ImageIcon("imagenes/imgDavidDesc.png"), 300, 400));
		
		imagenDavid.setBounds( 250,50, 300,200);
		imgDavidDesc.setBounds( 250,250, 300,400);
		imagenMehdi.setBounds(this.screenSize.width-550,50, 300,200);
		imgMehdiDesc.setBounds(this.screenSize.width-550,250,300,400);
		Atras.setBounds(0,(this.screenSize.height-((screenSize.width/20)+4)),this.screenSize.width,(screenSize.width/25));
		
		
		add(imgDavidDesc);
		add(imagenDavid);
		add(imagenMehdi);
		add(imgMehdiDesc);
		add(this.Atras);
		
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
