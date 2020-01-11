package com.gluonapplication;

import com.gluonhq.charm.glisten.control.CharmListView;
import com.gluonhq.charm.glisten.mvc.View;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MyCharmListView extends View {

    public MyCharmListView() {
        ObservableList<String> names = FXCollections.observableArrayList(
                "Julia", "Ian", "Sue", "Matthew", "Hannah", "Stephan", "Denise","Julia", "Ian", "Sue", "Matthew", "Hannah", "Stephan", "Denise");

        CharmListView<String, Integer> charmListView = new CharmListView<>(names);
        //charmListView.setHeadersFunction(String::length);
      // charmListView.setHeadersFunction(String::length);
        setCenter(charmListView);
    }
}
