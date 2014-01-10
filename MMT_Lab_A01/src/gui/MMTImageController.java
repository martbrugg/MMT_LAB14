package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JFileChooser;

import mmt_image.AveragingFilter;
import mmt_image.ContrastStretching;
import mmt_image.FileImageReader;
import mmt_image.FileImageWriter;
import mmt_image.GammaCorrection;
import mmt_image.GlobalThresholding;
import mmt_image.Histogram;
import mmt_image.HistogramEqualization;
import mmt_image.ImageFiltering;
import mmt_image.ImageProcess;
import mmt_image.IterativeGlobalThresholding;
import mmt_image.LaplacianFilter;
import mmt_image.MMTImage;
import mmt_image.MedianFilter;
import mmt_image.Otsu;
import mmt_image.Sobel;


public class MMTImageController implements ActionListener {
	String outputFileName;
	 MMTImageView myFrame;
	 MMTImageModel model;
	

	/**
	 * @param args
	 */
	public MMTImageController () {
			
			myFrame = new MMTImageView(this);
			model = new MMTImageModel(myFrame);
			
			MMTSliderPanel gammaSlider = new MMTSliderPanel("Gamma", new IFValChanged() {
				
				@Override
				public void setValue(double val) {
					if(model.getSource()!=null){
						model.setTarget(GammaCorrection.process(model.getSource(), val));
					}
				}
			});
			gammaSlider.setMinMax(0, 2);
			gammaSlider.setVal(1);
			
			
			MMTSliderPanel avgSpinner = new MMTSliderPanel("Averaing Filter", new IFValChanged() {
				
				
				@Override
				public void setValue(double val) {
					if(model.getSource()!=null){
						model.setTarget(AveragingFilter.process(model.getSource(), (int) val));
					}
					System.out.println("Spinbox: " + val);
					
				}
			});
			
			avgSpinner.setMinMax(1,25);
			avgSpinner.setTicks(2);
			
			MMTSliderPanel medianSpinner = new MMTSliderPanel("Median Filter", new IFValChanged() {
				
				
				@Override
				public void setValue(double val) {
					if(model.getSource()!=null){
						model.setTarget(MedianFilter.process(model.getSource(), (int) val));
					}
					
					
				}
			});
			
			medianSpinner.setMinMax(1,25);
			medianSpinner.setTicks(2);
			
		
			
			
			MMTButtonPanel contrastStretching = new MMTButtonPanel("Contrast Stretching", new IFValChanged() {
		
				@Override
				public void setValue(double val) {
					System.out.println("Contrast Stretching");
					if(model.getSource()!=null){
						model.setTarget(ContrastStretching.process(model.getSource()));
					}
					System.out.println("Button " + val);
					
				}
			});
			
			MMTButtonPanel histogramEqualization = new MMTButtonPanel("Histogram Equalization", new IFValChanged() {
				
				@Override
				public void setValue(double val) {
					System.out.println("Histogram Equalization");
					if(model.getSource()!=null){
						model.setTarget(HistogramEqualization.process(model.getSource()));
					}
					System.out.println("Button " + val);
					
				}
			});
			
			MMTSliderPanel globalThresholdingSlider = new MMTSliderPanel("Threshold", new IFValChanged() {
				
				@Override
				public void setValue(double val) {
					if(model.getSource()!=null){
						model.setTarget(GlobalThresholding.process(model.getSource(), (int)val));
					}
				}
			});
			globalThresholdingSlider.setMinMax(0, 255);
			globalThresholdingSlider.setVal(128);
			globalThresholdingSlider.setTicks(1);
			globalThresholdingSlider.setPaintTicks(false);
			
			
			MMTButtonPanel iterativeGlobalThresholding = new MMTButtonPanel("Iterative Global Thresholding", new IFValChanged() {
				
				@Override
				public void setValue(double val) {
					System.out.println("Iterative Global Thresholding");
					if(model.getSource()!=null){
						model.setTarget(IterativeGlobalThresholding.process(model.getSource()));
					}
					System.out.println("Button " + val);
					
				}
			});
			
			MMTButtonPanel otsu = new MMTButtonPanel("Otsu", new IFValChanged() {
				
				@Override
				public void setValue(double val) {
					System.out.println("Otsu");
					if(model.getSource()!=null){
						model.setTarget(Otsu.process(model.getSource()));
					}
					System.out.println("Button " + val);
					
				}
			});
			
			MMTButtonPanel unsharpm = new MMTButtonPanel("Unsharp masking", new IFValChanged() {
				
				@Override
				public void setValue(double val) {
					System.out.println("Unsharp masking");
					if(model.getSource()!=null){
						model.setTarget(ImageFiltering.UnsharpMasking(model.getSource()));
					}
					System.out.println("Button " + val);
					
				}
			});
			
			MMTSliderPanel highboost = new MMTSliderPanel("Highboost Filter", new IFValChanged() {
				
				@Override
				public void setValue(double val) {
					if(model.getSource()!=null){
						model.setTarget(ImageFiltering.HighboostFiltering(model.getSource(), val));
					}
				}
			});
			highboost.setMinMax(0, 1);
			highboost.setVal(0);
			
			MMTSliderPanel lap8 = new MMTSliderPanel("Laplacian 8", new IFValChanged() {
				
				@Override
				public void setValue(double val) {
					if(model.getSource()!=null){
						model.setTarget(LaplacianFilter.process(model.getSource(), ImageProcess.FilterType.LAPLACIAN8,  val));
					}
				}
			});
			lap8.setMinMax(0, 1);
			lap8.setVal(0);
			
			MMTSliderPanel lap4 = new MMTSliderPanel("Laplacian 4", new IFValChanged() {
				
				@Override
				public void setValue(double val) {
					if(model.getSource()!=null){
						model.setTarget(LaplacianFilter.process(model.getSource(), ImageProcess.FilterType.LAPLACIAN4,  val));
					}
				}
			});
			lap4.setMinMax(0, 1);
			lap4.setVal(0);
			
			MMTSliderPanel sobel = new MMTSliderPanel("Sobel", new IFValChanged() {
				
				@Override
				public void setValue(double val) {
					if(model.getSource()!=null){
						model.setTarget(Sobel.process(model.getSource(), val));
					}
				}
			});
			sobel.setMinMax(0, 1);
			sobel.setVal(0);
			
			MMTButtonPanel hist = new MMTButtonPanel("Histogramm", new IFValChanged() {
				
				@Override
				public void setValue(double val) {
					if(model.getSource()!=null){
			
						model.setTarget(Histogram.DrawHistogramm(model.getSource()));
					}
					
				}
			});
			
			myFrame.addParameterFieldFilter(avgSpinner);
			myFrame.addParameterFieldFilter(medianSpinner);
			myFrame.addParameterFieldFilter(lap4);
			myFrame.addParameterFieldFilter(lap8);
			myFrame.addParameterFieldFilter(sobel);
			myFrame.addParameterFieldHistogramm(hist);
			myFrame.addParameterFieldEnhancement(contrastStretching);
			myFrame.addParameterFieldEnhancement(gammaSlider);
			myFrame.addParameterFieldEnhancement(histogramEqualization);
			myFrame.addParameterFieldFilter(unsharpm);
			myFrame.addParameterFieldFilter(highboost);
			myFrame.addParameterFieldSegmentation(iterativeGlobalThresholding);
			myFrame.addParameterFieldSegmentation(globalThresholdingSlider);
			myFrame.addParameterFieldSegmentation(otsu);
			
			
			
			myFrame.setVisible(true);
			
			
		}
		
			
	public void setSourceFile(String path){
		System.out.println("Controller setSourceFile");
		System.out.println(FileImageReader.read(path));
		model.setSource(FileImageReader.read(path));
		model.setTarget(FileImageReader.read(path));
		model.history.add(model.getSource());
		
		
		System.out.println("view repaint");
		myFrame.repaint();
	}

	public void saveImage(String path){
		FileImageWriter.write(model.getTarget(), path);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	public void apply(){
		model.history.add(model.getTarget());
		model.setSource(model.getTarget());
	}
	
	public void undo(){
		if (model.history.size()==1){
			model.setSource(model.history.get(model.history.size()-1));
			model.setTarget(model.history.get(model.history.size()-1));
		}
		
		if (model.history.size()>1){
		model.history.remove(model.history.size()-1);
		model.setSource(model.history.get(model.history.size()-1));
		model.setTarget(model.history.get(model.history.size()-1));
		}
		
	}
	
	}

	
	
	


