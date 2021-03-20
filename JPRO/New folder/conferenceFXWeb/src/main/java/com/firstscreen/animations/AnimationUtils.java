package com.firstscreen.animations;

import com.firstscreen.category2.Category2View;
import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

import java.util.concurrent.atomic.AtomicBoolean;

public class AnimationUtils {

    public static void animate(Node node, Reflection effect) {
        final ColorAdjust effectPressed = new ColorAdjust();
        effectPressed.setBrightness(-0.5);
        String DURATION = "300ms";
        double SCALE = 1.3;
        ScaleTransition animationGrow = new ScaleTransition(Duration.valueOf(DURATION), node);
        animationGrow.setToX(SCALE);
        animationGrow.setToY(SCALE);
        final ScaleTransition animationShrink = new ScaleTransition(Duration.valueOf(DURATION), node);
        animationShrink.setToX(1);
        animationShrink.setToY(1);

        node.setOnMouseEntered((MouseEvent event) -> {
           /* for(RotateTransition rotateTransition: rotateTransitions){
                rotateTransition.play();
            }*/

            effect.setInput(effectPressed);
            animationGrow.playFromStart();
            animationShrink.stop();
        });

        node.setOnMouseExited((MouseEvent event) -> {
            //  for(RotateTransition rotateTransition: rotateTransitions){
            //    rotateTransition.stop();
            // }
            /*for(RotateTransition rotateTransition: rotateTransitions){
                rotateTransition.setToAngle(90);
                //rotateTransition.stop();
            }*/

            effect.setInput(null);
            animationGrow.stop();
            animationShrink.playFromStart();
        });
    }

    public static void animateCategories(Node node, StackPane root, int pathIndex, boolean needToDetails, GridPane gridPane){
        RotateTransition rotateTransition = new RotateTransition(Duration.millis(300), node);
        rotateTransition.setFromAngle(-15);
        rotateTransition.setToAngle(15);
        // rotateTransition.setToAngle(0);

        //rotateTransition.setCycleCount(Timeline.INDEFINITE);
        rotateTransition.setCycleCount(4);
        rotateTransition.setAutoReverse(true);
        rotateTransition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                RotateTransition rotateTransition = new RotateTransition(Duration.millis(300), node);
                //rotateTransition.setFromAngle(-15);
                rotateTransition.setToAngle(0);
                rotateTransition.play();
                rotateTransition.setOnFinished(e->{


                    if(needToDetails) {

                        Category2View category2View = new Category2View(root, pathIndex, gridPane);
                        category2View.refreshFirst();
                    }
                });

            }
        });
        // rotateTransitions[i++]=rotateTransition;
        rotateTransition.play();


    }
}
