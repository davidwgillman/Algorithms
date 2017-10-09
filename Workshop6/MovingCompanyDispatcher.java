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
 	private int nCrews = 2;
 	private int nHouseholds = 5;
 	private double[] jobs = new double[nHouseholds];
 	// make this an arraylist

 	private MovingCompanyCrew[] crews = new MovingCompanyCrew[nCrews];

 	public MovingCompanyDispatcher(){
 		Random r = new Random();
 		//nHouseholds = 1 + 20 * r.nextInt();
 	}

 	public double[] getJobs() {
 		return jobs;
 	}

 	public void newDay(int C, int H) {
 		nCrews = C;
 		nHouseholds = H;
 		for (int i = 0; i < nCrews; i++) {
 			crews[i] = new MovingCompanyCrew();
 		}
 	}

 	public double getLowerBound() {
 		double sum = 0;
 		for (int i = 0; i < jobs.length; i++) {
 			sum += jobs[i];
 		}
 		return sum /= crews.length;
 	}

 	public void makeJobs() {
 		// generate random jobs
 		Random r = new Random();
 		
 		for (int i = 0; i < nHouseholds; i++) {
 			double value = 1 + (5 * r.nextDouble());
 			jobs[i] = value;
 		}
 	}

 	public void assignJobs() {
 		// order jobs longest to shortest 

 		// sort decending
 		Arrays.sort(jobs);

 		// reverse
 		for(int i = 0; i < jobs.length / 2; i++)
		{
    		double temp = jobs[i];
    		jobs[i] = jobs[jobs.length - i - 1];
    		jobs[jobs.length - i - 1] = temp;
		}

 		// assign each job in order to first available crew

 		
 		for (int i = 0; i < nHouseholds; i++) {
 			// sort crews
 			sortCrews();
 			// assign job to lowest crew
 			crews[0].assignJob(jobs[i]);
 
 		}


 	}

 	// this method lets the client figure out how good a job the Dispatcher did
 	// Alternatively, you can let the Dispatcher do its own self-evaluation 
 	// and expose the stats in different method
 			// I chose to use this as my getter, evaluatePerfomance() checks how well it did 
 	public MovingCompanyCrew[] getCrews() {
 		return crews;
 	}

 	public double evaluatePerfomance() {
 		sortCrews();
 		double longest = crews[crews.length -1].hoursOfWork();
 		return 100 * (longest - getLowerBound()) / getLowerBound();

 	}

 	// made a seperate method bc i kept changing data types
 	public void sortCrews() {
 		Arrays.sort(crews);
 	}

 	public static void main(String[] args) {
 		MovingCompanyDispatcher MCD = new MovingCompanyDispatcher();
 		MCD.newDay(2,5);
 		MCD.makeJobs();
 		MCD.assignJobs();

 		double jobs[] = MCD.getJobs();
 		for (int i = 0; i < jobs.length; i++) {
 			//System.out.println(jobs[i]);
 		}

 		MovingCompanyCrew[] crews = MCD.getCrews();
 		System.out.println("\nHours of work:");
 		for (int i = 0; i < crews.length; i ++) {
 			System.out.println(crews[i].hoursOfWork());
 		}

 		System.out.printf("\nTheoretical Optimum: %f\n",MCD.getLowerBound());
 		System.out.printf("\nExcess: %.2f%%\n",MCD.evaluatePerfomance());
 	}

 }