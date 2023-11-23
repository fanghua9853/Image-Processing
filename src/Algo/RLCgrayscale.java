package Algo;
import java.util.LinkedList;

import Storage.ImageStorage;

public class RLCgrayscale {
    
    public int Calculate(int [][]imgArray){
        
        
        
    }

    public LinkedList<Integer> EncodePixel(int [][]imgArray){
        LinkedList<Integer> encode = new LinkedList<>();
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
        return encode;

        
    }



    public LinkedList<Integer> DecodePixel(LinkedList<Integer> encode){
        LinkedList<Integer> decode = new LinkedList<>();
        for(int i=0; i<encode.size(); i++){
            
            int pixel = encode.getFirst();
            encode.removeFirst();
            int count = encode.getFirst();
            encode.removeFirst();

            for(int j=0; j<count;j++){
                decode.add(pixel);
            }
        }

        return decode;
    }
}
