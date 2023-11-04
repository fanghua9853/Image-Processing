package Algo;

public class Harmonic implements filterInterface  {

    @Override
    public int Calculate(int[][] newWindow) {
        float mean =0;
        
        for(int i=0, count =0; i<newWindow.length; i++){
            for(int j=0; j<newWindow[0].length; j++){
                if(newWindow[i][j] != 0){
                    mean = mean+ 1/(float)newWindow[i][j];
                }
                
            }
        }

        mean =  (newWindow.length*newWindow[0].length)/mean;



        return (int)mean;
    }
    
}
