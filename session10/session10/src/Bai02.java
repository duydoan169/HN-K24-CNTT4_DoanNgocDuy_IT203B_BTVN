import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Bai02 {
    /*
    Lệnh if (rs.next()) chỉ di chuyển con trỏ ResultSet đúng một lần,
    nên chỉ xử lý được dòng dữ liệu đầu tiên.
    ResultSet ban đầu đứng trước dòng đầu tiên, mỗi lần gọi next()
    con trỏ sẽ chuyển sang dòng kế tiếp.
    Để in danh sách nhiều thuốc, cần dùng vòng lặp while để duyệt hết ResultSet.
    */

    public static void main(String[] args) {
        Bai02 test = new Bai02();
        test.printMedicineList();
    }

    public void printMedicineList() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        String sql = "SELECT medicine_name, stock FROM Pharmacy";

        try {
            conn = getHospitalConn();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.println(
                        "Thuốc: " + rs.getString("medicine_name")
                                + " | Số lượng: " + rs.getInt("stock")
                );
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