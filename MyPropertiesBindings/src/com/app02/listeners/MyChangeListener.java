/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app02.listeners;

import com.app01.properties.Person;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 *
 * @author Denys.Prokopiuk
 */
public class MyChangeListener {

    public static void main(String[] args) {
        final Person male = new Person();
        male.setFullname("Joe Smith");
        male.setEmployed(true);
        System.out.println(male);

        male.fullnameProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                System.out.println(observable.getValue());
                System.out.println("oldValue=" + oldValue);
                System.out.println("newValue=" + newValue);
            }

        });

        male.setFullname("Joseph Smith");
    }

}
