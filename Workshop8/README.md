#Workshop 8 Answers

1. Added a instance variable called comparisoncount in the BST class with getter and setter methods. I then add to comparisoncount everytime a comparison is made in the put method.

2. in FrequencyCount.java, I changed the code so that it uses a BST instead of a ST. And in the else statement where it checks if the current key is already there, I added several things. I set the comparison count in the BST class to 0 before I put in the key, and get the comparisoncount and add it to a global variable called comparisoncount. I then added an if statement to break the while loop if the distinct number of words is equal to N.

3.             Number of Comparisons w/ arg[0] == 8
| N             | Red Black Tree| Binary Search Tree |
| ------------: |--------------:| ------------------:|
| 100           | 5.44          | 7.27               |
| 1000          | 8.793         | 11.867             |
| 10000         | 12.2641       |16.4298             |


4. I made the above changes again for RedBlackBST.

5. The rate of growth for red black tree O(Log(N)) on average because we are dividing the subtree in half each time when we make a comparison. 

6. 
	1. If we are calculating the average number of compares for only distinct values, then having a completely random input would not affect the results significantly. 

	2. For the BST, the average number of comparisons is about half of the depth of the BST.

	For the Red Black BST, since this tree is self balancing, the (black) depth is O(log(n)) where n is the number of distinct values. The average number of comparisons is similar to the depth of this tree.