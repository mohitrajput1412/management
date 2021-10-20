package hotelmanagement.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class AddDrivers extends JFrame implements ActionListener {
    JTextField t1,t2,t3,t4,t5;
    JComboBox c1,c2;
JRadioButton r1,r2;
JButton b1,b2;
    public AddDrivers(){
setBounds(150,200,700,500);
JLabel l1= new JLabel("Add Driver");
l1.setBounds(350,0,120,20);
add(l1);

l1.setFont(new Font("Simple", Font.BOLD,20));
JLabel l2= new JLabel("Name");
l2.setBounds(70,50,80,20);
add(l2);
l2.setFont(new Font("Simple",Font.BOLD,20) );
t1= new JTextField();
t1.setBounds(220,50,90,20);
add(t1);
JLabel l3= new JLabel("Age");
l3.setBounds(70,90,50,25);
add(l3);
l3.setFont(new Font("Simple",Font.BOLD,20));
t2= new JTextField();
t2.setBounds(220,90,50,20);
add(t2);
JLabel l4= new JLabel("Gender");
l4.setBounds(70,130,80,20);
add(l4);
l4.setFont(new Font("Simple",Font.BOLD,20));
r1= new JRadioButton("Male");
add(r1);
r1.setBounds(220,130,70,20);
r2= new JRadioButton("Female");
add(r2);
r2.setBounds(290,130,70,20);
ImageIcon i= new ImageIcon(ClassLoader.getSystemResource("hotelmanagement/company/image/eleven.jpg"));
Image i2= i.getImage().getScaledInstance(400,400,Image.SCALE_FAST);
ImageIcon i3= new ImageIcon(i2);
JLabel label= new JLabel(i3);
add(label);
label.setBounds(400,20,400,400);
JLabel l5= new JLabel("Car Company");
l5.setBounds(70,170,150,20);
add(l5);
JLabel l6= new JLabel("Car Brand");
l6.setBounds(70,200,100,20);
t3= new JTextField();
t3.setBounds(220,165,70,20);
l6.setFont(new Font("Simple",Font.BOLD,20));
add(t3);
add(l6);
l5.setFont(new Font("Simple",Font.BOLD,20) );
t4= new JTextField();
t4.setBounds(220,210,70,20);
add(t4);
JLabel l7= new JLabel("Available");
l7.setBounds(70,250,90,20);
add(l7);
String st[]={"Yes","No"};
c1= new JComboBox(st);
add(c1);
c1.setBounds(220,250,50,30);
l7.setFont(new Font("Simple",Font.BOLD,20));
JLabel l8= new JLabel("Locastion");
l8.setBounds(70,290,120,20);
add(l8);
t5= new JTextField();
t5.setBounds(220,295,50,20);
add(t5);
l8.setFont(new Font("Simple",Font.BOLD,20));
 b1= new JButton("Add");
add(b1);
b1.setBounds(80,330,90,30);
b2= new JButton("Back");
add(b2);
b2.setBounds(200,330,90,30);
b1.addActionListener(this);
b2.addActionListener(this);
setLayout(null);
setVisible(true);
setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==b1){

                //conn c2= new conn();

                String Name=t1.getText();
                String Age = t2.getText();
                String Gender= null;
                if (r1.isSelected()){
                    Gender= "Male";
                }else if (r2.isSelected()){
                    Gender= "Female";
                }
                String CarCompany= t3.getText();
                String CarBrand= t4.getText();
                String Available= (String)c1.getSelectedItem();
                String Locastion= t5.getText();


            try {
                Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/mohit","root","Mohit*123");
                String str="INSERT INTO Driver values('"+Name+"','"+Age+"','"+Gender+"','"+CarCompany+"','"+CarBrand+"','"+Available+"','"+Locastion+"')";
                Statement s = c.createStatement();
                s.executeUpdate(str);
                JOptionPane.showMessageDialog( null,"Driver Add Succesful");
                this.setVisible(false);

            }catch (Exception ae){
                ae.printStackTrace();
            }

        }else if(e.getSource()==b2){
            this.setVisible(false);
        }
    }


    public static void main(String[] args) {
        AddDrivers a= new AddDrivers();

    }

}
