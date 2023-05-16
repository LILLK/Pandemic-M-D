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
 * Esta classe es el panel que sale solo ejecutar el programa.
 * Este panel es donde el usuario inicia sesion con sus credenciales
 * @author DAME
 */
public class JF_PanelInicioSesion extends JPanel {
	/**
	 * Este boton compureva las credenciales y logea si es possible 
	 */
	BotonIniciarSesion BotonIniciarSesion;
	/**
	 * Este boton cambia al panel {@link JF_PanelRegistrarse} 
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
 	*Este es el contructor del panel inicio sesion.
 	*Aqui hay 2 labels titulo , 2 botones para registrarse y para iniciar sesion, y dos campos de texto para el usuario y contrasenya  
 	*/
	public JF_PanelInicioSesion() {

		setLayout(null);
		//text fields//
		JTFUsuario = new JTextField(1);
		JTFUsuario.setBounds(((cambiarImg.screenSize.width / 12)*5),((cambiarImg.screenSize.height / 7)*2),	(cambiarImg.screenSize.width / 12)*2,(cambiarImg.screenSize.width / 35));
		JTFUsuario.setBorder(cambiarImg.bordeN);
		
		JTFContrasenya = new JPasswordField(1);
		JTFContrasenya.setBounds(((cambiarImg.screenSize.width / 12)*5),((cambiarImg.screenSize.height / 7)*3),(cambiarImg.screenSize.width / 12)*2,(cambiarImg.screenSize.width / 35));
		JTFContrasenya.setBorder(cambiarImg.bordeN);
		
		//labels//
		JLabel JLUsuario = new  JLabel();
		JLUsuario.setBounds(((cambiarImg.screenSize.width / 12)*5),((cambiarImg.screenSize.height / 7)*2 - (cambiarImg.screenSize.width / 45)),	((cambiarImg.screenSize.width / 12)),(cambiarImg.screenSize.width / 45));
		JLUsuario.setText("<html><center>Usuario");
		JLUsuario.setForeground(Color.BLACK);
		JLUsuario.setFont(new Font("Stika Text",Font.BOLD,(cambiarImg.screenSize.height/70)));
		JLUsuario.setBackground(cambiarImg.color1);
		JLUsuario.setBorder(cambiarImg.bordeN);
		JLUsuario.setOpaque(true);
		
		
		JLabel JLcontrasenya = new  JLabel();
		JLcontrasenya.setBounds(((cambiarImg.screenSize.width / 12)*5),((cambiarImg.screenSize.height / 7)*3 - (cambiarImg.screenSize.width / 45)),((cambiarImg.screenSize.width / 12)),(cambiarImg.screenSize.width / 45));
		JLcontrasenya.setText("<html><center>Contrasenya");
		JLcontrasenya.setForeground(Color.BLACK);
		JLcontrasenya.setFont(new Font("Stika Text",Font.BOLD,(cambiarImg.screenSize.height/70)));
		JLcontrasenya.setBackground(cambiarImg.color1);
		JLcontrasenya.setBorder(cambiarImg.bordeN);
		JLcontrasenya.setOpaque(true);
		
		//botones//
		BotonIniciarSesion = new  BotonIniciarSesion(this);
		BotonIniciarSesion.setBounds(((cambiarImg.screenSize.width / 2)-((cambiarImg.screenSize.width / 12))),((cambiarImg.screenSize.height / 7)*4 - (cambiarImg.screenSize.width / 50)),((cambiarImg.screenSize.width / 12)), (cambiarImg.screenSize.width / 45));
		BotonIniciarSesion.setOpaque(true);
		
		BotonRegistrarse = new  BotonRegistrarse(this);
		BotonRegistrarse.setBounds((cambiarImg.screenSize.width / 2),((cambiarImg.screenSize.height / 7)*4 - (cambiarImg.screenSize.width / 50)),((cambiarImg.screenSize.width / 12)),(cambiarImg.screenSize.width / 45));
		BotonRegistrarse.setOpaque(true);
		
		add(BotonIniciarSesion);
		add(BotonRegistrarse);
		add(JLUsuario);
		add(JTFUsuario);
		add(JLcontrasenya);
		add(JTFContrasenya);
		
	}
	/**
	 * Este metodo devuelve el contenido del campo usuario 
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
	 * Este metodo cambia el panel {@link JF_PanelInicioSesion } por el panel {@link JF_PanelRegistrarse}
	 */
	public void irPanelRegistrarse() {
		JFrame marcoP = (JFrame) SwingUtilities.getWindowAncestor(this);
		marcoP.remove(this);
		marcoP.add(new JF_PanelRegistrarse());
		marcoP.setVisible(true);
	}
	/**
	 * Este metodo cambia el panel {@link JF_PanelInicioSesion } por el panel {@link JF_PanelMenu}
	 */
	public void irMenu() {
		JFrame marcoP = (JFrame)SwingUtilities.getWindowAncestor(this);	
		marcoP.remove(this);
		marcoP.add(new JF_PanelMenu());
		marcoP.setVisible(true);
	}
}
