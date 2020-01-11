package com.gluonapplication;

import com.gluonhq.charm.glisten.control.DropdownButton;
import com.gluonhq.charm.glisten.mvc.View;
import javafx.scene.control.MenuItem;

public class MyDropDownBtnView extends View {

    public MyDropDownBtnView() {
        DropdownButton dropdownButton = new DropdownButton();
        MenuItem menuItem = new MenuItem("Choice 1");
        dropdownButton.getItems().addAll(menuItem, new MenuItem("Choice 2"), new MenuItem("Choice 3"), new MenuItem("Choice 4"));
        dropdownButton.setSelectedItem(menuItem);
        setCenter(dropdownButton);
    }


}
