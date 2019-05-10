/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybasiccontrols.ch05.mypasswordfield2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

/**
 *
 * @author Denys.Prokopiuk
 */
public class MyPassword2Controller implements Initializable {

    @FXML
    private TextField loginField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label messageLabel;

    @FXML
    private void loginAction(ActionEvent event) {
        String name = loginField.getText();
        String password = passwordField.getText();
        StringBuilder message = new StringBuilder();
        if (password.equals("11111111")) {
            message.append("access granted");
            messageLabel.setTextFill(Color.GREEN);
        } else {
            message.append("bad password");
            messageLabel.setTextFill(Color.RED);
        }

        if (!name.isEmpty()) {
            message.append(" for ").append(name);
            messageLabel.setText(message.toString());
            System.out.println(message);
            passwordField.clear();
        }
    }
    
    @FXML
    private void clearAction(ActionEvent event){
        loginField.clear();
        passwordField.clear();
        messageLabel.setText("");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}
