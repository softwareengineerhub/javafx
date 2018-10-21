/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineshapes;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeLineCap;
import javafx.stage.Stage;

/**
 *
 * @author asusadmin
 */
public class LineShapes extends Application {

    @Override
    public void start(Stage primaryStage) {
        Line line1 = new Line(20, 30, 250, 30);
        line1.setStroke(Color.GREEN);
        line1.setStrokeWidth(10);
        
        Line line2 = new Line(20, 70, 250, 70);
        line2.setStroke(Color.BLUE);
        line2.setStrokeWidth(10);
        line2.setStrokeLineCap(StrokeLineCap.ROUND);
        
        
        Line line3 = new Line(20, 110, 250, 110);
        line3.setStroke(Color.RED);
        line3.setStrokeWidth(5);
        line3.getStrokeDashArray().addAll(20d, 10d);
        
        Group root = new Group();
        root.getChildren().addAll(line1, line2, line3);
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
