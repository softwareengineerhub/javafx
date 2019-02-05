/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybasiccontrols.ch06.myslider;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.effect.SepiaTone;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Denys.Prokopiuk
 */
public class MySlider extends Application {
    
    private final SepiaTone sepiaTone = new SepiaTone();
    private final int sceneWidth = 450;
    private final int sceneHeight = 350;

    @Override
    public void start(Stage primaryStage) {

        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(15, 10, 20, 10));
        borderPane.setStyle("-fx-background-color: lightgray");
        borderPane.setCenter(drawImage());
        borderPane.setLeft(drawBorder(""));
        borderPane.setRight(drawBorder(""));
        borderPane.setTop(drawBorder(""));
        borderPane.setBottom(drawSlider("Sepia Tone"));
        
        Scene scene = new Scene(borderPane, sceneWidth, sceneHeight);
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
    
    private Region drawImage(){
        Image myImage = new Image("resources/my.jpeg");
        ImageView imageView = new ImageView(myImage);
        imageView.setFitHeight(sceneHeight-120);
        //imageView.setFitHeight(sceneWidth-120);
        imageView.setEffect(sepiaTone);
        imageView.setPreserveRatio(true);
        return new StackPane(imageView);
    }
    
    private Region drawBorder(String title){
        Text text = new Text(title);
        text.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        return new StackPane(text);
    }
    
    private Region drawSlider(String title){
        Label sepialLabel = new Label(title);
        sepialLabel.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        
        Slider slider = new Slider(0, 1, 0);
        slider.setMinorTickCount(1);
        slider.setMajorTickUnit(.5);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        
        Label sepialValue = new Label("value");
        sepialValue.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        HBox hbox = new HBox(25, sepialLabel, slider, sepialValue);
        hbox.setAlignment(Pos.CENTER);
        sepiaTone.levelProperty().bind(slider.valueProperty());
        sepialValue.textProperty().bind(slider.valueProperty().asString("%.2f"));
        return hbox;
    }
    
    
}
