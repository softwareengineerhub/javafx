/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybasiccontrols.ch07.myprogressindicator;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Slider;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.SepiaTone;
import javafx.scene.layout.BorderPane;
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
public class MyProgress extends Application {

    private final SepiaTone sepiaTone = new SepiaTone();
    private final int sceneWidth = 450;
    private final int sceneHeight = 350;

    @Override
    public void start(Stage primaryStage) {
        final int sliderLength = 50;

        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(4);
        dropShadow.setOffsetY(6);
        dropShadow.setColor(Color.BLUE);

        Label label = new Label("Show Some Progress");
        label.setFont(Font.font("Tahoma", FontWeight.BOLD, 16));

        Slider slider = new Slider(0, sliderLength, 0);
        ProgressBar bar = new ProgressBar(0);
        ProgressIndicator indicator = new ProgressIndicator(0);

        HBox hbox = new HBox(40, slider, bar, indicator);
        hbox.setAlignment(Pos.TOP_CENTER);
        hbox.setEffect(dropShadow);

        VBox vbox = new VBox(40, label, hbox);
        vbox.setAlignment(Pos.CENTER);
        vbox.setStyle("-fx-background-color: palegreen");

        Scene scene = new Scene(vbox, sceneWidth, sceneHeight);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
        
        bar.progressProperty().bind(slider.valueProperty().divide(sliderLength));
        indicator.progressProperty().bind(slider.valueProperty().divide(sliderLength));
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
