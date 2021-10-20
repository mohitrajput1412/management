package hotelmanagement.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class reciption extends JFrame {
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12;

    public reciption(){
        setBounds(190,100,900,570);
        setVisible(true);

        b1= new JButton("New Coustomer Form");
b1.setBounds(10,20,200,30);
add(b1);
b1.setBackground(Color.black);
b1.setForeground(Color.white);
ImageIcon i= new ImageIcon(ClassLoader.getSystemResource("hotelmanagement/company/image/fourth.jpg"));
Image i2= i.getImage().getScaledInstance(600,600,Image.SCALE_FAST);
ImageIcon i3= new ImageIcon(i2);
JLabel l= new JLabel(i3);
l.setBounds(260,0,600,600);
add(l);
setDefaultCloseOperation(EXIT_ON_CLOSE);
b1.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
                try {
                        newcoustomer n = new newcoustomer();
                        n.setVisible(true);
                        setVisible(false);
                }catch (Exception ae){

                }
        }
});
b2= new JButton("Room");
b2.setBounds(10,60,200,30);
b2.setBackground(Color.black);
b2.setForeground(Color.white);
add(b2);
b2.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
                try {
                        Room r = new Room();
                        r.setVisible(true);
                        setVisible(false);
                }catch (Exception ae){

                }
        }
});
        b3= new JButton("Department");
        b3.setBounds(10,100,200,30);
        b3.setBackground(Color.black);
        b3.setForeground(Color.white);
        add(b3);
        b3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                 try {
                         Department d= new Department();

                        d.setVisible(true);
                        setVisible(false);
                 }catch (Exception e1){

                 }
                 }
        });
        b4= new JButton("All Employe Info");
        b4.setBounds(10,140,200,30);
        b4.setBackground(Color.black);
        b4.setForeground(Color.white);
        add(b4);
        b4.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                        try {
                                AllEmploye a= new AllEmploye();
                                a.setVisible(true);
                        setVisible(false);
                        }
                catch (Exception e2){

                }
                }
        });
        b5= new JButton("Customer Info");
        b5.setBounds(10,180,200,30);
        b5.setBackground(Color.black);
        b5.setForeground(Color.white);
        add(b5);
            b5.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                            try {
                                    CoustoInfo c = new CoustoInfo();
                                    c.setVisible(true);
                                    setVisible(false);
                            }
                            catch (Exception e2){

                            }
                    }
            });
        b6= new JButton("Manager Info");
        b6.setBounds(10,220,200,30);
        b6.setBackground(Color.black);
        b6.setForeground(Color.white);
        add(b6);
            b6.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                            try {
                                    Manageerinfo m = new Manageerinfo();
                                    m.setVisible(true);
                                    setVisible(false);
                            }
                            catch (Exception e2){

                            }
                    }
            });
        b7= new JButton("Check Out");
        b7.setBounds(10,260,200,30);
        b7.setBackground(Color.black);
        b7.setForeground(Color.white);
        add(b7);
            b7.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                            try {
                                    Checkout ch = new Checkout();
                                    ch.setVisible(true);
                                    setVisible(false);
                            }
                            catch (Exception e2){

                            }
                    }
            });
        b8= new JButton("Update Check Status");
        b8.setBounds(10,300,200,30);
        b8.setBackground(Color.black);
        b8.setForeground(Color.white);
        add(b8);
            b8.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                            try {
                                    UpdateCheck uc = new UpdateCheck();
                                    uc.setVisible(true);
                                    setVisible(false);
                            }
                            catch (Exception e2){

                            }
                    }
            });
        b9= new JButton("Update Room Status ");
        b9.setBounds(10,340,200,30);
        b9.setBackground(Color.black);
        b9.setForeground(Color.white);
        add(b9);
            b9.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                            try {
                                    UpdateRoomCheckstatus cp = new UpdateRoomCheckstatus();
                                    cp.setVisible(true);
                                    setVisible(false);
                            }
                            catch (Exception e2){

                            }
                    }
            });
        b10= new JButton("Pic Up Service");
        b10.setBounds(10,380,200,30);
        b10.setBackground(Color.black);
        b10.setForeground(Color.white);
        add(b10);
            b10.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                            try {
                                    Picupservice pi = new Picupservice();
                                    pi.setVisible(true);
                                    setVisible(false);
                            }
                            catch (Exception e2){

                            }
                    }
            });
        b11= new JButton("Search Room");
        b11.setBounds(10,420,200,30);
        b11.setBackground(Color.black);
        b11.setForeground(Color.white);
        add(b11);
            b11.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                            try {
                                    Searchroom se = new Searchroom();
                                    se.setVisible(true);
                                    setVisible(false);
                            }
                            catch (Exception e2){

                            }
                    }
            });
        b12= new JButton("Log Out");
        b12.setBounds(10,460,200,30);
        b12.setBackground(Color.black);
        b12.setForeground(Color.white);
        add(b12);
            b12.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                            try {
                                    LogOut l = new LogOut();
                                 // new   reciption().setVisible(false);
                                    //new desktop().setVisible(false);
//                            l.setVisible(false);
  setVisible(false);
                            }
                            catch (Exception e2){

                            }
                    }
            });


        setLayout(null);
getContentPane().setBackground(Color.white);
    }

    public static void main(String[] args) {
        reciption r= new reciption();
    }


}


