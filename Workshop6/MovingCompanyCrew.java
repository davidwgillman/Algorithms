/* MovingCompanyCrew: contains a list of jobs in a day's work and an hoursOfWork() method
*/
<<<<<<< HEAD
import java.util.*;

public class MovingCompanyCrew implements Comparable<MovingCompanyCrew> {
	ArrayList<Double> jobsOfCrew = new ArrayList<Double>();

	public int compareTo(MovingCompanyCrew c){
		if (this.hoursOfWork() > c.hoursOfWork()){
			return 1;
		}
		else if(this.hoursOfWork() < c.hoursOfWork()){
			return -1;
		}
		else{
			return 0;
		}
	}

	public Double hoursOfWork() {
		Double totalHours = 0;
		for(int i = 0; i < jobsOfCrew.size(); i++){
			totalHours += jobsOfCrew.get(i);
		}
		return totalHours;
	}
}
=======

public class MovingCompanyCrew implements Comparable<MovieScore> {
	double[] jobs = null;

	public double hoursOfWork() {
		
	}
>>>>>>> origin/master
