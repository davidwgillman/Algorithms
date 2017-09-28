/* Shuffles an array of objects */

import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.StdRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

public final class KnuthShuffle {

    /**
     * Rearranges the elements of the specified array in uniformly random order.
     *
     * @param  a the array to shuffle
     */
	public static void shuffle(int[] a) {
		// implement this
		for (int i = 0; i < a.length; i++) {
			int r = StdRandom.uniform(0,i+1);
			int temp = a[r];
			a[r] = a[i];
			a[i] = temp;
		}
	}

	public static int concatenation(int[] a) {
		int x = 0;

		for (int i = 0; i < a.length; i++) {
			if (i == 0) {
				x += a[i] * 1000;
			}
			else if (i == 1) {
				x += a[i] * 100;
			}
			else if (i == 2) {
				x += a[i] * 10;
			}
			else {
				x += a[i];
			}
		}

		return x;
	}

	public static void main(String[] args) {
		// implement this

		System.out.println("Question 3");

		int[] a = new int[1000000];

		for (int i = 0; i < 1000000; i++) {
			a[i] = i;
		}

		Stopwatch stopwatch1 = new Stopwatch();
		KnuthShuffle.shuffle(a);
		double time1 = stopwatch1.elapsedTime();
		System.out.println("1000000 input = " + time1);

		int[] b = new int[2000000];

		for (int i = 0; i < 2000000; i++) {
			b[i] = i;
		}

		Stopwatch stopwatch2 = new Stopwatch();
		KnuthShuffle.shuffle(b);
		double time2 = stopwatch2.elapsedTime();
		System.out.println("2000000 input = " + time2);

		int[] c = new int[4000000];

		for (int i = 0; i < 4000000; i++) {
			c[i] = i;
		}

		Stopwatch stopwatch3 = new Stopwatch();
		KnuthShuffle.shuffle(c);
		double time3 = stopwatch3.elapsedTime();
		System.out.println("4000000 input = " + time3);

		int[] d = new int[8000000];

		for (int i = 0; i < 8000000; i++) {
			d[i] = i;
		}

		Stopwatch stopwatch4 = new Stopwatch();
		KnuthShuffle.shuffle(d);
		double time4 = stopwatch4.elapsedTime();
		System.out.println("8000000 input = " + time4);

		System.out.println("Question 5");

		int[] e = new int[4];

		e[0] = 1;
		e[1] = 2;
		e[2] = 3;
		e[3] = 4;

		Map<Integer, Integer> outputs = new HashMap<Integer, Integer>();

		for (int i = 0; i < 2400; i++) {
			KnuthShuffle.shuffle(e);
			int tempArray = KnuthShuffle.concatenation(e);
			if (outputs.containsKey(tempArray)) {
				int val = outputs.get(tempArray);
				val++;
				outputs.put(tempArray, val);
			}
			else {
				outputs.put(tempArray, 1);
			}
		}

		for (Map.Entry<Integer, Integer> entry : outputs.entrySet()) {
			 System.out.println("Output = " + entry.getKey() + ", Count = " + entry.getValue());
		}
	}
}
