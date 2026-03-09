package bai04;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User("Huy"),
                new User("AN"),
                new User("Thanh")
        );

        users.stream()
                .map(User::getUsername)
                .forEach(System.out::println);

        users.stream()
                .map(User::getUsername)
                .forEach(System.out::println);

        Supplier<User> supplier = User::new;

        User newUser = supplier.get();
        System.out.println(newUser.getUsername());
    }
}