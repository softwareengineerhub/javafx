/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app02.listeners;

import com.app01.properties.Person;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

/**
 *
 * @author Denys.Prokopiuk
 */
public class MyInvalidationListener {
    
    public static void main(String[] args) {
        final Person male = new Person();
        male.setFullname("Joe Smith");
        male.setEmployed(true);
        System.out.println(male);
        
        InvalidationListener mylistener = new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                System.out.println("Listener: "+male);
            }
        };
        
        male.fullnameProperty().addListener(mylistener);
        male.setFullname("Joseph Smith");
        
    }
    
}
