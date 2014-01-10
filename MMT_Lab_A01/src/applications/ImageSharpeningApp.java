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

public class ImageSharpeningApp {

	public ImageSharpeningApp() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 * Execution ImageSharpeningApp <SOURCEPATH> <FilterType> <factor>
	 * Possible Filtertypes 
	 * 			L4 Laplaian 4
	 * 			L8 Laplacian 8
	 * 			S  Sobel
	 */
	public static void main(String[] args) {
		//Rastersize 
		int rasterSize = 3;
		//default factor = 0. If not set as parameter it will create just the filter response
		double factor = 0;
		//default filter type. If not set as parameter it will use laplacian4 Filter 
		ImageProcess.FilterType type = FilterType.LAPLACIAN4;
		
		//interpretation of the command line parameter
		if (args.length>0){
			if(args.length>1){
			
				if (args[1].contains("L8")){
					type = ImageProcess.FilterType.LAPLACIAN4;
				}
				
				else if (args[1].contains("L8")){
					type = ImageProcess.FilterType.LAPLACIAN8;
				}
				
				else if (args[1].contains("S")){
					type = ImageProcess.FilterType.SOBEL;
				}
				
				
				if(args.length>2){
					factor = Double.parseDouble(args[2]);
				}
			}
			
			//Open the file
			MMTImage imgIn = FileImageReader.read(args[0]);
			
			//Execution of the relevant filteralgorithm
			if ( type == ImageProcess.FilterType.LAPLACIAN4 || type == ImageProcess.FilterType.LAPLACIAN8){
				MMTImage imgOut = LaplacianFilter.process(imgIn,type,factor);
				String outputFileName = args[0].split("\\.")[0]+"_FilLAP_Raster"+ rasterSize+"."+args[0].split("\\.")[1];
				FileImageWriter.write(imgOut, outputFileName);
			}
			
			else if ( type == ImageProcess.FilterType.SOBEL){
				MMTImage imgOut = Sobel.process(imgIn ,factor);
				String outputFileName = args[0].split("\\.")[0]+"_FilSOB_Raster"+ rasterSize+"."+args[0].split("\\.")[1];
				FileImageWriter.write(imgOut, outputFileName);
			}
			
			
			
			
			
		}
		else{
			System.out.println("No Data");
			
		}

	}

}
