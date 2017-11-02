/******************************************************************************
 *  Compilation:  javac DoubleHashST.java
 *  Execution:    java DoubleHashST < input.txt
 *  Dependencies: StdIn.java StdOut.java
 *  Data files:   https://algs4.cs.princeton.edu/34hash/tinyST.txt
 *  
 *  Symbol-table implementation with double hash table.
 *
 ******************************************************************************/

import edu.princeton.cs.algs4.StdIn
import edu.princeton.cs.algs4.StdOUt
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
     * Initializes an empty symbol table with initial capacity of 4
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
        n = new int[2];
        keys = new Key[2][]; // size of 2
        vals = new Value[2][];
        
        m = capacity;
        n[0] = 0;
        n[1] = 0;

        for (int j = 0; j < 2; j++) {
            keys[j] = (Key[])   new Object[m];
            vals[j] = (Value[]) new Object[m];            
        }

        Random rnd = new Random();
        a[0] = rnd.nextInt()&0x7fffffff;
        a[1] = rnd.nextInt()&0x7fffffff;        
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

        // double size of both tables if the fuller one is 50% full 
        if ((n[0] >= m/2) || (n[1] >= m/2)) {
            resize(2*m);
        }

        int j; // the table
        int i; // the index
        Key collisionKey;
        Value collisionValue;
        Key[] cycle;

        /* Fill in.
        *  Write insertion code that follows the description at the top of this file.
        *  Rehash using rehash()   
        *  Trick for switching tables: j = 1-j.
        */

        if (n[0] > n[1]) {
            j = 1;
        } else {
            j = 0;
        }

        i = hash(key, j);

        if ((keys[j][i] != null) && (vals[j][i] != null)) {
            collisionKey = keys[j][i];
            collisionValue = keys[j][i];

            this.rehash();
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

        // Fill in. 
        // Try to find the key in each table.

        for (int i = 0; i < n; i++) {
            if (keys[0][i] == key) {
                return vals[0][i];
            } else if (keys[1][i] == key) {
                return vals[1][i];
            }
        }
        // If it's not there:
        return null;
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

        // Fill in: find position i of key in table j
        // After finding the key, delete it and associated value 
        // Decrement the size of table j
        for (int i = 0; i < n; i++) {
            if (keys[0][i] == key) {
                keys[0][i] = null;
                vals[0][i] = null;
                n[0]--;
            } else if (keys[1][i] == key) {
                keys[1][i] = null;
                vals[1][i] = null;
                n[1]--;
            }
        }
 
        // Then halve the size of both arrays if the fuller one is 1/8 full or less
        if (/*Fill in: arrays are not empty but they are too small*/) resize(m/2);

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
                if (keys[i] != null) queue.enqueue(keys[i]);
            }
        }
        return queue;
    }

    // integrity check 
    // integrity not maintained during a delete()
    private boolean check() {

        // check that hash tables are at most 50% full
        if (n[0] > m[0]/2 || n[1] > m[1]/2)  {
            System.err.println("Hash table size m = " + m + "; array size n = " + n);
            return false;
        }

        // check that each key in table can be found by get()
        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < m; i++) {
                if (keys[j][i] == null) continue;
                else if (get(keys[j][i]) != vals[j][i]) {
                    System.err.println("get[" + keys[i] + "] = " + get(keys[i]) + "; vals[i] = " + vals[i]);
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
        }

        // print keys
        for (String s : st.keys()) 
            StdOut.println(s + " " + st.get(s)); 
    }
}

/******************************************************************************
 *  Copyright 2002-2016, Robert Sedgewick and Kevin Wayne.
 *
 *  This file is part of algs4.jar, which accompanies the textbook
 *
 *      Algorithms, 4th edition by Robert Sedgewick and Kevin Wayne,
 *      Addison-Wesley Professional, 2011, ISBN 0-321-57351-X.
 *      http://algs4.cs.princeton.edu
 *
 *
 *  algs4.jar is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  algs4.jar is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with algs4.jar.  If not, see http://www.gnu.org/licenses.
 ******************************************************************************/