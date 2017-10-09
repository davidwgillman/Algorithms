import java.util.Random;
import edu.princeton.cs.algs4.Insertion;
import java.util.*;
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
     
    int nCrews = 0;
    int nHouseholds = 0;
    
    
    Double[] jobs = null;
    
    MovingCompanyCrew[] crews= null;
    

    
    double lowerBoundNumber = 0;
    double higherBoundNumber = 0;
    
    /*
    public MovingCompanyDispatcher() {

    }
    */

    public void newDay(int C, int H) {
        nCrews = C;
        nHouseholds = H;
        
        //now assign c as number of crews
        crews = new MovingCompanyCrew[nCrews];  
        
        
        //assign length of jobs as number of households.
        jobs = new Double[nHouseholds];
        
    }

    public double getLowerBound() {
        // lower bound on numnber of hours worked by last crew to get off work
        
        //hours worked for lowest crew
        lowerBoundNumber = 0.0;
        
        //lowest working crew member
        MovingCompanyCrew lowestWorkingCrew = crews[0];
        
        
        //go through the list of crews...
        for(int a = 0; a < crews.length; a++) {
        
            //if theeres a new low one, set it as officla crew.
            
            if(crews[a].compareTo(lowestWorkingCrew) < 0) {
                lowestWorkingCrew = crews[a];
            }
            
            if (crews[a].hoursOfWork() < lowerBoundNumber) {
                lowerBoundNumber = crews[a].hoursOfWork();
                
            }
            
        }
        
        return lowerBoundNumber; 
    }
    
    public double getHigherBound() {
        // higher  bound on numnber of hours worked by last crew to get off work
        
        higherBoundNumber = 0.0;
        
        for(int a = 0; a < crews.length; a++) {
        
            if (a == 0) {
                higherBoundNumber = crews[a].hoursOfWork();
                
            }
            
            if (crews[a].hoursOfWork() > higherBoundNumber) {
                higherBoundNumber = crews[a].hoursOfWork();
                
            }
            
        }
        
        return higherBoundNumber; 
    }
    
    
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
        
        MovingCompanyDispatcher mcd = new MovingCompanyDispatcher();
        
        
        mcd.newDay(200,100);
        mcd.makeJobs();
        mcd.makeCrews();
        mcd.assignJobs();
        
        
        double low = mcd.getLowerBound();
        double high = mcd.getHigherBound();
        
        double percentage = mcd.getExcessHoursAsPercentageOfLowerBound();
        
        System.out.println("Low: " + low);
        System.out.println("High: " + high);
        System.out.println("%: " + percentage);
        
        
    }

 }