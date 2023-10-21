import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import Storage.ImageStorage;

public class MyFrame extends JFrame{
    JCheckBox bitBox0;
    JCheckBox bitBox1;
    JCheckBox bitBox2;
    JCheckBox bitBox3;
    JCheckBox bitBox4;
    JCheckBox bitBox5;
    JCheckBox bitBox6;
    JCheckBox bitBox7;
    JRadioButton nearestButton;
    JRadioButton linearButton;
    JRadioButton bilinerButton;
    ButtonGroup group;
    JButton loadBt;
    JButton upButton;
    JButton subButton;
    JButton transButton;
    JLabel label1;
    JLabel picLabel;
    JLabel labeltxtHighBoosting;
    JButton grayScaleButton;
    JButton histogramButton;
    JButton histogramButton2;
    JButton highBoostButton;
    JButton sharpenButton;
    JButton smoothButton;
    JButton medianButton;
    JMenu spatialMenu;
    JMenuItem m1;
    JMenuItem m2;
    JMenuItem m3;
    JMenuItem m4;
    JMenuItem m5;
    JTextField grayScaleTXT;
    JTextField HistrogramTxt;
    JTextField highBoostingTxt;
    JTextField highBoostingTxt2;
    JTextField medianFilterTxt;
    JTextField sharpenFilterTxt;
    JTextField smoothFilterTxt;

    ImageStorage imageStorage;
    
   
    //constructor
    MyFrame(){
        Action act = new Action();
        setTitle("Image Processing Tool");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        JTabbedPane tabs = new JTabbedPane();
        
        label1 = new JLabel();
        picLabel = new JLabel();
        JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER,0,50));
        JPanel panel2 = new JPanel(null);
        JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.CENTER,0,60));
        JPanel panel4 = new JPanel(new FlowLayout(FlowLayout.CENTER,0,50));
        JPanel panel5 = new JPanel();
        JPanel highBoostingPanel = new JPanel();
        JPanel medianPanel = new JPanel();
        JPanel smoothingPanel = new JPanel();
        JPanel sharpenPanel = new JPanel();


        JTabbedPane tabsFilter = new JTabbedPane();
        tabsFilter.add("Smoothing Fliter",smoothingPanel);
        tabsFilter.add("Median Fiter", medianPanel);
        tabsFilter.add("Sharpening Laplacin Fiter", sharpenPanel);
        tabsFilter.add("High Boosting Fiter", highBoostingPanel);
        

        JLabel labeltxtInput = new JLabel("Input: ");
        JLabel labeltxtOriginal = new JLabel("Original Image");
        JLabel labeltxtProcessed = new JLabel("Processed Image");
        JLabel labeltextMaskSize1 = new JLabel("Local Histogram Equalization Mask Size:");
        JLabel labeltxtHighBoosting = new JLabel("input: ");
        JLabel labeltxtHighBoosting2 = new JLabel("A value: ");
        // labeltxt.setBounds(20,80,100,50);
        labeltxtOriginal.setBounds(60, 155, 100, 80);
        labeltxtProcessed.setBounds(600, 155, 140, 80);
        panel1.setBackground(Color.LIGHT_GRAY);
        panel2.setBackground(Color.LIGHT_GRAY);
        panel3.setBackground(Color.LIGHT_GRAY);
        panel4.setBackground(Color.LIGHT_GRAY);
        panel5.setBackground(Color.LIGHT_GRAY);
        
        tabs.setBounds(200, 0, 1000, 200);
        tabs.add("Grayscale Resolution",panel1);
        tabs.add("Spatial Resolution",panel2);
        tabs.add("Bit Plane ",panel3);
        tabs.add("Histogram Equalization",panel4);
        tabs.add("Filters",tabsFilter);

        bitBox0 = new JCheckBox("0 bit");
        bitBox1 = new JCheckBox("1 bit");
        bitBox2 = new JCheckBox("2 bit");
        bitBox3 = new JCheckBox("3 bit");
        bitBox4 = new JCheckBox("4 bit");
        bitBox5 = new JCheckBox("5 bit");
        bitBox6 = new JCheckBox("6 bit");
        bitBox7 = new JCheckBox("7 bit");

        group = new ButtonGroup();
        highBoostButton = new JButton("High Boosting Filter");
        sharpenButton = new JButton("Sharpen Filter");
        smoothButton = new JButton("Smooth Filter");
        medianButton = new JButton("Median Filter");
        upButton = new JButton("Upsampling");
        subButton = new JButton("Subsampling");
        nearestButton = new JRadioButton("Nearest");
        nearestButton.setSelected(true);
        linearButton = new JRadioButton("Linear ");
        bilinerButton = new JRadioButton("Bilinear");
        loadBt = new JButton("Load Image");
        loadBt.addActionListener(act);
        loadBt.setBounds(10,80,100,40);
        transButton = new JButton("Transform");
        transButton.setBounds(10, 120, 100, 40);
        histogramButton = new JButton(" Local Histogram Equalization");
        histogramButton.setPreferredSize(new Dimension(300, 50));
        histogramButton2 = new JButton("Global Histogram Equalization");
        histogramButton2.setPreferredSize(new Dimension(300, 50));
        grayScaleTXT = new JTextField("8");
        grayScaleTXT.setPreferredSize(new Dimension(100, 50));
        HistrogramTxt = new JTextField("3");
        HistrogramTxt.setPreferredSize(new Dimension(100, 50));
        highBoostingTxt = new JTextField(2);
        highBoostingTxt.setPreferredSize(new Dimension(100, 40));
        highBoostingTxt2 = new JTextField(2);
        highBoostingTxt2.setPreferredSize(new Dimension(100, 40));
        medianFilterTxt = new JTextField(2);
        medianFilterTxt.setPreferredSize(new Dimension(100, 40));
        sharpenFilterTxt = new JTextField(2);
        sharpenFilterTxt.setPreferredSize(new Dimension(100, 40));
        smoothFilterTxt = new JTextField(2);
        smoothFilterTxt.setPreferredSize(new Dimension(100, 40));
        





        //grayScaleTXT.setBounds(100, 80, 100, 50);
        grayScaleButton = new JButton("Gray Scale Resolution");
        //grayScaleButton.setBounds(210,80,150,50);
        grayScaleButton.addActionListener(act);
        JMenuBar menuBar = new JMenuBar();
        spatialMenu = new JMenu("Spatial Reselution");
        // spatialMenu.addMenuListener(menuAction);
        m1 = new JMenuItem("32x32");
        m1.addActionListener(act);
        m2 = new JMenuItem("64x64");
        m3 = new JMenuItem("128x128");
        m4 = new JMenuItem("256x256");
        m5 = new JMenuItem("512x512");
        m2.addActionListener(act);
        m3.addActionListener(act);
        m4.addActionListener(act);
        m5.addActionListener(act);
        nearestButton.addActionListener(act);
        linearButton.addActionListener(act);
        bilinerButton.addActionListener(act);
        upButton.setBounds(80, 80, 100, 50);
        subButton.setBounds(180, 80, 100, 50);
        menuBar.setBounds(380, 80, 150, 50);
        nearestButton.setBounds(580, 100, 100, 50);
        linearButton.setBounds(660, 100, 100, 50);
        bilinerButton.setBounds(730, 100, 100, 50);
        
        // FlowLayout flow = new FlowLayout();
        // setLayout(flow);

        group.add(nearestButton);
        group.add(linearButton);
        group.add(bilinerButton);
        spatialMenu.add(m1);
        spatialMenu.add(m2);
        spatialMenu.add(m3);
        spatialMenu.add(m4);
        spatialMenu.add(m5);
        menuBar.add(spatialMenu);
        add(loadBt);
        add(transButton);
        add(upButton);
        add(subButton);
        add(labeltxtOriginal);
        add(labeltxtProcessed);

        panel1.add(labeltxtInput);
        panel1.add(grayScaleTXT);
        panel1.add(grayScaleButton);
        panel2.add(upButton);
        panel2.add(subButton);
        panel2.add(menuBar);
        panel2.add(nearestButton);
        panel2.add(linearButton);
        panel2.add(bilinerButton);
        panel3.add(bitBox0);
        panel3.add(bitBox1);
        panel3.add(bitBox2);
        panel3.add(bitBox3);
        panel3.add(bitBox4);
        panel3.add(bitBox5);
        panel3.add(bitBox6);
        panel3.add(bitBox7);
        panel4.add(labeltextMaskSize1);
        panel4.add(HistrogramTxt);
        panel4.add(histogramButton);
        panel4.add(histogramButton2);
        highBoostingPanel.add(labeltxtHighBoosting);
        highBoostingPanel.add(highBoostingTxt);
        highBoostingPanel.add(labeltxtHighBoosting2);
        highBoostingPanel.add(highBoostingTxt2);
        highBoostingPanel.add(highBoostButton);
        sharpenPanel.add(sharpenFilterTxt);
        sharpenPanel.add(sharpenButton);
        medianPanel.add(medianFilterTxt);
        medianPanel.add(medianButton);
        smoothingPanel.add(smoothFilterTxt);
        smoothingPanel.add(smoothButton);

        // panel5.add(tabsFilter);
        
        

        // add(panel1);
        add(picLabel);
        add(label1);
        // add(panel2);
        add(tabs);
        
        
        nearestButton.setVisible(true);
        linearButton.setVisible(true);
        bilinerButton.setVisible(true);
        setVisible(true);

       

    }

    public class Action extends Component implements ActionListener{   
        int imageHeight = 220;
        @Override
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == loadBt){
                imageStorage = new ImageStorage(new File("src/Lena.png"));
                BufferedImage bi =imageStorage.getBufferedImage();
                picLabel.setIcon(new ImageIcon(bi));
                picLabel.setBounds(50,imageHeight,bi.getWidth(),bi.getHeight());
                //m4.setText(imageStorage.getBufferedImage().getWidth()+"x"+imageStorage.getBufferedImage().getWidth());
                System.out.println("action");
            }
            else if(e.getSource() == grayScaleButton){
                imageStorage.grayScaleResolution(Integer.valueOf(grayScaleTXT.getText()));
                BufferedImage bi = imageStorage.getImagefromProcessedArray();
                label1.setIcon(new ImageIcon(bi));
                label1.setBounds(600, imageHeight, bi.getWidth(), bi.getHeight());
                System.out.println("gray");
            }
            else if(e.getSource() == m1)
            {
                imageStorage.subSample(4);
                BufferedImage bi = imageStorage.getImagefromProcessedArray();
                label1.setIcon(new ImageIcon(bi));
                label1.setBounds(600, imageHeight, bi.getWidth(), bi.getHeight());
                System.out.println(bi.getWidth());
            }
            else if(e.getSource() == m2){
                imageStorage.subSample(3);
                BufferedImage bi = imageStorage.getImagefromProcessedArray();
                label1.setIcon(new ImageIcon(bi));
                label1.setBounds(600, imageHeight, bi.getWidth(), bi.getHeight());
                 System.out.println(bi.getWidth());
            }
            else if(e.getSource() == m3){
                imageStorage.subSample(2);
                BufferedImage bi = imageStorage.getImagefromProcessedArray();
                label1.setIcon(new ImageIcon(bi));
                label1.setBounds(600, imageHeight, bi.getWidth(), bi.getHeight());
                 System.out.println(bi.getWidth());
            }

            else if(e.getSource() == m4){
                imageStorage.subSample(1);
                BufferedImage bi = imageStorage.getImagefromProcessedArray();
                label1.setIcon(new ImageIcon(bi));
                label1.setBounds(600, imageHeight, bi.getWidth(), bi.getHeight());
                 System.out.println(bi.getWidth());
            }
            else if(e.getSource() == m5){
                
                BufferedImage bi = imageStorage.getBufferedImage();
                label1.setIcon(new ImageIcon(bi));
                label1.setBounds(600, imageHeight, bi.getWidth(), bi.getHeight());
                 System.out.println(bi.getWidth());
            }

            
        }
    }

    



    public static void main(String[] args) {
        MyFrame frame = new MyFrame();
        
    }

    
}
