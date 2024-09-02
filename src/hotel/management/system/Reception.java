
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Reception extends  JFrame implements ActionListener{
    JButton newcustomer,rooms,Department,allemployee,customerinfo,managerinfo,checkout,updatestatus,updateroom,pickup,searchroom,logout;
    Reception(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        newcustomer = new JButton("New Customer form");
        newcustomer.setBounds(20,30,200,30);
        newcustomer.setBackground(Color.black);
        newcustomer.setForeground(Color.WHITE);
        newcustomer.addActionListener(this);
        add(newcustomer);
        
        rooms = new JButton("Rooms");
        rooms.setBounds(20,70,200,30);
        rooms.setBackground(Color.black);
        rooms.setForeground(Color.WHITE);
        rooms.addActionListener(this);
        add(rooms);
        
        Department = new JButton("Department");
        Department.setBounds(20,110,200,30);
        Department.setBackground(Color.black);
        Department.setForeground(Color.WHITE);
        Department.addActionListener(this);
        add(Department);
        
        allemployee = new JButton("All employee");
        allemployee.setBounds(20,150,200,30);
        allemployee.setBackground(Color.black);
        allemployee.setForeground(Color.WHITE);
        allemployee.addActionListener(this);
        add(allemployee);
        
        customerinfo = new JButton("Customer info");
        customerinfo.setBounds(20,190,200,30);
        customerinfo.setBackground(Color.black);
        customerinfo.setForeground(Color.WHITE);
        customerinfo.addActionListener(this);
        add(customerinfo);
        
        managerinfo = new JButton("Manager info");
        managerinfo.setBounds(20,230,200,30);
        managerinfo.setBackground(Color.black);
        managerinfo.setForeground(Color.WHITE);
        managerinfo.addActionListener(this);
        add(managerinfo);
        
        
        checkout = new JButton("Check Out");
        checkout.setBounds(20,270,200,30);
        checkout.setBackground(Color.black);
        checkout.setForeground(Color.WHITE);
        checkout.addActionListener(this);
        add(checkout);
        
        updatestatus = new JButton("Update Status");
        updatestatus.setBounds(20,310,200,30);
        updatestatus.setBackground(Color.black);
        updatestatus.setForeground(Color.WHITE);
        updatestatus.addActionListener(this);
        add(updatestatus);
        
        updateroom = new JButton("Update Room Status");
        updateroom.setBounds(20,350,200,30);
        updateroom.setBackground(Color.black);
        updateroom.setForeground(Color.WHITE);
        updateroom.addActionListener(this);
        add(updateroom);
       
         pickup= new JButton("Pickup Service");
        pickup.setBounds(20,390,200,30);
        pickup.setBackground(Color.black);
        pickup.setForeground(Color.WHITE);
        pickup.addActionListener(this);
        add(pickup);
        
        searchroom = new JButton("Search Room");
        searchroom.setBounds(20,430,200,30);
        searchroom.setBackground(Color.black);
        searchroom.setForeground(Color.WHITE);
        searchroom.addActionListener(this);
        add(searchroom);
        
        logout = new JButton("Logout");
        logout.setBounds(20,470,200,30);
        logout.setBackground(Color.black);
        logout.setForeground(Color.WHITE);
        logout.addActionListener(this);
        add(logout);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
       
        JLabel image = new JLabel(i1);
        image.setBounds(250, 20, 500, 470);
        add(image);
        
        setBounds(350,200,800,570);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==newcustomer){
            setVisible(false);
            new Addcustomer();
        }else if(ae.getSource()==rooms){
            new Room();
            setVisible(false);
        }else if(ae.getSource()==Department){
            new Department();
            setVisible(false);
        }else if (ae.getSource()==allemployee){
            new Employeeinfo();
            setVisible(false);
        }else if (ae.getSource()==customerinfo){
            new Customerinfo();
            setVisible(false);
        }else if (ae.getSource()==managerinfo){
            new Managerinfo();
            setVisible(false);
        }else if(ae.getSource()==searchroom){
            new Searchroom();
            setVisible(false);
        }else if(ae.getSource()==updatestatus){
            new Updatecheck();
            setVisible(false);
        }else if(ae.getSource()==updateroom){
            new Updateroom();
            setVisible(false);
        }else if(ae.getSource()==pickup){
            new Pickup();
            setVisible(false);
        }else if(ae.getSource()==checkout){
            new Checkout();
            setVisible(false);
        }else if(ae.getSource()==logout){
            setVisible(false);
            System.exit(0);
        }
    }
    public static void main(String[] args){
        new Reception();
    }
}
