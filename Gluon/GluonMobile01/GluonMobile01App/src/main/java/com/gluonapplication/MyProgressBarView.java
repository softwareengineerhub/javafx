package com.gluonapplication;

import com.gluonhq.charm.glisten.control.ProgressBar;
import com.gluonhq.charm.glisten.mvc.View;
import javafx.scene.layout.Border;

public class MyProgressBarView extends View {

    public MyProgressBarView() {
        ProgressBar p2 = new ProgressBar();
        //p2.setBorder(Border.EMPTY);
        //p2.setProgress(0.25F);

        setCenter(p2);
    }
}
