package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class update extends JFrame implements ActionListener {
    JTextField textField, nameField, emailField, addressField, pinField;
    JButton b1, b2,b3;
    String accountNumber;
    JPanel p1;

    update() {
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

        JLabel heading = new JLabel("UPDATE USER INFORMATION");
        heading.setBounds(60,60,400,40);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Raleway",Font.BOLD,25));
        add(heading);

        JLabel label2 = new JLabel("Account Number: ");
        label2.setBounds(40,150,200,35);
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("Raleway",Font.BOLD,15));
        add(label2);

        textField = new JTextField(15);
        textField.setBounds(175,154,250,25);
        textField.setBackground(Color.BLACK);
        textField.setForeground(Color.WHITE);
        textField.setCaretColor(Color.WHITE);
        textField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        textField.setFont(new Font("Raleway", Font.BOLD,15));
        add(textField);

        b3 = new JButton("Load");
        b3.setBounds(345, 190, 80, 25);
        b3.addActionListener(this);
        b3.setBackground(new Color(133, 34, 168));
        b3.setForeground(Color.WHITE);
        add(b3);

        JLabel label3 = new JLabel("Name:");
        label3.setBounds(40,220,200,35);
        label3.setForeground(Color.WHITE);
        label3.setFont(new Font("Raleway",Font.BOLD,15));
        add(label3);

        nameField = new JTextField();
        nameField.setBounds(175,227,250,25);
        nameField.setBackground(Color.BLACK);
        nameField.setForeground(Color.WHITE);
        nameField.setCaretColor(Color.WHITE);
        nameField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        nameField.setFont(new Font("Raleway", Font.BOLD,15));
        add(nameField);

        JLabel label4 = new JLabel("Email:");
        label4.setBounds(40,260,200,35);
        label4.setForeground(Color.WHITE);
        label4.setFont(new Font("Raleway",Font.BOLD,15));
        add(label4);

        emailField = new JTextField();
        emailField.setBounds(175,267,250,25);
        emailField.setBackground(Color.BLACK);
        emailField.setForeground(Color.WHITE);
        emailField.setCaretColor(Color.WHITE);
        emailField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        emailField.setFont(new Font("Raleway", Font.BOLD,15));
        add(emailField);

        JLabel label5 = new JLabel("Address");
        label5.setBounds(40,305,200,35);
        label5.setForeground(Color.WHITE);
        label5.setFont(new Font("Raleway",Font.BOLD,15));
        add(label5);

        addressField = new JTextField();
        addressField.setBounds(175,312,250,25);
        addressField.setBackground(Color.BLACK);
        addressField.setForeground(Color.WHITE);
        addressField.setCaretColor(Color.WHITE);
        addressField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        addressField.setFont(new Font("Raleway", Font.BOLD,15));
        add(addressField);

        JLabel label6 = new JLabel("PIN");
        label6.setBounds(40,350,200,35);
        label6.setForeground(Color.WHITE);
        label6.setFont(new Font("Raleway",Font.BOLD,15));
        add(label6);

        pinField = new JTextField();
        pinField.setBounds(175,357,250,25);
        pinField.setBackground(Color.BLACK);
        pinField.setForeground(Color.WHITE);
        pinField.setCaretColor(Color.WHITE);
        pinField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        pinField.setFont(new Font("Raleway", Font.BOLD,15));
        add(pinField);

        b1 = new JButton("UPDATE ACCOUNT");
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

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b3) {
            try {
                conn c = new conn();
                accountNumber = textField.getText();
                ResultSet rs = c.statement.executeQuery("SELECT * FROM signup WHERE form_no = (SELECT form_no FROM signup3 WHERE account_number = '" + accountNumber + "')");
                if (rs.next()) {
                    nameField.setText(rs.getString("name"));
                    emailField.setText(rs.getString("email"));
                    addressField.setText(rs.getString("address"));
                }else{
                    JOptionPane.showMessageDialog(null,"Account Not Found! PLease Enter The Correct Account Number");
                }
                ResultSet rs2 = c.statement.executeQuery("SELECT * FROM signup3 WHERE account_number = '" + accountNumber + "'");
                if (rs2.next()) {
                    pinField.setText(rs2.getString("pin"));
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        if (e.getSource() == b1) {
            try {
                int confirm = JOptionPane.showConfirmDialog(
                        this,"Are You Sure You Want To Delete This Account?\nThis Action Cannot Be Undone!", "Confirm Deletion", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE
                );
                if (confirm == JOptionPane.YES_OPTION) {
                    conn c = new conn();
                    String name = nameField.getText();
                    String email = emailField.getText();
                    String address = addressField.getText();
                    String pin = pinField.getText();

                    String q1 = "UPDATE signup SET name = '" + name + "', email = '" + email + "', address = '" + address + "' WHERE form_no = (SELECT form_no FROM signup3 WHERE account_number = '" + accountNumber + "')";
                    c.statement.executeUpdate(q1);

                    String q2 = "UPDATE signup3 SET pin = '" + pin + "' WHERE account_number = '" + accountNumber + "'";
                    c.statement.executeUpdate(q2);

                    String q3 = "UPDATE login SET pin = '" + pin + "' WHERE account_number = '" + accountNumber + "'";
                    c.statement.executeUpdate(q3);

                    JOptionPane.showMessageDialog(null, "User Information Updated Successfully!");
                    new admin();
                    setVisible(false);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }else if(e.getSource()==b2){
            new admin();
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new update();
    }
}
