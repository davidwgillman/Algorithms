# Workshop 5
## 9/28/17
## Caitlyn Ralph

1. Branch the github repo Algorithms, which contains the folder Workshop5. - DONE
2. Implement the KnuthShuffle algorithm shown in this demo (Links to an external site.) Links to an external site. Start with Workshop5/KnuthShuffle.java. - SEE KnuthShuffle.java
3. Time your algorithm on input arrays of size 10,000, 20,000, 40,000, and 80,000 and show the results in a table.

|   Input   | Runtime 1 | Runtime 2 | Runtime 3  |
| --------- |:---------:|:---------:| ----------:|
|   1000000 |   0.052   |  0.059    |  0.043     |
|   2000000 |   0.085   |  0.091    |  0.087     |
|   4000000 |   0.236   |  0.239    |  0.264     |
|   8000000 |   0.543   |  0.569    |  0.575     |

4. Estimate the running time in the form aNb using the doubling method.

The ratio of runtimes converges to 2. This would cause b in the aNb to be 1. The function would then be
T(N) = aN^1. If we use the biggest output, which in this case is 8000000 with an average runtime of 0.562, then plug it into that form, we get 0.562 = a8000000. This would make the constant 7.02916667e-8.

5. Write a program to shuffle the array [1,2,3,4] 2,400 times, count how many times each shuffled version of the array comes up, and print the results. Show the results.

* Output = 4321, Count = 105
* Output = 4132, Count = 85
* Output = 2341, Count = 105
* Output = 3142, Count = 114
* Output = 4231, Count = 115
* Output = 3241, Count = 80
* Output = 2314, Count = 111
* Output = 1324, Count = 102
* Output = 2413, Count = 96
* Output = 3214, Count = 83
* Output = 1423, Count = 101
* Output = 1234, Count = 102
* Output = 3412, Count = 95
* Output = 3124, Count = 122
* Output = 4213, Count = 91
* Output = 2134, Count = 83
* Output = 1432, Count = 87
* Output = 4312, Count = 102
* Output = 1243, Count = 109
* Output = 4123, Count = 109
* Output = 3421, Count = 107
* Output = 1342, Count = 99
* Output = 2143, Count = 117
* Output = 2431, Count = 80

6. Explain why the invariant in the demo is true: after round i, the array is uniformly shuffled from index 0 to index i. (Hint: use induction on i. The largest element in a uniformly shuffled array is equally likely to be in any position.)

For the base case, n = 1, we know the array is shuffled because there is only one value. For example, if the array of length n = 1 contains 2, we know that the 2 is shuffled.

For n = k + 1, we are adding another value to an array with length n. Because the definition of Knuth Shuffle is exchanging a value randomly for another value between the index 1 and N, then the probability of the new value getting switch with each place is 1/N. This would lead us to conclude that whenever you add a new value using the terms of Knuth Shuffle, it gets randomly placed, leading the array to still be shuffled.
