package com.gluonapplication;

import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.ProgressIndicator;
import com.gluonhq.charm.glisten.visual.Swatch;
import com.middleware.Categories2Dao;
import com.middleware.Details2Dao;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class GluonApplication extends MobileApplication {
    private MySplashView mySplashView;
    public Categories2Dao categories2Dao = new Categories2Dao();
    public Details2Dao details2Dao = new Details2Dao();
    public MyAvatarView myAvatarView = new MyAvatarView(this);

    @Override
    public void init() {
        addViewFactory("DETAILS_VIEW", () -> myAvatarView);
        addViewFactory("CATEGORY_VIEW", () -> new CategoriesView2(this));
        addViewFactory(HOME_VIEW, () -> {
            mySplashView = new MySplashView(this);
            return mySplashView;
        });
        ProgressIndicator pi = new ProgressIndicator();
        pi.setRadius(45);
        addLayerFactory("DETAILS_LOAD_LAYER", () -> MyLayerFactory.createLayer(pi, pi.getRadius(), pi.getRadius()));
    }

    @Override
    public void postInit(Scene scene) {
        mySplashView.widthProperty.bind(scene.widthProperty());
        mySplashView.heightProperty.bind(scene.heightProperty());
        Swatch.BLUE.assignTo(scene);
        ((Stage) scene.getWindow()).getIcons().add(new Image(GluonApplication.class.getResourceAsStream("/icon.png")));
    }

}
