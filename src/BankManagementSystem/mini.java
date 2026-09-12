package BankManagementSystem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class mini extends JFrame implements ActionListener {
    String pin;
    JButton button;
    JTable table;
    DefaultTableModel tableModel;
    JPanel p1;
    mini(String pin) {
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

        JLabel label2 = new JLabel("OOP Bank - Mini Statement");
        label2.setFont(new Font("System", Font.BOLD, 18));
        label2.setBounds(120, 10, 300, 30);
        add(label2);

        JLabel label5 = new JLabel();
        label5.setBounds(20, 90, 500, 20);
        label5.setFont(new Font("Raleway",Font.BOLD,18));
        label5.setForeground(Color.WHITE);
        add(label5);

        JLabel label4 = new JLabel();
        label4.setBounds(20, 110, 500, 20);
        label4.setFont(new Font("Raleway",Font.BOLD,15));
        label4.setForeground(Color.WHITE);
        add(label4);

        String[] columns = {"Date", "Type", "Amount"};
        tableModel = new DefaultTableModel(columns, 0);
        table = new JTable(tableModel);
        table.setFont(new Font("Raleway", Font.BOLD, 13));
        table.setBackground(Color.BLACK);
        table.setForeground(Color.WHITE);
        table.setGridColor(Color.LIGHT_GRAY);
        table.setRowHeight(22);
        table.setShowGrid(false);

        JTableHeader header = table.getTableHeader();
        header.setBackground(new Color(133, 34, 168));
        header.setForeground(Color.WHITE);
        header.setFont(new Font("Raleway", Font.BOLD, 14));

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.getViewport().setBackground(Color.BLACK);
        scrollPane.setBorder(null);
        scrollPane.setForeground(Color.WHITE);
        scrollPane.setBounds(25, 140, 405, 430);
        add(scrollPane);

        table.getColumnModel().getColumn(0).setPreferredWidth(220);
        table.getColumnModel().getColumn(1).setPreferredWidth(100);
        table.getColumnModel().getColumn(2).setPreferredWidth(110);

        try {
            conn c = new conn();
            ResultSet rs = c.statement.executeQuery("SELECT * FROM login WHERE pin = '" + pin + "'");
            if (rs.next()) {
                String acc = rs.getString("account_number");
                if (acc != null && acc.length() >= 16) {
                    label5.setText("Account Number: " + acc.substring(0, 4) + "XXXXXXXXXXXX" + acc.substring(12));
                } else {
                    label5.setText("Account Number: " + acc);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            conn c = new conn();
            int balance = 0;
            ResultSet rs = c.statement.executeQuery("SELECT * FROM bank WHERE pin = '" + pin + "'");
            while (rs.next()) {
                String date = rs.getString("date");
                String type = rs.getString("type");
                String amount = rs.getString("amount");

                tableModel.addRow(new Object[]{date, type, "Rs. " + amount});

                if (type.equalsIgnoreCase("Deposit") || type.equalsIgnoreCase("Transferred to You")) {
                    balance += Integer.parseInt(amount);
                } else {
                    balance -= Integer.parseInt(amount);
                }
            }
            label4.setText("Your Total Balance is Rs. " + balance);
        } catch (Exception e) {
            e.printStackTrace();
            label4.setText("Error loading transactions.");
        }

        button = new JButton("Exit");
        button.setBounds(330, 590, 100, 30);
        button.addActionListener(this);
        button.setBackground(new Color(133, 34, 168));
        button.setForeground(Color.WHITE);
        add(button);

        setTitle("Statement");
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
        setVisible(false);
        new main_Class(pin);
    }

    public static void main(String[] args) {
        new mini("");
    }
}
