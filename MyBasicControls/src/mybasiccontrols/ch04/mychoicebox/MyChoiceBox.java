/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybasiccontrols.ch04.mychoicebox;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.binding.StringBinding;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.StringConverter;

/**
 *
 * @author Denys.Prokopiuk
 */
public class MyChoiceBox extends Application {

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

        ChoiceBox button = makeChoiceBox("Yellow", "Cyan", "Red");
        
        /*
        button.setConverter(new StringConverter() {
            @Override
            public String toString(Object object) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public Object fromString(String string) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        */
        
       
        //yellowButton.setDefaultButton(true);
        //cyanButton.setCancelButton(true);
        Text text = new Text();
        VBox buttons = new VBox(40, button, text);
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
        
        
        
        text.textProperty().bind(button.valueProperty());

       

        

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private ChoiceBox makeChoiceBox(String yellow, String cyan, String red) {
        ChoiceBox cb = new ChoiceBox();
        cb.getItems().clear();
        cb.getItems().addAll(yellow, cyan, red);
        cb.setValue(cyan);
        return cb;
    }
}
