
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.*;
import java.awt.event.*;

public class Pickup extends JFrame implements ActionListener{
    JButton back,search;
    JTable table;
    JCheckBox availability;
    Choice carchoice;
    Pickup(){
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        JLabel heading = new JLabel("PICKUP SERVICE");
        heading.setFont(new Font("Tahoma",Font.BOLD,50));
        heading.setForeground(Color.BLUE);
        heading.setBounds(320,10,400,50);
        add(heading);
        

   
        carchoice = new Choice();
        carchoice.setBounds(130, 90, 150, 20);
        add(carchoice);
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from driver");
            while(rs.next()){
                carchoice.add(rs.getString("car_company"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JLabel bed = new JLabel("CAR Type");
        bed.setBounds(40, 90, 100, 20);
        add(bed);
        
        JLabel roomno = new JLabel("Name");
       roomno.setBounds(30,170,100,20);
       add(roomno);
       
       JLabel available = new JLabel("Age");
       available.setBounds(230,170,100,20);
       add(available);
       
       JLabel status = new JLabel("Gender");
       status.setBounds(380,170,100,20);
       add(status);
       
       JLabel price = new JLabel("Brand");
       price.setBounds(550,170,100,20);
       add(price);
       
       JLabel model = new JLabel("Model");
       model.setBounds(700,170,100,20);
       add(model);
       
       JLabel type = new JLabel("availability");
       type.setBounds(850,170,100,20);
       add(type);
       
       
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
           String query ="select * from driver";
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
                String type = (String) carchoice.getSelectedItem();
                String query ="select * from driver where car_company ='"+type+"'";
                Conn conn = new Conn();
                ResultSet rs = conn.s.executeQuery(query);
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
     new Pickup();   
    }
    
}

