package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class admin_Login extends JFrame implements ActionListener {
    JLabel label1, label2, label3;
    JTextField textField2;
    JPasswordField passwordField3;

    JButton button1,button2;
    admin_Login(){
        super("ADMIN LOGIN PAGE");
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank1.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(165,110,100,100);
        add(image);

        ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("icon/card.png"));
        Image ii2 = ii1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon ii3 = new ImageIcon(ii2);
        JLabel iimage = new JLabel(ii3);
        iimage.setBounds(300,545,100,100);
        add(iimage);

        label2 = new JLabel("Username :");
        label2.setFont(new Font("Ralway", Font.BOLD, 19));
        label2.setForeground(Color.WHITE);
        label2.setBounds(30,240,130,30);
        add(label2);

        textField2 = new JTextField(15);
        textField2.setBounds(165,240,240,35);
        textField2.setBackground(Color.BLACK);
        textField2.setForeground(Color.WHITE);
        textField2.setCaretColor(Color.WHITE);
        textField2.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        textField2.setFont(new Font("Arial", Font.BOLD,19));
        add(textField2);

        label3 = new JLabel("Password: ");
        label3.setFont(new Font("Ralway", Font.BOLD, 19));
        label3.setForeground(Color.WHITE);
        label3.setBounds(30,300,375,30);
        add(label3);

        passwordField3 = new JPasswordField(15);
        passwordField3.setBounds(165,300,240,30);
        passwordField3.setBackground(Color.BLACK);
        passwordField3.setForeground(Color.WHITE);
        passwordField3.setCaretColor(Color.WHITE);
        passwordField3.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        passwordField3.setFont(new Font("Arial", Font.BOLD, 17));
        add(passwordField3);

        button1 = new JButton("SIGN IN");
        button1.setFont(new Font("Arial", Font.BOLD, 14));
        button1.setForeground(Color.WHITE);
        button1.setBackground(new Color(113, 80, 133));
        button1.setBounds(87,370,140, 30);
        button1.addActionListener(this);
        add(button1);

        button2 = new JButton("CLEAR");
        button2.setFont(new Font("Arial", Font.BOLD, 14));
        button2.setForeground(Color.WHITE);
        button2.setBackground(new Color(113, 80, 133));
        button2.setBounds(250,370,140, 30);
        button2.addActionListener(this);
        add(button2);

        ImageIcon iii1 = new ImageIcon(ClassLoader.getSystemResource("icon/backbg2.jpg"));
        Image iii2 = iii1.getImage().getScaledInstance(450,640,Image.SCALE_DEFAULT);
        ImageIcon iii3 = new ImageIcon(iii2);
        JLabel iiimage = new JLabel(iii3);
        iiimage.setBounds(0,0,450,640);
        add(iiimage);


        setLayout(null);
        setSize(458,675);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setUndecorated(true);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String id = textField2.getText();
        String pin1 = passwordField3.getText();
        if(e.getSource()==button1){
            if(id.equals("admin") && pin1.equals("hamza")){
                new admin();
                setVisible(false);
                JOptionPane.showMessageDialog(null,"Welcome To Online Bank","Welcome",JOptionPane.INFORMATION_MESSAGE);
            } else if (textField2.getText().equals("")||passwordField3.getText().equals("")) {
                JOptionPane.showMessageDialog(null,"PLEASE FILL ALL THE FIELDS");
            }else{
                JOptionPane.showMessageDialog(null,"INCORRECT USERNAME OR PASSWORD");
            }
        }else if(e.getSource()==button2){
            textField2.setText("");
            passwordField3.setText("");
        }
    }

    public static void main(String[] args) {

        new admin_Login();
    }
}