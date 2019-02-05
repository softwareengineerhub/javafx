/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mylayouts.app03.mytilepane;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author Denys.Prokopiuk
 */
public class MyTilePane extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Color colors[] = {Color.ORANGE, Color.BLACK, Color.RED, Color.PINK, Color.WHITE, Color.GREEN, Color.CYAN, Color.BLUE};

        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(4);
        dropShadow.setOffsetY(6);
        dropShadow.setColor(Color.BLUE);

        TilePane tilePane = new TilePane(Orientation.HORIZONTAL);
        //each tile has equal size
        tilePane.setPadding(new Insets(50, 50, 50, 50));
        //tilePane.setBorder(new Border(BorderStroke.THICK));
        tilePane.setHgap(25);
        tilePane.setVgap(25);
        tilePane.setAlignment(Pos.CENTER);

        
        tilePane.setEffect(dropShadow);

        for (int i = 0; i < colors.length; i++) {
            if (i < colors.length / 2) {
                Rectangle square = new Rectangle(80, 80, colors[i]);
                square.setArcWidth(30);
                tilePane.getChildren().add(square);
            } else {
                Circle circle = new Circle(25, colors[i]);
                circle.relocate(50, 50);
                tilePane.getChildren().add(circle);
            }
        }

        Scene scene = new Scene(tilePane, 300, 250);

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
