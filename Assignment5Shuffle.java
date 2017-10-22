// Mimi Chenyao
// Algorithms Assignment 5 shuffle

import java.util.Random;
import java.util.Arrays;

public class Assignment5Shuffle {

    Float[] generateRandomAssociatedValues(int[] actualValues) {

        Float[] associatedValues = new Float[actualValues.length]; 
        Random random = new Random();

        for (int i = 0; i < actualValues.length; i++) {
        	associatedValues[i] = random.nextFloat();
        }

        System.out.print("Actual values: ");
        for (int i = 0; i < actualValues.length; i++) {
        	System.out.print(actualValues[i] + " ");
        }

        System.out.println("");

        System.out.print("Associated values: ");
        for (int i = 0; i < associatedValues.length; i++) {
        	System.out.print(associatedValues[i] + " ");
        }

        System.out.println("");

        return associatedValues;
    }

    void shuffleBasedOnAssociatedValues(int[] actualValues, Float[] associatedValues) {

    	System.out.println("Unshuffled array: " + Arrays.toString(actualValues));

        int counter = 0;
        for(int i = 0; i < associatedValues.length; i++) {
            for(int j = 1; j < associatedValues.length - 1; j++) {
                if (associatedValues[i] > associatedValues[j]) {
                    counter ++;

                    int swap = actualValues[i];
                    actualValues[i] = actualValues[j];
                    actualValues[j] = swap;
                }
            }
        }
       
        System.out.println("Shuffled array: " + Arrays.toString(actualValues));
    }

    public static void main(String[] args) {

    	Assignment5Shuffle test = new Assignment5Shuffle();

    	// int[] actualValuesTest = { 1, 2, 3, 4, 5, 6, 7, 8 };

        int N = 256000; // Input size; subject to change
        int cards[] = new int[N];

        Random random = new Random();
        
        for (int i = 0; i < N; i++) {
            cards[i] = random.nextInt(9);
        }

    	long startTime = System.currentTimeMillis();

    	Float[] associatedValuesTest = test.generateRandomAssociatedValues(cards);
    	test.shuffleBasedOnAssociatedValues(actualValuesTest, associatedValuesTest);

    	long endTime = System.currentTimeMillis();
    	long totaltime = endTime - startTime;
    	System.out.println("Time taken: " + totaltime + " milliseconds");
    }
}
