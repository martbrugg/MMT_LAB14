package mmt_image;

import java.util.Hashtable;

public class IterativeGlobalThresholding<item> extends ImageProcess {
	
	/**
	 * Process Iterative Global Thresholding algorithm on an image
	 * @param imgIn Source image
	 * @return processed image
	 */
	public static MMTImage process(MMTImage imgIn){
		//set default threshold
		int k = 128;
		
		System.out.println("Global Thresholding with k: " + k);
		//Create output image
		MMTImage imgOut = new MMTImage(imgIn.getWidth(), imgIn.getHeight());
		//Create histogramm
		Hashtable<Integer, Integer> table = Histogram.createHashTable(imgIn.getData());
		
		//calculation of the threshold
		k = calcThreshold(table, k);
		
		
		
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
	
	/**
	 * 
	 * @param table histogramm
	 * @param k threshold
	 * @return threshold
	 */
	public static int calcThreshold(Hashtable<Integer, Integer> table, int k){
		System.out.println("calcThreshold with k: " + k );
		//set delta
		int deltak = 5;
		//old threshold
		int kOld = k;
		//init lower Mean and n1
		int lowerMean = 0;
		int n1 = 0;
		//init higher Mean and n2
		int higherMean = 0;
		int n2 = 0;
		//Iteration through all grayvalues
		for(int i = 0; i < 256; i++){
			if(table.containsKey(i)){
				//increment and calc of lower mean if i < threshold
				if (i<=k){
					lowerMean += table.get(i)*i;
					n1+= table.get(i);
						
				}
				//increment and calc of higher mean if i > threshold
				else if (i>k){
					higherMean += table.get(i)*i;
					n2+= table.get(i);
						
				}
				
			}
		}
		
		//calculation of lower mean
		lowerMean = lowerMean/n1;
		//calcualtion of higher mean
		higherMean = higherMean/n2;
		
		//calculation of new threshold
		k = (lowerMean + higherMean)/2;
		//return threshold if  diff lower than delta
		if (Math.abs(k-kOld)<deltak){
			return k;
		}
		
		//recursive call if bigger
		else {
			return calcThreshold(table, k);
		}
		
		
		
	}

}
