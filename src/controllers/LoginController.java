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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Hyperlink;
import util.AlertUtil;
import util.DateUtil;
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
            
                
    ViewsUtil view_util = new ViewsUtil();
    AlertUtil alert_util = new AlertUtil();
    DateUtil date_util = new DateUtil();

         
    UserDao dao = new UserDao();
    

    
   
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    month.setText(date_util.getFormattedDate());
    time.setText(date_util.getCurrentTime());
    current.setText(date_util.getCurrentDayTime(LocalTime.MIN));
       
         
    }

    public void login(ActionEvent event) throws SQLException, IOException{
        String user_name = username.getText();
        String pass_word = password.getText();
        
        if(dao.loginUser(user_name, pass_word)){
            alert_util.showSucessAlert();
            goToDashboard(event);
         
        }
        
        
        alert_util.showErrorAlert();
            
        
        
       
    }
    
    

    
    public void goToRegister(ActionEvent event) throws IOException{
             
        view_util.transferWindow("Register.fxml", event);
       
    }
    
     
    public void goToDashboard(ActionEvent event) throws IOException{
        
        view_util.transferWindow("Dashboard.fxml", event);
        
        
    }
    
    
}

