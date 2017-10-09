import java.util.*;
/* MovingCompanyCrew: contains a list of jobs in a day's work and an hoursOfWork() method
*/

public class MovingCompanyCrew implements Comparable<MovingCompanyCrew> {
                
    //double[] jobs = null;
    
    ArrayList<Double> jobs = null;
    
    public MovingCompanyCrew() {
        
        jobs = new ArrayList<Double>();

    }
    
    
    public void setHours(double x) {
        
       jobs.add(x); 
       
    }
    
    
    //go through the hours of the jobs the crew has and return all the hours
    public double hoursOfWork() {
        
        double hoursWorked = 0.0;
        
        for (int j = 0; j < jobs.size(); j++) {
            hoursWorked += jobs.get(j);
        }
        
        return hoursWorked;
    }
    
    
    public int compareTo(MovingCompanyCrew a) {
        
        //this is used to find the lowest hour working crew member
        double difference = this.hoursOfWork() - a.hoursOfWork();
        
        if (difference <= 0) { //if this one is same or higher in value as a, then return -1
            return -1;
        }
        else {  //if this crew member has a lower value, then return 1.
            return 1;
        }
        
    }
    
    
}








