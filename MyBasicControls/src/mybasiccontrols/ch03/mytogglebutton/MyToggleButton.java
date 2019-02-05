/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybasiccontrols.ch03.mytogglebutton;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.DropShadow;
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
public class MyToggleButton extends Application {

    private final StackPane stackPane = new StackPane();
    private final DropShadow dropShadow = new DropShadow();
    private final ToggleGroup toggleGroup = new ToggleGroup();

    @Override
    public void start(Stage primaryStage) {
       // DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(4);
        dropShadow.setOffsetY(6);
        dropShadow.setColor(Color.rgb(150, 50, 50, .688));

        Label label = new Label("Change Background Color");
        label.setFont(Font.font("Tahoma", FontWeight.BOLD, 16));

        ToggleButton yellowButton = makeToggleButton("Yellow");
        ToggleButton cyanButton = makeToggleButton("Cyan");
        ToggleButton redButton = makeToggleButton("Red");
        
        //yellowButton.setDefaultButton(true);
        //cyanButton.setCancelButton(true);

        VBox buttons = new VBox(40, yellowButton, cyanButton, redButton);
        buttons.setAlignment(Pos.CENTER_LEFT);
        buttons.setEffect(dropShadow);
        //   buttons.getChildren().addAll(yellowButton, cyanButton);

        stackPane.setStyle("-fx-background-color: palegreen");
        stackPane.setAlignment(Pos.TOP_CENTER);
        stackPane.getChildren().addAll(label, buttons);
      
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

    private ToggleButton makeToggleButton(String color) {
        ToggleButton tb = new ToggleButton(color);
        tb.setUserData(color);
        tb.setOnAction(event -> {
            String bgColor = toggleGroup.getSelectedToggle()!=null? color: "paleegreen";
            stackPane.setStyle("-fx-background-color: "+bgColor);
        });
        return tb;
    }

}
