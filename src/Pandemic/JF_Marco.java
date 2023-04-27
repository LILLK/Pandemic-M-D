package Pandemic;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

public class JF_Marco extends JFrame{
	
	JF_PanelMenu JF_PanelMenu;
	//Dimension screenSize;
	
	public JF_Marco(){
		
		
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		setTitle("Pandemic");
		
		this.JF_PanelMenu = new JF_PanelMenu();
		add(this.JF_PanelMenu);
		setVisible(true);
		
	}

}
