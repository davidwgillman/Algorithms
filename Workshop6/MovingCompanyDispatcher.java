import java.util.Random;
import edu.princeton.cs.algs4.Insertion;

/* Randomly generates a day's worth of jobs for H households using V van crews
   H and V may be passed through a constructor or a newDay() method.
   [Suggestion: create an array of MovingCompanyCrew objects;
                a MovingCompanyCrew has a list of jobs and an hoursOfWork() method]
   Orders jobs from longest to shortest and assigns jobs in order to the first available crew.
   Prints the assignment and hours worked by the last crew to get off work.
   */

// imports

 public class MovingCompanyDispatcher {
    
    Random random = new Random();
     
    private int nCrews = 0;
    private int nHouseholds = 0;
    
    
    private Double[] jobs = null;
    
    

    private MovingCompanyCrew[] crews = null;

    //public MovingCompanyDispatcher();

    public void newDay(int C, int H) {
        nCrews = C;
        nHouseholds = H;
        
        //assign length of jobs as number of households.
        jobs = new Double[H];
        
        //now assign c as number of crews
        crews = new MovingCompanyCrew[C];
    }

    public double getLowerBound() {
        // lower bound on numnber of hours worked by last crew to get off work
        return 0; 
    }

    public void makeJobs() {
        // generate random jobs
        
        for (int i = 0; i < jobs.length; i++) {
        
              int hours = random.nextInt(4) + 1; //random number of jobs from 
            
              jobs[i] = (double)hours;
        
        }

    }

    public void assignJobs() {
        // order jobs longest to shortest 
        Insertion.sort(jobs);
        
        //assign each job in order to first available crew 
        if (jobs.length >= crews.length) {
            
            int numberOfLoops = jobs.length/crews.length;
            
            int indexesInLastLoop = jobs.length % crews.length;
            
            int jobIndex = 0;
            
            
            //loop through the crews array until all the jobs are filled.
            for(int x = numberOfLoops; x > 0; x--) {
                
                //we loop through all the crew member
                for (int a = 0; a < crews.length; a++) {
                    //set jobs to each one
                    crews[a].setHours(jobs[jobIndex]);
                    
                    //this job counter is used for the loop
                    jobIndex++;
                    
                }
                
            }
            
            //we loop through the remaineder of indexes in last loop
            for (int b = 0; b < indexesInLastLoop; b++) {
                //set jobs to each one
                crews[b].setHours(jobs[jobIndex]);
                    
                //this job counter is used for the loop
                jobIndex++;
                    
            }
            
        }
        
        
        
        if (crews.length > jobs.length) {
            for (int a = 0; a < jobs.length; a++) {
                crews[a].setHours(jobs[a]);
            }
        }
        
        
  
      
    }

    // this method lets the client figure out how good a job the Dispatcher did
    // Alternatively, you can let the Dispatcher do its own self-evaluation 
    // and expose the stats in different method
    public MovingCompanyCrew[] getCrews() {
        
        
        return crews;

    }

    public static void main(String[] args) {

    }

 }