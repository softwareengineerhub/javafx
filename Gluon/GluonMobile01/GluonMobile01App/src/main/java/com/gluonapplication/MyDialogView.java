package com.gluonapplication;


import com.gluonhq.charm.glisten.control.Dialog;
import com.gluonhq.charm.glisten.mvc.View;
import javafx.scene.control.*;

public class MyDialogView extends View {

    public MyDialogView() {


        Button btn = new Button("Click");
        btn.setOnAction(e->{
            Dialog dialog = new Dialog();
            dialog.setTitle(new Label("This is a regular dialog"));
            dialog.setContent(new Label("Just a regular dialog, plain and simple"));
            Button okButton = new Button("OK");
            okButton.setOnAction(e1 -> {
                dialog.hide();
            });
            dialog.getButtons().add(okButton);
            dialog.showAndWait();
        });


        setCenter(btn);
    }
}
