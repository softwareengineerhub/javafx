/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycompositecontrols.ch02.tooltip;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.binding.StringBinding;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author Denys.Prokopiuk
 */
public class MyTooltip extends Application {

    private final DropShadow dropShadow = new DropShadow();

    @Override
    public void start(Stage primaryStage) {

        dropShadow.setOffsetX(4);
        dropShadow.setOffsetY(6);
        dropShadow.setColor(Color.BLUE);

        Label name = new Label("Name");
        name.setFont(Font.font("Tahoma", FontWeight.BOLD, 16));

        Tooltip textTooltip = new Tooltip("We'd like your name before placing order");
       // textTooltip.setGraphic(new ImageView(new Image("")));
        textTooltip.setPrefWidth(200);
        textTooltip.setWrapText(true);

        TextField textField = new TextField();
        textField.setPrefWidth(200);
        textField.setPromptText("Input your name");
        textField.setTooltip(textTooltip);

        HBox hbox = new HBox(20, name, textField);
        CheckBox shoes = makeCheckBox("Shoes", 30);
        CheckBox hat = makeCheckBox("Hat", 20);
        CheckBox belt = makeCheckBox("Belt", 10);

        Label total = new Label();
        total.setFont(Font.font("Tahoma", FontWeight.BOLD, 16));

        VBox vbox = new VBox(20, hbox, shoes, hat, belt, total);
        vbox.setAlignment(Pos.CENTER_LEFT);
        vbox.setPadding(new Insets(20, 20, 20, 80));
        vbox.setStyle("-fx-background-color: palegreen");

        Scene scene = new Scene(vbox, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();

        StringBinding choiseBinding = new StringBinding() {
            CheckBox[] checkBoxes = {shoes, hat, belt};

            {
                for (CheckBox checkBox : checkBoxes) {
                    super.bind(checkBox.selectedProperty());
                }
            }

            @Override
            protected String computeValue() {
                double total = 0;
                for (CheckBox checkBox : checkBoxes) {
                    if (checkBox.isSelected()) {
                        total += (Integer) checkBox.getUserData();
                    }
                }
                return "Total: $ " + total;
            }
        };
        
        total.textProperty().bind(choiseBinding);
        
        textField.setOnAction(event -> {
            String name1 = textField.getText();
            System.out.println(name1);
        });
        

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private CheckBox makeCheckBox(String item, int cost) {
        CheckBox cb = new CheckBox(item);
        cb.setUserData(cost);
        cb.setTooltip(new Tooltip("$" + cost));
        cb.setEffect(dropShadow);
        return cb;
    }

}
