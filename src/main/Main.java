/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
/**
 *
 * @author Windyl
 */


public class Main extends Application {
     public static void main(String[] args) {
         Application.launch(args);
    }
     
     @Override
     public void start(Stage primaryStage) throws IOException{
         Parent parent = FXMLLoader.load(getClass().getResource("../resources/fxml/Login.fxml"));
         Scene scene = new Scene(parent);
         //Sets the main scene icon
         Image image_icon = new Image(getClass().getResourceAsStream("../resources/img/pos.png"));
         
         //Adds new icon near the title
         primaryStage.getIcons().add(image_icon);
         primaryStage.setTitle("Log in Form");
         primaryStage.setResizable(false);
         
         primaryStage.setScene(scene);
         primaryStage.show();
         
         
     }
    
}
