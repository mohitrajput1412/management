package hotelmanagement.company;
import com.mysql.cj.x.protobuf.MysqlxDatatypes;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Stack;
import java.awt.event.*;

public class addRoom extends JFrame implements ActionListener {
JTextField t1,t2;
JComboBox c1,c2,c3;
JButton b1,b2;
    addRoom(){
        setBounds(150,200,900,400);
        setLayout(null);
        setVisible(true);
JLabel l1= new JLabel("Add Room");
l1.setBounds(300,20,100,20);
l1.setFont(new Font("Simple",Font.BOLD,20));
add(l1);
JLabel l2= new JLabel("Room Nomber");
l2.setBounds(100,60,150,20);
l2.setFont(new Font("Simple", Font.BOLD,20));
add(l2);
t1= new JTextField();
t1.setBounds(280,60,150,20);
add(t1);
setDefaultCloseOperation(EXIT_ON_CLOSE);
getContentPane().setBackground(Color.white);
    JLabel l3= new JLabel("Availabel");
    l3.setBounds(100,100,120,20);
    l3.setFont(new Font("Simple",Font.BOLD,20));
    add(l3);
    JLabel l4= new JLabel("Cleaning Status");
    l4.setBounds(100,140,160,20);
    l4.setFont(new Font("Simple",Font.BOLD,20));
    add(l4);
    JLabel l5= new JLabel("Price");
    l5.setBounds(100,180,80,20);
    l5.setFont(new Font("Simple",Font.BOLD,20));
    add(l5);
     t2= new JTextField();
    t2.setBounds(280,180,80,20);
    add(t2);
    JLabel l6= new JLabel("Bade");
    l6.setBounds(100,220,60,20);
    l6.setFont(new Font("Simple",Font.BOLD,20));
    add(l6);
    c1= new JComboBox(new String[]{"Availabel","Occupied"});
    c1.setBounds(280,100,120,30);
    add(c1);
    c2= new JComboBox(new String[]{"Clean","Dearty"});
    c2.setBounds(280,140,120,30);
    add(c2);
    c3= new JComboBox(new String[]{"Single","Double"});
    c3.setBounds(280,220,120,30);
    add(c3);
ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("hotelmanagement/company/image/eight.jpg"));
    Image i1= i.getImage().getScaledInstance(400,400,Image.SCALE_DEFAULT);
    ImageIcon i2= new ImageIcon(i1);
    JLabel jLabel= new JLabel(i2);
    jLabel.setBounds(430,0,400,400);
    add(jLabel);
 b1= new JButton("Add Room");
  b1.setBounds(10,280,200,30);
  add(b1);
  b1.setBackground(Color.black);
  b1.setForeground(Color.white);
  b1.setFont(new Font("Simple",Font.BOLD,30));
  b2= new JButton("Cancel");
  b2.setBounds(220,280,150,30);
  add(b2);
  b2.setFont(new Font("Simple",Font.BOLD,30));
  b2.setBackground(Color.black);
  b2.setForeground(Color.white);
    b1.addActionListener(this);
b2.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e) {
if (e.getSource()==b1){
    try {
        //conn c1= new conn();
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/mohit","root","Mohit*123");
        String room=t1.getText();
        String available = (String)c1.getSelectedItem();
         String Cleaning= (String)c2.getSelectedItem();
         String price=t2.getText();
         String bade= (String)c3.getSelectedItem();

         String str="INSERT INTO room values('"+room+"','"+available+"','"+Cleaning+"','"+price+"','"+bade+"')";
        Statement s = c.createStatement();
        s.executeUpdate(str);
        // c1.s.executeUpdate(str);
            JOptionPane.showMessageDialog( null,"roomAdd Succesful");
            this.setVisible(false);

    }catch (Exception ae){
        System.out.println(e);
    }

}else if(e.getSource()==b2){
this.setVisible(false);
}
    }

    public static void main(String[] args)
    {
        addRoom a = new addRoom();
    }



}
