package bai06;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {

    // cập nhật thành công
    @Test
    void updateProfile_success() {

        User user = new User("old@mail.com",
                LocalDate.of(2000,1,1));

        UserProfile newProfile =
                new UserProfile("new@mail.com",
                        LocalDate.of(2001,1,1));

        List<User> users = new ArrayList<>();
        users.add(user);

        User result = UserService.updateProfile(user,newProfile,users);

        assertNotNull(result);
    }

    // ngày sinh tương lai
    @Test
    void updateProfile_birthDateFuture() {

        User user = new User("a@mail.com",
                LocalDate.of(2000,1,1));

        UserProfile newProfile =
                new UserProfile("new@mail.com",
                        LocalDate.now().plusDays(1));

        List<User> users = new ArrayList<>();
        users.add(user);

        User result = UserService.updateProfile(user,newProfile,users);

        assertNull(result);
    }

    // email trùng user khác
    @Test
    void updateProfile_duplicateEmail() {

        User user1 = new User("a@mail.com",
                LocalDate.of(2000,1,1));

        User user2 = new User("b@mail.com",
                LocalDate.of(2000,1,1));

        UserProfile newProfile =
                new UserProfile("b@mail.com",
                        LocalDate.of(2001,1,1));

        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);

        User result = UserService.updateProfile(user1,newProfile,users);

        assertNull(result);
    }

    // email giống email cũ
    @Test
    void updateProfile_sameEmail() {

        User user = new User("same@mail.com",
                LocalDate.of(2000,1,1));

        UserProfile newProfile =
                new UserProfile("same@mail.com",
                        LocalDate.of(2002,1,1));

        List<User> users = new ArrayList<>();
        users.add(user);

        User result = UserService.updateProfile(user,newProfile,users);

        assertNotNull(result);
    }

    // danh sách user rỗng
    @Test
    void updateProfile_emptyUserList() {

        User user = new User("old@mail.com",
                LocalDate.of(2000,1,1));

        UserProfile newProfile =
                new UserProfile("new@mail.com",
                        LocalDate.of(2002,1,1));

        List<User> users = new ArrayList<>();

        User result = UserService.updateProfile(user,newProfile,users);

        assertNotNull(result);
    }

    // email trùng + ngày sinh tương lai
    @Test
    void updateProfile_multipleViolation() {

        User user1 = new User("a@mail.com",
                LocalDate.of(2000,1,1));

        User user2 = new User("b@mail.com",
                LocalDate.of(2000,1,1));

        UserProfile newProfile =
                new UserProfile("b@mail.com",
                        LocalDate.now().plusDays(2));

        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);

        User result = UserService.updateProfile(user1,newProfile,users);

        assertNull(result);
    }
}