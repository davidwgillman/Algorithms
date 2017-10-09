/* MovingCompanyCrew: contains a list of jobs in a day's work and an hoursOfWork() method
*/
import java.util.*;
public class MovingCompanyCrew implements Comparable<MovingCompanyCrew> {
	ArrayList<Double> jobsOfCrew= new ArrayList<Double>();

	public int compareTo(MovingCompanyCrew crew){
		if(this.hoursOfWork() > crew.hoursOfWork()){
			return 1;
		}
		if(this.hoursOfWork() < crew.hoursOfWork()){
			return -1;
		}
		else{
			return 0;
		}
	}

	public Double hoursOfWork() {
		Double sumhours = 0.0;
		for(int n=0; n< jobsOfCrew.size(); n++){
			sumhours += jobsOfCrew.get(n);
		}
		return sumhours;
	}
}