package Algo;

public class highBoosting{

    public void Calculate(int[][] imgArray, int boost,int[][] smoothing, int[][] processedArray) {
        for(int i=0;i<imgArray.length;i++){
            for(int j=0;j<imgArray[0].length;j++){
                processedArray[i][j] = imgArray[i][j] +boost*(imgArray[i][j]-smoothing[i][j]);
                if(processedArray[i][j]>255){
                    processedArray[i][j]=255;
                }
                else if(processedArray[i][j]<0){
                    processedArray[i][j]=0;
                }
            }
        }
        
    }
    

}
