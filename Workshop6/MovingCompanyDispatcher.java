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

 	private MovingCompanyCrew[] crews = null;

 	public MovingCompanyDispatcher()

 	public newDay(int C, int H) {
 	}

 	public double getLowerBound() {
 		// lower bound on numnber of hours worked by last crew to get off work
 		return ; 
 	}

 	public void makeJobs() {
 		// generate random jobs
 	}

 	public void assignJobs() {
 		// order jobs longest to shortest 

 		// assign each job in order to first available crew 
 	}

 	public MovingCompanyCrew[] getCrews() {

 	}

 	public static void main(String[] args) {

 	}

 }