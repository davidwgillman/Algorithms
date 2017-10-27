import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

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
    private FrequencyCounter() { }

    /**
     * Reads in a command-line integer and sequence of words from
     * standard input and prints out a word (whose length exceeds
     * the threshold) that occurs most frequently to standard output.
     * It also prints out the number of words whose length exceeds
     * the threshold and the number of distinct such words.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        int distinct = 0, words = 0;
        double comparisoncount = 0, RBcomparisoncount = 0;
        int N = 10;
        int minlen = Integer.parseInt(args[0]);
        BST<String, Integer> bst = new BST<String, Integer>();
        RedBlackBST<String, Integer> RBbst = new RedBlackBST<String, Integer>();
        

        // compute frequency counts
        while (!StdIn.isEmpty()) {
            String key = StdIn.readString();
            if (key.length() < minlen) continue;
            words++;
            if (bst.contains(key)) {
                bst.put(key, bst.get(key) + 1);
                RBbst.put(key, RBbst.get(key) + 1);
            }
            else {
            	
            	bst.setComparisoncount(0);
                bst.put(key, 1);
                comparisoncount += bst.getComparisoncount();
                
                RBbst.setComparisoncount(0);
                RBbst.put(key, 1);
                RBcomparisoncount += RBbst.getComparisoncount();
                
                distinct++;
                if(distinct == N) {
                	break;
                }
            }
        }
        
        // find a key with the highest frequency count
        String max = "";
        bst.put(max, 0);
        RBbst.put(max, 0);
        
        for (String word : bst.keys()) {
            if (bst.get(word) > bst.get(max))
                max = word;
        }
       
        System.out.println("Binary Search Tree");
        StdOut.println(max + " " + bst.get(max));
        StdOut.println("distinct = " + distinct);
        StdOut.println("words    = " + words);
        StdOut.println("size    = " + (bst.size() - 1));
        StdOut.println("comparison count    = " + comparisoncount);
        StdOut.println("comparison count average    = " + (comparisoncount/distinct));
       ;
        
        
        System.out.println("\nRed Black Tree");
        StdOut.println(max + " " + RBbst.get(max));
        StdOut.println("distinct = " + distinct);
        StdOut.println("words    = " + words);
        StdOut.println("size    = " + (RBbst.size() - 1));
        StdOut.println("comparison count    = " + RBcomparisoncount);
        StdOut.println("comparison count average    = " + (RBcomparisoncount/distinct));
        
    }
}

