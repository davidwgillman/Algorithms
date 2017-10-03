/* Shuffles an array of objects */

import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Arrays; 

public final class KnuthShuffle {

    /**
     * Rearranges the elements of the specified array in uniformly random order.
     *
     * @param  a the array to shuffle
     */
    
	public static void shuffle(Object[] a) {
        for (int i = 0; i < a.length; i++) {
            int random = StdRandom.uniform(0,a.length);
            Object temp = a[random];
            a[random] = a[i];
            a[i] = temp;
        }
        //
    }

    public static void main(String[] args) {
        Object[] x = new Object[400000];
        for(int i = 0; i < x.length; i++){
            x[i] = i;
        }
        Stopwatch stopwatch = new Stopwatch();
        long start = System.currentTimeMillis();
        //System.out.println(Arrays.toString(x));
        shuffle(x);
        long elapsed = System.currentTimeMillis();
        //System.out.println("Milliseconds elapsed: "+ (elapsed - start));
        //System.out.println(Arrays.toString(x));
        System.out.println("Milliseconds elapsed: "+ (elapsed - start));
    }
}