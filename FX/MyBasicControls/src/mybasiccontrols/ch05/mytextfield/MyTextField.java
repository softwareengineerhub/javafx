/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybasiccontrols.ch05.mytextfield;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
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
public class MyTextField extends Application {

    //private final StackPane stackPane = new StackPane();
    //private final DropShadow dropShadow = new DropShadow();
    private final Label resultLabel = new Label();
    private final Label resultLabel2 = new Label();

    @Override
    public void start(Stage primaryStage) {
        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(4);
        dropShadow.setOffsetY(6);
        dropShadow.setColor(Color.rgb(150, 50, 50, .688));

        Label inputLabel = new Label("Phone Number");
        inputLabel.setFont(Font.font("Tahoma", FontWeight.BOLD, 16));
        
        TextField text = new TextField();
        text.setMaxWidth(150);
        text.setEffect(dropShadow);
        
        PasswordField passwordField = new PasswordField();
        text.setMaxWidth(150);
        text.setEffect(dropShadow);
        
        HBox firstBox = new HBox(15, inputLabel, text, passwordField);
        firstBox.setAlignment(Pos.CENTER);
        
        Label validLabel = new Label("Valid Phone");
        validLabel.setFont(Font.font("Tahoma", FontWeight.BOLD, 16));
        
        
        HBox secondBox = new HBox(15, validLabel, resultLabel, resultLabel2);
        secondBox.setAlignment(Pos.CENTER);
        
        VBox group = new VBox();
        group.setStyle("-fx-background-color: palegreen");
        group.setAlignment(Pos.TOP_CENTER);
        group.getChildren().addAll(firstBox, secondBox);

        Scene scene = new Scene(group, 300, 250);

        //label.opacityProperty().bind(scene.widthProperty().add(scene.heightProperty()).divide(1000));
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();

        
        resultLabel.textProperty().bind(text.textProperty());
        resultLabel2.textProperty().bind(passwordField.textProperty());
       

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private CheckBox makeCheckBox(String color) {
        CheckBox cb = new CheckBox(color);
        cb.setOnAction(event -> {
        });
        return cb;
    }
}

