# Workshop 5
## Parankush Bhardwaj


3. Time your algorithm on input arrays of size 10,000, 20,000, 40,000, and 80,000 and show the results in a table.

Input Size          First              Second      Third             Average (s)

1,000,000          0.137            0.128           0.13              0.1317
2,000,000          0.276            0.238           0.241            0.2517
4,000,000          0.549            0.526           0.498            0.5243
8,000,000          1.388            1.244           1.703            1.445



4. Estimate the running time in the form aN^b using the doubling method.

I noticed that the average runtime is doubling every time the input size is doubling.
This means that b = 1 (by the doubling method).

Thus we can infer that 0.137 = a * 1,000,000^1, making a = 0.000000137


5.

Output: (I am struggling getting my program to go from the 6 permutations it produces to the 24 required)

2413:    443
3142:    382
2341:    375
4123:    385
3421:    416
4312:    399


6. Explain why the invariant in the demo is true: after round i, the array is uniformly shuffled from index 0 to index i. (Hint: use induction on i. The largest element in a uniformly shuffled array is equally likely to be in any position.)

Base case: 0-th index

The first index of the array is chosen. It is both, the i-th and j-th value. Because both variables represent the same index, exchanging them in any random order will always lead to the value of the 0th index staying constant.

Inductive hypothesis: There are 'x' shuffles for a array of length 'x'.

We know from the rules of the algorithm that the i-th value increments from 0 to the final index [let the final index be called 'x']. We also know that the j-th value is a randomly chosen index from 0 to 'x'. And finally, we know that an exchange always occurs after every time the 'x' index increments.

Thus, we can infer that there are x exchanges for an array with length x.

Inductive step: x + 1 elements

If we add one more element to the array, what occurs is that the i-th value increments by 1, leading to the j-th value finding another randomly chosen index, and another exchange occuring. Thus, as the index grows, so does the number of shuffles.

This proves that the array is always uniformly shuffled, impying then that the largest element will always be equally likely to be in any position.



















