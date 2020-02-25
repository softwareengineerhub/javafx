package com.firstscreen.category2;

import com.backend.api.model.category.Category;
import com.firstscreen.FirstScreen;
import com.firstscreen.ShowError;
import com.firstscreen.animations.AnimationUtils;
import com.firstscreen.details.PerspectiveImage;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.animation.TranslateTransition;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;
import java.util.List;

import static com.gluonhq.charm.glisten.application.MobileApplication.HOME_VIEW;

public class Category2View extends View {

    public DoubleProperty heightProperty = new SimpleDoubleProperty();
    public DoubleProperty widthProperty = new SimpleDoubleProperty();
    private double startX;
    private Text topText = new Text("");
    private Text bottomText = new Text("");
    private FirstScreen mobileApplication;
    private CategoryShelf displayShelf;
    private StackPane stackPane = new StackPane();
    //private List<Category> categoriesList;


    public Category2View(FirstScreen mobileApplication){
        this.mobileApplication=mobileApplication;
        displayShelf = new CategoryShelf(topText, bottomText, mobileApplication);
        mobileApplication.categoriesDao2.callForVersion();
        mobileApplication.categoriesDao2.findAll();
      //  this.categoriesList = mobileApplication.categoriesDao2.getCurrentCategories();
    }

    public void refreshFirst(boolean needToRefresh) {
        if(needToRefresh){
            mobileApplication.categoriesDao2.setCurrentCategories(null);
            mobileApplication.categoriesDao2.findAll();
        }
        while(mobileApplication.categoriesDao2.getCurrentCategories()==null){

        }
        initHomeButton();
        initImageView();
        if (stackPane.getChildren().isEmpty()) {
            stackPane.getChildren().addAll(homeButton, topText, bottomText, displayShelf);
            //stackPane.getChildren().addAll(topText, bottomText, displayShelf);
            setCenter(stackPane);


            TranslateTransition topTransition = new TranslateTransition(Duration.millis(1), topText);
            topTransition.setByY(-heightProperty.getValue() / 2 + PerspectiveImage.HEIGHT / 4);

            TranslateTransition bottomTransition = new TranslateTransition(Duration.millis(1), bottomText);
            bottomTransition.setByY(-(-heightProperty.getValue() / 2 + PerspectiveImage.HEIGHT / 4));

            topTransition.play();
            bottomTransition.play();
            topText.toFront();
            homeButton.toFront();
            bottomText.toFront();
            AnimationUtils.pathTransition(homeButton);
        }else{
            mobileApplication.categoriesDao2.findAll();
        }
    }

    private CategoryShelf initImageView() {
        try {
            displayShelf.setCategoriesList(mobileApplication.categoriesDao2.getCurrentCategories());
            displayShelf.refresh();
        } catch (Exception ex) {
           ex.printStackTrace();
            // ShowError.showError(ex, false);
        }
        return displayShelf;
    }


    @Override
    protected void updateAppBar(AppBar appBar) {
        appBar.setVisible(false);
        appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> {}));
        appBar.setTitleText("Basic View");
        appBar.getActionItems().add(MaterialDesignIcon.SEARCH.button(e -> {}));
    }


    {

        //topText.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
        topText.setFont(Font.font("Noto Sans CJK SC Regular", FontWeight.BOLD, 20));
        bottomText.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
        //t.setFill(Color.blackRED);

        stackPane.setOnMousePressed(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent event) {
                startX = event.getX();
            }

        });

        stackPane.setOnMouseReleased(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                if (!event.getTarget().toString().contains("ImageView")) {
                    double currentX = event.getX();
                    if (currentX < startX) {
                        displayShelf.shift(-1);
                    } else {
                        displayShelf.shift(1);
                    }
                    startX = 0;
                }
            }
        });

    }


    private ImageView homeButton;

    private void initHomeButton() {
        if (homeButton != null) {
            return;
        }


        Image img = new Image(getClass().getResourceAsStream("/home2.png"));

        double xDelta = widthProperty.getValue() * 10 / 335;
        double yDelta = heightProperty.getValue() * 10 / 600;


        homeButton = new ImageView(img);


        homeButton.setFitHeight(heightProperty.get() * 0.1 - yDelta);
        homeButton.setFitWidth((widthProperty.getValue() - 5 * xDelta) * 0.25 - xDelta);

        homeButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent event) -> {

            mobileApplication.switchView(HOME_VIEW);

        });

        //  homeButton.setX(10);
        // homeButton.setY(10);

    }



}
