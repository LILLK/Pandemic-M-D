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

import Botones.BotonAtras;

public class JF_PanelInfo extends JPanel {
	
	BotonAtras Atras;
	Dimension screenSize;
	
	public JF_PanelInfo() {
	
		setLayout(null);
		this.screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		String s ="Hace 48 días conseguimos hacer mutar el virus T, pero nada salió como teníamos planeado. El\r\n"
				+ "virus tras mutar genero cuatro nuevas variantes de esté, y se dividieron por todo el mundo de\r\n"
				+ "forma homogénea infectando ciudad a ciudad y tu objetivo es salvar el mundo de esta\r\n"
				+ "pandemia.\r\n"
				+ "Para ello tendrás que moverte de ciudad en ciudad para desinfectar todas las ciudades o\r\n"
				+ "desarrollar las vacunas de los cuatro virus. Por la contraparte si una ciudad se infecta y se le\r\n"
				+ "acumulan con un total de 3 enfermedades, las ciudades colindantes se les añadirá una\r\n"
				+ "enfermedad y se genera 1 brote. Así que ten cuidado, porque al llegar a cierto número de\r\n"
				+ "brotes o que todas las ciudades se hayan infectado, significara el fin del mundo y de la partida.\r\n"
				+ "Por cada ronda tendrás 4 puntos de acción y estas son las acciones que puedes hacer\r\n"
				+ "Moverte: -1pa (“dev; No sé qué limites hay para moverse ni como se moverá”)\r\n"
				+ "Desarrollar vacuna: -1pa (Depende de la ciudad donde estés, desarrollaras un porcentaje de la\r\n"
				+ "vacuna)\r\n"
				+ "Quitar enfermedad: -1pa (Si tienes una ciudad colindante a ti infectada puedes bajar en 1 sus\r\n"
				+ "enfermedades)\r\n"
				+ "Habrá un sistema de puntuación que conistira en (“dev: falta por decidir”). Y tranquilo, el\r\n"
				+ "mundo puede esperar por ti “nombre del usuario”, por eso podrás guardar tus avances\r\n"
				+ "salvando el mundo y volver en cualquier momento.";
		this.Atras = new BotonAtras(this);
		JTextField Info = new JTextField(s);
		Border borde = BorderFactory.createLineBorder(Color.BLACK);
		Info.setBounds(100,100,800,600);
		Atras.setBounds(0,(this.screenSize.height-((screenSize.width/20)+4)),this.screenSize.width,(screenSize.width/25));
		Info.setForeground(Color.GRAY);
		Info.setBackground(Color.BLACK);
		Info.setBorder(borde);
	   // Info.setHorizontalAlignment(Info.CENTER);
	    //Info.setHorizontalAlignment(Info.LEFT);
	
	    Info.setHorizontalAlignment(Info.LEFT);
		Info.setVisible(true);
		Info.setOpaque(true);
		add(this.Atras);
		add(Info);
		
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
			imgFondo = ImageIO.read(new File("imagenes/imagenPandemic.png"));
			g.drawImage(imgFondo, 0, 0, size.width, size.height,null);
			setOpaque(false);
			super.paint(g);
		} catch (IOException e) {
			System.out.print("Error IMGfondo JF_PanelMenuMenu");
		}
		
		
	} 

}
