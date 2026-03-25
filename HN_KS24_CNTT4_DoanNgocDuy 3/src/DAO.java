import java.sql.*;

public class DAO {
    public static void transaction(String senderId, String receiverId, double amount) throws SQLException {
        Connection conn = null;
        try {
            conn = DBContext.getConnection();
            conn.setAutoCommit(false);

            String check = "Select * from Accounts where AccountId = ?";

            PreparedStatement psCheck1 = conn.prepareStatement(check);
            psCheck1.setString(1, senderId);
            ResultSet rsCheck1 = psCheck1.executeQuery();

            PreparedStatement psCheck2 = conn.prepareStatement(check);
            psCheck2.setString(1, receiverId);
            ResultSet rsCheck2 = psCheck2.executeQuery();

            if (!rsCheck1.next() || !rsCheck2.next()) {
                throw new Exception("ID nguoi nhan hoac nguoi gui khong ton tai");
            }

            double senderBalance = rsCheck1.getDouble("Balance");
            double receiverBalance = rsCheck2.getDouble("Balance");

            if (senderBalance < amount) {
                throw new Exception("So du tai khoan khong du");
            }

            String str = "{CALL sp_UpdateBalance(?, ?)}";
            CallableStatement cstmt = conn.prepareCall(str);
            cstmt.setString(1, senderId);
            cstmt.setDouble(2, senderBalance - amount);
            cstmt.execute();

            String str2 = "{CALL sp_UpdateBalance(?, ?)}";
            CallableStatement cstmt2 = conn.prepareCall(str2);
            cstmt2.setString(1, receiverId);
            cstmt2.setDouble(2, receiverBalance + amount);
            cstmt2.execute();

            conn.commit();

            String getAll = "select * from Accounts";
            PreparedStatement ps = conn.prepareStatement(getAll);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("ID: " + rs.getString("AccountId"));
                System.out.println("Balance: " + rs.getDouble("Balance"));
            }

        } catch (Exception e) {
            if (conn != null) conn.rollback();
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.setAutoCommit(true);
                conn.close();
            }
        }
    }
}