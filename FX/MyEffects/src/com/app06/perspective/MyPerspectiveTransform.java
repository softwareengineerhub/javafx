/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app06.perspective;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.PerspectiveTransform;
import javafx.scene.effect.SepiaTone;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 *
 * @author Denys.Prokopiuk
 */
public class MyPerspectiveTransform extends Application {

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        SepiaTone sepiaTone = new SepiaTone();
        sepiaTone.setLevel(0.8);
        
        PerspectiveTransform perspective = new PerspectiveTransform();
        perspective.setUlx(50);
        perspective.setUly(100);
        perspective.setLlx(50);
        perspective.setLly(175);
        
        perspective.setUrx(400);
        perspective.setUry(50);
        
        perspective.setLrx(400);
        perspective.setLry(250);
        
        
        
        

        Image myImage = new Image("resources/my.jpeg");
        ImageView imageView = new ImageView(myImage);
        imageView.setFitWidth(630);
        imageView.setPreserveRatio(true);
        imageView.setEffect(sepiaTone);
        imageView.setEffect(perspective);

        root.getChildren().add(imageView);

        Scene scene = new Scene(root, 630, 500);

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
