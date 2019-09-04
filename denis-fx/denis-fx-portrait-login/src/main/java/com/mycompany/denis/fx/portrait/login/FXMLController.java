package com.mycompany.denis.fx.portrait.login;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class FXMLController implements Initializable {
    
    @FXML
    private ImageView image;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
      //  label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        System.out.println("INIT!!!!!!!!!!!!!"+image);
        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(25), image);
        rotateTransition.setByAngle(9*360);
        rotateTransition.play();
    }    
}
