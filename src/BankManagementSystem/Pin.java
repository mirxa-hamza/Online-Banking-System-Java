package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pin extends JFrame implements ActionListener {
    JButton b1,b2;
    String pin;
    JPanel p1;
    JTextField textField,textField1,textField2;
    Pin(String pin){
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

        JLabel label = new JLabel("Pin Change");
        label.setBounds(140,130,400,35);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("System",Font.BOLD,28));
        add(label);

        JLabel label1 = new JLabel("ENTER THE OlD PIN NUMBER:");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("System",Font.BOLD,18));
        label1.setBounds(30,200,400,35);
        add(label1);

        textField = new JTextField();
        textField.setBackground(Color.BLACK);
        textField.setCaretColor(Color.WHITE);
        textField.setForeground(Color.WHITE);
        textField.setBounds(30,240,380,35);
        textField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        textField.setFont(new Font("Raleway",Font.BOLD,25));
        add(textField);

        JLabel label4 = new JLabel("ENTER THE NEW PIN NUMBER:");
        label4.setBounds(30,280,400,35);
        label4.setForeground(Color.WHITE);
        label4.setFont(new Font("System",Font.BOLD,18));
        add(label4);

        textField1 = new JTextField();
        textField1.setBackground(Color.BLACK);
        textField1.setCaretColor(Color.WHITE);
        textField1.setForeground(Color.WHITE);
        textField1.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        textField1.setBounds(30,320,380,35);
        textField1.setFont(new Font("Raleway",Font.BOLD,25));
        add(textField1);

        JLabel label5 = new JLabel("RE_ENTER THE NEW PIN NUMBER:");
        label5.setBounds(30,360,400,35);
        label5.setForeground(Color.WHITE);
        label5.setFont(new Font("System",Font.BOLD,18));
        add(label5);

        textField2 = new JTextField();
        textField2.setBackground(Color.BLACK);
        textField2.setForeground(Color.WHITE);
        textField2.setCaretColor(Color.WHITE);
        textField2.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        textField2.setBounds(30,400,380,35);
        textField2.setFont(new Font("Raleway",Font.BOLD,25));
        add(textField2);

        b1 = new JButton("Change PIN");
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
            String Opin = textField.getText();
            String pin1 = textField1.getText();
            String pin2 = textField2.getText();
            if(e.getSource()==b1){
                if(!Opin.equals(pin)){
                    JOptionPane.showMessageDialog(null,"Entered Wrong Old Pin Number");
                    return;
                }
                else if(!pin1.equals(pin2)){
                    JOptionPane.showMessageDialog(null,"Entered Pin Does Not Match");
                    return;
                }
                else if(textField1.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Enter New Pin");
                    return;
                }
                if(textField2.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Re-Enter New Pin");
                    return;
                }
                int result = JOptionPane.showConfirmDialog(this, "Do You Want To Change Your Account Pin", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
                if (result == JOptionPane.YES_OPTION){
                conn c = new conn();
                String q1 = "update bank set pin = '"+pin1+"' where pin = '"+pin+"'";
                String q2 = "update login set pin = '"+pin1+"' where pin = '"+pin+"'";
                String q3 = "update signup3 set pin = '"+pin1+"' where pin = '"+pin+"'";

                c.statement.executeUpdate(q1);
                c.statement.executeUpdate(q2);
                c.statement.executeUpdate(q3);

                JOptionPane.showMessageDialog(null,"Pin Changed Successfully");
                JOptionPane.showMessageDialog(null,"Please Login Again");
                new Login();
                setVisible(false);}
            } else if (e.getSource()==b2) {
                new main_Class(pin);
                setVisible(false);
            }
        }catch (Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Pin("");
    }
}
