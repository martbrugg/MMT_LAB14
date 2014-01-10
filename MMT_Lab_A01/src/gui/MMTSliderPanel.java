package gui;

import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.BorderFactory;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import gui.IFValChanged;

public class MMTSliderPanel extends JPanel 
						 implements PropertyChangeListener,
						 			ChangeListener,
						 			ActionListener{
	
	JFormattedTextField textField;
	JSlider slider;
	String title;
	IFValChanged callback;
	double value;
	public MMTSliderPanel() {
		
		// TODO Auto-generated constructor stub
	}

	
	
	public MMTSliderPanel(String myTitle ,final IFValChanged callback) {
		this.callback=callback;
		setBorder(BorderFactory.createCompoundBorder(	
												BorderFactory.createTitledBorder(myTitle), 
												BorderFactory.createEmptyBorder()));
		
		
		
		
		title = myTitle;
		textField = new JFormattedTextField();
		textField.setColumns(5);
		slider = new JSlider();
		textField.setText("1");
		textField.setEditable(false);
		//textField.setValue(new Double(0));
		textField.addPropertyChangeListener(this);
		
		
		slider.addChangeListener(this);
		slider.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				System.out.println("Mouse released");
				value = slider.getValue()/100.0;
				textField.setText(Double.toString(value));
				callback.setValue(value);
			}
		});

		this.add(textField);
		this.add(slider);
		this.setName(title);
		
		
		
		
	}
	
	
	public void setMinMax(double min, double max){
		slider.setMinimum((int) (min*100));
		slider.setMaximum((int) (max*100));
		
	}
	
	public void setTicks(int n){
		slider.setMajorTickSpacing(n*100);
		slider.setSnapToTicks(true);
		slider.setPaintTicks(true);
		
	}
	
	public void setPaintTicks(boolean b){
		slider.setPaintTicks(b);
	}
	
	public void setVal(double val){
		value = val;
		slider.setValue((int) (100*value));
		
	}
	public MMTSliderPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public MMTSliderPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("actionPerformed");
		
	}



	@Override
	public void stateChanged(ChangeEvent e) {
		System.out.println("StateChanged");
		value = slider.getValue()/100.0;
		textField.setText(Double.toString(value));
		
			
		
		
	}



	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		System.out.println("PropertyChanged"+ textField.getText() );
		value = Double.parseDouble(textField.getText());
		slider.setValue((int) value*100);
		
		

		
	}

}
