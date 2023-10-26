package Algo;
import java.util.ArrayList;
import java.util.HashMap;
public class HistogramEQ {

    HashMap<Integer,Integer>counter = new HashMap<Integer, Integer>();
    ArrayList<Integer> list; 
    double []level;
    int total;   
    float scale;

    public double[] pixelCount(int imgArray[][]){
        level = new double[256];
        for(int i=0;i<imgArray.length;i++){
            for(int j=0; j<imgArray[0].length;j++){
                level[imgArray[i][j]]+=1;
            }
        }
        return level;

    }

    
    public void equalize(int imgArray[][], int[][] processedArray){
        double[] histogram = pixelCount(imgArray);
        long sum=0;

        total = imgArray.length * imgArray[0].length;
        
         histogram[0]= histogram[0] *255/total;
        for(int i=1;i<histogram.length;i++){
            histogram[i]= histogram[i] *255/total+histogram[i-1];
            
        }
        for(int i =0;i<imgArray.length;i++){
            for(int j=0; j<imgArray[0].length; j++){
                processedArray[i][j] = (int)histogram[imgArray[i][j]];
            }
        }

    }
}
