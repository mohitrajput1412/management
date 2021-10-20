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

public class Department extends JFrame {
    public Department(){

        //Choice c1;
        //JCheckBox chec;
        JButton b1,b2;
        JTable tab;

        JLabel l= new JLabel("Department");
        l.setBounds(100,10,350,30);
        l.setFont(new Font("Simple",Font.BOLD,20));
        l.setForeground(Color.blue);
        add(l);
        JLabel l6= new JLabel("Budget");
        l6.setBounds(580,10,90,30);
        l6.setFont(new Font("Simple",Font.BOLD,20));
        l6.setForeground(Color.blue);
        add(l6);
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
                    Statement s= c.createStatement();String str= "select * from departemetn2";
                    ResultSet rs= s.executeQuery(str);
                  tab.setModel(DbUtils.resultSetToTableModel(rs));

                }catch (Exception e1){
                    System.out.println(e1);
                }
            }
        });
        getContentPane().setBackground(Color.white);


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

        Department d = new Department();
    }
}
