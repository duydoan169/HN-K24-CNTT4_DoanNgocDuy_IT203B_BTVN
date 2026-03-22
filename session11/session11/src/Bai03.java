import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class Bai03 {
    /*
    executeUpdate() trả về số dòng dữ liệu bị tác động bởi câu lệnh SQL.
    - Nếu giá trị > 0: có bản ghi được cập nhật thành công.
    - Nếu giá trị = 0: không có dòng nào bị ảnh hưởng, thường do mã giường không tồn tại.
    Dựa vào giá trị này, hệ thống có thể thông báo chính xác cho y tá
    thay vì luôn in ra "cập nhật thành công".
    */

    public static void main(String[] args) {
        Bai03 test = new Bai03();
        test.updateBedStatus("Bed_999");
    }

    public void updateBedStatus(String bedId) {
        Connection conn = null;
        Statement stmt = null;

        String sql = "UPDATE Beds SET bed_status = 'Occupied' WHERE bed_id = '" + bedId + "'";

        try {
            conn = getHospitalConn();
            stmt = conn.createStatement();

            int rowsAffected = stmt.executeUpdate(sql);

            if (rowsAffected > 0) {
                System.out.println("Đã cập nhật giường bệnh thành công!");
            } else {
                System.out.println("Lỗi: Mã giường không tồn tại!");
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            try {
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
