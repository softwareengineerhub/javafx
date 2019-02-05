/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mylayouts.app07.myanchorpane;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Denys.Prokopiuk
 */
public class MyAnchorPane extends Application {
 
    @Override
    public void start(Stage primaryStage) throws Exception {
        Color colors[] = {Color.ORANGE, Color.BLACK, Color.RED, Color.BLUE, Color.WHITE, Color.GREEN, Color.CYAN, Color.RED};

       
        Rectangle r1 = new Rectangle(70, 20, Color.RED);
        Rectangle r2 = new Rectangle(70, 20, Color.YELLOW);
        Rectangle r3 = new Rectangle(70, 20, Color.GREEN);
        Rectangle r4 = new Rectangle(70, 20, Color.BLUE);
        
        AnchorPane.setTopAnchor(r1, 10d);
        AnchorPane.setLeftAnchor(r1, 10d);
        
        AnchorPane.setTopAnchor(r2, 10d);
        AnchorPane.setRightAnchor(r2, 10d);
        
        AnchorPane.setBottomAnchor(r3, 10d);
        AnchorPane.setRightAnchor(r3, 10d);
        
        
        AnchorPane.setBottomAnchor(r4, 10d);
        AnchorPane.setLeftAnchor(r4, 10d);
        
        AnchorPane anchorPane = new AnchorPane(r1, r2, r3, r4);
         
        Scene scene = new Scene(anchorPane, 404, 404);

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
