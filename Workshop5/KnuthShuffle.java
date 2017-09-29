/* Shuffles an array of objects */

import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.StdRandom;


public final class KnuthShuffle {

    /**
     * Rearranges the elements of the specified array in uniformly random order.
     *
     * @param  a the array to shuffle
     */
    public static void swap(Object[] a, int i, int r){
		if(i < a.length && r < a.length){
			Object m = a[i];
			Object n = a[r];
			a[i] = n;
			a[r] = m;
		}
		return;
	}

	public static Integer[] arrayBuilder(int n){
    	Integer[] result = new Integer[n];
    	for(int i = 0; i < n; i++){
			result[i] = i;
		}
		return result;
	}

	public static void shuffle(Object[] a) {
		// as a demo, this generates a random number from 0 to 9
		int l = StdRandom.uniform(0,10);
		// implement this
		for(int i = 1, r; i < a.length; i++){
			r = StdRandom.uniform(0,i);
			swap(a, i, r);
		}
		return;
        
	}

	public static void main(String[] args) {
		Integer[] mainArray = {1,2,3,4};
		KnuthShuffle shuffler = new KnuthShuffle();
		int a1234=0, a1243=0, a1324=0, a1342=0, a1423=0, a1432=0, a2134=0, a2143=0, a2314=0, a2341=0, a2413=0, a2431=0;
		int a3124=0, a3142=0, a3214=0, a3241=0, a3412=0, a3421=0, a4123=0, a4132=0, a4213=0, a4231=0, a4312=0, a4321=0;
		for(int i = 0; i <= 2400; i++){
			shuffler.shuffle(mainArray);

			switch(mainArray[0]){
				case 1:
					switch(mainArray[1]){
						case 2:
							switch(mainArray[2]){
								case 3:
									//cool its 1234
									a1234++;
								case 4:
									//cool its 1243
									a1243++;
							}
						case 3:
							switch(mainArray[2]){
								case 2:
									//cool its 1324
									a1324++;
								case 4:
									//cool its 1342
									a1342++;
							}
						case 4:
							switch(mainArray[2]){
								case 2:
									//cool its 1423
									a1423++;
								case 3:
									//cool its 1432
									a1432++;
							}
					}
				case 2:
					switch(mainArray[1]){
						case 1:
							switch(mainArray[2]){
								case 3:
									//cool its 2134
									a2134++;
								case 4:
									//cool its 2143
									a2143++;
							}
						case 3:
							switch(mainArray[2]){
								case 1:
									//cool its 2314
									a2314++;
								case 4:
									//cool its 2341
									a2341++;
							}
						case 4:
							switch(mainArray[2]){
								case 1:
									//cool its 2413
									a2413++;
								case 2:
									//cool its 2431
									a2431++;
							}
					}
				case 3:
					switch(mainArray[1]){
						case 1:
							switch(mainArray[2]){
								case 4:
									//cool its 3142
									a3142++;
								case 2:
									//cool its 3124
									a3124++;
							}
						case 2:
							switch(mainArray[2]){
								case 1:
									//cool its 3214
									a3214++;
								case 4:
									//cool its 3241
									a3241++;
							}
						case 4:
							switch(mainArray[2]){
								case 1:
									//cool its 3412
									a3412++;
								case 2:
									//cool its 3421
									a3421++;
							}
					}
				case 4:
					switch(mainArray[1]){
						case 1:
							switch(mainArray[2]){
								case 2:
									//cool its 4123
									a4123++;
								case 3:
									//cool its 4132
									a4132++;
							}
						case 2:
							switch(mainArray[2]){
								case 1:
									//cool its 4213
									a4213++;
								case 3:
									//cool its 4231
									a4231++;
							}
						case 3:
							switch(mainArray[2]){
								case 1:
									//cool its 4312
									a4312++;
								case 2:
									//cool its 4321
									a4321++;
							}
					}
			}
		}
		System.out.println(a1234 + " of permutation 1234");
		System.out.println(a1243 + " of permutation 1243");
		System.out.println(a1324 + " of permutation 1324");
		System.out.println(a1342 + " of permutation 1342");
		System.out.println(a1423 + " of permutation 1423");
		System.out.println(a1432 + " of permutation 1432");
		System.out.println(a2134 + " of permutation 2134");
		System.out.println(a2143 + " of permutation 2143");
		System.out.println(a2314 + " of permutation 2314");
		System.out.println(a2341 + " of permutation 2341");
		System.out.println(a2413 + " of permutation 2413");
		System.out.println(a2431 + " of permutation 2431");
		System.out.println(a3124 + " of permutation 3124");
		System.out.println(a3142 + " of permutation 3142");
		System.out.println(a3214 + " of permutation 3214");
		System.out.println(a3241 + " of permutation 3241");
		System.out.println(a3412 + " of permutation 3412");
		System.out.println(a3421 + " of permutation 3421");
		System.out.println(a4123 + " of permutation 4123");
		System.out.println(a4132 + " of permutation 4132");
		System.out.println(a4213 + " of permutation 4213");
		System.out.println(a4231 + " of permutation 4231");
		System.out.println(a4312 + " of permutation 4312");
		System.out.println(a4321 + " of permutation 4321");
	}
}
