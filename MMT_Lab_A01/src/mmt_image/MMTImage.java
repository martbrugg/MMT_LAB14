/**
 * 
 */
package mmt_image;

/**
 * @author Martin
 *
 */
public class MMTImage {

	int[] data;
	String name;
	int width;
	int height;

	public MMTImage(int _width, int _height) {
		
		// writing size to internal variables
		width = _width;
		height = _height;
		//allocating data array with correct size
		data = new int[width*height];
		
	}
	
	/**
	 * Gets name
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
		System.out.println("Name: " + name + " set");
	}
	
	/**
	 * gets width
	 * @return width
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * gets height
	 * @return height
	 */
	public int getHeight() {
		return height;
	}
	
	public int getSize() {
		return height*width;
		
	}
	
	/**
	 * gets data array
	 * @return data array
	 */
	public int[] getData() {
		return data;
	}
	
	/**
	 * sets data array
	 * @param data
	 */
	public void setData(int[] data) {
		this.data = data;
	}
	
	/**
	 * set Pixel in linear format
	 * @param i Position in the array
	 * @param val Value
	 */
	public void setPixel(int i, int val){
		data[i]=val;
		
	}
	
	/**
	 * get Pixel in linear format
	 * @param i Position in the array
	 * @return Value at position
	 */
	public int getPixel(int i){
		return data[i];
	}
	
	/**
	 * set Pixel in 2D format
	 * @param x horizontal position
	 * @param y vertical position
	 * @param val Value
	 */
	public void setPixel(int x, int y, int val){
		//Calculating absolute position
		int pos = y*width + x;
		//Setting value of in data array
		data[pos]=val;
	}
	
	/**
	 * get Pixel in 2D format
	 * @param x horizonal position
	 * @param y vertical position
	 * @return Value at position
	 */
	public int getPixel(int x, int y){
		//Calculating absolute position
		int pos = y*width + x;
		//Setting value of in data array
		return data[pos];
	}
	
	/**
	 * Print pixel data of the array
	 */
	public void printData(){
		System.out.println("Objectname; " + name);
		for (int iCount = 0 ; iCount< data.length;iCount++){
			System.out.println(iCount + ": " + data[iCount]);
		}
		System.out.println("Objectname; " + name);
	}
	
	public int getXPos(int pos){
		return pos-(pos/width)*width;	
	}
	
	public int getYPos(int pos){
		return pos/width;
	}
	
	
	
	
	

}
