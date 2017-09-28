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
			int r = StdRandom.uniform(0, n); 
			Object swappedElem = a[n];
			a[n] = a[r];
			a[r] = swappedElem;
		}
	}

	public static void main(String[] args) {
		String inputArraySize = args[0];
		int size = Integer.parseInt(inputArraySize);
		String[] a = new String[Integer.parseInt(inputArraySize)];

		for(int i = 0; i < size; i++){
			a[i] = Integer.toString(i);
		}

		Stopwatch timer = new Stopwatch();
		KnuthShuffle.shuffle(a);
		double time = timer.elapsedTime();
		System.out.println(time);

		for(int n = 0; n < size; n++){
			System.out.print(a[n]+ ", ");
		}

	}
}