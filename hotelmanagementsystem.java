package hotelmanagement.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.Font.*;

public class hotelmanagementsystem extends JFrame implements ActionListener {
    public hotelmanagementsystem() throws InterruptedException {
       // JFrame jf = new JFrame();
        //      jf.setLayout(null);

        setSize(1366, 700);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotelmanagement/company/image/first.jpg"));
        JLabel l1 = new JLabel(i1);
//l1.setLayout(null);
        setBounds(0, 0, 1366, 700);
        JLabel l2 = new JLabel("Hotel Management System");
        l2.setBounds(20, 466, 700, 60);
        add(l1);
        l1.add(l2);
        l2.setForeground(Color.red);
        l2.setFont(new Font("serif", Font.ITALIC, 50));
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
JButton jb= new JButton("Next");
jb.setBounds(780,490,80,20);
l1.add(jb);
jb.setBackground(Color.black);
jb.setForeground(Color.white);
 jb.addActionListener(this);

            while (true) {
            l2.setVisible(false);
            try {
                Thread.sleep(500);
            } catch (Exception e) {

            } l2.setVisible(true);
try {
    Thread.sleep(500);


}catch (Exception e){}

            }

                   }
    public void actionPerformed(ActionEvent e) {
        new login().setVisible(true);
        this.setVisible(false);

    }

                   public static void main(String[] args) throws InterruptedException {
	// write your code here
        hotelmanagementsystem h= new hotelmanagementsystem();
        h.setVisible(true);
    }


}
