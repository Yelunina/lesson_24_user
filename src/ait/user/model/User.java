package ait.user.model;

public class User {
    private String email;
    private String password;

    public User(String email, String password) {
        setEmail(email);
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (emailIsValid(email)) {
            this.email = email;
        } else {
            System.out.println(email + " is not valid");
        }

    }

    /*
    1) '@' - exist and only one -> Done
    2) '.' - min one dot after @ -> Done
    3) min two symbols after last dot -> Done
    4) alphabetic, digits, '@', '.', '_', '-' -> Done
     */
    private boolean emailIsValid(String email) {
        int at = email.indexOf('@');
        if (at == -1 || email.lastIndexOf('@') != at) {
            return false;
        }
        if (email.indexOf('.', at + 1) == -1) {
            return false;
        }
        if (email.lastIndexOf('.') >= email.length() - 2) {
            return false;
        }
        for (int i = 0; i < email.length(); i++) {
            char c = email.charAt(i);
            if (!(Character.isDigit(c) || Character.isAlphabetic(c) || c == '@' || c == '.' || c == '_' || c == '-')) {
                return false;
            }
        }
        return true;
    }

    public String getPassword() {
        return password;
    }

    /*
    TODO Homework
    1) Min 8 symbols
    2) Min one symbol in uppercase
    3) Min one symbol in lowercase
    4) Min one symbol is digit
    5) Min one symbol is a special symbol (!%@*&)
     */
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}