import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Bai04 {
    /*
    Khi nối chuỗi trực tiếp vào câu SQL, dữ liệu nhập từ người dùng có thể
    làm thay đổi logic của mệnh đề WHERE.
    Chuỗi như: ' OR '1'='1' sẽ khiến điều kiện WHERE luôn đúng,
    dẫn đến việc trả về toàn bộ dữ liệu bệnh nhân trong CSDL.
    Để giảm rủi ro khi dùng Statement, cần kiểm tra và loại bỏ
    các ký tự đặc biệt trước khi thực hiện truy vấn.
    */

    public static void main(String[] args) {
        Bai04 test = new Bai04();
        test.findPatientByName("' OR '1'='1");
    }

    public void findPatientByName(String patientName) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        // Loại bỏ các ký tự nguy hiểm
        patientName = sanitizeInput(patientName);

        String sql = "SELECT * FROM Patients WHERE full_name = '" + patientName + "'";

        try {
            conn = getHospitalConn();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.println("Bệnh nhân: " + rs.getString("full_name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private String sanitizeInput(String input) {
        if (input == null) return "";
        return input
                .replace("'", "")
                .replace("--", "")
                .replace(";", "");
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