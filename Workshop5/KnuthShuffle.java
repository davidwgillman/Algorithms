import java.util.ArrayList;
import java.util.Arrays;

import javax.tools.JavaCompiler;

/* Shuffles an array of objects */

public final class KnuthShuffle {
	public static void main(String[] args) {
		int[] ar1 = {1, 2, 3, 4};
		int count = 0;
		int[] ar_compare = new int[4];
		
		System.arraycopy(ar1, 0, ar_compare, 0, ar1.length);
		
		Stopwatch stpwtch = new Stopwatch();
		
		for (int i = 0; i < 2400; i++) {
			shuffle(ar1);
			if (Arrays.equals(ar1, ar_compare)) {
				count++;
			}
			System.arraycopy(ar1, 0, ar_compare, 0, ar1.length);
		}
		
		// print elapsed time
		StdOut.println("Elapsed Time: " + stpwtch.elapsedTime());
		StdOut.println("Arrays repeated: " + count + " times.");
	}
	
	public static void shuffle(int[] a) {
		// as a demo, this generates a random number from 0 to 9
		for (int x = 0; x < a.length - 1; x++) {
			int i = StdRandom.uniform(0,4); 
			int swap;
			swap = a[x];
			a[x] = a[i];
			a[i] = swap;
		}
	}
}