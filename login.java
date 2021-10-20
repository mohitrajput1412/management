package hotelmanagement.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class login extends JFrame implements ActionListener {
   JButton b1,b2;
   JTextField t1,t2;
   //JPasswordField jp;
   JLabel l1,l2;
   //Statement s;
   ResultSet rs;
    private String str;

    public login(){

        //JFrame jf= new JFrame();

        setBounds(100,100,600,300);
        setLayout(null);

        l1= new JLabel("UserName");
        l1.setBounds(100,50,70,40);
        l2= new JLabel("Password");
        l2.setBounds(100,120,70,40);
       t1= new JTextField();
        t1.setBounds(190,50,100,30);
        t2= new JPasswordField();
        t2.setBounds(190,120,100,30);
        b1= new JButton("Login");
        b1.setBounds(140,220,80,40);
        b2= new JButton("Reset");
        b2.setBounds(230,220,80,40);
        b1.setBackground(Color.black);
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b1.setForeground(Color.white);

        ImageIcon i= new ImageIcon(ClassLoader.getSystemResource("hotelmanagement/company/image/second.jpg"));
Image i1= i.getImage().getScaledInstance(200,200,Image.SCALE_FAST);
ImageIcon i3= new ImageIcon(i1);
        JLabel l3= new JLabel(i3);
l3.setBounds(220,00,400,300);
getContentPane().setBackground(Color.white);
b1.addActionListener(this);
b2.addActionListener(this);
        add(l3);
        add(b2);
        add(b1);
        add(t2);
        add(l1);
        add(l2);
        add(t1);
   setVisible(true);

b1.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {

    }
});
    }


    @Override
    public void actionPerformed(ActionEvent e1) {
     if(e1.getSource()==b1){
try {conn c1 = new conn();
//    String u = t1.getText();
//   String v = jp.getText();

    //String host= "jdbc:mysql://localhost:3306/mohit";
    //String username= "root";
    //String password="Mohit*123";


   //ResultSet rs = s.executeQuery(str);
        try {//conn c1 = new conn();
           // String u = "root";
            //String v = "Mohit*123";
//            String u = t1.getText();
//         String v = jp.getText();

            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/mohit","root","Mohit*123");
            Statement s = c.createStatement();
            String u = "root";
            String v = "Mohit*123";
            //String u1 = t1.getText();
        //String v1 = t2.getText();

            //String str= "select * from login where username is'"+u+"'and password='"+v+"'";
           String str="select * from login";

            rs =s.executeQuery(str);
        if (rs.next()) {
            new desktop().setVisible(true);
            setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null, "incorrect use,passwrod");
            setVisible(false);
        }
    } finally {
        rs.close();
    }
}catch (Exception e){
e.printStackTrace();
}
     }else if(e1.getSource()==b2){
         System.exit(0);
     }
    }
    public static void main(String[] args) {

        login l = new login();
    }

}
