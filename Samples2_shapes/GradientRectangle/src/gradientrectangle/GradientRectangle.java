/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gradientrectangle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author asusadmin
 */
public class GradientRectangle extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Rectangle r1 = createRectangle(10, 10, 100, 50);
        Rectangle r2 = createRectangle(110, 110, 100, 50);
        Rectangle r3 = createRectangle(220, 220, 100, 50);
        
        root.getChildren().addAll(r1, r2, r3);
        
        Scene scene = new Scene(root, 400, 450);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private Rectangle createRectangle(int x, int y, int w, int h) {
        Rectangle rectangle = new Rectangle(x, y, w, h);
        rectangle.setFill(createLinearGradient(x, y, w, h));
        return rectangle;
    }
    
    private LinearGradient createLinearGradient(int x, int y, int w, int h){
        LinearGradient gradient = new LinearGradient(
                x, 
                y, 
                w+x, 
                h+y, 
                false, 
                CycleMethod.REFLECT, 
                new Stop(0, Color.CYAN), new Stop(1, Color.YELLOW));
        return gradient;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
