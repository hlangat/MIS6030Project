/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Raphael Charles Ndolo 636378
 */
public class DBConnect {
    private Connection con;
    private Statement st;
    private ResultSet result;
    
    //Constructor class
    public DBConnect(){
        try{
            //Load drivers
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/usiu_hostel", "root", "");
            st = con.createStatement();
        }catch(Exception e){
            System.out.println("Error: "+ e);
        }
    }
    
    public static void main(String args[]){
        DBConnect connection = new DBConnect();
    }
    
    public void login(String email, String password) throws SQLException{
        //JOptionPane.showMessageDialog(null, "Login Button Pressed!"+ password);
        if (email.equals("")) {
            JOptionPane.showMessageDialog (null, "Provide Username to Logon.");            
        }else if(password.equals("")){
            JOptionPane.showMessageDialog(null, "Provide Password to Logon.");
        }else{
            try{
                String query = "SELECT * FROM admin WHERE email = '" + email + "'"+"AND password = '"+ password +"'";
                result = st.executeQuery (query);
                if(result.next()){
                    JOptionPane.showMessageDialog(null, "Successful Login.");
                }else{
                    JOptionPane.showMessageDialog(null, "Invalid email or password!");
                }
            }catch(Exception e){
                
            }
            
        }
    }
}
