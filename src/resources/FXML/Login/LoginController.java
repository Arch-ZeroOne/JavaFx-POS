/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package resources.FXML.Login;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.sql.SQLException;
import dao.UserDao;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
    UserDao dao = new UserDao();
    Alert success_alert = new Alert(AlertType.INFORMATION);
    Alert error_alert = new Alert(AlertType.ERROR);
    
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
    
        
        
    
}

