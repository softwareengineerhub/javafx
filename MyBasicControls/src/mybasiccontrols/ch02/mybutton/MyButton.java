/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybasiccontrols.ch02.mybutton;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
public class MyButton extends Application {
    
    private final VBox vbox = new VBox(40);
    
    
    
    @Override
    public void start(Stage primaryStage) {
        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(4);
        dropShadow.setOffsetY(6);
        dropShadow.setColor(Color.rgb(150, 50, 50, .688));
        
        Label label = new Label("Change Background Color");
        label.setFont(Font.font("Tahoma", FontWeight.BOLD, 16));
        
        Button yellowButton = makeButton("Yellow");
        Button cyanButton = makeButton("Cyan");
        
        yellowButton.setDefaultButton(true);
        cyanButton.setCancelButton(true);
        
        
        HBox buttons = new HBox(40, yellowButton, cyanButton);
        buttons.setAlignment(Pos.CENTER);
        buttons.setEffect(dropShadow);        
     //   buttons.getChildren().addAll(yellowButton, cyanButton);
        
        
        
        vbox.setStyle("-fx-background-color: palegreen");
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(label, buttons);
        
        StackPane root = new StackPane();
        root.setStyle("-fx-background-color: red");

        
        
        root.getChildren().add(vbox);

        Scene scene = new Scene(root, 300, 250);

        //label.opacityProperty().bind(scene.widthProperty().add(scene.heightProperty()).divide(1000));

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

    private Button makeButton(String color) {
        Button button = new Button(color);
        Image image = new Image("resources/"+color+".jpg");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(50);
        imageView.setFitWidth(50);
        button.setGraphic(imageView);
        button.setOnAction(event->{vbox.setStyle("-fx-background-color: "+color);});
        return button;
    }

}
