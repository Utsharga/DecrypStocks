import java.time.LocalDate;
import java.util.ArrayList;

/**
 * This class performs a binary search to find the user-inputted date in an 
 * array of daily data of a stock, sorted in order of oldest to most recent data.
 */
public class BinarySearch {

	public int searchForDate(ArrayList<String[]> stockData, LocalDate target) {
		int index = -1;
		
		int low = 0;
		int high = stockData.size() - 1;
		int mid = (low + high) / 2;
		
		while (low <= high) {
			mid = (low + high) / 2;
			
			LocalDate date = LocalDate.parse(stockData.get(mid)[0]);
			
			if (date.equals(target)) {
				index = mid;
				high = mid - 1;
			}
			else if (date.isBefore(target))
				low = mid + 1;
			else
				high = mid - 1;
		}
		if (index == -1)
			return mid;
		else return index;
	}
	
}
