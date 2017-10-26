1. BST.java testing new 'count' and 'new' functions on tinyST.txt
Input:
tinyST.txt

Output:
S: count=0 new=true
E: count=1 new=true
A: count=2 new=true
R: count=2 new=true
C: count=3 new=true
H: count=3 new=true
E: count=2 new=false
X: count=1 new=true
A: count=3 new=false
M: count=4 new=true
P: count=5 new=true
L: count=5 new=true
E: count=2 new=false

A 8
C 4
E 12
H 5
L 11
M 9
P 10
R 3
S 0
X 7

2./3. Number of Comparisons Using BST
Input:
8 N=100 leipzig100K.txt
Output:
compares: 1.06
46-second 1
distinct = 23
words    = 23

Input:
8 N=1000 leipzig100K.txt
Output:
compares: 1.889
executive 2
distinct = 212
words    = 216

Input:
8 N=10000 leipzig100K.txt
Output:
compares: 2.1773
government 17
distinct = 1684
words    = 2123

4. Number of Comparisons Using RedBlackBST
Input:
8 N=100 leipzig100k.txt
Output:
compares: 0.81
46-second 1
distinct = 23
words    = 23

Input:
8 N=1000 leipzig100K.txt
Output:
compares: 1.381
executive 2
distinct = 212
words    = 216

Input:
8 N=10000 leipzig100K.txt
Output:
compares: 1.6096
government 17
distinct = 1684
words    = 2123

5. The rate of growth appears to be about log n.

6. 1. Completely random input would make duplicates much less common.

   2. The RedBlackTree was less deep which is why it did not take as many comparisons on average.
