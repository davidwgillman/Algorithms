/* MovingCompanyCrew: contains a list of jobs in a day's work and an hoursOfWork() method
*/
import java.util.*;
public class MovingCompanyCrew{
	public ArrayList<Integer> jobs = new ArrayList<Integer>();

	public double hoursOfWork() {
	    double sum = 0;
		for(int i = 0; i < jobs.size(); i++){
		    sum += jobs.get(i);
		  }
		return sum;
	}
}
	
