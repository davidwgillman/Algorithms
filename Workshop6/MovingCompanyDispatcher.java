/* Randomly generates a day's worth of jobs for H households using V van crews
   H and V may be passed through a constructor or a newDay() method.

   [Suggestion: create an array of MovingCompanyCrew objects;
                a MovingCompanyCrew has a list of jobs and an hoursOfWork() method]

   Orders jobs from longest to shortest and assigns jobs in order to the first available crew.

   Prints the assignment and hours worked by the last crew to get off work.
   */

// imports
   import java.util.Random;

 public class MovingCompanyDispatcher {
 	private int nCrews = 0;
 	private int nHouseholds = 0;
 	private double[] jobs = null;

 	private MovingCompanyCrew[] crews = null;

 	//public MovingCompanyDispatcher();

 	public void newDay(int C, int H) {
 	}

 	public double getLowerBound() {
 		// lower bound on numnber of hours worked by last crew to get off work
 		return 0; 
 	}

 	public void makeJobs() {
 		// generate random jobs
 		Random r = new Random();
 		
 		int num_jobs = 10 * r.nextInt();
 		for (int i = 0; i < num_jobs; i++) {
 			double value = 1 + (5 * r.nextDouble());
 		}
 	}

 	public void assignJobs() {
 		// order jobs longest to shortest 

 		// assign each job in order to first available crew 
 	}

 	// this method lets the client figure out how good a job the Dispatcher did
 	// Alternatively, you can let the Dispatcher do its own self-evaluation 
 	// and expose the stats in different method
 	public MovingCompanyCrew[] getCrews() {
 		return null;
 	}

 	public static void main(String[] args) {

 	}

 }