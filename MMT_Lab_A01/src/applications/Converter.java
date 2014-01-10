package applications;

import java.io.File;
import java.io.FilenameFilter;

import mmt_image.FileImageReader;
import mmt_image.FileImageWriter;
import mmt_image.MMTImage;

public class Converter {
	
	/**
	 * 
	 * @param args
	 * Execution: Converter <SOURCEPATH>
	 */
	public static void main(String[] args) {
		String fileName;
		String pathName = args[0];
		
		//Creating a new File object which takes the filepath as its object
		File dir = new File(pathName);
		
		//Write all the files which end with jpg in a list
		File[] fList = dir.listFiles(new FilenameFilter() {
			// Adding a Filter for Endings
			@Override
			public boolean accept(File dir, String name) {
				//
				return name.endsWith("jpg");
			}
		});
		
		//File conversion
		for (File Item : fList) {
			// Opening File
			MMTImage img = FileImageReader.read(Item.getAbsolutePath());
			// Creating outputfilename
			fileName = pathName + img.getName() + "NEW.png";
			// Writing File
			FileImageWriter.write(img, fileName, "png");
			System.out.println("Conversion of file "+ img.getName() + "successful");
		}
	}
	
		
	


}
