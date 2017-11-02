# Workshop 9
## Caitlyn Ralph
## Nov. 2, 2017

#### 1) See "DoubleHashST.java" for the implementations according to the comments on the top of the file.

We have fixed all the bugs in the code, but when we run, multiple of us are getting a NullPointerException when the DoubleHashST is initialized.

Here is the error message

> Exception in thread "main" java.lang.NullPointerException

> at DoubleHashST.<init>(DoubleHashST.java:84)

> at DoubleHashST.<init>(DoubleHashST.java:61)

> at FrequencyCounter.main(FrequencyCounter.java:58) 

It is directing to this line in the code: 
> public DoubleHashST() {this(INIT_CAPACITY); }

#### 2) I worked on the workshop until 2:40pm, and I was not able to get to the second question because the code doesn't run.