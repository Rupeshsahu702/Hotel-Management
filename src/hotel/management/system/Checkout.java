package hotel.management.system;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date.*;

public class Checkout extends JFrame implements ActionListener{
    Choice ccustomer;
    JLabel roomnumber,checkin,checkouttime;
    JButton checkoutb,back;
        
  Checkout(){
      setLayout(null);
      getContentPane().setBackground(Color.white);
      
      JLabel head = new JLabel("CHECK OUT");
      head.setBounds(100, 20, 150, 30);
      head.setForeground(Color.blue);
      head.setFont(new Font("Tahoma",Font.BOLD,20));
      add(head);
      
       JLabel lblid = new JLabel("Customer id");
      lblid.setBounds(30, 80, 100, 30);
      add(lblid);
      
        ccustomer = new Choice();
        ccustomer.setBounds(150, 80, 140, 30);
        add(ccustomer);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
        JLabel image = new JLabel(i1);
        image.setBounds(400,20,350,350);
        add(image);
      
        JLabel room = new JLabel("Room number");
        room.setBounds(30,130,100,30);
        add(room);
        
        roomnumber = new JLabel();
        roomnumber.setBounds(150,130,100,30);
        add(roomnumber);
        
         JLabel check = new JLabel("Checkin Time");
        check.setBounds(30,180,100,30);
        add(check);
        
        checkin = new JLabel();
        checkin.setBounds(150,180,100,30);
        add(checkin);
        
        JLabel checkout = new JLabel("Checkout Time");
        checkout.setBounds(30,230,100,30);
        add(checkout);
        
       java.util.Date date = new java.util.Date(); 
        
        checkouttime = new JLabel("" + date);
        checkouttime.setBounds(150,235,200,20);
        add(checkouttime);
        
        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from customer");
            
            while(rs.next()){
                ccustomer.add(rs.getString("number"));
                roomnumber.setText(rs.getString("room"));
                checkin.setText(rs.getString("time"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        checkoutb = new JButton("Check Out");
        checkoutb.setBounds(70, 300, 100, 20);
        checkoutb.setForeground(Color.WHITE);
        checkoutb.setBackground(Color.BLACK);
        checkoutb.addActionListener(this);
        add(checkoutb);
        
        back = new JButton("Back");
        back.setBounds(200, 300, 100, 20);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.addActionListener(this);
        add(back);
        
      setBounds(300,200,800,400);
      setVisible(true);
  }   
  public void actionPerformed(ActionEvent ae){
      if(ae.getSource()==checkoutb){
          String query = "delete from customer where number ='"+ ccustomer.getSelectedItem() +"'";
          String query2 = "update room set  availability ='Available' where roomnumber ='"+roomnumber.getText()+"'";
          try{
              Conn conn = new Conn();
              conn.s.executeUpdate(query);
              conn.s.executeUpdate(query2);
              JOptionPane.showMessageDialog(null,"CheckOut is completed");
              
          }catch(Exception e){
              e.printStackTrace();
          }
          new Reception();
          setVisible(false);
      }else if(ae.getSource()==back){
          new Reception();
          setVisible(false);
      }
  }
  
  public static void main(String[] args){
      new Checkout();
  }
}
