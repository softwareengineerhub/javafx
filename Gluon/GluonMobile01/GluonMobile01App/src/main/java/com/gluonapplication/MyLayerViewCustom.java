package com.gluonapplication;

import com.gluonhq.charm.glisten.application.GlassPane;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.ProgressIndicator;
import com.gluonhq.charm.glisten.layout.Layer;
import com.gluonhq.charm.glisten.layout.layer.PopupView;
import com.gluonhq.charm.glisten.mvc.View;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;


public class MyLayerViewCustom extends View {
    private PopupView popupView;
    private Layer layer;


    public MyLayerViewCustom() {
        Button btn = new Button("click");
        setCenter(btn);

        //ProgressIndicator progressIndicator = new ProgressIndicator();
        //progressIndicator.setRadius(45);

        btn.setOnAction(e->{
            if (layer == null) {
                layer = createLayer();
            }
            layer.show();
        });
    }

    private Layer createLayer() {
        return new Layer() {
            private final Node root;
            private final double size = 150;
            final GlassPane glassPane = MobileApplication.getInstance().getGlassPane();

            {
                setBackgroundFade(0.5);
                root = new StackPane(new Button("A custom layer"));
                root.setStyle("-fx-background-color: white;");
                getChildren().add(root);
            }

            @Override
            public void layoutChildren() {
                super.layoutChildren();
                root.setVisible(isShowing());
                if (!isShowing()) {
                    return;
                }
                root.resize(size, size);
                resizeRelocate((glassPane.getWidth() - size)/2, (glassPane.getHeight()- size)/2, size, size);
            }
        };
    }


}
