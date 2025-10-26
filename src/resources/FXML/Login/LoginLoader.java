/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package resources.FXML.Login;

import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
/**
 *
 * @author Windyl
 */
public class LoginLoader extends Application {
     public static void main(String[] args) {
         Application.launch(args);
    }
     
     @Override
     public void start(Stage primaryStage) throws IOException{
         Parent parent = FXMLLoader.load(getClass().getResource("Login.fxml"));
         Scene scene = new Scene(parent);
         primaryStage.setScene(scene);
         primaryStage.show();
         
         
     }
    
}
