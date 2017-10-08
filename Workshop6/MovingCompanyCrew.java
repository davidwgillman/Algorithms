/* MovingCompanyCrew: contains a list of jobs in a day's work and an hoursOfWork() method
*/

public class MovingCompanyCrew {
	double[] jobs = new double[10];
	int njobs = 0;

	public double hoursOfWork() {
		double acc = 0;
		for (double job : jobs) {
			acc += job;
		}
		return acc;
	}
	
	public void assignJob(double job) {
		jobs[njobs] = job;
		njobs++;
	}
	
}