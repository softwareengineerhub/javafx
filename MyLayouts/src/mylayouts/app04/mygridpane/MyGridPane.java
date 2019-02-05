/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mylayouts.app04.mygridpane;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author Denys.Prokopiuk
 */
public class MyGridPane extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        Color colors[] = {Color.ORANGE, Color.BLACK, Color.RED, Color.PINK, Color.WHITE, Color.GREEN, Color.CYAN, Color.BLUE};

        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(4);
        dropShadow.setOffsetY(6);
        dropShadow.setColor(Color.BLUE);

        GridPane gridPane = new GridPane();
        
        //each tile has equal size
        gridPane.setPadding(new Insets(50, 50, 50, 50));
        //tilePane.setBorder(new Border(BorderStroke.THICK));
        gridPane.setHgap(25);
        gridPane.setVgap(25);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setGridLinesVisible(true);

        
        gridPane.setEffect(dropShadow);

        for (int i = 0; i < colors.length; i=i+2) {
           
                Rectangle square = new Rectangle(80, 80, colors[i]);
                square.setArcWidth(30);           
                Circle circle = new Circle(25, colors[i]);
                circle.relocate(50, 50);
                gridPane.add(square, i, 0);
                gridPane.add(circle, i, 1);
                
           
        }

        Scene scene = new Scene(gridPane, 300, 250);

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

