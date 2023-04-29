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

public class JF_PanelRegistrarse extends JPanel {

	BotonIniciarSesion BotonIniciarSesion;
	BotonRegistrarse BotonRegistrarse;
	BotonSalir Salir;
	JFrame marcoP;
	Dimension screenSize;
	JTextField JTFUsuario;
	JTextField JTFContraseña;
	JTextField JTFRepContraseña;


	JF_PanelRegistrarse() {

		Color color =new Color(71, 161, 197);
		Border borde = BorderFactory.createLineBorder(Color.BLACK,3);
		screenSize = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
		cambiarImg img = new cambiarImg();
		setLayout(null);
		
		this.Salir = new BotonSalir();
		this.Salir.setBounds(((this.screenSize.width / 2) - (this.screenSize.width / 10)),
				(this.screenSize.height / 6 + ((this.screenSize.width / 18) * 6)), 
				(this.screenSize.width / 5),
				(this.screenSize.width / 20));
		//text fields//
		JTFUsuario = new JTextField(1);
		JTFUsuario.setBounds(((this.screenSize.width / 7)*3),
				((this.screenSize.height / 7)*2),
				(this.screenSize.width / 7),
				(this.screenSize.width / 50));
		JTFUsuario.setBorder(borde);
		
		JTFContraseña = new JTextField(1);
		JTFContraseña.setBounds(((this.screenSize.width / 7)*3),
				((this.screenSize.height / 7)*3),
				(this.screenSize.width / 7),
				(this.screenSize.width / 50));
		JTFContraseña.setBorder(borde);
		
		JTFRepContraseña = new JTextField(1);
		JTFRepContraseña.setBounds(((this.screenSize.width / 7)*3),
				((this.screenSize.height / 7)*4),
				(this.screenSize.width / 7),
				(this.screenSize.width / 50));
		JTFRepContraseña.setBorder(borde);
		
		//labels//
		JLabel JLUsuario = new  JLabel();
		JLUsuario.setBounds(((this.screenSize.width / 7)*3),
				((this.screenSize.height / 7)*2 - (this.screenSize.width / 55)),
				((this.screenSize.width / 7)/2),
				(this.screenSize.width / 55));
		JLUsuario.setText("<html><center>Usuario");
		JLUsuario.setForeground(Color.BLACK);
		JLUsuario.setFont(new Font("Stika Text",Font.BOLD,(this.screenSize.height/80)));
		JLUsuario.setBackground(color);
		JLUsuario.setBorder(borde);
		JLUsuario.setOpaque(true);
		
		
		JLabel JLcontraseña = new  JLabel();
		JLcontraseña.setBounds(((this.screenSize.width / 7)*3),
				((this.screenSize.height / 7)*3 - (this.screenSize.width / 55)),
				((this.screenSize.width / 7)/2),
				(this.screenSize.width / 55));
		JLcontraseña.setText("<html><center>Contraseña");
		JLcontraseña.setForeground(Color.BLACK);
		JLcontraseña.setFont(new Font("Stika Text",Font.BOLD,(this.screenSize.height/80)));
		JLcontraseña.setBackground(color);
		JLcontraseña.setBorder(borde);
		JLcontraseña.setOpaque(true);
		
		JLabel JLRepContraseña = new  JLabel();
		JLRepContraseña.setBounds(((this.screenSize.width / 7)*3),
				((this.screenSize.height / 7)*4 - (this.screenSize.width / 55)),
				((this.screenSize.width / 7)/2),
				(this.screenSize.width / 55));
		JLRepContraseña.setText("<html><center>Repetir Conrtraseña");
		JLRepContraseña.setForeground(Color.BLACK);
		JLRepContraseña.setFont(new Font("Stika Text",Font.BOLD,(this.screenSize.height/80)));
		JLRepContraseña.setBackground(color);
		JLRepContraseña.setBorder(borde);
		JLRepContraseña.setOpaque(true);
		
		//botones//
		BotonIniciarSesion = new  BotonIniciarSesion(this);
		BotonIniciarSesion.setBounds(((this.screenSize.width / 7)*3+(this.screenSize.width / 7)/2),
				((this.screenSize.height / 7)*4 + (this.screenSize.width / 50)),
				((this.screenSize.width / 7)/2),
				(this.screenSize.width / 55));
		BotonIniciarSesion.setOpaque(true);

		
		
		BotonRegistrarse = new  BotonRegistrarse(this);
		BotonRegistrarse.setBounds(((this.screenSize.width / 7)*3),
				((this.screenSize.height / 7)*4 + (this.screenSize.width / 50)),
				((this.screenSize.width / 7)/2),
				(this.screenSize.width / 55));
		BotonRegistrarse.setOpaque(true);

		
		
		
		add(BotonIniciarSesion);
		add(BotonRegistrarse);
		add(JLUsuario);
		add(JTFUsuario);
		add(JLcontraseña);
		add(JTFContraseña);
		add(JLRepContraseña);
		add(JTFRepContraseña);
		add(this.Salir);
		
	}
	//////////////////////////////////////////////////////////////////
	//-getJTFUsuario-getJTFContraseña-getJTFRepContraseña
	//devuelve el contenido del text field
	/////////////////////////////////////////////////////////////////
	public String getJTFUsuario() {
		return JTFUsuario.getText();
	}
	public String getJTFContraseña() {
		return JTFContraseña.getText();
	}
	public String getJTFRepContraseña() {
		return JTFRepContraseña.getText();
	}


	public void paint(Graphics g) {
		BufferedImage imgFondo;
		try {
			Dimension size = getSize();
			imgFondo = ImageIO.read(new File("imagenes/imagenPandemic6.png"));
			g.drawImage(imgFondo, 0, 0, size.width, size.height, null);
			setOpaque(false);
			super.paint(g);
		} catch (IOException e) {
			System.out.print("Error IMGfondo JF_PanelInicio");
		}

	}

	public void irPanelIniciarSesion() {
		JFrame marcoP = (JFrame) SwingUtilities.getWindowAncestor(this);
		marcoP.remove(this);
		marcoP.add(new JF_PanelInicioSesion());
		marcoP.setVisible(true);
	}
	public void irMenu() {
		JFrame marcoP = (JFrame)SwingUtilities.getWindowAncestor(this);	
		marcoP.remove(this);
		marcoP.add(new JF_PanelMenu());
		marcoP.setVisible(true);
	}
	

}
