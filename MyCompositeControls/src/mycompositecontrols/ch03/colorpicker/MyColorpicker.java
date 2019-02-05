/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycompositecontrols.ch03.colorpicker;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.binding.StringBinding;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author Denys.Prokopiuk
 */
public class MyColorpicker extends Application {

    private final DropShadow dropShadow = new DropShadow();

    @Override
    public void start(Stage primaryStage) {
        Label label = new Label("Choose a Color");
        label.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        
        ColorPicker colorPicker = new ColorPicker();
       // colorPicker.setOnAction(event->label.setTextFill(colorPicker.getValue()));
       label.textFillProperty().bind(colorPicker.valueProperty());
       
        
        VBox vbox = new VBox(30, label, colorPicker);
        vbox.setAlignment(Pos.CENTER);
        vbox.setStyle("-fx-background-color: blue");
        
        
        Scene scene = new Scene(vbox, 300, 250);

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
