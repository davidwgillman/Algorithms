/* Shuffles an array of objects */

import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.StdRandom;

public final class KnuthShuffle {
    /**
     * Rearranges the elements of the specified array in uniformly random order.
     *
     * @param  a the array to shuffle
     */
    public static void shuffle(Object[] a) {
        for(int n = 1; n < a.length; n++){
            int randomSpot = StdRandom.uniform(0, n+1);
            Object assignSpot = a[n];
            a[n] = a[randomSpot];
            a[randomSpot] = assignSpot;
        }
    }

    public static void main(String[] args) {
        String arraySize = args[0];
        int numElem = Integer.parseInt(arraySize);
        String [] a = new String [Integer.parseInt(arraySize)];
        for(int n =0; n < numElem; n++){
            a[n] =Integer.toString(n);
        }

        //printing time
        Stopwatch timer = new Stopwatch();
        KnuthShuffle.shuffle(a);
        double time = timer.elapsedTime();
        System.out.println(time);
          
    }
}