/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pathshapes;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;
import javafx.stage.Stage;

/**
 *
 * @author asusadmin
 */
public class PathShapes extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        
        MoveTo moveTo = new MoveTo(100, 150);
        QuadCurveTo quadCurveTo = new QuadCurveTo();
        quadCurveTo.setX(200);
        quadCurveTo.setY(150);
        quadCurveTo.setControlX(150);
        quadCurveTo.setControlY(50);
        Path path1 = new Path(moveTo, quadCurveTo);
        path1.setFill(Color.WHITE);
        path1.setStrokeWidth(3);
        
        MoveTo moveTo2 = new MoveTo(200, 150);
        LineTo lineTo1 = new LineTo(100, 150);
        LineTo lineTo2 = new LineTo(150, 275);
        LineTo lineTo3 = new LineTo(200, 150);
        Path path2 = new Path(moveTo2, lineTo1, lineTo2, lineTo3);
        path2.setFill(Color.GOLDENROD);
        path2.setStrokeWidth(3);
        
        
        root.getChildren().addAll(path1, path2);
        
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
