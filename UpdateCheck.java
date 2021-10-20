package hotelmanagement.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class UpdateCheck extends JFrame {
    Choice c;
    JTextField t1,t2,t3,t4,t5;
    JButton b1,b2,b3;
    public  UpdateCheck(){
        JLabel jl= new JLabel("Check in Details");
        jl.setBounds(100,50,350,30);
        jl.setFont(new Font("Simple",Font.BOLD, 40));
        jl.setForeground(Color.blue);
        add(jl);
        JLabel l1= new JLabel(" Customer-ID");
        l1.setBounds(30,140,140,20);
        l1.setFont(new Font("Simple",Font.BOLD, 20));
        add(l1);

        c=new Choice();
        try{
            Connection c1= DriverManager.getConnection("jdbc:mysql://localhost:3306/mohit","root","Mohit*123");
            Statement s= c1.createStatement();
            ResultSet rs=s.executeQuery("select * from coustomer");
            while (rs.next()){
                c.add(rs.getString("nomber"));
            }

        }catch (Exception e){
        }
        c.setBounds(200,140,140,30);
            add(c);


        JLabel l2= new JLabel("Room NO");
        l2.setBounds(30,200,140,20);
        l2.setFont(new Font("Simple",Font.BOLD, 20));
        add(l2);
        t1= new JTextField();
        t1.setBounds(200,200,140,30);
        add(t1);
        JLabel l3= new JLabel("Name");
        l3.setBounds(30,260,140,20);
        l3.setFont(new Font("Simple",Font.BOLD, 20));
        add(l3);
        t2= new JTextField();
        t2.setBounds(200,260,140,30);
        add(t2);

        JLabel l4= new JLabel("Check in");
        l4.setBounds(30,320,140,20);
        l4.setFont(new Font("Simple",Font.BOLD, 20));
        add(l4);
        t3= new JTextField();
        t3.setBounds(200,320,140,30);
        add(t3);

        JLabel l5= new JLabel("Amount Paid");
        l5.setBounds(30,380,140,20);
        add(l5);
        t4= new JTextField();
        t4.setBounds(200,380,140,30);
        add(t4);

        l5.setFont(new Font("Simple",Font.BOLD, 20));
        JLabel l6= new JLabel("Pending Amount");
        l6.setBounds(30,440,180,30);
        l6.setFont(new Font("Simple",Font.BOLD, 20));
        add(l6);
        t5= new JTextField();
        t5.setBounds(200,440,140,30);
        add(t5);
        b1= new JButton("Check");
        b1.setBounds(80,500,120,30);
        add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        b2= new JButton("Update");
        b2.setBounds(210,500,120,30);
        add(b2);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    String room= null;
                    String deposit=null;
                    int amountpaid;
                    String price=null;

      Connection c1= DriverManager.getConnection("jdbc:mysql://localhost:3306/mohit","root","Mohit*123");
      Statement s= c1.createStatement();
                    String id= c.getSelectedItem();
      String str="select * from coustomer where nomber='"+id+"'";
ResultSet rs = s.executeQuery(str);
while(rs.next()){
    t1.setText(rs.getString("room"));
    t2.setText(rs.getString("name"));
    t3.setText(rs.getString("checked"));
t4.setText(rs.getString("deposit"));
 room=rs.getString("room");
 deposit= rs.getString("deposit");


}
ResultSet rs2=s.executeQuery("select * from room where room='"+room+"'");
while (rs2.next()){
    price= rs2.getString("price");
amountpaid=Integer.parseInt(price)-Integer.parseInt(deposit);
t5.setText(Integer.toString(amountpaid));
}
                }catch (Exception e1){

                }


            }
        });
        ImageIcon i= new ImageIcon(ClassLoader.getSystemResource("hotelmanagement/company/image/nine.jpg"));
         JLabel l= new JLabel(i);
         add(l);
         l.setBounds(420,50,400,400);

        b3= new JButton("Back");
        b3.setBounds(340,500,120,30);
        add(b3);
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new reciption().setVisible(true);
                setVisible(false);
            }
        });

        setBounds(100,70,900,600);
setLayout(null);
setVisible(true);

    }

    public static void main(String[] args) {

        UpdateCheck up = new UpdateCheck();
    }
}
