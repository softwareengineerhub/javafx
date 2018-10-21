/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ellipsepoligonpoliline;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Polyline;
import javafx.stage.Stage;

/**
 *
 * @author asusadmin
 */
public class EllipsePoligonPoliline extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Ellipse ellipse = new Ellipse(100, 100, 40, 20);
        root.getChildren().add(ellipse);
        
        Polygon polygon = new Polygon(
                175, 45, 
                40, 50,
                65, 70
        );
        root.getChildren().add(polygon);
        
        Polyline polyline = new Polyline (
                175+100, 45+100, 
                40+100, 50+100,
                65+100, 70+100
        );
        polyline.setFill(Color.BLUE);
        root.getChildren().add(polyline);
        
        
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
