package applications;

import mmt_image.FileImageReader;
import mmt_image.FileImageWriter;
import mmt_image.HistogramEqualization;
import mmt_image.MMTImage;

public class HistogramEqualizationApp {

	public HistogramEqualizationApp() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 * Execution: HistogramEqualizationApp <SOURCEPATH>
	 */
	public static void main(String[] args) {
		
		if (args.length>0){
			MMTImage imgIn = FileImageReader.read(args[0]);
			MMTImage imgOut = HistogramEqualization.process(imgIn);
			String outputFileName = args[0].split("\\.")[0]+"_HE."+args[0].split("\\.")[1];
			FileImageWriter.write(imgOut, outputFileName);
			System.out.println("Histogram equalization for file "+outputFileName + "successful");
			
			
		}
		else{
			System.out.println("No Data");
			
		}

	}

}
