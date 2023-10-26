package Algo;

public class Box implements filterInterface{
    //sliding window by using boxfilter
    public int Calculate(int[][] newWindow){
        int count=0;
        for(int i=0;i<newWindow.length;i++){
            for(int j=0; j<newWindow[0].length;j++){
                count+=newWindow[i][j];
            }
        }
        return count/(newWindow.length * newWindow[0].length);
    }
}
