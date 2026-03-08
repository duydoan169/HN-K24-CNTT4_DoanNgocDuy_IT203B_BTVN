import java.io.IOException;

public class Bai04 {

    public static void saveToFile() throws IOException {
        throw new IOException("Loi ghi file");
    }

    public static void processUserData() throws IOException {
        saveToFile();
    }

    public static void main(String[] args) {
        try {
            processUserData();
        } catch (IOException e) {
            System.out.println("Loi khi luu file");
        }

        System.out.println("Chuong trinh tiep tuc");
    }
}