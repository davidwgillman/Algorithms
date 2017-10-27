# Algorithms Workshop 8

Please see 1-4 in the .java files or the .png files. 

1. The following the the code output for BST.
    Key: S, Value: 0</br>
    New key was added!</br>
    The number of comparisons for this key is 0</br>
    Was a new key added in?: true</br>
</br>
    Key: E, Value: 1</br>
    New key was added!</br>
    The number of comparisons for this key is 1</br>
    Was a new key added in?: true</br>
</br>
    Key: A, Value: 2</br>
    New key was added!</br>
    The number of comparisons for this key is 2</br>
    Was a new key added in?: true</br>
</br>
    Key: R, Value: 3 </br>
    New key was added! </br>
    The number of comparisons for this key is 2</br>
    Was a new key added in?: true</br>
</br>
    Key: C, Value: 4</br>
    New key was added!</br>
    The number of comparisons for this key is 3</br>
    Was a new key added in?: true</br>
</br>
    Key: H, Value: 5</br>
    New key was added!</br>
    The number of comparisons for this key is 3</br>
    Was a new key added in?: true</br>
</br>
    Key: E, Value: 6</br>
    The value of E was changed!</br>
    The number of comparisons for this key is 1</br>
    Was a new key added in?: false</br>
</br>
    Key: X, Value: 7</br>
    New key was added!</br>
    The number of comparisons for this key is 1</br>
    Was a new key added in?: true</br>
</br>
    Key: A, Value: 8</br>
    The value of A was changed!</br>
    The number of comparisons for this key is 2</br>
    Was a new key added in?: false</br>
</br>
    Key: M, Value: 9</br>
    New key was added!</br>
    The number of comparisons for this key is 4</br>
    Was a new key added in?: true</br>
</br>
    Key: P, Value: 10</br>
    New key was added!</br>
    The number of comparisons for this key is 5</br>
    Was a new key added in?: true</br>
</br>
    Key: L, Value: 11</br>
    New key was added!</br>
    The number of comparisons for this key is 5</br>
    Was a new key added in?: true</br>
</br>
    Key: E, Value: 12</br>
    The value of E was changed!</br>
    The number of comparisons for this key is 1</br>
    Was a new key added in?: false</br>
 </br>
The following is the code output for Red Black BST.</br>
    Key: S, Value: 0</br>
    New key was added!</br>
    The number of comparisons for this key is 0</br>
    Was a new key added in?: true</br>
</br>
    Key: E, Value: 1</br>
    New key was added!</br>
    The number of comparisons for this key is 1</br>
    Was a new key added in?: true</br>
</br>
    Key: A, Value: 2</br>
    New key was added!</br>
    The number of comparisons for this key is 2</br>
    Was a new key added in?: true</br>
</br>
    Key: R, Value: 3</br>
    New key was added!</br>
    The number of comparisons for this key is 2</br>
    Was a new key added in?: true</br>
</br>
    Key: C, Value: 4</br>
    New key was added!</br>
    The number of comparisons for this key is 2</br>
    Was a new key added in?: true</br>
</br>
    Key: H, Value: 5</br>
    New key was added!</br>
    The number of comparisons for this key is 3</br>
    Was a new key added in?: true</br>
</br>
    Key: E, Value: 6</br>
    The value of E was changed!</br>
    The number of comparisons for this key is 1</br>
    Was a new key added in?: false</br>
</br>
    Key: X, Value: 7</br>
    New key was added!</br>
    The number of comparisons for this key is 2</br>
    Was a new key added in?: true</br>
</br>
    Key: A, Value: 8</br>
    The value of A was changed!</br>
    The number of comparisons for this key is 3</br>
    Was a new key added in?: false</br>
</br>
    Key: M, Value: 9</br>
    New key was added!</br>
    The number of comparisons for this key is 3</br>
    Was a new key added in?: true</br>
</br>
    Key: P, Value: 10</br>
    New key was added!</br>
    The number of comparisons for this key is 3</br>
    Was a new key added in?: true</br>
</br>
    Key: L, Value: 11</br>
    New key was added!</br>
    The number of comparisons for this key is 3</br>
    Was a new key added in?: true</br>
</br>
    Key: E, Value: 12</br>
    The value of E was changed!</br>
    The number of comparisons for this key is 1</br>
    Was a new key added in?: false</br>
2. Look at the main function for Frequency Counter.java
3. ![alt text](https://github.com/davidwgillman/Algorithms/blob/sunwoo_ha/Workshop8/graph1.png)
4. Done. Look at the questions above.
5. The graph from #3 that looks at the average number of comparisons vs. N for BST and Red Black BST. To figure out the rate of growth, I took graph1.png and put it into log scale (graph2.png). 
![alt text](https://github.com/davidwgillman/Algorithms/blob/sunwoo_ha/Workshop8/graph2.png)
From this graph, we can see that when in log scale, the trends are linear for both BST and Red Black BST. Since the trend is linear in log scale, I estimate that the rate of growth should be alogN, where a is around 2. </br>
6. </br>
    1) If the inputs were truly random, the frequency of the input would more heavily favor towards common words in the in English language like "a", "the", etc. or in our case, common words that are greater than length of 8, like "television." As for the number of comparisions, I do not think that it would have been different. 
    2) Based on the results that we got, we can see that the depth of the Red Black BST is smaller than the depth of BST since the depth is equal to the number of comparisons that were made. This means that the Red Black BST are more efficient in putting new keys and values. 
