import mmt_image.FileImageReader;
import mmt_image.FileImageWriter;
import mmt_image.Histogram;
import mmt_image.MMTImage;


public class main {

	public main() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		MMTImage Image1 = FileImageReader.read("/Users/Martin/FH/SS2013/Multimedia_Technologien/LB/Test_Images/Enhancement/IMG7866_CS.jpg");
		MMTImage Image2 = Histogram.DrawHistogramm(Image1);
		
		//Image1.printData();
		
		//Test function
		//for(int iterator=0; iterator< Image1.getData().length/2;iterator++){
			
			//Image1.setPixel(iterator, 0);
		//}
		//FileImageWriter.write(Image1, "/Users/Martin/FH/SS2013/Multimedia Technologien/LB/Test_Images/Enhancement/IMG109_COPY.jpg");
		FileImageWriter.write(Image2, "/Users/Martin/FH/SS2013/Multimedia_Technologien/LB/Test_Images/Enhancement/HIST_TEST.jpg");
	}
	
		

}
