package Pandemic;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class cambiarImg {
	
	public static final Border bordeN = BorderFactory.createLineBorder(Color.BLACK, 6);;
	public static Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
	public static Color color1 = new Color(71,161,197);


	
	public cambiarImg() {
		
	}
	public static ImageIcon tamaño(ImageIcon im, int w, int h) {
		BufferedImage bi = new BufferedImage(w,h, BufferedImage.TRANSLUCENT);
		Graphics2D gd=(Graphics2D)bi.createGraphics();
		gd.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY));
		gd.drawImage(im.getImage(),0,0,w,h,null);
		gd.dispose();
		return new ImageIcon(bi);
	}


}
