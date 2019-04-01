/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

/**
 *
 * @author Raphael Charles Ndolo 636378
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;

public class Login extends JFrame{
    //Initializing Variables
    JFrame window;
    private JPanel panel;
    
    private ImageIcon image;
    private JLabel lblImage;
    private JLabel lblUserName;
    private JLabel lblPassword; 
    
    private JTextField txtUserName;
    private JPasswordField txtPassword;
    
    private JButton cmdLogin;
    private JButton cmdCancel;
    
    //Constructor
    public Login(){
        //Initializing JFrame
        window = new JFrame("USIU Hostel Management System");
        window.setSize(470, 600);
        
        
        //Initializing JPanel
        panel = new JPanel();
        panel.setLayout(null);
               
        //Initializing Labels
        lblUserName = new JLabel("Email Address");
        lblUserName.setForeground (Color.blue);
        lblUserName.setBackground(Color.red);
        lblUserName.setBounds (50, 450, 100, 25);
        
        lblPassword = new JLabel("Password");
        lblPassword.setForeground (Color.blue);
        lblPassword.setBounds (50, 480, 100, 25);
        
        image = new ImageIcon(getClass().getResource("Images/Students.jpg"));
        lblImage = new JLabel (image);
        Color cl = new Color (0, 0, 0);					//Setting Splash Window Border Color.
        lblImage.setBorder (new LineBorder (cl, 1));
        lblImage.setBounds(0,0,470,400);
        
        txtUserName = new JTextField();
        txtUserName.setBounds (180, 450, 200, 25);
        
        txtPassword = new JPasswordField();
        txtPassword.setBounds (180, 480, 200, 25);
        
        //Creating class for Action Listening
        ActionHandler handler = new ActionHandler();
        
        cmdLogin = new JButton("Login");
        cmdLogin.addActionListener(handler);
        cmdLogin.setBounds(50, 510, 100, 25);        
        
        cmdCancel = new JButton("Cancel");
        cmdCancel.addActionListener(handler);
        cmdCancel.setBounds(180, 510, 100, 25);
        
        window.add(panel);
        panel.add(lblImage);
        panel.add(cmdLogin);
        panel.add(cmdCancel);
        panel.add(lblUserName);
        panel.add(lblPassword);
        panel.add(txtUserName);
        panel.add(txtPassword);
        
        window.setVisible(true);
        window.setLayout(null);
        window.setResizable(true);
        window.setLocation(350, 50);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    private class ActionHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){
            //Determine which button was clicked.
            if(event.getSource()==cmdLogin){
                String uName = txtUserName.getText();
                String pWord = txtPassword.getText();
                
                try{
                    DBConnect conn = new DBConnect();
                    conn.login(uName, pWord);
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Error loading Database");
                }
                
            }else if(event.getSource()==cmdCancel){
                txtUserName.setText("");
                txtPassword.setText("");
                txtUserName.requestFocus();
            }
        }
    }
    //Main Method
    public static void main(String args[]){
        Login login = new Login();
    }
}
