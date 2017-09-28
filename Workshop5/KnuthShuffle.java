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
		// as a demo, this generates a random number from 0 to to the the length of the arry
		//this is the length of the array
		int length = a.length;
		int i = StdRandom.uniform(0, length); 
		// implement this
		for(n = 0; n < length; n++){
			int randomSpot = StdRandom.uniform(0, length + 1);
			Object assignSpot = a[randomSpot];
			a[n] = a[randomSpot];
			a[n] = assignSpot;
		}
	}

	public static void main(String[] args) {
		// implement this
		int numElem = args[0];
		int [] a = new int[numElem];
		for(n =0; n < numElem; n++){
			a[n] =n;
		}

		//printing time
		Stopwatch timer = new Stopwatch();
		KnuthShuffle.shuffle(a);
		double time = timer.elapsedTime();
		System.out.println(time);
		//printing array
		for(int n =0; n < a.length; n++){
			System.out.println(a[n] + ", ");
		}        
	}
}