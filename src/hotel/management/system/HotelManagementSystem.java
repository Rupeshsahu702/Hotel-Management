/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HotelManagementSystem extends JFrame implements ActionListener {
    HotelManagementSystem(){
        //setSize(1366,565);
        //setLocation(100,100);
        setBounds(100,100,1366,565);
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons//first.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0,0,1366,565);
        add(image);
        JLabel text = new JLabel("HOTEL MANAGEMENT SYSTEM");
        text.setBounds(20, 430, 1200,90 );
        text.setForeground(Color.WHITE);
        text.setFont(new Font("serif",Font.BOLD,50));
        image.add(text);
        
        JButton next = new JButton("Next");
        next.setBounds(1150,450,150,50);
         next.setBackground(Color.WHITE);
         next.setFont(new Font("serif",Font.BOLD,24));
         next.addActionListener(this);
        image.add(next);
        
        setVisible(true);
        while (true){
            text.setVisible(false);
            try{
                Thread.sleep(250);
            }catch( Exception e){
            e.printStackTrace();
            }
            text.setVisible(true);
            try{
                Thread.sleep(500);
            }catch( Exception e){
            e.printStackTrace();
            }
        }
            
        
    }
   
    public void actionPerformed(ActionEvent e){
        setVisible(false);
        new Login();
    
    }
    public static void main(String[] args) {
        new HotelManagementSystem();
        // TODO code application logic here
    }
    
}
