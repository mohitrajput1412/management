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


        public class Manageerinfo extends JFrame  {
            JTable jt;
            JButton b1,b2;
            public Manageerinfo(){
                jt= new JTable();

                jt.setBounds(10,20,1230,520);
                add(jt);
                setBounds(90,100,1280,600);
                setLayout(null);
                setVisible(true);
                setDefaultCloseOperation(EXIT_ON_CLOSE);
                JLabel l1= new JLabel("Name");
                l1.setBounds(10,0,50,20);
                add(l1);
                JLabel l2= new JLabel("Age");
                l2.setBounds(190,0,30,20);
                add(l2);
                JLabel l3= new JLabel("Gender");
                l3.setBounds(320,0,70,20);
                add(l3);
                JLabel l4= new JLabel("Job");
                l4.setBounds(480,0,30,20);
                add(l4);
                JLabel l5= new JLabel("Sellary");
                l5.setBounds(650,0,70,20);
                add(l5);
                JLabel l6= new JLabel("Mo.No");
                l6.setBounds(780,0,70,20);
                add(l6);
                JLabel l7= new JLabel("AdharNo");
                l7.setBounds(940,0,90,20);
                add(l7);
                JLabel l8= new JLabel("Email");
                l8.setBounds(1090,0,90,20);
                add(l8);
                getContentPane().setBackground(Color.white);
                b1= new JButton("Load Data");
                b1.setBounds(380,530,120,30);
                add(b1);
                b1.setBackground(Color.black);
                b2=new JButton("Cancel");
                b2.setBounds(510,530,120,30);
                add(b2);
                b2.setBackground(Color.black);
                b1.setForeground(Color.white);
                b2.setForeground(Color.white);
                //b1.addActionListener( this);
                //b2.addActionListener(this);
                b1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try{
                            //conn c1= new conn();
                            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/mohit","root","Mohit*123");

                            String st="select * from emp1 where job='Mannager'";
                            Statement s = c.createStatement();
                            ResultSet rs=s.executeQuery(st);
                            jt.setModel(DbUtils.resultSetToTableModel(rs));

                        }catch (Exception e1){
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

            }


    public static void main(String[] args) {
        Manageerinfo m= new Manageerinfo();
    }
}
