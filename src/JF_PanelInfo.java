import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class JF_PanelInfo extends JPanel implements ActionListener{
	
	JButton Atras;
	
	JF_PanelInfo() {
	
		setLayout(new BorderLayout());
	
		this.Atras = new JButton("Atras");
		
		
		add(this.Atras, BorderLayout.SOUTH);
		this.Atras.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == this.Atras) {
			
			JFrame marcoP = (JFrame)SwingUtilities.getWindowAncestor(this);	
			marcoP.remove(this);
			marcoP.add(new JF_PanelMenu());
			marcoP.setVisible(true);
		}
		
	}
}
