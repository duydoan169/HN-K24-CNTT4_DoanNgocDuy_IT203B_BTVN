package bai03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserProcessorTest {
    private UserProcessor userProcessor;

    @BeforeEach
    void setUp() {
        userProcessor = new UserProcessor();
    }

    @Test
    void shouldReturnSameEmailWhenEmailIsValid() {
        String result = userProcessor.processEmail("user@gmail.com");
        assertEquals("user@gmail.com", result);
    }

    @Test
    void shouldThrowExceptionWhenEmailMissingDomain(){
        assertThrows(IllegalArgumentException.class,
                () -> userProcessor.processEmail("user@"));
    }

    @Test
    void shouldConvertEmailToLowerCase() {

        String result = userProcessor.processEmail("Example@Gmail.com");

        assertEquals("example@gmail.com", result);
    }
}