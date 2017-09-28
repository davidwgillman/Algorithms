// Andrew Leonov

Workshop #5

Data Size	Elapsed Time
100,000		0.021 s
200,000		0.036 s
400,000		0.041 s
800,000		0.059 s


5. Run KnuthShuffle.java to see the results.

Code: 

public static void main(String[] args) {
		int[] ar1 = {1, 2, 3, 4};
		int count = 0;
		int[] ar_compare = new int[4];
		
		System.arraycopy(ar1, 0, ar_compare, 0, ar1.length);
		
		Stopwatch stpwtch = new Stopwatch();
		
		for (int i = 0; i < 2400; i++) {
			shuffle(ar1);
			if (Arrays.equals(ar1, ar_compare)) {
				count++;
			}
			System.arraycopy(ar1, 0, ar_compare, 0, ar1.length);
		}
		
		// print elapsed time
		StdOut.println("Elapsed Time: " + stpwtch.elapsedTime());
		StdOut.println("Arrays repeated: " + count + " times.");
	}


Output:

Elapsed Time: 0.004
Arrays repeated: 138 times.
