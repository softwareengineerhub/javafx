package com.gluonapplication;


import com.gluonhq.charm.glisten.mvc.View;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class MyTextItemsView extends View {

    public MyTextItemsView() {

        VBox vBox = new VBox();
        vBox.getChildren().addAll(new TextField(), new TextArea());

        setCenter(vBox);
    }
}
