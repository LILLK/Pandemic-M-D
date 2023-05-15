package Pandemic;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
/**
 * Esta es la classe del marco principal, este Frame se guardaran y mostraran los paneles del probrama
 * @author alumnat
 *
 */
public class JF_Marco extends JFrame{
	
	/**
	 * Panel de inicio sesion.
	 * {@link JF_PanelInicioSesion}
	 */
	JF_PanelInicioSesion JF_PanelInicioSesion ;
	/**
	 * Este constructor se encarga de construir el marco donde se mostraran la resta de paneles.
	 */
	public JF_Marco(){
		
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		setTitle("Pandemic");
		ImageIcon img = new ImageIcon("imagenes/fotoIcon.png");
		setIconImage(img.getImage());
		
		this.JF_PanelInicioSesion = new JF_PanelInicioSesion();
		add(this.JF_PanelInicioSesion);
		setVisible(true);
		
	}

}
