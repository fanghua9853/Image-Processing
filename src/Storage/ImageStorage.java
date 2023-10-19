package Storage;
import java.awt.image.*;
import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

import javax.imageio.ImageIO;
import java.awt.image.WritableRaster;
import java.awt.image.BufferedImage;

import Algo.BitChange;
import Algo.GrayScaleResolution;
import Algo.SpatialResolution;

public class ImageStorage {
    BufferedImage img;
    int[][] imgArray;
    int[][] processedArray;
    
    //Constructor
    public ImageStorage(File pic) {
        try {
            img = ImageIO.read(pic);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        imgArray = new int[img.getWidth()][img.getHeight()];
        this.getImageArray();
        //System.out.println("debug");
    }


    //Change buffer image into array and get gray scale value
    public void getImageArray(){
        for(int i =0; i<img.getWidth(); i++){
            for(int j =0; j<img.getHeight(); j++){
                int p = (img.getRGB(i,j));
                
                int r = (p >> 16) & 0xff;
                int g = (p >> 8) & 0xff;
                int b = (p) & 0xff;

                imgArray[i][j]=(r+g+b)/3;
            }
        }
    }
    public BufferedImage getBufferedImage()
    {
        return img;
    }
    //Write processed image to file
    public void saveProcessedImage(String filename){
        try {
            File f = new File(String.format("%s.png",filename));
            ImageIO.write(getImagefromProcessedArray(), "png", f);

        } catch (Exception e) {
            // TODO: handle exception
            System.out.print(e);
        }
    }

    //helper function for saveProcessedImage
    //Transform the processed array into the image
    public BufferedImage getImagefromProcessedArray(){
        int w = processedArray.length;
        int h = processedArray[0].length;
        BufferedImage img2 = new BufferedImage(w, h, BufferedImage.TYPE_BYTE_GRAY);

        //get the processed image arrary and set array to byte
        byte[] pixels = new byte[w*h];
        for(int i=0; i<processedArray.length; i++){
            for(int j=0; j<processedArray[0].length; j++){
                pixels[j*w+i] = (byte)processedArray[i][j];
            }
        }

        //
        img2.getRaster().setDataElements(0, 0, w, h, pixels);
        return img2;
        

    }

    public void grayScaleResolution(int newBit){
        GrayScaleResolution var = new GrayScaleResolution();
        processedArray = new int[imgArray.length][imgArray[0].length];
        var.changeGrayLevel(newBit, imgArray, processedArray); 
    }
    //Remove the selected Bit planes in SET Bit
    public void bitLevelResolution(Set<Integer> Bit) {
        BitChange var = new BitChange();
        processedArray = new int[imgArray.length][imgArray[0].length];
        var.changeBitLevel(imgArray, Bit, processedArray);
        stretch(processedArray);
    }
    public void subSample(int n)
    {
        SpatialResolution var = new SpatialResolution();
        
        processedArray = new int[imgArray.length/(int)Math.pow(2,n)][imgArray[0].length/(int)Math.pow(2,n)];
        var.redecueSpatialResolution(processedArray, n, imgArray);
    }
    public void upSample(String algo,int n)
    {
        SpatialResolution var = new SpatialResolution();
         processedArray = new int[imgArray.length][imgArray[0].length];
        for(int i=0;i<imgArray.length;i++)
        {
            processedArray[i]=imgArray[i].clone();
        }
        for(int i=0;i<n; i++)
        {
            processedArray=var.putPixelBack(processedArray);
            if(algo.equals("Nearstneighbor")){
                var.nearestNeighbor(processedArray);
            }else if(algo.equals("linear")){
                var.linearInterpolation(processedArray);
            }else if(algo.equals("bilinear")){
                var.biLinearInterpolation(processedArray);
            }
        }
    }


    public void stretch(int[][] processedArray){
        HashMap<Integer,Double> sm = new HashMap();
        for(int i = 0; i< processedArray.length; i++){
            for(int j=0; j< processedArray[0].length; j++){
                sm.put(processedArray[i][j], 0.0);
            }
        }

        double IntSpace = 255/((double) sm.size()-1);
        Integer[] s = sm.keySet().toArray(new Integer[0]);
        Arrays.sort(s);
        for(int i=0; i <sm.size()-1; i++){
            sm.put(s[i],i*IntSpace);
        }
        sm.put(s[s.length-1],255.0);  
        System.out.println(sm.toString());
        for(int i = 0; i< processedArray.length; i++){
            for(int j=0; j< processedArray[0].length; j++){
                processedArray[i][j]=(int) Math.round(sm.get(processedArray[i][j]));
            }
        }
    }

}
