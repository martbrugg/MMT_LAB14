package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import gui.IFValChanged;

public class MMTButtonPanel extends JPanel 
						 implements MouseListener{
	
	JFormattedTextField textField;
	JButton button;
	String title;
	IFValChanged callback;
	int value;
	public MMTButtonPanel() {
		
		// TODO Auto-generated constructor stub
	}

	
	
	public MMTButtonPanel(String myTitle ,final IFValChanged callback) {
		this.callback=callback;
		setBorder(BorderFactory.createCompoundBorder(	
												BorderFactory.createTitledBorder(myTitle), 
												BorderFactory.createEmptyBorder()));
		
		
		title = myTitle;
		button = new JButton("Run");
		button.addMouseListener(this);
		this.add(button);
		this.setName(title);
		
		
		
		
			
	}
	
	public MMTButtonPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public MMTButtonPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}



	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseReleased(MouseEvent e) {
		//System.out.println("Mouse Released: "+ textField.getText() );
		callback.setValue(0);
		
	}



	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
