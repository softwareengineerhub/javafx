/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app01.myshadow;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.Shadow;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Denys.Prokopiuk
 */
public class MyShadow extends Application {

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();

        Shadow shadow = new Shadow();
       // shadow.setWidth(1);
       // shadow.setHeight(1);
        shadow.setRadius(5);

        
        Text text = new Text(150, 150, "This is text");
        text.setFont(Font.font("Verbana", FontWeight.BOLD, 40));
        text.setEffect(shadow);
        root.getChildren().add(text);
        //root.setEffect(shadow);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
