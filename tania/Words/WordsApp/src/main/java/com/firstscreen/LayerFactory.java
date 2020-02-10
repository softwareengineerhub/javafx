package com.firstscreen;

import com.gluonhq.charm.glisten.application.GlassPane;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.layout.Layer;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class LayerFactory {


    public static Layer createLayer(Node node) {
        return new Layer(){
            final GlassPane glassPane = MobileApplication.getInstance().getGlassPane();
            StackPane root;
            //int sizeX= (int) glassPane.getWidth();
            //int sizeY=(int) glassPane.getHeight();

            int sizeX= 300;
            int sizeY=300;

            {
                setBackgroundFade(0.5);
                root = new StackPane(node);
                //  root.setStyle("-fx-background-color: white;");
                getChildren().add(root);
            }

            @Override
            public void layoutChildren() {
                super.layoutChildren();
                root.setVisible(isShowing());
                if (!isShowing()) {
                    return;
                }
                root.resize(sizeX, sizeY);
                resizeRelocate((glassPane.getWidth() - sizeX)/2, (glassPane.getHeight()- sizeY)/2, sizeX, sizeY);
            }


        };
    }


}
