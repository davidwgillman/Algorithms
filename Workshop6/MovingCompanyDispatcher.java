/* Randomly generates a day's worth of jobs for H households using V van crews
   H and V may be passed through a constructor or a newDay() method.

   [Suggestion: create an array of MovingCompanyCrew objects;
                a MovingCompanyCrew has a list of jobs and an hoursOfWork() method]

   Orders jobs from longest to shortest and assigns jobs in order to the first available crew.

   Prints the assignment and hours worked by the last crew to get off work.
   */

// imports
import java.util.Random;

import edu.princeton.cs.algs4.Quick;



 public class MovingCompanyDispatcher {
 	private int nCrews = 0;
 	private int nHouseholds = 0;
 	private int[] jobs = null;
 	int jobscounter;

 	private MovingCompanyCrew[] crews = null;

 	public MovingCompanyDispatcher() {
	}

 	public void newDay(int C, int H) {
 		nCrews = C;
 		nHouseholds = H;
 		jobscounter = H;
 		crews = new MovingCompanyCrew[nCrews];
 		jobs = new int[nHouseholds];
 		for(int i = 0; i < nCrews; i++) {
 			crews[i] = new MovingCompanyCrew();
 		}
 	}

 	public double getLowerBound() {
      // lower bound on number of hours worked by last crew to get off work
 		double sum = 0;
 		for(int i = 0; i < jobs.length; i++) {
 			sum += jobs[i];
 		}
 		sum /= nCrews;
 		return sum; 
 	}

 	public void makeJobs() {
 		// generate random jobs
 		Random rand = new Random();
 		
 		for(int i = 0; i < nHouseholds; i++) {
 			jobs[i] = rand.nextInt(9) + 1;
 		}

 		
 	}

 	public void assignJobs() {
 		// order jobs longest to shortest 

 		// assign each job in order to first available crew 
 		
 		if(nCrews >= nHouseholds) {
 			for(int j = 0; j < nHouseholds; j++) {
 				crews[j].addJob(jobs[j]);
 			}
 			
 		}
 		else {
 			for(int e = 0; e < nCrews; e++, jobscounter--) {
 				crews[e].addJob(jobs[e]);
 				
 			}
 			while(jobscounter > 0) {
 				Quick.sort(crews);
 				crews[0].addJob(jobs[jobscounter - 1]);
 				jobscounter--;
 			}
 			
 		}
 		
 		
 		
 	}

 	// this method lets the client figure out how good a job the Dispatcher did
 	// Alternatively, you can let the Dispatcher do its own self-evaluation 
 	// and expose the stats in different method
 	//number of hours and jobs
 	//excess hours worked compared to lower bound
 	public void getCrews() {
 		double lower = this.getLowerBound();
 		for(int i = 0; i < crews.length; i++) {
 			int hours = crews[i].hoursOfWork();
 			double Excess = ((hours - lower)/lower) * 100;
 			System.out.println("Crew: " + i + " Jobs: " + crews[i].jobs.size() + " Hours worked: " + hours + " Excess Hours " + Excess + "%");
 			
 		}
 	}

 	public static void main(String[] args) {
 		MovingCompanyDispatcher dispatch = new MovingCompanyDispatcher();
 		dispatch.newDay(10, 15);
 		dispatch.makeJobs();
 		dispatch.assignJobs();
 		dispatch.getCrews();

 	}

 }