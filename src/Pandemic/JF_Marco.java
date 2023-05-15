package Pandemic;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class JF_Marco extends JFrame{
	
	JF_PanelInicioSesion JF_PanelInicioSesion ;
	
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
