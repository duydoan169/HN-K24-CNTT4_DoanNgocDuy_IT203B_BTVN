package bai03;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        UserRepository repo = new UserRepository();

        Optional<UserRepository.User> user = repo.findUserByUsername("alice");

        System.out.println(
                user.map(u -> "Welcome " + u.username())
                        .orElse("Guest login")
        );
    }
}