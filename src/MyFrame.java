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
import java.util.HashSet;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import Algo.Alphatrimmed;
import Algo.Arithmetic;
import Algo.Box;
import Algo.Contraharmonic;
import Algo.GeoMean;
import Algo.Harmonic;
import Algo.Laplacin;
import Algo.Max;
import Algo.Median;
import Algo.Midpoint;
import Algo.Min;
import Algo.Sobel;
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
    ButtonGroup groupSampling;
    JButton loadBt;
    JRadioButton upButton;
    JRadioButton subButton;
    JButton transButton;
    JLabel label1;
    JLabel picLabel;
    JLabel labeltxtHighBoosting;
    JLabel labeltxtAlphatrimmed;
    JLabel labeltxtAlphatrimmedValue;
    JLabel labeltxtContraharmonicMaskSize;
    JLabel labeltxtContraharmonicQValue;
    JLabel labeltxtModifiedMaskSize;
    JLabel labeltxtModifiedEquation;
    JLabel labeltxtHybridEquation;
    JLabel labeltxtHuffman;
    JLabel labeltxtRLCgrayscale;
    JLabel labeltxtRLCbitchange;
   
    





    JButton HuffmanCompressionButton;
    JButton RLCbitchangeButton;
    JButton RLCgrayscaleButton;
    JButton ModifiedButton;
    JButton HybridButton;
    JButton SobelButton;
    JButton AlphatrimmedButton;
    JButton ContraharmonicButton;
    JButton HarmonicButton;
    JButton ArithmeticButton;
    JButton grayScaleButton;
    JButton histogramButton;
    JButton histogramButton2;
    JButton highBoostButton;
    JButton sharpenButton;
    JButton smoothButton;
    JButton medianButton;
    JButton bitButton;
    JButton geoButton;
    JButton maxButton;
    JButton minButton;
    JButton midpointButton;
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
    JTextField geoFilterTxt;
    JTextField maxFilterTxt;
    JTextField minFilterTxt;
    JTextField midPointFilterTxt;
    JTextField ArithmeticTxt;
    JTextField HarmonicTxt;
    JTextField ContraharmonicTxt;
    JTextField ContraharmonicQValueTxt;
    JTextField AlphatrimmedTxt;
    JTextField AlphatrimmedMaskTxt;
    JTextField ModifiedFilterMaskTxt;





    

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
        JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER,0,50));
        JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.CENTER,0,60));
        JPanel panel4 = new JPanel(new FlowLayout(FlowLayout.CENTER,0,50));
        JPanel panel5 = new JPanel();
        JPanel highBoostingPanel = new JPanel();
        JPanel medianPanel = new JPanel();
        JPanel smoothingPanel = new JPanel();
        JPanel sharpenPanel = new JPanel();
        JPanel ArithmeticMeanPanel = new JPanel();
        JPanel GeometricMeanPanel = new JPanel();
        JPanel HarmonicMeanPanel = new JPanel();
        JPanel ContraharmonicMeanPanel = new JPanel();
        JPanel MaxPanel = new JPanel();
        JPanel MinPanel = new JPanel();
        JPanel MidpointPanel = new JPanel();
        JPanel AlphatrimmedMeanPanel = new JPanel();
        JPanel SobelPane = new JPanel();
        JPanel HybridFilterPane = new JPanel();
        JPanel ModifiedFilterPane = new JPanel();
        JPanel RLCgrayscalePane = new JPanel();
        JPanel RLCbitchangePane = new JPanel();
        JPanel HuffmanCompressionPane = new JPanel();

        JTabbedPane tabsCompression = new JTabbedPane();
        JTabbedPane tabsHybridFilter = new JTabbedPane();
        JTabbedPane tabsFilter = new JTabbedPane();
        JTabbedPane tabsFilter2 = new JTabbedPane();
        tabsFilter.add("Smoothing Fliter",smoothingPanel);
        tabsFilter.add("Median Fiter", medianPanel);
        tabsFilter.add("Sharpening Laplacin Fiter", sharpenPanel);
        tabsFilter.add("High Boosting Fiter", highBoostingPanel);
        tabsFilter2.add("Geometric Mean",GeometricMeanPanel);
        tabsFilter2.add("Arithmetic Mean", ArithmeticMeanPanel);
        tabsFilter2.add("Harmonic Mean",HarmonicMeanPanel);
        tabsFilter2.add("Contraharmonic Mean",ContraharmonicMeanPanel);
        tabsFilter2.add("Max",MaxPanel);
        tabsFilter2.add("Min",MinPanel);
        tabsFilter2.add("Midpoint",MidpointPanel);
        tabsFilter2.add("Alpha-trimmed Mean",AlphatrimmedMeanPanel);
        tabsFilter2.add("Sobel",SobelPane);
        tabsHybridFilter.add("Hybrid Filter",HybridFilterPane);
        tabsHybridFilter.add("Modified Filter",ModifiedFilterPane);
        tabsCompression.add("Huffman Compression",HuffmanCompressionPane);
        tabsCompression.add("Run Length Code Grayscale",RLCgrayscalePane);
        tabsCompression.add("Run Length Code Bit Plane",RLCbitchangePane);

    //    JLabel labetxtHuffmanRuntime = new JLabel("Huffman Compression Runtime: ");
    //    JLabel labeltxtRLCgrayscaleRuntime = new JLabel("RLC grayscale Runtime: ");
    //    JLabel labeltxtRLCbitchangeRuntime = new JLabel("RLC bit plane Runtime: ");
        labeltxtHuffman = new JLabel("Huffman Compression Ratio: ");
        labeltxtRLCgrayscale = new JLabel("RLC grayscale Compression Ratio: ");
        labeltxtRLCbitchange = new JLabel("RLC bit plane Compression Ratio: ");
        JLabel labeltxtHybridEquation = new JLabel("Arithmetic Mean + Sobel");
        JLabel labeltxtModifiedEquation = new JLabel("Arithmetic Mean + Sharpening(Laplacin):  ");
        JLabel labeltxtModifiedMaskSize = new JLabel("Mask Size");
        JLabel labeltxtContraharmonicQValue = new JLabel("Q value");
        JLabel labeltxtContraharmonicMaskSize = new JLabel("Mask size:");
        JLabel labeltxtAlphatrimmedValue = new JLabel("Alphatrimmed Value:");
        JLabel labeltxtAlphatrimmed = new JLabel("Mask size:");
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
        tabs.add("Spatial Filters",tabsFilter);
        tabs.add("Image Restoration Filters",tabsFilter2);
        tabs.add("Presentation Filter",tabsHybridFilter);
        tabs.add("Compression Algo",tabsCompression);

        bitBox0 = new JCheckBox("0 bit");
        bitBox1 = new JCheckBox("1 bit");
        bitBox2 = new JCheckBox("2 bit");
        bitBox3 = new JCheckBox("3 bit");
        bitBox4 = new JCheckBox("4 bit");
        bitBox5 = new JCheckBox("5 bit");
        bitBox6 = new JCheckBox("6 bit");
        bitBox7 = new JCheckBox("7 bit");
        bitButton = new JButton("Bit change");
        bitButton.addActionListener(act);

        group = new ButtonGroup();
        groupSampling = new ButtonGroup();


        HuffmanCompressionButton = new JButton("Huffman Compression");
        HuffmanCompressionButton.addActionListener(act);
        RLCgrayscaleButton = new JButton("RLC graysale Compression");
        RLCgrayscaleButton.addActionListener(act);
        RLCbitchangeButton = new JButton("RLC bit plane Compression");
        RLCbitchangeButton.addActionListener(act);
        ModifiedButton = new JButton("Modified Filter");
        ModifiedButton.addActionListener(act);
        HybridButton = new JButton("Hybrid Filter");
        HybridButton.addActionListener(act);
        SobelButton = new JButton("Sobel Filter");
        SobelButton.addActionListener(act);
        AlphatrimmedButton = new JButton("Alphatrimmed Filter");
        AlphatrimmedButton.addActionListener(act);
        ContraharmonicButton = new JButton("Contraharmonic Filter");
        ContraharmonicButton.addActionListener(act);
        ArithmeticButton = new JButton("Arithmetic Filter");
        ArithmeticButton.addActionListener(act);
        HarmonicButton = new JButton("Harmonic Filter");
        HarmonicButton.addActionListener(act);
        maxButton = new JButton("Max Filter");
        maxButton.addActionListener(act);
        minButton = new JButton("Min Filter");
        minButton.addActionListener(act);
        midpointButton = new JButton("Midpoint Filter");
        midpointButton.addActionListener(act);
        geoButton = new JButton("Geometric Mean");
        geoButton.addActionListener(act);
        highBoostButton = new JButton("High Boosting Filter");
        highBoostButton.addActionListener(act);
        sharpenButton = new JButton("Sharpen Filter");
        sharpenButton.addActionListener(act);
        smoothButton = new JButton("Smooth Filter");
        smoothButton.addActionListener(act);
        medianButton = new JButton("Median Filter");
        medianButton.addActionListener(act);
        upButton = new JRadioButton("Upsampling");
        upButton.setSelected(true);
        subButton = new JRadioButton("Subsampling");
        nearestButton = new JRadioButton("Nearest");
        nearestButton.setSelected(true);
        linearButton = new JRadioButton("Linear ");
        bilinerButton = new JRadioButton("Bilinear");
        loadBt = new JButton("Load Image");
        loadBt.addActionListener(act);
        loadBt.setBounds(10,80,100,40);
        transButton = new JButton("Transform");
        transButton.setBounds(10, 120, 100, 40);
        transButton.addActionListener(act);
        histogramButton = new JButton(" Local Histogram Equalization");
        histogramButton.setPreferredSize(new Dimension(300, 50));
        histogramButton2 = new JButton("Global Histogram Equalization");
        histogramButton2.setPreferredSize(new Dimension(300, 50));
        histogramButton2.addActionListener(act);
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
        geoFilterTxt = new JTextField(2);
        geoFilterTxt.setPreferredSize(new Dimension(100, 40));
        maxFilterTxt = new JTextField(2);
        maxFilterTxt.setPreferredSize(new Dimension(100, 40));
        minFilterTxt = new JTextField(2);
        minFilterTxt.setPreferredSize(new Dimension(100, 40));
        midPointFilterTxt = new JTextField(2);
        midPointFilterTxt.setPreferredSize(new Dimension(100, 40));
        ArithmeticTxt = new JTextField(2);
        ArithmeticTxt.setPreferredSize(new Dimension(100, 40));
        HarmonicTxt = new JTextField(2);
        HarmonicTxt.setPreferredSize(new Dimension(100, 40));
        ContraharmonicTxt = new JTextField(2);
        ContraharmonicTxt.setPreferredSize(new Dimension(100, 40));
        ContraharmonicQValueTxt = new JTextField(2);
        ContraharmonicQValueTxt.setPreferredSize(new Dimension(100, 40));
        AlphatrimmedTxt = new JTextField(2);
        AlphatrimmedTxt.setPreferredSize(new Dimension(100, 40));
        AlphatrimmedMaskTxt = new JTextField(2);
        AlphatrimmedMaskTxt.setPreferredSize(new Dimension(100, 40));
        ModifiedFilterMaskTxt = new JTextField(2);
        ModifiedFilterMaskTxt.setPreferredSize(new Dimension(100, 40));


        





        





        //grayScaleTXT.setBounds(100, 80, 100, 50);
        grayScaleButton = new JButton("Gray Scale Resolution");
        //grayScaleButton.setBounds(210,80,150,50);
        grayScaleButton.addActionListener(act);
        JMenuBar menuBar = new JMenuBar();
        spatialMenu = new JMenu("Spatial Reselution");
        // spatialMenu.addMenuListener(menuAction);
        m1 = new JMenuItem("1x");
        m1.addActionListener(act);
        m2 = new JMenuItem("2x");
        m3 = new JMenuItem("3x");
        m4 = new JMenuItem("4x");
        // m5 = new JMenuItem("512x512");
        m2.addActionListener(act);
        m3.addActionListener(act);
        m4.addActionListener(act);
        // m5.addActionListener(act);
        nearestButton.addActionListener(act);
        linearButton.addActionListener(act);
        bilinerButton.addActionListener(act);
        upButton.setBounds(80, 80, 90, 50);
        subButton.setBounds(180, 80, 200, 50);
        menuBar.setBounds(380, 80, 150, 50);
        nearestButton.setBounds(580, 100, 100, 50);
        linearButton.setBounds(660, 100, 100, 50);
        bilinerButton.setBounds(730, 100, 100, 50);
        
        // FlowLayout flow = new FlowLayout();
        // setLayout(flow);

        group.add(nearestButton);
        group.add(linearButton);
        group.add(bilinerButton);
        groupSampling.add(upButton);
        groupSampling.add(subButton);
        spatialMenu.add(m1);
        spatialMenu.add(m2);
        spatialMenu.add(m3);
        spatialMenu.add(m4);
        // spatialMenu.add(m5);
        menuBar.add(spatialMenu);
        add(loadBt);
        add(transButton);
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
        panel3.add(bitButton);
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
        GeometricMeanPanel.add(geoFilterTxt);
        GeometricMeanPanel.add(geoButton);
        MaxPanel.add(maxFilterTxt);
        MaxPanel.add(maxButton);
        MinPanel.add(minFilterTxt);
        MinPanel.add(minButton);
        MidpointPanel.add(midPointFilterTxt);
        MidpointPanel.add(midpointButton);
        ArithmeticMeanPanel.add(ArithmeticTxt);
        ArithmeticMeanPanel.add(ArithmeticButton);
        HarmonicMeanPanel.add(HarmonicTxt);
        HarmonicMeanPanel.add(HarmonicButton);
        
        HuffmanCompressionPane.add(labeltxtHuffman);
        //HuffmanCompressionPane.add(labetxtHuffmanRuntime);
        HuffmanCompressionPane.add(HuffmanCompressionButton);
        RLCgrayscalePane.add(labeltxtRLCgrayscale);
        //RLCgrayscalePane.add(labeltxtRLCgrayscaleRuntime);
        RLCgrayscalePane.add(RLCgrayscaleButton);
        RLCbitchangePane.add(labeltxtRLCbitchange);
        //RLCbitchangePane.add(labeltxtRLCbitchangeRuntime);
        RLCbitchangePane.add(RLCbitchangeButton);
        ModifiedFilterPane.add(labeltxtModifiedEquation);
        ModifiedFilterPane.add(labeltxtModifiedMaskSize);
        ModifiedFilterPane.add(ModifiedFilterMaskTxt);
        ModifiedFilterPane.add(ModifiedButton);
        HybridFilterPane.add(labeltxtHybridEquation);
        HybridFilterPane.add(HybridButton);
        SobelPane.add(SobelButton);
        AlphatrimmedMeanPanel.add(labeltxtAlphatrimmed);
        AlphatrimmedMeanPanel.add(AlphatrimmedMaskTxt);
        AlphatrimmedMeanPanel.add(labeltxtAlphatrimmedValue);
        AlphatrimmedMeanPanel.add(AlphatrimmedTxt);
        AlphatrimmedMeanPanel.add(AlphatrimmedButton);
        ContraharmonicMeanPanel.add(labeltxtContraharmonicMaskSize);
        ContraharmonicMeanPanel.add(ContraharmonicTxt);
        ContraharmonicMeanPanel.add(labeltxtContraharmonicQValue);
        ContraharmonicMeanPanel.add(ContraharmonicQValueTxt);
        ContraharmonicMeanPanel.add(ContraharmonicButton);




        
        



        // panel5.add(tabsFilter);
        
        

        // add(panel1);
        add(picLabel);
        add(label1);
        // add(panel2);
        add(tabs);
        
        
        nearestButton.setVisible(true);
        linearButton.setVisible(true);
        bilinerButton.setVisible(true);
        upButton.setVisible(true);
        subButton.setVisible(true);
        setVisible(true);

       

    }

    public class Action extends Component implements ActionListener{   
        int imageHeight = 220;
        HashSet<Integer> b = new HashSet<Integer>();
        @Override
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == loadBt){
                File f= null;
                JFileChooser chooser = new JFileChooser();
                // optionally set chooser options ...
                if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                    f = chooser.getSelectedFile();
                    // read  and/or display the file somehow. ....
                } 
                imageStorage = new ImageStorage(f);
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
                if(upButton.isSelected()){
                    if(nearestButton.isSelected()){
                        imageStorage.upSample("Nearstneighbor", 1);
                    }else if(linearButton.isSelected()){
                        imageStorage.upSample("linear", 1);
                    }else if(bilinerButton.isSelected()){
                        imageStorage.upSample("bilinear", 1);
                    }
                }
                else if(subButton.isSelected()){
                imageStorage.subSample(1);
                }
                BufferedImage bi = imageStorage.getImagefromProcessedArray();
                label1.setIcon(new ImageIcon(bi));
                label1.setBounds(600, imageHeight, bi.getWidth(), bi.getHeight());
                 System.out.println(bi.getWidth());
            }
            else if(e.getSource() == m2){
                if(upButton.isSelected()){
                    if(nearestButton.isSelected()){
                        imageStorage.upSample("Nearstneighbor", 2);
                    }else if(linearButton.isSelected()){
                        imageStorage.upSample("linear", 2);
                    }else if(bilinerButton.isSelected()){
                        imageStorage.upSample("bilinear", 2);
                    }
                }
                else if(subButton.isSelected()){
                imageStorage.subSample(2);
                }
                BufferedImage bi = imageStorage.getImagefromProcessedArray();
                label1.setIcon(new ImageIcon(bi));
                label1.setBounds(600, imageHeight, bi.getWidth(), bi.getHeight());
                 System.out.println(bi.getWidth());
            }
            else if(e.getSource() == m3){
                if(upButton.isSelected()){
                    if(nearestButton.isSelected()){
                        imageStorage.upSample("Nearstneighbor", 3);
                    }else if(linearButton.isSelected()){
                        imageStorage.upSample("linear", 3);
                    }else if(bilinerButton.isSelected()){
                        imageStorage.upSample("bilinear", 3);
                    }
                }
                else if(subButton.isSelected()){
                imageStorage.subSample(3);
                }
                BufferedImage bi = imageStorage.getImagefromProcessedArray();
                label1.setIcon(new ImageIcon(bi));
                label1.setBounds(600, imageHeight, bi.getWidth(), bi.getHeight());
                 System.out.println(bi.getWidth());
            }

            else if(e.getSource() == m4){
                if(upButton.isSelected()){
                    if(nearestButton.isSelected()){
                        imageStorage.upSample("Nearstneighbor", 4);
                    }else if(linearButton.isSelected()){
                        imageStorage.upSample("linear", 4);
                    }else if(bilinerButton.isSelected()){
                        imageStorage.upSample("bilinear", 4);
                    }
                }
                else if(subButton.isSelected()){
                imageStorage.subSample(4);
                }
                BufferedImage bi = imageStorage.getImagefromProcessedArray();
                label1.setIcon(new ImageIcon(bi));
                label1.setBounds(600, imageHeight, bi.getWidth(), bi.getHeight());
                 System.out.println(bi.getWidth());
            }
            
            else if(e.getSource() == transButton){
                imageStorage = new ImageStorage(imageStorage.getImagefromProcessedArray(),imageStorage.getProcessedArray());
                BufferedImage bi =imageStorage.getBufferedImage();
                picLabel.setIcon(new ImageIcon(bi));
                picLabel.setBounds(50,imageHeight,bi.getWidth(),bi.getHeight());
                //m4.setText(imageStorage.getBufferedImage().getWidth()+"x"+imageStorage.getBufferedImage().getWidth());
                System.out.println("action");
                label1.setIcon(null);
            }
            else if(e.getSource() == medianButton){
                imageStorage.Filter(new Median(),Integer.valueOf(medianFilterTxt.getText()));
                BufferedImage bi = imageStorage.getImagefromProcessedArray();
                label1.setIcon(new ImageIcon(bi));
                label1.setBounds(600, imageHeight, bi.getWidth(), bi.getHeight());
                 System.out.println(bi.getWidth());
            }
            else if(e.getSource() == smoothButton){
                imageStorage.Filter(new Box(),Integer.valueOf(smoothFilterTxt.getText()));
                BufferedImage bi = imageStorage.getImagefromProcessedArray();
                label1.setIcon(new ImageIcon(bi));
                label1.setBounds(600, imageHeight, bi.getWidth(), bi.getHeight());
                 System.out.println(bi.getWidth());
            }
            else if(e.getSource() == sharpenButton){
                imageStorage.Filter(new Laplacin(Integer.valueOf(sharpenFilterTxt.getText())),Integer.valueOf(sharpenFilterTxt.getText()));
                BufferedImage bi = imageStorage.getImagefromProcessedArray();
                label1.setIcon(new ImageIcon(bi));
                label1.setBounds(600, imageHeight, bi.getWidth(), bi.getHeight());
            }
            else if(e.getSource() == histogramButton2){
                imageStorage.HEQ();
                BufferedImage bi = imageStorage.getImagefromProcessedArray();
                label1.setIcon(new ImageIcon(bi));
                label1.setBounds(600, imageHeight, bi.getWidth(), bi.getHeight());
            
            }
            else if(e.getSource() == highBoostButton){
                imageStorage.highBoost(Integer.valueOf(highBoostingTxt2.getText()),Integer.valueOf(highBoostingTxt.getText()));
                BufferedImage bi = imageStorage.getImagefromProcessedArray();
                label1.setIcon(new ImageIcon(bi));
                label1.setBounds(600, imageHeight, bi.getWidth(), bi.getHeight());
            
            }
            else if (e.getSource() == bitButton){
                b.clear();
               if(bitBox0.isSelected()){
                b.add(0);
               }
               if(bitBox1.isSelected()){
                b.add(1);
               }
               if(bitBox2.isSelected()){
                b.add(2);
               }
               if(bitBox3.isSelected()){
                b.add(3);
               }
               if(bitBox4.isSelected()){
                b.add(4);
               }
               if(bitBox5.isSelected()){
                b.add(5);
               }
               if(bitBox6.isSelected()){
                b.add(6);
               } 
               if(bitBox7.isSelected()){
                b.add(7);
               }
               System.out.println(b);
               imageStorage.bitLevelResolution(b);
               BufferedImage bi = imageStorage.getImagefromProcessedArray();
               label1.setIcon(new ImageIcon(bi));
               label1.setBounds(600, imageHeight, bi.getWidth(), bi.getHeight());
            }
            else if(e.getSource() == geoButton){
                imageStorage.Filter(new GeoMean(),Integer.valueOf(geoFilterTxt.getText()));
                BufferedImage bi = imageStorage.getImagefromProcessedArray();
                label1.setIcon(new ImageIcon(bi));
                label1.setBounds(600, imageHeight, bi.getWidth(), bi.getHeight());
            }
            else if(e.getSource() == maxButton){
                imageStorage.Filter(new Max(), Integer.valueOf(maxFilterTxt.getText()));
                BufferedImage bi = imageStorage.getImagefromProcessedArray();
                label1.setIcon(new ImageIcon(bi));
                label1.setBounds(600, imageHeight, bi.getWidth(), bi.getHeight());
            }
            else if(e.getSource() == minButton){
                imageStorage.Filter(new Min(), Integer.valueOf(minFilterTxt.getText()));
                BufferedImage bi = imageStorage.getImagefromProcessedArray();
                label1.setIcon(new ImageIcon(bi));
                label1.setBounds(600, imageHeight, bi.getWidth(), bi.getHeight());
            }
            else if(e.getSource() == midpointButton){
                imageStorage.Filter(new Midpoint(), Integer.valueOf(midPointFilterTxt.getText()));
                BufferedImage bi = imageStorage.getImagefromProcessedArray();
                label1.setIcon(new ImageIcon(bi));
                label1.setBounds(600, imageHeight, bi.getWidth(), bi.getHeight());
            }
            else if(e.getSource() == AlphatrimmedButton){
                System.out.println(Integer.valueOf(AlphatrimmedTxt.getText()));
                imageStorage.Filter(new Alphatrimmed(Integer.valueOf(AlphatrimmedTxt.getText())), Integer.valueOf(AlphatrimmedMaskTxt.getText()));
                BufferedImage bi = imageStorage.getImagefromProcessedArray();
                label1.setIcon(new ImageIcon(bi));
                label1.setBounds(600, imageHeight, bi.getWidth(), bi.getHeight());
            }
            else if(e.getSource() == HarmonicButton){
                imageStorage.Filter(new Harmonic(), Integer.valueOf(HarmonicTxt.getText()));
                BufferedImage bi = imageStorage.getImagefromProcessedArray();
                label1.setIcon(new ImageIcon(bi));
                label1.setBounds(600, imageHeight, bi.getWidth(), bi.getHeight());
            }
            else if(e.getSource() ==  ContraharmonicButton){
                System.out.println(Integer.valueOf(ContraharmonicQValueTxt.getText()));
                System.out.println(Integer.valueOf(ContraharmonicTxt.getText()));
                imageStorage.Filter(new Contraharmonic(Integer.valueOf(ContraharmonicQValueTxt.getText())), Integer.valueOf(ContraharmonicTxt.getText()));
                BufferedImage bi = imageStorage.getImagefromProcessedArray();
                label1.setIcon(new ImageIcon(bi));
                label1.setBounds(600, imageHeight, bi.getWidth(), bi.getHeight());
            }
            else if(e.getSource() == ArithmeticButton){
                System.out.println(Integer.valueOf(ArithmeticTxt.getText()));
                imageStorage.Filter(new Arithmetic(), Integer.valueOf(ArithmeticTxt.getText()));
                BufferedImage bi = imageStorage.getImagefromProcessedArray();
                label1.setIcon(new ImageIcon(bi));
                label1.setBounds(600, imageHeight, bi.getWidth(), bi.getHeight());
            }
            else if(e.getSource() == SobelButton){
                imageStorage.Filter(new Sobel(),3);
                BufferedImage bi = imageStorage.getImagefromProcessedArray();
                label1.setIcon(new ImageIcon(bi));
                label1.setBounds(600, imageHeight, bi.getWidth(), bi.getHeight());
            }
            else if(e.getSource() == HybridButton){
                imageStorage.HybridFilter(new Arithmetic());
                BufferedImage bi = imageStorage.getImagefromProcessedArray();
                label1.setIcon(new ImageIcon(bi));
                label1.setBounds(600, imageHeight, bi.getWidth(), bi.getHeight());

            }
            else if(e.getSource() == ModifiedButton){
                imageStorage.ModifiedFilter(new Arithmetic(),Integer.valueOf(ModifiedFilterMaskTxt.getText()));
                BufferedImage bi = imageStorage.getImagefromProcessedArray();
                label1.setIcon(new ImageIcon(bi));
                label1.setBounds(600, imageHeight, bi.getWidth(), bi.getHeight());
            }
            else if(e.getSource() == HuffmanCompressionButton){
                labeltxtHuffman.setText(imageStorage.HuffmanCompression());
                BufferedImage bi = imageStorage.getBufferedImage();
                label1.setIcon(new ImageIcon(bi));
                label1.setBounds(600, imageHeight, bi.getWidth(), bi.getHeight());
            }
            else if(e.getSource() == RLCgrayscaleButton){
                labeltxtRLCgrayscale.setText(imageStorage.RLCgrayscale());
                BufferedImage bi = imageStorage.getImagefromProcessedArray();
                label1.setIcon(new ImageIcon(bi));
                label1.setBounds(600, imageHeight, bi.getWidth(), bi.getHeight());
            }
            else if(e.getSource() == RLCbitchangeButton){
                labeltxtRLCbitchange.setText(imageStorage.RLCbitchange());
                BufferedImage bi = imageStorage.getImagefromProcessedArray();
                label1.setIcon(new ImageIcon(bi));
                label1.setBounds(600, imageHeight, bi.getWidth(), bi.getHeight());
            }
            
        }
    }

    



    public static void main(String[] args) {
        MyFrame frame = new MyFrame();
        
    }

    
}
