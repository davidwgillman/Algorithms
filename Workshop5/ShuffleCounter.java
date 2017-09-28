
public class ShuffleCounter {
	public static void main(String[] args){
		//2400 times
		int[] counts=new int[4322];
		for(int i=0;i<2400;i++){
			Integer[] arr=new Integer[]{1,2,3,4};
			KnuthShuffle.shuffle(arr);
			counts[Integer.parseInt(arr[0]+""+arr[1]+""+arr[2]+""+arr[3])]++;
		}
		for(int i=0;i<counts.length;i++)
			if(counts[i]>0)
				System.out.println(i+": "+counts[i]);
	}
}
