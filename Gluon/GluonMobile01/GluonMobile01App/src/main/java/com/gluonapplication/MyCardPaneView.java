package com.gluonapplication;

import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.control.CardPane;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.scene.control.Label;

public class MyCardPaneView extends View {

    public MyCardPaneView() {
        CardPane cardPane = new CardPane();
        //cardPane.getCellFactory().call()
        cardPane.getItems().addAll(getLabel("Card 1"), getLabel("Card 2"), getLabel("Card 3"));
        setCenter(cardPane);
    }


    private Label getLabel(String text) {
        Label label = new Label(text);
        label.setStyle("-fx-padding:10;");
        return label;
    }


    /*@Override
    protected void updateAppBar(AppBar appBar) {
        appBar.setProgressBarVisible(true);
        appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> System.out.println("Menu")));
        appBar.setTitleText("Basic View");
        appBar.getActionItems().add(MaterialDesignIcon.SEARCH.button(e -> System.out.println("Search")));
    }*/
}
