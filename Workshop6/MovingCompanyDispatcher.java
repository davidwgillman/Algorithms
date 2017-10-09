/* Randomly generates a day's worth of jobs for H households using V van crews
   H and V may be passed through a constructor or a newDay() method.

   [Suggestion: create an array of MovingCompanyCrew objects;
                a MovingCompanyCrew has a list of jobs and an hoursOfWork() method]

   Orders jobs from longest to shortest and assigns jobs in order to the first available crew.

   Prints the assignment and hours worked by the last crew to get off work.
   */

// imports

import java.util.*;

 public class MovingCompanyDispatcher {
 	private int nCrews = 0;
 	private int nHouseholds = 0;
 	private double[] jobs = null;
	private MovingCompanyCrew[] crews = null;
	Random rand = new Random();
	 
	public MovingCompanyDispatcher(){
		 this.nHouseholds = rand.nextInt(10) + 1;
		 this.nCrews = rand.nextInt(5) + 1;
	 }

 	public void newDay(int C, int H) {
		 this.nCrews = C;
		 this.nHouseholds = H;
		 makeCrews();
		 makeJobs();
		 assignJobs();
	 }
	 
	public void makeCrews(){
		crews = new MovingCompanyCrew[nCrews];
		for(int n=0; n < nCrews; n++){
			crews[n]=new MovingCompanyCrew();
		}
	}

 	public double getLowerBound() {
		// lower bound on number of hours worked by last crew to get off work
		 double hours =0.0;
		 for(int n=0; n < jobs.length; n++){
			hours += jobs[n];
		 }
		  double lowerbound = (hours/nCrews);
		  return lowerbound;
 	}

 	public void makeJobs() {
		 // generate random jobs
		 jobs = new double[nHouseholds];
		 for(int n = 0; n< jobs.length; n++){
			 jobs[n] = Math.random() * 4;
		 }
 	}

 	public void assignJobs() {
		// order jobs longest to shortest 
		Collections.reverse(Arrays.asList(jobs));
		// assign each job in order to first available crew
		for(int k = 0; k < jobs.length; k++){
			crews[leastwork()].jobsOfCrew.add(jobs[k]);
		}
	 }
	 
	 public int leastwork(){
		int min = 0;
		MovingCompanyCrew currentleast = crews[0];
		for(int n=1; n < crews.length; n++){
			if(currentleast.compareTo(crews[n]) > 0){
				currentleast = crews[n];
				min = n;
			}
		}
		return min;
	 }

 	// this method lets the client figure out how good a job the Dispatcher did
 	// Alternatively, you can let the Dispatcher do its own self-evaluation 
 	// and expose the stats in different method
 	public void evaluation(){
		double low = getLowerBound();
		 System.out.println("Lowest Bound: " + low);
		 for(int n=0; n < crews.length; n++){
			System.out.println("Crew " + (n + 1) + " worked " + crews[n].hoursOfWork() + " Hours");
			if(crews[n].hoursOfWork() > low){
				double excesshours = crews[n].hoursOfWork() - low;
				double excesspercent = (excesshours/low)*100;
				System.out.println("Crew " + (n + 1) + " worked an excess of " + excesspercent + "%");
				if(excesshours <= 1){
					System.out.println("Dispatcher did a great job");
				}
				if(excesshours > 1  & excesshours < 2){
					System.out.println("Dispatcher did a decent job");
				}
				if(excesshours > 2){
					System.out.println("Dispatcher did a bad job");
				}
			}
		 }
	 }

 	public static void main(String[] args) {
		MovingCompanyDispatcher tester = new MovingCompanyDispatcher();
		tester.newDay(3, 12);
		tester.evaluation();
 	}

 }