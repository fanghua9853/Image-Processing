package Algo;

public class SpatialResolution {
    public void redecueSpatialResolution(int[][] processedArray, int n, int[][] imgArray ){
        for(int i=0, r = 0; r<processedArray.length; r++, i+=Math.pow(2, n)){
            for(int j=0,c=0; c<processedArray[0].length; c++, j+=Math.pow(2, n)){
                processedArray[r][c] = imgArray[i][j];
            }
        }
    }


    public int[][] putPixelBack(int[][]imgArray){
        int[][] temp = new int[imgArray.length*2][imgArray[0].length*2];
        for(int i=0, r = 0; r<imgArray.length; r++, i+=2){
            for(int j=0,c=0; c<imgArray[0].length; c++, j+=2){
                temp[i][j] = imgArray[r][c];  
            }
        }
        return temp;
    }

    public void nearestNeighbor(int[][] processedArray)
    {
        for(int i=0; i<processedArray.length; i+=2){
            for(int j=0; j<processedArray[0].length; j+=2){
                processedArray[i][j+1]=processedArray[i][j];
                processedArray[i+1][j]=processedArray[i][j];
                processedArray[i+1][j+1]=processedArray[i][j];
                
            }
        }
    }
    public void linearInterpolation(int[][] processedArray)
    {
         for(int i=1; i<processedArray.length-1; i+=2){
            for(int j=0; j<processedArray[0].length; j+=2){
                processedArray[i][j]=(processedArray[i-1][j]+processedArray[i+1][j])/2;
            }
        }
        for(int i=0; i<processedArray.length; i+=2){
            for(int j=1; j<processedArray[0].length-1; j+=2){
                processedArray[i][j]=(processedArray[i][j-1]+processedArray[i][j+1])/2;
            }
        }
        for(int i=1; i<processedArray.length; i+=2){
            for(int j=1; j<processedArray[0].length-1; j+=2){
                processedArray[i][j]=(processedArray[i][j-1]+processedArray[i][j+1])/2;
            }
        }
    }
    public void biLinearInterpolation(int[][] processedArray)
    {
         for(int i=1; i<processedArray.length-1; i+=2){
            for(int j=1; j<processedArray[0].length-1; j+=2){
                processedArray[i][j]=(processedArray[i-1][j-1]+processedArray[i-1][j+1]+processedArray[i+1][j-1]+processedArray[i+1][j+1])/4;
            }
        }
        for(int i=2; i<processedArray.length; i+=2){
            for(int j=1; j<processedArray[0].length-1; j+=2){
                processedArray[i][j]=(processedArray[i][j-1]+processedArray[i][j+1]+processedArray[i-1][j]+processedArray[i+1][j])/4;
            }
        }
        for(int i=1; i<processedArray.length-1; i+=2){
            for(int j=2; j<processedArray[0].length; j+=2){
                processedArray[i][j]=(processedArray[i][j-1]+processedArray[i][j+1]+processedArray[i-1][j]+processedArray[i+1][j])/4;
            }
        }
    }
}
