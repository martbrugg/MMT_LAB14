package applications;

import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Class MainFrame creates a dialog to show a Picture
 * @author Martin
 *
 */

public class HistogramFrame extends JFrame {

	public HistogramFrame(String title, BufferedImage img) throws HeadlessException {
		super(title);
		//Setting title and size depending on imagesize
		this.setTitle(title);
		this.setSize(img.getWidth(),img.getHeight());
		
		//Graphics hist = new Gr
		//this.add(image);
		//Making the dialog visible
		//this.setVisible(true);
		
	}

	HistogramFrame(String title, GraphicsConfiguration gc) {
		super(title, gc);
		// TODO Auto-generated constructor stub
	}

}
