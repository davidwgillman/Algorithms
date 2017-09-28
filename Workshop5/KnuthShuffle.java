/* Shuffles an array of objects */

import edu.princeton.cs.algs4.Stopwatch;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdRandom;

public final class KnuthShuffle {

    /**
     * Rearranges the elements of the specified array in uniformly random order.
     *
     * @param  a the array to shuffle
     */
	public static void shuffle(Object[] a) {
		// implement this
		for(int i=1;i<a.length;i++){
			int r = StdRandom.uniform(0,i);
			//swap a[i] and a[r]
			Object x=a[i];
			a[i]=a[r];
			a[r]=x;
		}
	}

	public static void main(String[] args) {
		// implement this
		String[] s=new String[]{"a","b","c","d","e"};
		System.out.println(Arrays.toString(s));
		shuffle(s);
		System.out.println(Arrays.toString(s));
	}
}