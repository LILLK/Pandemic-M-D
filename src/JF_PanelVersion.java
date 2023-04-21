import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class JF_PanelVersion extends JPanel implements ActionListener {
	JButton Atras;

	Dimension screenSize;
	
	JF_PanelVersion() {
	
		setLayout(null);
		this.screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		
		this.Atras = new JButton("Atras");
		JLabel Version = new JLabel("Version 1.0");
		
		this.Atras.setBounds(0,this.screenSize.height-60,this.screenSize.width,20);
		add(this.Atras);
		add(Version);
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