package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class admin extends JFrame implements ActionListener {
    JButton b1,b2,b3,b4;
    JPanel p1;

    admin(){

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank1.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(175,110,100,100);
        add(image);

        p1 = new JPanel();
        p1.setBackground(new Color(133, 34, 168));
        p1.setBounds(0,0,458,55);
        add(p1);

        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icon/bank1.png"));
        Image i21 = i11.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
        ImageIcon i31 = new ImageIcon(i21);
        JLabel image7 = new JLabel(i31);
        image7.setBounds(10,10,50,50);
        p1.add(image7);

        JLabel label1 = new JLabel("Online Banking System");
        label1.setBounds(0,5,50,55);
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("System",Font.BOLD,28));
        p1.add(label1);

        JLabel label = new JLabel("ADMIN PANEL");
        label.setBounds(130,220,400,35);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("System",Font.BOLD,28));
        add(label);

        ImageIcon icon = new ImageIcon(getClass().getResource("/icon/user.png"));
        Image image1 = icon.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(image1);

        b1 = new JButton("DELETE ACCOUNT",scaledIcon);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        b1.setBounds(30,280,200,130);
        b1.setBackground(Color.BLACK);
        b1.setHorizontalTextPosition(SwingConstants.CENTER);
        b1.setVerticalTextPosition(SwingConstants.BOTTOM);
        b1.setFont(new Font("System",Font.BOLD,14));
        b1.setIconTextGap(5);
        add(b1);

        ImageIcon icon1 = new ImageIcon(getClass().getResource("/icon/update.png"));
        Image image2 = icon1.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon1 = new ImageIcon(image2);

        b2 = new JButton("UPDATE INFORMATION",scaledIcon1);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        b2.setBackground(Color.BLACK);
        b2.setHorizontalTextPosition(SwingConstants.CENTER);
        b2.setVerticalTextPosition(SwingConstants.BOTTOM);
        b2.setFont(new Font("System",Font.BOLD,14));
        b2.setIconTextGap(5);
        b2.setBounds(240,280,200,130);
        add(b2);

        ImageIcon icon2 = new ImageIcon(getClass().getResource("/icon/info.png"));
        Image image3 = icon2.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon2 = new ImageIcon(image3);

        b3 = new JButton("SHOW INFORMATION",scaledIcon2);
        b3.setForeground(Color.WHITE);
        b3.addActionListener(this);
        b3.setBackground(Color.BLACK);
        b3.setHorizontalTextPosition(SwingConstants.CENTER);
        b3.setVerticalTextPosition(SwingConstants.BOTTOM);
        b3.setFont(new Font("System",Font.BOLD,14));
        b3.setIconTextGap(5);
        b3.setBounds(30,440,200,130);
        add(b3);

        ImageIcon icon5 = new ImageIcon(getClass().getResource("/icon/logout.png"));
        Image image5 = icon5.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon5 = new ImageIcon(image5);

        b4 = new JButton("LOGOUT",scaledIcon5);
        b4.setForeground(Color.WHITE);
        b4.addActionListener(this);
        b4.setBackground(Color.BLACK);
        b4.setBounds(240,440,200,130);
        b4.setHorizontalTextPosition(SwingConstants.CENTER);
        b4.setVerticalTextPosition(SwingConstants.BOTTOM);
        b4.setFont(new Font("System",Font.BOLD,14));
        b4.setIconTextGap(5);
        add(b4);

        setLayout(null);
        setSize(458,675);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.BLACK);
        setUndecorated(true);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            new delete();
            setVisible(false);
        } else if (e.getSource() == b2) {
            new update();
            setVisible(false);
        } else if (e.getSource() == b3) {
            new showInfo();
            setVisible(false);
        } else if (e.getSource() == b4) {
            int result = JOptionPane.showConfirmDialog(this, "Do You Want To Logout Your Account ", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
            if (result == JOptionPane.YES_OPTION) {
                new Login();
                setVisible(false);
                JOptionPane.showMessageDialog(this, "Successfully Logged out.");
            }
        }
    }
    public static void main(String[] args) {
        new admin();
    }
}
