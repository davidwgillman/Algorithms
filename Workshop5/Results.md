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
 f(N)=a*(N^b) </br>
 f(2N)=a*((2N)^b)=a*(2^b)*(N^b) </br>
 f(N)=(f(2N))/(2^b) or f(N)*(2^b)=f(2N) </br>
 Not sure how to get a or b from this though... </br>
 Will use system of equations using two data points: 1M and 8M: </br>
 0.111666 = a*(1000000)^b </br>
 0.988 = a*(8000000)^b </br>
 0.988/((8000000)^b) = a </br>
 substitute a into the first equation </br>
 0.111666 = (0.988/((8000000)^b))*((1000000)^b) </br>
 **b=1.04844** </br>
 plug b into either of the above equations </br>
 0.988 = a*(8000000)^1.04844 </br>
 **a=0.0000000571849** </br>
 
 **RunTime=0.0000000571849*N^1.04844** </br>

 5. 
 4321: 77 instances //wow thats low! </br>
 4132: 101 instances </br>
 2341: 87 instances </br>
 3142: 109 instances </br>
 4231: 117 instances </br>
 3241: 110 instances </br>
 2314: 99 instances </br>
 1324: 94 instances </br>
 2413: 87 instances </br>
 3214: 123 instances </br>
 1423: 93 instances </br>
 1234: 101 instances </br>
 3124: 120 instances </br>
 3412: 113 instances </br>
 4213: 93 instances </br>
 2134: 104 instances </br>
 1432: 94 instances </br>
 4312: 98 instances </br>
 4123: 103 instances </br>
 1243: 99 instances </br>
 3421: 80 instances </br>
 1342: 104 instances </br>
 2431: 91 instances </br>
 2143: 104 instances </br>
 6. 
 We will consider the base case first where there is only one element to be shuffled. </br>
 **Base Case:**</br>
 i=0</br>
 We now pick an integer r between 0 and 0 uniformly at random. </br>
 We have chosen 0 since this is the only option. </br>
 a[i]=a[r] </br>
 a[0]=a[0] </br>
 We can easily see that the base case is true--that is to say that after round i (0), the array is uniformly shuffled from index 0 to index i (0).  </br>
 The array is shuffled in the only way possible, it is true that it is uniformly shuffled as only one shuffling exists (trivial case). It is equally likely for the largest element (and only element) to be in any position as there is only one position that exists for it to be in (trivial). </br>

 **i=n** </br>
 i=n </br>
 We now have an integer n that represents a list of arbitrary length. </br>
 We will pick an integer r between 0 and i uniformly at random for each element in the list.  </br>
 As we go through the list, for each element we will choose an integer between 0 and some i uniformly at random. We will then swap a[i] and a[r].  </br>
 Once we reach n, there will be n options as to where it goes, its current spot or the n-1 spots before it. We will choose a number between 0 and i (n) uniformly at random and swap them. From this it can be seen that every number has an equal chance to be at any position in the array. </br>
 A good way to imagine this is that you have a deck of cards with 1 card in it. You will then shuffle a new card in uniformly at random. There are two possible shufflings that exist. You will continue this  until you are shuffling in the nth card. There will be n! number of possible permutations (assuming every card is a distinct element). That is to say that there exist n! unique shufflings. Every element has an equal chance to be in any position in the array because with each introduction of a new card, you are putting it into the 'lottery' to be swapped with the new card enterings position. </br>

 **i=n+1** </br>
 i=n+1 </br>
 We now have an integer n+1 that represents a list of arbitrary length. </br>
 We will pick an integer r between 0 and i (n+1) uniformly at random for each element in the list. </br>
 If we follow the logic from the i=n case then it is easy to see that with a list of increasing size, the logic that every element has the same chance to be in any position follows. The probability of it being in certain positions will decrease with increasing n however. </br>

 //Sorry this is a weak proof//
 