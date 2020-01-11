package com.gluonapplication;

import com.gluonhq.charm.glisten.control.*;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class MyAvatarView extends View {

    public MyAvatarView() {
        List<Speaker> list = new ArrayList();
        Speaker sp1 = new Speaker();
        Speaker sp2 = new Speaker();
        Speaker sp3 = new Speaker();
        list.add(sp1);
        list.add(sp2);
        list.add(sp3);
        list.add(new Speaker());
        list.add(new Speaker());
        list.add(new Speaker());
        list.add(new Speaker());
        list.add(new Speaker());
        list.add(new Speaker());
        list.add(new Speaker());
        list.add(new Speaker());
        ObservableList<Speaker> speakers = FXCollections.observableList(list);

        AvatarPane<Speaker> avatarPane = new AvatarPane(speakers);
        avatarPane.setCollapsible(true);
        avatarPane.setAvatarFactory(speaker -> {
            Avatar avatar = new Avatar();
            Image image = new Image(speaker.getPicture());
            avatar.setImage(image);
            return avatar;
        });

        avatarPane.setContentFactory(speaker -> {
            VBox container = new VBox();
            Label name = new Label(speaker.getFullName());
            name.setWrapText(true);
            Label jobTitle = new Label(speaker.getJobTitle());
            jobTitle.setWrapText(true);
            Label company = new Label(speaker.getCompany());
            company.setWrapText(true);
            Label summary = new Label(speaker.getSummary());
            summary.setWrapText(true);
            container.getChildren().addAll(name, jobTitle, company, summary);
            return container;
        });


        setCenter(avatarPane);
        setBottom(createBottom());
    }

    private BottomNavigation createBottom(){
        BottomNavigation bottomNavigation = new BottomNavigation();


        //ToggleButton btn1 = new ToggleButton("View1", MaterialDesignIcon.DASHBOARD.graphic(), e -> showView("view1"));
        Button b1 = new Button();
        b1.setGraphic(new Icon(MaterialDesignIcon.DASHBOARD));
        b1.setOnAction(e->new Alert(Alert.AlertType.INFORMATION).showAndWait());

        Button b2 = new Button();
        b2.setGraphic(new Icon(MaterialDesignIcon.AC_UNIT));
        b2.setOnAction(e->new Alert(Alert.AlertType.INFORMATION).showAndWait());

        Button b3 = new Button();
        b3.setGraphic(new Icon(MaterialDesignIcon.MAP));
        b3.setOnAction(e->new Alert(Alert.AlertType.INFORMATION).showAndWait());

        //bottomNavigation.getActionItems().add(new BottomNavigationButton());

        BottomNavigationButton btn1 = new BottomNavigationButton();
        btn1.setGraphic(new Icon(MaterialDesignIcon.DASHBOARD));
        btn1.setOnAction(e->new Alert(Alert.AlertType.INFORMATION).showAndWait());

        BottomNavigationButton btn2 = new BottomNavigationButton();
        btn2.setGraphic(new Icon(MaterialDesignIcon.AC_UNIT));
        btn2.setOnAction(e->new Alert(Alert.AlertType.INFORMATION).showAndWait());

        BottomNavigationButton btn3 = new BottomNavigationButton();
        btn3.setGraphic(new Icon(MaterialDesignIcon.MAP));
        btn3.setOnAction(e->new Alert(Alert.AlertType.INFORMATION).showAndWait());

        bottomNavigation.getActionItems().addAll(btn1, btn2, btn3);
        return  bottomNavigation;
    }


    @Override
    protected void updateAppBar(AppBar appBar) {
       // appBar.setVisible(false);
        appBar.setProgress(0.5);
        appBar.setProgressBarVisible(true);
        appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> System.out.println("Menu")));
        appBar.setTitleText("Basic View");
        appBar.getActionItems().add(MaterialDesignIcon.SEARCH.button(e -> System.out.println("Search")));
    }
}
