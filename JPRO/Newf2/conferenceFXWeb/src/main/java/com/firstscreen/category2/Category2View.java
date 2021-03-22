package com.firstscreen.category2;

import com.backend.api.model.category.Category;
import com.firstscreen.details.PerspectiveImage;
import javafx.animation.TranslateTransition;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;
import java.util.List;

public class Category2View {

    private DoubleProperty heightProperty = new SimpleDoubleProperty();
    private DoubleProperty widthProperty = new SimpleDoubleProperty();
    private double startX;
    private Text topText = new Text("");
    private Text bottomText = new Text("");
    private Text amountText = new Text("");
    private CategoryShelf displayShelf;
    private StackPane stackPane = new StackPane();
    private Categories2Dao categories2Dao = new Categories2Dao();
    private List<Category> categoriesList;
    private StackPane root;
    private int pathIndex;
    private ImageView homeButton;
    private GridPane gridPane;


    public Category2View(StackPane root, int pathIndex, GridPane gridPane){
        this.gridPane = gridPane;
        //rootChildren = root.getChildren();
        initHomeButton();
        root.getChildren().clear();
        this.pathIndex = pathIndex;

        displayShelf = new CategoryShelf(topText, bottomText, amountText, homeButton, root, pathIndex);
        //categories2Dao.findAll(pathIndex);
        //this.categoriesList = categories2Dao.getCurrentCategories(pathIndex);
        this.root=root;
        //mobileApplication.categoriesDao2.findAll();
      //  this.categoriesList = mobileApplication.categoriesDao2.getCurrentCategories();
    }

    public void refreshFirst() {
        categories2Dao.findAll(pathIndex);
        /*while(categories2Dao.getCurrentCategories(pathIndex)==null){

        }*/
        //initHomeButton();
        initImageView();

       // if (stackPane.getChildren().isEmpty()) {
        if (root.getChildren().isEmpty()) {
           // stackPane.getChildren().addAll(homeButton, topText, bottomText, displayShelf);
           // stackPane.getChildren().addAll(topText, bottomText, displayShelf);
           // root.getChildren().addAll(topText, bottomText, displayShelf);
            //root.getChildren().add(stackPane);

           // VBox vbox = new VBox();

            //vbox.getChildren().addAll(topText, displayShelf, bottomText);
            root.getChildren().addAll(displayShelf);
            //root.getChildren().addAll(topText, displayShelf, bottomText);


            /*TranslateTransition topTransition = new TranslateTransition(Duration.millis(1), topText);
            topTransition.setByY(-heightProperty.getValue() / 2 + PerspectiveImage.HEIGHT / 4);

            TranslateTransition bottomTransition = new TranslateTransition(Duration.millis(1), bottomText);
            bottomTransition.setByY(-(-heightProperty.getValue() / 2 + PerspectiveImage.HEIGHT / 4));

            topTransition.play();
            bottomTransition.play();
            topText.toFront();
           // homeButton.toFront();
            bottomText.toFront();*/
           // AnimationUtils.pathTransition(homeButton);

        }else{

         //   categories2Dao.findAll(pathIndex);
            //mobileApplication.categoriesDao2.findAll();
        }
    }

    private CategoryShelf initImageView() {
        try {
            displayShelf.setCategoriesList(categories2Dao.getCurrentCategories());
            displayShelf.refresh();
        } catch (Exception ex) {
           ex.printStackTrace();
            // ShowError.showError(ex, false);
        }
        return displayShelf;
    }





    {

        //topText.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
        topText.setFont(Font.font("Noto Sans CJK SC Regular", FontWeight.BOLD, 20));
        bottomText.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
        amountText.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
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

          //  mobileApplication.switchView(HOME_VIEW);
            back();

        });

        //  homeButton.setX(10);
        // homeButton.setY(10);

    }

    private void back(){
        root.getChildren().clear();
        root.getChildren().addAll(gridPane);
        root.setStyle("-fx-background-color: linear-gradient(to right, red, aqua);");
    }



}
