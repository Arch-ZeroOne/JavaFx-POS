/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.sql.SQLException;
import dao.UserDao;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Text;
/**
 * FXML Controller class
 *
 * @author Windyl
 */
public class LoginController implements Initializable {
    @FXML
    TextField username;
    @FXML
    PasswordField password;
    @FXML
    Text month;
    @FXML
    Text time;
    @FXML
    Text current;
            
    
    UserDao dao = new UserDao();
    Alert success_alert = new Alert(AlertType.INFORMATION);
    Alert error_alert = new Alert(AlertType.ERROR);
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    LocalDate date = LocalDate.now();
    DateTimeFormatter format = DateTimeFormatter.ofPattern("E, MMM dd yyyy");
    String formatted_date = date.format(format);
    LocalTime current_time = LocalTime.now();
    System.out.println(time);
    
   
   
    month.setText(formatted_date);
    time.setText(String.valueOf(current_time));
    current.setText(getCurrentDayTime(current_time));
    

         
    }

    public void login() throws SQLException{
        String user_name = username.getText();
        String pass_word = password.getText();
        
        if(dao.loginUser(user_name, pass_word)){
            success_alert.setHeaderText("User logged in!!");
            success_alert.setContentText("User has been logge in");
            success_alert.showAndWait();
            
        }else{
            error_alert.setHeaderText("User Not Found");
            error_alert.setContentText("User has not been found please register");
            error_alert.showAndWait();
            
        }
        
        
    }
    
    
    public String getCurrentDayTime(LocalTime time){
        
 
    if(time.equals(LocalTime.NOON)){
        return "PM";
        
    }else if(time.equals(LocalTime.MIDNIGHT)){
        return "AM";
    }
    
       return null;
    }
    
}

