/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybasiccontrols.ch09.mytoolbar;

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
import javafx.scene.control.ToolBar;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
public class MyToolBar extends Application {
    
    private TextArea textArea;
    private final int sceneWidth = 450;
    private final int sceneHeight = 350;
    private VBox vbox;
    
    @Override
    public void start(Stage primaryStage) {
        final String myString = "This is useful text for you";
        
        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(4);
        dropShadow.setOffsetY(6);
        dropShadow.setColor(Color.BLUE);
        
        Label label = new Label("Enter Some Text");
        label.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        textArea = new TextArea(myString);
        textArea.setStyle("-fx-font-family: Geneva; -fx-font-size: 18;");
        textArea.setWrapText(true);
        textArea.setEffect(dropShadow);
        
        ToolBar toolBar = makeToolBar("Docker", "spring", "Copy", "Paste");
        
        HBox hbox = new HBox(40, toolBar);
        hbox.setAlignment(Pos.CENTER);
        hbox.setEffect(dropShadow);
        
        vbox = new VBox(40, label, textArea, hbox);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(30));
        vbox.setStyle("-fx-background-color: palegreen");
        
        Scene scene = new Scene(vbox, sceneWidth, sceneHeight);
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
    
    
    private ToolBar makeToolBar(String... names) {
        ToolBar toolBar = new ToolBar();
        for (String name : names) {
            Button button = new Button();
            button.setTooltip(new Tooltip(name));
            toolBar.getItems().add(button);
            Image image = null;
            if ("Copy".equals(name) || "Paste".equals(name)) {
                image = new Image("resources/" + name + ".png");
            } else {
                try{
                image = new Image("resources/" + name + ".jpg");
                }catch(Exception ex){
                    image = new Image("resources/" + name + ".jpeg");
                }
            }
            
            button.setGraphic(new ImageView(image));
            button.setOnAction(event -> {
                switch (name) {
                    case "Copy":
                        textArea.copy();
                        break;
                    case "Paste":
                        textArea.paste();
                    default:
                        vbox.setStyle("-fx-background-color: red");
                }
            });
        }
        return toolBar;
    }
    
}
