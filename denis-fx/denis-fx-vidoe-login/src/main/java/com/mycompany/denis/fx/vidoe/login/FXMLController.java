package com.mycompany.denis.fx.vidoe.login;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class FXMLController implements Initializable {
    
    @FXML
    private MediaView mediaView;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Media media = new Media("file:///C:/Users/dprokopiuk/Documents/NetBeansProjects/denis-fx-vidoe-login/src/main/resources/background.mp4");
        MediaPlayer mp = new MediaPlayer(media);
        mp.setVolume(0);
        mp.setAutoPlay(true);
        mp.setCycleCount(MediaPlayer.INDEFINITE);
        mediaView.setMediaPlayer(mp);
        mp.play();
    }    
}
