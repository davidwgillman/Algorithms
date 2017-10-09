/* MovingCompanyCrew: contains a list of jobs in a day's work and an hoursOfWork() method
*/

import java.util.ArrayList;

public class MovingCompanyCrew implements Comparable<MovingCompanyCrew> {
	//double[] jobs = null;
	ArrayList<Double> jobList = new ArrayList<Double>();

	public double hoursOfWork() {
		//System.out.println("we got here");
		double sum = 0;
		for (int i = 0; i < jobList.size(); i++){
			sum += jobList.get(i);
		}
		return sum;
	}

	public int compareTo(MovingCompanyCrew o) {
		MovingCompanyCrew b = (MovingCompanyCrew) o;
		double me = hoursOfWork();
		double them = b.hoursOfWork();
		if (them > me) { return -1; } else 
		if (me > them) { return 1; } else
		return 0;
	}

	public void assignJob(double time) {
		jobList.add(time);
	}
}
