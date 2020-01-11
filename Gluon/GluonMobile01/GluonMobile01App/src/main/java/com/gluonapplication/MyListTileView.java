package com.gluonapplication;

import com.gluonhq.charm.glisten.control.CharmListCell;
import com.gluonhq.charm.glisten.control.CharmListView;
import com.gluonhq.charm.glisten.control.ListTile;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

public class MyListTileView extends View {

    public MyListTileView() {

        ObservableList<String> names = FXCollections.observableArrayList(
                "Julia", "Ian", "Sue", "Matthew", "Hannah", "Stephan", "Denise","Julia", "Ian", "Sue", "Matthew", "Hannah", "Stephan", "Denise");

        CharmListView<String, Integer> charmListView = new CharmListView<>(names);
        charmListView.setCellFactory(p -> new CharmListCell<String>() {

            @Override
            public void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (item != null && !empty) {
                    VBox buttons = new VBox(MaterialDesignIcon.STAR_BORDER.graphic());
                    buttons.setMaxHeight(Double.MAX_VALUE);
                    buttons.setAlignment(Pos.TOP_RIGHT);
                    ListTile tile = new ListTile();
                    tile.textProperty().setAll(item.toString());
                    tile.setSecondaryGraphic(buttons);
                    tile.setPrefHeight(40);
                    tile.setOnMouseClicked(e -> buttons.getChildren().setAll(MaterialDesignIcon.STAR.graphic()));
                    setText(null);
                    setGraphic(tile);
                } else {
                    setText(null);
                    setGraphic(null);
                }
            }

        });
        setCenter(charmListView);

    }
}
