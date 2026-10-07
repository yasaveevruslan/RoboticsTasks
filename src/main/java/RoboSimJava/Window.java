package RoboSimJava;

import RoboSimJava.pages.LoginFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Window extends JFrame {

    private static JPanel headerPanel, menuPanel;
    private static JButton themeButton, exitButton;
    private static JComboBox languageButton;

    private final Font font = new Font("Segoe UI", Font.PLAIN, 14);

    public Window() {
        initWindow();
        setVisible(true);
        initBaseUI();
    }

    private void initWindow(){
        setTitle("Основное окно");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setBackground(Main.checkTheme ? Main.frameColorDark : Main.frameColorLight);
        panel.add(addHeader());
        add(panel);

    }

    private JPanel addHeader() {
        headerPanel = new JPanel();
        menuPanel = new JPanel();

        menuPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        menuPanel.setOpaque(false);

        themeButton = new JButton("Тема");
        themeButton.setFont(font);
        themeButton.setFocusPainted(false);
        themeButton.setBackground(Main.checkTheme ? Main.buttonColorDark : Main.buttonColorLight);
        themeButton.setForeground(Main.checkTheme ? Main.textColorDark : Main.textColorLight);
        menuPanel.add(themeButton);

        themeButton.addActionListener(e -> {
            Main.checkTheme = !Main.checkTheme;
//            changeColorObject();
        });

        String[] language = {"ру", "en", "de"};
        languageButton = new JComboBox(language);
        languageButton.setFont(font);
        languageButton.setBackground(Main.checkTheme ? Main.buttonColorDark : Main.buttonColorLight);
        languageButton.setForeground(Main.checkTheme ? Main.textColorDark : Main.textColorLight);
        languageButton.setFocusable(false);
        menuPanel.add(languageButton);

        languageButton.addActionListener(e -> {
//            changeLanguage(languageButton.getSelectedIndex());
        });

        headerPanel.add(menuPanel);


        return headerPanel;
    }

    private void initBaseUI() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                handleWindowClosing();
            }
        });
    }

    protected void handleWindowClosing() {
        int confirm = JOptionPane.showConfirmDialog(
                this,
                "Точно хотите выйти?",
                "Выход",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );
        if (confirm == JOptionPane.YES_OPTION){
            this.dispose();

            new LoginFrame().setVisible(true);
        }
    }
}
