/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firstscreen.category;

import com.backend.api.model.category.Category;
import com.backend.api.model.details.Details;
import com.backend.api.server.client.ServerClient;
import com.backend.api.server.data.MessageData;
import com.firstscreen.AnimationUtils;
import com.firstscreen.FirstScreen;
import com.firstscreen.PathAnimationUtils;
import com.firstscreen.details.DetailsCache;
import static com.gluonhq.charm.glisten.application.MobileApplication.HOME_VIEW;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 *
 * @author asusadmin
 */
public class CategoryView extends View {

    public ScrollPane scrollPane;
    public BorderPane root = new BorderPane();
    public ServerClient serverClient;

    public DoubleProperty heightProperty = new SimpleDoubleProperty();
    public DoubleProperty widthProperty = new SimpleDoubleProperty();
    public DoubleProperty menuHeightProperty = new SimpleDoubleProperty();
    public String categoryLanguage;
    public FirstScreen mobileApplication;
    private List<Node> nodes = new ArrayList();
    private List<Label> labels = new ArrayList();
    private FlowPane flowPane;
    
    
    {
        flowPane = new FlowPane(Orientation.HORIZONTAL);
        flowPane.styleProperty().set("-fx-background-color: linear (0%,0%) to (100%,100%) stops (0.0,aqua) (1.0,red);");
        flowPane.prefWidthProperty().bind(widthProperty);
        flowPane.prefHeightProperty().bind(heightProperty);
        flowPane.setHgap(25);
        flowPane.setVgap(25);
        flowPane.setAlignment(Pos.CENTER);
    }
    
    public void refresh() {
        //Node node = initCentralContent(9);
       // node.styleProperty().set("-fx-background-color: linear (0%,0%) to (100%,100%) stops (0.0,aqua) (1.0,red);");
       initCentralContent(9);
        root.setCenter(flowPane);
        root.setBottom(initBottomContent());
        setCenter(root);
    }

    @Override
    protected void updateAppBar(AppBar appBar) {
        appBar.setVisible(false);
        appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> System.out.println("Menu")));
        appBar.setTitleText("Basic View");
        appBar.getActionItems().add(MaterialDesignIcon.SEARCH.button(e -> System.out.println("Search")));
    }

    private HBox initBottomContent() {
        HBox menu = new HBox(0);
        //menu.setPrefHeight(150);
        menu.setAlignment(Pos.CENTER);
        menu.styleProperty().set("-fx-background-color: linear (0%,0%) to (100%,100%) stops (0.0,green) (1.0,black);");

        Node imgHome = initImage("/back.png", "");
        Node imgUK = initImage("/UK.png", "uk");
        Node imgChina = initImage("/China.png", "ch");
        Node imgRussia = initImage("/Russia.png", "ru");
        menu.getChildren().addAll(imgHome, imgUK, imgChina, imgRussia);

        return menu;
    }

    private FlowPane initCentralContent(int amountOfItemsPerPage) {        
        List<Category> categoriesList = CategoryCache.getInstance().getCategories();
        /*FlowPane flowPane = new FlowPane(Orientation.HORIZONTAL);
        //if(nodes.isEmpty()){
          //  flowPane.styleProperty().set("-fx-background-color: linear (0%,0%) to (100%,100%) stops (0.0,aqua) (1.0,red);");
        //}
        flowPane.prefWidthProperty().bind(widthProperty);
        flowPane.prefHeightProperty().bind(heightProperty);
        flowPane.setHgap(25);
        flowPane.setVgap(25);
        flowPane.setAlignment(Pos.CENTER);*/
        flowPane.getChildren().clear();
        nodes.clear();

        for (int i = 0; i < amountOfItemsPerPage; i++) {
            Category category = categoriesList.get(i);
            InputStream imgIn = new ByteArrayInputStream(category.getImage());
            Image img = new Image(imgIn);

            if (nodes.size() == amountOfItemsPerPage) {
                ImageView node = (ImageView) nodes.get(i);
                node.setImage(img);
                if ("CH".equalsIgnoreCase(categoryLanguage)) {
                    labels.get(i).setText(category.getDescriptionB());
                } else if ("RU".equalsIgnoreCase(categoryLanguage)) {
                    labels.get(i).setText(category.getDescriptionB());
                } else {
                    labels.get(i).setText(category.getDescriptionB());
                }
                continue;
            }

            VBox vbox = new VBox();
            vbox.setAlignment(Pos.CENTER);
            ImageView node = new ImageView(img);
            node.setPreserveRatio(true);
            node.setFitWidth(80);
            node.setFitHeight(80);
            nodes.add(node);
            //    AnimationUtils.animateCategories(node);

            node.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {

                    //System.out.println(mobileApplication);
                    //categoryName = category.getName();
                    //  executorService.execute(()->{PathAnimationUtils.animateCategories(node);});
                    //PathAnimationUtils.animateCategories(node);
                    // node.toFront();
                    /*for(Node item: nodes){
                        if(!node.equals(item)){
                            FadeAnimationUtils.animateCategories(item);
                            //item.setOpacity(0);
                        }                        
                    }
                    for(Label label: labels){
                        // FadeAnimationUtils.animateCategories(label);
                        //label.setText("");
                    }*/
                    //PathAnimationUtils.animateCategories(node);
                    MessageData requestData = new MessageData();
                    requestData.setCategoryRequest(false);
                    requestData.setCategoryName(category.getName());

                    new Thread() {
                        @Override
                        public void run() {
                            PathAnimationUtils.animateCategories(node, widthProperty.get(), heightProperty.get());
                            List<Details> detailsList = (List<Details>) serverClient.readData(requestData);
                            DetailsCache.getInstance().setDetailses(detailsList);
                            mobileApplication.refreshDetailView(category);
                            Platform.runLater(() -> {
                                mobileApplication.switchView("details_view");
                            });
                        }

                    }.start();
                }

            });
            Label label = null;
            if ("CH".equalsIgnoreCase(categoryLanguage)) {
                label = new Label(category.getDescriptionB());
            } else if ("RU".equalsIgnoreCase(categoryLanguage)) {
                label = new Label(category.getDescriptionC());
            } else {
                label = new Label(category.getDescriptionA());
            }
            label.setTextFill(Color.WHITE);
            labels.add(label);
            vbox.getChildren().addAll(node, label);
            flowPane.getChildren().add(vbox);
        }

        return flowPane;
    }

    private Node initImage(String imgPath, String language) {
        Reflection effect = new Reflection();
        double xDelta = widthProperty.getValue() * 10 / 335;
        double yDelta = heightProperty.getValue() * 10 / 600;
        Image img = new Image(getClass().getResourceAsStream(imgPath));
        ImageView imgNode = new ImageView(img);

        imgNode.setFitHeight(heightProperty.get() * 0.1 - yDelta);
        imgNode.setFitWidth((widthProperty.getValue() - 5 * xDelta) * 0.25 - xDelta);

        imgNode.setEffect(effect);
        AnimationUtils.animate(imgNode, effect);
        imgNode.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent event) -> {

            if (language.isEmpty()) {
                //System.out.println(mobileApplication);
                mobileApplication.switchView(HOME_VIEW);
                return;
            }

            categoryLanguage = language;
            root.setCenter(initCentralContent(9));
            for (Node node : nodes) {
                AnimationUtils.animateCategories(node);
            }

        });

        HBox menu = new HBox(0);
        menu.setPadding(new Insets(xDelta, xDelta, xDelta, xDelta));
        menu.getChildren().add(imgNode);
        return menu;
    }

    public void backFromDetails() {
        root.setCenter(initCentralContent(9));
    }

}
