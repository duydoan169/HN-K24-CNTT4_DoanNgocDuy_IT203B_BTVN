package bai02;

public class Main {
    public static void main(String[] args) {
        PasswordValidator validator = (password) -> password.length() >= 8;
        System.out.println(validator.validate("12345678"));
        System.out.println(validator.validate("1234"));
    }
}
