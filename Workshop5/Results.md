		# Copy your commands and output here, clearly labeled.

# Write your answers to questions here, too.
 
Runtimes for knuthshuffle

N = 1,000,000
.047 secs
.054 secs
.049 secs
Average = .05

N = 2,000,000
.147 secs
.092 secs
.089 secs
Average = .109

N = 4,000,000
.251 secs
.193 secs
.204 secs
Average = .216

N = 8,000,000
.505 secs
.438 secs
.435 secs
Average = .460

N = 16,000,000
.926 secs
.942 secs
.923 secs
Average = .930




 Estimate the running time in the form aNb using the doubling method. 

.930/.460 = 2.02, .460/.216 = 2.13, .216/.109 = 1.982, .109/.05 = 2.18. The ratio seems to be converging to 2 meaning that the exponent b is 1. Solving for a, .930 = a*16000000. 
A = 5.81 * 10^-8 making the equation  aNb = (5.81 * 10^-8)N















Write a program to shuffle the array [1,2,3,4] 2,400 times, count how many times each shuffled version of the array comes up, and print the results. Show the results. 



Key: 1,2,3,4 Count: 104
Key: 1,2,4,3 Count: 99
Key: 1,3,2,4 Count: 78
Key: 1,3,4,2 Count: 93
Key: 1,4,2,3 Count: 103
Key: 1,4,3,2 Count: 119
Key: 2,1,3,4 Count: 103
Key: 2,1,4,3 Count: 103
Key: 2,3,1,4 Count: 95
Key: 2,3,4,1 Count: 117
Key: 2,4,1,3 Count: 111
Key: 2,4,3,1 Count: 84
Key: 3,1,2,4 Count: 100
Key: 3,1,4,2 Count: 88
Key: 3,2,1,4 Count: 100
Key: 3,2,4,1 Count: 106
Key: 3,4,1,2 Count: 98
Key: 3,4,2,1 Count: 103
Key: 4,1,2,3 Count: 91
Key: 4,1,3,2 Count: 110
Key: 4,2,1,3 Count: 97
Key: 4,2,3,1 Count: 105
Key: 4,3,1,2 Count: 98
Key: 4,3,2,1 Count: 95

*Explain why the invariant in the demo is true: after round i, the array is uniformly shuffled from index 0 to index i. (Hint: use induction on i. The largest element in a uniformly shuffled array is equally likely to be in any position.) 

For an array to be uniformly shuffled, each element of the array has to have a 1/N chance of being in each place in the array.  If I is the current index and r is the random index generated from 0 to I, then at each iteration of i, r has 1/I chance of being chosen which is the definition of shuffle and if the array is shuffled at iteration I, we can assume that it will be shuffled at iteration I + 1 because the chances for r are 1/i+1 
