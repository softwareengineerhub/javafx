package com.gluonapplication;

import com.gluonhq.charm.down.Platform;
import com.gluonhq.charm.glisten.application.GlassPane;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.Avatar;
import com.gluonhq.charm.glisten.control.ProgressIndicator;
import com.gluonhq.charm.glisten.layout.Layer;
import com.gluonhq.charm.glisten.mvc.SplashView;
import com.gluonhq.charm.glisten.visual.Swatch;
import com.middleware.Categories2Dao;
import com.middleware.Details2Dao;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GluonApplication extends MobileApplication {
    private MySplashView mySplashView;
    public Categories2Dao categories2Dao = new Categories2Dao();
    public Details2Dao details2Dao = new Details2Dao();
    public MyAvatarView myAvatarView = new MyAvatarView(this);

    @Override
    public void init() {
        addViewFactory("DETAILS_VIEW", () -> myAvatarView);
        addViewFactory("CATEGORY_VIEW", ()->new  CategoriesView2(this));
        addViewFactory(HOME_VIEW, () -> {
            mySplashView = new MySplashView(this);
            return mySplashView;
        });

        ProgressIndicator pi = new ProgressIndicator();
        pi.setRadius(45);
        addLayerFactory("DETAILS_LOAD_LAYER", () -> MyLayerFactory.createLayer(pi,pi.getRadius(), pi.getRadius()));
    }

    @Override
    public void postInit(Scene scene) {
        mySplashView.widthProperty.bind(scene.widthProperty());
        mySplashView.heightProperty.bind(scene.heightProperty());

        //switchView("category2_view");
        Swatch.BLUE.assignTo(scene);

        ((Stage) scene.getWindow()).getIcons().add(new Image(GluonApplication.class.getResourceAsStream("/icon.png")));
    }

    /*public void mySwitch(String viewName){
        System.out.println("Here");
        showMessage("qqqqqqqqqqqqqqqqq");
    }*/


}
