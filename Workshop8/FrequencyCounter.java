import edu.princeton.cs.algs4.*;
import java.io.*;
import java.util.*;
/**
 *  The {@code FrequencyCounter} class provides a client for 
 *  reading in a sequence of words and printing a word (exceeding
 *  a given length) that occurs most frequently. It is useful as
 *  a test client for various symbol table implementations.
 *  <p>
 *  For additional documentation, see <a href="https://algs4.cs.princeton.edu/31elementary">Section 3.1</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
public class FrequencyCounter {

    // Do not instantiate.
    private FrequencyCounter() { 
    
    }

    /**
     * Reads in a command-line integer and sequence of words from
     * standard input and prints out a word (whose length exceeds
     * the threshold) that occurs most frequently to standard output.
     * It also prints out the number of words whose length exceeds
     * the threshold and the number of distinct such words.
     *
     * @param args the command-line arguments
     */
    
    public String[] parseFile(String filename) throws IOException {

        // create token1
        String token1 = "";

        // create Scanner inFile1
        Scanner inFile1 = new Scanner(new File(filename)); 

        List<String> temps = new ArrayList<String>();

        // while loop
        while (inFile1.hasNext()) {
            // find next line
            token1 = inFile1.next();
            temps.add(token1);
        }
        inFile1.close();

        String[] tempsArray = temps.toArray(new String[0]);

        /*
        for (String s : tempsArray) {
        System.out.println(s);
        }
        */
         

        return tempsArray;
    }
    
    
    public static void main(String[] args) {
        
        FrequencyCounter fc = new FrequencyCounter();
        
        //BST<String, Integer> bst = new BST<String, Integer>();
        
        RedBlackBST<String, Integer> bst = new RedBlackBST<String, Integer>();
                
        int distinct = 0;
        int words = 0;
        int inserts = 0;
        
        int minlen = Integer.parseInt(args[0]);
        
        String[] wordsFromText = new String[100000];
        
        
        try {
            wordsFromText = fc.parseFile("leipzig100k.txt");
        }
        catch(IOException ioe) {
            System.out.println("File name is wrong");
        }
        
        
        // compute frequency counts for BST
        for(int i = 0; i < 100; i++) {
            String key = wordsFromText[i];
            
            if (key.length() < minlen) continue;
            
            words++;
            
            if (bst.contains(key)) {
                bst.put(key, bst.get(key) + 1);
            }
            else {
                bst.put(key, 1);
                distinct++;
                inserts += bst.getCompareCount();
            }
            
        }
        
        int averageComparisons = inserts/distinct;
        
        
        // find a key with the highest frequency count for BST
        String max = "";
        bst.put(max, 0);
        
        for (String word : bst.keys()) {
            if (bst.get(word) > bst.get(max))
                max = word;
        }

        
        StdOut.println(max + " " + bst.get(max));
        StdOut.println("distinct = " + distinct);
        StdOut.println("words    = " + words);
        StdOut.println("average comparisons    = " + averageComparisons);
        StdOut.println();
        
    }
}
