
public class ShowCurrentTime {

	public static void main(String[] args) 
	{
		//get the total number of milliseconds since Jan 1 1970
		long totalMilliseconds = System.currentTimeMillis();
		
		//get the total seconds since START_TIME
		long totalSeconds = totalMilliseconds / 1000;
				
		//find the current second in the minute in the hour by finding remainder from 60 total seconds
		long currentSecond = totalSeconds % 60;
		
		//Compute the total minutes (minutes = seconds / 60)
		long totalMinutes = totalSeconds / 60;
		
		//compute the current minute in the hour
		long currentMinute = totalMinutes % 60;
		
		//get the total hours
		long totalHours = totalMinutes / 60;
		
		//get the current hour
		long currentHour = totalHours % 24;
		
		//display
		System.out.println(currentHour + ":" + currentMinute + ":" + currentSecond);

	}

}
