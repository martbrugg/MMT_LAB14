package mmt_image;

import java.util.Hashtable;

public class GlobalThresholding extends ImageProcess {
	
	/**
	 * Process Gamma correction algorithm on an image
	 * @param imgIn Source image
	 * @param lambda Gamma value
	 * @return processed image
	 */
	public static MMTImage process(MMTImage imgIn , int k){
		//Create output image
		MMTImage imgOut = new MMTImage(imgIn.getWidth(), imgIn.getHeight());
		//Create histogramm
		Hashtable<Integer, Integer> table = Histogram.createHashTable(imgIn.getData());
		
		//Appliance of the algorithm for each pixel
		for (int i = 0; i < imgIn.getData().length; i++) {
			int gOut;
			int gIn = imgIn.getData()[i];
			
			if (gIn <= k){
				gOut = o0;
			}
			else {
				gOut = o1;
			}
			imgOut.setPixel(i, gOut);
		}
		//return processed image
		return imgOut;
	}

}
