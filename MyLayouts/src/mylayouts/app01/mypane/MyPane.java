/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mylayouts.app01.mypane;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author Denys.Prokopiuk
 */
public class MyPane extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(4);
        dropShadow.setOffsetY(6);
        dropShadow.setColor(Color.BLUE);

        Pane pane = new Pane();
        pane.setPrefWidth(200);
        pane.setPrefHeight(200);

        Circle circle = new Circle(50, Color.BLUE);
        circle.relocate(50, 50);

        Rectangle square = new Rectangle(100, 100, Color.RED);
        square.setArcWidth(30);
        square.setArcHeight(30);
        square.relocate(200, 50);

        pane.getChildren().addAll(circle, square);
        pane.setEffect(dropShadow);

        Scene scene = new Scene(pane, 300, 250);

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
