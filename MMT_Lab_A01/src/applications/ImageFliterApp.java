package applications;

import mmt_image.AveragingFilter;
import mmt_image.FileImageReader;
import mmt_image.FileImageWriter;
import mmt_image.GammaCorrection;
import mmt_image.ImageFiltering;
import mmt_image.ImageProcess;
import mmt_image.ImageProcess.FilterType;
import mmt_image.LaplacianFilter;
import mmt_image.MMTImage;
import mmt_image.Sobel;

public class ImageFliterApp {

	public ImageFliterApp() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double factor = 1;
		if (args.length>0){
			if(args.length>1){
					factor = Double.parseDouble(args[2]);
				}
			
			
			
			MMTImage imgIn = FileImageReader.read(args[0]);
			MMTImage imgOut = ImageFiltering.HighboostFiltering(imgIn, factor);
			String outputFileName = args[0].split("\\.")[0]+"_USM"+ "."+args[0].split("\\.")[1];
			FileImageWriter.write(imgOut, outputFileName);

			
		}
		else{
			System.out.println("No Data");
			
		}

	}

}
