package views;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Windyl
 */
import java.io.IOException;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class DashboardLoader extends Application{
     public static void main(String[] args) {
         Application.launch(args);
        
    }
     
     
     public void start(Stage primaryStage ) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("../resources/fxml/Dashboard.fxml"));
         Scene scene = new Scene(root);
         
         primaryStage.setScene(scene);
         primaryStage.setTitle("Dashboard");
         primaryStage.setResizable(false);
         primaryStage.show();
         
         
     }
    
}
