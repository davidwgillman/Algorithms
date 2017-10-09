import java.util.Random;
import edu.princeton.cs.algs4.Insertion;
import java.util.*;
import edu.princeton.cs.algs4.Stopwatch;

/* Randomly generates a day's worth of jobs for H households using V van crews
   H and V may be passed through a constructor or a newDay() method.
   [Suggestion: create an array of MovingCompanyCrew objects;
                a MovingCompanyCrew has a list of jobs and an hoursOfWork() method]
   Orders jobs from longest to shortest and assigns jobs in order to the first available crew.
   Prints the assignment and hours worked by the last crew to get off work.
 */


 public class MovingCompanyDispatcher {
    
    Random random = new Random();
     
    int nCrews = 0;
    int nHouseholds = 0;
    
    
    Double[] jobs = null;
    
    MovingCompanyCrew[] crews= null;
    
    
    double lowerBoundNumber = 0;
    double higherBoundNumber = 0;
    

    public void newDay(int C, int H) {
        nCrews = C;
        nHouseholds = H;
        
        //now assign c as number of crews
        crews = new MovingCompanyCrew[nCrews];  
        
        
        //assign length of jobs as number of households.
        jobs = new Double[nHouseholds];
        
    }

    public double getLowerBound() {
        
        //hours worked for lowest crew
        lowerBoundNumber = 0.0;

        //go through the list of crews...
        for(int a = 0; a < crews.length; a++) {

            //set a base case for comparisons
            if (a == 0) {
                lowerBoundNumber = crews[a].hoursOfWork();

            }
 
            //if theres a new low one, set its hours as the new low
            if (crews[a].hoursOfWork() < lowerBoundNumber) {
                lowerBoundNumber = crews[a].hoursOfWork();
                
            }
            
        }
        
        return lowerBoundNumber; 
    }
    
    public double getHigherBound() {
        
        // higher  bound on numnber of hours worked by last crew to get off work
        higherBoundNumber = 0.0;
        
        
        //again, just loop through all the crews
        for(int b = 0; b < crews.length; b++) {
        
            //start with a base case
            if (b == 0) {
                higherBoundNumber = crews[b].hoursOfWork();
                
            }
            
            //if there's a crew with a new high hours, set that as the new high
            if (crews[b].hoursOfWork() >= higherBoundNumber) {
                higherBoundNumber = crews[b].hoursOfWork();
                
            }
            
        }
        
        return higherBoundNumber; 
    }
    
    
    //this function finds the range (highest hours worked - lowest hours worked) out of the total lowest hours worked.
    public double getExcessHoursAsPercentageOfLowerBound() {
        
        double difference = higherBoundNumber - lowerBoundNumber;
    
        double percent = (difference/lowerBoundNumber) * 100;
        
        return percent;
    
    }

    
    
    public void makeJobs() {
        // generate random jobs
        
        for (int i = 0; i < jobs.length; i++) {
        
              int hours = random.nextInt(4) + 1; //random number of jobs from 
            
              jobs[i] = (double)hours;
        
        }

    }
   
    
    public void makeCrews() {
    
        //create crews
        
        for(int j = 0; j < crews.length; j++) {
            crews[j] = new MovingCompanyCrew();   
        }
    
    }
    
    
    
    public void assignJobs() {
        // order jobs longest to shortest 
        Insertion.sort(jobs);

        //if there are more jobs than crewmembers...
        if (jobs.length >= crews.length) {
            
            int numberOfLoops = jobs.length/crews.length;
            
            int indexesInLastLoop = jobs.length % crews.length;
            
            int jobIndex = 0;
            
            
            //loop through the crews array until all the jobs are filled.
            for(int x = numberOfLoops; x > 0; x--) {
                
                //we loop through all the crew member
                for (int y = 0; y < crews.length; y++) {
                    //set jobs to each one
                    crews[y].setHours(jobs[jobIndex]);
                    
                    //below we print to console the jobs
                    double hoursWorked = crews[y].hoursOfWork();
                    System.out.println("Job assignment: Job " + jobs[jobIndex] + " hours, Crew has worked " + hoursWorked + " hours");
                    
                    //this job counter is used for the loop
                    jobIndex++;
                    
                }
                
            }
            
            //we loop through the remaineder of indexes in last loop
            for (int b = 0; b < indexesInLastLoop; b++) {
                //set jobs to each one
                crews[b].setHours(jobs[jobIndex]);
                
                //below we print to console the jobs
                double hoursWorked = crews[b].hoursOfWork();
                System.out.println("Job assignment: Job " + jobs[jobIndex] + " hours, Crew has worked " + hoursWorked + " hours");
                    
                //this job counter is used for the loop
                jobIndex++;
                
            }
        }
        
        
        //below handels the case when there are more crews than jobs...
        if (crews.length > jobs.length) {
            for (int a = 0; a < jobs.length; a++) {
                crews[a].setHours(jobs[a]);
                
                //below we print to console
                double hoursWorked = crews[a].hoursOfWork();
                System.out.println("Job assignment: Job " + jobs[a] + " hours, Crew has worked " + hoursWorked + " hours");

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
        
        //small array of crew members
        int[] crewsNumbers = new int[4];
        crewsNumbers[0] = 500;
        crewsNumbers[1] = 1000;
        crewsNumbers[2] = 2000;
        crewsNumbers[3] = 4000;
        
        //small array of jobs
        int[] jobsNumbers = new int[4];
        jobsNumbers[0] = 1000;
        jobsNumbers[1] = 2000;
        jobsNumbers[2] = 4000;
        jobsNumbers[3] = 8000;
        
        //init class
        MovingCompanyDispatcher mcd = new MovingCompanyDispatcher();
        
        
        for(int i = 0; i < 4; i++) {
            
            int crewsNumber = crewsNumbers[i];
            int jobsNumber = jobsNumbers[i];
            
            
            mcd.newDay(crewsNumber, jobsNumber);
            mcd.makeJobs();
            mcd.makeCrews();
        
            Stopwatch stopwatch = new Stopwatch();
        
            mcd.assignJobs();
        
            double time = stopwatch.elapsedTime();

            double low = mcd.getLowerBound();
            double high = mcd.getHigherBound();
        
            double percentage = mcd.getExcessHoursAsPercentageOfLowerBound();
        
            System.out.println("Low: " + low);
            System.out.println("High: " + high);
            System.out.println("%: " + percentage);
            System.out.println("time: " + time);
        
        }
    }

 }