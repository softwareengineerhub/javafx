package com.gluonapplication;

import com.gluonhq.charm.glisten.control.Rating;
import com.gluonhq.charm.glisten.mvc.View;
import javafx.scene.layout.VBox;

public class MyRatingView extends View {

    public MyRatingView() {

        Rating rating = new Rating();

        VBox vBox = new VBox();
        vBox.getChildren().add(rating);

        Rating rating2 = new Rating();
        rating2.setPartialRating(true);
        vBox.getChildren().add(rating2);

        Rating rating3 = new Rating();
        rating3.setUpdateOnHover(true);
        vBox.getChildren().add(rating3);

        setCenter(vBox);
    }
}
