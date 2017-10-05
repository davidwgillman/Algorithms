/* MovingCompanyCrew: contains a list of jobs in a day's work and an hoursOfWork() method
*/

public class MovingCompanyCrew implements Comparable<MovingCompanyCrew> {
    
    double[] jobs = null;
    
    double hours = 0;
    
    
    
    public MovingCompanyCrew() {

    }
    
    
    public void setHours(double x) {
       hours += x;
    }
    
    
    public double hoursOfWork() {
        return hours;
    }
    
    
    public int compareTo(MovingCompanyCrew a) {
       
        return 0;
     }
    
    
}