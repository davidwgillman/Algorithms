
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

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
    public static void main(String[] args)  throws FileNotFoundException {
        int distinct = 0, words = 0;
        int minlen = Integer.parseInt(args[0]);
        DoubleHashST<String, Integer> st = new DoubleHashST<String, Integer>();
        double count = 0;
        double averages = 0;
        
        PrintWriter Saver = new PrintWriter(new File("data.csv"));
        StringBuilder Builder = new StringBuilder();
        
        while (!StdIn.isEmpty()) {
        	if(words == 14350) {
        		break;
        	}
            String key = StdIn.readString();
            if (key.length() < minlen) continue;
            words++;
            if (st.contains(key)) {
            	
                st.put(key, st.get(key) + 1);
                count += st.getCompCounter();
                Builder.append(words);
                Builder.append(", ");
                Builder.append(count/words);
                Builder.append(", ");
                if(st.isRehashed()) {
                	Builder.append("1");
                }
                else {
                	Builder.append("0");
                }
                Builder.append(", ");
                if(st.isResized()) {
                	Builder.append("1");
                }
                else {
                	Builder.append("0");
                }
                	Builder.append('\n');
            }
            else {
            	st.put(key, 1);
                count += st.getCompCounter();
                Builder.append(words);
                Builder.append(", ");

                Builder.append(count/words);
                Builder.append(", ");
                if(st.isRehashed()) {
                	Builder.append(count/words);
                }
                else {
                	Builder.append("0");
                }
                Builder.append(", ");
                if(st.isResized()) {
                	Builder.append(count/words);
                }
                else {
                	Builder.append("0");
                }
                Builder.append('\n');
            }
         
            st.setCompCounter(0);
        	st.setRehashed(false);
        	st.setResized(false);
        }

        Saver.write(Builder.toString());
        Saver.close();
        
        StdOut.println("words    = " + words);
        StdOut.println("size = " + st.size());
        StdOut.println("average comparisons = " + count/words);
    }
}