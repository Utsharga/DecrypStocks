import java.util.ArrayList;

/**
 * This class sorts all stocks in an arraylist in order of growth, 
 * with the stock with the smallest growth at the beginning and 
 * greatest growth at the end.
 */
public class QuickSort {

	private int partition(ArrayList<StockADT> arr, int low, int high)
	{
		double pivot = arr.get(high).getGrowth();  
		int i = (low-1); // index of smaller element 
		for (int j=low; j<high; j++) 
		{
			// If current element is smaller than the pivot 
			if (arr.get(j).getGrowth() < pivot) 
			{
				i++;

				// swap arr[i] and arr[j]
				StockADT temp = arr.get(i);
				arr.set(i, arr.get(j));
				arr.set(j, temp);
			}
		}

		// swap arr[i+1] and arr[high] (or pivot) 
		StockADT temp = arr.get(i+1);
		arr.set(i+1, arr.get(high));
		arr.set(high, temp);

		return i+1;
	}

	/* arr[] = Array to be sorted, 
	low  = Starting index, 
	high  = Ending index */
	public void sortByGrowth(ArrayList<StockADT> arr, int low, int high)
	{
		if (low < high)
		{
			int partIndex = partition(arr, low, high);

			sortByGrowth(arr, low, partIndex-1);
			sortByGrowth(arr, partIndex+1, high);
		} 
	} 

}
