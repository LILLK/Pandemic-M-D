package Pandemic;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;

import Botones.*;

public class JF_PanelPartida extends JPanel {

	BotonSalir Salir;
	JFrame marcoP;
	Dimension screenSize;
	JTextField JTFUsuario;
	JTextField JTFContraseña;

	public JF_PanelPartida() {

		Color color =new Color(71, 161, 197);
		Border borde = BorderFactory.createLineBorder(Color.BLACK,3);
		screenSize = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
		//cambiarImg img = new cambiarImg();
		setLayout(null);

		
		//labels//
		JLabel JLUsuario = new  JLabel();
		JLUsuario.setBounds(((this.screenSize.width / 7)*3),
				((this.screenSize.height / 7)*2 - (this.screenSize.width / 55)),
				((this.screenSize.width / 7)/2),
				(this.screenSize.width / 55));
		JLUsuario.setBackground(color);
		JLUsuario.setOpaque(true);
		
		JLabel mapa = new JLabel();
		mapa.setIcon(cambiarImg.tamaño(new ImageIcon("imagenes/mapa_2.png"), 1550, 850));
		mapa.setBounds(this.screenSize.width/2-(1550/2),
				1, 
				1550, 
				850);
		mapa.setVisible(true);
		mapa.setOpaque(true);
		
		
		JLabel derecha = new  JLabel();
		derecha.setBounds(this.screenSize.width/2+(1550/2),
				1, 
				(this.screenSize.width-1550)/2, 
				this.screenSize.width);
		derecha.setBackground(color);
		derecha.setBorder(borde);
		derecha.setOpaque(true);
		
		
		
		JLabel iquierda = new  JLabel();
		iquierda.setBounds((1),
				(1),
				((this.screenSize.width-1550)/2),
				(this.screenSize.width));
		iquierda.setText("<html><center>Usuario");
		iquierda.setBackground(color);
		iquierda.setBorder(borde);
		iquierda.setOpaque(true);
		
		
		JLabel abajo = new  JLabel();
		abajo.setBounds(this.screenSize.width/2-(1550/2),
				(850),
				(1550),
				(850));
		abajo.setText("<html><center>Usuario");
		abajo.setBackground(color);
		abajo.setBorder(borde);
		abajo.setOpaque(true);
		
	
		
		
		
		
		add(iquierda);
		add(derecha);
		add(abajo);
		add(mapa);
	;
		
	}
	public String getJTFUsuario() {
		return JTFUsuario.getText();
	}
	public String getJTFContraseña() {
		return JTFContraseña.getText();
	}


	public void paint(Graphics g) {
		BufferedImage imgFondo;
		try {
			Dimension size = getSize();
			imgFondo = ImageIO.read(new File("imagenes/white.png"));
			g.drawImage(imgFondo, 0, 0, size.width, size.height, null);
			setOpaque(false);
			super.paint(g);
		} catch (IOException e) {
			System.out.print("Error IMGfondo JF_PanelInicio");
		}

	}

	public void irPanelRegistrarse() {
		JFrame marcoP = (JFrame) SwingUtilities.getWindowAncestor(this);
		marcoP.remove(this);
		marcoP.add(new JF_PanelRegistrarse());
		marcoP.setVisible(true);
	}
	public void irMenu() {
		JFrame marcoP = (JFrame)SwingUtilities.getWindowAncestor(this);	
		marcoP.remove(this);
		marcoP.add(new JF_PanelMenu());
		marcoP.setVisible(true);
	}
	

}
