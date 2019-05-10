/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app01.properties;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Denys.Prokopiuk
 */
public class Person {

    private final StringProperty fullname = new SimpleStringProperty(this, "fullname", "");
    private final BooleanProperty employed = new SimpleBooleanProperty(this, "employed", false);

    public StringProperty fullnameProperty() {
        return fullname;
    }

    public BooleanProperty employedProperty() {
        return employed;
    }

    public String getFullname() {
        return fullname.get();
    }

    public void setFullname(String fullname) {
        this.fullname.set(fullname);
    }

    public boolean isEmployed() {
        return this.employed.get();
    }

    public void setEmployed(boolean emploeed) {
        this.employed.set(emploeed);
    }

    @Override
    public String toString() {
        return "Person{" + "fullname=" + getFullname() + ", employed=" + isEmployed() + '}';
    }
    
    

}
