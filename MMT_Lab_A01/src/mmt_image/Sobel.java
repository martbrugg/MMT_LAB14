package mmt_image;

import java.util.Hashtable;

public class Sobel extends ImageProcess {

	public Sobel() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * Process Sobel algorithm on an image
	 * @param imgIn image
	 * @param factor factor for combination of image and gradient.
	 * @return processed image
	 */
	public static MMTImage process(MMTImage imgIn, double factor){
		//Create output image
		MMTImage imgOut = new MMTImage(imgIn.getWidth(), imgIn.getHeight());
		//Create raster
		MMTRaster raster = new MMTRaster(3);
		
		//Iteration through image
		for (int i = 0; i < imgIn.getData().length; i++) {
				//set raster for pixel
				raster.setRaster(imgIn, imgIn.getXPos(i), imgIn.getYPos(i));
				//set Pixel and with Sobel for pixel
				imgOut.setPixel(i, raster.getSobel(factor));
				
		}
		
		//return image
		return imgOut;
	}
	
	

}
