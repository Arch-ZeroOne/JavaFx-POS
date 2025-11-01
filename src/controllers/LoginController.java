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
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Hyperlink;
import util.ViewsUtil;
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
    @FXML
    Hyperlink gotoregister;
    @FXML

            
    
    UserDao dao = new UserDao();
    Alert success_alert = new Alert(AlertType.INFORMATION);
    Alert error_alert = new Alert(AlertType.ERROR);
    
    LocalDate date = LocalDate.now();
    DateTimeFormatter format = DateTimeFormatter.ofPattern("E, MMM dd yyyy");
    String formatted_date = date.format(format);
    LocalTime current_time = LocalTime.now();
    ViewsUtil view_util = new ViewsUtil();

    
   
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    month.setText(formatted_date);
    time.setText(String.valueOf(current_time.getHour()+":"+current_time.getMinute()+":"+current_time.getSecond()));
    current.setText(getCurrentDayTime(current_time));
    
   
         
    }

    public void login(ActionEvent event) throws SQLException, IOException{
        String user_name = username.getText();
        String pass_word = password.getText();
        
        if(dao.loginUser(user_name, pass_word)){
            success_alert.setHeaderText("User logged in!!");
            success_alert.setContentText("User has been logged in");
            //Sets the alert icon
            Image success_icon = new Image(getClass().getResourceAsStream("../resources/img/success.png"));
            Stage stage = (Stage) success_alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(success_icon);
            
            
            success_alert.showAndWait();
            
            goToDashboard(event);
            
            
  
           
            
        }else{
              //Sets the alert icon
            Image success_icon = new Image(getClass().getResourceAsStream("../resources/img/error.png"));
            Stage stage = (Stage) success_alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(success_icon);
            
            error_alert.setHeaderText("User Not Found");
            error_alert.setContentText("User has not been found please register");
            
          
            error_alert.showAndWait();
            
        }
        
        
    }
    
    
    public String getCurrentDayTime(LocalTime time){
      
      String[] split_time = String.valueOf(time).split(":");
      int current_time = Integer.parseInt(split_time[0]);
        

    if(current_time > 13 && current_time < 24){
        return "PM";
        
    }else if(current_time > 1 && current_time < 12){
        return "AM";
    }
    
       return null;
    }
    
    
    
    public void goToRegister(ActionEvent event) throws IOException{
             
        view_util.transferWindow("Register.fxml", event);
   
        
        
    }
    
     
    public void goToDashboard(ActionEvent event) throws IOException{
        
        view_util.transferWindow("Dashboard.fxml", event);
        
        
    }
    
    
    
    
    
}

