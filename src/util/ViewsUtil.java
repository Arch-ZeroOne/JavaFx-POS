/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Windyl
 */
public class ViewsUtil {
    
     
     public void transferWindow(String window, ActionEvent event) throws IOException{
            //gets the current stage 
        Stage current_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //get the fxml file to transfer to
        Parent root = FXMLLoader.load(getClass().getResource("../resources/fxml/"+window));
        
        //switches to the new scene
        Scene new_scene = new Scene(root);
        current_stage.setScene(new_scene);
        
        current_stage.show();
         
     }

    
}
