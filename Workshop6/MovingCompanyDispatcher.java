import java.util.Random;

/* Randomly generates a day's worth of jobs for H households using V van crews
   H and V may be passed through a constructor or a newDay() method.

   [Suggestion: create an array of MovingCompanyCrew objects;
                a MovingCompanyCrew has a list of jobs and an hoursOfWork() method]

   Orders jobs from longest to shortest and assigns jobs in order to the first available crew.

   Prints the assignment and hours worked by the last crew to get off work.
   */

// imports

 public class MovingCompanyDispatcher {
 	private int nCrews = 0;
 	private int nHouseholds = 0;
 	private double[] jobs = null;
 	private int jobpos = 0;

 	private MovingCompanyCrew[] crews = null;

 	public void newDay(int C, int H) {
 		nCrews = C;
 		nHouseholds = H;
 		jobpos = 0;
 		makeCrews();
 		makeJobs();
 	}

 	public double getLowerBound() {
 		// lower bound on number of hours worked by last crew to get off work
 		double jobTimes = 0;
 		for (double job : jobs) {
 			jobTimes += job;
 		}
 		jobTimes = (Math.round((jobTimes/crews.length) * 100.0) / 100.0);
 		return jobTimes; 
 	}
 	
 	public void makeCrews() {
 		crews = new MovingCompanyCrew[nCrews];
 		for (int i = 0; i < crews.length; i++) {
 			crews[i] = new MovingCompanyCrew();
 		}
 	}

 	public void makeJobs() {
 		jobs = new double[nHouseholds];
 		Random rand = new Random();
 		for (int i = 0; i < jobs.length; i++) {
 			jobs[i] = (Math.round(rand.nextDouble() * 1000.0) / 100.0);
 		}
 		
 		// order jobs longest to shortest 
 	 		for (int i = 0; i < jobs.length; i++) {
 	 			int max = 0;
 	 			for (int j = i; j < jobs.length; j++) {
 	 				if (jobs[j] > jobs[max]) {
 	 					max = j;
 	 				}
 	 			double temp = jobs[i];
 	 			jobs[i] = jobs[max];
 	 			jobs[max] = temp;
 	 			}
 	 		}
 	}

 	public void assignJobs() { 		
 		// assign each job in order to first available crew
 		for (MovingCompanyCrew crew : crews) {
 			if (jobpos < jobs.length) {
	 			crew.assignJob(jobs[jobpos]);
	 			jobpos++;
 			}
 		}
 		
 		orderCrews();
 		
 		if (jobpos < jobs.length) {
 			assignJobs();
 		}
 	}
 	
 	private void orderCrews() {
 		for (int i = 0; i < crews.length; i++) {
 			int min = 0;
 			for (int j = i; j < crews.length; j++) {
 				if (crews[j].hoursOfWork() < crews[min].hoursOfWork()) {
 					min = j;
 				}
 			MovingCompanyCrew temp = crews[i];
 			crews[i] = crews[min];
 			crews[min] = temp;
 			}
 		}
 	}

 	// this method lets the client figure out how good a job the Dispatcher did
 	// Alternatively, you can let the Dispatcher do its own self-evaluation 
 	// and expose the stats in different method
 	public void printCrews() {
 		double lowerBound = getLowerBound(); 
 		for (int i = 0; i < crews.length; i++ ) {
 			double crewHours = crews[i].hoursOfWork();
 			System.out.println("\nCrew " + (i + 1) + ": " + crewHours);
 			if (crewHours > lowerBound) {
 				double excessPerc = (Math.round((100 - ((lowerBound/crewHours) * 100.0)) * 100.0) / 100.0);
 				System.out.println("Excess hours: " + (Math.round((crewHours - lowerBound) * 100.0) / 100.0) + " hrs / " + excessPerc + "%");
 			}
 		}
 	}

 	public static void main(String[] args) {
 		MovingCompanyDispatcher mcd = new MovingCompanyDispatcher();
 		mcd.newDay(5, 10);
 		mcd.assignJobs();
 		mcd.printCrews();
 	}

 }