/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firstscreen.details;

import com.backend.api.model.category.Category;
import com.backend.api.model.details.Details;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import com.firstscreen.animations.AnimationUtils;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

/**
 *
 * @author asusadmin
 */
public class DetailsView {

    public ScrollPane scrollPane;
    public BorderPane root = new BorderPane();
    public DoubleProperty heightProperty = new SimpleDoubleProperty();
    public DoubleProperty widthProperty = new SimpleDoubleProperty();
    public static String SOUND_URL = "http://it-interview.org:8080/backend-api-web/SoundServlet?category=%s&details=%s&country=%s";
    private Category category;
    public int selectedDetails;
    private StackPane rootStackPane;
    // private double xDelta = getWidth()*10/335;


    private StackPane getRootStackPane;



    public void refresh(Category category, StackPane rootStackPane) {
        this.category = category;
        root.setBottom(initBottomContent());
        this.rootStackPane = rootStackPane;
        //root.setCenter(initImageView(CategoryView.categoryName, CategoryView.categoryLanguage));
        root.setCenter(initImageView());
        rootStackPane.getChildren().add(root);
    }

    private Shelf initImageView() {
        List<Details> detailsList = DetailsCache.getInstance().getDetailses();
        Image[] images = new Image[detailsList.size()];
        for (int i = 0; i < images.length; i++) {
            //images[i] = new Image(getClass().getResourceAsStream("/animals/animal" + (i + 1) + ".jpg"));
            //InputStream imgIn = new ByteArrayInputStream(detailsList.get(i).getImage());
            //images[i] = new Image(imgIn);
        }
        //Shelf displayShelf = new Shelf(images, this);
        Shelf displayShelf = new Shelf(images, this);
        displayShelf.setPrefSize(300, 300);
        return displayShelf;
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

                /*mobileApplication.backFromDetails();
                mobileApplication.switchView("category_view");
                return;*/
            }



        });

        HBox menu = new HBox(0);
        menu.setPadding(new Insets(xDelta, xDelta, xDelta, xDelta));
        menu.getChildren().add(imgNode);
        return menu;
    }

}
