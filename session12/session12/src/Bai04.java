import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Bai04 {
    /*
    Khi dùng Statement và nối chuỗi SQL trong vòng lặp, Database Server phải:
    - Parse câu SQL
    - Kiểm tra cú pháp
    - Tạo Execution Plan
    cho mỗi lần INSERT, dù cấu trúc câu lệnh giống hệt nhau.

    Với 1.000 bản ghi, DB phải làm lại các bước trên 1.000 lần → lãng phí CPU,
    tăng thời gian xử lý, hệ thống chạy rất chậm.

    PreparedStatement cho phép:
    - Parse và tạo Execution Plan chỉ MỘT LẦN
    - Truyền dữ liệu qua tham số
    - Tái sử dụng Execution Plan trong vòng lặp

    Tốc độ nhanh hơn rõ rệt, giảm tải cho Database Server.
    */

    public static void main(String[] args) {
        Bai04 test = new Bai04();
        test.insertBloodTestResults();
    }

    public void insertBloodTestResults() {
        String sql = """
            INSERT INTO blood_tests(patient_id, hemoglobin, glucose)
            VALUES (?, ?, ?)
        """;

        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/hospital",
                        "root",
                        "123456789"
                );
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            for (int i = 1; i <= 1000; i++) {
                ps.setInt(1, i);
                ps.setDouble(2, 13.5);
                ps.setDouble(3, 5.8);
                ps.executeUpdate();
            }

            System.out.println("Nap du lieu xet nghiem thanh cong.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}