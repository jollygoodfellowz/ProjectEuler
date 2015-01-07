
// Count all the Sundays on the first of a month for the past century
// Euler 19
public class CountingSundays {

	public static void main(String[] args) {
		
		int count = 0;
		int curDay = 2;
		int curMonth = 1;
		int daysMonth = 31;
		
		// The years
		for(int i = 1901; i <= 2000; i++) {
			
			// The Months
			for(int j = 1; j <= 12; j++, curMonth++) {
				
				// Handl all of the different cases for the amount of days in a month
				if(curMonth == 4 || curMonth == 6 || curMonth == 11 || curMonth == 9)
					daysMonth = 30;
				else if(curMonth == 1 || curMonth == 3 || curMonth == 5 || curMonth == 7 || curMonth == 8)
					daysMonth = 31;
				
				// The February case
				else {
					
					// Leap year
					if(i % 4 == 0) {
						
						// Leap year on a century
						if(i % 100 == 0 && i % 400 != 0) 
							daysMonth = 28;
						else
							daysMonth = 29;
					}
					else
						daysMonth = 28;
				}
				
				// Reset the months
				if(curMonth == 12)
					curMonth = 0;
				
				// The days in a month
				for(int k = 1; k <= daysMonth; k++, curDay++) {
					
					// If its a Sunday and the first of the month
					if(curDay == 1 && k == 1) 
						count++;
					
					// Reset the Current Day back to Sunday
					if(curDay == 7)
						curDay = 0;
				}
			}
		}
		
		System.out.println(count);
	}
}
