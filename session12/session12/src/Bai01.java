import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Bai01 {
    /*
        Khi nối chuỗi trực tiếp vào câu SQL, dữ liệu nhập từ người dùng có thể
        làm thay đổi logic của mệnh đề WHERE.
        Chuỗi như: ' OR '1'='1' sẽ khiến điều kiện WHERE luôn đúng,
        dẫn đến việc trả về toàn bộ dữ liệu bệnh nhân trong CSDL.
        Để giảm rủi ro khi dùng Statement, cần kiểm tra và loại bỏ
        các ký tự đặc biệt trước khi thực hiện truy vấn.
    */

    public static void main(String[] args) {
        Bai01 test = new Bai01();
        test.findPatientByName("' OR '1'='1");
    }

    public void findPatientByName(String patientName) {
        String sql = "SELECT * FROM doctors WHERE doctor_id = ?";

        try (
                Connection conn = getHospitalConn();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setInt(1, 2);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    System.out.println("Ma bac si: " + rs.getInt("doctor_id"));
                    System.out.println("Ten bac si: " + rs.getString("full_name"));
                    System.out.println("So dien thoai: " + rs.getString("phone_number"));
                }
            }

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