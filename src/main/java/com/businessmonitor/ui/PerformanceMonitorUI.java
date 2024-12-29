package com.businessmonitor.ui;

import com.businessmonitor.model.Performance;
import com.businessmonitor.service.PerformanceService;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.category.*;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PerformanceMonitorUI extends JFrame {
    private PerformanceService performanceService;
    private JPanel chartPanel;

    public PerformanceMonitorUI() {
        performanceService = new PerformanceService();
        setTitle("Business Performance Monitor");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        chartPanel = new JPanel();
        add(chartPanel, BorderLayout.CENTER);

        JButton refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(e -> loadChart());
        add(refreshButton, BorderLayout.SOUTH);
    }

    private void loadChart() {
        List<Performance> performances = performanceService.fetchPerformanceData();
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (Performance performance : performances) {
            dataset.addValue(performance.getSales(), "Sales", performance.getDate().toString());
            dataset.addValue(performance.getCosts(), "Costs", performance.getDate().toString());
        }

        JFreeChart chart = ChartFactory.createBarChart(
                "Business Performance", "Date", "Amount ($)", dataset, PlotOrientation.VERTICAL, true, true, false);
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setDomainGridlinePaint(Color.GRAY);
        plot.setRangeGridlinePaint(Color.GRAY);

        chartPanel.removeAll();
        chartPanel.add(new ChartPanel(chart));
        chartPanel.revalidate();
        chartPanel.repaint();
    }
}