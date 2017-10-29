##Algorithms Workshop 5: Shuffling

##Timing:
       N -- seconds
  100000 -- 1.18385
   80000 -- 0.164657
   60000 -- 0.136413
   40000 -- 0.149935
   20000 -- 0.137314
   10000 -- 0.130103
    
This timing is very strange. The first thing to notice is that 100000 takes significantly longer than any other timing. I first started the test at 80000, as was specified and noticed that the first run of the algorithm takes significantly longer. I’m guessing this is due to some type of overhead. I include test above 80000 to consume this overhead.

##Doubling:
    10k to 20k → .130 to .137 = x1.053
20k to 40k → .137 to .149 = x1.087
40k to 80k → .149 to .164 = x1.100
This makes me think that the runtime of knuth shuffle is not of form aNk as when N doubles, the runtime far less than doubles.

##2400 Shuffles of [1,2,3,4]:

[100, 93, 104, 111, 106, 120, 96, 99, 96, 104, 87, 112, 97, 85, 105, 90, 103, 96, 102, 89, 102, 100, 92, 111]


 