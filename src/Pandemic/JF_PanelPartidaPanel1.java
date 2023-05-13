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
import Logico.Parametros;
import Logico.Partida;
import oracle.security.o3logon.a;

public class JF_PanelPartidaPanel1 extends JPanel {

	static JLabel puntuacion;
	static JLabel brotes;
	static JLabel ronda;
	Dimension screenSize;

	public JF_PanelPartidaPanel1() {

		cambiarImg img = new cambiarImg();
		Border borde = BorderFactory.createLineBorder(Color.BLACK, 3);
		screenSize = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
		setLayout(null);
		this.setBounds(1551, 1, (this.screenSize.width - 1550), this.screenSize.height / 2);
		this.setOpaque(true);

		puntuacion = new JLabel();
		brotes = new JLabel();
		ronda = new JLabel();

		puntuacion.setBounds((this.getWidth() / 10) *1, ((this.getHeight() / 12) * 3), (this.getWidth() / 10) *8, this.getHeight() / 7);
		puntuacion.setBackground(Color.orange);
		puntuacion.setVisible(true);
		puntuacion.setBorder(borde);
		puntuacion.setOpaque(true);
		puntuacion.setHorizontalAlignment(SwingConstants.CENTER);
		puntuacion.setFont(new Font("Stika Text",Font.BOLD,21) );
		puntuacion.setText("la puntuacion es de: " + Partida.Puntuacion);

		brotes.setBounds((this.getWidth() / 10) *1, ((this.getHeight() / 12) * 5), (this.getWidth() / 10) *8, this.getHeight() / 7);
		brotes.setBackground(Color.orange);
		brotes.setVisible(true);
		brotes.setBorder(borde);
		brotes.setHorizontalAlignment(SwingConstants.CENTER);
		brotes.setFont(new Font("Stika Text",Font.BOLD,23) );
		brotes.setOpaque(true);
		brotes.setText("Brotes: " + Partida.brotes + "/" + Parametros.brotesTotal);

		ronda.setBounds((this.getWidth() / 10) *1, ((this.getHeight() / 12) * 7),  (this.getWidth() / 10) *8, this.getHeight() / 7);
		ronda.setBackground(Color.orange);
		ronda.setVisible(true);
		ronda.setBorder(borde);
		ronda.setHorizontalAlignment(SwingConstants.CENTER);
		ronda.setFont(new Font("Stika Text",Font.BOLD,23) );
		ronda.setOpaque(true);
		ronda.setText("Ronda :" + Partida.ronda);
		
		
		
		add(ronda);
		add(brotes);
		add(puntuacion);
	}
	
	
	public void paint(Graphics g) {
		BufferedImage imgFondo;
		try {
			Dimension size =getSize();
			imgFondo = ImageIO.read(new File("imagenes/fondo_2.png"));
			g.drawImage(imgFondo, 0, 0, size.width, size.height,null);
			setOpaque(false);
			super.paint(g);
		} catch (IOException e) {
			System.out.print("Error IMGfondo JF_PanelPartidaPanel1");
		}
	} 
	
	public static void updatePuntuacion() {
		puntuacion.setText("la puntuacion es de: " + Partida.Puntuacion);
	}
	public static void updateRonda() {
		ronda.setText("Ronda :" + Partida.ronda);
	}
	public static void updateBrotes() {
		brotes.setText("Brotes: " + Partida.brotes + "/" + Parametros.brotesTotal);
	}
	
	public void irMenu() {
		JFrame marcoP = (JFrame)SwingUtilities.getWindowAncestor(this);	
		marcoP.remove(this);
		marcoP.add(new JF_PanelMenu());
		marcoP.setVisible(true);
	}
}
