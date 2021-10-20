package hotelmanagement.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class UpdateRoomCheckstatus extends JFrame {
    Choice c1;
    JTextField t1,t2,t3,t4;
    JButton b1,b2,b3;
    public UpdateRoomCheckstatus(){

        setBounds(190,160,900,500);
        setLayout(null);
        setVisible(true);
        JLabel l= new JLabel("Update Room Status");
        l.setBounds(10,10,300,30);
        l.setForeground(Color.magenta);
        add(l);
        l.setFont(new Font("Simple",Font.BOLD,30));
        JLabel l2= new JLabel("Guset Id");
        l2.setBounds(30,70,100,20);
        l2.setFont(new Font("Simple",Font.BOLD,20));
        add(l2);
        c1 = new Choice();
        try{
            Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/mohit","root","Mohit*123");
            Statement s= c.createStatement();
            ResultSet rs=s.executeQuery("select * from coustomer");
            while (rs.next()){
                this.c1.add(rs.getString("nomber"));
            }

        }catch (Exception e){
        }
        c1.setBounds(250,70,120,30);
        add(c1);
        JLabel l3= new JLabel("Room No");
        l3.setBounds(30,130,100,20);
        l3.setFont(new Font("Simple",Font.BOLD,20));
        add(l3);

        JLabel l4= new JLabel("Availability");
        l4.setBounds(30,190,140,20);
        l4.setFont(new Font("Simple",Font.BOLD,20));
        add(l4);
        t2= new JTextField();
        t2.setBounds(250,190,120,30);
        add(t2);
        JLabel l5 = new JLabel("Clean Status");
        l5.setBounds(30,260,140,20);
        l5.setFont(new Font("Simple",Font.BOLD,20));
        add(l5);
        t3= new JTextField();
        t3.setBounds(250,260,120,30);
        add(t3);
        getContentPane().setBackground(Color.white);

        b1= new JButton("Check");
        b1.setBounds(50,350,80,40);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        t1= new JTextField();
        t1.setBounds(250,130,120,30);
        add(t1);

b1.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String s1= c1.getSelectedItem();
     String room = null;
        try {
            Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/mohit","root","Mohit*123");
        Statement s=c.createStatement();
        ResultSet rs= s.executeQuery("select * from coustomer where nomber='"+s1+"'");
        while (rs.next()){
            t1.setText(rs.getString("room"));
room =rs.getString("room");
        }
            ResultSet rs2= s.executeQuery("select * from room where room='"+room+"'");
while (rs2.next()){
t2.setText(rs2.getString("available"));
t3.setText(rs2.getString("Cleaning"));
}
        }catch (Exception e1){

        }

    }
});
        add(b1);
        b2= new JButton("Update");
        b2.setBounds(170,350,80,40);
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        add(b2);
     b2.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             try {
String room = t2.getText();
String availibility=t3.getText();
String status=t4.getText();
                 //cc.createStatement();
                 Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/mohit");
                 Statement s= c.createStatement();
                 String st="update room set available='"+availibility+"',Cleaning='"+status+"'";

                 s.executeUpdate(st);
JOptionPane.showMessageDialog(null,"Updated");
new reciption().setVisible(true);
setVisible(false);

             }catch (Exception e2){

             }
         }
     });
        b3= new JButton("Back");
        b3.setBounds(260,350,80,40);
        b3.setBackground(Color.black);
        b3.setForeground(Color.white);
        add(b3);
   b3.addActionListener(new ActionListener() {
       @Override
       public void actionPerformed(ActionEvent e) {
           setVisible(false);
           new reciption().setVisible(true);
       }
   });

    }

    public static void main(String[] args) {

        UpdateRoomCheckstatus upd= new UpdateRoomCheckstatus();
    }
}
