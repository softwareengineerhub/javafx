/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mylayouts.app02.hvpanel;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author Denys.Prokopiuk
 */
public class MyHBox extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(4);
        dropShadow.setOffsetY(6);
        dropShadow.setColor(Color.BLUE);

        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
      

        Circle circle = new Circle(50, Color.BLUE);
        circle.relocate(50, 50);

        Rectangle square = new Rectangle(100, 100, Color.RED);
        square.setArcWidth(30);
        square.setArcHeight(30);
        square.relocate(200, 50);

        hBox.getChildren().addAll(circle, square);
        hBox.setEffect(dropShadow);

        Scene scene = new Scene(hBox, 300, 250);

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
