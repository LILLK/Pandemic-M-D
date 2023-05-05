package Pandemic;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;

import Botones.*;
import Logico.Ciudades;
import Logico.Partida;

public class JF_PanelPartida extends JPanel {

	
	BotonSalir Salir;
	BotonCiudad BotonCiudad;
	JFrame marcoP;
	Dimension screenSize;
	JTextField JTFUsuario;
	JTextField JTFContraseña;
	JF_PanelPartidaVacunas JF_PanelPartidaVacunas;
	

	public JF_PanelPartida() {
		
		
		
		int tamañoX = 30;
		int tamañoY = 20;

		cambiarImg img = new cambiarImg();

		Color color =new Color(71, 161, 197);
		Border borde = BorderFactory.createLineBorder(Color.BLACK,3);
		screenSize = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
		setLayout(null);

		
		//labels//
		
		JLabel mapa = new JLabel();
		mapa.setIcon(img.tamaño(new ImageIcon("imagenes/mapa_2.png"), 1550, 850));
		mapa.setBounds(1,
				1, 
				1550, 
				850);
		mapa.setVisible(true);
		mapa.setOpaque(true);
		
		
		JLabel derecha = new  JLabel();
		derecha.setBounds(1551,
				1, 
				(this.screenSize.width-1550), 
				this.screenSize.width);
		derecha.setBackground(color);
		derecha.setBorder(borde);
		derecha.setOpaque(true);
		
		JF_PanelPartidaVacunas = new JF_PanelPartidaVacunas();
		
		
		
		
		
		
		
		for (Ciudades Ciudad : Partida.ciudades) {
			add(Ciudad.boton);
		}
 		add(derecha);
		add(JF_PanelPartidaVacunas);
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
