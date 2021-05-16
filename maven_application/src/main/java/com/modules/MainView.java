package com.modules;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import java.util.ArrayList;
import java.util.List;

/**
 * This class creates the User Interface for the user.
 * It utilises graphing as well as all the rest of the modules.
 */
@Route // localhost:8080/
public class MainView extends VerticalLayout {
    private ArrayMakerADT BigData;

    public MainView() {
        List<StockADT> stockList = new ArrayList<>();
        DatePicker labelDatePicker = new DatePicker();
        labelDatePicker.setLabel("Date in yyyy-mm-dd");
        NumberField Budget = new NumberField("Budget in USD");
        NumberField MinimumGrowth = new NumberField("Minimum % Growth");
        Button search = new Button("Search");
        TextField graphName = new TextField("Stock Name ");
        Button getClosePrice = new Button("Search Price");
        search.addClickListener(event -> {
            BigData = new ArrayMakerADT(labelDatePicker.getValue(), Budget.getValue(), MinimumGrowth.getValue());
            for (int i = BigData.stocks.size()-1; i >= 0; i--) {
                stockList.add(BigData.stocks.get(i));
            }
            Grid<StockADT> grid = new Grid<>(StockADT.class);
            grid.setItems(stockList);
            add(grid);
        });
        getClosePrice.addClickListener(event -> {
            Graph g = new Graph(BigData.stocks);
            List<StockADT> x = g.getAdj(findStock(graphName.getValue(), BigData.stocks));
            Grid<StockADT> grid2 = new Grid<>(StockADT.class);
            grid2.setItems(x);
            add(grid2);
        });
        add(labelDatePicker, Budget, MinimumGrowth, search, graphName, getClosePrice);
    }

    private StockADT findStock(String stockName, ArrayList<StockADT> a) {
        for (int i = 0; i < a.size(); i++) {
            if(a.get(i).name.equals(stockName)) return a.get(i);
        }
        return a.get(0);
    }
}
