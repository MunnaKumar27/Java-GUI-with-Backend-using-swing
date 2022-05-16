package Munna_Project;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class UserLogin extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField textField;
    private JPasswordField passwordField;
    private JButton btnNewButton;
    private JPanel contentPane;
    private JTextField firstname;
    private JTextField lastname;
    private JTextField email;
    private JTextField username;
    private JTextField mob;
    private JLabel label;


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UserLogin frame = new UserLogin();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public UserLogin() throws IOException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 1200, 600);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(Color.black);
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Welcome To Login Page ");
        lblNewLabel.setForeground(Color.black);
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 50));
        lblNewLabel.setBounds(400, 10, 2730, 93);
        contentPane.add(lblNewLabel);

        textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        textField.setBounds(481, 170, 281, 68);
        contentPane.add(textField);
        textField.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        passwordField.setBounds(481, 286, 281, 68);
        contentPane.add(passwordField);


        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBackground(Color.white);
        lblUsername.setForeground(Color.white);
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 31));
        lblUsername.setBounds(250, 166, 193, 52);
        contentPane.add(lblUsername);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setForeground(Color.white);
        lblPassword.setBackground(Color.white);
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 31));
        lblPassword.setBounds(250, 286, 193, 52);
        contentPane.add(lblPassword);

        JLabel label = new JLabel(); //JLabel Creation
        label.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\Untitled design.png"));
        Dimension size = label.getPreferredSize();
        label.setBounds(100, 15, size.width=1000, size.height=500);
        contentPane.add(label);


        btnNewButton  = new JButton("Register");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
        btnNewButton.setBounds(250, 400, 162, 73);
        contentPane.add(btnNewButton);
        btnNewButton.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent e) {
            UserRegistration obj = new UserRegistration();
            obj.setVisible(true);
        }
        });

        btnNewButton = new JButton("Login");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
        btnNewButton.setBounds(580, 400, 162, 73);
        btnNewButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {


                String userName = textField.getText();
                String password = passwordField.getText();
                try {
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/swing_demo",
                            "root", "");

                    PreparedStatement st = (PreparedStatement) connection
                            .prepareStatement("Select name, password from student where name=? and password=?");

                    st.setString(1, userName);
                    st.setString(2, password);
                    ResultSet rs = st.executeQuery();
                    if (rs.next()) {
                        dispose();
                        UserHome ah = new UserHome(userName);
                        ah.setTitle("Welcome");
                        ah.setVisible(true);
                        JOptionPane.showMessageDialog(btnNewButton, "You have successfully logged in");
                    } else {
                        JOptionPane.showMessageDialog(btnNewButton, "Wrong Username & Password");
                    }
                } catch (SQLException | IOException sqlException) {
                    sqlException.printStackTrace();
                }
            }
        });


        contentPane.add(btnNewButton);


        label = new JLabel("");
        label.setBounds(0, 0, 1008, 562);
        contentPane.add(label);


    }

}


