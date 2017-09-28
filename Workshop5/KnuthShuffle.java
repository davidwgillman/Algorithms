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
		// as a demo, this generates a random number from 0 to 9
		//int i = StdRandom.uniform(0,10); 
		// implement this
		validateNotNull(a);
		int n = a.length;
		for  (int i = 0; i < n; i++) {
			int r = StdRandom.uniform(0, i+1);
			Object temp = a[i];
			a[i] = a[r];
			a[r] = temp;

		}
		
		
	}

	public static void main(String[] args) {
		// implement this
		for (int i = 0; i < 10000; i++) {
			a[i] = i;
		}
		Stopwatch timer = new Stopwatch();
		
		KnuthShuffle.shuffle();

		double timer1 = timer.elapsedTime();
        StdOut.printf("(%.2f seconds)\n", timer1);





	}
}