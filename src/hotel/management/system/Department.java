


package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.*;
import java.awt.event.*;
public class Department extends JFrame implements ActionListener {
    JTable table;
    JButton back;
    Department(){
        setLayout(null);
       JLabel roomno = new JLabel("Department");
       roomno.setBounds(180,10,100,20);
       add(roomno);
       
       JLabel available = new JLabel("Budget");
       available.setBounds(420,10,100,20);
       add(available);
       
    
       
       back = new JButton("Back");
       back.setForeground(Color.white);
       back.setBackground(Color.black);
       back.setBounds(200,400,100,30);
       back.addActionListener(this);
       add(back);
       
       table = new JTable();
       table.setBounds(0,40,700,350);
       add(table);
       
       try{
           Conn conn = new Conn();
           String query ="select * from department";
           ResultSet rs = conn.s.executeQuery(query);
           table.setModel(DbUtils.resultSetToTableModel(rs));
           
           
       }catch(Exception e){
           e.printStackTrace();
       }
       setBounds(400,200,700,480);
       setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            new Reception();
        }
    }
    public static void main(String[] args){
     new Department();
}
}

