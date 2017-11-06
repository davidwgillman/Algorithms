/* Shuffles an array of objects */
import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.StdRandom;
import java.util.*;
import java.lang.Math;

public final class KnuthShuffle {
    /**
     * Rearranges the elements of the specified array in uniformly random order.
     *
     * @param  a the array to shuffle
     */
    public static void shuffle(Object[] a) {

        // as a demo, this generates a random number from 0 to 9
        //int i = StdRandom.uniform(0,10); 

        for(int c = 1; c < a.length; c++) {

            int r = StdRandom.uniform(0, c);

            Object temp = a[c];

            a[c] = a[r];

            a[r] = temp;

        }

        // implement this
    }

    public static String[] createArray(int size) {
        String[] arr = new String[size]; 
        for (int i = 0; i < size - 1; i++) {

            String x = Integer.toString(i);

            arr[i] = x;

        }
        return arr;
    }

    public static String convertToString(Object[] a){
        
        StringBuilder s = new StringBuilder();
        
        for(int q = 0; q < a.length; q++) {
            s.append(a[q]);
        }
        
        return s.toString();  
    }
    

    public static void main(String[] args) {
        //first create a array of a specific size
        String[] array = createArray(10000);

        Stopwatch stopwatch = new Stopwatch();

        shuffle(array);

        double time = stopwatch.elapsedTime();
        System.out.println("The time is: " + time);

        
        ///below code is for Question 5 ///

        ArrayList<String> permutations = new ArrayList<String>();
        
        ArrayList<Integer> frequencies = new ArrayList<Integer>();
        

        //do 2400 times
        for(int i = 0; i < 2400; i++){

            Object[] input = {1,2,3,4};

            //a shuffle on a predetermined input
            shuffle(input);

            //convert it to string so comparisons are easier
            String output = convertToString(input);

            //check for matches
            if(permutations.contains(output) == true){
                frequencies.set(permutations.indexOf(output), 
                frequencies.get(permutations.indexOf(output)) + 1);
            }
            else{
                permutations.add(output);
                frequencies.add(1);
            }
        }
        
        System.out.println(permutations.size());

        //for every match, print frequency.
        for(int i = 0; i < permutations.size(); i++){
            System.out.println(permutations.get(i)+":\t"+ frequencies.get(i));
        }

    }

    
} 

