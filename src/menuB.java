 import java.awt.*;
import javax.swing.*;

//Mehdi Tahrat&&David Hola

	

public class menuB extends JPanel {
	JPanel PanelInformacion;
	JPanel PanelVersion ;
	JPanel PanelAutores ; 
	
	JButton NuevaPartida;
	JButton CargarPartida;
	JButton Infromacion;
	JButton ResumenPuntuaciones;
	JButton Autores;
	JButton Version;
	JButton Salir;
	
	public menuB(){
		
		
		NuevaPartida = new JButton("NuevaPartida");
		CargarPartida = new JButton("CargarPartida");
		Infromacion = new JButton("Infromacion");
		ResumenPuntuaciones = new JButton("ResumenPuntuaciones");
		Autores = new JButton("Autores");
		Version = new JButton("Version");
		Salir = new JButton("Salir");
		
		add(NuevaPartida);
		add(CargarPartida);
		add(Infromacion);
		add(ResumenPuntuaciones);
		add(Autores);
		add(Version);
		add(Salir);
		
	}

}