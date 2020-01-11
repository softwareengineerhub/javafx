package com.gluonapplication;

import com.gluonhq.charm.glisten.control.DatePicker;
import com.gluonhq.charm.glisten.mvc.View;
import javafx.scene.control.Button;

import java.time.LocalDate;
import java.util.Optional;

public class MyDatePickerView extends View {

    public MyDatePickerView() {

        Button btn = new Button("Click");
        btn.setOnAction(e->{

            DatePicker datePicker = new DatePicker();
            //datePicker.showAndWait().ifPresent(System.out::println);
            datePicker.setDate(LocalDate.now());
            Optional<LocalDate> res = datePicker.showAndWait();
            System.out.println(res.isPresent());

        });

        setCenter(btn);
    }
}
