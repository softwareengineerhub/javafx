package com.firstscreen;

import com.backend.api.model.category.Category;
import com.backend.api.server.client.ServerClient;
import com.backend.api.server.client.ServerClientImpl;
import com.backend.api.server.data.MessageData;
import com.firstscreen.category.CategoryCache;
import com.firstscreen.login.LoginView;
import com.firstscreen.details.DetailsView;
import com.firstscreen.category.CategoryView;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.license.License;
import com.gluonhq.charm.glisten.visual.Swatch;
import java.util.List;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


@License(key="e7f092a3-8f19-4545-82f8-f8afbb19c611")
public class FirstScreen extends MobileApplication {

    private LoginView loginView = new LoginView();
    private CategoryView categoryView = new CategoryView();
    private DetailsView detailsView = new DetailsView();
    private ServerClient serverClient = new ServerClientImpl("52.39.234.36", 8083);
    //private ServerClient serverClient = new ServerClientImpl("localhost", 8083);

    @Override
    public void init() {
        System.out.println("init()");
        long start = System.currentTimeMillis();
        MessageData requestData = new MessageData();
        requestData.setCategoryRequest(true);
        List<Category> categories = (List<Category>) serverClient.readData(requestData);
        CategoryCache.getInstance().setCategories(categories);
        System.out.println("time: " + (System.currentTimeMillis() - start));
        System.out.println("categories.size=" + categories.size());
        //addViewFactory(HOME_VIEW, BasicView::new);
        addViewFactory(HOME_VIEW, () -> {
            return loginView;
        });
        addViewFactory("category_view", () -> {
            return categoryView;
        });
        addViewFactory("details_view", () -> {
            return detailsView;
        });
        categoryView.mobileApplication = this;
        categoryView.serverClient = serverClient;
        detailsView.mobileApplication = this;
    }

    @Override
    public void postInit(Scene scene) {
        loginView.startBtn.setOnAction(e -> {
            categoryView.refresh();
            switchView("category_view");
        }
        );
        System.out.println(scene.getHeight());
        System.out.println(scene.getWidth());
        loginView.widthProperty.bind(scene.widthProperty());
        loginView.heightProperty.bind(scene.heightProperty());
        
        
        detailsView.widthProperty.bind(scene.widthProperty());
        detailsView.heightProperty.bind(scene.heightProperty());        
        
        
        categoryView.widthProperty.bind(scene.widthProperty());
        categoryView.heightProperty.bind(scene.heightProperty());        
        
        Swatch.BLUE.assignTo(scene);
        ((Stage) scene.getWindow()).getIcons().add(new Image(FirstScreen.class.getResourceAsStream("/LOGO.png")));

    }

    public void refreshDetailView(Category category) {
        detailsView.refresh(category);
    }
    
    public void backFromDetails() {
        categoryView.backFromDetails();
    }
}
