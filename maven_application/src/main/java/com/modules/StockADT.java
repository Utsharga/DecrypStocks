package com.modules;
import java.io.*;
import java.time.LocalDate;
import java.util.*;

/**
 * This class creates a StockADT object, where it stores data in an arraylist 
 * of tuples. The object stores the stock name, current price, most recent 
 * entry date, price, and lastDate variables.
 */
public class StockADT {
	public ArrayList<String[]> stockData; // ArrayList of file data
	public String name; // Stock name
	public double price; // Current (most recent) stock price
	public LocalDate lastDate; // Most recent entry
	public double growth; // Growth from specified date

	public StockADT(String filename, LocalDate targetDate) {
		name = filename.substring(filename.lastIndexOf('/') + 1, filename.indexOf('.'));
		this.stockData = new ArrayList<String[]>();
		try (BufferedReader br = new BufferedReader(new FileReader("src/Stocks/" + filename))) {
			String line = br.readLine(); // read over 1st line (header)
			// create string array of the file
			System.out.println("Processing: " + this.name);
			if (line == null) {
				this.growth = 0.0;
				this.price = 0.0;
				return;
			}
			while ((line = br.readLine()) != null)
				this.stockData.add(line.split(","));

			this.lastDate = LocalDate.parse(stockData.get(stockData.size()-1)[0]);

			BinarySearch b = new BinarySearch();
			int targetIndex = b.searchForDate(stockData, targetDate);

			this.price = Double.parseDouble(stockData.get(stockData.size()-1)[4]);
			double targetPrice = Double.parseDouble(stockData.get(targetIndex)[4]);

			this.growth = (price - targetPrice) / targetPrice * 100;

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public double getGrowth() {
		return this.growth;
	}

	public String getName() {
		return this.name;
	}

	public void setName() {
		this.name = name;
	}

	public void setPrice() {
		this.price = price;
	}

	public void setGrowth() {
		this.growth = growth;
	}
	
}
