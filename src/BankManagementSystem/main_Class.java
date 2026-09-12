package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class main_Class extends JFrame implements ActionListener {
    JButton b1,b2,b3,b5,b7,b8,statment;
    String pin;
    JPanel p1,p2;
    main_Class(String pin){
        this.pin = pin;

        p1 = new JPanel();
        p1.setBackground(new Color(133, 34, 168));
        p1.setBounds(0,0,458,55);
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank1.png"));
        Image i2 = i1.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image7 = new JLabel(i3);
        image7.setBounds(10,10,50,50);
        p1.add(image7);

        JLabel label1 = new JLabel("Online Banking System");
        label1.setBounds(0,5,50,55);
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("System",Font.BOLD,28));
        p1.add(label1);

        p2 = new JPanel();
        p2.setBackground(Color.lightGray);
        p2.setBounds(30,75,400,120);
        p2.setLayout(null);
        add(p2);

        JLabel label11 = new JLabel("Balance:");
        label11.setBounds(30,10,200,35);
        label11.setForeground(Color.BLACK);
        label11.setFont(new Font("System",Font.BOLD,25));
        p2.add(label11);

        JLabel bal = new JLabel();
        bal.setBounds(110,55,200,50);
        bal.setForeground(new Color(133, 34, 168));
        bal.setFont(new Font("System",Font.BOLD,28));
        p2.add(bal);

        int balance = 0;
        try{
            conn c = new conn();
            String q = "select * from bank where pin = '"+pin+"'";
            ResultSet rs = c.statement.executeQuery(q);
            while (rs.next()){
                if(rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                }else{
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        } catch (Exception E) {
            E.printStackTrace();
        }
        bal.setText("Rs. "+balance);

        statment = new JButton("View Statement");
        statment.setBackground(new Color(133, 34, 168));
        statment.setBounds(30,195,400,30);
        statment.setFont(new Font("Arial", Font.BOLD, 15));
        statment.setForeground(Color.WHITE);
        statment.addActionListener(this);
        add(statment);

        ImageIcon icon = new ImageIcon(getClass().getResource("/icon/cash-flow.png"));
        Image image = icon.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(image);

        b8 = new JButton("Funds Transfer", scaledIcon);
        b8.setForeground(Color.WHITE);
        b8.setBackground(Color.BLACK);
        b8.setBounds(30, 265, 190, 110);
        b8.setHorizontalTextPosition(SwingConstants.CENTER);
        b8.setVerticalTextPosition(SwingConstants.BOTTOM);
        b8.setFont(new Font("System",Font.BOLD,15));
        b8.setIconTextGap(4);
        b8.addActionListener(this);
        add(b8);

        ImageIcon icon1 = new ImageIcon(getClass().getResource("/icon/bill.png"));
        Image image1 = icon1.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon1 = new ImageIcon(image1);

        b2 = new JButton("Bills & Top up",scaledIcon1);
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);
        b2.setHorizontalTextPosition(SwingConstants.CENTER);
        b2.setVerticalTextPosition(SwingConstants.BOTTOM);
        b2.setFont(new Font("System",Font.BOLD,15));
        b2.setIconTextGap(4);
        b2.addActionListener(this);
        b2.setBounds(240,265,190,110);
        add(b2);

        ImageIcon icon2 = new ImageIcon(getClass().getResource("/icon/deposit.png"));
        Image image2 = icon2.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon2 = new ImageIcon(image2);

        b1 = new JButton("DEPOSIT",scaledIcon2);
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        b1.addActionListener(this);
        b1.setBounds(30,390,190,110);
        b1.setHorizontalTextPosition(SwingConstants.CENTER);
        b1.setVerticalTextPosition(SwingConstants.BOTTOM);
        b1.setFont(new Font("System",Font.BOLD,15));
        b1.setIconTextGap(4);
        add(b1);

        ImageIcon icon3 = new ImageIcon(getClass().getResource("/icon/withdrawal.png"));
        Image image3 = icon3.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon3 = new ImageIcon(image3);

        b3 = new JButton("Withdrawal",scaledIcon3);
        b3.setForeground(Color.WHITE);
        b3.setBackground(Color.BLACK);
        b3.addActionListener(this);
        b3.setBounds(240,390,190,110);
        b3.setHorizontalTextPosition(SwingConstants.CENTER);
        b3.setVerticalTextPosition(SwingConstants.BOTTOM);
        b3.setFont(new Font("System",Font.BOLD,15));
        b3.setIconTextGap(4);
        add(b3);

        ImageIcon icon4 = new ImageIcon(getClass().getResource("/icon/pin.png"));
        Image image4 = icon4.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon4 = new ImageIcon(image4);

        b5 = new JButton("PIN CHANGE",scaledIcon4);
        b5.setForeground(Color.WHITE);
        b5.setBackground(Color.BLACK);
        b5.addActionListener(this);
        b5.setBounds(30,515,190,110);
        b5.setHorizontalTextPosition(SwingConstants.CENTER);
        b5.setVerticalTextPosition(SwingConstants.BOTTOM);
        b5.setFont(new Font("System",Font.BOLD,15));
        b5.setIconTextGap(4);
        add(b5);

        ImageIcon icon5 = new ImageIcon(getClass().getResource("/icon/logout.png"));
        Image image5 = icon5.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon5 = new ImageIcon(image5);

        b7 = new JButton("LOGOUT",scaledIcon5);
        b7.setForeground(Color.WHITE);
        b7.setBackground(Color.BLACK);
        b7.addActionListener(this);
        b7.setBounds(240,515,190,110);
        b7.setHorizontalTextPosition(SwingConstants.CENTER);
        b7.setVerticalTextPosition(SwingConstants.BOTTOM);
        b7.setFont(new Font("System",Font.BOLD,15));
        b7.setIconTextGap(4);
        add(b7);

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
        try{
            if(e.getSource()==statment){
                new mini(pin);
                setVisible(false);
            }
            else if(e.getSource()==b1){
                new Deposit(pin);
                setVisible(false);
            } else if (e.getSource()==b2) {
                new fastCash(pin);
                setVisible(false);
            } else if (e.getSource()==b3) {
                new Withdrawl(pin);
                setVisible(false);
            } else if (e.getSource()==b5) {
                new Pin(pin);
                setVisible(false);
            }else if (e.getSource()==b7) {
                int result = JOptionPane.showConfirmDialog(this, "Do You Want To Logout Your Account ", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
                if (result == JOptionPane.YES_OPTION) {
                    new Login();
                    setVisible(false);
                    JOptionPane.showMessageDialog(this, "Successfully Logged out.");
                }
            } else if (e.getSource()==b8) {
                new transfer(pin);
                setVisible(false);
            }
        } catch (Exception E) {
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new main_Class("");

    }
}
