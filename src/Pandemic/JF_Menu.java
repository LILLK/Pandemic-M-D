package Pandemic;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

//Mehdi Tahrat&&David Hola

public class JF_Menu extends JFrame implements ActionListener{
		menuB lamina;
		JPanel PanelInformacion;
		JPanel PanelAutores;
		JPanel PanelVersion;
	
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
		JFrame menu = (JFrame)SwingUtilities.getWindowAncestor(this);	
		menu.remove(this);
		
		menu.setVisible(true);
		
		}
		if (e.getSource() == lamina.Autores) {
			JFrame PanelAuto = (JFrame)SwingUtilities.getWindowAncestor(lamina);	
			PanelAuto.remove(lamina);
			PanelAuto.add(PanelAutores=new JPanel());
			PanelAuto.setVisible(true);
			
		}
		if (e.getSource() == lamina.Version) {
			JFrame PanelVer = (JFrame)SwingUtilities.getWindowAncestor(lamina);	
			PanelVer.remove(lamina);
			PanelVer.add(PanelVersion=new JPanel());
			PanelVer.setVisible(true);
			
		}
		if (e.getSource() == lamina.Salir) {
			
			dispose();
		}
	}
	
}

