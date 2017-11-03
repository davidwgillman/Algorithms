1. Implement DoubleHashST.java according to the comment at the top of the file.
I added the necessary code to the put, get, size, and delete functions to get the class running.

2. Run FrequencyCounter 8 < tale.txt using DoubleHashST. There should be 14,350 put() operations, as shown in the graphs on page 475 of the textbook.
I added a boolean for when resize was called and for when rehash was called. Then, I added a counter and incremented it for each equality statement that was made. After that, I checked the counter from FrequencyCounter and compounded it so that I could keep a running cumulative average. I then wrote this data into a csv called data.csv and graphed it using google sheets. The blue dots represent the cumulative equity average, the green x is when resize() was called, and the orange rehash() is when rehash() was called.

1. Reproduce the orange part of these graphs: graph the cumulative average number of equality tests up to the Nth put(), for each N.

2. Keep track of which put() operations caused a resize() and which caused a rehash(). Mark them on the graph.

3. Compare your graph to the graphs on page 475 and write down your remarks in a markdown document.
My graph had a similar shape of spiking up in the beginning before evening out to almost a straight horizontal lines. It also has the similarity of rehashing much more often in the beginning but eventually rehashing less and less frequent as N increases. My graph was different in that the average number of equality tests fell between 1 and 2, instead of between 2 and 10 like in the book.
Add your graph and markdown to your branch.


