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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicScrollBarUI;

import Botones.BotonAtras;
import Botones.BotonCargar;
import Logico.ConexionBD;
import Logico.Parametros;
import Logico.Partida;
import Logico.PartidasGuardadas;
/**
 * Esta classe es el panel de Cargar  Partida.
 * En esta se encotrara una lista de partidas que se podran cargar para seguir jugando.
 * @author DAME
 */
public class JF_PanelCargarPartida extends JPanel {
	/**
	 * Este boton vuelve al menu.
	 * {@link BotonAtras}
	 */
	BotonAtras Atras;
	/**
	 * Lista de partidas guardadas
	 */
	public static ArrayList<PartidasGuardadas> partGuar;
	/**
	 * Constructor del panel cargar partida
	 * Este panel contiene un panel principal en el centro 
	 * con el listado de partidas guardadas disponibles al usuario.
	 */
	public JF_PanelCargarPartida(){
		setLayout(null);
		JScrollPane scroll = new JScrollPane();
		JPanel panel = new JPanel();
		this.partGuar = new ArrayList<PartidasGuardadas>();
		Border borde1 = BorderFactory.createLineBorder(Color.WHITE,2);
		JLabel posicion = new JLabel();
		JLabel nomUsu = new JLabel();
		JLabel dificultad = new JLabel();
		JLabel brotes = new JLabel();
		JLabel ronda = new JLabel();
		JLabel puntuacion = new JLabel();
		//carga los datos y las variables del programa
		ConexionBD.cargarPartidas();
		
		//JScrollPane scroll
		scroll.setBounds((cambiarImg.screenSize.width/2)-410,330,820,450);
		scroll.getVerticalScrollBar().setUI(new BasicScrollBarUI());
		scroll.setViewportView(panel);
		
		//JLabel posicion 
		posicion.setText("Cargar");
		posicion.setBackground(Color.black);
		posicion.setForeground(Color.white);
		posicion.setHorizontalAlignment(SwingConstants.CENTER);
		posicion.setFont(new Font("Stika Text",Font.BOLD,20) );
		posicion.setBounds((cambiarImg.screenSize.width/2)-410,280,80,50);
		posicion.setOpaque(true);
		posicion.setVisible(true);
		//JLabel nomUsu 
		nomUsu.setText("Acciones");
		nomUsu.setBackground(Color.black);
		nomUsu.setForeground(Color.white);
		nomUsu.setHorizontalAlignment(SwingConstants.CENTER);
		nomUsu.setFont(new Font("Stika Text",Font.BOLD,20) );
		nomUsu.setBounds(((cambiarImg.screenSize.width/2)-410)+80,280,240,50);
		nomUsu.setOpaque(true);
		nomUsu.setVisible(true);
		//JLabel dificultad
		dificultad.setText("Dificultad");
		dificultad.setBackground(Color.black);
		dificultad.setForeground(Color.white);
		dificultad.setHorizontalAlignment(SwingConstants.CENTER);
		dificultad.setFont(new Font("Stika Text",Font.BOLD,20) );
		dificultad.setBounds(((cambiarImg.screenSize.width/2)-410)+320,280,100,50);
		dificultad.setOpaque(true);
		dificultad.setVisible(true);
		//JLabel brotes
		brotes.setText("Brotes");
		brotes.setBackground(Color.black);
		brotes.setForeground(Color.white);
		brotes.setHorizontalAlignment(SwingConstants.CENTER);
		brotes.setFont(new Font("Stika Text",Font.BOLD,20) );
		brotes.setBounds(((cambiarImg.screenSize.width/2)-410)+420,280,100,50);
		brotes.setOpaque(true);
		brotes.setVisible(true);
		//JLabel ronda
		ronda.setText("Ronda");
		ronda.setBackground(Color.black);
		ronda.setForeground(Color.white);
		ronda.setHorizontalAlignment(SwingConstants.CENTER);
		ronda.setFont(new Font("Stika Text",Font.BOLD,20) );
		ronda.setBounds(((cambiarImg.screenSize.width/2)-410)+520,280,100,50);
		ronda.setOpaque(true);
		ronda.setVisible(true);
		//JLabel puntuacion
		puntuacion.setText("Puntuación");
		puntuacion.setBackground(Color.black);
		puntuacion.setForeground(Color.white);
		puntuacion.setHorizontalAlignment(SwingConstants.CENTER);
		puntuacion.setFont(new Font("Stika Text",Font.BOLD,20) );
		puntuacion.setBounds(((cambiarImg.screenSize.width/2)-410)+620,280,180,50);
		puntuacion.setOpaque(true);
		puntuacion.setVisible(true);
		
		panel.setLayout(null);
		//Por cada partida guardada crea un registro en el label del cual se podra extraer datos
		int i =0;
		for(PartidasGuardadas partidasGuardadas : JF_PanelCargarPartida.partGuar) {
			System.out.println(partidasGuardadas.brotes+" "+ partidasGuardadas.puntuacion);
			JLabel label = new JLabel();
			label.setBounds(0, 0+(100*i), 800,100 );
			label.setBackground(cambiarImg.color1);
			label.setBorder(cambiarImg.bordeN);
			
			BotonCargar cargar = new BotonCargar(partidasGuardadas.idPartida,this);
			cargar.setBounds(0, 0, 100, 100);
			//cargar.setBorder(borde);
			label.add(cargar);
			
			for(int f = 0;f < partidasGuardadas.acciones;f++) {
				JLabel accion = new JLabel();
				accion.setBounds(120+(40*f), 35, 20, 30);
				accion.setBackground(Color.black);
				accion.setOpaque(true);
				accion.setBorder(borde1);
				label.add(accion);
			}
			//Contenido del label dentro del label.
			//Registro partida a partida
			JLabel dificultadU = new JLabel();
			String dificultadS ="<html><center>"+ partidasGuardadas.dificultadPartida;
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
			String brotesS ="<html><center>"+partidasGuardadas.brotes;
			brotesU.setText(brotesS);
			brotesU.setHorizontalAlignment(SwingConstants.CENTER);
			brotesU.setBounds(465,32,45,35);
			brotesU.setFont(new Font("Stika Text",Font.BOLD,32));
			brotesU.setForeground(Color.white);
			brotesU.setBackground(Color.BLACK);
			brotesU.setBorder(borde1);
			brotesU.setOpaque(true);
			label.add(brotesU);
			//////////////////
			//////////////////
			JLabel rondaU = new JLabel();
			String rondaS ="<html><center>"+partidasGuardadas.ronda;
			rondaU.setText(rondaS);
			rondaU.setHorizontalAlignment(SwingConstants.CENTER);
			rondaU.setBounds(565,32,45,35);
			rondaU.setFont(new Font("Stika Text",Font.BOLD,32));
			rondaU.setForeground(Color.white);
			rondaU.setBackground(Color.BLACK);
			rondaU.setBorder(borde1);
			rondaU.setOpaque(true);
			label.add(rondaU);
			//////////////////
			//////////////////
			JLabel puntos = new JLabel();
			String puntosS ="<html><center>"+partidasGuardadas.puntuacion;
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
		Atras.setBounds(0,(cambiarImg.screenSize.height-((cambiarImg.screenSize.width/20)+4)),cambiarImg.screenSize.width,(cambiarImg.screenSize.width/25));
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
		
		/**
		 * Este metodo cambia el panel {@link JF_PanelCargarPartida } por el panel {@link JF_PanelMenu}
		 */
	} 	public void irMenu() {
		JFrame marcoP = (JFrame)SwingUtilities.getWindowAncestor(this);	
		marcoP.remove(this);
		marcoP.add(new JF_PanelMenu());
		marcoP.setVisible(true);
	}
	/**
	 * Este metodo cambia el panel {@link JF_PanelCargarPartida} por el panel {@link JF_PanelPartida}
	 * si la resulocion de la pantalla es menor a 1920x1080.
	 * Sino cargara el panel {@link JF_PanelMenu} despues de un mensaje
	 * @param idP - int - id de partida
	 */
	public void irPanelPartida(int idP) {
		ConexionBD.cargarPartida( idP);
		Parametros.establecerParametros(Partida.dificultad);
		JFrame marcoP = (JFrame)SwingUtilities.getWindowAncestor(this);	
		marcoP.remove(this);
		if (cambiarImg.screenSize.width<1920 && cambiarImg.screenSize.height < 1080) {
			JOptionPane.showMessageDialog(new JFrame(), "No se puede jugar con una resulucion menor a 1920x1080");
			marcoP.add(new JF_PanelMenu());
		}else {
			marcoP.add(new JF_PanelPartida());
		}
		marcoP.setVisible(true);
	}

}
