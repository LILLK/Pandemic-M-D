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

public class JF_PanelPartidaPanel1 extends JPanel {

	JLabel puntuacion;
	JLabel brotes;
	JLabel ronda;
	Dimension screenSize;

	public JF_PanelPartidaPanel1() {

		int tamañoX = 40;
		int tamañoY = 40;

		cambiarImg img = new cambiarImg();
		Color color = new Color(71, 161, 197);
		Border borde = BorderFactory.createLineBorder(Color.BLACK, 3);
		screenSize = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
		setLayout(null);
		this.setBounds(1551, 1, (this.screenSize.width - 1550), this.screenSize.height / 2);
		this.setBackground(color);
		this.setBorder(borde);
		this.setOpaque(true);

		puntuacion = new JLabel();
		brotes = new JLabel();
		ronda = new JLabel();
		

		puntuacion.setBounds((this.getWidth()/2)-((this.getWidth()/2)/2),
				((this.getHeight()/12)*4),
				this.getWidth()/2,
				this.getHeight()/15);
		puntuacion.setBackground(Color.orange);
		puntuacion.setVisible(true);
		puntuacion.setBorder(borde);
		puntuacion.setOpaque(true);
		puntuacion.setText("la puntuacion es de: "+Partida.Puntuacion);
		
		
		
		brotes.setBounds((this.getWidth()/2)-((this.getWidth()/2)/2),
				((this.getHeight()/12)*6),
				this.getWidth()/2,
				this.getHeight()/15);
		brotes.setBackground(Color.orange);
		brotes.setVisible(true);
		brotes.setBorder(borde);
		brotes.setOpaque(true);
		brotes.setText("Brotes: "+Partida.brotes+"/"+Parametros.brotesTotal);
		
		ronda.setBounds((this.getWidth()/2)-((this.getWidth()/2)/2),
				((this.getHeight()/12)*8),
				this.getWidth()/2,
				this.getHeight()/15);
		ronda.setBackground(Color.orange);
		ronda.setVisible(true);
		ronda.setBorder(borde);
		ronda.setOpaque(true);
		ronda.setText("Ronda :" + Partida.ronda);

		
		add(ronda);
		add(brotes);
		add(puntuacion);
	
		
	}

}
