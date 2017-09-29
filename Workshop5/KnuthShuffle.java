/* Shuffles an array of objects */

import edu.princeton.cs.algs4.Knuth;
import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.StdRandom;
import java.util.HashMap;
import java.util.Map;

public final class KnuthShuffle {

    /**
     * Rearranges the elements of the specified array in uniformly random order.
     *
     * @param  a the array to shuffle
     */
	public static void shuffle(Object[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            // choose index uniformly in [i, n-1]
            int idx = i + (int) (StdRandom.uniform() * (n - i));
            Object temp = a[idx];
            a[idx] = a[i];
            a[i] = temp;
        }
	}

    /* Helper static array factory. Takes the size as parameter
	returns an array inflated with random numbers.
*/
    
    public static Object[] generateArray(int size){
        Integer[] numbers = new Integer[size];
        for(int i=0; i<size; i++){
            numbers[i] = StdRandom.uniform(1,size);
        }
        return numbers;
    }

	public static void main(String[] args) {
        Object[] testArray = generateArray(8000000 );

        Stopwatch chronometer = new Stopwatch();
        KnuthShuffle.shuffle(testArray);
        System.out.print(chronometer.elapsedTime()*1000); 
	}
}