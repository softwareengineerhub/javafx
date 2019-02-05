/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybasiccontrols.ch04.mycheckbox;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.binding.StringBinding;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
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
public class MyCheckBox extends Application {

    private final StackPane stackPane = new StackPane();
    private final DropShadow dropShadow = new DropShadow();
    private final Label resultLabel = new Label();

    @Override
    public void start(Stage primaryStage) {
        // DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(4);
        dropShadow.setOffsetY(6);
        dropShadow.setColor(Color.rgb(150, 50, 50, .688));

        Label label = new Label("Change Background Color");
        label.setFont(Font.font("Tahoma", FontWeight.BOLD, 16));

        CheckBox yellowButton = makeCheckBox("Yellow");
        CheckBox cyanButton = makeCheckBox("Cyan");
        CheckBox redButton = makeCheckBox("Red");
        redButton.setIndeterminate(true);
        redButton.setAllowIndeterminate(true);

        //yellowButton.setDefaultButton(true);
        //cyanButton.setCancelButton(true);
        VBox buttons = new VBox(40, yellowButton, cyanButton, redButton, resultLabel);
        buttons.setAlignment(Pos.CENTER_LEFT);
        buttons.setEffect(dropShadow);
        //   buttons.getChildren().addAll(yellowButton, cyanButton);

        stackPane.setStyle("-fx-background-color: palegreen");
        stackPane.setAlignment(Pos.TOP_CENTER);
        stackPane.getChildren().addAll(label, buttons);

        Scene scene = new Scene(stackPane, 300, 250);

        //label.opacityProperty().bind(scene.widthProperty().add(scene.heightProperty()).divide(1000));
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();

        StringBinding choiceBinding = new StringBinding() {

            CheckBox[] checkBoxes = {yellowButton, cyanButton, redButton};

            {
                for (CheckBox item : checkBoxes) {
                    super.bind(item.selectedProperty());
                }

            }

            @Override
            protected String computeValue() {
                StringBuilder choices = new StringBuilder();
                for (CheckBox checkBox : checkBoxes) {
                    if (checkBox.isSelected()) {
                        choices.append(checkBox.getText()).append(" ");
                    }
                }
                return choices.toString();
            }
        };
        
        resultLabel.textProperty().bind(choiceBinding);

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
