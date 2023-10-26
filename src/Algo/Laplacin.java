package Algo;

public class Laplacin implements filterInterface{
int [][] mask;
public Laplacin(int n){
    mask = new int[n][n];
    for(int i =0;i<n;i++){
        for(int j =0; j<n; j++){
            mask[i][j]=1;
        }
    }

    mask[(n-1)/2][(n-1)/2] = (n*n-1)*(-1);
}



    @Override
    public int Calculate(int[][] newWindow) {
        int sum=0;
       for(int i=0; i<newWindow.length;i++){
        for(int j=0;j<newWindow[0].length;j++){
            sum+=newWindow[i][j];
        }
       }
       sum-=newWindow[(newWindow.length-1)/2][(newWindow.length-1)/2];
       sum-=8*(newWindow[(newWindow.length-1)/2][(newWindow.length-1)/2]);


        return newWindow[(newWindow.length-1)/2][(newWindow.length-1)/2]+-1*sum;
    }
    
    

}
