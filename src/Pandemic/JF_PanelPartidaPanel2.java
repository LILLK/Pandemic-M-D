//Mehdi Tahrat && David hola
package Pandemic;
import java.awt.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import Botones.*;
import Logico.Partida;
/**
 * Esta classe es del panel que se situa abajo a la derecha en {@link JF_PanelPartida}
 * Este panel guarda el log, el boton de guardar , y las acciones restantes
 * @author DAME
 *
 */
public class JF_PanelPartidaPanel2 extends JPanel {
/**
 * En este label se mostrara en texto lo que va ocurriendo en partida
 */
	static  JLabel log = new JLabel();
	/**
	 * El texto del panel log
	 */
	static String logText ;
	/**
	 * panel de acciones restatnes
	 */
	static JLabel acciones = new JLabel();
/**
 * Boton de guardar partida
 */
	BotonGuardarPartida BotonGuardarPartida;
	/**
	 * Este es el constructor del panel.
	 * Este esta compuesto por 2 paneles(log y acciones restantes) y un boton de guardar partida
	 */
	public JF_PanelPartidaPanel2() {




		setLayout(null);
		this.setBounds(1551, cambiarImg.screenSize.height / 2 + 1, (cambiarImg.screenSize.width - 1550), (cambiarImg.screenSize.height / 2) - 23);
		this.setOpaque(true);
		
		acciones = new JLabel();
		log = new JLabel();
		BotonGuardarPartida = new BotonGuardarPartida(this);	
		
		acciones.setBounds(20, this.getHeight()/100, this.getWidth()-40, this.getHeight()/100*15);
		acciones.setBackground(Color.orange);
		acciones.setVisible(true);
		acciones.setBorder(cambiarImg.bordeN);
		acciones.setOpaque(true);
		acciones.setHorizontalAlignment(SwingConstants.CENTER);
		acciones.setFont(new Font("Stika Text",Font.BOLD,21) );
		acciones.setText("Acciones restantes: "+Partida.accionesRonda);
		
		log.setBounds(20, this.getHeight()/100*15, this.getWidth()-40, this.getHeight()/100*75);
		log.setBackground(Color.WHITE);
		log.setVisible(true);
		log.setBorder(cambiarImg.bordeN);
		log.setOpaque(true);
		log.setText(logText=" ");
		
		add(BotonGuardarPartida);
		add(acciones);
		add(log);


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
			System.out.print("Error IMGfondo JF_PanelPartidaPanel2");
		}
	} 
	/**
	 * Actualiza el texto del log 
	 * @param  newTexto - String-  el nuevo texto que mostrar por el log
	 */
	public static void updateLog(String newTexto) {
		if (Partida.accionesRonda==0) {
			logText = "";
		}
		String resultado="<p>"+newTexto+"</p>";
		logText += resultado;
		log.setText("<html>"+logText+"</html>");
	}
	/**
	 * Esta funcion actualiza el panel de acciones restantes
	 */
	public static void updateAcciones() {
		acciones.setText("acciones restantes: "+Partida.accionesRonda);
	}
	/**
	 * Esta funcion resta acciones en la ronda
	 */
	public static void restarAcciones() {
		Partida.accionesRonda--;
		acciones.setText("acciones restantes: "+Partida.accionesRonda);
	}
	
	
	
}
