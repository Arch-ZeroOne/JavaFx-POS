/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Windyl
 */
public class AlertUtil {
    Alert success_alert = new Alert(Alert.AlertType.INFORMATION);
    Alert error_alert = new Alert(Alert.AlertType.ERROR);
     
    
   public void showSucessAlert(){
         success_alert.setHeaderText("User logged in!!");
         success_alert.setContentText("User has been logged in");
               
        //Sets the alert icon
         Image success_icon = new Image(getClass().getResourceAsStream("../resources/img/success.png"));
         Stage stage = (Stage) success_alert.getDialogPane().getScene().getWindow();
         stage.getIcons().add(success_icon);
            
            
        success_alert.showAndWait();
            
           
   }
   
   
   public void showErrorAlert(){
          //Sets the alert icon
          Image error_icon = new Image(getClass().getResourceAsStream("../resources/img/error.png"));
          Stage stage = (Stage) error_alert.getDialogPane().getScene().getWindow();
          stage.getIcons().add(error_icon);
            
          error_alert.setHeaderText("User Not Found");
          error_alert.setContentText("User has not been found please register");
            
          
          error_alert.showAndWait();
   }
    
}
