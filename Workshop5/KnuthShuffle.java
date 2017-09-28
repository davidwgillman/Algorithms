/* Shuffles an array of objects */

import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.StdRandom;

public final class KnuthShuffle {

    /**
     * Rearranges the elements of the specified array in uniformly random order.
     *
     * @param  a the array to shuffle
     */
	static int ary10[] = new int[1000000];
	static int ary20[] = new int[2000000];
	static int ary40[] = new int[4000000];
	static int ary80[] = new int[8000000];
	static int temp = 0;
	static int j;

	public static void shuffle(int[] a) {
		// as a demo, this generates a random number from 0 to 9
		for(int i = 0; i < a.length; i++){
			j  = StdRandom.uniform(0,i+1);
			temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		} 
		// implement this
	}
	
	public static void populate(int[] b){
		for(int t = 0; t < b.length; t++){
			b[t] = t;
		}
	}

	public static void print(int[] c){
		for(int y = 0; y < c.length; y++){
			System.out.println(c[y] + ", ");
		}
	}

	public static void main(String[] args) {
		// implement this
		KnuthShuffle.populate(ary10);
		KnuthShuffle.populate(ary20);
		KnuthShuffle.populate(ary40);
		KnuthShuffle.populate(ary80);
		
		Stopwatch t10 = new Stopwatch();
		KnuthShuffle.shuffle(ary10);
		double time1 = t10.elapsedTime();
		System.out.println(time1);

		Stopwatch t20 = new Stopwatch();	
		KnuthShuffle.shuffle(ary20);
		double time2 = t20.elapsedTime();
		System.out.println(time2);

		Stopwatch t40 = new Stopwatch();
		KnuthShuffle.shuffle(ary40);
		double time3 = t40.elapsedTime();
		System.out.println(time3);

		Stopwatch t80 = new Stopwatch();
		KnuthShuffle.shuffle(ary80);
		double time4 = t80.elapsedTime();
		System.out.println(time4);
		

	}
}
