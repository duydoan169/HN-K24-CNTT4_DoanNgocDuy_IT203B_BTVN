import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Bai04 {
    record User(String username, String email, String status) {}
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("alice", "alice@gmail.com", "ACTIVE"));
        users.add(new User("bob", "bob@gmail.com", "INACTIVE"));
        users.add(new User("charlie", "charlie@gmail.com", "ACTIVE"));
        users.add(new User("charlie", "charlie@gmail.com", "ACTIVE"));
        users.add(new User("charlie", "charlie@gmail.com", "ACTIVE"));
        Set<String> seen = new HashSet<>();
        List<User> uniqueUsers = users.stream()
                .filter(u -> seen.add(u.username()))
                .toList();
        uniqueUsers.forEach(System.out::println);
    }
}