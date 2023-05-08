package Pandemic;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.ScrollPane;
import java.awt.Scrollbar;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.FieldPosition;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicScrollBarUI;

import Botones.BotonAtras;
import Logico.ConexionBD;
import Logico.Rankings;


public class JF_PanelPuntuaciones extends JPanel {

	BotonAtras Atras;
	Dimension screenSize;
	public static ArrayList<Rankings> rankings;
	private static final String USER = "DAW_PNDC22_23_DAME";
	private static final String PWD = "DM123";
	// Si estáis desde casa, la url será oracle.ilerna.com y no 192.168.3.26
	private static final String URL = "jdbc:oracle:thin:@192.168.3.26:1521:xe";
	public JF_PanelPuntuaciones() {
		
		
		setLayout(null);
		
		JScrollPane scroll = new JScrollPane();
		Connection con = conectarBaseDatos();
		Color color = new Color(71, 161, 197);
		Border borde = BorderFactory.createLineBorder(Color.BLACK,6);
		Border borde1 = BorderFactory.createLineBorder(Color.WHITE,2);
		JF_PanelPuntuaciones.rankings = new ArrayList<Rankings>();
		JPanel panel = new JPanel();
		JLabel posicion = new JLabel();
		JLabel nomUsu = new JLabel();
		JLabel dificultad = new JLabel();
		JLabel brotes = new JLabel();
		JLabel ronda = new JLabel();
		JLabel puntuacion = new JLabel();
		
		
		this.screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		ConexionBD.cargarRanking(con);
		
		scroll.setBounds((this.screenSize.width/2)-410,100,820,450);
		scroll.getVerticalScrollBar().setUI(new BasicScrollBarUI());
		scroll.setViewportView(panel);
		
		
		posicion.setText("Pos.");
		posicion.setBackground(Color.black);
		posicion.setForeground(Color.white);
		posicion.setHorizontalAlignment(SwingConstants.CENTER);
		posicion.setFont(new Font("Stika Text",Font.BOLD,20) );
		posicion.setBounds((this.screenSize.width/2)-410,50,80,50);
		posicion.setOpaque(true);
		posicion.setVisible(true);
		
		nomUsu.setText("Nombre Usuario");
		nomUsu.setBackground(Color.black);
		nomUsu.setForeground(Color.white);
		nomUsu.setHorizontalAlignment(SwingConstants.CENTER);
		nomUsu.setFont(new Font("Stika Text",Font.BOLD,20) );
		nomUsu.setBounds(((this.screenSize.width/2)-410)+80,50,240,50);
		nomUsu.setOpaque(true);
		nomUsu.setVisible(true);
		
		dificultad.setText("Dificultad");
		dificultad.setBackground(Color.black);
		dificultad.setForeground(Color.white);
		dificultad.setHorizontalAlignment(SwingConstants.CENTER);
		dificultad.setFont(new Font("Stika Text",Font.BOLD,20) );
		dificultad.setBounds(((this.screenSize.width/2)-410)+320,50,100,50);
		dificultad.setOpaque(true);
		dificultad.setVisible(true);
		
		brotes.setText("Brotes");
		brotes.setBackground(Color.black);
		brotes.setForeground(Color.white);
		brotes.setHorizontalAlignment(SwingConstants.CENTER);
		brotes.setFont(new Font("Stika Text",Font.BOLD,20) );
		brotes.setBounds(((this.screenSize.width/2)-410)+420,50,100,50);
		brotes.setOpaque(true);
		brotes.setVisible(true);
		
		ronda.setText("Ronda");
		ronda.setBackground(Color.black);
		ronda.setForeground(Color.white);
		ronda.setHorizontalAlignment(SwingConstants.CENTER);
		ronda.setFont(new Font("Stika Text",Font.BOLD,20) );
		ronda.setBounds(((this.screenSize.width/2)-410)+520,50,100,50);
		ronda.setOpaque(true);
		ronda.setVisible(true);
		
		puntuacion.setText("Puntuacion");
		puntuacion.setBackground(Color.black);
		puntuacion.setForeground(Color.white);
		puntuacion.setHorizontalAlignment(SwingConstants.CENTER);
		puntuacion.setFont(new Font("Stika Text",Font.BOLD,20) );
		puntuacion.setBounds(((this.screenSize.width/2)-410)+620,50,180,50);
		puntuacion.setOpaque(true);
		puntuacion.setVisible(true);
		
		panel.setLayout(null);
		
		int i =0;
		for(Rankings ranking : JF_PanelPuntuaciones.rankings) {
			JLabel label = new JLabel();
			label.setBounds(0, 0+(100*i), 800,100 );
			label.setBackground(color);
			label.setBorder(borde);

			JLabel pos = new JLabel();
			String posS = "<html><center>"+(i+1);
			pos.setText(posS);
			pos.setHorizontalAlignment(SwingConstants.CENTER);
			pos.setBounds(20,30,40,40);
			pos.setFont(new Font("Stika Text",Font.BOLD,38));
			pos.setForeground(Color.white);
			pos.setBackground(Color.BLACK);
			pos.setBorder(borde1);
			pos.setOpaque(true);
			label.add(pos);
			///////////////////
			JLabel nom = new JLabel();
			nom.setText(ranking.nomb_us);
			nom.setHorizontalAlignment(SwingConstants.CENTER);
			nom.setBounds(100,32,200,35);
			nom.setFont(new Font("Stika Text",Font.BOLD,32));
			nom.setForeground(Color.white);
			nom.setBackground(Color.BLACK);
			nom.setBorder(borde1);
			nom.setOpaque(true);
			label.add(nom);
			//////////////////
			JLabel dificultadU = new JLabel();
			String dificultadS ="<html><center>"+ranking.dificultad;
			dificultadU.setText(dificultadS);
			dificultadU.setHorizontalAlignment(SwingConstants.CENTER);
			dificultadU.setBounds(365,32,30,35);
			dificultadU.setFont(new Font("Stika Text",Font.BOLD,32));
			dificultadU.setForeground(Color.white);
			dificultadU.setBackground(Color.BLACK);
			dificultadU.setBorder(borde1);
			dificultadU.setOpaque(true);
			label.add(dificultadU);
			//////////////////
			JLabel brotesU = new JLabel();
			String brotesS ="<html><center>"+ranking.brotes;
			brotesU.setText(brotesS);
			brotesU.setHorizontalAlignment(SwingConstants.CENTER);
			brotesU.setBounds(465,32,30,35);
			brotesU.setFont(new Font("Stika Text",Font.BOLD,32));
			brotesU.setForeground(Color.white);
			brotesU.setBackground(Color.BLACK);
			brotesU.setBorder(borde1);
			brotesU.setOpaque(true);
			label.add(brotesU);
			//////////////////
			//////////////////
			JLabel rondaU = new JLabel();
			String rondaS ="<html><center>"+ranking.ronda;
			rondaU.setText(rondaS);
			rondaU.setHorizontalAlignment(SwingConstants.CENTER);
			rondaU.setBounds(565,32,30,35);
			rondaU.setFont(new Font("Stika Text",Font.BOLD,32));
			rondaU.setForeground(Color.white);
			rondaU.setBackground(Color.BLACK);
			rondaU.setBorder(borde1);
			rondaU.setOpaque(true);
			label.add(rondaU);
			//////////////////
			//////////////////
			JLabel puntos = new JLabel();
			String puntosS ="<html><center>"+ranking.puntuacion;
			puntos.setText(puntosS);
			puntos.setHorizontalAlignment(SwingConstants.CENTER);
			puntos.setBounds(640,32,150,35);
			puntos.setFont(new Font("Stika Text",Font.BOLD,32));
			puntos.setForeground(Color.white);
			puntos.setBackground(Color.BLACK);
			puntos.setBorder(borde1);
			puntos.setOpaque(true);
			label.add(puntos);
			//////////////////
			label.setVisible(true);
			label.setOpaque(true);
			panel.add(label);
			//p.updateUI();
			i++;
		}
	
		panel.setPreferredSize(new Dimension(800,100*i));
		
		add(posicion);
		add(nomUsu);
		add(dificultad);
		add(ronda);
		add(brotes);
		add(puntuacion);
		add(scroll);
		int x = 0; 
		int y = 0;
		
		
		
		
		
		
		this.Atras = new BotonAtras(this);
		Atras.setBounds(0,(this.screenSize.height-((screenSize.width/20)-3)),this.screenSize.width,(screenSize.width/25));
		add(this.Atras);
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
	public void irMenu() {
		JFrame marcoP = (JFrame)SwingUtilities.getWindowAncestor(this);	
		marcoP.remove(this);
		marcoP.add(new JF_PanelMenu());
		marcoP.setVisible(true);
	}

	private static Connection conectarBaseDatos() {
		Connection con = null;

		System.out.println("Intentando conectarse a la base de datos");

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(URL, USER, PWD);
			System.out.println("Conectados a la base de datos");
		} catch (ClassNotFoundException e) {
			System.out.println("No se ha encontrado el driver " + e);
		} catch (SQLException e) {
			System.out.println("Error en las credenciales o en la URL " + e);
		}
		

		//System.out.println("Conectados a la base de datos");

		return con;
	}
}
