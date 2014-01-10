package mmt_image;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class FileImageWriter {
	
	
	static int width;
	static int height;

	public FileImageWriter() {
		// TODO Auto-generated constructor stub
	}
	
	public static void write(MMTImage img, String fname){
		
		write(img,fname,"jpg");
		
	
	}
	public static void write(MMTImage img, String fname, String format){
		
		//Create new Bufferd Image
		BufferedImage bi = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
		
		//Get the raster
		WritableRaster r = bi.getRaster();
		
		//Set SampleValues
		r.setSamples(0, 0, bi.getWidth(), bi.getHeight(), 0, img.getData());
		
		//File handle
		File f = new File(fname);
		
		
		//Write date to file
		try {
			ImageIO.write( bi, format, f);
		} catch (IOException e) {
			//Errormessage in case of an error
			System.out.println("Error writing File!!!");
			e.printStackTrace();
		}
		//System message
		System.out.print("FileWrite successfull");
	}
	
public static BufferedImage getImage(MMTImage img){
		
		//Create new Bufferd Image
		BufferedImage bi = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
		
		//Get the raster
		WritableRaster r = bi.getRaster();
		
		//Set SampleValues
		r.setSamples(0, 0, bi.getWidth(), bi.getHeight(), 0, img.getData());
		
		return bi;

}
}
