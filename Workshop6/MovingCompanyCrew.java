import java.util.Arrays;

/* MovingCompanyCrew: contains a list of jobs in a day's work and an hoursOfWork() method
*/

public class MovingCompanyCrew implements Comparable<MovingCompanyCrew> {
	double[] jobs = null;

	public MovingCompanyCrew(int nJobs){
		jobs=new double[nJobs];
		for(int i=0;i<nJobs;i++)
			jobs[i]=0.0;
	}
	public void addJob(double job){
		int i=0;
		for(;jobs[i]>0.0;i++);
		jobs[i]=job;
	}
	public double hoursOfWork() {
		double totalHours=0.0;
		for(int i=0;i<jobs.length;i++)
			totalHours+=jobs[i];
		return totalHours;
	}
	public int compareTo(MovingCompanyCrew o) {
		double diff=this.hoursOfWork()-o.hoursOfWork();
		if(diff<0)
			return -1;
		else if(diff>0)
			return 1;
		return 0;
	}
	public String toString(){
		String str="[";
		for(int i=0;i<jobs.length && jobs[i]!=0.0;i++)
			str+=" "+jobs[i];
		str+=" ]";
		return str;
	}
	
}