package Botones;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.Border;

import Logico.Ciudades;
import Logico.Partida;
import Pandemic.JF_PanelPartida;
import Pandemic.cambiarImg;
/**
 * Esta classe define los constructores de  los botones Ciudad
 * Estos botones componen un tercio del juego , ya que 
 * no solo son las ciudades sino que tambien tienen los metodos de curar y infectarse
 * @author DAME
 *
 */
public class BotonCiudad extends JLabel {
	
	/**
	 * ciudad del boton
	 */
	public Ciudades ciudad;
	/**
	 * etiqueta con el nombre 
	 */
	public JLabel JLNombreCiudad;
	/**
	 * tamanyo x
	 */
	public int tamanyoX = 45;
	/**
	 *  tamanyo y
	 */
	public int tamanyoY = 30;

/**
 * Contructor del boton Ciudad en la partida
 * Se guarda la ciudad y se construye con estos datos
 * @param JF_PanelPartida {@link JF_PanelPartida}
 * @param ciudad {@link Ciudades}
 */
	public BotonCiudad(JF_PanelPartida JF_PanelPartida, Ciudades ciudad) {
		Border borde = BorderFactory.createLineBorder(Color.BLACK, 3);
		this.ciudad = ciudad;
		this.establecerIcono(tamanyoX, tamanyoY);
		this.setVisible(true);
		this.setOpaque(false);
		this.JLNombreCiudad = new JLabel();
		this.JLNombreCiudad.setVisible(false);
		this.JLNombreCiudad.setText(this.ciudad.nombre);
		this.JLNombreCiudad.setBorder(borde);
		this.JLNombreCiudad.setBackground(Color.WHITE);
		this.JLNombreCiudad.setOpaque(true);


		addMouseListener((MouseListener) new MouseListener() {
			public void mouseEntered(MouseEvent e) {
				JLNombreCiudad.setVisible(true);
				establecerIconoEntered(tamanyoX, tamanyoY);
			}
			public void mouseExited(MouseEvent a) {
				JLNombreCiudad.setVisible(false);
				establecerIcono(tamanyoX, tamanyoY);
			}
			public void mousePressed(MouseEvent i) {
			}
			public void mouseClicked(MouseEvent e) {
				//se cura la cidad
				BotonCiudad.this.ciudad.curar();
				//sigue el juego
				Partida.jugarPartida(JF_PanelPartida);
				//se actualiza el icono
				establecerIcono(tamanyoX, tamanyoY);
			}
			public void mouseReleased(MouseEvent e) {
			}
		});

	}
/**
 * Este metodo actualiza el icono de la ciudad
 * @param tamanyoX - tamaño horizontal
 * @param tamanyoY - tamaño vertical
 */
	public void establecerIcono(int tamanyoX, int tamanyoY) {
		//depende de el virus id se establecera un color diferente
		switch (BotonCiudad.this.ciudad.idVirus) {
		case 0://azul
			//si no tiene brote
			if (!BotonCiudad.this.ciudad.brote)
				//segun el numero de engermedades de la ciudad
				switch (BotonCiudad.this.ciudad.nEnfermedades) {
				case 0:
					setIcon(cambiarImg.tamanyo(new ImageIcon("botones/ciudad_azul_0_sano.png"), tamanyoX, tamanyoY));
					break;
				case 1:
					setIcon(cambiarImg.tamanyo(new ImageIcon("botones/ciudad_azul_1_sano.png"), tamanyoX, tamanyoY));
					break;
				case 2:
					setIcon(cambiarImg.tamanyo(new ImageIcon("botones/ciudad_azul_2_sano.png"), tamanyoX, tamanyoY));
					break;
				case 3:
					setIcon(cambiarImg.tamanyo(new ImageIcon("botones/ciudad_azul_3_sano.png"), tamanyoX, tamanyoY));
					break;	
				}
			else
				setIcon(cambiarImg.tamanyo(new ImageIcon("botones/ciudad_azul_0_brote.png"), tamanyoX, tamanyoY));				
			break;	

		case 1://rojo
			//si no tiene brote
			if (!BotonCiudad.this.ciudad.brote)
				//segun el numero de engermedades de la ciudad
				switch (BotonCiudad.this.ciudad.nEnfermedades) {
				case 0:
					setIcon(cambiarImg.tamanyo(new ImageIcon("botones/ciudad_rojo_0_sano.png"), tamanyoX, tamanyoY));
					break;
				case 1:
					setIcon(cambiarImg.tamanyo(new ImageIcon("botones/ciudad_rojo_1_sano.png"), tamanyoX, tamanyoY));
					break;
				case 2:
					setIcon(cambiarImg.tamanyo(new ImageIcon("botones/ciudad_rojo_2_sano.png"), tamanyoX, tamanyoY));
					break;
				case 3:
					setIcon(cambiarImg.tamanyo(new ImageIcon("botones/ciudad_rojo_3_sano.png"), tamanyoX, tamanyoY));
					break;	
				}
			else
				setIcon(cambiarImg.tamanyo(new ImageIcon("botones/ciudad_rojo_0_brote.png"), tamanyoX, tamanyoY));				
			break;
		case 2://verde
			//si no tiene brote
			if (!BotonCiudad.this.ciudad.brote)
				//segun el numero de engermedades de la ciudad
				switch (BotonCiudad.this.ciudad.nEnfermedades) {
				case 0:
					setIcon(cambiarImg.tamanyo(new ImageIcon("botones/ciudad_verde_0_sano.png"), tamanyoX, tamanyoY));
					break;
				case 1:
					setIcon(cambiarImg.tamanyo(new ImageIcon("botones/ciudad_verde_1_sano.png"), tamanyoX, tamanyoY));
					break;
				case 2:
					setIcon(cambiarImg.tamanyo(new ImageIcon("botones/ciudad_verde_2_sano.png"), tamanyoX, tamanyoY));
					break;
				case 3:
					setIcon(cambiarImg.tamanyo(new ImageIcon("botones/ciudad_verde_3_sano.png"), tamanyoX, tamanyoY));
					break;	
				}
			else
				setIcon(cambiarImg.tamanyo(new ImageIcon("botones/ciudad_verde_0_brote.png"), tamanyoX, tamanyoY));				
			break;
		case 3://amarillo
			//si no tiene brote
			if (!BotonCiudad.this.ciudad.brote)
				//segun el numero de engermedades de la ciudad
				switch (BotonCiudad.this.ciudad.nEnfermedades) {
				case 0:
					setIcon(cambiarImg.tamanyo(new ImageIcon("botones/ciudad_amarillo_0_sano.png"), tamanyoX, tamanyoY));
					break;
				case 1:
					setIcon(cambiarImg.tamanyo(new ImageIcon("botones/ciudad_amarillo_1_sano.png"), tamanyoX, tamanyoY));
					break;
				case 2:
					setIcon(cambiarImg.tamanyo(new ImageIcon("botones/ciudad_amarillo_2_sano.png"), tamanyoX, tamanyoY));
					break;
				case 3:
					setIcon(cambiarImg.tamanyo(new ImageIcon("botones/ciudad_amarillo_3_sano.png"), tamanyoX, tamanyoY));
					break;	
				}
			else
				setIcon(cambiarImg.tamanyo(new ImageIcon("botones/ciudad_amarillo_0_brote.png"), tamanyoX, tamanyoY));				
			break;

		}

	}
/**
 * Este metodo actualiza el icono de la ciudad cuando esta en "hoover"
 * @param tamanyoX - tamaño horizontal
 * @param tamanyoY - tamaño vertical
 */
	public void establecerIconoEntered(int tamanyoX, int tamanyoY) {
		//depende de el virus id se establecera un color diferente
		switch (BotonCiudad.this.ciudad.idVirus) {
		case 0://azul
			//si no tiene brote
			if (!BotonCiudad.this.ciudad.brote)
				//segun el numero de engermedades de la ciudad
				switch (BotonCiudad.this.ciudad.nEnfermedades) {
				case 0:
					setIcon(cambiarImg.tamanyo(new ImageIcon("botones/ciudad_azul_0_sano_entered.png"), tamanyoX, tamanyoY));
					break;
				case 1:
					setIcon(cambiarImg.tamanyo(new ImageIcon("botones/ciudad_azul_1_sano_entered.png"), tamanyoX, tamanyoY));
					break;
				case 2:
					setIcon(cambiarImg.tamanyo(new ImageIcon("botones/ciudad_azul_2_sano_entered.png"), tamanyoX, tamanyoY));
					break;
				case 3:
					setIcon(cambiarImg.tamanyo(new ImageIcon("botones/ciudad_azul_3_sano_entered.png"), tamanyoX, tamanyoY));
					break;	
				}
			else
				setIcon(cambiarImg.tamanyo(new ImageIcon("botones/ciudad_azul_0_brote_entered.png"), tamanyoX, tamanyoY));				
			break;	

		case 1://rojo
			//si no tiene brote
			if (!BotonCiudad.this.ciudad.brote)
				//segun el numero de engermedades de la ciudad
				switch (BotonCiudad.this.ciudad.nEnfermedades) {
				case 0:
					setIcon(cambiarImg.tamanyo(new ImageIcon("botones/ciudad_rojo_0_sano_entered.png"), tamanyoX, tamanyoY));
					break;
				case 1:
					setIcon(cambiarImg.tamanyo(new ImageIcon("botones/ciudad_rojo_1_sano_entered.png"), tamanyoX, tamanyoY));
					break;
				case 2:
					setIcon(cambiarImg.tamanyo(new ImageIcon("botones/ciudad_rojo_2_sano_entered.png"), tamanyoX, tamanyoY));
					break;
				case 3:
					setIcon(cambiarImg.tamanyo(new ImageIcon("botones/ciudad_rojo_3_sano_entered.png"), tamanyoX, tamanyoY));
					break;	
				}
			else
				setIcon(cambiarImg.tamanyo(new ImageIcon("botones/ciudad_rojo_0_brote_entered.png"), tamanyoX, tamanyoY));				
			break;
		case 2://verde
			//si no tiene brote
			if (!BotonCiudad.this.ciudad.brote)
				//segun el numero de engermedades de la ciudad
				switch (BotonCiudad.this.ciudad.nEnfermedades) {
				case 0:
					setIcon(cambiarImg.tamanyo(new ImageIcon("botones/ciudad_verde_0_sano_entered.png"), tamanyoX, tamanyoY));
					break;
				case 1:
					setIcon(cambiarImg.tamanyo(new ImageIcon("botones/ciudad_verde_1_sano_entered.png"), tamanyoX, tamanyoY));
					break;
				case 2:
					setIcon(cambiarImg.tamanyo(new ImageIcon("botones/ciudad_verde_2_sano_entered.png"), tamanyoX, tamanyoY));
					break;
				case 3:
					setIcon(cambiarImg.tamanyo(new ImageIcon("botones/ciudad_verde_3_sano_entered.png"), tamanyoX, tamanyoY));
					break;	
				}
			else
				setIcon(cambiarImg.tamanyo(new ImageIcon("botones/ciudad_verde_0_brote_entered.png"), tamanyoX, tamanyoY));				
			break;
		case 3://amarillo
			//si no tiene brote
			if (!BotonCiudad.this.ciudad.brote)
				//segun el numero de engermedades de la ciudad
				switch (BotonCiudad.this.ciudad.nEnfermedades) {
				case 0:
					setIcon(cambiarImg.tamanyo(new ImageIcon("botones/ciudad_amarillo_0_sano_entered.png"), tamanyoX, tamanyoY));
					break;
				case 1:
					setIcon(cambiarImg.tamanyo(new ImageIcon("botones/ciudad_amarillo_1_sano_entered.png"), tamanyoX, tamanyoY));
					break;
				case 2:
					setIcon(cambiarImg.tamanyo(new ImageIcon("botones/ciudad_amarillo_2_sano_entered.png"), tamanyoX, tamanyoY));
					break;
				case 3:
					setIcon(cambiarImg.tamanyo(new ImageIcon("botones/ciudad_amarillo_3_sano_entered.png"), tamanyoX, tamanyoY));
					break;	
				}
			else
				setIcon(cambiarImg.tamanyo(new ImageIcon("botones/ciudad_amarillo_0_brote_entered.png"), tamanyoX, tamanyoY));				
			break;

		}

	}
	
	/**
	 * Este metodo muestra por pantalla todos los nombres de ciudades
	 */
	public static void mostrarNombres() {
		for (BotonCiudad boton : JF_PanelPartida.botonesCiudad) 
			boton.JLNombreCiudad.setVisible(true);
	}
	/**
	 * Este metodo oculta todos los nombres de ciudades
	 */
	public static void ocultarNombres() {
		for (BotonCiudad boton : JF_PanelPartida.botonesCiudad) 
			boton.JLNombreCiudad.setVisible(false);
	}
}
