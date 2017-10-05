/* Randomly generates a day's worth of jobs for H households using V van crews
   H and V may be passed through a constructor or a newDay() method.

   [Suggestion: create an array of MovingCompanyCrew objects;
                a MovingCompanyCrew has a list of jobs and an hoursOfWork() method]

   Orders jobs from longest to shortest and assigns jobs in order to the first available crew.

   Prints the assignment and hours worked by the last crew to get off work.
   */

// imports
import java.util.stream.*;
import java.util.*;
import edu.princeton.cs.algs4.*;

 public class MovingCompanyDispatcher {
    private Integer nCrews = 0;
    private Integer nHouseholds = 0;
    public Integer[] jobs = null;
    
    private MovingCompanyCrew[] crews = null;

    public MovingCompanyDispatcher(){}

    public void newDay(int C, int H) {
        nCrews = C;
        nHouseholds = H;
        this.crews = new MovingCompanyCrew[C];
        for(int i = 0; i < crews.length; i++){
            crews[i] = new MovingCompanyCrew();
        }
        this.makeJobs();
    }

    public double getLowerBound() {
        // lower bound on numnber of hours worked by last crew to    get off work
        int sum = 0;
        for(int i : jobs){
            sum += i;
        }
        System.out.println(sum / nCrews);
        return  sum / nCrews;
    }
    
    
    public void makeJobs() {
        jobs = new Integer[nHouseholds];
        Random r = new Random();
        //r.setSeed(1235665432);
        for(int i = 0; i < nHouseholds; i++){
            jobs[i] = r.nextInt(8) + 1;
        }
    }
    
    public static void quickSort(Integer[] arr, int low, int high) {
		if (arr == null || arr.length == 0)
			return;
 
		if (low >= high)
			return;
 
		// pick the pivot
		int middle = low + (high - low) / 2;
		int pivot = arr[middle];
 
		// make left < pivot and right > pivot
		int i = low, j = high;
		while (i <= j) {
			while (arr[i] < pivot) {
				i++;
			}
 
			while (arr[j] > pivot) {
				j--;
			}
 
			if (i <= j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}
 
		// recursively sort two sub parts
		if (low < j)
			quickSort(arr, low, j);
 
		if (high > i)
			quickSort(arr, i, high);
	}
	
    public void assignJobs() {
        quickSort(jobs, 0, jobs.length - 1);
        int minpointer = 0;
        while(minpointer < jobs.length){
            MovingCompanyCrew minCrew = crews[0];
            //System.out.println(minCrew);
            double workHours = 10000000;
            for(int j = 0; j < crews.length; j++){
                //find crew with least hours
                if(crews[j].hoursOfWork() < workHours){
                    minCrew = crews[j];
                    workHours = crews[j].hoursOfWork();
                }
            }
            minCrew.jobs.add(jobs[minpointer]);
            //System.out.println(minCrew.hoursOfWork());
            minpointer++;
        }
    }

    // this method lets the client figure out how good a job the Dispatcher did
    // Alternatively, you can let the Dispatcher do its own self-evaluation 
    // and expose the stats in different method
    public MovingCompanyCrew[] getCrews() {
        for(int i = 0; i < crews.length; i++){
            System.out.println(crews[i].jobs);
            System.out.println(crews[i].hoursOfWork());
        }
        return crews;
    }
    
 }