

package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.*;
import java.awt.event.*;
public class Room extends JFrame implements ActionListener {
    JTable table;
    JButton back;
    Room(){
       setLayout(null);
       getContentPane().setBackground(Color.white);
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
       Image i2 = i1.getImage().getScaledInstance(600,600 , Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel image = new JLabel(i3);
       image.setBounds(500, 0, 600, 600);
       add(image);
       
       JLabel roomno = new JLabel("Room Number");
       roomno.setBounds(10,10,100,20);
       add(roomno);
       
       JLabel available = new JLabel("Availability");
       available.setBounds(120,10,100,20);
       add(available);
       
       JLabel status = new JLabel("Status");
       status.setBounds(230,10,100,20);
       add(status);
       
       JLabel price = new JLabel("Price");
       price.setBounds(320,10,100,20);
       add(price);
       
       JLabel type = new JLabel("Type");
       type.setBounds(420,10,100,20);
       add(type);
       
       back = new JButton("Back");
       back.setForeground(Color.white);
       back.setBackground(Color.black);
       back.setBounds(200,500,100,30);
       back.addActionListener(this);
       add(back);
       
       table = new JTable();
       table.setBounds(0,40,500,400);
       add(table);
       
       try{
           Conn conn = new Conn();
           String query ="select * from room";
           ResultSet rs = conn.s.executeQuery(query);
           table.setModel(DbUtils.resultSetToTableModel(rs));
           
           
       }catch(Exception e){
           e.printStackTrace();
       }
       setBounds(300,200,1050,600);
       setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            new Reception();
        }
    }
    public static void main(String[] args){
     new Room();
}
}
