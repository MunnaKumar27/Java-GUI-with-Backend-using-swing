package Munna_Project;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class UserHome extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UserHome frame = new UserHome();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public UserHome() {

    }


    public UserHome(String userSes) throws IOException {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 1014, 597);
        setResizable(true);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(Color.lightGray);
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel label = new JLabel(); //JLabel Creation
        label.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\Java.png")); //Sets the image to be displayed as an icon
        Dimension size = label.getPreferredSize(); //Gets the size of the image
        label.setBounds(100, 100, size.width=1200, size.height=550);
        contentPane.add(label);

        JLabel lblNewLabel = new JLabel("Welcome To home Page ");
        lblNewLabel.setForeground(Color.RED);
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 50));
        lblNewLabel.setBounds(400, 13, 2730, 93);
        contentPane.add(lblNewLabel);

        JButton btnNewButton = new JButton("Logout");
        btnNewButton.setForeground(new Color(0, 0, 0));
        btnNewButton.setBackground(UIManager.getColor("Button.disabledForeground"));
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 39));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int a = JOptionPane.showConfirmDialog(btnNewButton, "Are you sure?");

                if (a == JOptionPane.YES_OPTION) {
                    dispose();
                    UserLogin obj = null;
                    try {
                        obj = new UserLogin();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    obj.setTitle("Student-Login");
                    obj.setVisible(true);
                }
                dispose();
                UserLogin obj = null;
                try {
                    obj = new UserLogin();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

                obj.setTitle("Student-Login");
                obj.setVisible(true);

            }
        });
        btnNewButton.setBounds(880, 650, 162, 60);
        btnNewButton.setBackground(Color.white);
        contentPane.add(btnNewButton);

        JButton button = new JButton("Change-password\r\n");
        button.setBackground(UIManager.getColor("Button.disabledForeground"));
        button.setBackground(Color.white);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ChangePassword bo = new ChangePassword(userSes);
                bo.setTitle("Change Password");
                bo.setVisible(true);

            }
        });
        button.setFont(new Font("Tahoma", Font.PLAIN, 35));
        button.setBounds(350, 650, 350, 60);
        button.setBackground(Color.white);
        contentPane.add(button);
    }
}