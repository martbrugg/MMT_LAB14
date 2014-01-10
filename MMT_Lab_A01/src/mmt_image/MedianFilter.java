package mmt_image;

import java.util.Hashtable;

public class MedianFilter extends ImageProcess {

	public MedianFilter() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * Process Median Filter algorithm on an image
	 * @param imgIn image
	 * @param rSize Rastersize
	 * @return processed image
	 */
	public static MMTImage process(MMTImage imgIn, int rSize){
		//Create output image
		MMTImage imgOut = new MMTImage(imgIn.getWidth(), imgIn.getHeight());
		//create Raster
		MMTRaster raster = new MMTRaster(rSize);
		
		//Iteration through image
		for (int i = 0; i < imgIn.getData().length; i++) {
			
			//Set Raster for pixel
			raster.setRaster(imgIn, imgIn.getXPos(i), imgIn.getYPos(i));
			//calculate median for this pixel
			imgOut.setPixel(i, raster.getMedian());
		}
		//retrun image
		return imgOut;
	}
	
	

}
