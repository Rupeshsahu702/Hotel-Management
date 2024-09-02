package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.*;

public class Addrooms extends JFrame implements ActionListener {
    JButton add,cancel;
    JTextField tfroom,tfprice;
    JComboBox  availablecombo,cleancombo,bedcombo;
    JLabel lblroomno,lblavailable,lblclean,lblprice,lbltype;
    Addrooms(){
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel heading = new JLabel("ADD ROOMS");
        heading.setFont(new Font("Tahoma",Font.BOLD,17));
        heading.setBounds(150,20,200,20);
        add(heading);
        
        lblroomno = new JLabel("ROOM NUMBER");
        lblroomno.setFont(new Font("Tahoma",Font.PLAIN,14));
        lblroomno.setBounds(60,80,150,20);
        add(lblroomno); 
        
        tfroom = new JTextField();
        tfroom.setBounds(200, 80, 100, 30);
        add(tfroom);
        
        lblavailable= new JLabel("AVAILABLE");
        lblavailable.setFont(new Font("Tahoma",Font.PLAIN,14));
        lblavailable.setBounds(60,130,120,20);
        add(lblavailable);
        
        String availableoption[]={"Available","occupied"};
        availablecombo = new JComboBox(availableoption);
        availablecombo.setBounds(200,130,150,30);
        availablecombo.setBackground(Color.WHITE);
        add(availablecombo);
        
        lblclean= new JLabel("Cleaning status");
        lblclean.setFont(new Font("Tahoma",Font.PLAIN,14));
        lblclean.setBounds(60,180,120,20);
        add(lblclean);
        
        String cleanoption[]={"Clean","Dirty"};
        cleancombo = new JComboBox(cleanoption);
        cleancombo.setBounds(200,180,150,30);
        cleancombo.setBackground(Color.WHITE);
        add(cleancombo);
        
        lblprice = new JLabel("ROOM PRICE");
        lblprice.setFont(new Font("Tahoma",Font.PLAIN,14));
        lblprice.setBounds(60,230,150,20);
        add(lblprice); 
        
        tfprice = new JTextField();
        tfprice.setBounds(200, 230, 100, 30);
        add(tfprice);
                
        lbltype= new JLabel("Bed type");
        lbltype.setFont(new Font("Tahoma",Font.PLAIN,14));
        lbltype.setBounds(60,280,120,20);
        add(lbltype);
        
        String bedoption[]={"Single Bed","Double Bed"};
        bedcombo = new JComboBox(bedoption);
        bedcombo.setBounds(200,280,150,30);
        bedcombo.setBackground(Color.WHITE);
        add(bedcombo);
        
        add = new JButton("ADD");
        add.setForeground(Color.white);
        add.setBackground(Color.BLACK);
        add.setBounds(60, 360, 100, 30);
        add.addActionListener(this);
        add(add);
        
        cancel = new JButton("CANCEL");
        cancel.setBounds(200, 360, 100, 30);
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(450,50,350,350);
        add(image);
        
                
        setBounds(330,200,940,470);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add){
            String roomnumber = tfroom.getText();
            String availability = (String)availablecombo.getSelectedItem();
            String clean = (String)cleancombo.getSelectedItem();
            String price = tfprice.getText();
            String type = (String)bedcombo.getSelectedItem();
                    
            try{
                Conn conn = new Conn();
                String str="insert into room values('"+roomnumber+"','"+availability+"','"+clean+"','"+price+"','"+type+"')";
                conn.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"New Room added succesfully");
                setVisible(false);
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource()==cancel){
            setVisible(false);
        }
    }
    public static void main(String[] args){
        new Addrooms();
    }
}
