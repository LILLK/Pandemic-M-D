//Mehdi Tahrat && David hola
package Pandemic;

import java.awt.*;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import Botones.*;
import Logico.Partida;
/**
 * Esta classe genera el panel dificultad donde se elije el nivel de dificultad de la partida
 * @author DAME
 *
 */
public class JF_PanelPartidaDificultad extends JPanel {


	/**
	 * Este es el boton que se encarga de regresar al {@link JF_PanelMenu}
	 */
	BotonAtras Atras;

	
	/**
	 * Este es el constructor del panel de dificultad
	 * Consta de 4 botones. 3 son de elecciond e la dificultad
	 * Y el ultimo es para volver atras
	 */
	public JF_PanelPartidaDificultad() {
		///
		setLayout(null);
		//bottenes de dificultad
		JLabel normal = new JLabel();
		JLabel facil = new JLabel();
		JLabel dificil = new JLabel();
		Atras = new BotonAtras(this);
		
		//botones
		normal.setBounds(((cambiarImg.screenSize.width/2)-(cambiarImg.screenSize.width/10)),(cambiarImg.screenSize.height/6),(cambiarImg.screenSize.width/5),(cambiarImg.screenSize.width/20));
		normal.setIcon(cambiarImg.tamanyo(new ImageIcon("botones/BottonDif_normal-1.png"), ((int)(cambiarImg.screenSize.getWidth()/5)), ((int)(cambiarImg.screenSize.getWidth()/20))));
		
		facil.setText("facil");
		facil.setBounds(((cambiarImg.screenSize.width/2)-(cambiarImg.screenSize.width/10)),((cambiarImg.screenSize.height/6)+(cambiarImg.screenSize.width/18)),(cambiarImg.screenSize.width/5),(cambiarImg.screenSize.width/20));
		facil.setIcon(cambiarImg.tamanyo(new ImageIcon("botones/BottonDif_facil-1.png"), ((int)(cambiarImg.screenSize.getWidth()/5)), ((int)(cambiarImg.screenSize.getWidth()/20))));
				
		dificil.setIcon(cambiarImg.tamanyo(new ImageIcon("botones/BottonDif_dificil-1.png"), ((int)(cambiarImg.screenSize.getWidth()/5)), ((int)(cambiarImg.screenSize.getWidth()/20))));
		dificil.setText("dificil");
		dificil.setBounds(((cambiarImg.screenSize.width/2)-(cambiarImg.screenSize.width/10)),(cambiarImg.screenSize.height/6+((cambiarImg.screenSize.width/18)*2)),(cambiarImg.screenSize.width/5),(cambiarImg.screenSize.width/20));
		
		Atras.setBounds(0,(cambiarImg.screenSize.height-((cambiarImg.screenSize.width/20)-3)),cambiarImg.screenSize.width,(cambiarImg.screenSize.width/25));
		
		normal.addMouseListener(new MouseListener() {	
			public void mouseEntered(MouseEvent e) {
				normal.setIcon(cambiarImg.tamanyo(new ImageIcon("botones/BottonDif_normal-2.png"), ((int)(cambiarImg.screenSize.getWidth()/5)), ((int)(cambiarImg.screenSize.getWidth()/20))));
			}
			public void mouseExited(MouseEvent a) {
				normal.setIcon(cambiarImg.tamanyo(new ImageIcon("botones/BottonDif_normal-1.png"), ((int)(cambiarImg.screenSize.getWidth()/5)), ((int)(cambiarImg.screenSize.getWidth()/20))));
			}
			public void mousePressed(MouseEvent i) {}
			public void mouseClicked(MouseEvent e) {
				Partida.dificultad = 1;
				irPanelPartida();
			}
			public void mouseReleased(MouseEvent e) {}
		});		
		
		facil.addMouseListener(new MouseListener() {	
			public void mouseEntered(MouseEvent e) {
				facil.setIcon(cambiarImg.tamanyo(new ImageIcon("botones/BottonDif_facil-2.png"), ((int)(cambiarImg.screenSize.getWidth()/5)), ((int)(cambiarImg.screenSize.getWidth()/20))));
			}
			public void mouseExited(MouseEvent a) {
				facil.setIcon(cambiarImg.tamanyo(new ImageIcon("botones/BottonDif_facil-1.png"), ((int)(cambiarImg.screenSize.getWidth()/5)), ((int)(cambiarImg.screenSize.getWidth()/20))));
			}
			public void mousePressed(MouseEvent i) {}
			public void mouseClicked(MouseEvent e) {
				Partida.dificultad = 0;
				irPanelPartida();

			}
			public void mouseReleased(MouseEvent e) {}
		});
		
		dificil.addMouseListener(new MouseListener() {	
			public void mouseEntered(MouseEvent e) {
				dificil.setIcon(cambiarImg.tamanyo(new ImageIcon("botones/BottonDif_dificil-2.png"), ((int)(cambiarImg.screenSize.getWidth()/5)), ((int)(cambiarImg.screenSize.getWidth()/20))));
			}
			public void mouseExited(MouseEvent a) {
				dificil.setIcon(cambiarImg.tamanyo(new ImageIcon("botones/BottonDif_dificil-1.png"), ((int)(cambiarImg.screenSize.getWidth()/5)), ((int)(cambiarImg.screenSize.getWidth()/20))));
			}
			public void mousePressed(MouseEvent i) {}
			public void mouseClicked(MouseEvent e) {
				Partida.dificultad = 2;
				irPanelPartida();
			}
			public void mouseReleased(MouseEvent e) {}
		});
		
		add(this.Atras);
		add(dificil);
		add(facil);
		add(normal);
	}
	/**
	 * Este metodo pinta el fondo de la pantalla
	 */
	public void paint(Graphics g) {
		BufferedImage cambiarImgFondo;
		try {
			Dimension size = getSize();
			cambiarImgFondo = ImageIO.read(new File("imagenes/imagenPandemic6.png"));
			g.drawImage(cambiarImgFondo, 0, 0, size.width, size.height, null);
			setOpaque(false);
			super.paint(g);
		} catch (IOException e) {
			System.out.print("Error IMGfondo JF_PanelPartidaDificultad");
		}

	}
	/**
	 * Este metodo cambia el panel {@link JF_PanelPartidaDificultad } por el panel {@link JF_PanelPartida} si se teiene una resulucion igual o mayor a 1920x1080
	 */
	public void irPanelPartida() {
		Partida.iniciarNuevaPartida(Partida.dificultad);
		JFrame marcoP = (JFrame)SwingUtilities.getWindowAncestor(this);	
		marcoP.remove(this);
		if (cambiarImg.screenSize.width<1920 && cambiarImg.screenSize.height < 1080) {
			JOptionPane.showMessageDialog(new JFrame(), "No se puede jugar con una resulucion menor a 1920x1080");
			marcoP.add(new JF_PanelMenu());
		}else {
			marcoP.add(new JF_PanelPartida());
		}		marcoP.setVisible(true);
	}
	/**
	 * Este metodo cambia el panel {@link JF_PanelPartidaDificultad } por el panel {@link JF_PanelMenu}
	 */
	public void irMenu() {
		JFrame marcoP = (JFrame)SwingUtilities.getWindowAncestor(this);	
		marcoP.remove(this);
		marcoP.add(new JF_PanelMenu());
		marcoP.setVisible(true);
	}
}