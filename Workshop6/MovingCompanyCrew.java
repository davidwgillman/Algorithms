/* MovingCompanyCrew: contains a list of jobs in a day's work and an hoursOfWork() method
*/

public class MovingCompanyCrew implements Comparable<MovingCompanyCrew> {
	double[] jobs = null;

	public MovingCompanyCrew(int jobsN) {
		jobs = new double[jobsN];
		for (int i = 0; i < jobsN; i++){
			jobs[i] = 0;

		}
	}

	public double hoursOfWork() {
		//adds up hours of work for each crew
		double sum = 0;
		for (double d : jobs) {
			sum += d;
		}
		return sum;
	}

	public int compareTo(MovingCompanyCrew m) {
		double dif = this.hoursOfWork()-m.hoursOfWork();
		if (dif<0)
			return -1;
		else if (dif>0)
			return 1;
		return 0;
	}

