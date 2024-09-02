package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;


import java.sql.*;
import net.proteanit.sql.*;
import java.awt.event.*;

public class Updatecheck extends JFrame implements ActionListener{
    Choice ccustomer;
    JTextField tfroom,tfcheckin,tfname,tfpaid,tfpending;
    JButton check,update,back;
    Updatecheck(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel lblupdate = new JLabel("Update Status");
        lblupdate.setBounds(90,20,200,30);
        lblupdate.setForeground(Color.BLUE);
        lblupdate.setFont(new Font("Tahoma",Font.BOLD,20));
        add(lblupdate);
        
        JLabel lblid = new JLabel("Customer id");
        lblid.setBounds(30,90,100,20);
        add(lblid);
        
        ccustomer = new Choice();
        ccustomer.setBounds(150, 90, 150, 25);
        add(ccustomer);
        
        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from customer");
            while(rs.next()){
                ccustomer.add(rs.getString("number"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JLabel roomno = new JLabel("Room number");
        roomno.setBounds(30,130,100,20);
        add(roomno);
        
        tfroom = new JTextField();
        tfroom.setBounds(150, 130, 100, 20);
        add(tfroom);
        
        JLabel name = new JLabel("Name");
        name.setBounds(30,160,100,20);
        add(name);
        
        tfname = new JTextField();
        tfname.setBounds(150, 160, 150, 20);
        add(tfname);
        
        JLabel checkin = new JLabel("Checkin Time");
        checkin.setBounds(30,190,100,20);
        add(checkin);
        
        tfcheckin = new JTextField();
        tfcheckin.setBounds(150, 190, 200, 20);
        add(tfcheckin);
        
        JLabel paid = new JLabel("Amount Paid");
        paid.setBounds(30,220,100,20);
        add(paid);
        
        tfpaid = new JTextField();
        tfpaid.setBounds(150, 220, 150, 20);
        add(tfpaid);
        
        JLabel pending = new JLabel("Pending Amount");
        pending.setBounds(30,250,100,20);
        add(pending);
        
        tfpending = new JTextField();
        tfpending.setBounds(150, 250, 150, 20);
        add(tfpending);
        
        check = new JButton("Check");
        check.setForeground(Color.WHITE);
        check.setBackground(Color.BLACK);
        check.setBounds(30,340,70,20);
        check.addActionListener(this);
        add(check);
        
        update = new JButton("update");
        update.setForeground(Color.WHITE);
        update.setBackground(Color.BLACK);
        update.setBounds(120,340,100,20);
        update.addActionListener(this);
        add(update);
        
        back = new JButton("Back");
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.setBounds(250,340,70,20);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(500,40,400,350);
        add(image);
        
        
        setBounds(300,200,980,500);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==check){
            String id =ccustomer.getSelectedItem();
            String query="select * from customer where number = '"+id+"'";
            try{
               Conn conn = new Conn();
               ResultSet rs = conn.s.executeQuery(query);
               while(rs.next()){
                   tfroom.setText(rs.getString("room"));
                   tfname.setText(rs.getString("name"));
                   tfcheckin.setText(rs.getString("time"));
                   tfpaid.setText(rs.getString("deposit"));
                   
               }
               ResultSet rs2 = conn.s.executeQuery("select * from room where roomnumber = '"+tfroom.getText()+"'");
               while(rs2.next()){
                   String price = rs2.getString("price");
                   int amountpaid = Integer.parseInt(price)-Integer.parseInt(tfpaid.getText());
                   tfpending.setText(""+amountpaid);
               }
               
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else if(ae.getSource()==update){
            String number = ccustomer.getSelectedItem();
            String room = tfroom.getText();
            String name = tfname.getText();
            String time = tfcheckin.getText();
            String deposit = tfpaid.getText();
            try {
                Conn conn = new Conn();
                
                conn.s.executeUpdate("update customer set room='"+room+"',name ='"+name+"',time ='"+time+"',number ='"+number+"',deposit ='"+deposit+"' where number ='"+number+"'");
                JOptionPane.showMessageDialog(null,"Customer details updated");
                setVisible(false);
                new Reception();
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource()==back){
            setVisible(false);
            new Reception();
        }
    }
    public static void main(String[] args){
        new Updatecheck();
    }
}
