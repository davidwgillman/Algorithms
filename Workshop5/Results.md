# Copy your commands and output here, clearly labeled.

# Write your answers to questions here, too.
# 3. Time your algorithm on input arrays of size 1 million, 2 million, 4 million, and 8 million and show the results in a table:

Input Size | Time to Run | Ratio Between Previous
--- | --- | ---
1,000,000 | 0.224 | x
2,000,000 | 0.302 | 1.35
4,000,000 | 0.487 | 1.61
8,000,000 | 1.119 | 2.3

# 4. Estimate the running time in the form aN^b^ using the doubling method:

Using the doubling rule, increasing input size until limit is found:

Input Size | Time to Run | Ratio Between Previous
--- | --- | ---
10000 | 0.012 | x
20000 | 0.006 | 0.5
40000 | 0.006 | 1
80000 | 0.012 | 2
160000 | 0.093 | 7.75
320000 | 0.101 | 1.09
640000 | 0.282 | 2.79
1280000 | 0.693 | 2.46
2560000 | 1.066 | 1.54
5120000 | 1.38 | 1.29
10240000 | 5.967 | 4.32
20480000 | 22.427 | 3.76
40960000 | 38.464 | 1.72
81920000 | 86.588 | 2.25


Let's just say the limit we'll be approaching is 2?
So if the limit we're approaching is 2, then b = 1
What could a be? Basically we know that this function is aN^1^, or aN. We can figure out roughly what a is by simply dividing for each term given our empirical evidence.

For 81920000, 86.588 / 81920000 = 0.000001056982422, which is tiny!
For 1280000, 0.693 / 1280000 = 0.00000054140625, which is also tiny.

So the order of growth is ~0.0000005*N. This is basically linear time, which makes sense because each element is being shuffled once, so there is really only one major operation per element of the array.

# 5. Write a program to shuffle the array [1,2,3,4] 2400 times, count how many times each shuffled version of the array appears, and print the results.

85 of permutation 1234
80 of permutation 1243
0 of permutation 1324
101 of permutation 1342
108 of permutation 1423
0 of permutation 1432
112 of permutation 2134
95 of permutation 2143
94 of permutation 2314
101 of permutation 2341
91 of permutation 2413
94 of permutation 2431
90 of permutation 3124
77 of permutation 3142
99 of permutation 3214
104 of permutation 3241
100 of permutation 3412
123 of permutation 3421
95 of permutation 4123
115 of permutation 4132
109 of permutation 4213
90 of permutation 4231
108 of permutation 4312
105 of permutation 4321

# 6. Explain why the invariant in the demo is true: after round i, the array is uniformly shuffled from index 0 to index i.
For each round, a random number j is chosen between 0 and i. The element at index j is then swapped with the element at index i. This ensures that, for each new element that i refers to, there is an equal chance it will go anywhere in the array thus far from index 0 to index i. Further, any element from index i, after getting swapped into index j, has an equal chance of getting *re-swapped* into i in a later round, because the algorithm always chooses a random j between 0 and i. For example, say we are at round 13 in our program, so i = 13. j is chosen to be 5, so the element at index 5 is now at index 13, and the element at index 13 is now at index 5. 3 rounds later, when i = 16, every element that has been shuffled so far has a 1 in 15 chance of being chosen to be swapped. It just so happens that this time, j is chosen to be 5 again, so the element at index 5 (which was previously in index i when i was 13) is now put into index 16 and vice versa. The chance of this happening for any element between index 0 and i is equally likely each round, because the rounds are independent of each other. Therefore, the array will always be uniformly shuffled from 0 to i.






