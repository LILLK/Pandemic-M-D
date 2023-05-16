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
 * Esta classe es donde se construye el Panel Menu
 * @author DAME
 */
public class JF_PanelMenu extends JPanel {
	/**
	 * boton que vuelve al panel de inicio sesion
	 */
	BotonLogOut BotonLogOut;
	/**
	 * boton para crear una nueva partida
	 */
	BotonNuevaPartida NuevaPartida;
	/**
	 * boton para cargar una nueva partida
	 */
	BotonCargarPartida CargarPartida;
	/**
	 * boton para ir al panel informacion
	 */
	BotonInformacion Infromacion;
	/**
	 * boton para inr al panel puntuaciones
	 */
	BotonPuntuaciones ResumenPuntuaciones;
	/**
	 * boton para ir al panel autores
	 */

	BotonAutores Autores;
	/**
	 * boton para ir al boton version
	 */
	BotonVersion Version;
	/**
	 * boton para salir del programa
	 */
	BotonSalir Salir;
	
	/**
	 * Constructor del Panel Menu.
	 * Aqui hay varios botones que dirijen al usuario por el programa
	 * @author DAME
	 */
	JF_PanelMenu(){
		setLayout(null);
		this.NuevaPartida = new BotonNuevaPartida(this);
		this.CargarPartida = new BotonCargarPartida(this);
		this.Infromacion = 	new BotonInformacion(this);
		this.ResumenPuntuaciones = 	new BotonPuntuaciones(this);
		this.Autores =new BotonAutores(this);
		this.Version = 	new BotonVersion(this);
		this.Salir = new BotonSalir();
		this.BotonLogOut = new BotonLogOut(this);
		
		//se establece la posicion y el tamaño de los componentes dependiendo del tamaño de la pantalla 
		this.NuevaPartida.setBounds			(((cambiarImg.screenSize.width/2)-(cambiarImg.screenSize.width/10)),(cambiarImg.screenSize.height/6),(cambiarImg.screenSize.width/5),(cambiarImg.screenSize.width/20));
		this.CargarPartida.setBounds		(((cambiarImg.screenSize.width/2)-(cambiarImg.screenSize.width/10)),((cambiarImg.screenSize.height/6)+(cambiarImg.screenSize.width/18)),(cambiarImg.screenSize.width/5),(cambiarImg.screenSize.width/20));
		this.Infromacion.setBounds			(((cambiarImg.screenSize.width/2)-(cambiarImg.screenSize.width/10)),(cambiarImg.screenSize.height/6+((cambiarImg.screenSize.width/18)*2)),(cambiarImg.screenSize.width/5),(cambiarImg.screenSize.width/20));
		this.ResumenPuntuaciones.setBounds	(((cambiarImg.screenSize.width/2)-(cambiarImg.screenSize.width/10)),(cambiarImg.screenSize.height/6+((cambiarImg.screenSize.width/18)*3)),(cambiarImg.screenSize.width/5),(cambiarImg.screenSize.width/20));
		this.Autores.setBounds				(((cambiarImg.screenSize.width/2)-(cambiarImg.screenSize.width/10)),(cambiarImg.screenSize.height/6+((cambiarImg.screenSize.width/18)*4)),(cambiarImg.screenSize.width/5),(cambiarImg.screenSize.width/20));
		this.Version.setBounds				(((cambiarImg.screenSize.width/2)-(cambiarImg.screenSize.width/10)),(cambiarImg.screenSize.height/6+((cambiarImg.screenSize.width/18)*5)),(cambiarImg.screenSize.width/5),(cambiarImg.screenSize.width/20));
		this.Salir.setBounds				(((cambiarImg.screenSize.width/2)-(cambiarImg.screenSize.width/10)),(cambiarImg.screenSize.height/6+((cambiarImg.screenSize.width/18)*6)),(cambiarImg.screenSize.width/5),(cambiarImg.screenSize.width/20));
		this.BotonLogOut.setBounds((cambiarImg.screenSize.width/10)*9, (cambiarImg.screenSize.height/10), cambiarImg.screenSize.height/10, cambiarImg.screenSize.width/14);
	
		add(this.BotonLogOut);
		add(this.NuevaPartida);
		add(this.CargarPartida);
		add(this.Infromacion);
		add(this.ResumenPuntuaciones);
		add(this.Autores);
		add(this.Version);
		add(this.Salir);
		
	}
	/**
	 * Este metodo se usa para dibujar una imagen de fondo en un JPanel 
	 * y configurar la opacidad del JPanel para mostrar la imagen de fondo.
	 *@author DAME
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
	
	/**
	 * Metodo que cambia este por el panel JF_PanelAutores
	 * @author DAME
	 */
	public void irPanelAutores() {
		JFrame marcoP = (JFrame)SwingUtilities.getWindowAncestor(this);	
		marcoP.remove(this);
		marcoP.add(new JF_PanelAutores());
		marcoP.setVisible(true);
	}
	/**
	 * Metodo que cambia este por el panel JF_PanelInfo
	 * @author DAME
	 */
	public void irPanelInformacion() {
		JFrame marcoP = (JFrame)SwingUtilities.getWindowAncestor(this);	
		marcoP.remove(this);
		marcoP.add(new JF_PanelInfo());
		marcoP.setVisible(true);
	}
	/**
	 * Metodo que cambia este por el panel JF_PanelVersion
	 * @author DAME
	 */
	public void irPanelVersion() {
		JFrame marcoP = (JFrame)SwingUtilities.getWindowAncestor(this);	
		marcoP.remove(this);
		marcoP.add(new JF_PanelVersion());
		marcoP.setVisible(true);
	}
	/**
	 * Metodo que cambia este por el panel JF_PanelPuntuaciones
	 * @author DAME
	 */
	public void irPanelPuntuacion() {
		JFrame marcoP = (JFrame)SwingUtilities.getWindowAncestor(this);	
		marcoP.remove(this);
		marcoP.add(new JF_PanelPuntuaciones());
		marcoP.setVisible(true); 
	}
	/**
	 * Metodo que cambia este por el panel JF_PanelPartidaDificultad
	 * @author DAME
	 */
	public void irPanelPartidaDificultad() {
		JFrame marcoP = (JFrame)SwingUtilities.getWindowAncestor(this);	
		marcoP.remove(this);
		marcoP.add(new JF_PanelPartidaDificultad());
		marcoP.setVisible(true); 
	}
	/**
	 * Metodo que cambia este por el panel JF_PanelInicioSesion
	 * @author DAME
	 */
	public void irPanelIniciarSesion() {
		JFrame marcoP = (JFrame) SwingUtilities.getWindowAncestor(this);
		marcoP.remove(this);
		marcoP.add(new JF_PanelInicioSesion());
		marcoP.setVisible(true);
	}
	/**
	 * Metodo que cambia este por el panel JF_PanelCargarPartida
	 * @author DAME
	 */
	public void irPanelCargarPartida() {
		JFrame marcoP = (JFrame) SwingUtilities.getWindowAncestor(this);
		marcoP.remove(this);
		marcoP.add(new JF_PanelCargarPartida());
		marcoP.setVisible(true);
	}
}
