package Storage;
import java.awt.image.*;
import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;

import javax.imageio.ImageIO;
import java.awt.image.WritableRaster;
import java.awt.image.BufferedImage;

import Algo.*;

public class ImageStorage {
    BufferedImage img;
    int[][] imgArray;
    int[][] processedArray;
    
    //Constructor
    public ImageStorage(File pic) {
        try {
            img = ImageIO.read(pic);
        } catch (Exception e) {
            e.printStackTrace();
        }
        imgArray = new int[img.getWidth()][img.getHeight()];
        this.getImageArray();
        //System.out.println("debug");
    }
    //Constructor
    public ImageStorage(BufferedImage pic,int[][] process) {
        try {
            img = pic;
        } catch (Exception e) {
            e.printStackTrace();
        }
        imgArray = new int[process.length][];
        for(int i=0;i<process.length;i++){
            imgArray[i]=process[i].clone();
        }
        //System.out.println("debug");
    }
    public int[][] getProcessedArray()
    {
        return processedArray;
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
    public void Filter(filterInterface s,int n){
        Filters m = new Filters(s,n);
        processedArray = new int[imgArray.length][imgArray[0].length];
        m.slideWindow(imgArray, processedArray);
    }
    public void HybridFilter(filterInterface s){
        HybridFilter m = new HybridFilter(s);
        processedArray = new int[imgArray.length][imgArray[0].length];
        m.slideWindow(imgArray, processedArray);
        MSE();
    }
    public void ModifiedFilter(filterInterface s,int n){
        ModifiedFilter m = new ModifiedFilter(s,n);
        processedArray = new int[imgArray.length][imgArray[0].length];
        m.slideWindow(imgArray, processedArray);
    }
    public void HEQ(){
        HistogramEQ heq = new HistogramEQ();
         processedArray = new int[imgArray.length][imgArray[0].length];
         heq.equalize(imgArray, processedArray);
    }

    public void highBoost(int boost, int n){
        Filter(new Box(),n);
       highBoosting hb = new highBoosting();
       hb.Calculate(imgArray, boost, processedArray, processedArray);

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
        if(s.length !=1){
            sm.put(s[s.length-1],255.0);    
        }
         
        System.out.println(sm.toString());
        for(int i = 0; i< processedArray.length; i++){
            for(int j=0; j< processedArray[0].length; j++){
                processedArray[i][j]=(int) Math.round(sm.get(processedArray[i][j]));
            }
        }
    } 
    public void MSE(){
        double mse=0;
        for(int i=0;i<imgArray.length;i++){
            for(int j=0; j<imgArray[0].length;j++){
                mse+=Math.pow(imgArray[i][j]-processedArray[i][j],2);
            }
        }
        mse= mse/((imgArray.length * imgArray[0].length));
        System.out.println(mse);
    }

    public void RLCgrayscale(int[][] imgArray){
        RLCgrayscale grayscale = new RLCgrayscale();
        LinkedList<Integer> encode = new LinkedList<>();
        LinkedList<Integer> decode = new LinkedList<>();
        long encodeStart = System.currentTimeMillis();
        encode = grayscale.EncodePixel(imgArray);
        long encodeEnd = System.currentTimeMillis();
        long encodeTime = encodeEnd - encodeStart;
       
        long decodeStart = System.currentTimeMillis();
        decode = grayscale.DecodePixel(encode);
        long decodeEnd = System.currentTimeMillis();
        long decodeTime = decodeEnd - decodeStart;
       
        
        //Calculate the compression ratio
        double originalLenth = encode.size();
        double newLength = decode.size();
        double compressionRatio = originalLenth/newLength;

        //
        System.out.println("Encode time: "+encodeTime+" Decode time: "+decodeTime+" COmpression Ratio: "+compressionRatio);

    }

    public void HuffmanCompression(){
        Huffman h = new Huffman();
        h.Calculate(imgArray);
        String[] encode=h.PixelToCode(imgArray);
        int[] decode = h.HuffmanDecoding(encode);
        
    }

    
}
