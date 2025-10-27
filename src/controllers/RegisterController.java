/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.SQLException;
import dao.UserDao;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * FXML Controller class
 *
 * @author Windyl
 */
public class RegisterController implements Initializable {
    @FXML
    TextField email;
    @FXML
    PasswordField password;
    @FXML
    ComboBox<String> role; 
    private final UserDao user_dao = new UserDao();
    Alert alert = new Alert(AlertType.INFORMATION);
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Creates the values for the combo box
        ObservableList<String> observable_list = FXCollections.observableArrayList("Admin","User");
        
        //Adds the roles to the role combo box
        role.setItems(observable_list);
        
        //Sets the first item as the default value
        role.getSelectionModel().selectFirst();
    }

    public void registerUser(ActionEvent event) throws SQLException {
        String user_name = email.getText();
        String pass_word = password.getText();
        String user_role = role.getValue();
        
        if(user_dao.registerUser(user_name, pass_word, user_role)){
            alert.setTitle("User Registered");
            alert.setContentText("New User "+user_name+" has been successfully registered");
            alert.showAndWait();
           
            //Resets only the email and password since role field is a dropdown
            email.setText("");
            password.setText("");
           
            
        }
    }    
    
}
