package applications;

import gui.IFValChanged;
import mmt_image.FileImageReader;
import mmt_image.FileImageWriter;
import mmt_image.GammaCorrection;
import mmt_image.GlobalThresholding;
import mmt_image.IterativeGlobalThresholding;
import mmt_image.Histogram;
import mmt_image.MMTImage;
import mmt_image.Otsu;

public class OtsuApp {
	static String outputFileName;
	

	/**
	 * @param args
	 * Execution OtsuApp <SOURCEPATH>
	 */
	public static void main(String[] args) {
		if (args.length>0){
			MMTImage imgIn = FileImageReader.read(args[0]);
			outputFileName = args[0].split("\\.")[0]+"_OTSU"+"."+args[0].split("\\.")[1];
			MMTImage imgOut = Otsu.process(imgIn);
			FileImageWriter.write(imgOut, outputFileName);
			
		}
		else{
			System.out.println("No Data");
			
		}

	}
	
	

}
