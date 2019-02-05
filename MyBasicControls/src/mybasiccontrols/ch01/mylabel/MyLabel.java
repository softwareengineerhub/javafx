/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybasiccontrols.ch01.mylabel;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author Denys.Prokopiuk
 */
public class MyLabel extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Label label = new Label("MyLable");
        label.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        label.setTextFill(Color.NAVY);
        label.setGraphic(new ImageView(new Image("resources/my.jpeg")));
        label.setGraphicTextGap(20);
        
        StackPane root = new StackPane();
        root.setStyle("-fx-background-color: red");
        
        root.getChildren().add(label);
        
        Scene scene = new Scene(root, 300, 250);
        
        
        label.opacityProperty().bind(scene.widthProperty().add(scene.heightProperty()).divide(1000));
        
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
