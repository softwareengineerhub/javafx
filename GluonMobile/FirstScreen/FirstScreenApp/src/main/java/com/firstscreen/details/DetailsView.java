/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firstscreen.details;

import com.backend.api.model.category.Category;
import com.backend.api.model.details.Details;
import com.firstscreen.AnimationUtils;
import com.firstscreen.FirstScreen;
import com.gluonhq.charm.down.Services;
import com.gluonhq.charm.down.plugins.VideoService;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.Effect;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

/**
 *
 * @author asusadmin
 */
public class DetailsView extends View {

    public ScrollPane scrollPane;
    public BorderPane root = new BorderPane();
    public DoubleProperty heightProperty = new SimpleDoubleProperty();
    public DoubleProperty widthProperty = new SimpleDoubleProperty();
    public static String SOUND_URL = "http://it-interview.org:8080/backend-api-web/SoundServlet?category=%s&details=%s&country=%s";
    private Category category;
    public int selectedDetails;
    // private double xDelta = getWidth()*10/335;

    public FirstScreen mobileApplication;

    public void refresh(Category category) {
        this.category = category;
        root.setBottom(initBottomContent());
        //root.setCenter(initImageView(CategoryView.categoryName, CategoryView.categoryLanguage));
        root.setCenter(initImageView());
        setCenter(root);
    }

    private Shelf initImageView() {
        List<Details> detailsList = DetailsCache.getInstance().getDetailses();
        Image[] images = new Image[detailsList.size()];
        for (int i = 0; i < images.length; i++) {
            //images[i] = new Image(getClass().getResourceAsStream("/animals/animal" + (i + 1) + ".jpg"));
            InputStream imgIn = new ByteArrayInputStream(detailsList.get(i).getImage());
            images[i] = new Image(imgIn);
        }
        Shelf displayShelf = new Shelf(images, this);
        displayShelf.setPrefSize(300, 300);
        return displayShelf;
    }

    @Override
    protected void updateAppBar(AppBar appBar) {
        appBar.setVisible(false);
        appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> System.out.println("Menu")));
        appBar.setTitleText("Basic View");
        appBar.getActionItems().add(MaterialDesignIcon.SEARCH.button(e -> System.out.println("Search")));
    }

    private HBox initBottomContent() {
        //HBox menu = new HBox(20);
        HBox menu = new HBox(0);
        // HBox menu = new HBox(this.getHeight()/20);
        // menu.setPadding(new Insets(20, 20, 20, 20));
        menu.setAlignment(Pos.CENTER);
        menu.styleProperty().set("-fx-background-color: linear (0%,0%) to (100%,100%) stops (0.0,green) (1.0,black);");
        Node imgBack = initImage("/back.png", "");
        Node imgUK = initImage("/UK.png", "en");
        Node imgChina = initImage("/China.png", "ch");
        Node imgRussia = initImage("/Russia.png", "ru");
        menu.getChildren().addAll(imgBack, imgUK, imgChina, imgRussia);
        return menu;
    }

    private Node initImage(String imgPath, String language) {
        Reflection effect = new Reflection();
        double xDelta = widthProperty.getValue() * 10 / 335;
        double yDelta = heightProperty.getValue() * 10 / 600;
        Image img = new Image(getClass().getResourceAsStream(imgPath));
        ImageView imgNode = new ImageView(img);
        //imgNode.setFitHeight(35);
        //imgNode.setFitWidth(55);

        imgNode.setFitHeight(heightProperty.get() * 0.1 - yDelta);
        imgNode.setFitWidth((widthProperty.getValue() - 5 * xDelta) * 0.25 - xDelta);

        imgNode.setEffect(effect);
        AnimationUtils.animate(imgNode, effect);
        imgNode.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent event) -> {

            if (language.isEmpty()) {
                Services.get(VideoService.class).ifPresent(video -> {
                    video.stop();
                });

                mobileApplication.backFromDetails();
                mobileApplication.switchView("category_view");
                return;
            }

            Services.get(VideoService.class).ifPresent(video -> {
                video.stop();
                video.setControlsVisible(false);
                String url = String.format(SOUND_URL, category.getName(), DetailsCache.getInstance().getDetailses().get(selectedDetails).getName(), language);
                video.getPlaylist().add(url);
                video.setLooping(false);
                video.play();
            });

        });

        HBox menu = new HBox(0);
        menu.setPadding(new Insets(xDelta, xDelta, xDelta, xDelta));
        menu.getChildren().add(imgNode);
        return menu;
    }

}
