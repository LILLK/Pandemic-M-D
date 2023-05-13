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
import oracle.security.o3logon.a;

public class JF_PanelPartidaPanel2 extends JPanel {

	static  JLabel log = new JLabel();
	static String logText ;
	static JLabel acciones = new JLabel();
	Dimension screenSize;
	BotonGuardarPartida BotonGuardarPartida;
	public JF_PanelPartidaPanel2() {



		Color color = new Color(71, 161, 197);
		Border borde = BorderFactory.createLineBorder(Color.BLACK, 3);
		screenSize = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
		setLayout(null);
		this.setBounds(1551, this.screenSize.height / 2 + 1, (this.screenSize.width - 1550), (this.screenSize.height / 2) - 23);
		this.setOpaque(true);
		
		
		acciones = new JLabel();
		log = new JLabel();
		BotonGuardarPartida = new BotonGuardarPartida(this);	

		acciones.setBounds(20, this.getHeight()/100, this.getWidth()-40, this.getHeight()/100*15);
		acciones.setBackground(Color.orange);
		acciones.setVisible(true);
		acciones.setBorder(borde);
		acciones.setOpaque(true);
		acciones.setHorizontalAlignment(SwingConstants.CENTER);
		acciones.setFont(new Font("Stika Text",Font.BOLD,21) );
		acciones.setText("Acciones restantes: "+Partida.accionesRonda);
		
		log.setBounds(20, this.getHeight()/100*15, this.getWidth()-40, this.getHeight()/100*75);
		log.setBackground(Color.WHITE);
		log.setVisible(true);
		log.setBorder(borde);
		log.setOpaque(true);
		log.setText(logText=" ");
		
		add(BotonGuardarPartida);
		add(acciones);
		add(log);


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
			System.out.print("Error IMGfondo JF_PanelPartidaPanel2");
		}
	} 
	public static void updateLog(String newTexto) {
		String resultado="<p>"+newTexto+"</p>";
		logText += resultado;
		log.setText("<html>"+logText+"</html>");
	}
	
	public static void updateAcciones() {
		acciones.setText("acciones restantes: "+Partida.accionesRonda);
	}
	
	public static void restarAcciones() {
		Partida.accionesRonda--;
		acciones.setText("acciones restantes: "+Partida.accionesRonda);
	}
	
	
	
}
