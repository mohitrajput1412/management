package hotelmanagement.company;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.jar.JarFile;

public class Room extends JFrame {
JTable jt;
JButton b1,b2;
    public Room(){
        jt= new JTable();
        jt.setBounds(10,40,580,450);
        add(jt);
        //ImageIcon i= new ImageIcon(ClassLoader.getSystemResource("hotelmanagement/company/image/t.jpg"));
        b1= new JButton("LOAD DATA");
            b1.setBounds(180,500,130,30);
            add(b1);
            b2= new JButton("Cancel");
            b2.setBounds(330,500,130,30);
            add(b2);
            JLabel n= new JLabel("Room No");
            n.setBounds(10,20,100,20);
            add(n);
            JLabel a=new JLabel("Availibility");
            a.setBounds(120,20,100,20);
            a.setFont(new Font("Simple",Font.BOLD,20));
            add(a);
        JLabel c=new JLabel("Clean status");
        c.setBounds(230,20,150,20);
        c.setFont(new Font("Simple",Font.BOLD,20));
        add(c);
        JLabel p=new JLabel("Price");
        p.setBounds(390,20,80,20);
        p.setFont(new Font("Simple",Font.BOLD,20));
        add(p);
        JLabel B=new JLabel("Bade Type");
        B.setBounds(480,20,130,20);
        B.setFont(new Font("Simple",Font.BOLD,20));
        add(B);


        n.setFont(new Font("Simple",Font.BOLD,20));
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotelmanagement/company/image/twelve.jpg"));
        Image i3 = i1.getImage().getScaledInstance(580, 450,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel image = new JLabel(i2);
        image.setBounds(600,40,580,450);
        add(image);

        b1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try{
                        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/mohit","root","Mohit*123");
                        String st="select * from room";
                        Statement s= c.createStatement();
                        ResultSet rs=s.executeQuery(st);
                        jt.setModel(DbUtils.resultSetToTableModel(rs));
                    }
                    catch (Exception e1)
                    {
                        e1.printStackTrace();
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

    setBounds(110,120,1200,600);
            setLayout(null);
            setVisible(true);


}

    public static void main(String[] args) {
        Room r= new Room();
    }
}
