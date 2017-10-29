import java.util.Arrays;

public final class KnuthShuffle {

    /**
     * Rearranges the elements of the specified array in uniformly random order.
     *
     * @param  _2k the array to shuffle
     */
	public static void shuffle(int[] _2k) {
		// as a demo, this generates a random number from 0 to 9
		//int i = StdRandom.uniform(0,10); 
		// implement this
		//long start_time = System.nanoTime();
		int n = _2k.length;
	        for (int i = 0; i < n; i++) {
	            // choose index uniformly in [0, i]
	            int r = (int) (Math.random() * (i + 1));
	            Object swap = _2k[r];
	            _2k[r] = _2k[i];
	            _2k[i] = (int) swap;
	            
	        }
	        //long end_time = System.nanoTime();
	        //double difference = (end_time - start_time) / 1e6;
	   //System.out.println(difference);
	}

	static int[] populate(int size) {
		int[] a = new int[size];
		for (int i = 0; i < a.length; i++) {
			a[i] = 1;
		}
		return a;
	}
	

	public static void main(String[] args) {
		// implement this
		
		//timing part:
		/*for (int i = 100000; i >= 2000; i -= 10000) {
			int[] a = populate(2000);
			System.out.println(i);
			shuffle(a);
		}*/
		int[] p = new int[24];
		//2400 shuffles part:
		
		// THIS IS THE WORST CODE IVE EVER WRITTEN
		for (int i = 0; i < 2400; i++) {
			int[] a = {1,2,3,4};
			shuffle(a);
			switch (Arrays.toString(a)) {
			case("[1, 2, 3, 4]") : 
				p[0]++; break;
			case("[1, 2, 4, 3]"):
				p[1]++; break;
			case("[1, 3, 2, 4]") : 
				p[2]++; break;
			case("[1, 3, 4, 2]"):
				p[3]++; break;
			case("[1, 4, 2, 3]") : 
				p[4]++; break;
			case("[1, 4, 3, 2]"):
				p[5]++; break;
			case("[2, 1, 3, 4]") : 
				p[6]++; break;
			case("[2, 1, 4, 3]"):
				p[7]++; break;
			case("[2, 3, 1, 4]") : 
				p[8]++; break;
			case("[2, 3, 4, 1]"):
				p[9]++; break;
			case("[2, 4, 1, 3]") : 
				p[10]++; break;
			case("[2, 4, 3, 1]"):
				p[11]++; break;
			case("[3, 1, 2, 4]") : 
				p[12]++; break;
			case("[3, 1, 4, 2]"):
				p[13]++; break;
			case("[3, 2, 1, 4]") : 
				p[14]++; break;
			case("[3, 2, 4, 1]"):
				p[15]++; break;
			case("[3, 4, 1, 2]") : 
				p[16]++; break;
			case("[3, 4, 2, 1]"):
				p[17]++; break;
			case("[4, 1, 2, 3]") : 
				p[18]++; break;
			case("[4, 1, 3, 2]"):
				p[19]++; break;
			case("[4, 2, 1, 3]") : 
				p[20]++; break;
			case("[4, 2, 3, 1]"):
				p[21]++; break;
			case("[4, 3, 1, 2]") : 
				p[22]++; break;
			case("[4, 3, 2, 1]"):
				p[23]++; break;
			}
		}
		System.out.println(Arrays.toString(p));
	}
}