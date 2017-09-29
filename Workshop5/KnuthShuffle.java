/* Shuffles an array of objects */

import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.StdRandom;
import java.util.ArrayList;
import java.lang.Math;

public final class KnuthShuffle {

    /**
     * Rearranges the elements of the specified array in uniformly random order.
     *
     * @param  a the array to shuffle
     */
	public static void shuffle(Object[] a) {
		int r;
		for(int i = 0; i < a.length; i++){
			//this generates a random number from 0 to i
			r = StdRandom.uniform(0,i+1); 
			if(r==i) continue;
			else{
				Object temp = a[i];
				a[i] = a[r];
				a[r] = temp;
			}
		}
	}

	public static void trial(Object[] a, int trialNum){
		int currentTrial = trialNum+1;

	    Stopwatch stopwatch = new Stopwatch();

		shuffle(a);

		double time = stopwatch.elapsedTime();
		System.out.println(a.length+" Trial "+currentTrial+" Time:\t" + time);

		if(currentTrial<3){
			trial(a, currentTrial);
		}
	}

	public static void part3(int N){
		for(int i = 0; i<4; i++){
			Object[] a = new Object[N*(int)Math.pow(2,i)];
    		for (int j = 0; j < N; j++) {
        		a[j] = j;
   			}

   			trial(a, 0);
		}
	}

	public static String stringArray(Object[] a){
		StringBuilder s = new StringBuilder();
		for(Object o : a){
			s.append(o);
		}
		return s.toString();
	}

	public static void part5(){

		ArrayList<String> outcomes = new ArrayList<String>();
		ArrayList<Integer> recursions = new ArrayList<Integer>();

		for(int i = 0; i<2400; i++){
			Object[] a = {1,2,3,4};
			shuffle(a);
			String output = stringArray(a);

			if(outcomes.contains(output)){
				int j = outcomes.indexOf(output);
				recursions.set(j, recursions.get(j)+1);
			}
			else{
				outcomes.add(output);
				recursions.add(1);
			}
		}

		for(int i = 0; i<outcomes.size(); i++){
			System.out.println(outcomes.get(i)+":\t"+recursions.get(i));
		}
	}

	public static void main(String[] args) {
		int option = Integer.parseInt(args[0]);
		if(option == 3){part3(1000000);} 
		else {part5();}
    }
}