import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;

public class DateLabel {
	
	static boolean useToday = true; // enter useToday?
	
	static Date today = Calendar.getInstance().getTime();
	static int month = 3; 	//enter month
	static int day = 31; 	//enter day
	static int year = 16; 	//enter year
	static int dayOfWeek = 	3;
	
	static final String [] months = {"January", "February", "March", "April", "May", "June", "July",
									 "August", "September", "October", "November", "December"};

	static final String [] weekdayArray = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
										//0 		   1		  		2 		   3		   		4		 5			 6
	static final Integer[] longMonths = {1, 3, 5, 7, 8, 10, 12};
	static HashSet<Integer> longMonth = new HashSet<Integer>(Arrays.asList(longMonths));

	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		if(useToday) {
			/* get current dates */
			month = today.getMonth() + 1;
			year = today.getYear() - 100;
			dayOfWeek = today.getDay() - 1;
			day = today.getDate();
			
			/* get the right weekdayArray for 28th of month*/
			int diff = 28 - day;
			day = 28;
			dayOfWeek += diff;
			
			/* long month */
			if(longMonth.contains(month)) {
				day	+= 3;
				dayOfWeek += 3;
			}
			/* short month not February */
			else if(month != 2) {
				day += 2;
				dayOfWeek +=2;
			}
			dayOfWeek += 700;
		}
		
		System.out.println(months[month - 1] + " Prayer Requests");

		/* print out the days */
		while(day > 0) {
			System.out.println(month + "/" + day-- + "/" + year + " " + weekdayArray[dayOfWeek-- % 7]);
		}
	}
}
