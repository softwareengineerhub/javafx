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
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Denys.Prokopiuk
 */
public class MyReflection extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        
        Reflection reflection = new Reflection();
        reflection.setFraction(0.7);
        reflection.setTopOffset(20);
        reflection.setTopOpacity(0.5);
        reflection.setBottomOpacity(0.2);
        
        Text text = new Text(100, 100, "This is text");        
        text.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 40));
        text.setFill(Color.DARKGREEN);
        text.setEffect(reflection);
        root.getChildren().add(text);
        
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
