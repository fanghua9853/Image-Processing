package Algo;

import java.util.Arrays;

public class Alphatrimmed implements filterInterface {
    int d;
    public Alphatrimmed(int dVal){
        d=dVal;
    }
    public int Calculate(int[][] newWindow) {

        int[] arr = new int[newWindow.length * newWindow[0].length];
        float mean =0;
        for(int i=0, count =0; i<newWindow.length; i++){
            for(int j=0; j<newWindow[0].length; j++){
                arr[count] = newWindow[i][j];
                count++;
            }
        }
        Arrays.sort(arr);
        
        for(int i=d/2; i<arr.length - d/2;i++){
            mean = mean+arr[i];
        }

        mean=mean/(arr.length - d);
        return (int)mean;
    
    }

    
}
