package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;


import java.sql.*;
import net.proteanit.sql.*;
import java.awt.event.*;

public class Updateroom extends JFrame implements ActionListener{
    Choice ccustomer;
    JTextField tfroom,tfclean,tfavailable,tfpaid,tfpending;
    JButton check,update,back;
    Updateroom(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel lblupdate = new JLabel("Update Room Status");
        lblupdate.setBounds(40,20,300,30);
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
        
        JLabel lblavailable = new JLabel("availability");
        lblavailable.setBounds(30,160,100,20);
        add(lblavailable);
        
        tfavailable = new JTextField();
        tfavailable.setBounds(150, 160, 150, 20);
        add(tfavailable);
        
        JLabel checkin = new JLabel("Cleaning status");
        checkin.setBounds(30,190,100,20);
        add(checkin);
        
        tfclean = new JTextField();
        tfclean.setBounds(150, 190, 200, 20);
        add(tfclean);
        
        
        check = new JButton("Check");
        check.setForeground(Color.WHITE);
        check.setBackground(Color.BLACK);
        check.setBounds(30,300,70,20);
        check.addActionListener(this);
        add(check);
        
        update = new JButton("update");
        update.setForeground(Color.WHITE);
        update.setBackground(Color.BLACK);
        update.setBounds(120,300,100,20);
        update.addActionListener(this);
        add(update);
        
        back = new JButton("Back");
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.setBounds(250,300,70,20);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
   
        JLabel image = new JLabel(i3);
        image.setBounds(400,40,500,300);
        add(image);
        
        
        setBounds(300,200,980,450);
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
               }
               ResultSet rs2 = conn.s.executeQuery("select * from room where roomnumber = '"+tfroom.getText()+"'");
               while(rs2.next()){
                   tfavailable.setText(rs2.getString("availability"));
                   tfclean.setText(rs2.getString("status"));
                   
               }
               
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else if(ae.getSource()==update){
            String number = ccustomer.getSelectedItem();
            String room = tfroom.getText();
            String available= tfavailable.getText();
            String clean = tfclean.getText();
         
            try {
                Conn conn = new Conn();
                
                conn.s.executeUpdate("update room set roomnumber='"+room+"',availability ='"+available+"',status ='"+clean+"' where roomnumber ='"+room+"'");
                JOptionPane.showMessageDialog(null,"Room details updated");
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
        new Updateroom();
    }
}

