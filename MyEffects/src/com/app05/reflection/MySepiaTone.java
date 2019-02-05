/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app05.reflection;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.SepiaTone;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 *
 * @author Denys.Prokopiuk
 */
public class MySepiaTone extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        SepiaTone sepiaTone = new SepiaTone();         
        sepiaTone.setLevel(0.8);
        
        Image myImage = new Image("resources/my.jpeg");
        ImageView imageView = new ImageView(myImage);
        imageView.setFitWidth(630);
        imageView.setPreserveRatio(true);
        imageView.setEffect(sepiaTone);
                
        root.getChildren().add(imageView);
        
        Scene scene = new Scene(root, 630, 500);
        
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
