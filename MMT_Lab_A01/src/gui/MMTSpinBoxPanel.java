package gui;

import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import gui.IFValChanged;

public class MMTSpinBoxPanel extends JPanel 
						 implements PropertyChangeListener,
						 			ChangeListener,
						 			ActionListener{
	
	JFormattedTextField textField;
	JSpinner spinner;
	String title;
	IFValChanged callback;
	int value;
	public MMTSpinBoxPanel() {
		
		// TODO Auto-generated constructor stub
	}

	
	
	public MMTSpinBoxPanel(String myTitle ,final IFValChanged callback) {
		this.callback=callback;
		setBorder(BorderFactory.createCompoundBorder(	
												BorderFactory.createTitledBorder(myTitle), 
												BorderFactory.createEmptyBorder()));
		
		
		title = myTitle;
		textField = new JFormattedTextField();
		textField.setColumns(5);
		spinner = new JSpinner(
				new SpinnerNumberModel(3, 3, 21, 21)
				);
			
		
		textField.setText("1");
		textField.setEditable(false);
		//textField.setValue(new Double(0));
		//textField.addPropertyChangeListener(this);
		
		
		spinner.addChangeListener(this);

		this.add(textField);
		this.add(spinner);
		this.setName(title);
		
		
		
		
		
		
	}
	
	
	
	
	public void setVal(double val){
		value = (int) val;
		spinner.setValue((int) (value));
		
	}
	public MMTSpinBoxPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public MMTSpinBoxPanel(LayoutManager layout, boolean isDoubleBuffered) {
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
		
			value = (int) spinner.getModel().getValue();
			System.out.println(value);
			textField.setText(Double.toString(value));
			callback.setValue(value);
		
		
	}



	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		System.out.println("PropertyChanged"+ textField.getText() );
		value = (int) Double.parseDouble(textField.getText());
		spinner.setValue((int) value);
		
		

		
	}

}
