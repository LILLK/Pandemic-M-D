//Mehdi Tahrat && David hola
package Pandemic;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicScrollBarUI;

import Botones.BotonAtras;
import Logico.ConexionBD;
import Logico.Rankings;

/**
 * Esta classe Crea el panel de puntuacion
 * Este panel contiene un label al cetro donde se muestran todas las partidas acabadas con puntuacion superior a 0
 * @author DAME
 *
 */
public class JF_PanelPuntuaciones extends JPanel {
	/**
	 * Este boton vuelve al menu.
	 * {@link BotonAtras}
	 */
	BotonAtras Atras;
	/**
	 * Lista de objetos ranking, donde se guardan los rankings de las partidas 
	 */
	public static ArrayList<Rankings> rankings;
	/**
	 * Este es el constructor del panel Puntacion
	 * Este panel contiene un label al cetro donde se muestran todas las partidas acabadas con puntuacion superior a 0
	 */
	public JF_PanelPuntuaciones() {
		
		
		setLayout(null);
		
		JScrollPane scroll = new JScrollPane();

		Border borde1 = BorderFactory.createLineBorder(Color.WHITE,2);
		
		JF_PanelPuntuaciones.rankings = new ArrayList<Rankings>();
		
		JPanel panel = new JPanel();
		JLabel posicion = new JLabel();
		JLabel nomUsu = new JLabel();
		JLabel dificultad = new JLabel();
		JLabel brotes = new JLabel();
		JLabel ronda = new JLabel();
		JLabel puntuacion = new JLabel();
		
		
		ConexionBD.cargarRanking();
		//creacion del panel contendor 
		//Scroll del panel 
		scroll.setBounds((cambiarImg.screenSize.width/2)-410,330,820,450);
		scroll.getVerticalScrollBar().setUI(new BasicScrollBarUI());
		scroll.setViewportView(panel);
		//posicion  
		posicion.setText("Pos.");
		posicion.setBackground(Color.black);
		posicion.setForeground(Color.white);
		posicion.setHorizontalAlignment(SwingConstants.CENTER);
		posicion.setFont(new Font("Stika Text",Font.BOLD,20) );
		posicion.setBounds((cambiarImg.screenSize.width/2)-410,280,80,50);
		posicion.setOpaque(true);
		posicion.setVisible(true);
		//nombre del usuario 
		nomUsu.setText("Nombre Usuario");
		nomUsu.setBackground(Color.black);
		nomUsu.setForeground(Color.white);
		nomUsu.setHorizontalAlignment(SwingConstants.CENTER);
		nomUsu.setFont(new Font("Stika Text",Font.BOLD,20) );
		nomUsu.setBounds(((cambiarImg.screenSize.width/2)-410)+80,280,240,50);
		nomUsu.setOpaque(true);
		nomUsu.setVisible(true);
		//dificultad 
		dificultad.setText("Dificultad");
		dificultad.setBackground(Color.black);
		dificultad.setForeground(Color.white);
		dificultad.setHorizontalAlignment(SwingConstants.CENTER);
		dificultad.setFont(new Font("Stika Text",Font.BOLD,20) );
		dificultad.setBounds(((cambiarImg.screenSize.width/2)-410)+320,280,100,50);
		dificultad.setOpaque(true);
		dificultad.setVisible(true);
		//brotes
		brotes.setText("Brotes");
		brotes.setBackground(Color.black);
		brotes.setForeground(Color.white);
		brotes.setHorizontalAlignment(SwingConstants.CENTER);
		brotes.setFont(new Font("Stika Text",Font.BOLD,20) );
		brotes.setBounds(((cambiarImg.screenSize.width/2)-410)+420,280,100,50);
		brotes.setOpaque(true);
		brotes.setVisible(true);
		//ronda
		ronda.setText("Ronda");
		ronda.setBackground(Color.black);
		ronda.setForeground(Color.white);
		ronda.setHorizontalAlignment(SwingConstants.CENTER);
		ronda.setFont(new Font("Stika Text",Font.BOLD,20) );
		ronda.setBounds(((cambiarImg.screenSize.width/2)-410)+520,280,100,50);
		ronda.setOpaque(true);
		ronda.setVisible(true);
		//puntuacion 
		puntuacion.setText("Puntuación");
		puntuacion.setBackground(Color.black);
		puntuacion.setForeground(Color.white);
		puntuacion.setHorizontalAlignment(SwingConstants.CENTER);
		puntuacion.setFont(new Font("Stika Text",Font.BOLD,20) );
		puntuacion.setBounds(((cambiarImg.screenSize.width/2)-410)+620,280,180,50);
		puntuacion.setOpaque(true);
		puntuacion.setVisible(true);
		
		panel.setLayout(null);
		
		int i =0;
		//por cada partida encontrada las anyadimos al panel creado antes
		for(Rankings ranking : JF_PanelPuntuaciones.rankings) {
			JLabel label = new JLabel();
			label.setBounds(0, 0+(100*i), 800,100 );
			label.setBackground(cambiarImg.color1);
			label.setBorder(cambiarImg.bordeN);
			//posicion de la partida en el ranking
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
			//nombre del usuario de esta partida
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
			//dificultad de de esta partida
			JLabel dificultadU = new JLabel();
			String dificultadS =" "+ranking.dificultad;
			dificultadU.setText(dificultadS);
			dificultadU.setHorizontalAlignment(SwingConstants.CENTER);
			dificultadU.setBounds(365,32,40,35);
			dificultadU.setFont(new Font("Stika Text",Font.BOLD,32));
			dificultadU.setForeground(Color.white);
			dificultadU.setBackground(Color.BLACK);
			dificultadU.setBorder(borde1);
			dificultadU.setOpaque(true);
			label.add(dificultadU);
			//brotes de de esta partida
			JLabel brotesU = new JLabel();
			String brotesS =" "+ranking.brotes;
			brotesU.setText(brotesS);
			brotesU.setHorizontalAlignment(SwingConstants.CENTER);
			brotesU.setBounds(465,32,50,35);
			brotesU.setFont(new Font("Stika Text",Font.BOLD,32));
			brotesU.setForeground(Color.white);
			brotesU.setBackground(Color.BLACK);
			brotesU.setBorder(borde1);
			brotesU.setOpaque(true);
			label.add(brotesU);
			//rondas de de esta partida
			JLabel rondaU = new JLabel();
			String rondaS =" "+ranking.ronda;
			rondaU.setText(rondaS);
			rondaU.setHorizontalAlignment(SwingConstants.CENTER);
			rondaU.setBounds(565,32,55,35);
			rondaU.setFont(new Font("Stika Text",Font.BOLD,32));
			rondaU.setForeground(Color.white);
			rondaU.setBackground(Color.BLACK);
			rondaU.setBorder(borde1);
			rondaU.setOpaque(true);
			label.add(rondaU);
			//dificultad de de esta partida
			JLabel puntos = new JLabel();
			String puntosS =" "+ranking.puntuacion;
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

		this.Atras = new BotonAtras(this);
		Atras.setBounds(0,(cambiarImg.screenSize.height-((cambiarImg.screenSize.width/20)-3)),cambiarImg.screenSize.width,(cambiarImg.screenSize.width/25));
		add(this.Atras);
	}
	/**
	 * Este metodo pinta el fondo de la pantalla
	 */
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
	/**
	 * Este metodo cambia el panel {@link JF_PanelPuntuaciones } por el panel {@link JF_PanelMenu}
	 */
	public void irMenu() {
		JFrame marcoP = (JFrame)SwingUtilities.getWindowAncestor(this);	
		marcoP.remove(this);
		marcoP.add(new JF_PanelMenu());
		marcoP.setVisible(true);
	}


}
