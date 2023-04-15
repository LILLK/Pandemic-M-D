import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class JF_PanelVersion extends JPanel implements ActionListener {
	JButton Atras;
	JLabel Version;
	
	JF_PanelVersion() {
	
		setLayout(new BorderLayout());
		
		this.Atras = new JButton("Atras");
		this.Version = new JLabel("Version 1.0");
		
		
		add(this.Atras, BorderLayout.SOUTH);
		add(this.Version, BorderLayout.CENTER);
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