/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arc_quadcurve_cubiccurve;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.QuadCurve;
import javafx.stage.Stage;

/**
 *
 * @author asusadmin
 */
public class Arc_QuadCurve_CubicCurve extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        
        Arc arc = new Arc(40, 60, 30, 30, 30, 100);
        //root.getChildren().add(arc);
        
        QuadCurve quadCurve = new QuadCurve();
        quadCurve.setStartX(100);
        quadCurve.setStartY(125);
        quadCurve.setEndX(200);
        quadCurve.setEndY(125);
        quadCurve.setControlX(150);
        quadCurve.setControlY(25);        
        quadCurve.setFill(Color.RED);
        //root.getChildren().add(quadCurve);
        
        CubicCurve cubicCurve = new CubicCurve();
        cubicCurve.setStartX(100);
        cubicCurve.setStartY(125);
        cubicCurve.setEndX(300);
        cubicCurve.setEndY(125);
        cubicCurve.setControlX1(150);
        cubicCurve.setControlY1(25);
        cubicCurve.setControlX2(250);
        cubicCurve.setControlY2(370);
        cubicCurve.setFill(Color.RED);
        root.getChildren().add(cubicCurve);
        
        Scene scene = new Scene(root, 400, 350);
        
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
