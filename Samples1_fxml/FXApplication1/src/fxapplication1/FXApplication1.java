/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxapplication1;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author asusadmin
 */
public class FXApplication1 extends Application {
    
    @Override
    public void start(Stage primaryStage) {        
        //Group group = new Group();
        StackPane root = new StackPane();
        
        
        DropShadow dropShadow = new DropShadow();
        dropShadow.setColor(Color.BLUE);
        dropShadow.setOffsetX(3.0);
        
        Rectangle rectangle = new Rectangle(400, 60, Color.YELLOW);
        rectangle.setArcHeight(20);
        rectangle.setArcWidth(20);
        rectangle.setEffect(dropShadow);
        
        Text text = new Text("Text");
        text.setFill(Color.RED);
        text.setFont(Font.font(null, FontWeight.BOLD, 32));
        text.setEffect(dropShadow);
        
        root.getChildren().addAll(rectangle, text);
        
        FadeTransition fade = new FadeTransition(Duration.seconds(1.5), text);
        fade.setFromValue(1.0);
        fade.setToValue(0);
        fade.setCycleCount(Animation.INDEFINITE);
        fade.setAutoReverse(true);
        fade.play();
        
        
        
        
        
        Scene scene = new Scene(root, 300, 250, Color.LIGHTGREEN);
        
        primaryStage.setTitle("Hello from JavaFX!");
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
