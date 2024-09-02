/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;

/**
 *
 * @author rupesh kumar sahu
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Dashboard  extends JFrame implements ActionListener{
   
    Dashboard(){
        setBounds(0,0,1550,1000);
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550, 1000, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1550, 1000);
        add(image);
        
        JLabel text = new JLabel("THE TAJ GROUPS WELCOMES YOU");
        text.setBounds(400,80,1000,50);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Tahoma",Font.PLAIN,46));
        image.add(text);
        
        JMenuBar mb = new JMenuBar();
        mb.setBounds(0,0,1550,30);
        image.add(mb);
        
        JMenu hotel = new JMenu("HOTEL MANAGEMNET");
        hotel.setForeground(Color.RED);
        mb.add(hotel);
        
        JMenuItem reception = new JMenuItem("RECEPTION");
        reception.addActionListener(this);
        hotel.add(reception);
        
        JMenu admin = new JMenu("ADMIN");
        admin.setForeground(Color.blue);
        mb.add(admin);
        
        JMenuItem employee = new JMenuItem("ADD EMPLOYEE");
        employee.addActionListener(this);
        admin.add(employee);
        
        JMenuItem DRIVER = new JMenuItem("ADD DRIVERS");
        DRIVER.addActionListener(this);
        admin.add(DRIVER);
        
        JMenuItem ROOMS = new JMenuItem("ADD ROOMS");
        ROOMS.addActionListener(this);
        admin.add(ROOMS);
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("ADD EMPLOYEE")){
        new Addemployee();
    }else if(ae.getActionCommand().equals("ADD ROOMS")){
        new Addrooms();
        }else if(ae.getActionCommand().equals("ADD DRIVERS")){
            new Adddriver();
        }else if(ae.getActionCommand().equals("RECEPTION")){
            new Reception();
        }
            
    }
    public static void main(String[] args){
        new Dashboard();
        
    }
    
}
