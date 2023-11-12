package Algo;

public class Sobel implements filterInterface{

    int [][] gx;
    int [][] gy;
    public Sobel(){
        gx = new int[3][3];
        gx[0] = new int[]{1,2,1};
        gx[1] = new int[]{0,0,0};
        gx[2] = new int[]{-1,-2,-1};

        gy = new int[3][3];
        gy[0] = new int[]{-1,0,1};
        gy[1] = new int[]{-2,0,2};
        gy[2] = new int[]{-1,0,1};

        
    }


    @Override
    public int Calculate(int[][] newWindow) {
        int gxVal=0;
        int gyVal=0;
        int g=0;
        for(int i=0; i<newWindow.length;i++){
            for(int j=0; j<newWindow[0].length;j++){
                gxVal += newWindow[i][j]*gx[i][j];
                gyVal += newWindow[i][j]*gy[i][j];
            }
        }
        g = (int) Math.sqrt((gxVal*gxVal)+(gyVal*gyVal));

        if(g > 255){
            g = 255;
        }
        return g;
    }
    
}
