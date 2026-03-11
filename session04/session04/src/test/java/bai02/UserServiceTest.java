package bai02;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {
    UserService UserServiceTest = new UserService();

    @Test
    void checkRegistrationAge_01() {
        assertTrue(UserServiceTest.checkRegistrationAge(18));
    }

    @Test
    void checkRegistrationAge_02() {
        assertFalse(UserServiceTest.checkRegistrationAge(17));
    }

    @Test
    void checkRegistrationAge_03() {
        assertThrows(IllegalArgumentException.class, () -> {
            UserServiceTest.checkRegistrationAge(-1);
        });
    }
}