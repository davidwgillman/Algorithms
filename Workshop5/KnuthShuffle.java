/* Shuffles an array of objects */

/* Shuffles an array of objects */

import edu.princeton.cs.algs4.Stopwatch;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import edu.princeton.cs.algs4.StdRandom;

public final class KnuthShuffle {

    /**
     * Rearranges the elements of the specified array in uniformly random order.
     *
     * @param  a the array to shuffle
     */
	public static void shuffle(int[] a) {
		// as a demo, this generates a random number from 0 to 9
		
		int j, temp; 
		for(int i = 0; i < a.length; i++) {
			j = StdRandom.uniform(0, i+1);
			temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			
		}
		// implement this
	}
	
	public static int[] GenerateArray(int N) {
		int[] inputArray = new int[N];
		for(int i = 0; i < N; i++) {
			inputArray[i] = i + 1;
		}
		return inputArray;
		
	}
	
	public static void printArray(int[] inarray) {
		for(int i = 0; i < inarray.length; i++) {
			System.out.println(inarray[i]);
		}
	}
	
	public static int ArrayCombo(int[] inarray) {
		int num = 0;
		
		for(int i = 0; i < inarray.length; i++) {
			
			if(i == 0) {
				num += inarray[i] * 1000;
			}
			else if(i == 1){
				num += inarray[i] * 100;
			}
			else if(i == 2) {
				num += inarray[i] * 10;
			}
			else if(i == 3) {
				num += inarray[i];
			}
			
		}
		
		return num;
	}
	

	public static void main(String[] args) {
		// implement this
		//int testarray[] = KnuthShuffle.GenerateArray(4);
		TreeMap<Integer, Integer> arraymap = new TreeMap();
		
		
		
		for(int i = 0; i < 2400; i++) {
			int testarray[] = KnuthShuffle.GenerateArray(4);
			KnuthShuffle.shuffle(testarray);
			int f = KnuthShuffle.ArrayCombo(testarray);
			
			if(arraymap.containsKey(f)) {
				int val = arraymap.get(f);
				val++;
				arraymap.put(f, val);
			}
			else {
				arraymap.put(f, 1);
			}
			
		}
		for (Entry<Integer, Integer> entry : arraymap.entrySet()) {
		     System.out.println("Key: " + entry.getKey() + ". Value: " + entry.getValue());
		}
		
	}
}