package ui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class BackgroundPanel extends JPanel{
	
	private Image image;
	
	public BackgroundPanel(String img) {
	    this(new ImageIcon(img).getImage());
	  }

	public BackgroundPanel(Image image) {
		super();
		this.image = image;
		/*Dimension size = new Dimension(image.getWidth(this), image.getHeight(this));
	    //setPreferredSize(size);
	    //setMinimumSize(size);
	    this.setMaximumSize(size);
	    //setSize(size);
	    setLayout(null);*/
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
	}
	

}