/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rectangleshapes;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author asusadmin
 */
public class RectangleShapes extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Rectangle rectangle1 = new Rectangle(20, 20, 90, 90);
        rectangle1.setFill(Color.BLUE);
        rectangle1.setStroke(Color.BLACK);
        rectangle1.setStrokeWidth(10);
        
        
        Rectangle rectangle2 = new Rectangle(150, 150, 90, 90);
        rectangle2.setFill(Color.YELLOW);
        rectangle2.setStroke(Color.BLACK);
        rectangle2.setStrokeWidth(10);
        rectangle2.setArcWidth(5);
        rectangle2.setArcHeight(5);
        
        root.getChildren().addAll(rectangle1, rectangle2);
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
