/* MovingCompanyCrew: contains a list of jobs in a day's work and an hoursOfWork() method
*/
import java.util.ArrayList;
import java.time.LocalTime;
import edu.princeton.cs.algs4.Insertion;

public class MovingCompanyCrew implements Comparable<MovingCompanyCrew> {
	//double[] jobs = null;
	private final ArrayList<Job> jobs = new ArrayList<Job>();
	private LocalTime endTime = LocalTime.of(0,0);
	private double hours = 0;

	public double hoursOfWork() {
		return hours;
	}

	public void addJob(Job job){
		this.jobs.add(job);
		this.hours += job.getDuration();


		if(this.endTime.isBefore(job.getEndTime())) this.endTime = job.getEndTime();
	}

	public void printJobs(){
		for(Job job : this.jobs){
			System.out.println("\t"+job.getStartTime() + " - " + job.getEndTime());
		}
	}

	public boolean hasConflict(Job that){
		for(Job job : this.jobs){
			if(job.getStartTime().isBefore(that.getStartTime())&&job.getEndTime().isAfter(that.getStartTime())) return true;
			else if(job.getStartTime().isBefore(that.getEndTime())&&job.getEndTime().isAfter(that.getEndTime())) return true;
		}
		return false;
	}

	public int compareTo(MovingCompanyCrew that){
		if(this.endTime.isBefore(that.endTime)) return -1;
		else if(this.endTime.isAfter(that.endTime)) return 1;
		return 0;
	}
}