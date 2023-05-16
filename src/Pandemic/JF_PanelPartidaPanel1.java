//Mehdi Tahrat && David hola
package Pandemic;
/**
 * Esta classe es del panel que se situa arriba a la derecha en {@link JF_PanelPartida} y muestra algunos datos de la partida.
 * Esta panel contiene los labels de puntuacion, brotes y partida.
 * @author DAME
 */
import java.awt.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import Logico.Parametros;
import Logico.Partida;

public class JF_PanelPartidaPanel1 extends JPanel {
	/**
	 * En este label se muestra la puntuacion de la partida
	 */
	static JLabel puntuacion;
	/**
	 * En este label se muestran los brotes
	 */
	static JLabel brotes;
	/**
	 * En este label se muestran las ronda
	 */
	static JLabel ronda;

	/**
	 * Este es el constructor del panel 1 y los labels brotes , puntuacion y ronda
	 */
	public JF_PanelPartidaPanel1() {

		setLayout(null);
		this.setBounds(1551, 1, (cambiarImg.screenSize.width - 1550), cambiarImg.screenSize.height / 2);
		this.setOpaque(true);

		puntuacion = new JLabel();
		brotes = new JLabel();
		ronda = new JLabel();

		puntuacion.setBounds((this.getWidth() / 10) *1, ((this.getHeight() / 12) * 3), (this.getWidth() / 10) *8, this.getHeight() / 7);
		puntuacion.setBackground(Color.orange);
		puntuacion.setVisible(true);
		puntuacion.setBorder(cambiarImg.bordeN);
		puntuacion.setOpaque(true);
		puntuacion.setHorizontalAlignment(SwingConstants.CENTER);
		puntuacion.setFont(new Font("Stika Text",Font.BOLD,21) );
		puntuacion.setText("La puntuación es de: " + Partida.Puntuacion);

		brotes.setBounds((this.getWidth() / 10) *1, ((this.getHeight() / 12) * 5), (this.getWidth() / 10) *8, this.getHeight() / 7);
		brotes.setBackground(Color.orange);
		brotes.setVisible(true);
		brotes.setBorder(cambiarImg.bordeN);
		brotes.setHorizontalAlignment(SwingConstants.CENTER);
		brotes.setFont(new Font("Stika Text",Font.BOLD,23) );
		brotes.setOpaque(true);
		brotes.setText("Brotes: " + Partida.brotes + "/" + Parametros.brotesTotal);

		ronda.setBounds((this.getWidth() / 10) *1, ((this.getHeight() / 12) * 7),  (this.getWidth() / 10) *8, this.getHeight() / 7);
		ronda.setBackground(Color.orange);
		ronda.setVisible(true);
		ronda.setBorder(cambiarImg.bordeN);
		ronda.setHorizontalAlignment(SwingConstants.CENTER);
		ronda.setFont(new Font("Stika Text",Font.BOLD,23) );
		ronda.setOpaque(true);
		ronda.setText("Ronda :" + Partida.ronda);
		
		
		
		add(ronda);
		add(brotes);
		add(puntuacion);
	}
	
	/**
	 * Este metodo pinta el fondo de la pantalla
	 */
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
	/**
	 * Esta funcion actualiza el panel puntuacion
	 */
	public static void updatePuntuacion() {
		puntuacion.setText("La puntuación es de: " + Partida.Puntuacion);
	}
	/**
	 * Esta funcion actualiza el panel ronda
	 */
	public static void updateRonda() {
		ronda.setText("Ronda :" + Partida.ronda);
	}
	/**
	 * Esta funcion actualiza el panel 
	 */
	public static void updateBrotes() {
		brotes.setText("Brotes: " + Partida.brotes + "/" + Parametros.brotesTotal);
	}
	
}
