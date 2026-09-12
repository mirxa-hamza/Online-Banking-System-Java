package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame  implements ActionListener{
    JLabel label2, label3;
    JTextField textField2;
    JPasswordField passwordField3;
    JPanel p1;

    JButton button1,button2,button3,button4;
    Login(){
        super("Online Banking System");

        p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(0,0,450,675);
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank1.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(165,110,100,100);
        p1.add(image);

        ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("icon/card.png"));
        Image ii2 = ii1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon ii3 = new ImageIcon(ii2);
        JLabel iimage = new JLabel(ii3);
        iimage.setBounds(300,545,100,100);
        p1.add(iimage);

        label2 = new JLabel("Account No :");
        label2.setFont(new Font("Ralway", Font.BOLD, 19));
        label2.setForeground(Color.WHITE);
        label2.setBounds(30,240,130,30);
        p1.add(label2);

        textField2 = new JTextField(15);
        textField2.setBounds(165,240,240,35);
        textField2.setBackground(Color.BLACK);
        textField2.setForeground(Color.WHITE);
        textField2.setCaretColor(Color.WHITE);
        textField2.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        textField2.setFont(new Font("Arial", Font.BOLD,19));
        p1.add(textField2);

        label3 = new JLabel("Password: ");
        label3.setFont(new Font("Ralway", Font.BOLD, 19));
        label3.setForeground(Color.WHITE);
        label3.setBounds(30,300,375,35);
        p1.add(label3);

        passwordField3 = new JPasswordField(15);
        passwordField3.setBounds(165,300,240,35);
        passwordField3.setBackground(Color.BLACK);
        passwordField3.setForeground(Color.WHITE);
        passwordField3.setCaretColor(Color.WHITE);
        passwordField3.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        passwordField3.setFont(new Font("Arial", Font.BOLD, 17));
        p1.add(passwordField3);

        button1 = new JButton("SIGN IN");
        button1.setFont(new Font("Arial", Font.BOLD, 15));
        button1.setForeground(Color.WHITE);
        button1.setBackground(new Color(113, 80, 133));
        button1.setBounds(87,370,140, 30);
        button1.addActionListener(this);
        p1.add(button1);

        button2 = new JButton("CLEAR");
        button2.setFont(new Font("Arial", Font.BOLD, 15));
        button2.setForeground(Color.WHITE);
        button2.setBackground(new Color(113, 80, 133));
        button2.setBounds(240,370,140, 30);
        button2.addActionListener(this);
        p1.add(button2);

        button3 = new JButton("SIGN UP");
        button3.setFont(new Font("Arial", Font.BOLD, 15));
        button3.setForeground(Color.WHITE);
        button3.setBackground(new Color(135, 141, 28, 255));
        button3.setBounds(87,410,295, 30);
        button3.addActionListener(this);
        p1.add(button3);

        button4 = new JButton("ADMIN LOGIN");
        button4.setFont(new Font("Arial", Font.BOLD, 14));
        button4.setForeground(Color.WHITE);
        button4.setBackground(new Color(113, 80, 133));
        button4.setBounds(295,17,140, 30);
        button4.addActionListener(this);
        p1.add(button4);

        ImageIcon iii1 = new ImageIcon(ClassLoader.getSystemResource("icon/backbg2.jpg"));
        Image iii2 = iii1.getImage().getScaledInstance(450,640,Image.SCALE_DEFAULT);
        ImageIcon iii3 = new ImageIcon(iii2);
        JLabel iiimage = new JLabel(iii3);
        iiimage.setBounds(0,0,450,640);
        p1.add(iiimage);


        setLayout(null);
        setSize(458,675);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.BLACK);
        //setUndecorated(true);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            if(e.getSource()==button1){
                conn c = new conn();
                String account_number = textField2.getText();
                String pin = passwordField3.getText();
                String q = "select * from login where account_number = '"+account_number+"' and pin = '"+pin+"' ";
                ResultSet resultSet = c.statement.executeQuery(q);
                if(resultSet.next()){
                    new main_Class(pin);
                    JOptionPane.showMessageDialog(null,"Welcome To Online Bank","Welcome",JOptionPane.INFORMATION_MESSAGE);
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null,"Incorrect Account Number Or Pin","Message",JOptionPane.WARNING_MESSAGE);
                }
            }else if(e.getSource()==button2){
                textField2.setText("");
                passwordField3.setText("");
            }else if(e.getSource()==button3){
                new Signup();
                setVisible(false);
            } else if (e.getSource()==button4) {
                setVisible(false);
                new admin_Login();
            }
        } catch (Exception E) {
            E.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Login();
    }
}