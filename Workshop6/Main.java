public class Main
{
    public static void main(String[] args) {
        MovingCompanyDispatcher mcd = new MovingCompanyDispatcher();
        mcd.newDay(10000, 10000);
        mcd.assignJobs();
        mcd.getCrews();
        mcd.getLowerBound(); 
        //
    }
}

