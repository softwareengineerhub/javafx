package com.gluonapplication;

import com.gluonhq.charm.glisten.control.Toast;
import com.gluonhq.charm.glisten.mvc.View;
import javafx.scene.control.Button;
import javafx.util.Duration;

import static com.gluonhq.charm.glisten.control.Message.LENGTH_LONG;

public class MyToastView extends View {

    public MyToastView() {

        Button button = new Button("Show toast");
        Toast toast = new Toast("This is a toast!");
        toast.setDuration(LENGTH_LONG);
        button.setOnAction(event -> toast.show());

        setCenter(button);

    }
}
