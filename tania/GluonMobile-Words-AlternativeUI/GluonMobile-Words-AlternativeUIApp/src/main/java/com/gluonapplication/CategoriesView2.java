package com.gluonapplication;

import com.backend.api.model.category.Category;
import com.gluonhq.charm.down.Services;
import com.gluonhq.charm.down.plugins.ShareService;
import com.gluonhq.charm.glisten.control.*;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

import java.io.*;

import static com.gluonhq.charm.glisten.application.MobileApplication.HOME_VIEW;

public class CategoriesView2 extends View {

    private GluonApplication gluonApplication;
    private ObservableList<Category> names;

    public CategoriesView2(GluonApplication gluonApplication) {
        this.gluonApplication = gluonApplication;

        names = FXCollections.observableArrayList(gluonApplication.categories2Dao.getCurrentCategories());
        CharmListView<Category, Integer> charmListView = new CharmListView<>(names);
        charmListView.selectedItemProperty().addListener(new ChangeListener<Category>() {
            @Override
            public void changed(ObservableValue<? extends Category> observable, Category oldValue, Category newValue) {
                

                /*gluonApplication.showLayer("DETAILS_LOAD_LAYER");

                new Thread(()->{
                    gluonApplication.myAvatarView.initData(newValue.getName());
                    
                    javafx.application.Platform.runLater(()->{
                        gluonApplication.hideLayer("DETAILS_LOAD_LAYER");
                        gluonApplication.switchView("DETAILS_VIEW");
                    });
                }).start();*/
                gluonApplication.switchView(HOME_VIEW);

                new Thread(() -> {
                    gluonApplication.myAvatarView.initData(newValue.getName());
                    
                    javafx.application.Platform.runLater(() -> {
                        gluonApplication.switchView("DETAILS_VIEW");
                    });
                }).start();

            }
        });

        charmListView.setCellFactory(p -> new CharmListCell<Category>() {

            @Override
            public void updateItem(Category item, boolean empty) {
                super.updateItem(item, empty);
                BorderPane panel = new BorderPane();

                Label labelA = new Label(item.getDescriptionA());
                Label labelB = new Label(item.getDescriptionB());
                Label labelC = new Label(item.getDescriptionC());
                Label labelD = new Label(item.getDescriptionD());

                if (item.getImage() == null) {
                    try (ByteArrayInputStream in = new ByteArrayInputStream(item.getImageData());) {
                        Image img = new Image(in);
                        item.setImage(img);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }

                ImageView imageView = new ImageView(item.getImage());
                imageView.setFitWidth(325);
                imageView.setFitHeight(210);
                panel.setCenter(imageView);

                HBox top = new HBox();
                top.styleProperty().set("-fx-background-color: #ffffff67;");
                DropShadow dropShadow = new DropShadow();
                dropShadow.setColor(Color.valueOf("#848282"));
                top.setEffect(dropShadow);
                top.setAlignment(Pos.CENTER);
                top.setSpacing(20);
                top.setPadding(new Insets(10, 10, 10, 10));
                top.getChildren().addAll(labelA, labelB);
                panel.setTop(top);

                HBox bottom = new HBox();
                //bottom.styleProperty().set("-fx-background-color: #39a9b2");
                bottom.styleProperty().set("-fx-background-color: #ffffff67;");
                dropShadow = new DropShadow();
                dropShadow.setColor(Color.valueOf("#848282"));
                bottom.setEffect(dropShadow);

                bottom.setAlignment(Pos.CENTER);
                bottom.setSpacing(20);
                bottom.setPadding(new Insets(10, 10, 10, 10));
                bottom.getChildren().addAll(labelC, labelD);
                panel.setBottom(bottom);
                setGraphic(panel);
            }

        });
        setCenter(charmListView);
        Toast toast = new Toast("Welcome");
        //toast.setDuration(LENGTH_LONG);
        //toast.setDuration(Message.LENGTH_SHORT);
        toast.show();
        //toast.cancel();
    }

    @Override
    protected void updateAppBar(AppBar appBar) {
        appBar.setVisible(true);
        appBar.setTitleText("Choose Category to Learn");
        
        appBar.getActionItems().add(MaterialDesignIcon.REFRESH.button(e -> {

            Toast toast = new Toast("Refresh");
            toast.show();

            Runnable r = () -> {

                gluonApplication.categories2Dao.setCurrentCategories(null);
                gluonApplication.categories2Dao.findAll();
                while (gluonApplication.categories2Dao.getCurrentCategories() == null) {
                }
                names.clear();
                names.addAll(gluonApplication.categories2Dao.getCurrentCategories());
                javafx.application.Platform.runLater(() -> {
                    gluonApplication.switchView("CATEGORY_VIEW");
                });
            };

            if (gluonApplication.categories2Dao.needToRefreshByVersion()) {
                gluonApplication.switchView(HOME_VIEW);
                Thread t = new Thread(r);
                t.start();
            }

        }));

        appBar.getActionItems().add(MaterialDesignIcon.SHARE.button(e -> {
            Services.get(ShareService.class).ifPresent(service -> service.share("This is the subject", "This is the content of the message"));
        }));
    }
}
