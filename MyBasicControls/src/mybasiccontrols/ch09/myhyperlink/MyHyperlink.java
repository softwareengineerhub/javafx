/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybasiccontrols.ch09.myhyperlink;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
public class MyHyperlink extends Application {

    private TextArea textArea;
    private final int sceneWidth = 450;
    private final int sceneHeight = 350;
    private final ImageView selectedImage = new ImageView();

    @Override
    public void start(Stage primaryStage) {

        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(4);
        dropShadow.setOffsetY(6);
        dropShadow.setColor(Color.BLUE);

        Label label = new Label("Select an Icon");
        label.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        
        Hyperlink firstLink = makeHyperlink("Yellow");
        Hyperlink secondLink = makeHyperlink("Cyan");
        
        Button clearButton = new Button("Clear Links");
        clearButton.setEffect(dropShadow);
        clearButton.setOnAction(event->{
            firstLink.setVisited(false);
            secondLink.setVisited(false);
            selectedImage.setImage(null);
        });
       
        
        VBox vbox = new VBox(10, label, firstLink, secondLink, clearButton);
        vbox.setAlignment(Pos.CENTER_LEFT);
        vbox.setPadding(new Insets(30));
        
        
        
     

        HBox hbox = new HBox(vbox, selectedImage);
        hbox.setPadding(new Insets(50, 50, 50, 100));
        hbox.setAlignment(Pos.CENTER_LEFT);
        vbox.setStyle("-fx-background-color: palegreen");
        hbox.setEffect(dropShadow);

        
        Scene scene = new Scene(hbox, sceneWidth, sceneHeight);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();

        //  bar.progressProperty().bind(slider.valueProperty().divide(sliderLength));
        //  indicator.progressProperty().bind(slider.valueProperty().divide(sliderLength));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

   

    private Hyperlink makeHyperlink(String text) {
        Hyperlink hyperlink = new Hyperlink(text);
        Image img = new Image("resources/"+text+".jpg");
        hyperlink.setOnAction(event->{selectedImage.setImage(img);});        
        return hyperlink;
    }

}
