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
import java.util.jar.JarEntry;

public class Searchroom extends JFrame {
JComboBox jc;
JCheckBox chec;
JButton b1,b2;
JTable tab;
    public Searchroom(){
JLabel l= new JLabel("Search For Room");
l.setBounds(100,10,350,30);
l.setFont(new Font("Simple",Font.BOLD,40));
l.setForeground(Color.blue);
add(l);


JLabel l2= new JLabel("Bade Type");
l2.setBounds(50,100,170,30);
add(l2);
l2.setFont(new Font("Simple",Font.BOLD,20));
String st[]={"Single","Double"};
jc= new JComboBox(st);
jc.setBounds(230,100,100,20);
add(jc);

chec =new JCheckBox("Only Desplay Available");
chec.setBounds(500,100,200,30);
add(chec);

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
            String str= "select * from room where bade='"+jc.getSelectedItem()+"'";
String str2= "select * from room where available='Available'' AND bade='"+jc.getSelectedItem()+"'";
            ResultSet rs= s.executeQuery(str);
            tab.setModel(DbUtils.resultSetToTableModel(rs));
if (chec.isSelected()){
    ResultSet rs2= s.executeQuery(str2);
    tab.setModel(DbUtils.resultSetToTableModel(rs2));

}
        }catch (Exception e1){
            System.out.println(e1);
        }
    }
});
        getContentPane().setBackground(Color.white);
JLabel l1= new JLabel("Room no");
l1.setBounds(10,140,120,30);
l1.setFont(new Font("Simple",Font.BOLD,20));
add(l1);
JLabel l3= new JLabel("Availablity");
        l3.setBounds(250,140,120,30);
        l3.setFont(new Font("Simple",Font.BOLD,20));
        add(l3);

JLabel l4= new JLabel("Status");
        l4.setBounds(485,140,120,30);
        l4.setFont(new Font("Simple",Font.BOLD,20));
        add(l4);

JLabel l5= new JLabel("Price");
        l5.setBounds(740,140,120,30);
        l5.setFont(new Font("Simple",Font.BOLD,20));
        add(l5);

JLabel l6= new JLabel("Type");
        l6.setBounds(960,140,120,30);
        l6.setFont(new Font("Simple",Font.BOLD,20));
        add(l6);

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

        Searchroom se= new Searchroom();

    }
}