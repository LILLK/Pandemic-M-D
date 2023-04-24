package Pandemic;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import Botones.*;

public class JF_PanelMenu extends JPanel {
	
	BotonNuevaPartida NuevaPartida;
	BotonCargarPartida CargarPartida;
	BotonInformacion Infromacion;
	BotonPuntuaciones ResumenPuntuaciones;
	BotonAutores Autores;
	BotonVersion Version;
	BotonSalir Salir;
	JFrame marcoP;
	Dimension screenSize;
	
	JF_PanelMenu(){
		
		this.screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		
		setLayout(null);
		this.NuevaPartida = new BotonNuevaPartida();
		this.CargarPartida = new BotonCargarPartida(this);
		this.Infromacion = new BotonInformacion(this);
		this.ResumenPuntuaciones = new BotonPuntuaciones(this);
		this.Autores = new BotonAutores(this);
		this.Version = new BotonVersion(this);
		this.Salir = new BotonSalir();
		
		this.NuevaPartida.setBounds(((this.screenSize.width/2)-150),50,300,75);
		this.CargarPartida.setBounds(((this.screenSize.width/2)-150),145,300,75);
		this.Infromacion.setBounds(((this.screenSize.width/2)-150),240,300,75);
		this.ResumenPuntuaciones.setBounds(((this.screenSize.width/2)-150),335,300,75);
		this.Autores.setBounds(((this.screenSize.width/2)-150),430,300,75);
		this.Version.setBounds(((this.screenSize.width/2)-150),525,300,75);
		this.Salir.setBounds(((this.screenSize.width/2)-150),620,300,75);
		
		
		add(this.NuevaPartida);
		add(this.CargarPartida);
		add(this.Infromacion);
		add(this.ResumenPuntuaciones);
		add(this.Autores);
		add(this.Version);
		add(this.Salir);

	
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
	public void irPanelAutores() {
		JFrame marcoP = (JFrame)SwingUtilities.getWindowAncestor(this);	
		marcoP.remove(this);
		marcoP.add(new JF_PanelAutores());
		marcoP.setVisible(true);
	}
	public void irPanelInformacion() {
		JFrame marcoP = (JFrame)SwingUtilities.getWindowAncestor(this);	
		marcoP.remove(this);
		marcoP.add(new JF_PanelInfo());
		marcoP.setVisible(true);
	}
	public void irPanelVersion() {
		JFrame marcoP = (JFrame)SwingUtilities.getWindowAncestor(this);	
		marcoP.remove(this);
		marcoP.add(new JF_PanelVersion());
		marcoP.setVisible(true);
	}
	/*
	public void irMenu(JPanel JPanel) {
		JFrame marcoP = (JFrame)SwingUtilities.getWindowAncestor(JPanel);	
		marcoP.remove(JPanel);
		marcoP.add(this);
		marcoP.setVisible(true);
	}*/

	

}
