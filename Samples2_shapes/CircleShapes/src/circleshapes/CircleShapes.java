/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circleshapes;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 *
 * @author asusadmin
 */
public class CircleShapes extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        int radius = 40;
        
        Circle circle1 = new Circle(40, 40, radius, Color.RED);
        circle1.setStroke(Color.BLACK);
        circle1.setStrokeWidth(10);
        
        Circle circle2 = new Circle(140, 140, radius, Color.YELLOW);
        circle2.setStroke(Color.BLACK);
        circle2.setStrokeWidth(10);
        
        
        Circle circle3 = new Circle(200, 200, radius, Color.GREEN);
        circle3.setStroke(Color.BLACK);
        circle3.setStrokeWidth(10);
        
        Group root = new Group();
        root.getChildren().addAll(circle1, circle2, circle3);
        
        
        
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
