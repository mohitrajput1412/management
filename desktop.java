package hotelmanagement.company;

import javax.imageio.stream.ImageInputStream;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class desktop extends JFrame implements ActionListener {
    JMenuBar mb;
    JMenu m1,m2;
    JMenuItem i1,i2,i3,i4;
    public desktop(){
    mb= new JMenuBar();
    add(mb);
    m1=  new JMenu("Hotel Management");
         mb.add(m1);
         //mb.setBackground(Color.cyan);
         m1.setForeground(Color.red);
         m2= new JMenu("Admin");
         mb.add(m2);
         m2.setForeground(Color.red);
         i1= new JMenuItem("Reciption");
         i1.addActionListener(this);
         m1.add(i1);
         i2= new JMenuItem("Add Employ");
        i2.addActionListener(this);
         m2.add(i2);
         i3= new JMenuItem("Add Room");
         i3.addActionListener(this);
         m2.add(i3);
         i4= new JMenuItem("Add Driver");
        i4.addActionListener(this);
         m2.add(i4);
         ImageIcon i= new ImageIcon(ClassLoader.getSystemResource("hotelmanagement/company/image/third.jpg"));
Image i2= i.getImage().getScaledInstance(1500,700,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
         JLabel l= new JLabel(i3);
         l.setBounds(0,20,1500,700);
         add(l);
         JLabel l2= new JLabel("Hotel Gopal");
         l2.setBounds(480,20,300,40);
         l2.setFont(new Font("Italic",Font.ROMAN_BASELINE,40));
         l2.setForeground(Color.white);
        l.add(l2);
          //setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
         setBounds(0,0,1500,1000);
         setVisible(true);

   mb.setBounds(0,0,1500,20);
    }

    public static void main(String[] args) {

        desktop d= new desktop();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Reciption"))
        {
            reciption r= new reciption();
            r.setVisible(true);
        }else if(e.getActionCommand().equals("Add Employ")){
         addemploye ae= new addemploye();
             ae.setVisible(true);
        }else if(e.getActionCommand().equals("Add Room")){
addRoom ar= new addRoom();
ar.setVisible(true);
        }else if(e.getActionCommand().equals("Add Driver")){
     AddDrivers ad= new AddDrivers();
ad.setVisible(true);
        }    }
}
