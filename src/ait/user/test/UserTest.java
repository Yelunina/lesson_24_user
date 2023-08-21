package ait.user.test;

import ait.user.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    private User user;
    private String email = "john@gmail.com";
    private String password = "1234";

    @BeforeEach
    void setUp() {
        user = new User(email, password);
    }

    @Test
    void testValidEmail() {
        String validEmail = "john@gmx.de";
        user.setEmail(validEmail);
        assertEquals(validEmail, user.getEmail());
    }

    @Test
    void testEmailWithoutAt() {
        String invalidEmail = "john.gmx.de";
        user.setEmail(invalidEmail);
        assertEquals(email,user.getEmail());
    }

    @Test
    void testEmailDoubleAt() {
        String invalidEmail = "jo@hn@gmx.de";
        user.setEmail(invalidEmail);
        assertEquals(email,user.getEmail());
    }

    @Test
    void testEmailDotAfterAt() {
        String invalidEmail = "john@gmxde";
        user.setEmail(invalidEmail);
        assertEquals(email,user.getEmail());
    }

    @Test
    void testEmailLastDot() {
        String invalidEmail = "john@gmxde.";
        user.setEmail(invalidEmail);
        assertEquals(email,user.getEmail());
        invalidEmail = "john@gmxd.e";
        user.setEmail(invalidEmail);
        assertEquals(email,user.getEmail());
    }

    @Test
    void testEmailIncorrectSymbol() {
        String invalidEmail = "jo!hn@gmx.de";
        user.setEmail(invalidEmail);
        assertEquals(email,user.getEmail());
    }
}