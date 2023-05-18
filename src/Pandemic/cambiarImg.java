//Mehdi Tahrat && David hola
package Pandemic;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.border.Border;
/**
 * Esta calsse sirve a rescalar el tamanyo de las imagenes
 * @author DAME
 *
 */
public class cambiarImg {
	/**
	 * Borde que tendran algunos labels
	 */
	public static final Border bordeN = BorderFactory.createLineBorder(Color.BLACK, 6);
	/**
	 * Tamanyo de la pantalla
	 */
	public static Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
	/**
	 * Color azul claro
	 */
	public static Color color1 = new Color(71,161,197);
	/**
	 * Esta funcion devuelve una imagen rescalada al tamanyo deseado
	 * @param im ImageIcon - imagen a escalar
	 * @param w int - anchura de la imgan
	 * @param h int - alzada de la imagen
	 * @return ImageIcon
	 */
	public static ImageIcon tamanyo(ImageIcon im, int w, int h) {
		BufferedImage bi = new BufferedImage(w,h, BufferedImage.TRANSLUCENT);
		Graphics2D gd=(Graphics2D)bi.createGraphics();
		gd.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY));
		gd.drawImage(im.getImage(),0,0,w,h,null);
		gd.dispose();
		return new ImageIcon(bi);
	}


}
