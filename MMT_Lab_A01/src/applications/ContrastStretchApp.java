package applications;

import mmt_image.ContrastStretching;
import mmt_image.FileImageReader;
import mmt_image.FileImageWriter;
import mmt_image.MMTImage;

public class ContrastStretchApp {

	public ContrastStretchApp() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 * Execution: ConrastStretchApp <SOURCEPATH>
	 */
	public static void main(String[] args) {
		
		if (args.length>0){
			MMTImage imgIn = FileImageReader.read(args[0]);
			MMTImage imgOut = ContrastStretching.process(imgIn);
			String outputFileName = args[0].split("\\.")[0]+"_CS."+args[0].split("\\.")[1];
			FileImageWriter.write(imgOut, outputFileName);
			System.out.println("Contrast stretching for file "+outputFileName + "successful");
			
			
		}
		else{
			System.out.println("No Data");
			
		}

	}

}
