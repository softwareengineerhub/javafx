/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycompositecontrols.ch06.mysplitpane;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.HBox;
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
public class MySplitPane extends Application {

    @Override
    public void start(Stage primaryStage) {
        final String myText = "Some text data. This is example";
        
        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(4);
        dropShadow.setOffsetX(6);
        dropShadow.setColor(Color.BLUE);
        
        StackPane sp1 = makeTextArea(myText, "Tahoma", 14);
        StackPane sp2 = makeTextArea(myText, "Verdana", 18);
        StackPane sp3 = makeTextArea(myText, "Cambria", 20);
       
        SplitPane splitPane = new SplitPane();
        splitPane.getItems().addAll(sp1, sp2, sp3);
        splitPane.setDividerPositions(0.3, 0.65, 0.9);
        splitPane.setEffect(dropShadow);
        
        Label label = new Label("Multiple Text Areas");
        label.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        
        VBox vbox = new VBox(20, label, splitPane);
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
    
  

    private StackPane makeTextArea(String myText, String fontName, int i) {
        TextArea textArea = new TextArea(myText);
        textArea.setStyle("-fx-font-family: "+fontName+";" +" -fx-font-size: "+i);
        textArea.setWrapText(true);
        return new StackPane(textArea);
    }

}
