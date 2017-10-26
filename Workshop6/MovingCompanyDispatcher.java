/* Randomly generates a day's worth of jobs for H households using V van crews
   H and V may be passed through a constructor or a newDay() method.

   [Suggestion: create an array of MovingCompanyCrew objects;
                a MovingCompanyCrew has a list of jobs and an hoursOfWork() method]

   Orders jobs from longest to shortest and assigns jobs in order to the first available crew.

   Prints the assignment and hours worked by the last crew to get off work.
   */

import java.util.*;

 public class MovingCompanyDispatcher {
 	private int nCrews = 0;
 	private int nHouseholds = 0;
 	private Double[] jobs = null;
 	private MovingCompanyCrew[] crews = null;
	Random Rand = new Random();

 	public MovingCompanyDispatcher(){
		this.nHouseholds = Rand.nextInt(10) + 1;
		this.nCrews = Rand.nextInt(5) + 1;
	 }

 	public void newDay(int C, int H) {
		this.nCrews = C;
		this.nHouseholds = H;
		makeCrews();
		makeJobs();
		assignJobs();
 	}

 	public Double getLowerBound() {
		 // lower bound on number of hours worked by last crew to get off work
		double totalHours = 0;
 		for(int i = 0; i < jobs.length; i++)
 			totalHours += jobs[i];
 		double lowerBound = totalHours/nCrews;
 		return lowerBound;
 	}

 	public void makeJobs() {
		jobs = new Double[nHouseholds];
		for(int i = 0; i < jobs.length; i++){
			jobs[i] = Math.random() * 4;
		}
	 }

	public void makeCrews(){
		crews = new MovingCompanyCrew[nCrews];
		for(int n = 0; n < nCrews; n++){
			crews[n] = new MovingCompanyCrew();
		}
	}

	private int laziestWorker(){
		int minimum = 0;
		MovingCompanyCrew currentMin =crews[0];
		for(int i = 1;i < crews.length; i++)
			if(crews[i].compareTo(currentMin) < 0){
				minimum = i;
				currentMin = crews[i];
			}
		return minimum;
	}

 	public void assignJobs() {
		// order jobs longest to shortest 
		Collections.reverse(Arrays.asList(jobs));
		// assign each job in order to first available crew
		for(int j = 0; j < jobs.length; j++){
			crews[laziestWorker()].jobsOfCrew.add(jobs[j]);
		}
	 }
	 
 	// this method lets the client figure out how good a job the Dispatcher did
 	// Alternatively, you can let the Dispatcher do its own self-evaluation 
	// and expose the stats in different method
	 
 	public void printEvaluation() {
		double lb = getLowerBound();
		System.out.println("The lowest bound was " + lb + " hours.");
		 for (int i = 0; i < crews.length; i++ ) {
			int crewNum = i + 1;
			double numberOfHours = crews[i].hoursOfWork();
			System.out.println("Crew number " + crewNum + " worked " + numberOfHours + " hours.");
			if (numberOfHours > lb){
				double excessHours = numberOfHours - lb;
				System.out.println("Crew number " + crewNum + " worked an excess of " + excessHours + " hours");
			}
		 }

 	}

 	public static void main(String[] args) {
		MovingCompanyDispatcher test = new MovingCompanyDispatcher();
		test.newDay(4, 10);
		test.printEvaluation();
 	}
 }