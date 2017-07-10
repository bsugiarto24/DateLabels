import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

public class DateLabel {
	
	
	static Date today = Calendar.getInstance().getTime();
	static boolean useToday = true; // enter useToday?
	static int month = 3; 	//enter month
	static int day = 31; 	//enter day
	static int year = 16; 	//enter year
	
	static String [] weekday = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
	//							 0 		   1		  2 		   3		   4		 5			 6
	static int daystart = 	3;
	
	static HashSet<Integer> longMonth = new HashSet<Integer>();
	static Integer[] longMonths = {1, 3, 5, 7, 8, 10, 12};
	

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		List<Integer> list =  Arrays.asList(longMonths);
		longMonth.addAll(list);
		
		if(useToday) {
			month = today.getMonth() + 1;
			year = today.getYear() - 100;
			daystart = today.getDay() - 1;
			day = today.getDate();
			
			//set daystart to the 28th day
			while(day < 28) {
				day++;
				daystart++;
			}
			
			//make sure day is at 28 in order to proceed
			if(day == 28){
				//long month
				if(longMonth.contains(month)) {
					day	+= 3;
					daystart += 3;
				}
				//short month not February
				else if(month != 2) {
					day += 2;
					daystart +=2;
				}
			}
			daystart %= 7;
		}
		
		/* print out the days */
		while(day > 0) {
			System.out.println(month + "/" + day-- + "/" + year + " " + weekday[daystart--]);
			if(daystart < 0)
				daystart = 6;
		}
	}

}
