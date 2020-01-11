package com.gluonapplication;

import com.gluonhq.charm.glisten.control.ProgressIndicator;
import com.gluonhq.charm.glisten.mvc.View;

public class MyProgressIndecatorView extends View {

    public MyProgressIndecatorView() {
        ProgressIndicator p1 = new ProgressIndicator();
        p1.setRadius(45);
        setCenter(p1);

    }
}
