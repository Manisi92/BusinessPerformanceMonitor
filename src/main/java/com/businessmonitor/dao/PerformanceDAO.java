package com.businessmonitor.dao;

import com.businessmonitor.model.Performance;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PerformanceDAO {
    private static final String DB_URL = "jdbc:sqlite:business_performance.db";

    public List<Performance> getAllPerformanceData() {
        List<Performance> performances = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            String sql = "SELECT * FROM performance";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Performance performance = new Performance(
                        rs.getDate("date").toLocalDate(),
                        rs.getDouble("sales"),
                        rs.getDouble("costs")
                );
                performances.add(performance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return performances;
    }

    public void insertPerformance(Performance performance) {
        String sql = "INSERT INTO performance(date, sales, costs) VALUES(?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDate(1, Date.valueOf(performance.getDate()));
            pstmt.setDouble(2, performance.getSales());
            pstmt.setDouble(3, performance.getCosts());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}