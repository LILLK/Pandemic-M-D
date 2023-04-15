import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class JF_PanelAutores extends JPanel implements ActionListener {
	JButton Atras;
	JLabel jLabel2;
	
	JF_PanelAutores()  {
	
		setLayout(new BorderLayout());
		
		this.Atras = new JButton("Atras");
		
		BufferedImage imgDavid;
		try {
			imgDavid = ImageIO.read(new File("imagenes/fotoDavid.png"));
			Image scaledInstance = imgDavid.getScaledInstance(200, 100, Image.SCALE_DEFAULT);
			jLabel2.setIcon(new ImageIcon(scaledInstance));
			//JLabel imagenDavid = new JLabel(new ImageIcon(imgDavid));
			//imagenDavid.resize(200,200);
			//SetImageSize(12);
			add(jLabel2);
			
		} catch (IOException e) {
			System.out.print("ds");
		}
		
		
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
