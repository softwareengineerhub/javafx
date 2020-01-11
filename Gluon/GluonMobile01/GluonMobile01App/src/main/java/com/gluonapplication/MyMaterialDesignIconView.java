package com.gluonapplication;

import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.scene.layout.VBox;

public class MyMaterialDesignIconView extends View {


    public MyMaterialDesignIconView() {
        VBox vbox = new VBox();
        for(MaterialDesignIcon icon: MaterialDesignIcon.values()){
            vbox.getChildren().add(icon.graphic());
            vbox.setFillWidth(true);

        }

        setCenter(vbox);
    }
}
