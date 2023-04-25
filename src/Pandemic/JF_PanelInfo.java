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
		String s ="<html><center>Hace 48 días conseguimos hacer mutar el virus T, pero nada salió como teníamos planeado. El<p>"
				+ "<html><center>virus tras mutar genero cuatro nuevas variantes de esté, y se dividieron por todo el mundo de<p>"
				+ "<html><center>forma homogénea infectando ciudad a ciudad y tu objetivo es salvar el mundo de esta<p>"
				+ "<html><center>pandemia.<p>"
				+ "<html><center>Para ello tendrás que moverte de ciudad en ciudad para desinfectar todas las ciudades o<p>"
				+ "<html><center>desarrollar las vacunas de los cuatro virus. Por la contraparte si una ciudad se infecta y se le<p>"
				+ "<html><center>acumulan con un total de 3 enfermedades, las ciudades colindantes se les añadirá una<p>"
				+ "<html><center>enfermedad y se genera 1 brote. Así que ten cuidado, porque al llegar a cierto número de<p>"
				+ "<html><center>brotes o que todas las ciudades se hayan infectado, significara el fin del mundo y de la partida.<p>"
				+ "<html><center>Por cada ronda tendrás 4 puntos de acción y estas son las acciones que puedes hacer<p>"
				+ "<html><center>Moverte: -1pa (“dev; No sé qué limites hay para moverse ni como se moverá”)<p>"
				+ "<html><center>Desarrollar vacuna: -1pa (Depende de la ciudad donde estés, desarrollaras un porcentaje de la<p>"
				+ "<html><center>vacuna)<p>"
				+ "<html><center>Quitar enfermedad: -1pa (Si tienes una ciudad colindante a ti infectada puedes bajar en 1 sus<p>"
				+ "<html><center>enfermedades)<p>"
				+ "<html><center>Habrá un sistema de puntuación que conistira en (“dev: falta por decidir”). Y tranquilo, el<p>"
				+ "<html><center>mundo puede esperar por ti “nombre del usuario”, por eso podrás guardar tus avances<p>"
				+ "<html><center>salvando el mundo y volver en cualquier momento.";
		this.Atras = new BotonAtras(this);
		JLabel Info = new JLabel();
		Border borde = BorderFactory.createLineBorder(Color.BLACK,8);
		Color color =new Color(63, 98, 152);
		JLabel TInfo = new JLabel();
		
		TInfo.setBounds(((this.screenSize.width/2)-400),180,800,100);
		TInfo.setText("Informacion del Juego");
		TInfo.setForeground(Color.BLACK);
		TInfo.setFont(new Font("Stika Text",Font.BOLD,73));
		TInfo.setBackground(color);
		TInfo.setBorder(borde);
		
		Info.setBounds(((this.screenSize.width/2)-275),300,550,600);
		Info.setText(s);
		Info.setForeground(Color.BLACK);
		Info.setFont(new Font("Stika Text",Font.BOLD,12));
		Info.setBackground(color);
		Info.setBorder(borde);
		
		Atras.setBounds(0,(this.screenSize.height-((screenSize.width/20)-3)),this.screenSize.width,(screenSize.width/25));
	   // Info.setHorizontalAlignment(Info.CENTER);
	    //Info.setHorizontalAlignment(Info.LEFT);
	
	    //Info.setHorizontalAlignment(Info.LEFT);
		TInfo.setVisible(true);
		Info.setVisible(true);
		Info.setOpaque(true);
		TInfo.setOpaque(true);
		add(this.Atras);
		add(Info);
		add(TInfo);
		
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
			imgFondo = ImageIO.read(new File("imagenes/imagenPandemic6.png"));
			g.drawImage(imgFondo, 0, 0, size.width, size.height,null);
			setOpaque(false);
			super.paint(g);
		} catch (IOException e) {
			System.out.print("Error IMGfondo JF_PanelMenuMenu");
		}
		
		
	} 

}
