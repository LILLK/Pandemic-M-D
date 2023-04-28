package Pandemic;

import java.awt.Dimension;

import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import Botones.BotonAtras;
import Logico.ConexionBD;
import Logico.ranking;

public class JF_PanelPuntuaciones extends JPanel {

	BotonAtras Atras;
	Dimension screenSize;
	public static ArrayList<ranking> ranking;
	private static final String USER = "DAW_PNDC22_23_DAME";
	private static final String PWD = "DM123";
	// Si estáis desde casa, la url será oracle.ilerna.com y no 192.168.3.26
	private static final String URL = "jdbc:oracle:thin:@192.168.3.26:1521:xe";
	public JF_PanelPuntuaciones() {
		
		ConexionBD ds= new ConexionBD();
		
		Connection con = conectarBaseDatos();
		//ranking rk = new ranking();
		ds.cargarRanking(con,this);
		JPanel p = new JPanel();
		p.setBounds(0,0,100,100);
		int x = 0; 
		int y = 0;
		for(int i =0 ; i< ranking.size();i++) {
			JLabel label = new JLabel();
			label.setBounds(x,y,p.WIDTH,50);
			p.add(label);
			p.updateUI();
			y = y+50;
			
		}
		
		setLayout(null);
		this.screenSize=Toolkit.getDefaultToolkit().getScreenSize();
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
