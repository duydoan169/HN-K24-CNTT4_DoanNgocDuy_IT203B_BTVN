package bai02;

@FunctionalInterface
public interface PasswordValidator {
    boolean validate(String password);
}