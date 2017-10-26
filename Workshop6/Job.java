
import java.time.LocalTime;

public class Job implements Comparable<Job>{
	private final LocalTime startTime, endTime;
	private final long duration;

	public Job(LocalTime time, long d){
		startTime = time;
		duration = d;
		endTime = startTime.plusHours(duration);
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public long getDuration(){
		return duration;
	}

	/*public int compareTo(Job that) {	// returns 0 if there is a time conflict
		if(this.endTime.isBefore(that.startTime)) return -1;
		else if(this.startTime.isAfter(that.endTime)) return 1;
		return 0;
	}*/

	public int compareTo(Job that) {	// returns 0 if there is a time conflict
		if(this.duration > that.duration) return -1;
		else if(this.duration < that.duration) return 1;
		return 0;
	}
}