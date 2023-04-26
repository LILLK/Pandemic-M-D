package Pandemic;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
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
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

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
		Border borde = BorderFactory.createLineBorder(Color.BLACK,8);

		
		
		imagenDavid.setIcon(img.tamaño(new ImageIcon("imagenes/fotoDavid.png"),(this.screenSize.height/3),(this.screenSize.height/4)));
		//imgDavidDesc.setIcon(img.tamaño(new ImageIcon("imagenes/imgDavidDesc.png"),(this.screenSize.height/3),(this.screenSize.height/3)));
		imagenMehdi.setIcon(img.tamaño(new ImageIcon("imagenes/imagenMehdi.png"), (this.screenSize.height/3), (this.screenSize.height/4)));
		//imgMehdiDesc.setIcon(img.tamaño(new ImageIcon("imagenes/imgMehdiDesc.png"), (this.screenSize.height/3), (this.screenSize.height/3)));
		
		
		imgDavidDesc.setText("<html><center>DAVID CALIN HOLA<p>Tengo 18 años y estudio programación web. Me apasiona todo lo relacionado con la tecnologia "
				+ "							y la informática, especialmente los videojuegos. Me encanta aprender sobre nuevos lenguajes de programacion y "
				+ "							diseñar mis propios juegos en mi tiempo libre. Espero poder seguir creciendo en esta carrera y convertirme en un"
				+ "							desarrollador web exitoso.");
		
		
		imgDavidDesc.setBackground(new Color(71,161,197));
		imgDavidDesc.setForeground(Color.black);
		imgDavidDesc.setOpaque(true);
		imgDavidDesc.setFont(new Font("Stika Text",Font.BOLD,(this.screenSize.height/52)));
		imgDavidDesc.setVisible(true);
		
		imgMehdiDesc.setText("<html><center>Mehdi Tharat<p>Soy un estudiante de 20 años apasionado por la informatica y la programcación. Me encanta trabajar"
				+ "							con números y desentrañar problemas matemáticos complejos. Estoy en constante búsqueda de nuevas tecnologías y lenguajes "
				+ "							programación que me permitan mejorar mia habitidades y conocimientos.Mi objetivo es convertirme en un experto en"
				+ "							programación.");
		imgMehdiDesc.setBackground(new Color(71,161,197));
		imgMehdiDesc.setForeground(Color.black);
		imgMehdiDesc.setFont(new Font("Stika Text",Font.BOLD,(this.screenSize.height/52)));
		imgMehdiDesc.setOpaque(true);
		imgMehdiDesc.setVisible(true);
		
		imagenMehdi.setBorder(borde);
		imagenDavid.setBorder(borde);
		
		imagenDavid.setBounds	((this.screenSize.width/2)-(this.screenSize.height/5)-(this.screenSize.height/3),(this.screenSize.height/8), (this.screenSize.height/3),(this.screenSize.height/4));
		imgDavidDesc.setBounds	((this.screenSize.width/2)-(this.screenSize.height/5)-(this.screenSize.height/3),(this.screenSize.height/8)+(this.screenSize.height/4), (this.screenSize.height/3),(this.screenSize.height/3));
		imagenMehdi.setBounds	((this.screenSize.width/2)+(this.screenSize.height/5),(this.screenSize.height/8), (this.screenSize.height/3),(this.screenSize.height/4));
		imgMehdiDesc.setBounds	((this.screenSize.width/2)+(this.screenSize.height/5),(this.screenSize.height/8)+(this.screenSize.height/4),(this.screenSize.height/3),(this.screenSize.height/3));
		Atras.setBounds(0,(this.screenSize.height-((screenSize.width/20)-3)),this.screenSize.width,(screenSize.width/25));
		
		
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
			imgFondo = ImageIO.read(new File("imagenes/imagenPandemic6.png"));
			g.drawImage(imgFondo, 0, 0, size.width, size.height,null);
			setOpaque(false);
			super.paint(g);
		} catch (IOException e) {
			System.out.print("Error IMGfondo JF_PanelMenuMenu");
		}
		
		
	} 
	


}
