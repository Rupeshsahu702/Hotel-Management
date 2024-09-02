
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.*;
import java.awt.event.*;

public class Searchroom extends JFrame implements ActionListener{
    JButton back,search;
    JTable table;
    JComboBox bedchoice;
    JCheckBox availability;
    Searchroom(){
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        JLabel heading = new JLabel("SEARCH ROOM");
        heading.setFont(new Font("Tahoma",Font.BOLD,50));
        heading.setForeground(Color.BLUE);
        heading.setBounds(320,10,400,50);
        add(heading);
        

        String bedtype[] = {"Single Bed","Double Bed","King size Bed","Queen size bed"};
   
        bedchoice = new JComboBox(bedtype);
        bedchoice.setBounds(130, 90, 150, 20);
        add(bedchoice);
        
        
        JLabel bed = new JLabel("Bed Type");
        bed.setBounds(40, 90, 100, 20);
        add(bed);
        
        JLabel roomno = new JLabel("Room Number");
       roomno.setBounds(10,170,100,20);
       add(roomno);
       
       JLabel available = new JLabel("Availability");
       available.setBounds(230,170,100,20);
       add(available);
       
       JLabel status = new JLabel("Status");
       status.setBounds(450,170,100,20);
       add(status);
       
       JLabel price = new JLabel("Price");
       price.setBounds(700,170,100,20);
       add(price);
       
       JLabel type = new JLabel("Type");
       type.setBounds(850,170,100,20);
       add(type);
       
       availability = new JCheckBox("Only display Available");
       availability.setBackground(Color.white);
       availability.setBounds(700,90,200,20);
       add(availability);
       
       back = new JButton("Back");
       back.setForeground(Color.white);
       back.setBackground(Color.black);
       back.setBounds(200,500,100,30);
       back.addActionListener(this);
       add(back);
       
       search = new JButton("Search");
       search.setForeground(Color.white);
       search.setBackground(Color.black);
       search.setBounds(450,140,100,20);
       search.addActionListener(this);
       add(search);
       
       table = new JTable();
       table.setBounds(0,200,1000,400);
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
        if(ae.getSource()==search){
            try{
                String type = (String) bedchoice.getSelectedItem();
                
                String query ="select * from room where type='"+type+"'";
                String query2 ="select * from room where availability ='Available' AND type ='"+type+"'";
                
                Conn conn = new Conn();
                ResultSet rs ;
                if(availability.isSelected()){
                    rs = conn.s.executeQuery(query2);
                }else{
                    rs = conn.s.executeQuery(query);
                }
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource()==back){
            setVisible(false);
            new Reception();
        }
        
    }
    public static void main(String[] args){
     new Searchroom();   
    }
    
}
