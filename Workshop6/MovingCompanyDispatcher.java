/* Randomly generates a day's worth of jobs for H households using V van crews
   H and V may be passed through a constructor or a newDay() method.

   [Suggestion: create an array of MovingCompanyCrew objects;
                a MovingCompanyCrew has a list of jobs and an hoursOfWork() method]

   Orders jobs from longest to shortest and assigns jobs in order to the first available crew.

   Prints the assignment and hours worked by the last crew to get off work.
   */

// imports
<<<<<<< HEAD
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import edu.princeton.cs.algs4.Quick;


=======
>>>>>>> origin/master

 public class MovingCompanyDispatcher {
 	private int nCrews = 0;
 	private int nHouseholds = 0;
<<<<<<< HEAD
 	private Integer[] jobs = null;
 	int counter;

 	private MovingCompanyCrew[] crews = null;

 	public MovingCompanyDispatcher() {
	}

 	public void newDay(int C, int H) {
 		nCrews = C;
 		nHouseholds = H;
 		counter = H;
 		crews = new MovingCompanyCrew[nCrews];
 		jobs = new Integer[nHouseholds];
 		
 		for(int i = 0; i < nCrews; i++) {
 			crews[i] = new MovingCompanyCrew();
 		}
 	}

 	public double getLowerBound() {
      // Assumes the jobs could be assigned so that each crew gets the same number of hours
 		double sum = 0;
 		for(int i = 0; i < jobs.length; i++) {
 			sum += jobs[i];
 		}
 		sum /= nCrews;
 		return sum; 
=======
 	private double[] jobs = null;

 	private MovingCompanyCrew[] crews = null;

 	public MovingCompanyDispatcher()

 	public newDay(int C, int H) {
 	}

 	public double getLowerBound() {
 		// lower bound on numnber of hours worked by last crew to get off work
 		return ; 
>>>>>>> origin/master
 	}

 	public void makeJobs() {
 		// generate random jobs
<<<<<<< HEAD
 		Random rand = new Random();
 		
 		for(int i = 0; i < nHouseholds; i++) {
 			jobs[i] = rand.nextInt(9) + 1;
 		}
 		
 		Arrays.sort(jobs, Collections.reverseOrder());
 	}

 	public void assignJobs() { 
 		// Assigns additional jobs from greatest to least to crew that have the least amount of work to the greatest amount of work.
 		if(nCrews >= nHouseholds) {
 			for(int first = 0; first < nHouseholds; first++) {
 				crews[first].addJob(jobs[first]);
 			}
 			
 		}
 		else {
 			for(int it = 0; it < nCrews; it++, counter--) {
 				crews[it].addJob(jobs[it]);
 			}
 			
 			while(counter < jobs.length) {
 				Quick.sort(crews);
 				crews[0].addJob(jobs[counter]);
 				counter++;
 			}
 			
 		}
 		
 		
 		
=======
 	}

 	public void assignJobs() {
 		// order jobs longest to shortest 

 		// assign each job in order to first available crew 
>>>>>>> origin/master
 	}

 	// this method lets the client figure out how good a job the Dispatcher did
 	// Alternatively, you can let the Dispatcher do its own self-evaluation 
 	// and expose the stats in different method
<<<<<<< HEAD
 	//number of hours and jobs
 	//excess hours worked compared to lower bound
 	public void getCrews() {
 		double lower = this.getLowerBound();
 		Quick.sort(crews);
 		for(int i = 0; i < crews.length; i++) {
 			int hours = crews[i].hoursOfWork();
 			double Excess = ((hours - lower)/lower) * 100;
 			System.out.println("Crew Number: " + i + "\nJobs: " + crews[i].jobs.size() + " Worked for: " + hours + " hours Excess Amount Worked: " + Excess + "%");
 			
 		}
 	}

 	public static void main(String[] args) {
 		MovingCompanyDispatcher Movers = new MovingCompanyDispatcher();
 		Movers.newDay(10, 20);
 		Movers.makeJobs();
 		Movers.assignJobs();
 		Movers.getCrews();
=======
 	public MovingCompanyCrew[] getCrews() {

 	}

 	public static void main(String[] args) {
>>>>>>> origin/master

 	}

 }