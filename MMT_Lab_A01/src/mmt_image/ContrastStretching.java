package mmt_image;

import java.util.Hashtable;

public class ContrastStretching extends ImageProcess {

	public ContrastStretching() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * Process Contrast stretching algorithm on an image
	 * @param imgIn
	 * @return processed image
	 */
	public static MMTImage process(MMTImage imgIn){
		//Create output image
		MMTImage imgOut = new MMTImage(imgIn.getWidth(), imgIn.getHeight());
		//Create Histogram
		Hashtable<Integer, Integer> table = Histogram.createHashTable(imgIn.getData());
		
		//Get Min and Max grayvalue
		int gMax = Histogram.getMaxGrayValue(table);
		int gMin = Histogram.getMinGrayValue(table);
		
		//Calculate the Stretchfactor to see the amount of change
		float stretchFactor;
		stretchFactor = 100 - (((float)gMax - gMin)/W_MAX)*100;
		
		//Appliance of the algorithm for each pixel
		for (int i = 0; i < imgIn.getData().length; i++) {
			int gOut;
			int gIn = imgIn.getData()[i];
			gOut = (gIn - gMin)*((W_MAX-W_MIN)/(gMax-gMin))+W_MIN;
			imgOut.setPixel(i, gOut);
			
			
			
		}
		//Debug output of the stretch factor
		System.out.println("Stretchfaktor=" + stretchFactor + "%");
		//Return image
		return imgOut;
	}

}
