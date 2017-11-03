import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

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
     * @throws FileNotFoundException 
     */
    public static void main(String[] args) throws FileNotFoundException {
        int distinct = 0, words = 0;
        double averages = 0;
        int minlen = Integer.parseInt(args[0]);
        DoubleHashST<String, Integer> st = new DoubleHashST<String, Integer>();
        
        PrintWriter pw = new PrintWriter(new File("test.csv"));
        StringBuilder sb = new StringBuilder();
        
        sb.append("Put");
        sb.append(", ");
        sb.append("Average");
        sb.append(", ");
        sb.append("Rehash");
        sb.append(", ");
        sb.append("Resize");
        sb.append('\n');
        

        // compute frequency counts
        while (!StdIn.isEmpty()) {
        	
            String key = StdIn.readString();
            if (key.length() < minlen) continue;
            words++;
            if (st.contains(key)) {
            	
                st.put(key, st.get(key) + 1);
                //System.out.println("average before contains" + averages);
                averages += st.getComparisons();
                //System.out.println("average after contains" + averages);
                
                sb.append(words);
                sb.append(", ");
                //System.out.println((double)averages/words);
                sb.append(averages/words);
                sb.append(", ");
                if(st.isRehash()) {
                	sb.append("TRUE");
                }
                else {
                	sb.append("FALSE");
                }
                sb.append(", ");
                if(st.isResize()) {
                	sb.append("TRUE");
                }
                else {
                	sb.append("FALSE");
                }
                sb.append('\n');
                
                
            }
            else {
            	st.put(key, 1);
            	//System.out.println("average before" + averages);
                averages += st.getComparisons();
                //System.out.println("average after" + averages);
                sb.append(words);
                sb.append(", ");
                
                
                //System.out.println("words " + words);
                sb.append(averages/words);
                sb.append(", ");
                if(st.isRehash()) {
                	sb.append("TRUE");
                }
                else {
                	sb.append("FALSE");
                }
                sb.append(", ");
                if(st.isResize()) {
                	sb.append("TRUE");
                }
                else {
                	sb.append("FALSE");
                }
                sb.append('\n');
                
                distinct++;
            }
         
            st.setComparisons(0);
        	st.setRehash(false);
        	st.setResize(false);
        	if (words == 14350) break;
        }
        System.out.println("hi");
        pw.write(sb.toString());
        pw.close();
        // find a key with the highest frequency count
        String max = "";
        st.put(max, 0);
        for (String word : st.keys()) {
            if (st.get(word) > st.get(max))
                max = word;
        }

        //StdOut.println(max + " " + st.get(max));
        StdOut.println("distinct = " + distinct);
        StdOut.println("words    = " + words);
    }
}
