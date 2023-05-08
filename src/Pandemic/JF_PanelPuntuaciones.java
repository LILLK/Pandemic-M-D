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
	private static final String URL = "jdbc:oracle:thin:@oracle.ilerna.com:1521:xe";
	public JF_PanelPuntuaciones() {
		
		JF_PanelPuntuaciones.rankings = new ArrayList<Rankings>();
		setLayout(null);
		ConexionBD ds= new ConexionBD();
		this.screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		Connection con = conectarBaseDatos();
		Color color = new Color(71, 161, 197);
		Border borde = BorderFactory.createLineBorder(Color.BLACK,6);
		Border borde1 = BorderFactory.createLineBorder(Color.WHITE,2);
		//ranking rk = new ranking();
		ds.cargarRanking(con);
		JScrollPane scroll = new JScrollPane();
		scroll.setBounds(100,100,820,450);
		//scroll.getVerticalScrollBar().setBackground(Color.BLACK);
		scroll.getVerticalScrollBar().setUI(new BasicScrollBarUI());
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		int i =0;
		for(Rankings ranking : JF_PanelPuntuaciones.rankings) {
			JLabel label = new JLabel();
			label.setBounds(0, 0+(100*i), 800,100 );
			label.setBackground(color);
			label.setBorder(borde);
			/*label.setText(i+"                                    "+
					ranking.nomb_us+"                            "+
					ranking.brotes+"                         "+
					ranking.puntuacion+"                     "+
					ranking.dificultad+"                    "+
					ranking.ronda);*/
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
			JLabel dificultad = new JLabel();
			String dificultadS ="<html><center>"+ranking.dificultad;
			dificultad.setText(dificultadS);
			dificultad.setHorizontalAlignment(SwingConstants.CENTER);
			dificultad.setBounds(360,32,25,35);
			dificultad.setFont(new Font("Stika Text",Font.BOLD,32));
			dificultad.setForeground(Color.white);
			dificultad.setBackground(Color.BLACK);
			dificultad.setBorder(borde1);
			dificultad.setOpaque(true);
			label.add(dificultad);
			//////////////////
			JLabel brotes = new JLabel();
			String brotesS ="<html><center>"+ranking.brotes;
			brotes.setText(brotesS);
			brotes.setHorizontalAlignment(SwingConstants.CENTER);
			brotes.setBounds(420,32,25,35);
			brotes.setFont(new Font("Stika Text",Font.BOLD,32));
			brotes.setForeground(Color.white);
			brotes.setBackground(Color.BLACK);
			brotes.setBorder(borde1);
			brotes.setOpaque(true);
			label.add(brotes);
			//////////////////
			//////////////////
			JLabel ronda = new JLabel();
			String rondaS ="<html><center>"+ranking.ronda;
			ronda.setText(rondaS);
			ronda.setHorizontalAlignment(SwingConstants.CENTER);
			ronda.setBounds(480,32,25,35);
			ronda.setFont(new Font("Stika Text",Font.BOLD,32));
			ronda.setForeground(Color.white);
			ronda.setBackground(Color.BLACK);
			ronda.setBorder(borde1);
			ronda.setOpaque(true);
			label.add(ronda);
			//////////////////
			//////////////////
			JLabel puntos = new JLabel();
			String puntosS ="<html><center>"+ranking.puntuacion;
			puntos.setText(puntosS);
			puntos.setHorizontalAlignment(SwingConstants.CENTER);
			puntos.setBounds(600,32,100,35);
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
		
		scroll.setViewportView(panel);
		
		
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
