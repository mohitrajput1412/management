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

public class Picupservice extends JFrame {
    public Picupservice(){
        Choice c1;
        JCheckBox chec;
        JButton b1,b2;
        JTable tab;

            JLabel l= new JLabel("Picup Service");
            l.setBounds(100,10,350,30);
            l.setFont(new Font("Simple",Font.BOLD,40));
            l.setForeground(Color.blue);
            add(l);


            JLabel l2= new JLabel("Car Type");
            l2.setBounds(50,100,170,30);
            add(l2);
            l2.setFont(new Font("Simple",Font.BOLD,20));

            c1= new Choice();
            try {
                Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/mohit","root","Mohit*123");
                Statement s= c.createStatement();
                ResultSet rs= s.executeQuery("select * from driver");
                while (rs.next()){
                    c1.add(rs.getString("CarBrand"));

                }
            }catch (Exception e){

            }
            c1.setBounds(230,100,100,20);
            add(c1);


            tab= new JTable();
            tab.setBounds(10,170,1200,300);
            add(tab);

            b1= new JButton("Submit");
            b1.setBounds(30,600,120,30);
            b1.setFont(new Font("Simple",Font.BOLD,20));
            add(b1);
            b1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/mohit","root","Mohit*123");
                        Statement s= c.createStatement();
                        String str= "select * from driver where CarBrand='"+c1.getSelectedItem()+"'";
                        ResultSet rs= s.executeQuery(str);
                        tab.setModel(DbUtils.resultSetToTableModel(rs));

                    }catch (Exception e1){
                        System.out.println(e1);
                    }
                }
            });
            getContentPane().setBackground(Color.white);
            JLabel l1= new JLabel("Name");
            l1.setBounds(10,140,120,30);
            l1.setFont(new Font("Simple",Font.BOLD,20));
            add(l1);
            JLabel l3= new JLabel("Age");
            l3.setBounds(250,140,120,30);
            l3.setFont(new Font("Simple",Font.BOLD,20));
            add(l3);

            JLabel l4= new JLabel("Gender");
            l4.setBounds(350,140,120,30);
            l4.setFont(new Font("Simple",Font.BOLD,20));
            add(l4);

            JLabel l5= new JLabel("Car Company");
            l5.setBounds(520,140,200,30);
            l5.setFont(new Font("Simple",Font.BOLD,20));
            add(l5);

            JLabel l6= new JLabel("Car Brand");
            l6.setBounds(720,140,120,30);
            l6.setFont(new Font("Simple",Font.BOLD,20));
            add(l6);
        JLabel l7= new JLabel("Available");
        l7.setBounds(860,140,120,30);
        l7.setFont(new Font("Simple",Font.BOLD,20));
        add(l7);
        JLabel l8= new JLabel("Locastion");
        l8.setBounds(1020,140,120,30);
        l8.setFont(new Font("Simple",Font.BOLD,20));
        add(l8);



        b2= new JButton("Back");
            b2.setBounds(170,600,120,30);
            b2.setFont(new Font("Simple",Font.BOLD,20));
            add(b2);
            b2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new reciption().setVisible(true);
                    setVisible(false);
                }
            });

            setBounds(50,50,1200,800);
            setLayout(null);
            setVisible(true);


        }



    public static void main(String[] args) {

        Picupservice pi= new Picupservice();
    }
}
