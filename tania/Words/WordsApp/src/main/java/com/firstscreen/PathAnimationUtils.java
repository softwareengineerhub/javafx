/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firstscreen;

import javafx.animation.PathTransition;
import javafx.animation.PathTransition.OrientationType;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

/**
 *
 * @author asusadmin
 */
public class PathAnimationUtils {

    public static void animateCategories(Node node, double parentWidth, double parentHeight) {            
        //final Scene scene = node.getScene();
          //     final Point2D windowCoord = new Point2D(scene.getWindow().getX(), scene.getWindow().getY());
            //   final Point2D sceneCoord = new Point2D(scene.getX(), scene.getY());
        final Point2D nodeCoord = node.localToScene(0.0, 0.0);
               //final double clickX = Math.round(windowCoord.getX() + sceneCoord.getX() + nodeCoord.getX());
               //final double clickY = Math.round(windowCoord.getY() + sceneCoord.getY() + nodeCoord.getY());


        
        Path path = new Path();        
        //path.getElements().add(new MoveTo(node.getLayoutX()-node.getBoundsInLocal().getWidth(),node.getLayoutY()-node.getBoundsInLocal().getHeight()));
        //double startX = node.getLayoutX()+node.getBoundsInLocal().getWidth();
        //double startY = node.getLayoutY()+node.getBoundsInLocal().getHeight();
        double startX = nodeCoord.getX();
        double startY = nodeCoord.getY();
        
        
        //path.getElements().add(new MoveTo(startX, startY));                
        path.getElements().add(new MoveTo(-startX, 0));                
        path.getElements().add(new LineTo(parentWidth, 0));                
        //path.getElements().add(new LineTo(parentWidth, 0));                
        //path.getElements().add(new CubicCurveTo(0, startY, parentWidth/2, 0, parentWidth, parentHeight));
        
      //  path.getElements().add(new CubicCurveTo(parentWidth-10, 0, 0, 0, parentWidth-50, parentHeight));
        //path.getElements().add(new CubicCurveTo(10, 10, 0, 0, 290, 0));
        //path.getElements().add(new CubicCurveTo(290, 0, 0, 0, 200, 550));
        
        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(2000));
        pathTransition.setNode(node);
        pathTransition.setPath(path);
        
        pathTransition.setOrientation(OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransition.setCycleCount(Timeline.INDEFINITE);
        //pathTransition.setCycleCount(2);
        
        pathTransition.setAutoReverse(true);
        
        pathTransition.play();
        /*pathTransition.setOnFinished(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                Path path = new Path();
                path.getElements().add(new MoveTo(0, 0));
                PathTransition pathTransition = new PathTransition();
                pathTransition.setPath(path);
                pathTransition.setNode(node);
              //  pathTransition.play();

            }
        });*/

        
        
        
        
        
        

    }

}

