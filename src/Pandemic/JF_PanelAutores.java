package Pandemic;
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
	public JF_PanelAutores()  {
	
		setLayout(null);

		this.screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		
		this.Atras = new JButton("Atras");
		
		BufferedImage imgDavid;
		try {
			imgDavid = ImageIO.read(new File("imagenes/fotoDavid.png"));
			JLabel imagenDavid = new JLabel(tamaño(new ImageIcon(imgDavid),300,200));
			Dimension sizeImgDavid = imagenDavid.getPreferredSize();
			imagenDavid.setBounds( 100,200, sizeImgDavid.width,sizeImgDavid.height);
			add(imagenDavid);

		} catch (IOException e) {
			System.out.print("ds");
		}
		BufferedImage imgMehdi;
		try {
			imgMehdi = ImageIO.read(new File("imagenes/imagenMehdi.png"));
			JLabel imagenMehdi = new JLabel(tamaño(new ImageIcon(imgMehdi),300,200));
			Dimension sizeImgMehdi = imagenMehdi.getPreferredSize();
			imagenMehdi.setBounds(this.screenSize.width-400,200, sizeImgMehdi.width,sizeImgMehdi.height);
			add(imagenMehdi);

		} catch (IOException e) {
			System.out.print("ds");
		}
		
	
		Atras.setBounds(0,this.screenSize.height-60,this.screenSize.width,20);
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
