//Mehdi Tahrat && David hola
package Pandemic;

import java.awt.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import Botones.*;

public class JF_PanelRegistrarse extends JPanel {

	BotonIniciarSesion BotonIniciarSesion;
	BotonRegistrarse BotonRegistrarse;
	BotonSalir Salir;
	JFrame marcoP;

	JTextField JTFUsuario;
	JTextField JTFContraseña;
	JTextField JTFRepContraseña;


	JF_PanelRegistrarse() {



		cambiarImg img = new cambiarImg();
		setLayout(null);
		
		this.Salir = new BotonSalir();
		this.Salir.setBounds(((cambiarImg.screenSize.width / 2) - (cambiarImg.screenSize.width / 10)),
				(cambiarImg.screenSize.height / 6 + ((cambiarImg.screenSize.width / 18) * 6)), 
				(cambiarImg.screenSize.width / 5),
				(cambiarImg.screenSize.width / 20));
		//text fields//
		JTFUsuario = new JTextField(1);
		JTFUsuario.setBounds(((cambiarImg.screenSize.width / 12)*5),
		((cambiarImg.screenSize.height / 7)*2),
		(cambiarImg.screenSize.width / 12)*2,
		(cambiarImg.screenSize.width / 35));

		JTFUsuario.setBorder(cambiarImg.bordeN);
		
		JTFContraseña = new JPasswordField(1);
		JTFContraseña.setBounds(((cambiarImg.screenSize.width / 12)*5),
		((cambiarImg.screenSize.height / 7)*3),
		(cambiarImg.screenSize.width / 12)*2,
		(cambiarImg.screenSize.width / 35));
;
		JTFContraseña.setBorder(cambiarImg.bordeN);
		
		JTFRepContraseña = new JPasswordField(1);
		JTFRepContraseña.setBounds(((cambiarImg.screenSize.width / 12)*5),
				((cambiarImg.screenSize.height / 7)*4),
				(cambiarImg.screenSize.width / 12)*2,
				(cambiarImg.screenSize.width / 35));
		JTFRepContraseña.setBorder(cambiarImg.bordeN);
		
		//labels//
		JLabel JLUsuario = new  JLabel();
		JLUsuario.setBounds(((cambiarImg.screenSize.width / 12)*5),
				((cambiarImg.screenSize.height / 7)*2 - (cambiarImg.screenSize.width / 45)),
				((cambiarImg.screenSize.width / 12)),
				(cambiarImg.screenSize.width / 45));
		JLUsuario.setText("<html><center>Usuario");
		JLUsuario.setForeground(Color.BLACK);
		JLUsuario.setFont(new Font("Stika Text",Font.BOLD,(cambiarImg.screenSize.height/80)));
		JLUsuario.setBackground(cambiarImg.color1);
		JLUsuario.setBorder(cambiarImg.bordeN);
		JLUsuario.setOpaque(true);
		
		
		JLabel JLcontraseña = new  JLabel();
		JLcontraseña.setBounds(((cambiarImg.screenSize.width / 12)*5),
				((cambiarImg.screenSize.height / 7)*3 - (cambiarImg.screenSize.width / 45)),
				((cambiarImg.screenSize.width / 12)),
				(cambiarImg.screenSize.width / 45));
		JLcontraseña.setText("<html><center>Contraseña");
		JLcontraseña.setForeground(Color.BLACK);
		JLcontraseña.setFont(new Font("Stika Text",Font.BOLD,(cambiarImg.screenSize.height/80)));
		JLcontraseña.setBackground(cambiarImg.color1);
		JLcontraseña.setBorder(cambiarImg.bordeN);
		JLcontraseña.setOpaque(true);
		
		JLabel JLRepContraseña = new  JLabel();
		JLRepContraseña.setBounds(((cambiarImg.screenSize.width / 12)*5),
				((cambiarImg.screenSize.height / 7)*4 - (cambiarImg.screenSize.width / 45)),
				((cambiarImg.screenSize.width / 12)),
				(cambiarImg.screenSize.width / 45));
		JLRepContraseña.setText("<html><center>Repetir Conrtraseña");
		JLRepContraseña.setForeground(Color.BLACK);
		JLRepContraseña.setFont(new Font("Stika Text",Font.BOLD,(cambiarImg.screenSize.height/80)));
		JLRepContraseña.setBackground(cambiarImg.color1);
		JLRepContraseña.setBorder(cambiarImg.bordeN);
		JLRepContraseña.setOpaque(true);
		
		//botones//
		BotonIniciarSesion = new  BotonIniciarSesion(this);
		BotonIniciarSesion.setBounds(((cambiarImg.screenSize.width / 2)-((cambiarImg.screenSize.width / 12))),
				((cambiarImg.screenSize.height / 7)*4 + (cambiarImg.screenSize.width / 30)),
				((cambiarImg.screenSize.width / 12)),
				(cambiarImg.screenSize.width / 45));
		BotonIniciarSesion.setOpaque(true);

		
		
		BotonRegistrarse = new  BotonRegistrarse(this);
		BotonRegistrarse.setBounds((cambiarImg.screenSize.width / 2),
				((cambiarImg.screenSize.height / 7)*4 + (cambiarImg.screenSize.width / 30)),
				((cambiarImg.screenSize.width / 12)),
				(cambiarImg.screenSize.width / 45));
		BotonRegistrarse.setOpaque(true);

		
		
		
		add(BotonIniciarSesion);
		add(BotonRegistrarse);
		add(JLUsuario);
		add(JTFUsuario);
		add(JLcontraseña);
		add(JTFContraseña);
		add(JLRepContraseña);
		add(JTFRepContraseña);
		
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
			imgFondo = ImageIO.read(new File("imagenes/imagenPandemic6_3.png"));
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
