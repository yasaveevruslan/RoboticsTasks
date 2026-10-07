package RoboSimJava;

import RoboSimJava.pages.LoginFrame;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static boolean isAuth = false;
    public static int idUser;
    public static boolean checkTheme = false;

    public static final Color frameColorDark = new Color(95, 44, 105);
    public static final Color textColorDark = new Color(57, 123, 197);
    public static final Color buttonColorLight = new Color(182, 143, 190);
    public static final Color frameColorLight = new Color(194, 21, 229);
    public static final Color textColorLight = new Color(40, 63, 113);
    public static final Color buttonColorDark = new Color(131, 61, 145);


    public static void main(String[] args) {
        SwingUtilities.invokeLater(LoginFrame::new);
    }
}