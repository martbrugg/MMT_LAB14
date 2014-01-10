package gui;

import gui.MMTSliderPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.ScrollPaneLayout;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import javax.swing.plaf.TabbedPaneUI;

import mmt_image.FileImageWriter;
import mmt_image.MMTImage;







/**
 * Class MainFrame creates a dialog to show a Picture
 * @author Martin
 *
 */

public class MMTImageView 	extends JFrame 
						implements ActionListener, MouseListener{
	// Variables declaration - do not modify
	ImageIcon sourceIcon;
	ImageIcon sourceHist;
	ImageIcon targetIcon;
	ImageIcon targetHist;
	
    private JLabel jLabel1;
    private JLabel jLabelHist1;
    private JLabel jLabel2;
    private JLabel jLabelHist2;
    private JMenu jMenu1;
    private JMenu jMenu2;
    private JMenuBar jMenuBar1;
    private JMenuItem jMenuItem1;
    private JMenuItem jMenuItem2;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JPanel jPanelRight;
    private JPanel jHistPane1;
    private JPanel jHistPane2;
    private JPanel jPaneFilter;
    private JPanel jPaneEnhancement;
    private JPanel jPaneSegmentation;
    private JPanel jPaneHistogram;
    private JButton confButton;
    private JButton undoButton;

    private BufferedImage img1;
    private JComboBox<String> jComboBox;
    private JTabbedPane jTab;
    
    // End of variables declaration
	
	MMTImageController controller;
	
	public void setsourceIcon(BufferedImage img) {
		System.out.println("View setSourceIcon");
		sourceIcon = new ImageIcon(img);
		jLabel1.setIcon(sourceIcon);
		jLabel1.setText("");	
	}
	
	public void setsourceHist(BufferedImage img) {
		System.out.println("View setSourceIcon");
		sourceHist = new ImageIcon(img);
		jLabelHist1.setIcon(sourceHist);
		jLabelHist1.setText("");
		
		
	}
	
	public void settargetIcon(BufferedImage img) {
		System.out.println("View setTargetIcon");
		targetIcon = new ImageIcon(img);
		jLabel2.setIcon(targetIcon);
		
	}
	
	public void settargetHist(BufferedImage img) {
		
		targetHist = new ImageIcon(img);
		jLabelHist2.setIcon(targetHist);
		jLabelHist2.setText("");
		
		
	}

	private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jLabel1 = new javax.swing.JLabel();
        jLabelHist1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jLabel2 = new javax.swing.JLabel();
        jLabelHist2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanelRight = new JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jPaneFilter = new JPanel();
        jPaneEnhancement = new JPanel();
        jPaneSegmentation = new JPanel();
        jPaneHistogram = new JPanel();
        jHistPane1 = new JPanel();
        jHistPane2 = new JPanel();
        confButton = new JButton("Apply");
        confButton.addMouseListener(this);
        confButton.setActionCommand("apply");
        
        undoButton = new JButton("Undo");
        undoButton.addMouseListener(this);
        undoButton.setActionCommand("undo");
        jTab = new JTabbedPane(JTabbedPane.VERTICAL);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        
        jScrollPane1.setViewportView(jHistPane1);
        jScrollPane2.setViewportView(jHistPane2);
        jPanelRight.add(jScrollPane3);
        jScrollPane3.setViewportView(jTab);
        jPanelRight.add(confButton);
        jPanelRight.add(undoButton);
        
        
        jHistPane1.setLayout(new BoxLayout(jHistPane1, BoxLayout.PAGE_AXIS));
        jHistPane2.setLayout(new BoxLayout(jHistPane2, BoxLayout.PAGE_AXIS));
        jHistPane1.add(jLabel1);
        jHistPane1.add(jLabelHist1);
        
        jHistPane2.add(jLabel2);
        jHistPane2.add(jLabelHist2);
        
        jMenu1.setText("File");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Open");
        jMenuItem1.addActionListener(this);
        jMenuItem1.setActionCommand("openFile");
        jMenu1.add(jMenuItem1);
        
        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Save");
        jMenuItem2.addActionListener(this);
        jMenuItem2.setActionCommand("saveFile");
        jMenu1.add(jMenuItem2);
        
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);
       

        setJMenuBar(jMenuBar1);
        
        //this.setSize(800, 250);
        
        this.add(jScrollPane1);
        this.add(jScrollPane2);
        this.add(jPanelRight);
        
        
        jLabel1.setIcon(sourceIcon);
        jLabel1.setText("Open File");
        jLabel2.setIcon(targetIcon);
    
        jComboBox = new JComboBox<>();
        
        //jPaneFilter.add(jComboBox);
       
        jTab.addTab("Enhancement",jPaneEnhancement);
        jTab.addTab("Filter", jPaneFilter);
        jTab.addTab("Segmentation",jPaneSegmentation);
        jTab.addTab("Histogramm", jPaneHistogram);
        
        
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
        		layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(jScrollPane1,GroupLayout.DEFAULT_SIZE,550,Short.MAX_VALUE)
        			.addComponent(jScrollPane2,GroupLayout.DEFAULT_SIZE,550,Short.MAX_VALUE)
        			.addComponent(jPanelRight,GroupLayout.PREFERRED_SIZE,320,GroupLayout.PREFERRED_SIZE)
        			));
        
        layout.setVerticalGroup(
        		layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        		.addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup())
        			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
        			.addComponent(jScrollPane1,GroupLayout.Alignment.LEADING,GroupLayout.DEFAULT_SIZE,800,Short.MAX_VALUE)
        			.addComponent(jScrollPane2,GroupLayout.Alignment.CENTER)
        			.addComponent(jPanelRight
        					,GroupLayout.Alignment.LEADING)
        			));
       
        jPaneFilter.setLayout(new BoxLayout(jPaneFilter,BoxLayout.PAGE_AXIS));
        jPaneEnhancement.setLayout(new BoxLayout(jPaneEnhancement,BoxLayout.PAGE_AXIS));
        jPaneSegmentation.setLayout(new BoxLayout(jPaneSegmentation,BoxLayout.PAGE_AXIS));
        //paralayout.addLayoutComponent("Combo", jComboBox);
        
        pack();
        
        
 
    }

	public void addParameterFieldFilter(Component parafield){
		
		System.out.println("Add Parafield");
		jPaneFilter.add(parafield);
		
		
	}
	
	public void addParameterFieldEnhancement(Component parafield){
		
		System.out.println("Add Parafield");
		jPaneEnhancement.add(parafield);
		
	}
	
	public void addParameterFieldSegmentation(Component parafield){
		
		System.out.println("Add Parafield");
		jPaneSegmentation.add(parafield);
		
	}
	
public void addParameterFieldHistogramm(Component parafield){
		
		System.out.println("Add Parafield");
		jPaneHistogram.add(parafield);
		
	}



	MMTImageView() throws HeadlessException {
		// TODO Auto-generated constructor stub
	}

	MMTImageView(String title) throws HeadlessException {
		super(title);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Creating a new dialog to display an image
	 * @param title Title of dialog
	 * @param img Buffered image to show
	 * @throws HeadlessException
	 */
	public MMTImageView(MMTImageController controller) throws HeadlessException {
		
		this.controller=controller;
		this.initComponents();
		//Main Panel configuration
		
		
		
		
		
		
		
	}
	
	
	
	public void actionPerformed(ActionEvent e){
		
		System.out.println("Hallo");
		
		if(e.getActionCommand()=="openFile"){
			controller.setSourceFile(openImage());
		}
		
		if(e.getActionCommand()=="saveFile"){
			System.out.println("Save File");
			controller.saveImage(saveImage());
		}
		
	}
	
	
	
	public void addParameter(String title, gui.IFValChanged callback){
		MMTSliderPanel para = new MMTSliderPanel(title, callback);
		this.add(para);
			
		}
	
	public void redraw(BufferedImage img){
		//icon2.setImage(img);
		//image2.setIcon(icon2);
	
	}

	MMTImageView(String title, GraphicsConfiguration gc) {
		super(title, gc);
		// TODO Auto-generated constructor stub
	}

	public String openImage(){
		final JFileChooser chooser = new JFileChooser("Select file");
		chooser.setDialogType(JFileChooser.OPEN_DIALOG);
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		chooser.setCurrentDirectory(new File("/Users/Martin/FH/SS2013/Multimedia_Technologien/LB/Test_Images"));
		
		chooser.addPropertyChangeListener(new PropertyChangeListener() { 
            public void propertyChange(PropertyChangeEvent e) { 
                if (e.getPropertyName().equals(JFileChooser.SELECTED_FILE_CHANGED_PROPERTY) 
                        || e.getPropertyName().equals(JFileChooser.DIRECTORY_CHANGED_PROPERTY)) { 
                    final File f = (File) e.getNewValue(); 
                } 
            }

			
        }); 

        chooser.setVisible(true); 
        final int result = chooser.showOpenDialog(null); 
        String inputVerzStr = null;
        if (result == JFileChooser.APPROVE_OPTION) { 
            File inputVerzFile = chooser.getSelectedFile(); 
            inputVerzStr = inputVerzFile.getPath(); 
            System.out.println("Eingabepfad:" + inputVerzStr); 
            
        } 
        System.out.println("Abbruch"); 
        chooser.setVisible(false); 
        return inputVerzStr;
	}
        
        
	public String saveImage(){
    		final JFileChooser chooser = new JFileChooser("Save file");
    		chooser.setDialogType(JFileChooser.SAVE_DIALOG);
    		chooser.setFileSelectionMode(JFileChooser.SAVE_DIALOG);
    		chooser.setCurrentDirectory(new File("/Users/Martin/FH/SS2013/Multimedia_Technologien/LB/Test_Images"));
    		
    		chooser.addPropertyChangeListener(new PropertyChangeListener() { 
                public void propertyChange(PropertyChangeEvent e) { 
                    if (e.getPropertyName().equals(JFileChooser.SELECTED_FILE_CHANGED_PROPERTY) 
                            || e.getPropertyName().equals(JFileChooser.DIRECTORY_CHANGED_PROPERTY)) { 
                        final File f = (File) e.getNewValue(); 
                    } 
                }

    			
            }); 

            chooser.setVisible(true); 
            final int result = chooser.showSaveDialog(null); 
            String inputVerzStr = null;
            if (result == JFileChooser.APPROVE_OPTION) { 
                File inputVerzFile = chooser.getSelectedFile(); 
                inputVerzStr = inputVerzFile.getPath(); 
                System.out.println("Speicherpfad:" + inputVerzStr); 
                
            } 
        System.out.println("Abbruch"); 
        chooser.setVisible(false); 
        return inputVerzStr;
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
		if(e.getComponent()==confButton){
			controller.apply();
			System.out.println("Apply");
		}
		if(e.getComponent()==undoButton){
			controller.undo();
			System.out.println("Undo");
		}
		
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

	


