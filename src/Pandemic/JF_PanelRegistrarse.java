//Mehdi Tahrat && David hola
package Pandemic;
import java.awt.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import Botones.*;
/**
 * Esta classe es del panel registrase.
 * En este panel el usuario puede crear un nuevo usuario en la base de datos 
 * @author DAME
 *
 */

public class JF_PanelRegistrarse extends JPanel {
	/**
	 * Este boton cambia al panel {@link JF_PanelInicioSesion} 
	 */
	BotonIniciarSesion BotonIniciarSesion;
	/**
	 * Este boton compureva las credenciales y se registra si es possible
	 */
	BotonRegistrarse BotonRegistrarse;
	/**
	 * Este es el campo de texto donde se introduce el usuario
	 */
	JTextField JTFUsuario;
	/**
	 * Este es el campo de texto donde se introduce la contrasenya
	 */
	JTextField JTFContrasenya;
	/**
	 * Este es el campo de texto donde se confirma la contrasenya introducida
	 */
	JTextField JTFRepContrasenya;

	/**
	 * Este es el constructor del panel registrarse 
	 * En este panel el usuario puede crear un nuevo usuario en la base de datos 
	 */
	JF_PanelRegistrarse() {

		cambiarImg img = new cambiarImg();
		setLayout(null);

		//text fields//
		JTFUsuario = new JTextField(1);
		JTFUsuario.setBounds(((cambiarImg.screenSize.width / 12)*5),((cambiarImg.screenSize.height / 7)*2),(cambiarImg.screenSize.width / 12)*2,
		(cambiarImg.screenSize.width / 35));
		JTFUsuario.setBorder(cambiarImg.bordeN);
		
		JTFContrasenya = new JPasswordField(1);
		JTFContrasenya.setBounds(((cambiarImg.screenSize.width / 12)*5),((cambiarImg.screenSize.height / 7)*3),(cambiarImg.screenSize.width / 12)*2,(cambiarImg.screenSize.width / 35));
;
		JTFContrasenya.setBorder(cambiarImg.bordeN);
		
		JTFRepContrasenya = new JPasswordField(1);
		JTFRepContrasenya.setBounds(((cambiarImg.screenSize.width / 12)*5),((cambiarImg.screenSize.height / 7)*4),(cambiarImg.screenSize.width / 12)*2,(cambiarImg.screenSize.width / 35));
		JTFRepContrasenya.setBorder(cambiarImg.bordeN);
		
		//labels//
		JLabel JLUsuario = new  JLabel();
		JLUsuario.setBounds(((cambiarImg.screenSize.width / 12)*5),((cambiarImg.screenSize.height / 7)*2 - (cambiarImg.screenSize.width / 45)),((cambiarImg.screenSize.width / 12)),(cambiarImg.screenSize.width / 45));
		JLUsuario.setText("<html><center>Usuario");
		JLUsuario.setForeground(Color.BLACK);
		JLUsuario.setFont(new Font("Stika Text",Font.BOLD,(cambiarImg.screenSize.height/80)));
		JLUsuario.setBackground(cambiarImg.color1);
		JLUsuario.setBorder(cambiarImg.bordeN);
		JLUsuario.setOpaque(true);
		
		
		JLabel JLcontrasenya = new  JLabel();
		JLcontrasenya.setBounds(((cambiarImg.screenSize.width / 12)*5),((cambiarImg.screenSize.height / 7)*3 - (cambiarImg.screenSize.width / 45)),((cambiarImg.screenSize.width / 12)), (cambiarImg.screenSize.width / 45));
		JLcontrasenya.setText("<html><center>Contrasenya");
		JLcontrasenya.setForeground(Color.BLACK);
		JLcontrasenya.setFont(new Font("Stika Text",Font.BOLD,(cambiarImg.screenSize.height/80)));
		JLcontrasenya.setBackground(cambiarImg.color1);
		JLcontrasenya.setBorder(cambiarImg.bordeN);
		JLcontrasenya.setOpaque(true);
		
		JLabel JLRepContrasenya = new  JLabel();
		JLRepContrasenya.setBounds(((cambiarImg.screenSize.width / 12)*5), ((cambiarImg.screenSize.height / 7)*4 - (cambiarImg.screenSize.width / 45)), ((cambiarImg.screenSize.width / 12)),(cambiarImg.screenSize.width / 45));
		JLRepContrasenya.setText("<html><center>Repetir Conrtrasenya");
		JLRepContrasenya.setForeground(Color.BLACK);
		JLRepContrasenya.setFont(new Font("Stika Text",Font.BOLD,(cambiarImg.screenSize.height/80)));
		JLRepContrasenya.setBackground(cambiarImg.color1);
		JLRepContrasenya.setBorder(cambiarImg.bordeN);
		JLRepContrasenya.setOpaque(true);
		
		//botones//
		BotonIniciarSesion = new  BotonIniciarSesion(this);
		BotonIniciarSesion.setBounds(((cambiarImg.screenSize.width / 2)-((cambiarImg.screenSize.width / 12))),((cambiarImg.screenSize.height / 7)*4 + (cambiarImg.screenSize.width / 30)),((cambiarImg.screenSize.width / 12)),(cambiarImg.screenSize.width / 45));
		BotonIniciarSesion.setOpaque(true);
		
		BotonRegistrarse = new  BotonRegistrarse(this);
		BotonRegistrarse.setBounds((cambiarImg.screenSize.width / 2),
				((cambiarImg.screenSize.height / 7)*4 + (cambiarImg.screenSize.width / 30)),((cambiarImg.screenSize.width / 12)),(cambiarImg.screenSize.width / 45));
		BotonRegistrarse.setOpaque(true);

		add(BotonIniciarSesion);
		add(BotonRegistrarse);
		add(JLUsuario);
		add(JTFUsuario);
		add(JLcontrasenya);
		add(JTFContrasenya);
		add(JLRepContrasenya);
		add(JTFRepContrasenya);
		
	}

	/**
	 * Este metodo devuelve el contenido del campo unusario 
	 * @return String
	 */
	public String getJTFUsuario() {
		return JTFUsuario.getText();
	}
	/**
	 * Este metodo devuelve el contenido del campo contrasenya 
	 * @return String
	 */
	public String getJTFContrasenya() {
		return JTFContrasenya.getText();
	}
	/**
	 * Este metodo devuelve el contenido del campo Repcontrasenya 
	 * @return String
	 */
	public String getJTFRepContrasenya() {
		return JTFRepContrasenya.getText();
	}

	/**
	 * Este metodo pinta el fondo de la pantalla
	 */
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
	/**
	 * Este metodo cambia el panel {@link JF_PanelRegistrarse } por el panel {@link JF_PanelInicioSesion}
	 */
	public void irPanelIniciarSesion() {
		JFrame marcoP = (JFrame) SwingUtilities.getWindowAncestor(this);
		marcoP.remove(this);
		marcoP.add(new JF_PanelInicioSesion());
		marcoP.setVisible(true);
	}
	/**
	 * Este metodo cambia el panel {@link JF_PanelRegistrarse } por el panel {@link JF_PanelMenu}
	 */
	public void irMenu() {
		JFrame marcoP = (JFrame)SwingUtilities.getWindowAncestor(this);	
		marcoP.remove(this);
		marcoP.add(new JF_PanelMenu());
		marcoP.setVisible(true);
	}

	

}
