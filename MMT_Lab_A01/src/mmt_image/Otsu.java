package mmt_image;


import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Otsu<item> extends ImageProcess {
	
	/**
	 * Process Otsu algorithm on an image
	 * @param imgIn Source image
	 * @return processed image
	 */
	public static MMTImage process(MMTImage imgIn){
		//Create output image
		MMTImage imgOut = new MMTImage(imgIn.getWidth(), imgIn.getHeight());
		
		//Create normalized histogramm
		Hashtable<Integer, Float> normtable = Histogram.normalizedHistogram(Histogram.createHashTable(imgIn.getData()),imgIn.getSize());
		
		
		//Compute cumulative probabilities
		float [] p1 = new float[W_MAX+1];
		float [] p2 = new float[W_MAX+1];
		//Iteration trought all grayvalues
		for (int i = 0; i<=W_MAX; i++){
			float p = 0;
			
			for(int j=0;j<=i;j++){
				//Check if value in Hashtable
				if (normtable.containsKey(j)){
					//Increment temporary probability
					p += normtable.get(j);
				}
			}
			//Set P1 and P2
			p1[i]=p;
			p2[i]=1-p;
		}
		
		//Compute cumulative means
		int [] mean1 = new int[W_MAX+1];
		int [] mean2 = new int[W_MAX+1]; 
		
		//Iteration through all grayvalues
		for (int i = 0; i<=W_MAX; i++){
			
			//Calculation of meanvalue 1
			//tmp Meanvalue and initialisation with 0
			float tmpmean = 0;
			
			//Iteration from 0 to i
			for(int j=0;j<=i;j++){
				//Check if value in Hashtable
				if (normtable.containsKey(j)){
					//Increment temporary meanvalue
					tmpmean += normtable.get(j)*j;
				}
			}
			//Calculation of meanvalue 1
			mean1[i]=(int) (tmpmean/p1[i]);
			
			//Calculation of meanvalue2
			//reset of temporary meanvalue
			tmpmean=0;
			
			//Iteration from i to 255
			for(int j=i;j<=W_MAX;j++){
				//Check if value in Hashtable
				if (normtable.containsKey(j)){
					//Incrementant tmporary meanvalue
					tmpmean += normtable.get(j)*j;
				}
			}
			//Calculation of meanvalue2
			mean2[i]=(int) (tmpmean/p2[i]);
			
		}
		
		//Compute global intensity mean
		//Init of globalmean with 0
		int globalmean = 0;
		
		//Iteration through grayvalues
		for (int i = 0; i<=W_MAX; i++){
			//Check if value in Hashtable
			if (normtable.containsKey(i)){
				//Incrementation  and calculation of globalmean
				globalmean+=normtable.get(i)*i;
			}
		}
		
		
		//Compute Inter-class variance
		float [] interclassVar = new float[W_MAX+1];
		//temporary list for multiple maxvalues
		List<Integer> maxInterclassVarList = new ArrayList<Integer>();
		//Init of tmpMaximum with 0
		float tmpMax = 0;
		//Iteration through grayvalues
		for (int i = 0; i<=W_MAX; i++){
				//Calculation of Inter-class variance
				interclassVar[i]= (float) (p1[i]*Math.pow(mean1[i]-globalmean,2)+p2[i]*Math.pow(mean2[i]-globalmean,2));
				
				//Check for the Max values
				//Add actual i to list if Interclassvar equals maximum
				if (interclassVar[i]==tmpMax){	
					maxInterclassVarList.add(i);	
				}
				//Reset list and add Interclassvar if it's bigger than maximum
				else if (interclassVar[i]>tmpMax){
					maxInterclassVarList.clear();
					maxInterclassVarList.add(i);	
					tmpMax = interclassVar[i];
				}
			}
		
		//Calculation of the Threshold
		int k = 0;
		//Calculation of mean k
		for(Integer item :maxInterclassVarList){
			k += item;
		}
		k = k/maxInterclassVarList.size();
		
		//Appliance of the threshhold algorithm for each pixel
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
		System.out.println("Otsu with k: " + k);
		//Return Image
		return imgOut;
	}
	
	

}
