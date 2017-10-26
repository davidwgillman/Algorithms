<<<<<<< HEAD
import java.util.ArrayList;

/* MovingCompanyCrew: contains a list of jobs in a day's work and an hoursOfWork() method
*/

public class MovingCompanyCrew implements Comparable<MovingCompanyCrew> {
	 ArrayList<Integer> jobs = new ArrayList<>();
	Integer hours = 0;

	public Integer hoursOfWork() {
		return hours;
	}
	
	public void addJob(Integer job) {
		jobs.add(job);
		hours += job;
	}
	
	@Override
	public int compareTo(MovingCompanyCrew args0) {
		// TODO Auto-generated method stub
		return this.hoursOfWork().compareTo(args0.hoursOfWork());
	}
	
}
=======
/* MovingCompanyCrew: contains a list of jobs in a day's work and an hoursOfWork() method
*/

public class MovingCompanyCrew implements Comparable<MovieScore> {
	double[] jobs = null;

	public double hoursOfWork() {
		
	}
>>>>>>> origin/master
