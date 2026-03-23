import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;

public class Bai03 {
    /*
        Stored Procedure CALCULATE_DISCHARGE_FEE có:
        - 1 tham số IN: p_id (INT)
        - 1 tham số OUT: total_fee (DOUBLE)

        Khi gọi Stored Procedure bằng JDBC:
        - Bắt buộc phải registerOutParameter() trước khi execute()
        - JDBC cần biết trước vị trí và kiểu dữ liệu của tham số OUT
        - Nếu không đăng ký, sẽ xảy ra lỗi "The column index is out of range"
          hoặc không lấy được giá trị trả về
    */

    public static void main(String[] args) {
        Bai03 test = new Bai03();
        test.calculateDischargeFee(1);
    }

    public void calculateDischargeFee(int patientId) {
        String sql = "{CALL CALCULATE_DISCHARGE_FEE(?, ?)}";

        try (
                Connection conn = getHospitalConn();
                CallableStatement cs = conn.prepareCall(sql)
        ) {
            cs.setInt(1, patientId);

            cs.registerOutParameter(2, Types.DOUBLE);

            cs.execute();

            double totalFee = cs.getDouble(2);
            System.out.println("Tong vien phi: " + totalFee);

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