package Algo;
import java.util.Arrays;

public class Filters {
    String type;
    public Filters(String s){
        type=s;
    }
    //Sliding window 
    public void slideWindow(int n, int imgArray[][],int processedArray[][]){
        int[][] newWindow = new int[n][n];
        int[][] temp = new int[imgArray.length + newWindow.length-1][imgArray[0].length + newWindow[0].length-1];
    
        for(int i=n/2; i<temp.length-n/2;i++){
            for(int j=n/2; j<temp[0].length-n/2; j++){
                temp[i][j] = imgArray[i-n/2][j-n/2];
            }
        }
        //start from actual image so start from n/2 which is the padding of the image
        for(int i=n/2,i2=0; i<temp.length-n/2; i++,i2++){
            for(int j=n/2, j2=0; j<temp[0].length-n/2;j++, j2++){
                //sliding window
                for(int k=0; k<n; k++){
                    for(int f=0;f<n;f++){
                        newWindow[k][f] = temp[i2+k][j2+f];
                    }
                }
                //run filter and save to processed on processed[i][j]

                if(type.equals("median")){
                    processedArray[i2][j2] = findMedian(newWindow);
                }
                else if(type.equals("box")){
                    processedArray[i2][j2] = boxFilter(newWindow);
                }
            }
        }




    }

    //sort 
    public int findMedian(int [][]newWindow){
        int[] arr = new int[newWindow.length * newWindow[0].length];
        int median;
        for(int i=0, count =0; i<newWindow.length; i++){
            for(int j=0; j<newWindow[0].length; j++){
                arr[count] = newWindow[i][j];
                count++;
            }
        }
        Arrays.sort(arr);
        median = arr[(arr.length +1)/2];
        
        return median;
    }

    //sliding window by using boxfilter
    public int boxFilter(int[][] newWindow){
        int count=0;
        for(int i=0;i<newWindow.length;i++){
            for(int j=0; j<newWindow[0].length;j++){
                count+=newWindow[i][j];
            }
        }
        return count/(newWindow.length * newWindow[0].length);

    }


}
