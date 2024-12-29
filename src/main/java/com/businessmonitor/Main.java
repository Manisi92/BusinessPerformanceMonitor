package com.businessmonitor;

import com.businessmonitor.ui.PerformanceMonitorUI;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PerformanceMonitorUI ui = new PerformanceMonitorUI();
            ui.setVisible(true);
        });
    }
}