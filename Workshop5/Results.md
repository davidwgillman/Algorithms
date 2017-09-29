# Copy your commands and output here, clearly labeled.

		Question 3 command in terminal: java KnuthSuffle 3
		Question 5 command in termainal: java KnuthSuffle 5



# Write your answers to questions here, too.
 
	Question 3: (5.54611 x 10-8)*N^1.08047

		|           | Trial 1 | Trial 2 | Trial 3 | Average |
		|-----------|---------|---------|---------|---------|
		| 1,000,000 | 0.192   | 0.153   | 0.134   | 0.1597  |
		| 2,000,000 | 0.306   | 0.314   | 0.301   | 0.3070  |
		| 4,000,000 | 0.703   | 0.694   | 0.711   | 0.7027  |
		| 8,000,000 | 1.505   | 1.504   | 1.522   | 1.5103  |


		0.1597 = c1000000^b
		1.5103 = c8000000^b
		0.1597/1000000^b = 1.5103/8000000^b, b = 1.08047
		1.5943 = c80000001.08047, c = 5.54611 x 10-8


	Question 5:

		3214:	94
		3421:	94
		3124:	115
		2143:	89
		1423:	98
		3241:	104
		4132:	90
		2413:	99
		1432:	104
		4312:	113
		1324:	107
		1342:	92
		4231:	99
		1234:	100
		1243:	103
		4123:	105
		4321:	101
		2431:	120
		2314:	83
		3412:	98
		2134:	93
		2341:	103
		4213:	96
		3142:	100


	Question 6:
		*Explain why the invariant in the demo is true: after round i, the array is uniformly shuffled from index 0 to index i.

		Every time i increases, a[i] and another value are randomly swapped. A uniform shuffle(swap) means that each value in index from 0 up to i has an equal probability for being swapped with a[i]. Any given swap is uniform because of the equal probability. The uniformity is retained even as i increases because the probability of each index from 0 to i being the swapped index value changes (decreases) to ensure equal probability at every step. This means that the swapping probability for any given index is (N-i)/N.

		In the case with the code, a number from 0 to i was uniformally selected randomly. This number, r, was then used as an the index for the value which would be swapped( a[r] with a[i] ). Because r represents an index in the array, and r was uniformily randomly generated between 0 and i, each index from 0 to i had an equal probability of being swapped. Thus, the uniformity in shuffling.