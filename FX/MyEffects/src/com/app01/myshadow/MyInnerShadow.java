/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app01.myshadow;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Denys.Prokopiuk
 */
public class MyInnerShadow  extends Application {
    
     @Override
    public void start(Stage primaryStage) {
        Group root = new Group();

        InnerShadow innerShadow = new InnerShadow();
        // shadow.setWidth(1);
        // shadow.setHeight(1);
        innerShadow.setOffsetX(-4);
        innerShadow.setOffsetX(-6);
        //innerShadow.setRadius(5);
        innerShadow.setColor(Color.RED);

        Text text = new Text(150, 150, "This is text");
        text.setFont(Font.font("Verbana", FontWeight.BOLD, 40));
        text.setEffect(innerShadow);
        root.getChildren().add(text);
        //root.setEffect(shadow);

        Rectangle rectangle = new Rectangle(10, 10, 100, 100);
        rectangle.setFill(Color.GREEN);
        rectangle.setEffect(innerShadow);
        root.getChildren().add(rectangle);
        
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
