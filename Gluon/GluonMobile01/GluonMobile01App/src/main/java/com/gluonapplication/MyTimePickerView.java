package com.gluonapplication;

import com.gluonhq.charm.glisten.control.TimePicker;
import com.gluonhq.charm.glisten.mvc.View;
import javafx.scene.control.Button;

public class MyTimePickerView extends View {

    public MyTimePickerView() {

        Button btn = new Button("Click");
        btn.setOnAction(e->{
            TimePicker timePicker = new TimePicker();
            timePicker.showAndWait().ifPresent(System.out::println);
        });

        setCenter(btn);
    }
}
