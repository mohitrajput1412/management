
package hotelmanagement.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.zip.ZipEntry;
public class addemploye  extends  JFrame implements ActionListener  {
 JTextField t1,t2,t3,t4,t5,t6;
 JRadioButton r1,r2;

// JFrame jf;
String Gender;
JComboBox jc;
String job;
 public addemploye(){

     setLayout(null);
    setBounds(150,200,700,500);
    JLabel Name= new JLabel("Name");
     t1= new JTextField();
     Name.setBounds(60,50,70,20);
     Name.setFont(new Font("PLAIN",Font.BOLD,20));
     t1.setBounds(190,50,150,20);
     add(t1);
     add(Name);
     JLabel Age= new JLabel("Age");
     t2= new JTextField();
     Age.setBounds(70,90,70,30);
     Age.setFont(new Font("PLAIN",Font.BOLD,20));
     t2.setBounds(180,90,150,20);
     add(t2);
     add(Age);
     JLabel Gender= new JLabel("Gender");
     Gender.setBounds(70,130,70,30);
     Gender.setFont(new Font("Simple",Font.BOLD,20));
   r1= new JRadioButton("Male");
  r1.setBounds(150,130,70,30);
   r2= new JRadioButton("Female");
  r2.setBounds(210,130,80,30);
  r1.setBackground(Color.white);
  r2.setBackground(Color.white);
  add(r2);
  add(r1);
     add(Gender);
     JLabel Job= new JLabel("Job");
     Job.setBounds(70,170,70,30);
     Job.setFont(new Font("Simple",Font.BOLD,20));
     add(Job);
     String str[]={"Mannager","Forters","Kitchen Staff","Room Server","Waiter","Front Desk Clerk","Accountant"};
     jc= new JComboBox(str);
  jc.setBounds(150,170,150,30);
  jc.setBackground(Color.white);
     //JComboBox<String> jc= new JComboBox<String>();
      job = (String)jc.getSelectedItem();
      add(jc);
  JLabel Sallary= new JLabel("Sellary");
     Sallary.setBounds(70,210,70,30);
     Sallary.setFont(new Font("Simple",Font.BOLD,20));
     add(Sallary);
      t3= new JTextField();
     t3.setBounds(180,210,50,20);
     add(t3);
     JLabel Mobile= new JLabel("Mobile");
     Mobile.setBounds(70,250,70,30);
     Mobile.setFont(new Font("Simple",Font.BOLD,20));
     add(Mobile);
      t4= new JTextField();
     t4.setBounds(160,250,120,20);
     add(t4);
     setDefaultCloseOperation(EXIT_ON_CLOSE);
     JLabel Aadhar = new JLabel("Aadhar");
     Aadhar.setBounds(70,310,130,20);
     Aadhar.setFont(new Font("Simple",Font.BOLD,20));
     t5= new JTextField();
     t5.setBounds(160,310,130,20);
     add(t5);
     add(Aadhar);
  JLabel Email = new JLabel("Email Id");
  Email.setBounds(70,350,130,20);
  Email.setFont(new Font("Simple",Font.BOLD,20));
  t6= new JTextField();
  t6.setBounds(160,350,130,20);
  add(t6);
  add(Email);
     ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotelmanagement/company/image/tenth.jpg"));
     Image i3 = i1.getImage().getScaledInstance(350, 350,Image.SCALE_DEFAULT);
     ImageIcon i2 = new ImageIcon(i3);
     JLabel image = new JLabel(i2);
     image.setBounds(350,20,400,400);
     add(image);
     getContentPane().setBackground(Color.white);
     setVisible(true);
     JLabel jl= new JLabel("Add Employe Details");
     jl.setBounds(400,0,200,30);
     jl.setFont(new Font("Simple",Font.BOLD,20));
     jl.setForeground(Color.blue);
     jl.setBackground(Color.black);
     add(jl);
     JButton b1= new JButton("Submit");
     b1.setBackground(Color.black);
     b1.setForeground(Color.white);
     b1.setBounds(150,400,80,40);
     add(b1);
b1.addActionListener(this);
setVisible(true);
 }
    public void actionPerformed(ActionEvent e) {

        String name;
        //t1= new JTextField();
        job = (String)jc.getSelectedItem();
        name = t1.getText();
          // t2= new JTextField();
        String age= t2.getText();
          //t3= new JTextField();
        String sellary= t3.getText();
        //t4= new JTextField();
        String mobile= t4.getText();
        //t5= new JTextField();
        String adhar= t5.getText();
        //t6=  new JTextField();
        String email= t6.getText();
    //    String Gender = null;
//        r1= new JRadioButton();
  //      r2= new JRadioButton();
        if(r1.isSelected()){
            Gender= "Male";
        }else if(r2.isSelected()){
            Gender="Female";
        }

        try {
            // conn c1 = new conn();
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/mohit","root","Mohit*123");
            String str = "INSERT INTO emp1 values( '"+name+"', '"+age+"', '"+Gender+"','"+job+"', '"+sellary+"', '"+mobile+"','"+adhar+"', '"+email+"')";
            Statement s = c.createStatement();
           s.executeUpdate(str);
            JOptionPane.showMessageDialog(null,"Employee Added");
            this.setVisible(false);

        } catch (Exception ae) {
            ae.printStackTrace();
        }
    }
    public static void main(String[] args)
       {

           addemploye e = new addemploye();
    }

    }
