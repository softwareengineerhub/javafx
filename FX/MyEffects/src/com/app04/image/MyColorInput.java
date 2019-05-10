/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app04.image;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Denys.Prokopiuk
 */
public class MyColorInput extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        ColorAdjust colorAdjust = new ColorAdjust();
        colorAdjust.setHue(-0.05);
        colorAdjust.setContrast(0.1);
        colorAdjust.setBrightness(0.9);
        colorAdjust.setSaturation(0.2);
        
        Image myImage = new Image("resources/my.jpeg");
        ImageView imageView = new ImageView(myImage);
        imageView.setFitWidth(630);
        imageView.setPreserveRatio(true);
        imageView.setEffect(colorAdjust);
                
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
