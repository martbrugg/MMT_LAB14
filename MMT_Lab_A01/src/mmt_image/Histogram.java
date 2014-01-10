package mmt_image;

import java.util.Hashtable;

public class Histogram {
	
	/**
	 * print Histogram from image data
	 * @param data array of pixels with gray value
	 */
	public static void printHashTable(int[] data){
		//Create Hashtable from data arry
		Hashtable <Integer, Integer> table = createHashTable(data);
		
		//Iterate through each gray value
		for(int i = 0 ; i<256; i++){
			//Print gray value and amount if its in the table
			if(table.containsKey(i)){
				System.out.println(i + ": \t" + table.get(i));	
			}
		}
	}
	
	/**
	 * Create Histogram from image data
	 * @param data arry of pixels with gray value
	 * @return Histogram as a Hashtable
	 */
	public static Hashtable <Integer, Integer> createHashTable(int[] data){
		//Create empty Hashtable
		Hashtable <Integer, Integer> table = new Hashtable<Integer, Integer>();
		//Iterate trough each pixel
		for (int pixel : data) {
			//Increment if Grayvalue is already in table
			if (table.containsKey(pixel)){
				table.put(pixel, table.get(pixel)+1);
			}
			//Initialize table for this Grayvalue with 1
			else{
				table.put(pixel, 1);	
			}
		}
		//Return Histogram as a Hashtable
		return table;
		
	}
	
	/**
	 * Get Minimum Grayvalue
	 * @param table Histogram as a Hashtable
	 * @return Minimum Grayvalue
	 */
	public static int getMinGrayValue(Hashtable <Integer, Integer> table){
		//Initialize Minimum with 255
		int min = 255;
		
		//Iterate trough each Grayvalue
		for(int i = 0 ; i<256; i++){
			//sets minimum to act Grayvalue and exits the loop
			if(table.containsKey(i)){
				min = i;
				break;
			}
		}
		//Return Minimum Grayvalue
		return min;
	}
	
	/**
	 * Get Maximum Grayvalue
	 * @param table Histogram as a Hashtable
	 * @return Maximum Grayvalue
	 */
	public static int getMaxGrayValue(Hashtable <Integer, Integer> table){
		//Initialize Maximum with 0
		int max = 0;
		
		//Iterate trough each Grayvalue in reverse direction
		for(int i = 255 ; i>=0; i--){
			//sets maximum to act Grayvalue and exits the loop
			if(table.containsKey(i)){
				//System.out.println("Key " + i);
				max = i;
				break;
			}
		}
		//Return Maximum Grayvalue
		return max;
	}
	
	/**
	 * Creates normalized Histogram from Histogram
	 * @param data Histogram as a Hashtable
	 * @param size Size of the img im number of pixels
	 * @return Normalized Histogram as Hashtable
	 */
	public static Hashtable <Integer, Float> normalizedHistogram(Hashtable <Integer, Integer> data, int size){
		//Create empty Hashtable for normalized Histogram
		Hashtable<Integer, Float> table = new Hashtable<Integer, Float>();
		
		//Iterate through each Grayvalue
		for(int i = 0 ; i<256; i++){
			//If Item found for this Grayvalue calculation of the normalized value save into Normalized Histogram
			if(data.containsKey(i)){
				float value = (float)data.get(i)/size;
				table.put(i, value);
			}
		}
		//Return of the Normalized Histogram as Hashtable
		return table;
		
	}
	
	/**
	 * Draws a histogramm Image of an Image
	 * @param image
	 * @return Histogramm Image
	 */
	public static MMTImage DrawHistogramm(MMTImage image){
		
		//Hashtable for normalized histogram
		Hashtable<Integer, Float> htable = Histogram.normalizedHistogram(Histogram.createHashTable(image.getData()), image.getData().length);
		//Creating an empty image for the histogramm and init every pixel with 255
		MMTImage histimg = new MMTImage(257, 257);
		for(int i=0; i < histimg.getData().length;i++){
			histimg.setPixel(i, 255);
		}
		
		//Calculation of the max value of the histogramm (for scaling the image)
		float max = 0;
		for(int i = 0; i < 256; i++){
			if(htable.containsKey(i)){
				if (htable.get(i)>max){
					max = htable.get(i);
				}
			}
		}
		
		//Iteration throug all grayvalues and drawing the histogramimage
		for(int i = 0; i < 257; i++){
			histimg.setPixel(0, i, 0);
			histimg.setPixel(i, 256, 0);
			
		}
		
		for(int i = 0; i < 256; i++){
			if(htable.containsKey(i)){
				int yval =  (int) ((htable.get(i)/max) * 255);
				System.out.println(yval);
				for(int j=0;j<yval;j++){
					histimg.setPixel(i+1, 255-j, 0);
					
				}
			}
			
			
		}
		//return the image
		return histimg;
		
	}
	
	

}
