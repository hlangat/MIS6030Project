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

public class Login extends JFrame{
    //Initializing Variables
    JFrame window;
    private JPanel panel;
    
    private JLabel lblUserName;
    private JLabel lblPassword; 
    
    private JTextField txtUserName;
    private JPasswordField txtPassword;
    
    private JButton cmdLogin;
    private JButton cmdCancel;
    
    //Constructor
    public Login(){
        //Initializing JFrame
        super("USIU Hostel Management System");
        window = new JFrame();
        window.setSize(800, 500);
        //window.setLayout(null);
        window.setVisible(true);
        window.setResizable(true);
        window.setLocation(250, 50);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Initializing JPanel
        panel = new JPanel();
        panel.setLayout(null);
        
        //Initializing Labels
        lblUserName = new JLabel("Email");
        lblUserName.setForeground (Color.blue);
        lblUserName.setBackground(Color.red);
        lblUserName.setBounds (100, 100, 75, 25);
        
        lblPassword = new JLabel("Password");
        lblPassword.setForeground (Color.blue);
        lblPassword.setBounds (100, 130, 75, 25);
        
        
        txtUserName = new JTextField();
        txtUserName.setBounds (200, 100, 175, 25);
        
        txtPassword = new JPasswordField();
        txtPassword.setBounds (200, 130, 175, 25);
        
        //Creating class for Action Listening
        ActionHandler handler = new ActionHandler();
        
        cmdLogin = new JButton("Login");
        cmdLogin.addActionListener(handler);
        cmdLogin.setBounds(100, 160, 75, 25);        
        
        cmdCancel = new JButton("Cancel");
        cmdCancel.addActionListener(handler);
        cmdCancel.setBounds(200, 160, 75, 25);
        
        window.add(panel);
        panel.add(cmdLogin);
        panel.add(cmdCancel);
        panel.add(lblUserName);
        panel.add(lblPassword);
        panel.add(txtUserName);
        panel.add(txtPassword);
        
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
