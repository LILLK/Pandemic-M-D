//Mehdi Tahrat && David hola
package Pandemic;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import Botones.BotonAtras;
/**
 * Esta classe es el panel de autores.
 * En el se encuentran 2 imagenes de los autores con un pequeño texto de estos.
 * @author DAME
 *
 */
public class JF_PanelAutores extends JPanel  {
	/**
	 * Este boton vuelve al menu.
	 * {@link BotonAtras}
	 */
	BotonAtras Atras;
	/**
	 * Panel del menu 
	 * {@link JF_PanelMenu}
	 */
	JF_PanelMenu JF_PanelMenu;
	
	public JF_PanelAutores()  {
	
		setLayout(null);
		//Importar Objetos
		this.Atras = new BotonAtras(this);
		cambiarImg img = new cambiarImg();
		JLabel imagenDavid = new JLabel();
		JLabel imgDavidDesc = new JLabel();
		JLabel imagenMehdi = new JLabel();
		JLabel imgMehdiDesc = new JLabel();
		
		//Contenido JLabels
		//IMAGENES//
		imagenDavid.setIcon(img.tamanyo(new ImageIcon("imagenes/fotoDavid.png"),(cambiarImg.screenSize.height/3),(cambiarImg.screenSize.height/4)));
		imagenMehdi.setIcon(img.tamanyo(new ImageIcon("imagenes/imagenMehdi.png"), (cambiarImg.screenSize.height/3), (cambiarImg.screenSize.height/4)));
		imgDavidDesc.setText("<html><center>DAVID CALIN HOLA<p>Tengo 18 años y estudio programación web. Me apasiona todo lo relacionado con la tecnologia "
				+ "							y la informática, especialmente los videojuegos. Me encanta aprender sobre nuevos lenguajes de programacion y "
				+ "							diseñar mis propios juegos en mi tiempo libre. Espero poder seguir creciendo en esta carrera y convertirme en un"
				+ "							desarrollador web exitoso.");
		//TEXTO//
		imgMehdiDesc.setText("<html><center>Mehdi Tharat<p>Soy un estudiante de 20 años apasionado por la informatica y la programcación. Me encanta trabajar"
				+ "							con números y desentrañar problemas matemáticos complejos. Estoy en constante búsqueda de nuevas tecnologías y lenguajes "
				+ "							programación que me permitan mejorar mia habitidades y conocimientos.Mi objetivo es convertirme en un experto en"
				+ "							programación.");
		
		
		//Atributos Descripcion David
		imgDavidDesc.setBackground(cambiarImg.color1);//Color Fondo
		imgDavidDesc.setForeground(Color.black);//Color Letras
		imgDavidDesc.setFont(new Font("Stika Text",Font.BOLD,(cambiarImg.screenSize.height/52)));//Fuente del texto
		imgDavidDesc.setOpaque(true);
		imgDavidDesc.setVisible(true);
		
		//Atributos Imagen Mehdi
		imgMehdiDesc.setBackground(cambiarImg.color1);//Color Fondo
		imgMehdiDesc.setForeground(Color.black);//Color Letras
		imgMehdiDesc.setFont(new Font("Stika Text",Font.BOLD,(cambiarImg.screenSize.height/52)));//Fuente Texto
		imgMehdiDesc.setOpaque(true);
		imgMehdiDesc.setVisible(true);
		
		imagenMehdi.setBorder(cambiarImg.bordeN);
		imagenDavid.setBorder(cambiarImg.bordeN);
		
		//Tamaño Objetos//
		imagenDavid.setBounds	((cambiarImg.screenSize.width/2)-(cambiarImg.screenSize.height/5)-(cambiarImg.screenSize.height/3),(cambiarImg.screenSize.height/8), (cambiarImg.screenSize.height/3),(cambiarImg.screenSize.height/4));
		imgDavidDesc.setBounds	((cambiarImg.screenSize.width/2)-(cambiarImg.screenSize.height/5)-(cambiarImg.screenSize.height/3),(cambiarImg.screenSize.height/8)+(cambiarImg.screenSize.height/4), (cambiarImg.screenSize.height/3),(cambiarImg.screenSize.height/3));
		imagenMehdi.setBounds	((cambiarImg.screenSize.width/2)+(cambiarImg.screenSize.height/5),(cambiarImg.screenSize.height/8), (cambiarImg.screenSize.height/3),(cambiarImg.screenSize.height/4));
		imgMehdiDesc.setBounds	((cambiarImg.screenSize.width/2)+(cambiarImg.screenSize.height/5),(cambiarImg.screenSize.height/8)+(cambiarImg.screenSize.height/4),(cambiarImg.screenSize.height/3),(cambiarImg.screenSize.height/3));
		Atras.setBounds(0,(cambiarImg.screenSize.height-((cambiarImg.screenSize.width/20)-3)),cambiarImg.screenSize.width,(cambiarImg.screenSize.width/25));
		
		//Añadir Objetos
		add(imgDavidDesc);
		add(imagenDavid);
		add(imagenMehdi);
		add(imgMehdiDesc);
		add(this.Atras);
		
	}
	/**
	 * Este metodo cambia el panel {@link JF_PanelAutores} por el panel {@link JF_PanelMenu}
	 */
	public void irMenu() {
		JFrame marcoP = (JFrame)SwingUtilities.getWindowAncestor(this);	
		marcoP.remove(this);
		marcoP.add(new JF_PanelMenu());
		marcoP.setVisible(true);
	}
/**
 * Este metodo pinta el fondo de la pantalla
 */
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
