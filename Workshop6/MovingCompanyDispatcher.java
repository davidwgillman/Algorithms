/* Randomly generates a day's worth of jobs for H households using V van crews
   H and V may be passed through a constructor or a newDay() method.

   [Suggestion: create an array of MovingCompanyCrew objects;
                a MovingCompanyCrew has a list of jobs and an hoursOfWork() method]

   Orders jobs from longest to shortest and assigns jobs in order to the first available crew.

   Prints the assignment and hours worked by the last crew to get off work.
   */

// imports
import java.util.stream.*;
import java.util.*;
import edu.princeton.cs.algs4.*;

 public class MovingCompanyDispatcher {
    private Integer nCrews = 0;
    private Integer nHouseholds = 0;
    private Integer[] jobs = null;
    
    private MovingCompanyCrew[] crews = null;

    public MovingCompanyDispatcher(){
        
      }

    public void newDay(int C, int H) {
        nCrews = C;
        nHouseholds = H;
        this.crews = new MovingCompanyCrew[C];
        this.makeJobs();
    }

    public double getLowerBound() {
        // lower bound on numnber of hours worked by last crew to    get off work
        int sum = 0;
        for(int i : jobs){
            sum += i;
        }
        return  sum / nCrews;
    }
    
    
    public void makeJobs() {
        jobs = new Integer[nHouseholds];
        Random r = new Random();
        for(int i = 0; i < nHouseholds; i++){
            jobs[i] = r.nextInt(8) + 1;
        }
    }

    public void assignJobs() {
        Quick q = new Quick();
        q.sort(jobs);
        
        int jobsPerCrew = (int)(jobs.length / nCrews);
        for(int i : jobs){
            MovingCompanyCrew minCrew = crews[0];
            double workHours = 10000000;
            for(int j = 0; j < crews.length; j++){
                if(crews[j].hoursOfWork() < workHours){
                    minCrew = crews[j];
                }
            }
            minCrew.jobs.add(jobs[0]);
            
        }
    }

    // this method lets the client figure out how good a job the Dispatcher did
    // Alternatively, you can let the Dispatcher do its own self-evaluation 
    // and expose the stats in different method
    public MovingCompanyCrew[] getCrews() {

    }

    public static void main(String[] args) {

    }

 }