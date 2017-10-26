import edu.princeton.cs.algs4.StdRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ProblemFiveShuffling{
    public static void main(String[] args){
        int[] array = new int[]{1,2,3,4};
        int count = 0; 
        ArrayList<Long> combinations = new ArrayList<Long>();
        HashMap<Long, Integer> repetitions = new HashMap<Long, Integer>();
        combinations.add(makeOneNumber(array));
        for (int i = 0; i < 2400; i++) {
            shuffle(array);
            long shuffledArray = makeOneNumber(array);
            combinations.add(shuffledArray);
        }
        
        for(int i = 0; i < combinations.size(); i++){
            long item = combinations.get(i);
            if(repetitions.containsKey(item)){
                repetitions.put(item, repetitions.get(item) + 1);
            }
            else{
                repetitions.put(item, 1);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        int overallCount = 0;
        for(Map.Entry<Long, Integer> entry : repetitions.entrySet()){
            if (entry.getValue() >1){
                overallCount += 1;
                sb.append("\n");
                sb.append(entry.getKey());
                sb.append(": ");
                sb.append(entry.getValue());
                sb.append(" times");
            }
        }
        
        if (overallCount > 0) {
            sb.insert(0, " repeated numbers:");
            sb.insert(0, overallCount);
            sb.insert(0, "There are ");
        }

        System.out.print(sb.toString());
    }
  
    public static void shuffle(int[] a) {
		for(int n = 1; n < a.length; n++){
			int r = StdRandom.uniform(0, n); 
			int swappedElem = a[n];
			a[n] = a[r];
			a[r] = swappedElem;
		}
	}
	
	public static long makeOneNumber(int[] nums){
        StringBuilder strBigNum = new StringBuilder();
        for (int n : nums){
            strBigNum.append(n);
        }
        long bigNum = 0;
        long factor = 1;
        for (int i = strBigNum.length()-1; i >= 0; i--) {
            bigNum += Character.digit(strBigNum.charAt(i), 10) * factor;
            factor *= 10;
        }
        return bigNum;
    }
}
