package RoboSimJava.pages;

import RoboSimJava.Auth;
import RoboSimJava.Main;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class LoginFrame extends JFrame {


    private JPanel formPanel, main, header, menuPanel, logoPanel;

    private JLabel usernameLabel;
    private JTextField usernameField;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JCheckBox showPasswordBox;
    private JButton authButton;

    private JLabel logoLabel;
    private JLabel subtitleLabel;
    private JButton themeButton;
    private JComboBox languageButton;

    private final Font font = new Font("Segoe UI", Font.PLAIN, 14);



    private final String[][] text = {
            {"Авторизация", "тема", "Менеджер задач", "Твой личный помощник в отслеживании заданий и прогресса", "логин", "пароль", "показать пароль", "Авторизация"},
            {"Authorization", "topic", "Task Manager", "Your personal assistant for tracking tasks and progress", "login", "password", "show password", "Authorization"},
            {"Autorisierung", "Betreff", "Task-Manager", "Ihr persönlicher Assistent zur Verfolgung von Aufgaben und Fortschritten", "Login", "Passwort", "Passwort anzeigen", "Autorisierung"}
    };

    public LoginFrame() {
        try{
            initAuth();
            addPanels();
            updateAllWindows();
            repaint();
            revalidate();
        } catch (IOException ignored) {

        }
        setVisible(true);
    }

    private void updateAllWindows() {
        SwingUtilities.invokeLater(() -> {
            for (Window window : Window.getWindows()) {
                if (window.isVisible()) {
                    SwingUtilities.updateComponentTreeUI(window);
                    window.revalidate();
                    window.repaint();
                }
            }
        });
    }

    private void initAuth() throws IOException {
        setTitle(text[0][0]);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(550, 620);
        setResizable(false);
        URL iconURL = getClass().getResource("/icon.png");
        if (iconURL != null) {
            ImageIcon icon = new ImageIcon(iconURL);
            setIconImage(icon.getImage());
        }
    }



    private void addPanels()
    {
        main = new JPanel();
        main.setBackground(Main.checkTheme ? Main.frameColorDark : Main.frameColorLight);
        main.add(headerPanel());
        main.add(createFormPanel());
        getContentPane().add(main);

    }

    private JPanel headerPanel()
    {
        header = new JPanel();
        header.setBackground(Main.checkTheme ? Main.frameColorDark : Main.frameColorLight);
        header.setLayout(new BoxLayout(header, BoxLayout.Y_AXIS));



        header.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0));
        header.setAlignmentX(Component.CENTER_ALIGNMENT);

        menuPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        menuPanel.setOpaque(false);

        themeButton = new JButton(text[0][1]);
        themeButton.setFont(font);
        themeButton.setFocusPainted(false);
        themeButton.setBackground(Main.checkTheme ? Main.buttonColorDark : Main.buttonColorLight);
        themeButton.setForeground(Main.checkTheme ? Main.textColorDark : Main.textColorLight);
        menuPanel.add(themeButton);

        themeButton.addActionListener(e -> {
            Main.checkTheme = !Main.checkTheme;
            changeColorObject();
        });

        String[] language = {"ру", "en", "de"};
        languageButton = new JComboBox(language);
        languageButton.setFont(font);
        languageButton.setBackground(Main.checkTheme ? Main.buttonColorDark : Main.buttonColorLight);
        languageButton.setForeground(Main.checkTheme ? Main.textColorDark : Main.textColorLight);
        languageButton.setFocusable(false);
        menuPanel.add(languageButton);

        languageButton.addActionListener(e -> {
            changeLanguage(languageButton.getSelectedIndex());
        });

        header.add(menuPanel);

        logoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        logoPanel.setOpaque(false);

        JLabel logoIcon = new JLabel();
        URL iconURL = getClass().getResource("/icon.png");
        if (iconURL != null) {
            ImageIcon icon = new ImageIcon(iconURL);
            logoIcon.setIcon(icon);
        }
        logoPanel.add(logoIcon);

        logoLabel = new JLabel(text[0][2]);
        logoLabel.setFont(new Font("Segor UI", Font.BOLD, 30));
        logoLabel.setForeground(Main.checkTheme ? Main.textColorDark : Main.textColorLight);
        logoPanel.add(logoLabel);

        header.add(logoPanel);
        header.add(Box.createVerticalStrut(5));

        subtitleLabel = new JLabel(text[0][3]);
        subtitleLabel.setFont(font);
        subtitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        subtitleLabel.setForeground(Main.checkTheme ? Main.textColorDark : Main.textColorLight);
        header.add(subtitleLabel);
        header.add(Box.createVerticalStrut(15));

        JSeparator separator = new JSeparator();
        separator.setAlignmentX(Component.CENTER_ALIGNMENT);
        separator.setMaximumSize(new Dimension(380, 2));
        header.add(separator);

        return header;
    }

    private JPanel createFormPanel()
    {
        formPanel = new JPanel();
        formPanel.setLayout(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 5, 5, 5));

        formPanel.setBackground(Main.checkTheme ? Main.frameColorDark : Main.frameColorLight);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 10, 8, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;

        // Username
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.weightx = 0.2;

        usernameLabel = new JLabel(text[0][4]);
        usernameLabel.setFont(font);
        usernameLabel.setForeground(Main.checkTheme ? Main.textColorDark : Main.textColorLight);
        formPanel.add(usernameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.weightx = 0.8;

        usernameField = new JTextField();
        usernameField.setFont(font);
        usernameField.setForeground(Main.checkTheme ? Main.textColorDark : Main.textColorLight);
        usernameField.setPreferredSize((new Dimension(220, 35)));
        usernameField.setMinimumSize((new Dimension(180, 35)));
        formPanel.add(usernameField, gbc);

        //password
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.weightx = 0.2;

        passwordLabel = new JLabel(text[0][5]);
        passwordLabel.setFont(font);
        passwordLabel.setForeground(Main.checkTheme ? Main.textColorDark : Main.textColorLight);
        formPanel.add(passwordLabel, gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.weightx = 0.8;

        passwordField = new JPasswordField();
        passwordField.setFont(font);
        passwordField.setForeground(Main.checkTheme ? Main.textColorDark : Main.textColorLight);
        passwordField.setPreferredSize(new Dimension(220, 35));
        passwordField.setMinimumSize(new Dimension(180, 35));
        formPanel.add(passwordField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.weightx = 0.2;

        showPasswordBox = new JCheckBox(text[0][6]);
        showPasswordBox.setFont(font);
        showPasswordBox.setForeground(Main.checkTheme ? Main.textColorDark : Main.textColorLight);
        showPasswordBox.setFocusPainted(false);
        showPasswordBox.setPreferredSize(new Dimension(140, 30));
        showPasswordBox.addActionListener(e -> {
            if (showPasswordBox.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }
        });
        showPasswordBox.setBackground(Main.checkTheme ? Main.frameColorDark : Main.frameColorLight);
        formPanel.add(showPasswordBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.weightx = 0.2;

        authButton = new JButton(text[0][7]);
        authButton.setFont(font);
        authButton.setBackground(Main.checkTheme ? Main.buttonColorDark : Main.buttonColorLight);
        authButton.setForeground(Main.checkTheme ? Main.textColorDark : Main.textColorLight);
        authButton.setFocusPainted(false);
        formPanel.add(authButton, gbc);

        authButton.addActionListener(e -> {
            Auth a = new Auth(usernameField.getText(), new String(passwordField.getPassword()));
            if (Main.isAuth) {
                setVisible(false);
                openWindow();
            }
        });

        return formPanel;
    }


    private void performLogin() {

    }

    private void openWindow() {
        SwingUtilities.invokeLater(() -> {
            JFrame frame;
            frame = new RoboSimJava.Window();
            frame.setVisible(true);
        });
    }


    private void changeColorObject() {
        authButton.setForeground(Main.checkTheme ? Main.textColorDark : Main.textColorLight);
        authButton.setBackground(Main.checkTheme ? Main.buttonColorDark : Main.buttonColorLight);
        showPasswordBox.setForeground(Main.checkTheme ? Main.textColorDark : Main.textColorLight);
        showPasswordBox.setBackground(Main.checkTheme ? Main.frameColorDark : Main.frameColorLight);
        passwordField.setForeground(Main.checkTheme ? Main.textColorDark : Main.textColorLight);
        passwordLabel.setForeground(Main.checkTheme ? Main.textColorDark : Main.textColorLight);
        usernameField.setForeground(Main.checkTheme ? Main.textColorDark : Main.textColorLight);
        usernameLabel.setForeground(Main.checkTheme ? Main.textColorDark : Main.textColorLight);
        formPanel.setBackground(Main.checkTheme ? Main.frameColorDark : Main.frameColorLight);
        subtitleLabel.setForeground(Main.checkTheme ? Main.textColorDark : Main.textColorLight);
        logoLabel.setForeground(Main.checkTheme ? Main.textColorDark : Main.textColorLight);
        languageButton.setForeground(Main.checkTheme ? Main.textColorDark : Main.textColorLight);
        languageButton.setBackground(Main.checkTheme ? Main.buttonColorDark : Main.buttonColorLight);
        themeButton.setForeground(Main.checkTheme ? Main.textColorDark : Main.textColorLight);
        themeButton.setBackground(Main.checkTheme ? Main.buttonColorDark : Main.buttonColorLight);
        header.setBackground(Main.checkTheme ? Main.frameColorDark : Main.frameColorLight);
        main.setBackground(Main.checkTheme ? Main.frameColorDark : Main.frameColorLight);
        menuPanel.setBackground(Main.checkTheme ? Main.frameColorDark : Main.frameColorLight);
        logoPanel.setBackground(Main.checkTheme ? Main.frameColorDark : Main.frameColorLight);
    }

    private void changeLanguage(int index) {
        setTitle(text[index][0]);
        themeButton.setText(text[index][1]);
        logoLabel.setText(text[index][2]);
        subtitleLabel.setText(text[index][3]);
        usernameLabel.setText(text[index][4]);
        passwordLabel.setText(text[index][5]);
        showPasswordBox.setText(text[index][6]);
        authButton.setText(text[index][7]);
    }

}
