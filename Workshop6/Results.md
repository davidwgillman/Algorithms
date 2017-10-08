The algorithm for assigning jobs sorts the array of jobs, then assigns each job (in order from longest to shortest) to
the crew with the least work to do.
The sorting algorithm is a Dual-Pivot Quicksort which runs with n*log(n) performance. The job assigning is done with
n performance. The job assigning algorithm has a total runtime of n*log(n)+n.
This algorithm does not always calculate the ideal assignments of jobs, but is usually very close and does so fairly
simply and efficiently.

When run with fairer=true, the program uses assignJobsFairer(), this starts by running the original assignJobs()
algorithm, but then makes correct swaps to make the crews happier. It checks each pair of jobs between crews for
whether swapping them will make the crews happier. If it would then it swaps them.
This additional algorithm makes the job assignment fairer in many cases but has relatively poor performance. The
performance of swap checking is at worst (j/c)^c swaps which grows exponentially as the number of crews increases.
This adds significant time to the algorithm with only moderate improvements in crew happiness.