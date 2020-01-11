package com.gluonapplication;

import com.gluonhq.charm.glisten.control.ExpansionPanel;
import com.gluonhq.charm.glisten.control.ExpansionPanelContainer;
import com.gluonhq.charm.glisten.mvc.View;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class MyExpansionPanelContainerView extends View {

    public MyExpansionPanelContainerView() {
        ExpansionPanelContainer container = new ExpansionPanelContainer();
        container.setAccessibleText("AccessibleText");

        ExpansionPanel panel = new ExpansionPanel();
        Button btn = new Button("Content");
        panel.setExpandedContent(btn);
        panel.setExpanded(true);
        //panel.setCollapsedContent(new Label("Collapsed"));

        container.getItems().add(panel);
        setCenter(container);
    }
}
