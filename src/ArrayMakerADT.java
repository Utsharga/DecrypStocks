import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.*;

/**
 * This class goes through all files in the dataset and creates an arraylist 
 * of StockADT objects representing all the stocks (class variable stocks) 
 * based on the specified criteria. The stocks are all listed in order of 
 * descending growth.
 */
public class ArrayMakerADT {
    public ArrayList<StockADT> stocks;  // List of all stocks that fit user criteria
                                        // sorted by growth

    public ArrayMakerADT(LocalDate targetDate, double budget, double minGrowth) {
        File allStocks = new File("price-volume-data-for-all-us-stocks-etfs/Stocks");
        File[] stockList = allStocks.listFiles();
        stocks = new ArrayList<StockADT>();
        if (stockList != null) {
            for (File stockFile : stockList) {
                StockADT stock = new StockADT(stockFile.getName(), targetDate);
                if (stock.getPrice() < budget && stock.getGrowth() > minGrowth)
                    this.stocks.add(stock);
            }
            
            QuickSort q = new QuickSort();
            q.sortByGrowth(this.stocks, 0, stocks.size()-1);
        } else {
            //throw FileNotFoundException("Directory does not exist.");
        }
    }

}
