package mmt_image;

import java.util.Hashtable;

public class LaplacianFilter extends ImageProcess {

	public LaplacianFilter() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 * @param imgIn Image
	 * @param type Type of filter
	 * @param factor Factor for combination from gradient and picture
	 * @return
	 */
	public static MMTImage process(MMTImage imgIn, FilterType type, double factor){
		//Create output image
		MMTImage imgOut = new MMTImage(imgIn.getWidth(), imgIn.getHeight());
		//Create Histogram
		MMTRaster raster = new MMTRaster(3);
		
		//Itaration through the image
		for (int i = 0; i < imgIn.getData().length; i++) {
			//set 3x3 raster
			raster.setRaster(imgIn, imgIn.getXPos(i), imgIn.getYPos(i));
			//Laplacian 4 calculation
			if (type == FilterType.LAPLACIAN4){
				imgOut.setPixel(i, raster.getLaplacian4(factor));
				}
			//Laplacian 8 calculation
			if (type == FilterType.LAPLACIAN8){
				imgOut.setPixel(i, raster.getLaplacian8(factor));
				}
		}
		
		//return image
		return imgOut;
	}
	
	public static MMTImage process(MMTImage imgIn, FilterType type){
		
		//call of the algorithm and return of the image
		return process(imgIn, type, 0);
	}
	
	

}
