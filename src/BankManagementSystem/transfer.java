package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class transfer extends JFrame implements ActionListener {
    String pin;
    JTextField textField, textField1;
    JButton b1, b2;
    JPanel p1;

    transfer(String pin) {
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

        JLabel label3 = new JLabel("Online Banking System");
        label3.setBounds(0,5,50,55);
        label3.setForeground(Color.WHITE);
        label3.setFont(new Font("System",Font.BOLD,28));
        p1.add(label3);

        JLabel label = new JLabel("FUNDS TRANSFER");
        label.setBounds(105,130,400,35);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("System",Font.BOLD,28));
        add(label);

        JLabel label1 = new JLabel("MAXIMUM TRANSFER LIMIT IS RS.10,000");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("System", Font.BOLD, 16));
        label1.setBounds(70, 160, 700, 35);
        add(label1);

        JLabel label4 = new JLabel("ENTER THE ACCOUNT NUMBER:");
        label4.setBounds(30,220,400,35);
        label4.setForeground(Color.WHITE);
        label4.setFont(new Font("System",Font.BOLD,18));
        add(label4);

        textField = new JTextField();
        textField.setBackground(Color.BLACK);
        textField.setForeground(Color.WHITE);
        textField.setCaretColor(Color.WHITE);
        textField.setBounds(30,260,380,35);
        textField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        textField.setFont(new Font("Raleway",Font.BOLD,25));
        add(textField);

        JLabel label5 = new JLabel("ENTER THE AMOUNT:");
        label5.setBounds(30,310,400,35);
        label5.setForeground(Color.WHITE);
        label5.setFont(new Font("System",Font.BOLD,18));
        add(label5);

        textField1 = new JTextField();
        textField1.setBackground(Color.BLACK);
        textField1.setForeground(Color.WHITE);
        textField1.setCaretColor(Color.WHITE);
        textField1.setBounds(30,350,380,35);
        textField1.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        textField1.setFont(new Font("Raleway",Font.BOLD,25));
        add(textField1);

        b1 = new JButton("Transfer");
        b1.setForeground(Color.WHITE);
        b1.setBackground(new Color(133, 34, 168));
        b1.setFont(new Font("System",Font.BOLD,13));
        b1.addActionListener(this);
        b1.setBounds(240,470,170,40);
        add(b1);

        b2 = new JButton("Cancel");
        b2.setForeground(Color.WHITE);
        b2.setBackground(new Color(255, 183, 1));
        b2.addActionListener(this);
        b2.setFont(new Font("System",Font.BOLD,13));
        b2.setBounds(240,525,170,40);
        add(b2);


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
        if (e.getSource() == b1) {

                String toAccount = textField.getText().trim();
                String amountStr = textField1.getText().trim();
                Date date = new Date();
                if (toAccount.equals("") || amountStr.equals("") || amountStr.equals("0")) {
                    JOptionPane.showMessageDialog(null, "Please enter valid account number and amount.");
                    return;
                }
            int result = JOptionPane.showConfirmDialog(this, "Do You Want To Transfer Rs "+amountStr+" To Account Number "+toAccount, "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
            if (result == JOptionPane.YES_OPTION){
                int amount = Integer.parseInt(amountStr);
                conn c = new conn();
                ResultSet rsSender = c.statement.executeQuery("SELECT * FROM bank WHERE pin = '" + pin + "'");
                int balance = 0;
                while (rsSender.next()) {
                    String type = rsSender.getString("type");
                    int amt = Integer.parseInt(rsSender.getString("amount"));
                    if (type.equals("Deposit") || type.equals("Transferred to You")) {
                        balance += amt;
                    } else {
                        balance -= amt;
                    }
                }
                if (balance < amount) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance.");
                    return;
                }
                ResultSet rsReceiver = c.statement.executeQuery("SELECT * FROM login WHERE account_number = '" + toAccount + "'");
                if (rsReceiver.next()) {
                    int receiverPin = rsReceiver.getInt("pin");
                    String q1 = "INSERT INTO bank VALUES ('" + pin + "', '" + date + "', 'Transferred', '" + amount + "')";
                    c.statement.executeUpdate(q1);
                    String q2 = "INSERT INTO bank VALUES ('" + receiverPin + "', '" + date + "', 'Received', '" + amount + "')";
                    c.statement.executeUpdate(q2);
                    JOptionPane.showMessageDialog(null, "Rs. " + amount + " Transferred Successfully To Account: " + toAccount);
                    new main_Class(pin);
                    setVisible(false);
                }
                } else {
                    JOptionPane.showMessageDialog(null, "Account not found!");
                }
            }else if (e.getSource() == b2) {
            new main_Class(pin);
            setVisible(false);
        }
        }  catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error occurred: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new transfer("");
    }
}