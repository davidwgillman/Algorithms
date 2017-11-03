Check out Algorithms/Workshop9 from github.

1. Implement DoubleHashST.java according to the comment at the top of the file. Test it with main().

I implemented all the functions according to the specifications. I also added a comparison variable, rehash boolean, and resize boolean with setter and getter methods. And I incremented the comparison variable when a comparison happens, and change the resize and rehash variables to true when they happen in the code.

2. Run FrequencyCounter 8 < tale.txt using DoubleHashST. There should be 14,350 put() operations, as shown in the graphs on page 475 of the textbook.

I changed the frequency counter to calculate the cumulative averages and write out all the data in text.csv. The csv showed averages of all 1’s and all the resize variables were false, indicating that no collisions ever occur. I didn’t feel appropriate to create a graph of all 1 values and no rehashing.

    1. Reproduce the orange part of these graphs: graph the cumulative average number of equality tests up to the Nth put(), for each N.
    2. Keep track of which put() operations caused a resize() and which caused a rehash(). Mark them on the graph.
    3. Compare your graph to the graphs on page 475 and write down your remarks in a markdown document.

Add your graph and markdown to your branch. Commit and push them along with your code.


