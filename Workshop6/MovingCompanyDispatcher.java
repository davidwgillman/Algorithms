/* Randomly generates a day's worth of jobs for H households using V van crews
   H and V may be passed through a constructor or a newDay() method.

   [Suggestion: create an array of MovingCompanyCrew objects;
                a MovingCompanyCrew has a list of jobs and an hoursOfWork() method]

   Orders jobs from longest to shortest and assigns jobs in order to the first available crew.

   Prints the assignment and hours worked by the last crew to get off work.
   */

// imports
 //import edu.princeton.cs.algs4.StdRandom;
 //import edu.princeton.cs.algs4.insertion;
 import java.util.*;

 public class MovingCompanyDispatcher {
 	private int nCrews = 0;
 	private int nHouseholds = 0;
 	private double[] jobs = null;

 	private MovingCompanyCrew[] crews = null;

 	public MovingCompanyDispatcher() {

 	}

 	public void newDay(int C, double[] J) {
 		int H = J.length;
 		nCrews = C;
 		crews = new MovingCompanyCrew[nCrews];
		nHouseholds = H;
 		jobs = new double[nHouseholds];
 		makeCrews();
 		jobs = J;	
 	}

 	public double getLowerBound() {
 		// lower bound on numnber of hours worked by last crew to get off work
 		double sum = 0;
 		for (int i=0; i < jobs.length; i++) {
 			sum += jobs[i];
 		}
 		double avg = sum/nCrews;
 		return avg; 
 	}

 	public void makeCrews() {
 		for (int i = 0; i < nCrews; i++){
 			crews[i] = new MovingCompanyCrew(nHouseholds);
 		}


 	}

 	public void makeJobs() {
 		// generate random jobs
 		double rndm = Math.random()*7+1;
 		for (int i = 0; i < nHouseholds; i++) {
 			jobs[i] = rndm;
 		}

 	}

 	public MovingCompanyCrew leastNumOfWork() {
 		int minInd = 0;
 		MovingCompanyCrew min = crews[0];
 		for (int i = 1; i < crews.length; i++) {
 			if (crews[i].compareTo(min) < 0) {
 			minInd = i;
 			min = crews[i];
 			}
 		}
 		return min;
 	}


 	public void addJobs(double job){
 		int i = 0;
 		while (jobs[i]>0.0) {
 			i++;
 		}
 		jobs[i] = job;
 	}

 	public void assignJobs() {
 		// order jobs longest to shortest 
 		Arrays.sort(jobs);
		// assign each job in order to first available crew
		for (int i = 0; i < jobs.length; i--) {
			MovingCompanyCrew min = leastNumOfWork();
			min.addJobs(jobs[i]);
		} 
 	}

 	// this method lets the client figure out how good a job the Dispatcher did
 	// Alternatively, you can let the Dispatcher do its own self-evaluation 
 	// and expose the stats in different method
 	public MovingCompanyCrew[] getCrews() {
 		for (int i=0; i<nCrews;i++) {
 			System.out.println(crews[i]);
 		}
 		double lowerBound = getLowerBound();
 		System.out.println("Lower Bound: " + lowerBound + "hours");
 	}

 	public static void main(String[] args) {
 		MovingCompanyDispatcher mcp = new MovingCompanyDispatcher();
 		double[] j = new double[] {9,8,7,6,5,4,3,2};
 		mcp.newDay(2,j);
 		mcp.makeJobs()
 		mcp.assignJobs();
 		mcp.getCrews();

 	}

 }