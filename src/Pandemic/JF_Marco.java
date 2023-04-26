package Pandemic;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

public class JF_Marco extends JFrame{
	
	JF_PanelMenu JF_PanelMenu;
	//Dimension screenSize;
	
	JF_Marco(){
		
		//Dimension  screenSize = new Dimension();
	
		//setBounds (400, 200, 800, 800);
		
		//this.screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		//setSize(screenSize);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		setTitle("Pandemic");
		
		this.JF_PanelMenu = new JF_PanelMenu();
		add(this.JF_PanelMenu);
		setVisible(true);
		
	}

}
