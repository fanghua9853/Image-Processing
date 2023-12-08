package Algo;

import java.util.Set;

public class BitChange {
    String binary;
    public void changeBitLevel(int [][] imgArray, Set<Integer> Bit,int [][] processedArray) {
        for(int  i=0; i<imgArray.length; i++){
            for(int j=0; j<imgArray[0].length; j++){
                //change the grayscale val to bit num
                binary = String.format("%8s",Integer.toBinaryString(imgArray[i][j])).replace(' ','0');
                 StringBuilder str = new StringBuilder(binary);
                 str=str.reverse();
                 for(int k=0; k<8;k++){
                    if(Bit.contains(k) ){
                        str.setCharAt(k, '0');
                    }

                }
                str=str.reverse();
                processedArray[i][j] = Integer.parseInt(str.toString(),2);
            }
            
        }


    }
}