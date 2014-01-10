package applications;

import gui.IFValChanged;
import mmt_image.FileImageReader;
import mmt_image.FileImageWriter;
import mmt_image.GammaCorrection;
import mmt_image.MMTImage;

public class GammaCorrectApp {
	static String outputFileName;
	public GammaCorrectApp() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 * Execution: GammaCorrectApp <SOURCEPATH> <lambda>
	 */
	public static void main(String[] args) {
		double lambda = 1;
		if (args.length>0){
			if(args.length>1){
				lambda = Double.parseDouble(args[1]);
			}
			
			System.out.println(args[0]);
			final MMTImage imgIn = FileImageReader.read(args[0]);
			//histogram.printHashTable(imgIn.getData());
			outputFileName = args[0].split("\\.")[0]+"_GC"+"."+args[0].split("\\.")[1];
			MMTImage imgOut = GammaCorrection.process(imgIn,lambda);
			
			
			
		}
		else{
			System.out.println("No Data");
			
		}

	}
	
	

}
