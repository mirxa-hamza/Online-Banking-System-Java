package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Signup2 extends JFrame implements ActionListener {
    String formno;

    JComboBox comboBox,comboBox2,comboBox3,comboBox4,comboBox5;
    JTextField textCNIC;
    JRadioButton r1,r2,e1,e2;
    JButton b1,b2;
    JPanel p1;
    Signup2(String formno){
        super("Application Form");
        this.formno = formno;

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

        JLabel l1 = new JLabel("Page 2");
        l1.setFont(new Font("Raleway",Font.BOLD,18));
        l1.setForeground(Color.WHITE);
        l1.setBounds(40,125,200,40);
        add(l1);

        JLabel l11 = new JLabel( "Form No :");
        l11.setFont(new Font("Raleway",Font.BOLD,21));
        l11.setBounds(150,65,200,30);
        l11.setForeground(Color.WHITE);
        add(l11);

        JLabel l12 = new JLabel( formno);
        l12.setFont(new Font("Raleway",Font.BOLD,21));
        l12.setBounds(250,65,100,30);
        l12.setForeground(Color.WHITE);
        add(l12);

        JLabel l2 = new JLabel("Additional Details");
        l2.setFont(new Font("Raleway",Font.BOLD,22));
        l2.setBounds(140,90,600,40);
        l2.setForeground(Color.WHITE);
        add(l2);

        JLabel l3 = new JLabel("Religion :");
        l3.setFont(new Font("Raleway",Font.BOLD,15));
        l3.setForeground(Color.WHITE);
        l3.setBounds(40,170,80,30);
        add(l3);

        String religion[] = {"Muslim","Hindu","Christian","Other"};
        comboBox = new JComboBox(religion);
        comboBox.setForeground(Color.WHITE);
        comboBox.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        comboBox.setBackground(Color.BLACK);
        comboBox.setFont(new Font("Raleway",Font.BOLD,15));
        comboBox.setBounds(170,172,270,30);
        add(comboBox);

        JLabel l4 = new JLabel("Category :");
        l4.setFont(new Font("Raleway",Font.BOLD,15));
        l4.setBounds(40,210,80,30);
        l4.setForeground(Color.WHITE);
        add(l4);

        String category[]={"General","OBC","SC","Other"};
        comboBox2 = new JComboBox(category);
        comboBox2.setFont(new Font("Raleway",Font.BOLD,15));
        comboBox2.setForeground(Color.WHITE);
        comboBox2.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        comboBox2.setBackground(Color.BLACK);
        comboBox2.setBounds(170,212,270,30);
        add(comboBox2);

        JLabel l5 = new JLabel("Income :");
        l5.setFont(new Font("Raleway",Font.BOLD,15));
        l5.setBounds(40,250,100,30);
        l5.setForeground(Color.WHITE);
        add(l5);

        String income[] ={"Null","<50,000","<250,000","<500,000","<1,000,000",">1,000,000"};
        comboBox3 = new JComboBox(income);
        comboBox3.setFont(new Font("Raleway",Font.BOLD,15));
        comboBox3.setForeground(Color.WHITE);
        comboBox3.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        comboBox3.setBackground(Color.BLACK);
        comboBox3.setBounds(170,252,270,30);
        add(comboBox3);

        JLabel l6 = new JLabel("Education :");
        l6.setFont(new Font("Raleway",Font.BOLD,15));
        l6.setBounds(40,290,100,30);
        l6.setForeground(Color.WHITE);
        add(l6);

        String education[] ={"Under-Graduate","Graduate","Post-Graduate","Doctrate","Others"};
        comboBox4 = new JComboBox(education);
        comboBox4.setFont(new Font("Raleway",Font.BOLD,15));
        comboBox4.setForeground(Color.WHITE);
        comboBox4.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        comboBox4.setBackground(Color.BLACK);
        comboBox4.setBounds(170,292,270,30);
        add(comboBox4);

        JLabel l7 = new JLabel("Occupation :");
        l7.setFont(new Font("Raleway",Font.BOLD,15));
        l7.setBounds(40,330,100,30);
        l7.setForeground(Color.WHITE);
        add(l7);

        String occupation[] ={"Job","Self-Employed","Business","Student","Retired","Other"};
        comboBox5 = new JComboBox(occupation);
        comboBox5.setFont(new Font("Raleway",Font.BOLD,15));
        comboBox5.setForeground(Color.WHITE);
        comboBox5.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        comboBox5.setBackground(Color.BLACK);
        comboBox5.setBounds(170,332,270,30);
        add(comboBox5);

        JLabel l8 = new JLabel("CNIC :");
        l8.setFont(new Font("Raleway",Font.BOLD,15));
        l8.setBounds(40,370,150,30);
        l8.setForeground(Color.WHITE);
        add(l8);

        textCNIC = new JTextField();
        textCNIC.setFont(new Font("Raleway",Font.BOLD,15));
        textCNIC.setForeground(Color.WHITE);
        textCNIC.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        textCNIC.setBackground(Color.BLACK);
        textCNIC.setCaretColor(Color.WHITE);
        textCNIC.setBounds(170,372,270,30);
        add(textCNIC);

        JLabel l9 = new JLabel( "Senior Citizen :");
        l9.setFont(new Font("Raleway",Font.BOLD,15));
        l9.setBounds(40,410,120,30);
        l9.setForeground(Color.WHITE);
        add(l9);

        r1 = new JRadioButton("Yes");
        r1.setFont(new Font("Raleway",Font.BOLD,15));
        r1.setBackground(Color.BLACK);
        r1.setForeground(Color.WHITE);
        r1.setBounds(190,412,100,30);

        add(r1);

        r2 = new JRadioButton("No");
        r2.setFont(new Font("Raleway",Font.BOLD,15));
        r2.setBackground(Color.BLACK);
        r2.setForeground(Color.WHITE);
        r2.setBounds(300,412,100,30);
        add(r2);
        ButtonGroup buttonGroup1 =  new ButtonGroup();
        buttonGroup1.add(r1);
        buttonGroup1.add(r2);

        JLabel l10 = new JLabel( "Existing Account :");
        l10.setFont(new Font("Raleway",Font.BOLD,15));
        l10.setBounds(40,450,180,30);
        l10.setForeground(Color.WHITE);
        add(l10);

        e1 = new JRadioButton("Yes");
        e1.setFont(new Font("Raleway",Font.BOLD,15));
        e1.setBackground(Color.BLACK);
        e1.setForeground(Color.WHITE);
        e1.setBounds(190,452,100,30);
        add(e1);

        e2 = new JRadioButton("No");
        e2.setFont(new Font("Raleway",Font.BOLD,15));
        e2.setBackground(Color.BLACK);
        e2.setForeground(Color.WHITE);
        e2.setBounds(300,452,100,30);
        add(e2);

        ButtonGroup buttonGroup2 =  new ButtonGroup();
        buttonGroup2.add(e1);
        buttonGroup2.add(e2);

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
        String rel = (String) comboBox.getSelectedItem();
        String cate = (String) comboBox2.getSelectedItem();
        String inc = (String) comboBox3.getSelectedItem();
        String edu = (String) comboBox4.getSelectedItem();
        String occ = (String) comboBox5.getSelectedItem();
        String cnic = textCNIC.getText();
        String scitizen = null;
        if(r1.isSelected()){
            scitizen = "Yes";
        }else if(r2.isSelected()){
            scitizen = "No";
        }
        String e_account = null;
        if(e1.isSelected()){
            e_account = "Yes";
        }else if(e2.isSelected()){
            e_account = "No";
        }
        try{
            if(e.getSource()==b1){
            if(textCNIC.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Fill All The Feilds");
            }else if(cnic.length()!=13){
                JOptionPane.showMessageDialog(null,"Enter The Correct CNIC And Try Again");
            }
            else{
                conn c1 = new conn();
                String q = "insert into signup2 values('"+formno+"','"+rel+"','"+cate+"','"+inc+"','"+edu+"','"+occ+"','"+cnic+"','"+scitizen+"','"+e_account+"')";
                c1.statement.executeUpdate(q);
                new Signup3(formno);
                setVisible(false);
            }
        } else if (e.getSource()==b2) {
                new Login();
                setVisible(false);
            }
        } catch (Exception E) {
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Signup2("");
    }
}
