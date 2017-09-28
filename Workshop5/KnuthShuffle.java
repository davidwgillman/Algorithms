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

        int N = a.length;
        
        for (int i = 0; i < N; i++) {
            int r = StdRandom.uniform(0,10);
            int temp = i;
            i = r;
            r = temp;
        }
	}

	public static void main(String[] args) {
        
        // Create new array of size N
        int cards[] = new int[N];
        
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform();
        }
        
        // Logs how long the process took
        double time = stopwatch.elapsedTime();
        System.out.println("Time passed: " + time);
	}
}
