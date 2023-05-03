package Pandemic;

import java.awt.Color;
import java.awt.Dimension;


import java.awt.Graphics;
import java.awt.ScrollPane;
import java.awt.Scrollbar;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

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
		
		JF_PanelPuntuaciones.rankings = new ArrayList<Rankings>();
		setLayout(null);
		ConexionBD ds= new ConexionBD();
		this.screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		Connection con = conectarBaseDatos();
		Color color = new Color(71, 161, 197);
		Border borde = BorderFactory.createLineBorder(Color.BLACK,6);
		
		//ranking rk = new ranking();
		ds.cargarRanking(con);
		ScrollPane p = new ScrollPane();
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(800,100));
		int i =0;
		for(Rankings ranking : JF_PanelPuntuaciones.rankings) {
			JLabel label = new JLabel();
			label.setBounds(0, 0+(100*i), 790,100 );
			label.setBackground(color);
			label.setBorder(borde);
			label.setText(ranking.brotes+ranking.nomb_us);
			
			label.setVisible(true);
			label.setOpaque(true);
			p.add(label);
			//p.updateUI();
			i++;
		}
		p.setLayout(null);
		//p.setViewportView(panel);
		//p.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		p.setBounds(100,100,800,500);
		//Scene s = new Scene(p,800,300);
		//p.setPreferredSize(new Dimension(800,1000));
		Scrollbar sp = new Scrollbar(Scrollbar.VERTICAL);
		//p.setViewport(new JViewport());
		//sp.setViewportView(p);
		
		p.add(sp);
		
		//JF_ScrolRank rank = new JF_ScrolRank();
		add(p);
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
