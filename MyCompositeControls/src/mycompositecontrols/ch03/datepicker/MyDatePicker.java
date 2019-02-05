/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycompositecontrols.ch03.datepicker;

import java.time.LocalDate;
import java.time.Month;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author Denys.Prokopiuk
 */
public class MyDatePicker extends Application {

    @Override
    public void start(Stage primaryStage) {
        Label label = new Label("Choose a Color");
        label.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));

        DatePicker datePicker = new DatePicker();
        datePicker.setOnAction(event->{
            LocalDate localDate = datePicker.getValue();
            Month m=localDate.getMonth();
            int year = localDate.getYear();
            System.out.println(year+" "+m);
        });
        
        VBox vbox = new VBox(30, label, datePicker);
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
