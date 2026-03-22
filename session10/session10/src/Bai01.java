import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Bai01 {
    /*
    Việc tạo kết nối CSDL liên tục mà không đóng sẽ gây rò rỉ connection.
    Sau một thời gian dài, số connection vượt quá giới hạn của DB và hệ thống không thể kết nối tiếp.
    Điều này làm ứng dụng treo theo thời gian, đặc biệt nguy hiểm với hệ thống y tế cần hoạt động 24/7.
    Vì vậy mọi truy vấn bắt buộc phải đóng kết nối sau khi sử dụng.
    */

    public static void main(String[] args) {
        Bai01 test = new Bai01();
        test.getPatientById("P001");
    }

    public void getPatientById(String patientId) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Patients WHERE patient_id = ?";

        try {
            conn = getHospitalConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1, patientId);
            rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public Connection getHospitalConn() {
        // Lỗi nếu không đóng connection: gây rò rỉ tài nguyên và treo hệ thống sau thời gian dài
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