/* Shuffles an array of objects */

import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public final class Shuffle1234 {

    /**
     * Rearranges the elements of the specified array in uniformly random order.
     *
     * @param  a the array to shuffle
     */
	static int arreh[] = new int[4];
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
	
	public static void populate(){
		arreh[0] = 1;
		arreh[1] = 2;
		arreh[2] = 3;
		arreh[3] = 4;
	}

	public static Integer translate(int[] c){ 
		int number = 0;
		number += c[0] * 1000;
		number += c[1] * 100;
		number += c[2] * 10;
		number += c[3] * 1;
		
		return number;
	}

	public static void main(String[] args) {
		TreeMap<Integer, Integer> combinations = new TreeMap();

		for(int i = 0; i <= 24000; i++) {
			Shuffle1234.populate();
			Shuffle1234.shuffle(arreh);
			int num = Shuffle1234.translate(arreh);
			
			if(combinations.containsKey(num)) {
				int counter = combinations.get(num);
				counter++;
				combinations.put(num, counter);
			}
			else {
				combinations.put(num, 1);
			}
		}
		
		for(Entry<Integer, Integer> counts: combinations.entrySet()) {
			System.out.println("Combination: " + counts.getKey() + " Count: " + counts.getValue());
		}
	}
}
