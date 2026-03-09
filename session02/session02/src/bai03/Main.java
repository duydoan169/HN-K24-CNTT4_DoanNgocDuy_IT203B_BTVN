package bai03;

public class Main {
    public static void main(String[] args) {
        Authenticatable user = () -> "123456";
        System.out.println(user.getPassword());
        System.out.println(user.isAuthenticated());
        String encrypted = user.encryptPassword("123456");
        System.out.println(encrypted);
    }
}