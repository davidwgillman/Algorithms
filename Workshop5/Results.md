# Copy your commands and output here, clearly labeled.
To use the code, write in the command line: 
    java -cp algs4.jar:. KnuthShuffle [input size of choice]
    java -cp algs4.jar:. ProblemFiveShuffling

# Write your answers to questions here, too.
 1. Done.
 2. Look at KnuthShuffle.java.
 3. 
|         | 1000000 | 2000000 | 4000000 | 8000000 |
| --------|:-------:|:-------:|:-------:|:-------:|
| trial 1 |  0.110  |  0.212  |  0.443  |  0.929  |
| trial 2 |  0.143  |  0.211  |  0.445  |  1.070  |
| trial 3 |  0.100  |  0.205  |  0.452  |  0.925  |
| average |  0.118  |  0.209  |  0.447  |  0.975  |
4. We have f(n) = a(n)^b. Based on the doubling method, f(2n) = a(2n)^b </br>
   f(n) = a((2n)^b)/(2^b) or f(2n) = f(n)*(2^b) </br>
   Using system of equations using two points: 1000000 and 8000000 </br>
   0.118 = a(1000000)^b </br>
   0.975 = a(8000000)^b </br>
   a = 0.975/(8000000)^b </br>
   0.118 = (0.975/(8000000)^b)*(1000000)^b </br>
   b = 1.01554 </br>
   0.118 = a(1000000)^1.01554 </br>
   a = 0.0000000852011 </br>
   **runTime = 0.0000000852011(n)^1.01554**
5. Look at ProblemFiveShuffling.java.
    There are 24 repeated numbers:
        * 4321: 97 times
        * 4132: 99 times
        * 2341: 129 times
        * 3142: 93 times
        * 4231: 107 times
        * 3241: 95 times
        * 2314: 85 times
        * 1324: 93 times
        * 2413: 93 times
        * 3214: 107 times
        * 1423: 101 times
        * 1234: 96 times
        * 3412: 106 times
        * 3124: 106 times
        * 4213: 113 times
        * 2134: 93 times
        * 4312: 102 times
        * 1432: 108 times
        * 1243: 80 times
        * 4123: 82 times
        * 3421: 113 times
        * 1342: 97 times
        * 2143: 112 times
        * 2431: 94 times
6.
 **Base Case**: There is only one element to be shuffled.
i = 0;
We will now choose an integer j between 0 and 0 uniformly at random.
0 is chosen because it is the only option.
a[i] = a[j]
a[0] = a[0]
After one round, the array is uniformly shuffled from index 0 to index i, 0, as it is the only one
shuffle that exists. It is equally likely for the largest element to the be in any position as there is only one position that exists for it to be in. 

**i = n**
Now there is an integer, n, which represents an array of arbitrary length. 
As we loop though the array, for each element, we will choose an integer between 0 and some j uniformly at random. Then a[i]and a[j] will be swapped. Once it has reach the nth loop, there will be n options as to where it can go, the current position ot the n-1 positions before it. From this, it can be seen that ebery number has an equal chance to be at any position in the array.

**i = n + 1**
Finally, we have an integer n + 1 that represents an array of arbitrary length.
We will now choose an integer j between 0 and (n + 1) uniformly at random for each element in the array. Following the logic from i = n, then it is easy to see that with a list of increasing size, the logic that every element has the same chance to be in any position follows. 