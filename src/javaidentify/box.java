package javaidentify;

import static marvin.MarvinPluginCollection.crop;
import static marvin.MarvinPluginCollection.findTextRegions;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;
import java.util.List;

import marvin.gui.MarvinImagePanel; 
import marvin.image.MarvinImage;
import marvin.image.MarvinSegment;
import marvin.io.MarvinImageIO;


import javax.swing.JButton; 
import javax.swing.JFrame; 
import javax.swing.JPanel; 

public class box extends JFrame implements ActionListener

{ 
    private JPanel		panelBottom; 
    
    private MarvinImagePanel	imagePanel; 
    private MarvinImage		image,  
    				backupImage;
     
     
    private JButton             buttonGray,  
                                buttonEdgeDetector,  
                                buttonInvert,  
                                buttonReset; 
     
    public box() 
    { 
        super("Extract Passport Picture");
         
        // Create Graphical Interface 
        buttonGray = new JButton("Gray");
        buttonGray.addActionListener(this); 
        buttonEdgeDetector = new JButton("EdgeDetector");
        buttonEdgeDetector.addActionListener(this); 
        buttonInvert = new JButton("Invert");
        buttonInvert.addActionListener(this); 
        buttonReset = new JButton("Reset");
        buttonReset.addActionListener(this); 
         
        panelBottom = new JPanel(); 
        panelBottom.add(buttonGray); 
        panelBottom.add(buttonEdgeDetector); 
        panelBottom.add(buttonInvert); 
        panelBottom.add(buttonReset); 
        
        // ImagePanel 
        imagePanel = new MarvinImagePanel();
         
        Container l_c = getContentPane(); 
        l_c.setLayout(new BorderLayout()); 
        l_c.add(panelBottom, BorderLayout.SOUTH); 
        l_c.add(imagePanel, BorderLayout.NORTH);
        
     // Load image
    	image = MarvinImageIO.loadImage("./res/alan-keane.jpg");
    	  crop(image.clone(), image, 130, 500, 1000, 1000);
          
          

          MarvinImageIO.saveImage(image, "/Users/shannonhealy/Documents//alan-keane-2.png");
            imagePanel.setImage(image);
            
            setSize(340,430);
            setVisible(true);
            
          
            
            
            //MarvinImageIO.saveImage(image, "/Users/shannonhealy/Documents/passport_2.png");
    }
         
            
    
    
    
     
    public static void main(String args[]){
        box t = new box(); 
        t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    } 
     
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == buttonGray){ 
        } 
        else if(e.getSource() == buttonEdgeDetector){
        } 
        else if(e.getSource() == buttonInvert){
        } 
    } 
}