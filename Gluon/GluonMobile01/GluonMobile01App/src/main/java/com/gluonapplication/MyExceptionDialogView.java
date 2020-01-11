package com.gluonapplication;

import com.gluonhq.charm.glisten.control.ExceptionDialog;
import com.gluonhq.charm.glisten.mvc.View;
import javafx.scene.control.Button;

public class MyExceptionDialogView extends View {

    public MyExceptionDialogView() {

        Button btn = new Button("Click");
        btn.setOnAction(e->{
            try {
                String s = null;
                s.toUpperCase();
            } catch(Exception ex) {
                ExceptionDialog exceptionDialog = new ExceptionDialog();
                exceptionDialog.setException(ex);
                exceptionDialog.showAndWait();
            }

        });

        setCenter(btn);
    }
}
