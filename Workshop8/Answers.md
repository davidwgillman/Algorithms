##Workshop 8 Answers

1.) I added a counter called compCount to the BST class, and increased it by 1 in the put() method after calling compareTo(). In addition to this, I added helper methods to set and retrieve the counter as well. 

2.) For the FrequencyCounter class, I worked a lot in the else statement within the while loop in order to count only distinct values. I used the the compCount setting methods I added before to reset the compCount to 0 in the begining. I also added a global count that is updated after each distinct put operation using the get methods for compCount. I also changed the class to use a BST and not a ST. 

3.)
| N        | BST           | RedBlackTree  |
|: ------------- :|:-------------:|: -----:|
| 100      | 7.18 | 5.37 |
| 1000      | 11.859      |   8.784 |
| 10000 | 16.428      |    12.262 |

4.) I performed identical changes to the put function in RedBlackTree and also added a counter and the according methods. I then changed FrequencyCounter to use a RedBlackTree.

5.) The comparisons appear to be on average O(logN) based on the graph for both BST and RedBlackTrees. This is supported by the straight line that results from changing the graph to a logarithmic scale.


6.) Reflect on the results.
1.  Random input for only distinct words will not change the number of comparisons needed. If we count more than just distinct words, it will be more likely that common words in sentences, such as “the”, will pop up and cause more changes in values and not new keys. 
2.  The results suggest that because of the balance of a RedBlackTree, the depth is much smaller than the depth of the unbalanced BST. As a result, the comparisons of a RedBlackTree very close to the depth of the tree. While for a BST, the number of comparisons is ½ the depth of the tree. 

