package Algo;
import java.util.Comparator;
import java.util.PriorityQueue;

import Storage.ImageStorage;
public class Huffman {
    
    public int Calculate(int [][]imgArray){

        int[] level = pixelCount(imgArray);
        PriorityQueue<HuffmanNode> q = new PriorityQueue<HuffmanNode>(256, new MyComparator()); 
        
    for (int i = 0; i < level.length; i++) { 

        // creating a Huffman node object 
        // and add it to the priority queue. 
        HuffmanNode hn = new HuffmanNode(); 
        if(level[i]!=0)
        {
            hn.pixel = i; 
            hn.prob = level[i]; 

            hn.left = null; 
            hn.right = null; 

            // add functions adds 
            // the huffman node to the queue. 
            q.add(hn); 
        }
        
    } 

    // create a root node 
    HuffmanNode root = null; 

    // Here we will extract the two minimum value 
    // from the heap each time until 
    // its size reduces to 1, extract until 
    // all the nodes are extracted. 
    while (q.size() > 1) { 

        // first min extract. 
        HuffmanNode x = q.peek(); 
        q.poll(); 

        // second min extract. 
        HuffmanNode y = q.peek(); 
        q.poll(); 

        // new node f which is equal 
        HuffmanNode f = new HuffmanNode(); 

        // to the sum of the frequency of the two nodes 
        // assigning values to the f node. 
        f.prob = x.prob + y.prob; 
        f.pixel = '-'; 

        // first extracted node as left child. 
        f.left = x; 

        // second extracted node as the right child. 
        f.right = y; 

        // marking the f node as the root node. 
        root = f; 

        // add this node to the priority-queue. 
        q.add(f); 
    }          
        return 0;
    }
    public int[] pixelCount(int imgArray[][]){
        int[] level = new int[256];
        for(int i=0;i<imgArray.length;i++){
            for(int j=0; j<imgArray[0].length;j++){
                level[imgArray[i][j]]+=1;
            }
        }
        return level;

    }
    class HuffmanNode{
        int prob;
        int pixel;
        HuffmanNode left;
        HuffmanNode right;
    }
    class MyComparator implements Comparator<HuffmanNode> { 
    public int compare(HuffmanNode x, HuffmanNode y) 
    { 
  
        return x.prob - y.prob; 
    } 
} 

}
