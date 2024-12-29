package com.businessmonitor.service;

import com.businessmonitor.dao.PerformanceDAO;
import com.businessmonitor.model.Performance;

import java.util.List;

public class PerformanceService {
    private PerformanceDAO performanceDAO;

    public PerformanceService() {
        this.performanceDAO = new PerformanceDAO();
    }

    public List<Performance> fetchPerformanceData() {
        return performanceDAO.getAllPerformanceData();
    }

    public void addPerformance(Performance performance) {
        performanceDAO.insertPerformance(performance);
    }
}