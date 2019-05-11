/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firstscreen.login;

import com.gluonhq.charm.down.Services;
import com.gluonhq.charm.down.plugins.ShareService;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 *
 * @author asusadmin
 */
public class LoginView extends View {

    public Button startBtn;
    private Button shareBtn;
    public StackPane pane = new StackPane();

    public DoubleProperty heightProperty = new SimpleDoubleProperty();
    public DoubleProperty widthProperty = new SimpleDoubleProperty();

    public LoginView() {
        heightProperty.addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                double currentHeight = (double) newValue;
                double paneHeight = 1.5 * currentHeight / 5;
                pane.setLayoutY((currentHeight / 2 - paneHeight / 2) / 1.5);
                pane.setPrefHeight(currentHeight - paneHeight * 2);
            }

        });
        widthProperty.addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                double currentWidth = (double) newValue;
                double paneWidth = currentWidth / 5;
                pane.setLayoutX((currentWidth / 2 - paneWidth / 2) / 2);
                pane.setPrefWidth(currentWidth - paneWidth * 2);
            }

        });

        startBtn = new Button("START");
        shareBtn = new Button("SHARE");
        shareBtn.setOnAction(e -> {
            Services.get(ShareService.class).ifPresent(service -> service.share("This is the subject", "This is the content of the message"));
        }
        );
        
        Image img = new Image(getClass().getResourceAsStream("/login_bg.jpeg"));
        ImageView node = new ImageView(img);
        node.fitWidthProperty().bind(widthProperty);
        node.fitHeightProperty().bind(heightProperty);
        AnchorPane anchorPane = new AnchorPane(node, initPane());
        setCenter(anchorPane);
    }

    @Override
    protected void updateAppBar(AppBar appBar) {
        appBar.setVisible(false);
        appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> System.out.println("Menu")));
        appBar.setTitleText("Basic View");
        appBar.getActionItems().add(MaterialDesignIcon.SEARCH.button(e -> System.out.println("Search")));
    }

    private Pane initPane() {
        pane.styleProperty().set("-fx-background-color: #ffffff67; -fx-background-radius: 30px;");
        DropShadow dropShadow = new DropShadow();
        dropShadow.setColor(Color.valueOf("#848282"));
        pane.setEffect(dropShadow);
        startBtn.styleProperty().set("-fx-background-color: #2ccc99; -fx-background-radius: 30px;");
        shareBtn.styleProperty().set("-fx-background-color: FF007F; -fx-background-radius: 30px;");
        //pane.getChildren().addAll(startBtn, shareBtn);
        
        VBox vbox = new VBox(40);
        vbox.setAlignment(Pos.CENTER);
      //  vbox.getChildren().add(startBtn);
        vbox.getChildren().addAll(startBtn, shareBtn);
        pane.getChildren().add(vbox);        
        return pane;
    }

}
