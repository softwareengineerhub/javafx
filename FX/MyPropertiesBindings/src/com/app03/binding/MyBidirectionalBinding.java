/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app03.binding;

import javafx.scene.shape.Circle;

/**
 *
 * @author Denys.Prokopiuk
 */
public class MyBidirectionalBinding {

    public static void main(String[] args) {
        Circle c1 = new Circle(10);
        Circle c2 = new Circle(20);
        System.out.println("c1=" + c1.getRadius());
        System.out.println("c2=" + c2.getRadius());
        c1.radiusProperty().bindBidirectional(c2.radiusProperty());
        System.out.println("@After binding");
        System.out.println("c1=" + c1.getRadius());
        System.out.println("c2=" + c2.getRadius());
        System.out.println("@After changes in c1");

        c1.setRadius(30);
        System.out.println("c1=" + c1.getRadius());
        System.out.println("c2=" + c2.getRadius());
        
        //always false
        System.out.println("isBound: " + c1.radiusProperty().isBound());
        c1.radiusProperty().unbind();
        System.out.println("isBound: " + c1.radiusProperty().isBound());
    }

}
