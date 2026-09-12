package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Withdrawl extends JFrame implements ActionListener{
    JButton b1,b2;
    JTextField textField;
    JPanel p1;
    String pin;
    Withdrawl(String pin){
        this.pin = pin;
        p1 = new JPanel();
        p1.setBackground(new Color(133, 34, 168));
        p1.setBounds(0,0,458,55);
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank1.png"));
        Image i2 = i1.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image7 = new JLabel(i3);
        image7.setBounds(10,0,50,50);
        p1.add(image7);

        JLabel label1 = new JLabel("Online Banking System");
        label1.setBounds(0,5,50,55);
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("System",Font.BOLD,28));
        p1.add(label1);

        JLabel label = new JLabel("Withdrawal");
        label.setBounds(160,130,400,35);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("System",Font.BOLD,28));
        add(label);

        JLabel label3 = new JLabel("MAXIMUM WITHDRAWAL LIMIT IS RS.10,000");
        label3.setForeground(Color.WHITE);
        label3.setFont(new Font("System", Font.BOLD, 16));
        label3.setBounds(70, 160, 700, 35);
        add(label3);

        JLabel label2 = new JLabel("ENTER THE AMOUNT:");
        label2.setBounds(30,220,400,35);
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("System",Font.BOLD,18));
        add(label2);

        textField = new JTextField();
        textField.setBackground(Color.BLACK);
        textField.setForeground(Color.WHITE);
        textField.setCaretColor(Color.WHITE);
        textField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        textField.setBounds(30,260,380,35);
        textField.setFont(new Font("Raleway",Font.BOLD,28));
        add(textField);

        b1 = new JButton("Withdrawal");
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
        try {
                 if(e.getSource()==b1) {
                String amount = textField.getText();
                Date date = new Date();
                if (textField.getText().equals("")||textField.getText().equals("0")) {
                    JOptionPane.showMessageDialog(null, "Please Enter The Amount You Want To Withdraw");
                } else {
                    conn c = new conn();
                    ResultSet resultSet = c.statement.executeQuery("select * from bank where pin = '" + pin + "'");
                    int balance = 0;
                    while (resultSet.next()) {
                        if (resultSet.getString("type").equals("Deposit")) {
                            balance += Integer.parseInt(resultSet.getString("amount"));
                        } else {
                            balance -= Integer.parseInt(resultSet.getString("amount"));
                        }
                    }
                    if (balance < Integer.parseInt(amount)) {
                        JOptionPane.showMessageDialog(null, "Insuffient Balance");
                        return;
                    }
                    int result = JOptionPane.showConfirmDialog(this, "Do You Want To Withdrawal Rs. "+amount+" From Your Account", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
                    if (result == JOptionPane.YES_OPTION) {
                        c.statement.executeUpdate("insert into bank values('" + pin + "', '" + date + "', 'Withdrawl', '" + amount + "' )");
                        JOptionPane.showMessageDialog(null, "Rs. " + amount + " Debited Successfully");
                        new main_Class(pin);
                        setVisible(false);
                    }
                }
            }else if (e.getSource()==b2) {
                     new main_Class(pin);
                     setVisible(false);
                 }
        }catch (Exception E) {
            E.printStackTrace();
        }
            }
    public static void main(String[] args) {
        new Withdrawl("");
    }
}
