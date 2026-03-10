import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Bai05 {
    record User(String username, String email, String status) {}

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();

        users.add(new User("alexander", "a@gmail.com", "ACTIVE"));
        users.add(new User("charlotte", "c@gmail.com", "ACTIVE"));
        users.add(new User("Benjamin", "b@gmail.com", "INACTIVE"));
        users.add(new User("bob", "b@gmail.com", "ACTIVE"));
        users.add(new User("anna", "a@gmail.com", "ACTIVE"));
        users.add(new User("christopher", "c@gmail.com", "ACTIVE"));

        users.stream()
                .sorted(Comparator.comparingInt((User u) -> u.username().length()).reversed())
                .limit(3)
                .forEach(u -> System.out.println(u.username()));
    }
}