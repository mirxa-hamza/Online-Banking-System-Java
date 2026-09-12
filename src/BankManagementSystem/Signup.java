package BankManagementSystem;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Signup extends JFrame implements ActionListener {
    JRadioButton rMale,rFemale,rMarried,rUnMarried;

    JTextField textName,textFName,textEmail,textMs,textAddress,textCity,textState;

    JPasswordField textpassword;
    JPanel p1;
    JButton b1,b2;

    JDateChooser dateChooser;
    Random rand = new Random();
    long first4 = (rand.nextLong()%900L)+1000L;
    String first = " "+Math.abs(first4);


    Signup(){
        super("Application Form");
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

        JLabel label4 = new JLabel("APPLICATION FORM NO:"+first);
        label4.setBounds(60,60,400,40);
        label4.setForeground(Color.WHITE);
        label4.setFont(new Font("Raleway",Font.BOLD,25));
        add(label4);

        JLabel label3 = new JLabel("Personal Information");
        label3.setFont(new Font("Raleay",Font.BOLD,22));
        label3.setForeground(Color.WHITE);
        label3.setBounds(125,95,300,30);
        add(label3);

        JLabel labelName = new JLabel("Name :");
        labelName.setFont(new Font("Raleway",Font.BOLD,15));
        labelName.setForeground(Color.WHITE);
        labelName.setBounds(40,150,80,30);
        add(labelName);

        textName = new JTextField();
        textName.setFont(new Font("Raleway",Font.BOLD,15));
        textName.setBackground(Color.BLACK);
        textName.setForeground(Color.WHITE);
        textName.setCaretColor(Color.WHITE);
        textName.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        textName.setBounds(160,152,270,30);
        add(textName);

        JLabel labelFName = new JLabel("Father Name :");
        labelFName.setFont(new Font("Raleway",Font.BOLD,15));
        labelFName.setForeground(Color.WHITE);
        labelFName.setBounds(40,190,180,30);
        add(labelFName);

        textFName = new JTextField();
        textFName.setFont(new Font("Raleway",Font.BOLD,15));
        textFName.setBackground(Color.BLACK);
        textFName.setForeground(Color.WHITE);
        textFName.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        textFName.setCaretColor(Color.WHITE);
        textFName.setBounds(160,192,270,30);
        add(textFName);

        JLabel labelG = new JLabel("Gender :");
        labelG.setFont(new Font("Raleway",Font.BOLD,15));
        labelG.setForeground(Color.WHITE);
        labelG.setBounds(40,230,180,30);
        add(labelG);

        rMale = new JRadioButton("Male");
        rMale.setFont(new Font("Raleway",Font.BOLD,15));
        rMale.setBounds(170,232,60,30);
        rMale.setBackground(Color.BLACK);
        rMale.setForeground(Color.WHITE);
        add(rMale);

        rFemale = new JRadioButton("Female");
        rFemale.setFont(new Font("Raleway",Font.BOLD,15));
        rFemale.setBounds(280,232,90,30);
        rFemale.setBackground(Color.BLACK);
        rFemale.setForeground(Color.WHITE);
        add(rFemale);

        JLabel DOB = new JLabel("Date Of Birth :");
        DOB.setFont(new Font("Raleway",Font.BOLD,15));
        DOB.setForeground(Color.WHITE);
        DOB.setBounds(40,270,180,30);
        add(DOB);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(160, 272, 270, 30);
        dateChooser.setFont(new Font("Raleway", Font.BOLD, 15));
        dateChooser.setDateFormatString("dd-MM-yyyy");
        add(dateChooser);

        JTextField dateField = ((JTextField) dateChooser.getDateEditor().getUiComponent());
        dateField.setForeground(Color.WHITE);
        dateField.setCaretColor(Color.WHITE);
        dateField.setFont(new Font("Raleway", Font.BOLD, 15));
        dateField.setOpaque(true);
        dateField.setBorder(BorderFactory.createLineBorder(Color.GRAY));


        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(rMale);
        buttonGroup.add(rFemale);

        JLabel labelEmail = new JLabel("Email Address :");
        labelEmail.setFont(new Font("Raleway",Font.BOLD,15));
        labelEmail.setForeground(Color.WHITE);
        labelEmail.setBounds(40,310,180,30);
        add(labelEmail);

        textEmail = new JTextField();
        textEmail.setFont(new Font("Raleway",Font.BOLD,15));
        textEmail.setBackground(Color.BLACK);
        textEmail.setForeground(Color.WHITE);
        textEmail.setCaretColor(Color.WHITE);
        textEmail.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        textEmail.setBounds(160,312,270,30);
        add(textEmail);

        JLabel labelMs = new JLabel("Martial Status :");
        labelMs.setFont(new Font("Raleway",Font.BOLD,15));
        labelMs.setBounds(40,350,200,30);
        labelMs.setForeground(Color.WHITE);
        add(labelMs);

        rMarried = new JRadioButton("Married");
        rMarried.setFont(new Font("Raleway",Font.BOLD,15));
        rMarried.setBounds(170,352,100,30);
        rMarried.setBackground(Color.BLACK);
        rMarried.setForeground(Color.WHITE);
        add(rMarried);

        rUnMarried = new JRadioButton("Un-Married");
        rUnMarried.setFont(new Font("Raleway",Font.BOLD,15));
        rUnMarried.setBounds(280,352,120,30);
        rUnMarried.setBackground(Color.BLACK);
        rUnMarried.setForeground(Color.WHITE);
        add(rUnMarried);

        ButtonGroup buttonGroup1 =  new ButtonGroup();
        buttonGroup1.add(rMarried);
        buttonGroup1.add(rUnMarried);

        JLabel labelAddress = new JLabel("Address :");
        labelAddress.setFont(new Font("Raleway",Font.BOLD,15));
        labelAddress.setBounds(40,390,180,30);
        labelAddress.setForeground(Color.WHITE);
        add(labelAddress);

        textAddress = new JTextField();
        textAddress.setFont(new Font("Raleway",Font.BOLD,15));
        textAddress.setBackground(Color.BLACK);
        textAddress.setForeground(Color.WHITE);
        textAddress.setCaretColor(Color.WHITE);
        textAddress.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        textAddress.setBounds(160,392,270,30);
        add(textAddress);

        JLabel labelCity = new JLabel("City :");
        labelCity.setFont(new Font("Raleway",Font.BOLD,15));
        labelCity.setBounds(40,430,180,30);
        labelCity.setForeground(Color.WHITE);
        add(labelCity);

        textCity = new JTextField();
        textCity.setFont(new Font("Raleway",Font.BOLD,15));
        textCity.setCaretColor(Color.WHITE);
        textCity.setBackground(Color.BLACK);
        textCity.setForeground(Color.WHITE);
        textCity.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        textCity.setBounds(160,432,270,30);
        add(textCity);

        JLabel labelState = new JLabel("State :");
        labelState.setFont(new Font("Raleway",Font.BOLD,15));
        labelState.setBounds(40,470,180,30);
        labelState.setForeground(Color.WHITE);
        add(labelState);

        textState = new JTextField();
        textState.setFont(new Font("Raleway",Font.BOLD,14));
        textState.setBackground(Color.BLACK);
        textState.setCaretColor(Color.WHITE);
        textState.setForeground(Color.WHITE);
        textState.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        textState.setBounds(160,472,270,30);
        add(textState);

        JLabel labelPassword = new JLabel("Password :");
        labelPassword.setFont(new Font("Raleway",Font.BOLD,15));
        labelPassword.setBounds(40,510,180,30);
        labelPassword.setForeground(Color.WHITE);
        add(labelPassword);

        textpassword = new JPasswordField();
        textpassword.setFont(new Font("Raleway",Font.BOLD,14));
        textpassword.setBackground(Color.BLACK);
        textpassword.setForeground(Color.WHITE);
        textpassword.setCaretColor(Color.WHITE);
        textpassword.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        textpassword.setBounds(160,512,270,30);
        add(textpassword);

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
        String formno  = first;
        String name = textName.getText();
        String fname = textFName.getText();
        String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(rMale.isSelected()){
            gender="Male";
        }else if(rFemale.isSelected()){
            gender = "Female";
        }
        String email = textEmail.getText();
        String martial = null;
        if(rMarried.isSelected()){
            martial = "Married";
        } else if ((rUnMarried.isSelected())) {
            martial = "Unmarried";
        }
        String state = textState.getText();
        String address = textAddress.getText();
        String city = textCity.getText();
        String password = textpassword.getText();
        try{
            if(e.getSource()==b1){
            if(textName.getText().equals("")||textFName.getText().equals("")||textState.getText().equals("")||textCity.getText().equals("")||textAddress.getText().equals("")||textEmail.getText().equals("")||textpassword.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Fill All The Fields");
            } else if (!email.contains("@")&&!email.contains(".com")) {
                JOptionPane.showMessageDialog(null,"Please Enter Correct Email");
            } else{
                conn conn1 = new conn();
                String q = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+martial+"','"+address+"','"+city+"','"+state+"','"+password+"')";
                conn1.statement.executeUpdate(q);
                new Signup2(first);
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
        new Signup();
    }
}
