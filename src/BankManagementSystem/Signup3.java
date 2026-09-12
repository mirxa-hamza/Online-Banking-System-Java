package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Signup3 extends JFrame implements ActionListener {
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6;
    JButton b1,b2;
    String form_no;
    JPanel p1;
    Signup3(String form_no){
        super("Application Form");
        this.form_no = form_no;

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

        JLabel l14 = new JLabel( "Form No :");
        l14.setFont(new Font("Raleway",Font.BOLD,21));
        l14.setBounds(150,65,200,30);
        l14.setForeground(Color.WHITE);
        add(l14);

        JLabel l15 = new JLabel( form_no);
        l15.setFont(new Font("Raleway",Font.BOLD,21));
        l15.setBounds(250,65,100,30);
        l15.setForeground(Color.WHITE);
        add(l15);

        JLabel l1 = new JLabel("Page 3");
        l1.setFont(new Font("Raleway",Font.BOLD,18));
        l1.setForeground(Color.WHITE);
        l1.setBounds(40,125,200,40);
        add(l1);

        JLabel l2 = new JLabel("Account Details");
        l2.setFont(new Font("Raleway",Font.BOLD,22));
        l2.setBounds(150,90,600,40);
        l2.setForeground(Color.WHITE);
        add(l2);

        JLabel l3 = new JLabel("Account Type :");
        l3.setFont(new Font("Raleway",Font.BOLD,17));
        l3.setBounds(40,160,200,30);
        l3.setForeground(Color.WHITE);
        add(l3);

        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway",Font.BOLD,15));
        r1.setBounds(80,195,150,30);
        r1.setBackground(Color.BLACK);
        r1.setForeground(Color.WHITE);
        add(r1);

        r2 = new JRadioButton("Investment Account");
        r2.setFont(new Font("Raleway",Font.BOLD,15));
        r2.setBounds(250,195,190,30);
        r2.setBackground(Color.BLACK);
        r2.setForeground(Color.WHITE);
        add(r2);

        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway",Font.BOLD,15));
        r3.setBounds(80,235,150,30);
        r3.setBackground(Color.BLACK);
        r3.setForeground(Color.WHITE);
        add(r3);

        r4 = new JRadioButton("Other Account");
        r4.setFont(new Font("Raleway",Font.BOLD,15));
        r4.setBounds(250,235,350,30);
        r4.setBackground(Color.BLACK);
        r4.setForeground(Color.WHITE);
        add(r4);

        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(r1);
        buttonGroup1.add(r2);
        buttonGroup1.add(r3);
        buttonGroup1.add(r4);

        JLabel l4 = new JLabel("Account Number :");
        l4.setFont(new Font("Raleway",Font.BOLD,17));
        l4.setBounds(40,275,200,30);
        l4.setForeground(Color.WHITE);
        l4.setBackground(Color.BLACK);
        add(l4);

        JLabel l6 = new JLabel("XXX-XXXX-XXXX-4841");
        l6.setFont(new Font("Raleway",Font.BOLD,17));
        l6.setBounds(210,280,200,20);
        l6.setForeground(Color.WHITE);
        l6.setBackground(Color.BLACK);
        add(l6);

        JLabel l5 = new JLabel("(Your 16-Digit Account Number)");
        l5.setFont(new Font("Raleway",Font.BOLD,12));
        l5.setBounds(210,301,200,20);
        l5.setForeground(Color.WHITE);
        l5.setBackground(Color.BLACK);
        add(l5);

        JLabel l8 = new JLabel("Password :");
        l8.setFont(new Font("Raleway",Font.BOLD,17));
        l8.setBounds(40,335,200,20);
        l8.setForeground(Color.WHITE);
        l8.setBackground(Color.BLACK);
        add(l8);

        JLabel l9 = new JLabel("XXXX");
        l9.setFont(new Font("Raleway",Font.BOLD,18));
        l9.setBounds(210,337,200,20);
        l9.setForeground(Color.WHITE);
        l9.setBackground(Color.BLACK);
        add(l9);

        JLabel l10= new JLabel("(4-Digit Password)");
        l10.setFont(new Font("Raleway",Font.BOLD,12));
        l10.setBounds(210,356,200,20);
        l10.setForeground(Color.WHITE);
        l10.setBackground(Color.BLACK);
        add(l10);

        JLabel l11 = new JLabel("Service Required :");
        l11.setFont(new Font("Raleway",Font.BOLD,17));
        l11.setBounds(40,390,200,20);
        l11.setForeground(Color.WHITE);
        l11.setBackground(Color.BLACK);
        add(l11);

        c1 = new JCheckBox("ATM Card");
        c1.setFont(new Font("Raleway",Font.BOLD,15));
        c1.setBounds(80,425,150,30);
        c1.setForeground(Color.WHITE);
        c1.setBackground(Color.BLACK);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setFont(new Font("Raleway",Font.BOLD,15));
        c2.setBounds(250,425,200,30);
        c2.setForeground(Color.WHITE);
        c2.setBackground(Color.BLACK);
        add(c2);

        c5 = new JCheckBox("Cheque Book");
        c5.setFont(new Font("Raleway",Font.BOLD,15));
        c5.setBounds(80,465,150,30);
        c5.setForeground(Color.WHITE);
        c5.setBackground(Color.BLACK);
        add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setFont(new Font("Raleway",Font.BOLD,15));
        c6.setBounds(250,465,200,30);
        c6.setForeground(Color.WHITE);
        c6.setBackground(Color.BLACK);
        add(c6);

        JCheckBox c7 = new JCheckBox("I Here By Decleares That The Above Entered Details \nCorrect To The Best Of My Knowledge.");
        c7.setFont(new Font("Raleway",Font.BOLD,9));
        c7.setBounds(30,510,600,30);
        c7.setForeground(Color.WHITE);
        c7.setBackground(Color.BLACK);
        c7.doClick();
        add(c7);

        b1 = new JButton("Next");
        b1.setForeground(Color.WHITE);
        b1.setBackground(new Color(133, 34, 168));
        b1.setFont(new Font("System",Font.BOLD,13));
        b1.addActionListener(this);
        b1.setBounds(280,560,150,35);
        add(b1);

        b2 = new JButton("Cancel");
        b2.setForeground(Color.WHITE);
        b2.setBackground(new Color(255, 183, 1));
        b2.addActionListener(this);
        b2.setFont(new Font("System",Font.BOLD,13));
        b2.setBounds(280,605,150,35);
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
        String aType = null;
        if(r1.isSelected()){
            aType = "Saving Account";
        }else if(r2.isSelected()){
            aType = "Fixed Deposit Account";
        }else if(r3.isSelected()){
            aType = "Current Account";
        }else if(r4.isSelected()){
            aType = "Recurring Deposit Account";
        }

        Random ran = new Random();
        long first7 = (ran.nextLong()%90000000L) + 14099633000000000L;
        String accNo = "" +Math.abs(first7);

        long first3 = (ran.nextLong()% 9000L)+1000L;
        String pin = ""+Math.abs(first3);

        String fac = "";
        if(c1.isSelected()){
            fac += "ATM Card";
        }else if(c2.isSelected()){
            fac += "Internet Banking";
        }else if(c5.isSelected()){
            fac += "Cheque Book";
        }else if(c6.isSelected()){
            fac += "E-Statment";
        }
        try{
            if(e.getSource()==b1){
                if(aType.equals("")) {
                    JOptionPane.showMessageDialog(null, "Fill All The Feilds");
                }
                else {
                    conn c1 = new conn();
                    String q1 = "insert into signup3 values('"+form_no+"','"+aType+"','"+accNo+"','"+pin+"','"+fac+"')";
                    String q2 = "insert into login values('"+form_no+"','"+accNo+"','"+pin+"')";
                    c1.statement.executeUpdate(q1);
                    c1.statement.executeUpdate(q2);
                    JOptionPane.showMessageDialog(null,"Account Number : "+accNo+"\nPin : "+pin);
                    new Login();
                    setVisible(false);
                }
            } else if (e.getSource()== b2) {
                new Login();
                setVisible(false);
            }
        } catch (Exception E) {
            E.printStackTrace();
        }
        }

    public static void main(String[] args) {
        new Signup3("");
    }
}
