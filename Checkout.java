package hotelmanagement.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Checkout extends JFrame {
    public Checkout(){
        Choice c1;
        JTextField t1 ;
        JButton b1,b2,b3;
        JLabel l= new JLabel("Check Out");
        l.setBounds(100,10,300,50);
        l.setFont(new Font("Simple",Font.BOLD,50));
        l.setForeground(Color.blue);
        add(l);
        JLabel l2= new JLabel("Costomer Id");
        l2.setBounds(100,100,120,20);
        l2.setFont(new Font("Simple",Font.BOLD,20));
        add(l2);
        c1= new Choice();
        try{
            Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/mohit","root","Mohit*123");
            Statement s= c.createStatement();
            ResultSet rs= s.executeQuery("select * from coustomer");
            while (rs.next()){
                c1.add(rs.getString("nomber"));


            }

//String id= c1.getSelectedItem();

        }catch (Exception e){ }
        c1.setBounds(240,100,120,30);
        add(c1);
        JLabel l3= new JLabel("Room No");
        l3.setBounds(100,150,120,20);
        l3.setFont(new Font("Simple",Font.BOLD,20));
        add(l3);

        b1= new JButton("CheckOut");
        b1.setBounds(150,250,120,50);
        b1.setForeground(Color.white);
        b1.setBackground(Color.black);
        add(b1);

        b2= new JButton("Back");
        b2.setBounds(300,250,120,50);
        b2.setForeground(Color.white);
        b2.setBackground(Color.black);
        add(b2);

        ImageIcon i= new ImageIcon(ClassLoader.getSystemResource("hotelmanagement/company/image/tick.png"));
Image i2= i.getImage().getScaledInstance(20,20,Image.SCALE_FAST);
ImageIcon i3= new ImageIcon(i2);

b3= new JButton(i3);
b3.setBounds(370,100,20,20);
add(b3);

        ImageIcon imageIcon=new ImageIcon(ClassLoader.getSystemResource("hotelmanagement/company/image/sixth.jpg"));
Image image= imageIcon.getImage().getScaledInstance(400,400,Image.SCALE_FAST);
   ImageIcon i4= new ImageIcon(image);
    JLabel lab= new JLabel(i4);
    lab.setBounds(390,10,550,450);
    add(lab);
        t1= new JTextField();
        t1.setBounds(240,150,120,30);
        add(t1);


        b1.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
String id= c1.getSelectedItem();

        try {
            Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/mohit","root","Mohit*123");
            String room = t1.getText();
            String st="Delete  from coustomer where nomber='"+id+"'";
            String st2= "update room set available='Available'where room = '"+room+"'";

Statement s =c.createStatement();
 s.executeUpdate(st);
s.executeUpdate(st2);
JOptionPane.showMessageDialog(null, "Coustomer Checout Succesfull");
        new reciption().setVisible(true);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
});
b2.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        new reciption().setVisible(true);
        setVisible(false);
    }
});
        b3.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        //String id= c1.getSelectedItem();
//String room= null;
        try {
            Connection c2= DriverManager.getConnection("jdbc:mysql://localhost:3306/mohit","Mohit*123","root");
        Statement s=c2.createStatement();
        String id=c1.getSelectedItem();
        ResultSet rs= s.executeQuery("select * from coustomer where nomber='"+id+"'");
        while (rs.next()){
           t1.setText(rs.getString("room"));

        }
        } catch (Exception E) {

        }
    }
});
getContentPane().setBackground(Color.white);


        setBounds(190,210,900,500);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


    }

    public static void main(String[] args) {
        Checkout ch= new Checkout();
    }
}
