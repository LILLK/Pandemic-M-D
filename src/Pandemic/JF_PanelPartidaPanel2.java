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
import Logico.Partida;

public class JF_PanelPartidaPanel2 extends JPanel {

	
	Dimension screenSize;
	BotonGuardarPartida BotonGuardarPartida;
	public JF_PanelPartidaPanel2() {

		int tamañoX = 40;
		int tamañoY = 40;

		cambiarImg img = new cambiarImg();
		Color color = new Color(71, 161, 197);
		Border borde = BorderFactory.createLineBorder(Color.BLACK, 3);
		screenSize = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
		setLayout(null);
		this.setBounds(1551, this.screenSize.height / 2 + 1, (this.screenSize.width - 1550),(this.screenSize.height / 2) - 23);
		this.setBackground(color);
		this.setBorder(borde);
		this.setOpaque(true);
		
		
		JLabel acciones = new JLabel();
		JLabel log = new JLabel();
		BotonGuardarPartida = new BotonGuardarPartida(this);


		

		acciones.setBounds((this.getWidth()/2)-((this.getWidth()/2)/2),
				((this.getHeight()/16)),
				this.getWidth()/2,
				this.getHeight()/15);
		acciones.setBackground(Color.orange);
		acciones.setVisible(true);
		acciones.setBorder(borde);
		acciones.setOpaque(true);
		acciones.setText("numero de acciones restantes");
		
		log.setBounds((this.getWidth()/2)-((this.getWidth()/2)/2),
				((this.getHeight()/16)*2),
				this.getWidth()/2,
				this.getHeight()/2);
		log.setBackground(Color.WHITE);
		log.setVisible(true);
		log.setBorder(borde);
		log.setOpaque(true);
		log.setText("has infectado....se a curado...");
		
		
	
		
		add(BotonGuardarPartida);
		add(acciones);
		add(log);


	}

}
