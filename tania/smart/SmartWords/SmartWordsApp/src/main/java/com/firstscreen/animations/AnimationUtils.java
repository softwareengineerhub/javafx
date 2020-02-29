package com.firstscreen.animations;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

import java.util.concurrent.atomic.AtomicBoolean;

public class AnimationUtils {

    private static AtomicBoolean startNextAnimation = new AtomicBoolean(true);

    public static void animateDetailsChanged(ImageView view, Image updatedImg) {
        startNextAnimation.set(false);
        SequentialTransition sequentialFadeTransition = initFadeTransition(view, updatedImg);

        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(450), view);
        scaleTransition.setByX(0.2);
        scaleTransition.setByY(0.2);
        scaleTransition.setCycleCount(2);
        scaleTransition.setAutoReverse(true);

        ParallelTransition parallelTransition = new ParallelTransition();
        parallelTransition.getChildren().addAll(sequentialFadeTransition, scaleTransition);
        parallelTransition.play();
        parallelTransition.setOnFinished(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                startNextAnimation.set(true);
            }
        });

    }

    private static SequentialTransition initFadeTransition(ImageView view, Image updatedImg){
        SequentialTransition sequentialFadeTransition = new SequentialTransition();
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(650), view);
        fadeTransition.setFromValue(1.0f);
        fadeTransition.setToValue(0.25f);
        fadeTransition.setOnFinished(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                view.setImage(updatedImg);
            }
        });
        FadeTransition fadeTransition2 = new FadeTransition(Duration.millis(650), view);
        fadeTransition2.setFromValue(0.25f);
        fadeTransition2.setToValue(1.0f);
        sequentialFadeTransition.getChildren().addAll(fadeTransition, fadeTransition2);
        return sequentialFadeTransition;
    }

    public static boolean canStartNewAnimation(){
        return startNextAnimation.get();
    }


    public static void pathTransition(Node node){
        node.setVisible(false);
        Path path = new Path();
        MoveTo moveTo = new MoveTo(0, 0);
        LineTo lineTo = new LineTo(-100, 275);
        path.getElements().add(moveTo);
        path.getElements().add(lineTo);
        PathTransition pathTransition = new PathTransition();
        pathTransition.setNode(node);
        pathTransition.setPath(path);

        //Setting the orientation of the path
        //pathTransition.setOrientation(
        //      PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        //Setting the duration of the transition
        pathTransition.setDuration(Duration.millis(50));

        pathTransition.setOnFinished(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                node.setVisible(true);
            }
        });


        pathTransition.play();
    }
}
