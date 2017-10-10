/* Randomly generates a day's worth of jobs for H households using V van crews
   H and V may be passed through a constructor or a newDay() method.

   [Suggestion: create an array of MovingCompanyCrew objects;
                a MovingCompanyCrew has a list of jobs and an hoursOfWork() method]

   Orders jobs from longest to shortest and assigns jobs in order to the first available crew.

   Prints the assignment and hours worked by the last crew to get off work.
   */

// imports
import java.util.Random;

 public class MovingCompanyDispatcher {
    private int nCrews = 0;
    private int nHouseholds = 0;
    private double[] jobs = null;

    private MovingCompanyCrew[] crews = null;

    public MovingCompanyDispatcher(){
        
    }
        
    public void newDay(int C, int H){
        this.nCrews = C;
        this.nHouseholds = H;
        this.jobs = new double[H];
        this.crews = new MovingCompanyCrew[C];
        
        for(int i = 0; i < C; i++){
            this.crews[i] = new MovingCompanyCrew();
        }
    }

    public double getLowerBound(){
        // lower bound on numnber of hours worked by last crew to get off work
        double totalHoursWorked = 0;
        
        for(int i = 0; i < this.crews.length; i++){
            totalHoursWorked += this.crews[i].hoursOfWork();
        }
        
        double lowerBound = totalHoursWorked/this.nCrews;
        
        return lowerBound;
    }

    public void makeJobs(){
        Random hoursGenerator = new Random();
        
        for(int i = 0; i < this.nHouseholds; i++){
            double hours = (double)hoursGenerator.nextInt(7);
            this.jobs[i] = hours;          
        }
        
    }

    public void assignJobs(){
        // order jobs longest to shortest .
        
        for(int i = 0; i < this.jobs.length; i++){
            double temp = 0;
            
            for(int j = 0; j < this.jobs.length; j++){
                if(this.jobs[i] > this.jobs[j]){
                    temp = this.jobs[i];
                    this.jobs[i] = this.jobs[j];
                    this.jobs[j] = temp;
                }
            }
        }
        // assign each job in order to first available crew 
        
        for(int i = 0; i < this.jobs.length; i++){
            int leastBusy = 0;
            
            for(int j = 0; j < this.crews.length; j++){
                if(this.crews[leastBusy].compareTo(this.crews[j]) == 1 || this.crews[leastBusy].compareTo(this.crews[j]) == 0){
                    leastBusy = j;
                }
            }
            
            this.crews[leastBusy].addJob(this.jobs[i]);
        }
                
    }

    // this method lets the client figure out how good a job the Dispatcher did
    // Alternatively, you can let the Dispatcher do its own self-evaluation 
    // and expose the stats in different method
    
    public double getTotalWorkHours(){
        double totalWorkHours = 0;
        for(int i = 0; i < this.jobs.length; i++){
            totalWorkHours = this.jobs[i] + totalWorkHours;
        }
        
        return totalWorkHours;
    }
    
    public MovingCompanyCrew[] getCrews(){
        return this.crews;
    }

    public static void main(String[] args){
        MovingCompanyDispatcher test = new MovingCompanyDispatcher();
        
        test.newDay(5,13);
        test.makeJobs();
        test.assignJobs();
        
        MovingCompanyCrew[] testDummies = test.getCrews();
        double totalWorkHours = test.getTotalWorkHours();
        MovingCompanyCrew longestWorker = testDummies[0];
        
        for(int i = 0; i < 5; i++){
            System.out.println("Moving crew " + i + " worked " + testDummies[i].hoursOfWork() + " hours");
            if(longestWorker.compareTo(testDummies[i]) == -1){
                longestWorker = testDummies[i];
            }
        }
        System.out.println("A total of " + totalWorkHours + " hours was collectively worked");
        
        System.out.println("Today's lower bound was " + test.getLowerBound());
        
        double marginOfError = 100 - ((test.getLowerBound()/longestWorker.hoursOfWork())*100);
        
        System.out.println("The dispatcher had a " + marginOfError + "% margin of error today");
        
    }

 }