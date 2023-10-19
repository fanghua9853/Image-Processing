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
    JRadioButton nearestButton;
    JRadioButton linearButton;
    JRadioButton bilinerButton;
    ButtonGroup group;
    JButton loadBt;
    JLabel label1;
    JLabel picLabel;
    JButton grayScaleButton;
    JMenu spatialMenu;
    JMenuItem m1;
    JMenuItem m2;
    JMenuItem m3;
    JMenuItem m4;
    JMenuItem m5;
    JTextField grayScaleTXT;
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
        JPanel panel1 = new JPanel(null);
        JLabel labeltxt = new JLabel("Input: ");
        labeltxt.setBounds(20,80,100,50);
        panel1.setBackground(Color.LIGHT_GRAY);
        tabs.setBounds(200, 0, 1000, 200);
        tabs.add("Enhancement",panel1);
        tabs.add("Enhancement 2",new JPanel());
        
        group = new ButtonGroup();
        nearestButton = new JRadioButton("Nearest");
        nearestButton.setSelected(true);
        linearButton = new JRadioButton("Linear ");
        bilinerButton = new JRadioButton("Bilinear");
        loadBt = new JButton("Load Image");
        loadBt.addActionListener(act);
        loadBt.setBounds(10,100,100,50);
        grayScaleTXT = new JTextField("8");
        grayScaleTXT.setPreferredSize(new Dimension(100, 50));
        grayScaleTXT.setBounds(100, 80, 100, 50);
        grayScaleButton = new JButton("Gray Scale Resolution");
        grayScaleButton.setBounds(210,80,150,50);
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
        panel1.add(labeltxt);
        panel1.add(grayScaleTXT);
        panel1.add(grayScaleButton);
        panel1.add(menuBar);
        panel1.add(nearestButton);
        panel1.add(linearButton);
        panel1.add(bilinerButton);
        
        

        // add(panel1);
        add(picLabel);
        add(label1);
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
                imageStorage = new ImageStorage(new File("project1/src/Lena.png"));
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
