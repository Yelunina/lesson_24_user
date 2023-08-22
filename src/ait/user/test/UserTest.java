package ait.user.test;
/*Продолжить писать код, начатый в классной работе.
В классе UserTest написать тесты для setPassword. В классе User изменить метод setPassword,
чтобы работала валидация пароля исходя из требований указанных в комментарии к коду.
 */

import ait.user.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    private User user;
    private String email = "john@gmail.com";
    private String password = "12345678Ait!";

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
        assertEquals(email, user.getEmail());
    }

    @Test
    void testEmailDoubleAt() {
        String invalidEmail = "jo@hn@gmx.de";
        user.setEmail(invalidEmail);
        assertEquals(email, user.getEmail());
    }

    @Test
    void testEmailDotAfterAt() {
        String invalidEmail = "john@gmxde";
        user.setEmail(invalidEmail);
        assertEquals(email, user.getEmail());
    }

    @Test
    void testEmailLastDot() {
        String invalidEmail = "john@gmxde.";
        user.setEmail(invalidEmail);
        assertEquals(email, user.getEmail());
        invalidEmail = "john@gmxd.e";
        user.setEmail(invalidEmail);
        assertEquals(email, user.getEmail());
    }

    @Test
    void testEmailIncorrectSymbol() {
        String invalidEmail = "jo!hn@gmx.de";
        user.setEmail(invalidEmail);
        assertEquals(email, user.getEmail());
    }

    /*
    TODO Homework
    1) Min 8 symbols
    2) Min one symbol in uppercase
    3) Min one symbol in lowercase
    4) Min one symbol is digit
    5) Min one symbol is a special symbol (!%@*&)
     */
    @Test
    void testValidPassword() {
        String validPassword = "12345678Ait!";
        user.setPassword(validPassword);
        assertEquals(password, user.getPassword());
    }

    @Test
    void testPasswordMinEightSymbols() {
        String invalidPassword = "678Ait!";
        user.setPassword(invalidPassword);
        assertEquals(password, user.getPassword());
    }

    @Test
    void testPasswordMinOneSymbolInUppercase() {
        String invalidPassword = "5678ait!";
        user.setPassword(invalidPassword);
        assertEquals(password, user.getPassword());
    }

    @Test
    void testPasswordMinOneSymbolInLowercase() {
        String invalidPassword = "5678AIT!";
        user.setPassword(invalidPassword);
        assertEquals(password, user.getPassword());
    }

    @Test
    void testPasswordMinOneSymbolIsDigit() {
        String invalidPassword = "AitAitT!";
        user.setPassword(invalidPassword);
        assertEquals(password, user.getPassword());
    }

    @Test
    void testPasswordMinOneSymbolIsSpecialSymbol() {
        String invalidPassword = "678Ait589";
        user.setPassword(invalidPassword);
        assertEquals(password, user.getPassword());
    }

}