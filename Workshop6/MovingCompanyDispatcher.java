import java.util.Arrays;

/* Randomly generates a day's worth of jobs for H households using V van crews
   H and V may be passed through a constructor or a newDay() method.

   [Suggestion: create an array of MovingCompanyCrew objects;
                a MovingCompanyCrew has a list of jobs and an hoursOfWork() method]

   Orders jobs from longest to shortest and assigns jobs in order to the first available crew.

   Prints the assignment and hours worked by the last crew to get off work.
   */

// imports

 public class MovingCompanyDispatcher {
 	private int nCrews = 0;
 	private int nHouseholds = 0;
 	private double[] jobs = null;
 	private MovingCompanyCrew[] crews = null;

 	public MovingCompanyDispatcher(){}
 	public void newDay(int C, int H, boolean fairer) {
 		nCrews=C;
 		crews=new MovingCompanyCrew[nCrews];
 		nHouseholds=H;
 		jobs=new double[nHouseholds];
 		makeCrews();
 		makeJobs();
 		if(fairer)
 			assignJobsFairer();
 		else
 			assignJobs();
 	}
 	public void newDay(int C, double[] J, boolean fairer) {
 		int H=J.length;
 		nCrews=C;
 		crews=new MovingCompanyCrew[nCrews];
 		nHouseholds=H;
 		jobs=new double[nHouseholds];
 		makeCrews();
 		jobs=J;
 		if(fairer)
 			assignJobsFairer();
 		else
 			assignJobs();
 	}
 	public double getUpperBound() {
 		// upper bound on number of hours worked by last crew to get off work
 		MovingCompanyCrew max=crews[0];
		for(int i=1;i<crews.length;i++)
			if(crews[i].compareTo(max)>0)
				max=crews[i];
		return max.hoursOfWork();
 	}
 	public double getLowerBound() {
 		// lower bound on number of hours worked by last crew to get off work
 		// Returns the avg number of hours each crew must work.
 		// This lower bound is often only possible if jobs are split between workers.
 		double count=0;
 		for(int i=0;i<jobs.length;i++)
 			count+=jobs[i];
 		double avgPerCrew=count/nCrews;
 		return avgPerCrew;
 	}
 	public int findLazyestWorker(){
 		int minI=0;
 		MovingCompanyCrew min=crews[0];
 		for(int i=1;i<crews.length;i++)
 			if(crews[i].compareTo(min)<0){
 				minI=i;
 				min=crews[i];
 			}
 		return minI;
 	}
 	public void makeJobs() {
 		// generate random jobs
 		for(int i=0;i<jobs.length;i++)
 			jobs[i]=Math.random()*7+1; //random double [1,7)
 	}
 	public void makeCrews(){
 		//Create crews with room for nJobs
 		for(int i=0;i<crews.length;i++)
 			crews[i]=new MovingCompanyCrew(nHouseholds);
 	}
 	public void assignJobs() {
 		// order jobs shortest to longest
 		Arrays.sort(jobs);

 		// assign each job in order (starting with largest) to first available crew
 		for(int i=jobs.length-1;i>=0;i--)
 			crews[findLazyestWorker()].addJob(jobs[i]);
 	}
 	public void assignJobsFairer() {
 		assignJobs();
 		for(int a=0;a<crews.length-1;a++) //For each crew
 			for(int i=0;i<crews[a].numJobs();i++) //For each job in that crew
 				for(int b=a+1;b<crews.length;b++) //Check each other crew after it
 					for(int j=0;j<crews[b].numJobs();j++) //For each job in that crew
 						trySwap(crews[a],i,crews[b],j);
 	}
 	//Checks and attempts a swap of jobs between crews
 	//a=which crew swapping from, i=index for that crew
 	//b=which crew swapping to, j=index for that crew
 	public void trySwap(MovingCompanyCrew a,int i,MovingCompanyCrew b,int j){
 		double hoursA=a.hoursOfWork();
 		double hoursB=b.hoursOfWork();
 		double crewDiff=hoursA-hoursB;
 		double jobA=a.getJob(i);
 		double jobB=b.getJob(j);
 		double jobDiff=jobA-jobB;
 		//If jobDiff is in between 0 and crewDiff:
 		if(((jobDiff>0)&&(jobDiff<crewDiff)) || ((jobDiff<0)&&(jobDiff>crewDiff)))
 			swap(a,i,b,j);
 	}
 	public void swap(MovingCompanyCrew a,int i,MovingCompanyCrew b,int j){
 		double jobA=a.getJob(i);
 		a.setJob(i,b.getJob(j));
 		b.setJob(j,jobA);
 	}
 	// this method lets the client figure out how good a job the Dispatcher did
 	// Alternatively, you can let the Dispatcher do its own self-evaluation 
 	// and expose the stats in different method
 	public void printStats() {
 		for(int i=0;i<nCrews;i++)
 			System.out.println(crews[i]);
 		double upper=getUpperBound();
 		double lower=getLowerBound();
 		double diff=upper-lower;
 		double diffP=diff/lower;
 		System.out.println("Hardest Worker: "+upper+" hours");
 		System.out.println("Theoretical Lower Bound: "+lower+" hours");
 		System.out.println("Difference: "+diff+" hours");
 		System.out.println("Difference as a Percentage of the Lower Bound: "+diffP*100+"%");
 	}

 	public static void main(String[] args) {
 		MovingCompanyDispatcher comp=new MovingCompanyDispatcher();
 		double[] a=new double[]{9,8,7,6,5,4,3,2};
 		comp.newDay(3,a,false);
 		comp.printStats();
 	}
 }