/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycompositecontrols.ch08.myscrollpane;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TitledPane;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author Denys.Prokopiuk
 */
public class MyScrollPane extends Application {

    @Override
    public void start(Stage primaryStage) {
        Image myImage = new Image("resources/Img.jpg");
        ImageView imageView = new ImageView(myImage);
        imageView.setPreserveRatio(true);

        
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(imageView);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        
        scrollPane.vvalueProperty().addListener((observableValue, oldValue, newValue)->{System.out.println(newValue);});
        

        Scene scene = new Scene(scrollPane, 300, 250);
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

    private Tab makeTab(String title, boolean close) {
        TextArea textArea = new TextArea(title);
        textArea.setStyle("-fx-background-color: " + (close ? "red" : "blue"));
        textArea.setWrapText(true);
        Tab tab = new Tab(title, textArea);
        if (close) {
            tab.setOnCloseRequest(event -> {
                System.out.println("Closed");
            });
        }
        return tab;
    }

}
