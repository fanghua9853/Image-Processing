package Algo;

import java.util.Arrays;

public class GeoMean implements filterInterface {
    public int Calculate(int[][] newWindow) {

        
        float mean =0;
        
        for(int i=0, count =0; i<newWindow.length; i++){
            for(int j=0; j<newWindow[0].length; j++){
                mean = mean + (float)Math.log(newWindow[i][j]);
                
            }
        }

        mean = mean/(newWindow.length*newWindow[0].length);
        
        
        return (int)Math.exp(mean);
    
    }
}
