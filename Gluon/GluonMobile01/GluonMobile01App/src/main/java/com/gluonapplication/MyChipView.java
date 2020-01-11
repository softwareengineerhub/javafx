package com.gluonapplication;

import com.gluonhq.charm.glisten.control.Chip;
import com.gluonhq.charm.glisten.mvc.View;
import javafx.scene.image.Image;

public class MyChipView extends View {

    public MyChipView() {
        Chip chip = new Chip();
        chip.setText("Some text");
        chip.setDeletable(false);
        chip.setGraphic(new Image(getClass().getResourceAsStream("/login_bg.jpeg")));
        setCenter(chip);
    }
}
