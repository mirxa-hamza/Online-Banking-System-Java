package BankManagementSystem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class showInfo extends JFrame implements ActionListener {
        JButton b1;
        JPanel p1;
    showInfo(){

        setLayout(new BorderLayout());

        p1 = new JPanel();
        p1.setBackground(new Color(133, 34, 168));
        p1.setBounds(0,0,1200,55);
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

        JLabel label4 = new JLabel("ALL ACCOUNTS INFORMATION");
        label4.setBounds(390,70,500,55);
        label4.setForeground(Color.WHITE);
        label4.setFont(new Font("System",Font.BOLD,28));
        add(label4);

        String[] columns = {"Form No", "Name", "Father Name", "DOB", "Gender", "Email", "Marital Status", "Address", "City", "Account No", "PIN"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        JTable table = new JTable(model);
        table.setFont(new Font("Raleway", Font.BOLD, 13));
        table.setBackground(Color.BLACK);
        table.setForeground(Color.WHITE);
        table.setRowHeight(35);
        table.setGridColor(Color.lightGray);
        table.setShowGrid(false);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.getViewport().setBackground(Color.BLACK);
        scrollPane.setBorder(null);
        scrollPane.setForeground(Color.WHITE);
        scrollPane.setBounds(20, 140, 1160, 430);
        add(scrollPane);

        JTableHeader header = table.getTableHeader();
        header.setBackground(new Color(133, 34, 168));
        header.setForeground(Color.WHITE);
        header.setFont(new Font("Raleway", Font.BOLD, 14));

        table.getColumnModel().getColumn(0).setPreferredWidth(85);
        table.getColumnModel().getColumn(1).setPreferredWidth(140);
        table.getColumnModel().getColumn(2).setPreferredWidth(140);
        table.getColumnModel().getColumn(3).setPreferredWidth(115);
        table.getColumnModel().getColumn(4).setPreferredWidth(80);
        table.getColumnModel().getColumn(5).setPreferredWidth(210);
        table.getColumnModel().getColumn(6).setPreferredWidth(130);
        table.getColumnModel().getColumn(7).setPreferredWidth(240);
        table.getColumnModel().getColumn(8).setPreferredWidth(130);
        table.getColumnModel().getColumn(9).setPreferredWidth(170);
        table.getColumnModel().getColumn(10).setPreferredWidth(50);


        b1 = new JButton("Back");
        b1.setBounds(1070,595,100, 30);
        b1.setForeground(Color.WHITE);
        b1.setBackground(new Color(133, 34, 168));
        b1.addActionListener(this);
        add(b1);

        try {
            conn c = new conn();
            String q = "SELECT s.form_no, s.name, s.father_name, s.DOB, s.gender, s.email, s.marital_status, s.address, s.city, s.state, s3.account_number, s3.pin " + "FROM signup s " + "JOIN signup3 s3 ON s.form_no = s3.form_no";
            ResultSet rs = c.statement.executeQuery(q);
            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getString("form_no"),
                        rs.getString("name"),
                        rs.getString("father_name"),
                        rs.getString("DOB"),
                        rs.getString("gender"),
                        rs.getString("email"),
                        rs.getString("marital_status"),
                        rs.getString("address"),
                        rs.getString("city"),
                        rs.getString("account_number"),
                        rs.getString("pin")
                });
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        setLayout(null);
        setSize(1200,675);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.BLACK);
        setUndecorated(true);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            new admin();
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new showInfo();
    }
}
