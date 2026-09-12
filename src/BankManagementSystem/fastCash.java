package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class fastCash extends JFrame implements ActionListener {
    JButton b1,b2;
    String pin;
    JPanel p1;
    JTextField textField,textField1;
    fastCash(String pin){
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

        JLabel label = new JLabel("Bills & Top up");
        label.setBounds(140,130,400,35);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("System",Font.BOLD,28));
        add(label);

        JLabel label1 = new JLabel("ENTER THE COMPANY NAME:");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("System",Font.BOLD,18));
        label1.setBounds(30,200,400,35);
        add(label1);

        textField = new JTextField();
        textField.setBackground(Color.BLACK);
        textField.setForeground(Color.WHITE);
        textField.setCaretColor(Color.WHITE);
        textField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        textField.setBounds(30,240,380,35);
        textField.setFont(new Font("Raleway",Font.BOLD,25));
        add(textField);

        JLabel label4 = new JLabel("ENTER THE REFRENCE NUMBER:");
        label4.setBounds(30,280,400,35);
        label4.setForeground(Color.WHITE);
        label4.setFont(new Font("System",Font.BOLD,18));
        add(label4);

        textField1 = new JTextField();
        textField1.setBackground(Color.BLACK);
        textField1.setForeground(Color.WHITE);
        textField1.setCaretColor(Color.WHITE);
        textField1.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        textField1.setBounds(30,320,380,35);
        textField1.setFont(new Font("Raleway",Font.BOLD,25));
        add(textField1);

        b1 = new JButton("Pay");
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
    public void actionPerformed(ActionEvent e){
            if (e.getSource() == b1) {
                try {
                    String company = textField.getText().trim();
                    String reference = textField1.getText().trim();

                    if (company.equals("") || reference.equals("")) {
                        JOptionPane.showMessageDialog(this, "Please Fill Both Company Name and Reference Number.");
                        return;
                    }
                    if (!reference.matches("\\d+")) {
                        JOptionPane.showMessageDialog(this, "Reference Number Must Contain Only Digits.");
                        return;
                    }
                    int randomBill = (int)(Math.random() * 2000) + 1;

                    int result = JOptionPane.showConfirmDialog(this, "Company: " + company + "\nReference: " + reference + "\nAmount: Rs. " + randomBill + "\n\nDo You Want To Pay Bill?", "Confirm Bill Payment", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

                    if (result == JOptionPane.YES_OPTION) {
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

                        if (balance < randomBill) {
                            JOptionPane.showMessageDialog(this, "Insufficient Balance");
                            return;
                        }

                        Date date = new Date();
                        c.statement.executeUpdate("insert into bank values('" + pin + "', '" + date + "', 'Bill Paid - " + company + "', '" + randomBill + "' )");
                        JOptionPane.showMessageDialog(this, "Rs. " + randomBill + " Paid Successfully to " + company);
                        new main_Class(pin);
                        setVisible(false);
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else if (e.getSource() == b2) {
                new main_Class(pin);
                setVisible(false);
            }
        }
    public static void main(String[] args) {
        new fastCash("");
    }
}
