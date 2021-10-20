package hotelmanagement.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class newcoustomer extends JFrame {
    JTextField t1,t2,t3,t4,t5;
    JButton b1,b2;
    JRadioButton r1,r2;
    JComboBox c1;
    Choice c;
    public newcoustomer(){
        JLabel l= new JLabel("New Costumer Form");
        l.setBounds(300,10,200,30);
        add(l);
        l.setForeground(Color.blue);
        l.setFont(new Font("Simple",Font.BOLD,20));
        setLayout(null);
        JLabel l1= new JLabel("Id");
        l1.setBounds(30,70,20,30);
        l1.setFont(new Font("Simple",Font.BOLD,20));
        add(l1);
        c1= new JComboBox(new String[]{"Paspport","Voterid","AdharCard","Pancard"});
        c1.setBounds(240,70,150,30);
        add(c1);
        JLabel l2= new JLabel("Number-");
        l2.setBounds(30,130,100,30);
        l2.setFont(new Font("Simple",Font.BOLD,20));
        add(l2);
        t1= new JTextField();
        t1.setBounds(240,130,150,30);
        add(t1);
        JLabel l3 = new JLabel("Name-");
        l3.setBounds(30,190,90,30);
        l3.setFont(new Font("Simple",Font.BOLD,20));
        add(l3);
        t2= new JTextField();
        t2.setBounds(240,190,150,30);
        add(t2);

        JLabel l4 = new JLabel("Gender-");
        l4.setBounds(30,250,90,30);
        l4.setFont(new Font("Simple",Font.BOLD,20));
        add(l4);
        r1= new JRadioButton("Male");
        r1.setBounds(240,250,60,30);
        add(r1);
        r1.setBackground(Color.white);
        r2= new JRadioButton("Female");
        r2.setBounds(340,250,70,30);
        add(r2);
        r2.setBackground(Color.white);
        JLabel l5 = new JLabel("Country-");
        l5.setBounds(30,310,90,30);
        l5.setFont(new Font("Simple",Font.BOLD,20));
        add(l5);
        t3= new JTextField();
        t3.setBounds(240,310,150,30);
        add(t3);
        t4= new JTextField();
        t4.setBounds(240,430,150,30);
        add(t4);
        t5= new JTextField();
        t5.setBounds(240,490,150,30);
add(t5);

        JLabel l6 = new JLabel("AllocatedRoom");
        l6.setBounds(30,370,170,20);
        l6.setFont(new Font("Simple",Font.BOLD,20));
        add(l6);
c= new Choice();
try {
    Connection c1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/mohit","root","Mohit*123");
//    conn c1 = new conn();
    String st="select * from room";
    Statement s= c1.createStatement();
    ResultSet rs=s.executeQuery(st);
while (rs.next()) {

    c.add(rs.getString("room"));
}

}catch (Exception e){}
c.setBounds(240,370,170,40);
add(c);
        JLabel l7 = new JLabel("Checked in");
        l7.setBounds(30,430,120,20);
        l7.setFont(new Font("Simple",Font.BOLD,20));
        add(l7);
        JLabel l8 = new JLabel("Deposit");
        l8.setBounds(30,490,90,20);
        l8.setFont(new Font("Simple",Font.BOLD,20));
        add(l8);
getContentPane().setBackground(Color.white);
b1= new JButton("Add Costumer");
b1.setBounds(130,560,150,30);
add(b1);
b2= new JButton("Cancel");
b2.setBounds(300,560,150,30);
add(b2);
b1.setBackground(Color.black);
b1.setForeground(Color.white);
b2.setBackground(Color.black);
b2.setForeground(Color.white);
ImageIcon i= new ImageIcon(ClassLoader.getSystemResource("hotelmanagement/company/image/fifth.png"));
Image i2= i.getImage().getScaledInstance(400,600,Image.SCALE_DEFAULT);
ImageIcon i3= new ImageIcon(i2);
JLabel labe= new JLabel(i3);
labe.setBounds(480,20,400,600);
add(labe);
b1.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String id=(String)c1.getSelectedItem();
        String nomber= t1.getText();
        String name=t2.getText();
        String gender=null;
        if(r1.isSelected()){
            gender= "Male";
        }else if(r2.isSelected()){
            gender="Female";
        }
String countryname=t3.getText();
        String room=(String)c.getSelectedItem();
        String checked= t4.getText();
        String deposit=t5.getText();
        String st="insert into coustomer values('"+id+"','"+nomber+"','"+name+"','"+gender+"','"+countryname+"','"+room+"','"+checked+"','"+deposit+"')";
        String st2="update  room set available='Occupied' where room='"+room+"'";
        try {
           Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/mohit","root","Mohit*123");
            Statement s = c.createStatement();
            s.executeUpdate(st);
            s.executeUpdate(st2);
            JOptionPane.showMessageDialog(null,"Employee Added");
        setVisible(false);
        new reciption().setVisible(true);
        }catch (Exception exception){}

    }
});

b2.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
     setVisible(false);
     new reciption().setVisible(true);

    }
});
        setBounds(190,100,1000,680);
    setVisible(true);
    setLayout(null);
    }

    public static void main(String[] args) {
        newcoustomer n= new newcoustomer();

    }
}
