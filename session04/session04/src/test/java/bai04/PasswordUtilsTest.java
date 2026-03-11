package bai04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class PasswordUtilsTest {

    @Test
    void testStrongPassword() {
        assertEquals("Mạnh",
                PasswordUtils.evaluatePasswordStrength("Abc123!@"));
    }

    @Test
    void testMissingUppercase() {
        assertEquals("Trung bình",
                PasswordUtils.evaluatePasswordStrength("abc123!@"));
    }

    @Test
    void testMissingLowercase() {
        assertEquals("Trung bình",
                PasswordUtils.evaluatePasswordStrength("ABC123!@"));
    }

    @Test
    void testMissingDigit() {
        assertEquals("Trung bình",
                PasswordUtils.evaluatePasswordStrength("Abcdef!@"));
    }

    @Test
    void testMissingSpecialCharacter() {
        assertEquals("Trung bình",
                PasswordUtils.evaluatePasswordStrength("Abc12345"));
    }

    @Test
    void testPasswordTooShort() {
        assertEquals("Yếu",
                PasswordUtils.evaluatePasswordStrength("Ab1!"));
    }

    @Test
    void testOnlyLowercase() {
        assertEquals("Yếu",
                PasswordUtils.evaluatePasswordStrength("password"));
    }

    @Test
    void testUppercaseAndNumberOnly() {
        assertEquals("Yếu",
                PasswordUtils.evaluatePasswordStrength("ABC12345"));
    }
}