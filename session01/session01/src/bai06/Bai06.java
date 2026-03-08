package bai06;

import java.io.IOException;
import java.time.LocalDate;

public class Bai06 {

    public static void logError(String msg) {
        System.out.println("[ERROR] " + LocalDate.now() + " " + msg);
    }

    public static void saveToFile() throws IOException {
        throw new IOException("Loi ghi file");
    }

    public static void processUserData() throws IOException {
        saveToFile();
    }

    public static void main(String[] args) {
        User u = new User();

        try {
            u.setAge(-1);
        } catch (InvalidAgeException e) {
            logError(e.getMessage());
        }

        try {
            processUserData();
        } catch (IOException e) {
            logError("Khong luu duoc file");
        }

        if (u.getName() != null) {
            System.out.println(u.getName());
        }

        System.out.println("Chuong trinh tiep tuc");
    }
}