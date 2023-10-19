package Algo;

public class GrayScaleResolution {
    public void changeGrayLevel(int newBit, int[][] imgArray, int[][] processedArray){
        for(int i =0; i< processedArray.length; i++){
            for(int j=0; j<processedArray[0].length; j++){
                processedArray[i][j] = (imgArray[i][j]/(int)(Math.pow(2, 8-newBit))) * 255 /(int) (Math.pow(2, newBit));

            }
        }
    }
}
