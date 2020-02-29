/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firstscreen;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import javafx.scene.control.Alert;

/**
 *
 * @author asusadmin
 */
public class ShowError {

    public static void showError(Throwable ex, boolean toConsole) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(ex.getMessage());
        alert.setHeaderText(ex.getLocalizedMessage());
        try (ByteArrayOutputStream out = new ByteArrayOutputStream();) {
            PrintStream ps = new PrintStream(out);
            ex.printStackTrace(ps);
            alert.setContentText(new String(out.toByteArray()));
        } catch (Exception ex1) {
            throw new RuntimeException(ex);
        }
        alert.showAndWait();
        if (toConsole) {
            ex.printStackTrace();
        }
    }

}
