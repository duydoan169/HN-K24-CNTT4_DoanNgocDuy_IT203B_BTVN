public class Main {
    public static void main(String[] args) {
        try {
            DAO.transaction("ACC01", "ACC02", 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}