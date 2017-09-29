import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import edu.princeton.cs.algs4.StdRandom;

public class Distributions
{
    public static void main(String[] args){
        int [] original = new int[]{1,2,3,4};
        ArrayList<Integer> permutations = new ArrayList<Integer>();
        HashMap<Integer, Integer> repeatedLists = new HashMap<Integer, Integer>();
        permutations.add(concatenate(original));
        
        for(int n=0; n< 2400; n++){
            shuffle(original);
            concatenate(original);
            permutations.add(concatenate(original));
        }
        
        for(int n= 0; n < permutations.size(); n++){
            int entry = permutations.get(n);
            if(repeatedLists.containsKey(entry)){
                repeatedLists.put(entry, repeatedLists.get(entry) + 1);
            }
            else{
                repeatedLists.put(entry, 1);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(Map.Entry<Integer, Integer> item : repeatedLists.entrySet()){
            if(item.getValue() > 1){
                count += 1;
                sb.append("\n");
                sb.append(item.getKey());
                sb.append(": ");
                sb.append(item.getValue());
                sb.append(" instances");
            }
        }
    
        System.out.print(sb.toString());
    }
    
    public static void shuffle(int [] toBeShuffled){
        for(int n = 1; n < toBeShuffled.length; n++){
            int randomSpot = StdRandom.uniform(0, n+1);
            int assignSpot = toBeShuffled[n];
            toBeShuffled[n] = toBeShuffled[randomSpot];
            toBeShuffled[randomSpot] = assignSpot;
        }
    }
    
    public static int concatenate(int [] concatenateThis){
        int thousands = 0;
        int hundreds = 0;
        int tens = 0;
        int ones = 0;
        for( int n=0; n < concatenateThis.length; n++){
            if(n==0){
                thousands = concatenateThis[n] * (1000);
            }
            else if(n==1){
                hundreds = concatenateThis[n] * (100);
            }
            else if(n==2){
                tens = concatenateThis[n] * (10);
            }
            else if(n==3){
                ones = concatenateThis[n] * (1);
            }
        }
        int concatenation = thousands + hundreds + tens + ones;
        return concatenation;
    }
}
