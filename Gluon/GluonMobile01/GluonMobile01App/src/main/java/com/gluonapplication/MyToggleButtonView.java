package com.gluonapplication;

import com.gluonhq.charm.glisten.control.ToggleButtonGroup;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.ToggleButton;

public class MyToggleButtonView extends View {

    public MyToggleButtonView() {
        ToggleButtonGroup toggleButtonGroup = new ToggleButtonGroup();
        toggleButtonGroup.setSelectionType(SelectionMode.SINGLE);

        ToggleButton toggleButton = new ToggleButton();
        toggleButton.setGraphic(MaterialDesignIcon.FORMAT_ALIGN_LEFT.graphic());
        toggleButtonGroup.getToggles().add(toggleButton);

        toggleButton = new ToggleButton();
        toggleButton.setSelected(true);
        toggleButton.setGraphic(MaterialDesignIcon.FORMAT_ALIGN_CENTER.graphic());
        toggleButtonGroup.getToggles().add(toggleButton);


        toggleButton = new ToggleButton();
        toggleButton.setGraphic(MaterialDesignIcon.FORMAT_ALIGN_RIGHT.graphic());
        toggleButtonGroup.getToggles().add(toggleButton);


        toggleButton = new ToggleButton();
        toggleButton.setGraphic(MaterialDesignIcon.FORMAT_ALIGN_JUSTIFY.graphic());
        toggleButtonGroup.getToggles().add(toggleButton);

        setCenter(toggleButtonGroup);
    }
}
