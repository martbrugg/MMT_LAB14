package mmt_image;

import java.util.Hashtable;

public class HistogramEqualization extends ImageProcess {

	
	/**
	 * Process Histogram Equalisation algorithm on an image
	 * @param imgIn Source image
	 * @return return processed image
	 */
	public static MMTImage process(MMTImage imgIn){
		////Create output image
		MMTImage imgOut = new MMTImage(imgIn.getWidth(), imgIn.getHeight());
		
		//Create Histogram
		Hashtable<Integer, Integer> table = Histogram.createHashTable(imgIn.getData());
		
		//Create normalized Histogram
		Hashtable<Integer, Float> normtable = Histogram.normalizedHistogram(table, imgIn.getData().length);
		
		//Appliance of the algorithm for each pixel
		for (int i = 0; i < imgIn.getData().length; i++) {
			int gIn = imgIn.getData()[i];
			int gOut;
			//Initialze temporary sum for each pixel
			float sum=0;
			
			//Calculation
			for(int j=0; j<gIn; j++){
				if(normtable.containsKey(j)){
				sum += normtable.get(j);
				}
			}
			gOut = (int) (W_MAX * sum);
			imgOut.setPixel(i, gOut);
		}
		
		//return processed image
		return imgOut;
	}

}
