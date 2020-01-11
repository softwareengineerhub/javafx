package com.gluonapplication;

import com.gluonhq.charm.down.Services;
import com.gluonhq.charm.glisten.mvc.View;
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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;

public class MyVideoView extends View {
    public DoubleProperty heightProperty = new SimpleDoubleProperty();
    public DoubleProperty widthProperty = new SimpleDoubleProperty();
    private StackPane pane = new StackPane();
    private Button startBtn;
    private Button shareBtn;

    public MyVideoView() {
        makeBinding();
        startBtn = new Button("START");
        shareBtn = new Button("SHARE");

        MediaView node = new MediaView();
        Media media = new Media("file:///C:/background.mp4");
        MediaPlayer mp = new MediaPlayer(media);
        mp.setVolume(0);
        mp.setAutoPlay(true);
        mp.setCycleCount(MediaPlayer.INDEFINITE);
        node.setMediaPlayer(mp);

        //Image img = new Image(getClass().getResourceAsStream("/login_bg.jpeg"));
        //ImageView node = new ImageView(img);

        node.fitWidthProperty().bind(widthProperty);
        node.fitHeightProperty().bind(heightProperty);
        AnchorPane anchorPane = new AnchorPane(node, initPane());
        setCenter(anchorPane);
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


    private void makeBinding(){
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
    }
}
