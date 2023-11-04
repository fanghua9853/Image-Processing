package Algo;

public class Contraharmonic implements filterInterface {
    int Q;
    public Contraharmonic(int QVal){
        Q=QVal;
    }
    @Override
    public int Calculate(int[][] newWindow) {
        float up =0;
        float below=0;
        float mean=0;
        
        for(int i=0, count =0; i<newWindow.length; i++){
            for(int j=0; j<newWindow[0].length; j++){
                if(newWindow[i][j] != 0){
                    up = up+ (float)Math.pow(newWindow[i][j], Q+1);
                    below = below + (float)Math.pow(newWindow[i][j], Q);
                }   
            }
        }
        
        mean = up/below;
        return (int)mean;
    }
    
}
