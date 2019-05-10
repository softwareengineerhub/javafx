/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textshape;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author asusadmin
 */
public class TextShape extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Text text = new Text(50, 100, "TEXT");
        text.setFont(Font.font("Verbana", FontWeight.BOLD, FontPosture.ITALIC, 50));
        //text.setStrikethrough(true);
        text.setFill(Color.RED);
        text.setStrokeWidth(2);
        text.setStroke(Color.DARKBLUE);
        text.setUnderline(true);
        root.getChildren().add(text);
        
        
        Scene scene = new Scene(root, 300, 250, Color.YELLOW);
        
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
