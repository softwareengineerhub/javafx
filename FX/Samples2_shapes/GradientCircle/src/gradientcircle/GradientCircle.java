/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gradientcircle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 *
 * @author asusadmin
 */
public class GradientCircle extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Circle c1 = createCircle(60, 60, 50);
        Circle c2 = createCircle(170, 60, 50);
        Circle c3 = createCircle(300, 60, 50);
        
        root.getChildren().addAll(c1, c2, c3);
        //root.getChildren().addAll(c1);
        
        Scene scene = new Scene(root, 650, 500);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private Circle createCircle(double centerX, double centerY, double radius){
        Circle c = new Circle(centerX, centerY, radius, createGradient(centerX, centerY, radius));
        return c;
    }
    
    private RadialGradient createGradient(double centerX, double centerY, double radius){
        return new RadialGradient(
                0,
                0,
                centerX,
                centerY,                
                radius/2,
                false,
                CycleMethod.REFLECT,
                new Stop(0, Color.GREEN), new Stop(1, Color.WHITE));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

