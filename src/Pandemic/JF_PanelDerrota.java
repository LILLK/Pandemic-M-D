package Pandemic;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;

import Botones.BotonAtras;
import Logico.Partida;

public class JF_PanelDerrota extends JPanel {
	
	BotonAtras Atras;
	Dimension screenSize;
	
	public JF_PanelDerrota() {
	
		setLayout(null);
		this.screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		String s = "<html>"+"<p><center>"+"Puntuacion: "+Partida.Puntuacion +"</center></p>"+"<p><center>" +"Ronda: "+Partida.ronda +	"</center></p>"+"</html>";
		
		  

		this.Atras = new BotonAtras(this);
		JLabel Info = new JLabel();
		Border borde = BorderFactory.createLineBorder(Color.BLACK,6);
		Color color =new Color(71, 161, 197);
		JLabel TInfo = new JLabel();
		
		TInfo.setBounds(((this.screenSize.width/2)-(this.screenSize.width/6)),(this.screenSize.height/7),(this.screenSize.width/3),(this.screenSize.height/5));
		TInfo.setText("<html><p><center>Derota!!!!<center/></p></html>");
		TInfo.setForeground(Color.BLACK);
		TInfo.setFont(new Font("Stika Text",Font.BOLD,(this.screenSize.height/15)));
		TInfo.setBackground(color);
		TInfo.setBorder(borde);
		TInfo.setVisible(true);
		TInfo.setOpaque(true);
		
		Info.setBounds(((this.screenSize.width/2)-(this.screenSize.width/6)),(this.screenSize.height/7*3),(this.screenSize.width/3),(this.screenSize.height/5));
		Info.setText(s);
		Info.setForeground(Color.BLACK);
		Info.setFont(new Font("Stika Text",Font.BOLD,this.screenSize.height/53));
		Info.setBackground(color);
		Info.setBorder(borde);
		Info.setVisible(true);
		Info.setOpaque(true);
		
		Atras.setBounds(0,(this.screenSize.height-((this.screenSize.width/19))),this.screenSize.width,(screenSize.width/25));
	   // Info.setHorizontalAlignment(Info.CENTER);
	    //Info.setHorizontalAlignment(Info.LEFT);
	
	    //Info.setHorizontalAlignment(Info.LEFT);
		
		
		
		add(this.Atras);
		add(Info);
		add(TInfo);
		
	}

	public void irMenu() {
		JFrame marcoP = (JFrame)SwingUtilities.getWindowAncestor(this);	
		marcoP.remove(this);
		marcoP.add(new JF_PanelMenu());
		marcoP.setVisible(true);
	}
	public void paint(Graphics g) {
		BufferedImage imgFondo;
		try {
			Dimension size =getSize();
			imgFondo = ImageIO.read(new File("imagenes/imagenPandemic6.png"));
			g.drawImage(imgFondo, 0, 0, size.width, size.height,null);
			setOpaque(false);
			super.paint(g);
		} catch (IOException e) {
			System.out.print("Error IMGfondo JF_PanelMenuMenu");
		}
		
		
	} 

}
