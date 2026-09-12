package BankManagementSystem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class delete extends JFrame implements ActionListener {
    JButton b1,b2;
    JTextField textField;
    JPanel p1;
    delete(){
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

        JLabel label = new JLabel("Delete Account");
        label.setBounds(130,130,400,35);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("System",Font.BOLD,28));
        add(label);

            JLabel label2 = new JLabel("ENTER THE ACCOUNT NUMBER:");
            label2.setBounds(30,220,400,35);
            label2.setForeground(Color.WHITE);
            label2.setFont(new Font("System",Font.BOLD,18));
            add(label2);

            textField = new JTextField();
            textField.setBackground(Color.BLACK);
            textField.setForeground(Color.WHITE);
            textField.setBounds(30,260,380,35);
            textField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            textField.setFont(new Font("Raleway",Font.BOLD,28));
            add(textField);

            b1 = new JButton("DELETE ACCOUNT");
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
        if (e.getSource() == b1) {
            String acc = textField.getText();
            if (acc != null && !acc.isEmpty()) {
                try {
                    conn c = new conn();
                    ResultSet rs = c.statement.executeQuery("SELECT form_no FROM signup3 WHERE account_number = '" + acc + "'");
                    if (rs.next()) {
                        int confirm = JOptionPane.showConfirmDialog(
                                this,"Are You Sure You Want To Delete This Account?\nThis Action Cannot Be Undone!", "Confirm Deletion", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE
                        );
                        if (confirm == JOptionPane.YES_OPTION) {
                            String formNo = rs.getString("form_no");
                            c.statement.executeUpdate("DELETE FROM bank WHERE pin IN (SELECT pin FROM signup3 WHERE account_number = '" + acc + "')");
                            c.statement.executeUpdate("DELETE FROM login WHERE account_number = '" + acc + "'");
                            c.statement.executeUpdate("DELETE FROM signup3 WHERE account_number = '" + acc + "'");
                            c.statement.executeUpdate("DELETE FROM signup2 WHERE form_no = '" + formNo + "'");
                            c.statement.executeUpdate("DELETE FROM signup WHERE form_no = '" + formNo + "'");
                            JOptionPane.showMessageDialog(this, "Account Deleted Successfully.");
                            new admin();
                            setVisible(false);
                        } else {
                            JOptionPane.showMessageDialog(this, "Account Deletion Cancelled.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Account Not Found");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please Enter Account Number");
            }
        } else if (e.getSource()==b2) {
            new admin();
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new delete();
    }
}
