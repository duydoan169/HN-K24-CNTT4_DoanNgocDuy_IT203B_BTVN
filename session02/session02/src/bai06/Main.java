package bai06;

public class Main {
    public static void main(String[] args) {
        UserProcessor processor = UserUtils::convertToUpperCase;
        User user = new User("Duy");
        String result = processor.process(user);
        System.out.println(result);
    }
}