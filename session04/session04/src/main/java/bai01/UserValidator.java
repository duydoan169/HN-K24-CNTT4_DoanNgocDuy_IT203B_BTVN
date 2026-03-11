package bai01;

public class UserValidator {

    boolean isValidUsername(String username){
        if(username == null) return false;
        return username.length() >= 6 && username.length() <= 20 && !username.contains(" ");
    }
}
