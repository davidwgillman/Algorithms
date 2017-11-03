/******************************************************************************
 *  Compilation:  javac DoubleHashST.java
 *  Execution:    java DoubleHashST < input.txt
 *  Dependencies: StdIn.java StdOut.java
 *  Data files:   https://algs4.cs.princeton.edu/34hash/tinyST.txt
 *  
 *  Symbol-table implementation with double hash table.
 *
 ******************************************************************************/

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Queue;
import java.util.ArrayList;
import java.util.Random;

// Insert any other import statements for classes needed from edu.princeton.cs.algs4

/**
 *  The {@code DoubleHashST} class represents a symbol table of generic
 *  key-value pairs.
 *  It supports the usual <em>put</em>, <em>get</em>, <em>contains</em>,
 *  <em>delete</em>, <em>size</em>, and <em>is-empty</em> methods.
 *  It also provides a <em>keys</em> method for iterating over all of the keys.
 *  A symbol table implements the <em>associative array</em> abstraction:
 *  when associating a value with a key that is already in the symbol table,
 *  the convention is to replace the old value with the new value.
 *  Unlike {@link java.util.Map}, this class uses the convention that
 *  values cannot be {@code null}—setting the
 *  value associated with a key to {@code null} is equivalent to deleting the key
 *  from the symbol table.
 *  <p>
 *  This implementation uses two hash tables, each with its own hash function. 
 *  Any given key is in one of the two tables but not both.
 *
 *  Inserting a new key works like this:
 *  1. Hash the new key to the table with fewer elements.
 *  2. If the table position is occupied, evict that key and replace it with the new key, and
 *     hash the old key into the other table (again evicting a key that might reside there).
 *  3. Keep evicting keys and hashing them to the other table until either
 *     a. there's no collision, and the insertion is finished
 *     b. there's a cycle (the same key gets kicked out twice); in this case, rehash both tables
 *  
 *  This implementation requires that the key type override the {@code equals()} and 
 *  {@code hashCode()} methods.
 *  
 *  This code is modified from LinearProbingHashST.java by Robert Sedgewick and Kevin Wayne.
 */
public class DoubleHashST<Key, Value> {
    private static final int INIT_CAPACITY = 4;

    private int[] n;           // number of key-value pairs in each hash table
    private int m;             // size of each hash table
    private Key[][] keys;      // the keys
    private Value[][] vals;    // the values

    private int[] a;           // random hash parameter

    /**
     * Initializes an empty symbol table.
     */
    public DoubleHashST() {
        this(INIT_CAPACITY);
    }

    /**
     * Initializes an empty symbol table with the specified initial capacity.
     *
     * @param capacity the initial capacity
     */
    public DoubleHashST(int capacity) {
        this.n = new int[2];
        this.keys = (Key[][]) new Object[2][];
        this.vals = (Value[][]) new Object[2][];
        
        this.m = capacity;
        this.n[0] = 0;
        this.n[1] = 0;

        for (int j = 0; j < 2; j++) {
            this.keys[j] = (Key[])   new Object[m];
            this.vals[j] = (Value[]) new Object[m];            
        }

        Random rnd = new Random();
        this.a = new int[2];
        this.a[0] = rnd.nextInt() & 0x7fffffff;
        this.a[1] = rnd.nextInt() & 0x7fffffff;        
   }

    /**
     * Returns the number of key-value pairs in this symbol table.
     *
     * @return the number of key-value pairs in this symbol table
     */
    public int size() {
        return n[0] + n[1];
    }

    /**
     * Returns true if this symbol table is empty.
     *
     * @return {@code true} if this symbol table is empty;
     *         {@code false} otherwise
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns true if this symbol table contains the specified key.
     *
     * @param  key the key
     * @return {@code true} if this symbol table contains {@code key};
     *         {@code false} otherwise
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }

    // hash function for keys - returns value between 0 and M-1
    // if M = 2^(32-h) the formula is (a * abs(hashcode) mod 2^32) / 2^h
    private int hash(Key key, int k) {
        long l = key.hashCode() & 0x7fffffff; // 0 to 2^31 - 1, like abs(hashcode) but bug-free
        l = (a[k] * l) % 4294967296L; // 0 to 2^32 - 1
        return (int) (l * m / 4294967296L); // 0 to M - 1
    }

    // resizes the hash table to the given capacity by re-hashing all of the keys
    // keep same size n and hash a
    private void resize(int capacity) {
        DoubleHashST<Key, Value> temp = new DoubleHashST<Key, Value>(capacity);
        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < m; i++) {
                 if (keys[j][i] != null) {
                    temp.put(keys[j][i], vals[j][i]);
                }
            }
        }
        keys = temp.keys;
        vals = temp.vals;
        m    = temp.m;
    }


    // rehashes the hash table with new hash a
    // keep same size n and capacity m
    private void rehash() {
        DoubleHashST<Key, Value> temp = new DoubleHashST<Key, Value>(m);
        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < m; i++) {
                 if (keys[j][i] != null) {
                    temp.put(keys[j][i], vals[j][i]);
                }
            }
        }
        keys = temp.keys;
        vals = temp.vals;
        a = temp.a;
    }

    /**
     * Inserts the specified key-value pair into the symbol table, overwriting the old 
     * value with the new value if the symbol table already contains the specified key.
     * Deletes the specified key (and its associated value) from this symbol table
     * if the specified value is {@code null}.
     *
     * Fill in this code according to the description at the top of the file.
     *
     * @param  key the key
     * @param  val the value
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("first argument to put() is null");

        if (val == null) {
            delete(key);
            return;
        }

        int indexOfMax = 0;
        
        if(n[0]>n[1]){
            indexOfMax = 0;
        }

        else if(n[1]>n[0]){
            indexOfMax = 1;
        }

        else{
            Random r = new Random();
            indexOfMax = r.nextInt(2);
        }

        if (n[indexOfMax] >= m/2){
            resize(2*m);
        }

        int j = 1 - indexOfMax; // the table
        int i = hash(key, j); // the index
        ArrayList<Key> collisionKeyList = new ArrayList<Key>();

        Key collisionKey = key;
        Value collisionVal = val;

        System.out.println("We are looking at " + key);
        while(keys[j][i] != null){
            if(collisionKeyList.contains(collisionKey)){
                System.out.println("rehashing!");
                rehash();
                break;
            }
            else if(keys[j][i].equals(key)){
                vals[j][i] = val;
                System.out.println(key + " already exists!");
                return;
            }
            else{
                System.out.println("a collision has occurred already exists!");
                collisionKey = keys[j][i];
                collisionVal = vals[j][i];
                j = 1-j;
                i = hash(collisionKey, j);
                keys[j][i] = collisionKey;
                vals[j][i] = collisionVal;
                collisionKeyList.add(collisionKey);
            }
        }

        // After finding a place for the key:
        keys[j][i] = key;
        vals[j][i] = val;
        n[j]++;
    }

    /**
     * Returns the value associated with the specified key.
     * @param key the key
     * @return the value associated with {@code key};
     *         {@code null} if no such value
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to get() is null");
        int j = 0;
        int i = hash(key, j);

        if (keys[j][i] != null && keys[j][i].equals(key)){
            System.out.println("The value of " + key + " is " + vals[j][i]);
            return vals[j][i];
        }

        else if(keys[1-j][i] != null && keys[1-j][i].equals(key)){
            return vals[1-j][i];
        }

        else{
            System.out.println("Couldn't find the value of " + key);
            return null;
        }
    }

    /**
     * Removes the specified key and its associated value from this symbol table     
     * (if the key is in this symbol table).    
     *
     * @param  key the key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to delete() is null");
        if (!contains(key)) return;
        int j = 0;
        int i = hash(key, j);
        if (keys[j][i] != null && keys[j][i].equals(key)){
            keys[j][i] = null;
            vals[j][i] = null;
            n[j]--;
        }
        else if(keys[1-j][i] != null && keys[1-j][i].equals(key)){
            keys[1-j][i] = null;
            vals[1-j][i] = null;
            n[j]--;
        }

        int indexOfMax = -1;
        if(n[0]>n[1]){
            indexOfMax = 0;
        }
        else{
            indexOfMax = 1;
        }

        if (n[indexOfMax] > 0 && n[indexOfMax] <= m/8){
            resize(m/2);
        }

        assert check();
    }

    /**
     * Returns all keys in this symbol table as an {@code Iterable}.
     * To iterate over all of the keys in the symbol table named {@code st},
     * use the foreach notation: {@code for (Key key : st.keys())}.
     *
     * @return all keys in this symbol table
     */
    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < m; i++) {
                if (keys[j][i] != null) queue.enqueue(keys[j][i]);
            }
        }
        return queue;
    }

    // integrity check 
    // integrity not maintained during a delete()
    private boolean check() {

        // check that hash tables are at most 50% full
        if (n[0] > n[0]/2 || n[1] > n[1]/2)  {
            System.err.println("Hash table size m = " + m + "; array size n = " + n);
            return false;
        }

        // check that each key in table can be found by get()
        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < m; i++) {
                if (keys[j][i] == null) continue;
                else if (get(keys[j][i]) != vals[j][i]) {
                    System.err.println("get[" + keys[j][i] + "] = " + get(keys[j][i]) + "; vals[i] = " + vals[j][i]);
                    return false;
                }
            }
        }
        return true;
    }


    /**
     * Unit tests the {@code DoubleHashST} data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) { 
        DoubleHashST<String, Integer> st = new DoubleHashST<String, Integer>();
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
            System.out.println("done with this loop and added " + key);
        }

        // print keys
        for (String s : st.keys()) 
            StdOut.println(s + " " + st.get(s)); 
        StdOut.println("size is " + st.size()); 
    }
}