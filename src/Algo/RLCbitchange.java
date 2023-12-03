package Algo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class RLCbitchange {
    
    public ArrayList<Integer>[] EncodePixel(int [][]imgArray){
        ArrayList<Integer>[] encodeList = new ArrayList[8]; 
        int [][] temp = new int[imgArray.length][imgArray[0].length];
        BitChange BC = new BitChange();
        
        for(int b=0; b<8;b++){
            HashSet<Integer> bitNum = new HashSet<>();
            bitNum.add(0);
            bitNum.add(1);
            bitNum.add(2);
            bitNum.add(3);
            bitNum.add(4);
            bitNum.add(5);
            bitNum.add(6);
            bitNum.add(7);
            bitNum.remove(b);

            BC.changeBitLevel(imgArray, bitNum, temp);
            
            encodeList[b] = new ArrayList<>();
            int count=0;
            int lastPixel=temp[0][0];

            if(lastPixel == 0){
                encodeList[b].add(0);
            }
            for(int i=0; i<temp.length;i++){
                for(int j=0; j<temp[0].length;j++){
                    if(temp[i][j] == lastPixel){
                        count+=1;
                    }else{
                        
                        encodeList[b].add(count);
                        lastPixel=temp[i][j];
                        count=1;
                    }
                    
                }
            }
            encodeList[b].add(count);
        }
        return encodeList;

        
    }

    public int[] decodePixel(ArrayList<Integer>[] encoList){
        

        LinkedList<Integer>[] BitDecode = new LinkedList[8];
        
        for(int b=0;b<8;b++){
             BitDecode[b] = new LinkedList<>();
             for(int i=0;i<encoList[b].size();i++){
                for(int j=0;j<encoList[b].get(i);j++){
                    if(i %2==0){
                        BitDecode[b].add(1);
                    }else{
                        BitDecode[b].add(0);
                    }
                }
             }
        }
        int[] decodeList = new int [BitDecode[0].size()];
        for(int i=0; i<BitDecode[0].size();i++){
            StringBuilder str = new StringBuilder();
            for(int j=0; j<BitDecode.length;j++){
                str.append(BitDecode[j].get(i));
            }
            str.reverse();
            decodeList[i] = Integer.parseInt(str.toString(),2);
        }
        
        
        
        
        return decodeList;
    }


}
