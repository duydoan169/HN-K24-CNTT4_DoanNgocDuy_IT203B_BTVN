package bai05;

public class Bai05 {
    public static void main(String[] args) {
        User u = new User();

        try {
            u.setAge(-5);
        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Chuong trinh tiep tuc");
    }
}
