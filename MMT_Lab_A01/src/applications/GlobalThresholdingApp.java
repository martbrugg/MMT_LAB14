package applications;

import gui.IFValChanged;
import mmt_image.FileImageReader;
import mmt_image.FileImageWriter;
import mmt_image.GammaCorrection;
import mmt_image.GlobalThresholding;
import mmt_image.IterativeGlobalThresholding;
import mmt_image.Histogram;
import mmt_image.MMTImage;

public class GlobalThresholdingApp {
	static String outputFileName;
	public GlobalThresholdingApp() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 * Execution <SOURCEPATH> <threshold>
	 */
	public static void main(String[] args) {
		int k = 128;
		if (args.length>0){
			if(args.length>1){
				k = Integer.parseInt(args[1]);
			}
			
			MMTImage imgIn = FileImageReader.read(args[0]);
			outputFileName = args[0].split("\\.")[0]+"_GTH"+"."+args[0].split("\\.")[1];
			MMTImage imgOut = GlobalThresholding.process(imgIn, k);
			FileImageWriter.write(imgOut, outputFileName);
			
		}
		else{
			System.out.println("No Data");
			
		}

	}
	
	

}
