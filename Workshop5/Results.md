# Copy your commands and output here, clearly labeled.

# Write your answers to questions here, too.
 
 1. Done. 

 2. Done.

 3. 
 | `Input`      | `Run Time Avg`|
 |:------------:|:-----------:|
 |10,000        |0.003666...  |
 |20,000        |0.004666...  |
 |40,000        |0.007        |
 |80,000        |0.013666...  |
 |...           |...          |
 |1,000,000     |0.111666...  |
 |2,000,000     |0.235333...  |
 |4,000,000     |0.472666...  |
 |8,000,000     |0.988        |

 4. 
 f(N)=a*(N^b)
 f(2N)=a*((2N)^b)=a*(2^b)*(N^b)
 f(N)=(f(2N))/(2^b) or f(N)*(2^b)=f(2N)
 Not sure how to get a or b from this though... 
 Will use system of equations using two data points: 1M and 8M:
 0.111666 = a*(1000000)^b
 0.988 = a*(8000000)^b
 0.988/((8000000)^b) = a 
 substitute a into the first equation 
 0.111666 = (0.988/((8000000)^b))*((1000000)^b)
 **b=1.04844**
 plug b into either of the above equations
 0.988 = a*(8000000)^1.04844
 **a=0.0000000571849**
 
 **RunTime=0.0000000571849*N^1.04844**

 5. 
 4321: 77 instances //wow thats low!
 4132: 101 instances
 2341: 87 instances
 3142: 109 instances
 4231: 117 instances
 3241: 110 instances
 2314: 99 instances
 1324: 94 instances
 2413: 87 instances
 3214: 123 instances
 1423: 93 instances
 1234: 101 instances
 3124: 120 instances
 3412: 113 instances
 4213: 93 instances
 2134: 104 instances
 1432: 94 instances
 4312: 98 instances
 4123: 103 instances
 1243: 99 instances
 3421: 80 instances
 1342: 104 instances
 2431: 91 instances
 2143: 104 instances 
 6. 
 We will consider the base case first where there is only one element to be shuffled. 
 **Base Case:**
 i=0
 We now pick an integer r between 0 and 0 uniformly at random.
 We have chosen 0 since this is the only option. 
 a[i]=a[r] 
 a[0]=a[0]
 We can easily see that the base case is true--that is to say that after round i (0), the array is uniformly shuffled from index 0 to index i (0).  
 The array is shuffled in the only way possible, it is true that it is uniformly shuffled as only one shuffling exists (trivial case). It is equally likely for the largest element (and only element) to be in any position as there is only one position that exists for it to be in (trivial).

 **i=n**
 i=n
 We now have an integer n that represents a list of arbitrary length.
 We will pick an integer r between 0 and i uniformly at random for each element in the list.  
 As we go through the list, for each element we will choose an integer between 0 and some i uniformly at random. We will then swap a[i] and a[r].  
 Once we reach n, there will be n options as to where it goes, its current spot or the n-1 spots before it. We will choose a number between 0 and i (n) uniformly at random and swap them. From this it can be seen that every number has an equal chance to be at any position in the array. 
 A good way to imagine this is that you have a deck of cards with 1 card in it. You will then shuffle a new card in uniformly at random. There are two possible shufflings that exist. You will continue this  until you are shuffling in the nth card. There will be n! number of possible permutations (assuming every card is a distinct element). That is to say that there exist n! unique shufflings. Every element has an equal chance to be in any position in the array because with each introduction of a new card, you are putting it into the 'lottery' to be swapped with the new card enterings position.

 **i=n+1**
 i=n+1
 We now have an integer n+1 that represents a list of arbitrary length.
 We will pick an integer r between 0 and i (n+1) uniformly at random for each element in the list.  
 If we follow the logic from the i=n case then it is easy to see that with a list of increasing size, the logic that every element has the same chance to be in any position follows. The probability of it being in certain positions will decrease with increasing n however. 

 //Sorry this is a weak proof//
 