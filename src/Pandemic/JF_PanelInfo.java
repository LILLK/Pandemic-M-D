package Pandemic;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import Botones.BotonAtras;
/**
 * Esta classe contiene un resumen de las normas del juego, como se juega y un poco de historia.
 * @author DAME
 *
 */
public class JF_PanelInfo extends JPanel {
	/**
	 * Este boton vuelve al menu.
	 * {@link BotonAtras}
	 */
	BotonAtras Atras;
	/**
	 * Aqui se almacena el nombre del jugador
	 */
	public static String NombreJ;

	/**
	 * Este constrocutor genera el panel info.
	 * Este contiene un label titulo y otro mas grande en el centro donde se resumen las normas y el como se juega
	 */
	public JF_PanelInfo() {
	
		setLayout(null);
		//Contenido de la informacion del juego
		String s ="<html><p><center>Hace 48 días conseguimos hacer mutar el virus T, pero nada salió como teníamos planeado. "
				+ "El virus tras mutar genero cuatro nuevas variantes de esté, y se dividieron por todo el mundo de forma homogénea infectando ciudad a ciudad, y tu objetivo es salvar el mundo de esta pandemia."
				+ "Para ello tendrás que elejir las ciudades que curar y tendras que desarollar las vacunas de cada virs."
				+ "Por la contraparte si una ciudad se infecta y tiene 3 enfermedades,se genera un brote y las ciudades colindantes se les añadirá una enfermedad. "
				+ "Así que ten cuidado, porque al llegar a cierto número de brotessignificara el fin del mundo y de la partida."
				+ "Por cada ronda tendrás 4 puntos de acción y estas son las acciones que puedes hacer: "
				+ "<p>Dsarrollar vacuna:-1pa </p> <p>Quitar enfermedad: -1pa (si la vacuna esta desarollada se curara por copleto) </p>"
				+ "Y tranquilo, el mundo puede esperar por ti"+NombreJ +", por eso podrás guardar tus avances salvando el mundo y volver en cualquier momento.</html></p></center>";
		this.Atras = new BotonAtras(this);
		//Contenido de la informacion
		JLabel Info = new JLabel();
		//Label que hace la cuncion de titulo 
		JLabel TInfo = new JLabel();
		
		TInfo.setBounds(((cambiarImg.screenSize.width/2)-(cambiarImg.screenSize.width/6)),(cambiarImg.screenSize.height/10)*2,(cambiarImg.screenSize.width/3),(cambiarImg.screenSize.height/10));
		TInfo.setText("Informacion del Juego");
		TInfo.setForeground(Color.BLACK);
		TInfo.setFont(new Font("Stika Text",Font.BOLD,(cambiarImg.screenSize.height/25)));
		TInfo.setBackground(cambiarImg.color1);
		TInfo.setHorizontalAlignment(SwingConstants.CENTER);
		TInfo.setBorder(cambiarImg.bordeN);
		TInfo.setVisible(true);
		TInfo.setOpaque(true);
		
		
		Info.setBounds(((cambiarImg.screenSize.width/2)-(cambiarImg.screenSize.width/4)),((cambiarImg.screenSize.height/7)+(cambiarImg.screenSize.height/5)),((cambiarImg.screenSize.width/2)),((cambiarImg.screenSize.height/2)));
		Info.setText(s);
		Info.setForeground(Color.BLACK);
		Info.setFont(new Font("Stika Text",Font.BOLD,cambiarImg.screenSize.height/53));
		Info.setBackground(cambiarImg.color1);
		Info.setBorder(cambiarImg.bordeN);
		Info.setVisible(true);
		Info.setOpaque(true);
		
		Atras.setBounds(0,(cambiarImg.screenSize.height-((cambiarImg.screenSize.width/19))),cambiarImg.screenSize.width,(cambiarImg.screenSize.width/25));
		add(this.Atras);
		add(Info);
		add(TInfo);
		
	}
	/**
	 * Este metodo cambia el panel {@link JF_PanelInfo } por el panel {@link JF_PanelMenu}
	 */
	public void irMenu() {
		JFrame marcoP = (JFrame)SwingUtilities.getWindowAncestor(this);	
		marcoP.remove(this);
		marcoP.add(new JF_PanelMenu());
		marcoP.setVisible(true);
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

}
