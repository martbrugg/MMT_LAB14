package gui;

import java.util.ArrayList;
import java.util.List;

import mmt_image.FileImageWriter;
import mmt_image.Histogram;
import mmt_image.MMTImage;

public class MMTImageModel {

	MMTImage Source;
	MMTImage Target;
	MMTImageView view;
	List<MMTImage> history;
	public MMTImageModel(MMTImageView view) {
		this.view = view;
		history = new ArrayList<MMTImage>();
		
	}
	
	/**
	 * @param args
	 */
	
	

	public MMTImage getSource() {
		return Source;
	}

	public void setSource(MMTImage source) {
		System.out.println("Model SetSource");
		Source = source;
		view.setsourceIcon(FileImageWriter.getImage(Source));
		view.setsourceHist(FileImageWriter.getImage(Histogram.DrawHistogramm(source)));
		
		
	}

	public MMTImage getTarget() {
		return Target;
	}

	public void setTarget(MMTImage target) {
		System.out.println("Model SetTarget");
		Target = target;
		view.settargetIcon(FileImageWriter.getImage(Target));
		view.settargetHist(FileImageWriter.getImage(Histogram.DrawHistogramm(Target)));
	}
	
	

}
