/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firstscreen;

import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.Reflection;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

/**
 *
 * @author asusadmin
 */
public class AnimationUtils {
    //private static RotateTransition[] rotateTransitions = new RotateTransition[9];
    //private static int i;    

    public static void animate(Node node, Reflection effect) {
        final ColorAdjust effectPressed = new ColorAdjust();
        effectPressed.setBrightness(-0.5);
        String DURATION = "300ms";
        double SCALE = 1.1;
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
    
    public static void animateCategories(Node node){         
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
            //    System.out.println("FINISH");
                RotateTransition rotateTransition = new RotateTransition(Duration.millis(300), node);
                    //rotateTransition.setFromAngle(-15);
                rotateTransition.setToAngle(0);
                rotateTransition.play();
                
            }
        });
       // rotateTransitions[i++]=rotateTransition;
        rotateTransition.play();
        
        
    }
    

}
