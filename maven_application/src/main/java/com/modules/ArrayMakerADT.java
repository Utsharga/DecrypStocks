package com.modules;
import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;

public class ArrayMakerADT {
    public ArrayList<StockADT> stocks;  // List of all stocks that fit user criteria
                                        // sorted by growth

    public ArrayMakerADT(LocalDate targetDate, double budget, double minGrowth) {
        System.out.print("Working!");
        File allStocks = new File("src/Stocks");
        File[] stockList = allStocks.listFiles();
        stocks = new ArrayList<StockADT>();
        // TODO: Better exception handling (try/catch blocks)
        if (stockList != null) {
            for (File stockFile : stockList) {
                StockADT stock = new StockADT(stockFile.getName(), targetDate);
                if (stock.getPrice() < budget && stock.getGrowth() > minGrowth)
                    this.stocks.add(stock);
            }
            
            QuickSort q = new QuickSort();
            q.sortByGrowth(this.stocks, 0, stocks.size()-1);
        } else {
            System.out.println("Not Working");
            // Handle the case where dir is not really a directory.
            // Checking dir.isDirectory() above would not be sufficient
            // to avoid race conditions with another process that deletes
            // directories.
        }
    }

}
