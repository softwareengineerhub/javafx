package com.gluonapplication;

import com.gluonhq.charm.glisten.control.ProgressIndicator;
import com.gluonhq.charm.glisten.layout.layer.PopupView;
import com.gluonhq.charm.glisten.mvc.View;
import javafx.scene.control.Button;


public class MyLayerView extends View {
    private PopupView popupView;


    public MyLayerView() {
        Button btn = new Button("click");
        setCenter(btn);
        popupView = new PopupView(getCenter());
        ProgressIndicator progressIndicator = new ProgressIndicator();
        progressIndicator.setRadius(45);
        popupView.setContent(progressIndicator);
        btn.setOnAction(e->{
            popupView.show();
        });
    }


}
