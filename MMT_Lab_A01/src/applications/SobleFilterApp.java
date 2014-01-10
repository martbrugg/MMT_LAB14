package applications;

import mmt_image.AveragingFilter;
import mmt_image.FileImageReader;
import mmt_image.FileImageWriter;
import mmt_image.GammaCorrection;
import mmt_image.ImageProcess;
import mmt_image.ImageProcess.FilterType;
import mmt_image.LaplacianFilter;
import mmt_image.MMTImage;
import mmt_image.Sobel;

public class SobleFilterApp {

	public SobleFilterApp() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int rasterSize = 3;
		
		if (args.length>0){
			System.out.println(args[0]);
			MMTImage imgIn = FileImageReader.read(args[0]);
			//histogram.printHashTable(imgIn.getData());
			MMTImage imgOut = Sobel.process(imgIn,0);
			String outputFileName = args[0].split("\\.")[0]+"_SobFil_Raster"+ rasterSize+"."+args[0].split("\\.")[1];
			System.out.println(outputFileName);
			FileImageWriter.write(imgOut, outputFileName);
			
			
		}
		else{
			System.out.println("No Data");
			
		}

	}

}
