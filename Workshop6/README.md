Question 5: Discuss your choice of method for ordering the jobs. What is its rate of growth? (Use any argument.) Were there any other considerations for choosing it?

I sorted the jobs using insertion sort mainly due to simplicity and ease of implementation.  The sorting algorithm has a growth rate of N^2 because it has two nested for-loops.

The arguments used to find the rate of growth were:

1000 jobs, 500 crews 2000 jobs, 1000 crews 4000 jobs, 2000 crews 8000 jobs, 4000 crews

The results are as follows:

Input                       Runtime 1    Runtime 2    Runtime 3
1000,   2000            0.018           0.014           0.017
2000,   1000            0.022           0.012           0.021
4000,   2000            0.038           0.030           0.018
8000,   4000            0.072           0.072           0.074

As we can see from the results above, doubling the input resulting in the runtime, on average, also doubling. Indeed, if we use the doubling hypothesis, we will find that the ratios for run times converge to 2. This means that, again by the doubling rule, b = 1.


Using the results from Runtime 1, we can see that:

0.072 = a * 8000, making a = 0.9 * 10 ^ -6

Thus, the function’s growth rate is f(x) = [0.9 * 10 ^ -6] * x
