package Algo;
import java.util.Arrays;

public class Max implements filterInterface {
    public int Calculate(int[][] newWindow){

        int[] arr = new int[newWindow.length * newWindow[0].length];
        
        for(int i=0, count =0; i<newWindow.length; i++){
            for(int j=0; j<newWindow[0].length; j++){
                arr[count] = newWindow[i][j];
                count++;
            }
        }
        Arrays.sort(arr);
        

        return arr[arr.length - 1];
    }
}
