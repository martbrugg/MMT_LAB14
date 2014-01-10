package mmt_image;

import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class FileImageReader {
	

	public FileImageReader() {
		// TODO Auto-generated constructor stub
	}

	public static MMTImage read(String fname){
		
		// File handle
		File f = new File(fname);
		
		//Reading ImageData into Buffered Image type
		BufferedImage bi;
		try {
			bi = ImageIO.read(f);
		} catch (IOException e) {
			//Error Message in case of error
			System.out.println("Error opening File!!!");
			e.printStackTrace();
			return null;
		}
		//System Message
		System.out.println("Opening file successfull");
		//Define Raster
		Raster raster = bi.getData();
		
		//Read height and width from raster
		int width = raster.getWidth();
		int height = raster.getHeight();

		//create MMTImage object
		MMTImage img = new MMTImage(width, height);
		
		//set Name of image
		img.setName(fname.substring(fname.lastIndexOf("/")+1, fname.lastIndexOf('.')));
		
		
		//Transfering the data to to MMTImage object array
		raster.getPixels(0, 0, width, height, img.getData());
		
		return img;
	}
}
