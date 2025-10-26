package util;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Windyl
 */
import java.sql.Connection;
import java.sql.DriverManager;
public class Util {
  
    private static final String URL = "jdbc:mysql://localhost:3306/pos_system";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    
    public Connection getConnection(){
        
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connection Established");
            return DriverManager.getConnection(URL,USER,PASSWORD);
            
        }catch(Exception e){
            e.printStackTrace();
        }
         
         
         return null;
         
     }
    
}
