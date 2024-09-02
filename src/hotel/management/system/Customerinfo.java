

package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.*;
import java.awt.event.*;
public class Customerinfo extends JFrame implements ActionListener {
    JTable table;
    JButton back;
    Customerinfo(){
       setLayout(null);
       getContentPane().setBackground(Color.white);
       
       
       JLabel roomno = new JLabel("Document");
       roomno.setBounds(10,10,100,20);
       add(roomno);
       
       JLabel available = new JLabel("Doc Number");
       available.setBounds(150,10,100,20);
       add(available);
       
       JLabel status = new JLabel("Name");
       status.setBounds(300,10,100,20);
       add(status);
       
       JLabel price = new JLabel("Gender");
       price.setBounds(400,10,100,20);
       add(price);
       
       JLabel type = new JLabel("country");
       type.setBounds(550,10,100,20);
       add(type);
       
       JLabel phone = new JLabel("Room number");
       phone.setBounds(650,10,100,20);
       add(phone);
       
       JLabel email= new JLabel("checkin time");
       email.setBounds(750,10,100,20);
       add(email);
       
       JLabel adhar = new JLabel("Deposit");
       adhar.setBounds(900,10,100,20);
       add(adhar);
       back = new JButton("Back");
       back.setForeground(Color.white);
       back.setBackground(Color.black);
       back.setBounds(420,500,100,30);
       back.addActionListener(this);
       add(back);
       
       table = new JTable();
       table.setBounds(0,40,1000,400);
       add(table);
       
       try{
           Conn conn = new Conn();
           String query ="select * from customer";
           ResultSet rs = conn.s.executeQuery(query);
           table.setModel(DbUtils.resultSetToTableModel(rs));
           
           
       }catch(Exception e){
           e.printStackTrace();
       }
       setBounds(300,200,1000,600);
       setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            new Reception();
        }
    }
    public static void main(String[] args){
     new Customerinfo();
}
}
