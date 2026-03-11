package bai03;

import java.util.Locale;

public class UserProcessor {

    public String processEmail(String email){
        if(email == null || !email.contains("@")){
            throw new IllegalArgumentException("Invaild email formad");
        }

        String[] parts = email.split("@");

        if (parts.length != 2 || parts[1].isEmpty()) {
            throw new IllegalArgumentException("Invalid email domain");
        }

        return email.toLowerCase();
    }
}
