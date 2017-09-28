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
		for(int n = 0; n < a.length; n++){
			int i = StdRandom.uniform(0, a.length + 1); 
			int swappedElem = a[i];
			a[i] = a[n];
			a[n] = swappedElem;
		}
	}

	public static void main(String[] args) {
		int inputArraySize = args[0];
		String[] a = new int[inputArraySize];

		for(int i = 0; i < inputArraySize; i++){
			a[i] = i;
		}

		Stopwatch timer = new Stopwatch();
		KnuthShuffle.shuffle(a);
		double time = timer.elapsedTime();
		System.out.println(time);

		for(int n = 0; n < inputArraySize; n++){
			System.out.print(a[n]+ ", ");
		}

	}
}