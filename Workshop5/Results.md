# Copy your commands and output here, clearly labeled.

# Write your answers to questions here, too.
# 3. Time your algorithm on input arrays of size 1 million, 2 million, 4 million, and 8 million and show the results in a table:

Input Size | Time to Run | Ratio Between Previous
--- | --- | ---
1,000,000 | 0.224 | x
2,000,000 | 0.302 | 1.35
4,000,000 | 0.487 | 1.61
8,000,000 | 1.119 | 2.3

# 4. Estimate the running time in the form aN^b using the doubling method:

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
What could a be? Basically we know that this function is aN^1, or aN. We can figure out roughly what a is by simply dividing for each term given our empirical evidence.

For 81920000, 86.588 / 81920000 = 0.000001056982422, which is tiny!
For 1280000, 0.693 / 1280000 = 0.00000054140625, which is also tiny.

So the order of growth is ~0.0000005*N. This is basically linear time, which makes sense because each element is being shuffled once, so there is really only one major operation per element of the array.

# 5. Write a program to shuffle the array [1,2,3,4] 2400 times, count how many times each shuffled version of the array appears, and print the results.




