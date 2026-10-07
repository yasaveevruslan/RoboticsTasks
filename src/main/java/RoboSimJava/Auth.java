package RoboSimJava;

import javax.swing.*;

public class Auth {


    private static int id = 0;
    private static String userIdFirst = "gorr03";
    private static String passwordFirst = "12347890";
    private String userId;
    private String password;


    public Auth(String userId, String password) {
        this.userId = userId;
        this.password = password;
        authUser(this.userId, this.password);
    }

    public void authUser(String userId, String password) {
        if (userId.equals(userIdFirst) && password.equals(passwordFirst)) {
            Main.isAuth = true;
        } else {
            JOptionPane.showMessageDialog(null, "Не верный логин или пароль", "Ошибка", JOptionPane.WARNING_MESSAGE);
        }
    }
}
