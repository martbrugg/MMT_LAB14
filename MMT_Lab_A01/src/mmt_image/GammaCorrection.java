package mmt_image;

import java.util.Hashtable;

public class GammaCorrection extends ImageProcess {
	
	/**
	 * Process Gamma correction algorithm on an image
	 * @param imgIn Source image
	 * @param lambda Gamma value
	 * @return processed image
	 */
	public static MMTImage process(MMTImage imgIn , double lambda){
		//Create output image
		System.out.println("Gamacorrection with lamda: " + lambda);
		MMTImage imgOut = new MMTImage(imgIn.getWidth(), imgIn.getHeight());
		//Create histogramm
		Hashtable<Integer, Integer> table = Histogram.createHashTable(imgIn.getData());
		
		//Appliance of the algorithm for each pixel
		for (int i = 0; i < imgIn.getData().length; i++) {
			int gOut;
			int gIn = imgIn.getData()[i];
			gOut = (int)((W_MAX-W_MIN)*Math.pow(((double)gIn - W_MIN)/(W_MAX-W_MIN),lambda)+W_MIN);
			imgOut.setPixel(i, gOut);
		}
		//return processed image
		return imgOut;
	}

}
