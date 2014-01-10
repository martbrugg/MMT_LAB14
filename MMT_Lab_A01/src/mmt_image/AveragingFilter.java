package mmt_image;

import java.util.Hashtable;

public class AveragingFilter extends ImageProcess {

	public AveragingFilter() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * Process Averaging Filter algorithm on an image
	 * @param imgIn
	 * @return processed image
	 */
	public static MMTImage process(MMTImage imgIn, int rSize){
		//Create output image
		MMTImage imgOut = new MMTImage(imgIn.getWidth(), imgIn.getHeight());
		//Create Histogram
		MMTRaster raster = new MMTRaster(rSize);
		
		//Itertion through all Pixel
		for (int i = 0; i < imgIn.getData().length; i++) {
			//Set Raster for this pixel
			raster.setRaster(imgIn, imgIn.getXPos(i), imgIn.getYPos(i));
			//Apply Average algorithm
			imgOut.setPixel(i, raster.getAverage());
		}
		//Return Image
		return imgOut;
	}
	
	

}
