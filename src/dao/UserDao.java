/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import util.DatabaseUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;


/**
 *
 * @author Windyl
 */
public class UserDao {
    private final DatabaseUtil util = new DatabaseUtil();
    private final Connection connection =  util.getConnection();
    
    
    public boolean registerUser(String email, String password, String role) throws SQLException{
        String query = "INSERT INTO user (email, password, role, createdAt) VALUES (?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(query);
       
        Date now = new Date();
        java.sql.Date sql_date = new java.sql.Date(now.getTime());
  
        statement.setString(1, email);
        statement.setString(2, password);
        statement.setString(3, role);
        statement.setDate(4, sql_date);
        
     
      
        int rowsAffected = statement.executeUpdate();
        
        if(rowsAffected > 0){
            //returns true if the user is inserted
            return true;
            
        }
        
        //returns false by default if a user is not successfully registered
        return false;
        
        
        
    }
    
    
    public boolean loginUser(String email , String password) throws SQLException{
         String query = "SELECT * FROM user WHERE email = ? AND password = ?";
         PreparedStatement statement = connection.prepareStatement(query);
         statement.setString(1, email);
         statement.setString(2, password);
         ResultSet result = statement.executeQuery();
         
         if(result.next()){
      
            
             
             
             return true;
             
             
         }
         
         
        
        
        return false;
        
        
    }
    
}
