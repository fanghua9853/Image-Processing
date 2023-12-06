package Algo;
import java.util.ArrayList;
import java.util.LinkedList;

import Storage.ImageStorage;

public class RLCgrayscale {
    

    public ArrayList<Integer> EncodePixel(int [][]imgArray){
        ArrayList<Integer> encode = new ArrayList<>();
        int count=0;
        int lastPixel=imgArray[0][0];
        for(int i=0; i<imgArray.length;i++){
            for(int j=0; j<imgArray[0].length;j++){
                if(imgArray[i][j] == lastPixel){
                    count+=1;
                }else{
                    encode.add(lastPixel);
                    encode.add(count);
                    lastPixel=imgArray[i][j];
                    count=1;
                }
                
            }
        }
        encode.add(lastPixel);
        encode.add(count);
        return encode;

        
    }



    public ArrayList<Integer> DecodePixel(ArrayList<Integer> encode){
        ArrayList<Integer> decode = new ArrayList<>();
        for(int i=1; i<encode.size(); i+=2){
            
            int pixel = encode.get(i-1);
            int count = encode.get(i);

            for(int j=0; j<count;j++){
                decode.add(pixel);
            }
        }

        return decode;
    }
}
