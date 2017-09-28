/* Shuffles an array of objects */

import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.StdRandom;

public final class KnuthShuffle {

    /**
     * Rearranges the elements of the specified array in uniformly random order.
     *
     * @param  a the array to shuffle
     */
	public static void shuffle(Integer[] a) {

        int N = a.length;
        
        for (int i = 0; i < N; i++) {
            Integer r = StdRandom.uniform(0,N);
            Integer temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
	}

	public static void main(String[] args) {
        
        // Create new array of size N
        Integer N = 10;
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
        knuthShuffle.shuffle(cards);
        
        System.out.print("Shuffled cards: ");
        for (int i = 0; i < cards.length; i++) {
            System.out.print(cards[i] + " ");
        }
        
        // Logs how long the process took
        Stopwatch stopwatch = new Stopwatch();
        double time = stopwatch.elapsedTime();
        
        System.out.println(" ");
        System.out.println("Time passed: " + time);
	}
}
