import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        try{
            DAO.transaction("ACC01", "ACC02", 999);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
