package Algo;

import java.util.Set;

public class BitChange {
    String binary;
    public void changeBitLevel(int [][] imgArray, Set<Integer> Bit,int [][] processedArray) {
        for(int  i=0; i<imgArray.length; i++){
            for(int j=0; j<imgArray[0].length; j++){
                binary = String.format("%8s",Integer.toBinaryString(imgArray[i][j])).replace(' ','0');
                // System.out.print(binary);

                 StringBuilder str = new StringBuilder(binary);
                 str=str.reverse();
                
                 for(int k=0; k<8;k++){
                    if(Bit.contains(k) ){
                        str.setCharAt(k, '0');
                    }

                }
                
                str=str.reverse();
                // System.out.print(" : ");
                // System.out.println(str.toString());
                processedArray[i][j] = Integer.parseInt(str.toString(),2);
            }
            
        }


    }
}