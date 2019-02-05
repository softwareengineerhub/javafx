/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycompositecontrols.ch04.mylistview;

import java.time.LocalDate;
import java.time.Month;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author Denys.Prokopiuk
 */
public class MyListView extends Application {

    @Override
    public void start(Stage primaryStage) {
        Label label = new Label("Choose a Color");
        label.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));

        
        ObservableList<String> list1 = FXCollections.observableArrayList("Red","Blue","Green","White","Pink","Orange","Black","Yellow");
        ListView listView1 = new ListView(list1);
        listView1.setMaxWidth(300);
        listView1.setMaxHeight(300);        
        listView1.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        //listView1.setEffect(drop);
        
        ObservableList<String> list2 = FXCollections.observableArrayList();
        ListView listView2 = new ListView(list2);
        listView2.setMaxWidth(300); 
        listView2.setMaxHeight(300);
        listView2.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
        Button b1 = new Button("->");
        Button b2 = new Button("<-");
        
        VBox vbox = new VBox(20, b1, b2);
        vbox.setAlignment(Pos.CENTER);
        vbox.setMinWidth(40);        
        
        HBox hbox = new HBox(20, listView1, vbox, listView2); 
        hbox.setAlignment(Pos.CENTER);
        hbox.setMinWidth(40);        
        hbox.setStyle("-fx-background-color: palegreen");
        
        Scene scene = new Scene(hbox, 300, 250);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        b1.setOnAction(event->{
            ObservableList selections = listView1.getSelectionModel().getSelectedItems();
            list2.addAll(selections);
            list1.removeAll(selections);
            
            
        });
        
        b2.setOnAction(event->{
            ObservableList selections = listView2.getSelectionModel().getSelectedItems();
            list1.addAll(selections);
            list2.removeAll(selections);            
        });

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
