/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mylayouts.app06.myborderpane;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Denys.Prokopiuk
 */
public class MyBorderPane extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Color colors[] = {Color.ORANGE, Color.BLACK, Color.RED, Color.BLUE, Color.WHITE, Color.GREEN, Color.CYAN, Color.RED};

        int i=0;
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(getRegion("#b22222ff"));
        borderPane.setLeft(getRegion("#ffff00ff"));        
        borderPane.setCenter(getRegion("#ffa500ff"));
      //  borderPane.setRight(getRegion("#008000ff"));
        borderPane.setBottom(getRegion("#90ee90ff"));
      
        

        Scene scene = new Scene(borderPane, 404, 404);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private Region getRegion(String color){
        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(new Text("Text"));
        //StackPane stackPane = new StackPane();
        stackPane.setStyle("-fx-background-color: "+color);
        return stackPane;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
