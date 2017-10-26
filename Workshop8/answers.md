Genevieve Liberte
Algorithms
Workshop 8

N | Avg Comparisons (BST)
--- | ---
100 | 7
1000 | 11
10000 | 16

N | Avg Comparisons (RedBlack)
--- | ---
100 | 5
1000 | 8
10000 | 12

While we don't really have enough data to calculate the exact order of growth of this function accurately, we can use the shape of the graph and the points that we do have to help us estimate. First we ask ourselves whether this function is logarithmic or exponential in nature. I think it is safe to say that this function is not linear nor exponential - by looking at the graph, we can see that its line seems to be slowing down in growth rather than speeding up; it seems to be approaching a limit at the X axis rather than the Y axis. This tell us the function is of order a log n. We know the function is logarithmic, but what is its constant?
I know off the top of my head that log of 100 is about 6.5 So, if a was equal to 1, then the average when N is 100 should be 6.5, and the average when it is 10000 should be 13. So we know that, for the BST, a must be slightly smaller than 1. And, for the Red Black tree, a must be slightly larger than 1. Looking at the logarithmic graph of the averages provides us a little clarity. The logarithmic line graph for BST does look steeper than the line graph for the RedBlack tree, so this checks out. I would say that the rate of growth for the BST is about 0.8 log N, and the rate of growth for the Red Black tree is about 1.3 log N.

###6. 
######1.
If the resutls in the files were random, we would expect a lot more distinct keys and therefore a lot more comparisons in our trees. Language is composed of patterns and recurring words - certain words are definitely more frequent than others in a paragraph of text. Even when setting a minimum length of the words you're counting so as to disregard common words like and and the, the subject of a piece of text will definitely influence its word frequency. This is something that doesn't happen when working with random text.

######2.
The results suggest that the Binary Search tree is deeper than the Red Black Tree by a few levels. This makes sense, because the BST is not self-balancing like the Red Black tree, so it doesn't limit its depth as rigidly.