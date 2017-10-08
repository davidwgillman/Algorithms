The algorithm for assigning jobs sorts the array of jobs, then assigns each jobs (in order from longest to shortest) to
the crew with the least work to do.
The sorting algorithm is a Dual-Pivot Quicksort which runs with n*log(n) performance. The job assigning is done with
n performance. The job assigning algorithm has a total runtime of n*log(n)+n.
This algorithm does not always calculate the ideal assignments of jobs, but is usually very close and does so fairly
simply and efficiently.