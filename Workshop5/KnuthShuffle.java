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
        
        for (int i = 1; i < N; i++) {
            int r = StdRandom.uniform(0, i+1);
            Object temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
	}

	public static void main(String[] args) {
        
        // Create new array of size N
        int N = 80000; // Input size; subject to change
        Integer cards[] = new Integer[N];
        
        for (int i = 0; i < N; i++) {
            cards[i] = StdRandom.uniform(0, N);
        }
        
        KnuthShuffle knuthShuffle = new KnuthShuffle();
        
        System.out.print("Unshuffled cards: ");
        for (int i = 0; i < cards.length; i++) {
            System.out.print(cards[i] + " ");
        }
        
        System.out.println(" ");
        
        Stopwatch stopwatch = new Stopwatch();
        knuthShuffle.shuffle(cards);
        
        // Calculate and output elapsed time
        double time = stopwatch.elapsedTime();
        
        System.out.print("Shuffled cards: ");
        for (int i = 0; i < cards.length; i++) {
            System.out.print(cards[i] + " ");
        }
        
        System.out.println(" ");
        System.out.println("Time passed: " + time);
	}
}
