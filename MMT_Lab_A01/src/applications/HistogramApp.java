package applications;

import mmt_image.FileImageReader;
import mmt_image.MMTImage;
import mmt_image.Histogram;

public class HistogramApp {

	public HistogramApp() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 * Execution: Histogramapp <SOURCEPATH>
	 */
	public static void main(String[] args) {
		
		if (args.length>0){
			System.out.println(args[0]);
			//Open Image
			MMTImage img = FileImageReader.read(args[0]);
			//print  Histogram for this image
			Histogram.printHashTable(img.getData());
			
		}
		else{
			System.out.println("No Data");
			
		}

	}

}
