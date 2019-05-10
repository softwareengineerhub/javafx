/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app03.mylighting;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Denys.Prokopiuk
 */
public class MySpotLight extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        
        Light.Spot spotLight = new Light.Spot(200, 125, 50, 1, Color.BLUE);
        spotLight.setPointsAtX(200);
        spotLight.setPointsAtY(125);
        spotLight.setPointsAtZ(10);
        
        Lighting lighting = new Lighting(spotLight);
        lighting.setSurfaceScale(5);
        lighting.setSpecularExponent(5);
        lighting.setSpecularConstant(2);
        
        Text text = new Text(80, 270, "Point Light");
        text.setFont(Font.font("Tahoma", FontWeight.BOLD, 60));
        text.setFill(Color.YELLOW);
        text.setEffect(lighting);
        
        Circle circle = new Circle(250, 250, 200, Color.RED);
        circle.setEffect(lighting);
        
        root.getChildren().addAll(circle, text);
        
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
