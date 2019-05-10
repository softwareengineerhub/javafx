/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycompositecontrols.ch09.myhtmleditor;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;

/**
 *
 * @author Denys.Prokopiuk
 */
public class MyHtmlEditor extends Application {

    @Override
    public void start(Stage primaryStage) {
        
        final String myString = "Some text we are going to edit.";
        
        HTMLEditor htmlEditor = new HTMLEditor();
        htmlEditor.setHtmlText(myString);
        htmlEditor.setPrefHeight(300);
        
        TextArea textArea = new TextArea();
        textArea.setWrapText(true);
        
        Button button = new Button("HTML Code");
        button.setStyle("-fx-background-color: palegreen");
        button.setOnAction(event->textArea.setText(htmlEditor.getHtmlText()));
        
        VBox vbox = new VBox(30, htmlEditor, button, textArea);
        vbox.setAlignment(Pos.CENTER);
        vbox.setStyle("-fx-background-color: #e6e6e6");
        
        
       
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

    private Tab makeTab(String title, boolean close) {
        TextArea textArea = new TextArea(title);
        textArea.setStyle("-fx-background-color: " + (close ? "red" : "blue"));
        textArea.setWrapText(true);
        Tab tab = new Tab(title, textArea);
        if (close) {
            tab.setOnCloseRequest(event -> {
                System.out.println("Closed");
            });
        }
        return tab;
    }

}
