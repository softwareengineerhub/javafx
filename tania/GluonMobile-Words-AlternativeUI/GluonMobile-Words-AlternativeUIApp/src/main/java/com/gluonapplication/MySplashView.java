package com.gluonapplication;

import com.gluonhq.charm.down.Services;
import com.gluonhq.charm.down.plugins.VideoService;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.control.ProgressIndicator;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import com.middleware.Categories2Dao;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;

import java.net.URI;
import java.nio.file.Paths;
import java.util.Optional;
import javafx.scene.Node;

public class MySplashView  extends View {

    private GluonApplication gluonApplication;
    private StackPane pane = new StackPane();

    public DoubleProperty heightProperty = new SimpleDoubleProperty();
    public DoubleProperty widthProperty = new SimpleDoubleProperty();
    private boolean isFirst =true;


    public MySplashView(GluonApplication gluonApplication) {
        gluonApplication.categories2Dao.findAll();
        this.gluonApplication=gluonApplication;
        makeBinding();
        //Node mediaView = initMediaView();
        ProgressIndicator p1 = initProgressIndicator();
     //   initMediaView();
        //AnchorPane anchorPane = new AnchorPane(mediaView, initPane(p1));
        AnchorPane anchorPane = new AnchorPane(initPane(p1));
        setCenter(anchorPane);

        Runnable r = ()->{

            while(gluonApplication.categories2Dao.getCurrentCategories()==null){
            }
            javafx.application.Platform.runLater(()->{gluonApplication.switchView("CATEGORY_VIEW");});

        };

        Thread t = new Thread(r);
        t.start();
    }



    private ProgressIndicator initProgressIndicator(){
        ProgressIndicator pi = new ProgressIndicator();
        pi.setRadius(45);
        return pi;
    }
    
    private void initMediaView(){
        Optional<VideoService> videoService = Services.get(VideoService.class);
        videoService.ifPresent(video -> {
            if(isFirst){
            //video.setFullScreen(true);
            video.setPosition(Pos.CENTER, 0, widthProperty.getValue(), 0, heightProperty.getValue());
            //video.setControlsVisible(true);
            video.setLooping(true);
            video.getPlaylist().add("background.mp4");
            }
            video.show();
            video.play();            
            
            //mediaView.fitHeightProperty().bind(heightProperty);
        });
        //return videoService.get();
    }

    private MediaView initMediaView2(){
        MediaView mediaView = new MediaView();
        if(1<2){
            //return mediaView;
        }
        String uriValue = "";





        //URI uri = URI.create("file://" + Paths.get("background.mp4").toAbsolutePath());
        Media media = new Media(getURI().toString());

        //Media media = new Media("file:///C:/background.mp4");
        MediaPlayer mp = new MediaPlayer(media);
        mp.setVolume(0);
        mp.setAutoPlay(true);
        mp.setCycleCount(MediaPlayer.INDEFINITE);
        mediaView.setMediaPlayer(mp);
        mediaView.fitHeightProperty().bind(heightProperty);
        return mediaView;
    }

    private URI getURI(){
        try {
            return getClass().getResource("/background.mp4").toURI();
        }catch (Throwable th){
            throw new RuntimeException(th);
        }
    }

    private Pane initPane(ProgressIndicator progressIndicator) {
        pane.styleProperty().set("-fx-background-color: #ffffff67; -fx-background-radius: 30px;");
        DropShadow dropShadow = new DropShadow();
        dropShadow.setColor(Color.valueOf("#848282"));
        pane.setEffect(dropShadow);
        Button infoBtn = new Button("Content is loading");
        infoBtn.setOnAction(e->{
            //gluonApplication.switchView("CATEGORY_VIEW");
        });
        infoBtn.styleProperty().set("-fx-background-color: #2ccc99; -fx-background-radius: 30px;");

        VBox vbox = new VBox(40);
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(infoBtn, progressIndicator);
        pane.getChildren().add(vbox);
        return pane;
    }


    @Override
    protected void updateAppBar(AppBar appBar) {
        appBar.setVisible(false);       
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
