package mmt_image;

import java.util.Hashtable;

public class ImageFiltering extends ImageProcess {

	public ImageFiltering() {
	}
	/**
	 * Process Image filtering algorithm on an image
	 * @param imgIn
	 * @return processed image
	 */
	
	
	public static MMTImage process(MMTImage imgIn){
		
		//Call of the method and return the image
		return UnsharpMasking(imgIn);
		
	}
	
	/**
	 * Process UnsharpMasking algorithm on an image
	 * @param imgIn
	 * @return
	 */
	public static MMTImage UnsharpMasking(MMTImage imgIn){
		//Creating the output image
		MMTImage imgOut = new MMTImage(imgIn.getWidth(), imgIn.getHeight());
		//Creation of a blurred image with raster 25
		MMTImage blurredImg = MedianFilter.process(imgIn, 25);
		
		//Iteration through all Pixels applyance of the algorithm
		for (int i = 0; i < imgIn.getData().length; i++) {
			imgOut.setPixel(i, MMTRaster.Clipping(imgIn.getPixel(i) + imgIn.getPixel(i) - blurredImg.getPixel(i)));
		}
		
		//return Image
		return imgOut;
	}
	
	/**
	 * Process HighboostFilteralgorithm on an image
	 * @param imgIn
	 * @param factor factor for Filter
	 * @return
	 */
	public static MMTImage HighboostFiltering(MMTImage imgIn, double factor){
		//Creating the output image
		MMTImage imgOut = new MMTImage(imgIn.getWidth(), imgIn.getHeight());
		//Iteration through all Pixels applyance of the algorithm
		MMTImage blurredImg = MedianFilter.process(imgIn, 15);
		for (int i = 0; i < imgIn.getData().length; i++) {
			imgOut.setPixel(i, MMTRaster.Clipping(imgIn.getPixel(i) + (int) (factor * (imgIn.getPixel(i) - blurredImg.getPixel(i)))));
		}
		
		
		return imgOut;
	}
	
	

}
