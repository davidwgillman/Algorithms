/* MovingCompanyCrew: contains a list of jobs in a day's work and an hoursOfWork() method
*/
import java.util.ArrayList;

public class MovingCompanyCrew implements Comparable {
    ArrayList<Double> jobs = new ArrayList();
    
    public MovingCompanyCrew(){
        
    }
    
    public void addJob(double newJob){
        this.jobs.add(newJob);
    }
    
    public int compareTo(Object target){
        MovingCompanyCrew validTarget = (MovingCompanyCrew)target;
        
        if(this.hoursOfWork() < validTarget.hoursOfWork()){
            return -1;
        }
        else if(this.hoursOfWork() > validTarget.hoursOfWork()){
            return 1;
        }
        else{
            return 0;
        }
    }

    public double hoursOfWork(){
        double totalWorkHours = 0;
        
        for(int i = 0; i < this.jobs.size(); i++){
            totalWorkHours = totalWorkHours + this.jobs.get(i);
        }
        
        return totalWorkHours;
    }
}