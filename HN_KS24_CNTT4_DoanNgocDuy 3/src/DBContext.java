import java.sql.Connection;
import java.sql.DriverManager;

public class DBContext {
    public static Connection getConnection(){
        String user = "root";
        String password = "123456789";
        String url = "jdbc:mysql://localhost:3306/minipro_3";

        try {
            return DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
