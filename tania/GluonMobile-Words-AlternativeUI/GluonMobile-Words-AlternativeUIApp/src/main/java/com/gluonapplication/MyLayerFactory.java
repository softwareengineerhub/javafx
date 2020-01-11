package com.gluonapplication;

import com.gluonhq.charm.glisten.application.GlassPane;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.ProgressIndicator;
import com.gluonhq.charm.glisten.layout.Layer;
import javafx.scene.Node;

public class MyLayerFactory {

    public static Layer createLayer(Node node, double w, double h) {
        return new Layer() {
            private final Node root = node;
            final GlassPane glassPane = MobileApplication.getInstance().getGlassPane();

            {
                setBackgroundFade(0.5);
                getChildren().add(root);


            }

            /*@Override
            public void show() {
                super.show();
                //gluonApplication.myAvatarView.initData(categoryName);
                //gluonApplication.switchView("DETAILS_VIEW");
            }*/

            @Override
            public void layoutChildren() {
                super.layoutChildren();
                root.setVisible(isShowing());
                if (!isShowing()) {
                    return;
                }
                //root.resize(size, size);
                //resizeRelocate((glassPane.getWidth() - size)/2, (glassPane.getHeight()- size)/2, size, size);
                //resize(200,200);
                relocate(glassPane.getWidth() / 2 - w, glassPane.getHeight() / 2 - h);
            }
        };
    }

}
