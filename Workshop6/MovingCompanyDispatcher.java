/* Randomly generates a day's worth of jobs for H households using V van crews
   H and V may be passed through a constructor or a newDay() method.

   [Suggestion: create an array of MovingCompanyCrew objects;
                a MovingCompanyCrew has a list of jobs and an hoursOfWork() method]

   Orders jobs from longest to shortest and assigns jobs in order to the first available crew.

   Prints the assignment and hours worked by the last crew to get off work.
   */
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Insertion;
import java.time.LocalTime;

 public class MovingCompanyDispatcher {
 	private int nCrews = 0;
 	private int nHouseholds = 0;
 	private Job[] jobs = null;

 	private MovingCompanyCrew[] crews = null;

 	public MovingCompanyDispatcher(){};

 	public void newDay(int C, int H) {
 		this.nCrews = C;
 		this.nHouseholds = H;

 		this.crews = new MovingCompanyCrew[nCrews];
 		this.jobs = new Job[nHouseholds];

 		for(int i = 0; i < this.nCrews; i++){
            this.crews[i] = new MovingCompanyCrew();
        }
 	}

 	public double getLowerBound() {
 		// lower bound on numnber of hours worked by last crew to get off work
 		double totalHours = 0;

 		for(MovingCompanyCrew crew : crews){
 			totalHours += crew.hoursOfWork();
 		}

 		return (double)(totalHours/this.nCrews); 
 	}

 	// this function finds the range (highest hours worked - lowest hours worked) out of the total lowest hours worked
	public double getExcessHoursAsPercentageOfLowerBound() {
		double lower = getLowerBound(), higher = this.crews[this.crews.length-1].hoursOfWork(); //crews are ordered by time they get off, last is last to get off

	    double difference = higher-lower;

	    double percent = (difference/lower) * 100;

	    return percent;
	}

 	public void makeJobs() {
 		// generate random jobs
 		for (int i = 0; i < this.jobs.length; i++) {
			this.jobs[i] = new Job(LocalTime.of(StdRandom.uniform(6,19), StdRandom.uniform(0,60)), StdRandom.uniform(1,4));
		}
 	}

 	public void assignJobs() {
 		// order jobs longest to shortest 
 		Insertion.sort(this.jobs);

 		// assign each job in order to first available crew 
 		for(Job job : this.jobs){
 			int i = 0;
 			boolean possible = true;
 			Insertion.sort(this.crews); //sort crews by endTime of last job
 			while(this.crews[i].hasConflict(job) && possible){
 				i++;
 				if(i==this.crews.length){
 					i = 0;
 					possible = false;
 				} 
 			}
 			
 			if(possible) this.crews[i].addJob(job);
 			else System.out.println("No possible assignment:\t"+job.getStartTime()+" - "+job.getEndTime());
 		}

 	}

 	// this method lets the client figure out how good a job the Dispatcher did
 	// Alternatively, you can let the Dispatcher do its own self-evaluation 
 	// and expose the stats in different method
 	public MovingCompanyCrew[] getCrews() {
 		return this.crews;
 	}

 	public void getEvaluation(){
 		for(int i = 0; i < this.crews.length; i++){
 			System.out.println("Crew " +i+ ":\t" +this.crews[i].hoursOfWork());
 			this.crews[i].printJobs();
 		}

 		System.out.println("Lowerbound for hours worked:\t"+getLowerBound());
 		System.out.println("Hours worked by last crew:\t"+this.crews[this.crews.length-1].hoursOfWork());
 		System.out.printf("Excess hours as precentaage of lowerbound:\t %.2f",getExcessHoursAsPercentageOfLowerBound());
 		System.out.println();
 	}

 	public static void main(String[] args) {
 		MovingCompanyDispatcher test = new MovingCompanyDispatcher();
        
        test.newDay(5,13);
        test.makeJobs();
        test.assignJobs();
        test.getEvaluation();
 	}

 }