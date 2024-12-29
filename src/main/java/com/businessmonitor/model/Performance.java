package com.businessmonitor.model;

import java.time.LocalDate;

public class Performance {
    private LocalDate date;
    private double sales;
    private double costs;
    private double profit;

    public Performance(LocalDate date, double sales, double costs) {
        this.date = date;
        this.sales = sales;
        this.costs = costs;
        this.profit = sales - costs;
    }

    // Getter e Setter
    public LocalDate getDate() { return date; }
    public double getSales() { return sales; }
    public double getCosts() { return costs; }
    public double getProfit() { return profit; }
}