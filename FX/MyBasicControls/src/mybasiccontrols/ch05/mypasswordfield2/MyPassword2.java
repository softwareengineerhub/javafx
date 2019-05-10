/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybasiccontrols.ch05.mypasswordfield2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Denys.Prokopiuk
 */
public class MyPassword2 extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("./MyPassword2.fxml"));
        
        Scene scene = new Scene(root, 400, 230);
        stage.setScene(scene);
        stage.setTitle("PasswordField Control");
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
