/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybasiccontrols.ch06.myscrollbar;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author Denys.Prokopiuk
 */
public class MyScrollBar extends Application {

    private final VBox vbox = new VBox(40);

    @Override
    public void start(Stage primaryStage) {
        
        final int offsetY = 6;
        final int sceneWidth = 450;
        final int sceneHeight = 350;
        
        ScrollBar hScroller = new ScrollBar();
        hScroller.setMin(0);
        hScroller.setMax(sceneWidth);
        hScroller.setPrefWidth(sceneWidth);
        
        ScrollBar vScroller = new ScrollBar();
        vScroller.setOrientation(Orientation.VERTICAL);
        vScroller.setMin(0);
        vScroller.setMax(sceneHeight);
        vScroller.setPrefHeight(sceneHeight);
        vScroller.setLayoutY(hScroller.getWidth()-offsetY);
        
        Image myImage = new Image("resources/Cyan.jpg");
        ImageView imageView = new ImageView(myImage);
        imageView.setPreserveRatio(true);
        
        VBox vbox = new VBox(imageView);
        Group root = new Group(vbox, vScroller, hScroller);
        
        Scene scene = new Scene(root, sceneWidth, sceneHeight);
        
        vbox.layoutYProperty().bind(vScroller.valueProperty().negate());
        vScroller.prefHeightProperty().bind(scene.heightProperty().subtract(2*offsetY));
        
        vbox.layoutXProperty().bind(hScroller.valueProperty().negate());
        hScroller.prefWidthProperty().bind(scene.widthProperty());        
        
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
