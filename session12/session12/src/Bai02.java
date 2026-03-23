import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Bai02 {
    /*
    PHÂN TÍCH (NGẮN GỌN)

    Statement nối chuỗi SQL nên số double bị phụ thuộc Locale của hệ điều hành
    (37.5 hoặc 37,5), dễ gây lỗi cú pháp SQL.
    PreparedStatement dùng setDouble(), setInt() để truyền giá trị theo kiểu dữ liệu,
    JDBC Driver tự chuyển sang định dạng SQL hợp lệ, không phụ thuộc dấu chấm hay phẩy.
    */

    public static void main(String[] args) {
        Bai02 test = new Bai02();
        test.updateVitalSigns(1, 37.5, 80);
    }

    public void updateVitalSigns(int patientId, double temperature, int heartRate) {
        String sql = "UPDATE Patients SET temperature = ?, heart_rate = ? WHERE id = ?";

        try (
                Connection conn = getHospitalConn();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setDouble(1, temperature);
            ps.setInt(2, heartRate);
            ps.setInt(3, patientId);

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getHospitalConn() {
        try {
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/hospital",
                    "root",
                    "123456789"
            );
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}