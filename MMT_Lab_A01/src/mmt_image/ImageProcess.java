package mmt_image;

/**
 * Global Class for Image Processing
 * Ever algorithm should inherit from this class
 * @author Martin
 *
 */
public class ImageProcess {
	


	
	//Global constants for image processing
	//Max Grayvalue
	public static final int W_MAX = 255;
	//Min Grayvalue
	public static final int W_MIN = 0;
	public static final int o0 = 0;
	public static final int o1 = 255;

	
	public enum FilterType{
		LAPLACIAN4,LAPLACIAN8,SOBEL;
		
		
		
	}
}
