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
			int r = StdRandom.uniform(0,i+1);
			//swap a[i] and a[r]
			Object x=a[i];
			a[i]=a[r];
			a[r]=x;
		}
	}

	public static void main(String[] args) {
		final int n=8000000;
		System.out.println("Running with array of "+n+" size!");
		double sum=0;
		for(int i=0;i<10;i++)
			sum+=shuffler(n);
		double avg=sum/10;
		System.out.println("Avg time: "+avg);
	}
	public static double shuffler(int n){
		Integer[] s=new Integer[n];
		for(int i=0;i<n;i++){
			s[i]=i;
		}
		//System.out.println(Arrays.toString(s));
		Stopwatch stopwatch=new Stopwatch();
		shuffle(s);
		double time=stopwatch.elapsedTime();
		//System.out.println(time);
		//System.out.println(Arrays.toString(s));
		return time;
	}
}