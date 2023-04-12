import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

//Mehdi Tahrat&&David Hola

public class JF_Menu extends JFrame implements ActionListener{
		menuB lamina;
	
	JF_Menu(){
		
		String titulo = "PANDEMIC";
		setBounds (400, 200, 800, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		setTitle(titulo);
		lamina=new menuB();
		add(lamina);
		setVisible(true);
		
		lamina.NuevaPartida.addActionListener(this);
		lamina.CargarPartida.addActionListener(this);
		lamina.Infromacion.addActionListener(this);
		lamina.ResumenPuntuaciones.addActionListener(this);
		lamina.Autores.addActionListener(this);
		lamina.Version.addActionListener(this);
		lamina.Salir.addActionListener(this);
		
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	String titulo = this.getTitle();
		
		if (e.getSource() == lamina.Infromacion) {
		JFrame PanelInfo = (JFrame)SwingUtilities.getWindowAncestor(this);	
		PanelInfo.remove(this);
		PanelInfo.add(new PanelInfo());
		PanelInfo.setVisible(true);
		
		}
	}
	
}

