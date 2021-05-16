package com.modules;
import java.util.ArrayList;

/**
 * This class creates an undirected graph connecting StockADT objects of similar 
 * prices (within $5 in price) using an adjacency list. The graph object contains 
 * two arraylists, stocks and adj, with the list of similar stocks corresponding 
 * to the respective index in the stocks list.
 */
public class Graph {

  public ArrayList<StockADT> stocks;
  public ArrayList<ArrayList<StockADT>> adj;

  public Graph(ArrayList<StockADT> allStocks) {
    this.stocks = allStocks;
    this.adj = new ArrayList<ArrayList<StockADT>>();

    for (StockADT current : allStocks) {
      ArrayList<StockADT> adjStocks = new ArrayList<StockADT>();
      for (StockADT stock : allStocks) {
        if (!stock.name.equals(current.name)) {
          if (Math.abs(stock.getPrice() - current.getPrice()) <= 5) {
            adjStocks.add(stock);
          }
        }
      }
      this.adj.add(adjStocks);
    }
  }

  private int index(StockADT stock) {
    int indexOfStock = 0;
    for (StockADT current : this.stocks) {
      if (stock.name.equals(current.name)) {
        break;
      }
      indexOfStock++;
    }
    return indexOfStock;
  }

  public ArrayList<StockADT> getAdj(StockADT stock) {
    int index = this.index(stock);
    return this.adj.get(index);
  }

}
