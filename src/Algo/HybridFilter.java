package Algo;

public class HybridFilter {
    filterInterface mean;
    filterInterface sobel;
    int n;
    public HybridFilter(filterInterface s){ 
        mean=s;
        sobel=new Sobel();
        this.n=3;
    }
    //Sliding window 
    public void slideWindow(int imgArray[][],int processedArray[][]){
        int[][] newWindow = new int[n][n];
        int[][] temp = new int[imgArray.length + newWindow.length-1][imgArray[0].length + newWindow[0].length-1];
        //padding
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
                processedArray[i2][j2] =(int)(Math.pow(mean.Calculate(newWindow), 2)+2*sobel.Calculate(newWindow));
                if(processedArray[i2][j2]>255){
                    processedArray[i2][j2]=255;
                }
                else if(processedArray[i2][j2]<0){
                    processedArray[i2][j2]=0;
                }
            }
        }




    }

}
