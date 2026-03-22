package bai05.dao;

import bai05.model.Doctor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAO extends DBContext {

    public List<Doctor> getAllDoctors() {
        List<Doctor> list = new ArrayList<>();
        String sql = "SELECT doctor_id, full_name, specialty FROM Doctors";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Doctor(
                        rs.getString("doctor_id"),
                        rs.getString("full_name"),
                        rs.getString("specialty")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean addDoctor(Doctor d) {
        String sql = "INSERT INTO Doctors VALUES (?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, d.getId());
            ps.setString(2, d.getName());
            ps.setString(3, d.getSpecialty());
            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Lỗi thêm bác sĩ: " + e.getMessage());
            return false;
        }
    }

    public void countBySpecialty() {
        String sql = """
            SELECT specialty, COUNT(*) AS total
            FROM Doctors
            GROUP BY specialty
        """;

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                System.out.println(
                        rs.getString("specialty") + ": " +
                                rs.getInt("total")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
