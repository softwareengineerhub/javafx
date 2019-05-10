/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycompositecontrols.ch06.mytabpane;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TitledPane;
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
public class MyTabPane extends Application {

    @Override
    public void start(Stage primaryStage) {
        final String myText = "Some text data. This is example";

        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(4);
        dropShadow.setOffsetX(6);
        dropShadow.setColor(Color.BLUE);

      
        Tab tab1 = makeTab("Tab1", false);
        Tab tab2 = makeTab("Tab2", true);
        Tab tab3 = makeTab("Tab3", false);
        TabPane tabPane = new TabPane(tab1, tab2, tab3);
        
        Label label = new Label("Multiple Text Areas");
        label.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));

        VBox vbox = new VBox(20, label, tabPane);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(30));
        vbox.setStyle("-fx-background-color: palegreen");

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
        textArea.setStyle("-fx-background-color: " +(close ? "red" : "blue") );
        textArea.setWrapText(true);
        Tab tab = new Tab(title, textArea);
        if(close){
            tab.setOnCloseRequest(event->{System.out.println("Closed");});
        }
        return tab;
    }

}
