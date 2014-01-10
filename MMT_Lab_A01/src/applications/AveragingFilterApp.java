package applications;

import mmt_image.AveragingFilter;
import mmt_image.FileImageReader;
import mmt_image.FileImageWriter;
import mmt_image.GammaCorrection;
import mmt_image.MMTImage;

public class AveragingFilterApp {

	public AveragingFilterApp() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 * Execution: AveragingFilterApp <SOURCEPATH> <rastersize>
	 */
	public static void main(String[] args) {
		int rasterSize = 3;
		if (args.length>0){
			if(args.length>1){
				rasterSize = Integer.parseInt(args[1]);
			}
			
			
			MMTImage imgIn = FileImageReader.read(args[0]);
			MMTImage imgOut = AveragingFilter.process(imgIn,rasterSize);
			String outputFileName = args[0].split("\\.")[0]+"_AVFil_Raster"+ rasterSize+"."+args[0].split("\\.")[1];
			FileImageWriter.write(imgOut, outputFileName);
			System.out.println("Averagingfilter for file "+outputFileName + "successful");
		}
		else{
			System.out.println("No Data");
			
		}

	}

}
