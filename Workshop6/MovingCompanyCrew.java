import java.util.*;
/* MovingCompanyCrew: contains a list of jobs in a day's work and an hoursOfWork() method
*/

public class MovingCompanyCrew {
                
    double totalHours = 0;
     
    //sets more hours for the crew to work.
    public void setHours(double x) {

       totalHours += x;
       
    }
    
    
    //returns hours needed to work from crew.
    public double hoursOfWork() {
        
        return totalHours;
    }

    
    
}








