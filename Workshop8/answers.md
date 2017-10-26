# Algorithms Workshop 8
## Caitlyn Ralph
## Oct. 26, 2017

### 1. 
* S
* Tree lastPutCompareCount: 0
* Tree lastPutNew: 0
* E
* Tree lastPutCompareCount: 1
* Tree lastPutNew: 1
* A
* Tree lastPutCompareCount: 2
* Tree lastPutNew: 2
* R
* Tree lastPutCompareCount: 3
* Tree lastPutNew: 3
* C
* Tree lastPutCompareCount: 4
* Tree lastPutNew: 4
* H
* Tree lastPutCompareCount: 5
* Tree lastPutNew: 5
* E
* Tree lastPutCompareCount: 6
* Tree lastPutNew: 5
* X
* Tree lastPutCompareCount: 7
* Tree lastPutNew: 6
* A
* Tree lastPutCompareCount: 8
* Tree lastPutNew: 6
* M
* Tree lastPutCompareCount: 9
* Tree lastPutNew: 7
* P
* Tree lastPutCompareCount: 10
* Tree lastPutNew: 8
* L
* Tree lastPutCompareCount: 11
* Tree lastPutNew: 9
* E
* Tree lastPutCompareCount: 12
* Tree lastPutNew: 9
* S 0
* E 12
* X 7
* A 8
* R 3
* C 4
* H 5
* M 9
* L 11
* P 10
* 
* A 8
* C 4
* E 12
* H 5
* L 11
* M 9
* P 10
* R 3
* S 0
* X 7

### 2. done, see FrequencyCounter.java code

### 3.
* N = 100, lastPutCompareCount = 102
* N = 1000, lastPutCompareCount = 1166
* N = 10000, lastPutCompareCount = 20340
* Graph 
![alt text](workshop8_question3.jpg "Graph")

### 4.
* S
* Tree lastPutCompareCount: 0
* Tree lastPutNew: 0
* E
* Tree lastPutCompareCount: 1
* Tree lastPutNew: 1
* A
* Tree lastPutCompareCount: 1
* Tree lastPutNew: 2
* R
* Tree lastPutCompareCount: 2
* Tree lastPutNew: 3
* C
* Tree lastPutCompareCount: 3
* Tree lastPutNew: 4
* H
* Tree lastPutCompareCount: 1
* Tree lastPutNew: 3
* E
* Tree lastPutCompareCount: 2
* Tree lastPutNew: 3
* X
* Tree lastPutCompareCount: 3
* Tree lastPutNew: 4
* A
* Tree lastPutCompareCount: 4
* Tree lastPutNew: 4
* M
* Tree lastPutCompareCount: 5
* Tree lastPutNew: 5
* P
* Tree lastPutCompareCount: 1
* Tree lastPutNew: 4
* L
* Tree lastPutCompareCount: 2
* Tree lastPutNew: 5
* E
* Tree lastPutCompareCount: 3
* Tree lastPutNew: 5
* A 8
* C 4
* E 12
* H 5
* L 11
* M 9
* P 10
* R 3
* S 0
* X 7

* N = 100, lastPutCompareCount = 101
* N = 1000, lastPutCompareCount = 1165
* N = 10000, lastPutCompareCount = 20339
* The graph is essentially the same.

### 5. I have a feeling something may be wrong, but it looks as if both the rate of growths are similar. The ratios between T(2N)/T(N) are not converging to a usable ratio, and it looks like it's growing exponentially, so I don't think alogN works either.

### 6. 
#### a) I think there would have been less compares for both the BST and the RedBlackBST because there is more of a chance that, with random output, N distinct words would come up in the first N words.
#### b) From my results, it looks like the depths were similar—however, taking into account what I know about BST and RedBlackTrees, I think the RedBlackTrees would probably have a shorter depth since they extend horizontally.