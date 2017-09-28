/* Shuffles an array of objects */
import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.StdRandom;

public final class KnuthShuffle {
    /**
     * Rearranges the elements of the specified array in uniformly random order.
     *
     * @param  a the array to shuffle
     */
    public static void shuffle(Object[] a) {
        
        // as a demo, this generates a random number from 0 to 9
        //int i = StdRandom.uniform(0,10); 
        
        for(int c = 1; c < a.length; c++) {
            
            int r = StdRandom.uniform(0, c);
            
            Object temp = a[c];
            
            a[c] = a[r];
            
            a[r] = temp;
            
        }
        
        // implement this
    }
    
   
    public static String[] createArray(int size) {
        String[] arr = new String[size]; 
        for (int i = 0; i < size - 1; i++) {
            
            String x = Integer.toString(i);
            
            arr[i] = x;
            
        }
        return arr;
    }
    
    
    public static void main(String[] args) {
        
        //first create a array of a specific size
        String[] array = createArray(10000);
        
        Stopwatch stopwatch = new Stopwatch();
        
        shuffle(array);
        
        double time = stopwatch.elapsedTime();
        System.out.println("The time is: " + time);
                
    }
}