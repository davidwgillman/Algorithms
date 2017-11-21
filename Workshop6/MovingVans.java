import java.util.*;

/**
 * Write a description of class MovingVans here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MovingVans
{
    public static void main(String[] args) {
        // Creating empty priority queue
        PriorityQueue pQueue = new PriorityQueue();
        // Creating crew array of five crews
        int[] crews = new int[5]; 
        
        // Adding 'randomized' job hours as items to the pQueue
        pQueue.add((int)(Math.random() * 10));
        pQueue.add((int)(Math.random() * 10));
        pQueue.add((int)(Math.random() * 10));
        pQueue.add((int)(Math.random() * 10));
        pQueue.add((int)(Math.random() * 10));
       
        // Printing all elements that represent job hours
        System.out.println("The queue elements:");
        Iterator itr = pQueue.iterator();
        while (itr.hasNext())
            System.out.println(itr.next());
        
        for(int i=0; i < crews.length; i++){
          // fill crews array with total available work hours
          crews[i] = 8;
        }

        long startTime = System.nanoTime();
        Iterator iter2 = pQueue.iterator();
        while(iter2.hasNext()){
            iter2 = pQueue.iterator();
            for(int c: crews) {
                int job = (int) pQueue.peek();
                System.out.println("Job: "+job);
                if ((c - job) < 0){
                    long endTime = System.nanoTime();
                    long duration = (endTime - startTime);
                    System.out.println("Crew "+c+" is done in "+duration+" miliseconds");
                }
                // subtract job hours from total available work hours
                c = c - job;
                System.out.println("Job "+job+" subtracted from crew "+c);
                // Removing job
                pQueue.remove(job);
                // Printing current elements in pQueue
                System.out.println("The current queue elements:");
                Iterator itr2 = pQueue.iterator();
                while (itr2.hasNext())
                    System.out.println(itr2.next());
            }
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("Elapsed time for crews: "+duration/1000000);
    }
    
}
