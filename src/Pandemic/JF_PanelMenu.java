package Pandemic;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import Botones.*;

public class JF_PanelMenu extends JPanel implements ActionListener{
	
	BotonNuevaPartida NuevaPartida;
	JButton CargarPartida;
	JButton Infromacion;
	JButton ResumenPuntuaciones;
	JButton Autores;
	JButton Version;
	JButton Salir;
	JFrame marcoP;
	Dimension screenSize;
	
	JF_PanelMenu(){
		
		this.screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		
		setLayout(null);
		this.NuevaPartida = new BotonNuevaPartida();
		this.CargarPartida = new JButton("CargarPartida");
		this.Infromacion = new JButton("Infromacion");
		this.ResumenPuntuaciones = new JButton("ResumenPuntuaciones");
		this.Autores = new JButton("Autores");
		this.Version = new JButton("Version");
		this.Salir = new JButton("Salir");
		
		this.NuevaPartida.setBounds(((this.screenSize.width/2)-100),200,200,50);
		this.CargarPartida.setBounds(((this.screenSize.width/2)-100),260,200,50);
		this.Infromacion.setBounds(((this.screenSize.width/2)-100),320,200,50);
		this.ResumenPuntuaciones.setBounds(((this.screenSize.width/2)-100),380,200,50);
		this.Autores.setBounds(((this.screenSize.width/2)-100),440,200,50);
		this.Version.setBounds(((this.screenSize.width/2)-100),500,200,50);
		this.Salir.setBounds(((this.screenSize.width/2)-100),560,200,50);
		
		
		add(this.NuevaPartida);
		add(this.CargarPartida);
		add(this.Infromacion);
		add(this.ResumenPuntuaciones);
		add(this.Autores);
		add(this.Version);
		add(this.Salir);
		
		//this.NuevaPartida.addActionListener(this);
		this.CargarPartida.addActionListener(this);
		this.Infromacion.addActionListener(this);
		this.ResumenPuntuaciones.addActionListener(this);
		this.Autores.addActionListener(this);
		this.Version.addActionListener(this);
		this.Salir.addActionListener(this);
		
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == this.Infromacion){
			
			JFrame marcoP = (JFrame)SwingUtilities.getWindowAncestor(this);	
			marcoP.remove(this);
			marcoP.add(new JF_PanelInfo());
			marcoP.setVisible(true);
		}
		if(e.getSource() == this.Autores){
			
			JFrame marcoP = (JFrame)SwingUtilities.getWindowAncestor(this);	
			marcoP.remove(this);
			marcoP.add(new JF_PanelAutores());
			marcoP.setVisible(true);
		}
		
		if(e.getSource() == this.Version){
			
			JFrame marcoP = (JFrame)SwingUtilities.getWindowAncestor(this);	
			marcoP.remove(this);
			marcoP.add(new JF_PanelVersion());
			marcoP.setVisible(true);
		}
		
		
		if(e.getSource()== Salir) {
			System.exit(0);
		}
	}
	public void paint(Graphics g) {
		BufferedImage imgFondo;
		try {
			Dimension size =getSize();
			imgFondo = ImageIO.read(new File("imagenes/imagenPandemic.png"));
			g.drawImage(imgFondo, 0, 0, size.width, size.height,null);
			setOpaque(false);
			super.paint(g);
		} catch (IOException e) {
			System.out.print("ds");
		}
		
		
	}

	

}
