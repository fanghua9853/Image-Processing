package Test;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import Storage.ImageStorage;

public class test {
    public static void main(String[] args) {
        ImageStorage var = new ImageStorage(new File("project1/src/Lena2.png"));
        System.out.println("ran");
        Set<Integer> testSet = new HashSet<>();
        testSet.add(7);
        // testSet.add(6);
        // testSet.add(5);
        // testSet.add(4);
        // testSet.add(3);
        // testSet.add(2);
        // testSet.add(0);
        // var.bitLevelResolution(testSet);
        var.upSample("Nearstneighbor",2);;  
        var.saveProcessedImage("project1/src/up");
        
    }
}
