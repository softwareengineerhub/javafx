/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybasiccontrols.ch03.myradiobutton;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
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
public class MyRadioButton extends Application {

    private final StackPane stackPane = new StackPane();
    private final DropShadow dropShadow = new DropShadow();

    @Override
    public void start(Stage primaryStage) {
       // DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(4);
        dropShadow.setOffsetY(6);
        dropShadow.setColor(Color.rgb(150, 50, 50, .688));

        Label label = new Label("Change Background Color");
        label.setFont(Font.font("Tahoma", FontWeight.BOLD, 16));

        RadioButton yellowButton = makeRadioButton("Yellow");
        RadioButton cyanButton = makeRadioButton("Cyan");
        RadioButton redButton = makeRadioButton("Red");
        
        //yellowButton.setDefaultButton(true);
        //cyanButton.setCancelButton(true);

        VBox buttons = new VBox(40, yellowButton, cyanButton, redButton);
        buttons.setAlignment(Pos.CENTER_LEFT);
        buttons.setEffect(dropShadow);
        //   buttons.getChildren().addAll(yellowButton, cyanButton);

        stackPane.setStyle("-fx-background-color: palegreen");
        stackPane.setAlignment(Pos.TOP_CENTER);
        stackPane.getChildren().addAll(label, buttons);
        ToggleGroup toggleGroup = new ToggleGroup();
        toggleGroup.getToggles().addAll(cyanButton, yellowButton, redButton);
        
        
        
        
        StackPane root = new StackPane();
        
        root.getChildren().add(stackPane);

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

    private RadioButton makeRadioButton(String color) {
        RadioButton rb = new RadioButton(color);
        rb.setEffect(dropShadow);
        rb.setOnAction(event->{stackPane.setStyle("-fx-background-color: "+color);});
        return rb;
    }

}
