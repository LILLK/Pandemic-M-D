package Pandemic;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Logico.Rankings;

public class JF_ScrolRank extends JPanel {
	 
    public JF_ScrolRank() {
        //JPanel pnlcenter = new JPanel();
        Color color = new Color(71, 161, 197);
        int i=0;
        for(Rankings ranking : JF_PanelPuntuaciones.rankings) {
			JLabel label = new JLabel();
			label.setBounds(0, 0+(100*i), 800,100 );
			label.setBackground(color);
			label.setBorder(BorderFactory.createLineBorder(Color.black));
			label.setText(ranking.brotes+ranking.nomb_us);
			label.setVisible(true);
			label.setOpaque(true);
			this.add(label);
			
			i++;
		}
        this.setLayout(null); // por defecto usa FlowLayout
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setBounds(0, 0, 200, 200);
        this.setPreferredSize(new Dimension(600, 600));
        this.setVisible(true);
 
        final JScrollPane scroller = new JScrollPane(this,  JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroller.setViewportView(this);
 
        this.setSize(new Dimension(400,400));
        add(scroller);
        //this.pack();
 
        //this.setLocationRelativeTo(null);
 
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
 