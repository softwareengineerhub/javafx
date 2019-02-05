/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycompositecontrols.ch01.menus;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Denys.Prokopiuk
 */
public class MyCompositeControls extends Application {

    private final StringProperty currentFont = new SimpleStringProperty("Arial");
    private final StringProperty currentStyle = new SimpleStringProperty("");
    private final StringProperty currentSize = new SimpleStringProperty("18");
    private final ToggleGroup toggleGroup = new ToggleGroup();

    @Override
    public void start(Stage primaryStage) {
        final String myString = "My Text";

        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(4);
        dropShadow.setOffsetY(6);
        dropShadow.setColor(Color.BLUE);

        TextArea textArea = new TextArea(myString);
        textArea.setWrapText(true);
        textArea.setEffect(dropShadow);

        Menu fontMenu = new Menu("Font");
        MenuItem arial = makeFontMenuItem("Arial", '1');
        MenuItem calibri = makeFontMenuItem("Calibri", '2');
        MenuItem cambria = makeFontMenuItem("Cambria", '3');
        fontMenu.getItems().addAll(arial, calibri, cambria);

        Menu sizeMenu = new Menu("Size");
        RadioMenuItem small = makeRadioMenuItem("18", true);
        RadioMenuItem medium = makeRadioMenuItem("28", false);
        RadioMenuItem large = makeRadioMenuItem("36", false);
        sizeMenu.getItems().addAll(small, medium, large);

        Menu styleMenu = new Menu("Style");
        CheckMenuItem bold = new CheckMenuItem("Bold");
        CheckMenuItem italic = new CheckMenuItem("Italic");
        styleMenu.getItems().addAll(bold, italic);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fontMenu, sizeMenu, styleMenu);

        VBox textVBox = new VBox(20, textArea);
        textVBox.setAlignment(Pos.CENTER);
        textVBox.setPadding(new Insets(30));

        VBox vbox = new VBox(menuBar, textVBox);
        vbox.setStyle("-fx-background-color: palegreen");

        Scene scene = new Scene(vbox, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();

        StringBinding styleBinding = new StringBinding() {

            @Override
            protected String computeValue() {
                StringBuilder sb = new StringBuilder();
                if (bold.isSelected()) {
                    sb.append("bold ");
                }
                if (italic.isSelected()) {
                    sb.append("italic ");
                }
                return sb.toString();
            }
        };

        currentStyle.bind(styleBinding);

        textArea.styleProperty().bind(
                Bindings.concat("-fx-font: ").
                        concat(currentStyle).concat(" ").
                        concat(currentSize).concat("pt ").
                        concat(currentFont).concat(";")
        );

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private MenuItem makeFontMenuItem(String text, char accKey) {
        MenuItem menuItem = new MenuItem(text);
        menuItem.setAccelerator(KeyCombination.keyCombination("Ctrl+" + accKey));
        menuItem.setOnAction(event -> currentFont.set(menuItem.getText()));
        return menuItem;
    }

    private RadioMenuItem makeRadioMenuItem(String text, boolean selected) {
        RadioMenuItem menuItem = new RadioMenuItem(text);
        if (selected) {
            menuItem.setSelected(selected);
            currentSize.set(menuItem.getText());
        }
        menuItem.setToggleGroup(toggleGroup);
        menuItem.setOnAction(evnet -> {
            currentSize.set(menuItem.getText());
        });
        return menuItem;
    }

}
