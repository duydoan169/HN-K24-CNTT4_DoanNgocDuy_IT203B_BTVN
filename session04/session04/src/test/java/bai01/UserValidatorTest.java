package bai01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserValidatorTest {
    UserValidator userValidator = new UserValidator();

    @Test
    void TC01(){
        assertTrue(userValidator.isValidUsername("user123"));
    }

    @Test
    void TC2(){
        assertFalse(userValidator.isValidUsername("abc"));
    }

    @Test
    void TC03(){
        assertFalse(userValidator.isValidUsername("user name"));
    }
}