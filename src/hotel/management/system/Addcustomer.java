
package hotel.management.system;

import java.awt.Color;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;
import java.awt.event.*;
public class Addcustomer extends JFrame implements ActionListener {
    JRadioButton rbmale,rbfemale;
    JButton addcustomer, back;
    JTextField tfnumber,tfcountry,tfname,tfdeposit;
     JLabel checkintime;
     Choice croom;
     JComboBox idcombo;
    Addcustomer(){
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        JLabel form = new JLabel("NEW CUSTOMER FORM");
        form.setForeground(Color.BLUE);
        form.setFont(new Font("Tahoma",Font.PLAIN,25));
        form.setBounds(100,25,400,50);
        add(form);
        
        JLabel id = new JLabel("Customer ID");
        id.setBounds(30, 100, 100, 20);
        add(id);
        
        String optionid[] ={"Passport","Aadhaar card","Driving license","PAN Card","Voter id"};
        idcombo = new JComboBox(optionid);
        idcombo.setBounds(150,100,150,20);
        add(idcombo);
        
        JLabel number = new JLabel("Number");
        number.setBounds(30,140,100,20);
        add(number);
        
         tfnumber = new JTextField();
        tfnumber.setBounds(150,140,150,20);
        add(tfnumber);
        
        JLabel name = new JLabel("Name");
        name.setBounds(30,180,100,20);
        add(name);
        
        tfname = new JTextField();
        tfname.setBounds(150,180,150,20);
        add(tfname);
        
        JLabel lblgender = new JLabel("GENDER");
        lblgender.setBounds(30, 220, 70,30);
        add(lblgender);
        
        rbmale = new JRadioButton("Male");
        rbmale.setBounds(150, 220, 70, 30);
        rbmale.setBackground(Color.WHITE);
        add(rbmale);
        
        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(200, 220, 100, 30);
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);
        
        ButtonGroup gender = new ButtonGroup();
        gender.add(rbmale);
        gender.add(rbfemale);
        
        JLabel country = new JLabel("Country");
        country.setBounds(30,260,100,20);
        add(country);
        
        tfcountry = new JTextField();
        tfcountry.setBounds(150,260,150,20);
        add(tfcountry);
        
        JLabel room = new JLabel("Allocated Room");
        room.setBounds(30,300,100,20);
        add(room);
        
        croom = new Choice();
        try{
            Conn conn = new Conn();
            String query = "select * from room where availability = 'Available'";
            ResultSet rs = conn.s.executeQuery(query);
            while(rs.next()){
                croom.add(rs.getString("roomnumber"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        croom.setBounds(150,300,100,20);
        add(croom);
        
        JLabel checkin = new JLabel("CheckIN Time");
        checkin.setBounds(30,340,100,20);
        add(checkin);
        
        Date date = new Date(); 
        
        checkintime = new JLabel(""+date);
        checkintime.setBounds(150,340,150,20);
        add(checkintime);
        
        JLabel deposit = new JLabel("Deposit");
        deposit.setBounds(30,380,100,20);
        add(deposit);
        
        tfdeposit = new JTextField();
        tfdeposit.setBounds(150,380,150,20);
        add(tfdeposit);
        
        addcustomer = new JButton("Add customer");
        addcustomer.setBackground(Color.BLACK);
        addcustomer.setForeground(Color.white);
        addcustomer.setBounds(50,430,130,30);
        addcustomer.addActionListener(this);
        add(addcustomer);
        
        back= new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.setBounds(200,430,130,30);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
        Image i2 =i1.getImage().getScaledInstance(300,400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,50,300,400);
        add(image);
        
        setBounds(340 ,200,800,550);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
       if(ae.getSource()==addcustomer){
           String id = (String) idcombo.getSelectedItem();
           String number = tfnumber.getText();
           String name = tfname.getText();
           String gender = null;
           if(rbmale.isSelected()){
               gender = "Male";
           }else{
               gender ="Female";
           }
           String country = tfcountry.getText();
           String room = croom.getSelectedItem();
           String time =checkintime.getText();
           String deposit = tfdeposit.getText();
           try{
              Conn conn = new Conn();
              String query =" insert into customer values('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+time+"','"+deposit+"')";
              String query2 ="update room set availability = 'Occupied' where roomnumber = '"+room+"' ";
              
              conn.s.executeUpdate(query);
              conn.s.executeUpdate(query2);
              JOptionPane.showMessageDialog(null,"Customer details added successfully");
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
        new Addcustomer();
    }
    
}
