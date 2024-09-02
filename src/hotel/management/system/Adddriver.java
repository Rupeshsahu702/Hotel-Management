package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.*;

public class Adddriver extends JFrame implements ActionListener {
    JButton add,cancel;
    JTextField tfname,tfage,tfcompany,tfmodel;
    JComboBox  availablecombo,gendercombo,bedcombo;
    JLabel lblname,lblavailable,lblage,lblgender,lblprice,lbltype;
    Adddriver(){
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel heading = new JLabel("ADD DRIVERS");
        heading.setFont(new Font("Tahoma",Font.BOLD,17));
        heading.setBounds(150,20,200,20);
        add(heading);
        
        lblname = new JLabel("Name");
        lblname.setFont(new Font("Tahoma",Font.PLAIN,14));
        lblname.setBounds(60,80,150,20);
        add(lblname); 
        
        tfname = new JTextField();
        tfname.setBounds(200, 80, 100, 30);
        add(tfname);
        
        lblage= new JLabel("AGE");
        lblage.setFont(new Font("Tahoma",Font.PLAIN,14));
        lblage.setBounds(60,130,120,20);
        add(lblage);
        
        tfage = new JTextField();
        tfage.setBounds(200, 130, 100, 30);
        add(tfage);
        
        lblgender= new JLabel("Gender");
        lblgender.setFont(new Font("Tahoma",Font.PLAIN,14));
        lblgender.setBounds(60,180,120,20);
        add(lblgender);
        
        String cleanoption[]={"Male","Female"};
        gendercombo = new JComboBox(cleanoption);
        gendercombo.setBounds(200,180,150,30);
        gendercombo.setBackground(Color.WHITE);
        add(gendercombo);
        
        lblprice = new JLabel("Car company");
        lblprice.setFont(new Font("Tahoma",Font.PLAIN,14));
        lblprice.setBounds(60,230,150,20);
        add(lblprice); 
        
        tfcompany = new JTextField();
        tfcompany.setBounds(200, 230, 100, 30);
        add(tfcompany);
                
        lbltype= new JLabel("Car Model");
        lbltype.setFont(new Font("Tahoma",Font.PLAIN,14));
        lbltype.setBounds(60,280,120,20);
        add(lbltype);
        
        tfmodel = new JTextField();
        tfmodel.setBounds(200, 280, 150, 30);
        add(tfmodel);
        
        lblavailable= new JLabel("Availability");
        lblavailable.setFont(new Font("Tahoma",Font.PLAIN,14));
        lblavailable.setBounds(60,330,120,20);
        add(lblavailable);
        
        String option[]={"Available","Not available"};
        availablecombo = new JComboBox(option);
        availablecombo.setBounds(200,330,150,30);
        availablecombo.setBackground(Color.WHITE);
        add(availablecombo);
        
        
        add = new JButton("ADD");
        add.setForeground(Color.white);
        add.setBackground(Color.BLACK);
        add.setBounds(60, 380, 100, 30);
        add.addActionListener(this);
        add(add);
        
        cancel = new JButton("CANCEL");
        cancel.setBounds(200, 380, 100, 30);
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450,50,500,300);
        add(image);
        
                
        setBounds(330,200,980,470);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add){
            String name = tfname.getText();
            String gender = (String)gendercombo.getSelectedItem();
            String age = tfage.getText();
            String company = tfcompany.getText();
            String type = tfmodel.getText();
            String availability = (String)availablecombo.getSelectedItem();
            
            try{
                Conn conn = new Conn();
                String str="insert into driver values('"+name+"','"+age+"','"+gender+"','"+company+"','"+type+"','"+availability+"')";
                conn.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"New Driver added succesfully");
                setVisible(false);
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource()==cancel){
            setVisible(false);
        }
    }
    public static void main(String[] args){
        new Adddriver();
    }
}

