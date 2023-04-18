import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class JF_PanelAutores extends JPanel implements ActionListener {
	JButton Atras;
	Dimension screenSize;
	JF_PanelAutores()  {
	
		setLayout(null);

		this.screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		
		this.Atras = new JButton("Atras");
		
		BufferedImage imgDavid;
		try {
			imgDavid = ImageIO.read(new File("imagenes/fotoDavid.png"));
			//Image scaledInstance = imgDavid.getScaledInstance(2, 1, Image.SCALE_SMOOTH);
			//jLabel2.setIcon(new ImageIcon(scaledInstance));
			JLabel imagenDavid = new JLabel(tamaño(new ImageIcon(imgDavid),300,200));
			//imagenDavid
			Dimension sizeImgDavid = imagenDavid.getPreferredSize();
			imagenDavid.setBounds( 200,200, sizeImgDavid.width,sizeImgDavid.height);
			add(imagenDavid);
			//imagenDavid.setLocation(50,500);
		} catch (IOException e) {
			System.out.print("ds");
		}
		
	
		int x = screenSize.height-300;
		Atras.setBounds(0,screenSize.height-60,screenSize.width,20);
		add(this.Atras);
		this.Atras.addActionListener(this);
	}
	
	
	
	
	public static ImageIcon tamaño(ImageIcon im, int w, int h) {
		BufferedImage bi = new BufferedImage(w,h, BufferedImage.TRANSLUCENT);
		Graphics2D gd=(Graphics2D)bi.createGraphics();
		gd.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY));
		gd.drawImage(im.getImage(),0,0,w,h,null);
		gd.dispose();
		return new ImageIcon(bi);
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
