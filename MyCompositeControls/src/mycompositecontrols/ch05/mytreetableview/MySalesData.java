/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycompositecontrols.ch05.mytreetableview;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Denys.Prokopiuk
 */
public class MySalesData {

    private StringProperty company = new SimpleStringProperty();
    private DoubleProperty units = new SimpleDoubleProperty();

    public MySalesData(String name, double price) {
        company.set(name);
        units.set(price);
    }

    public MySalesData() {
    }

    public final String getCompany() {
        return company.getValue();
    }

    public final void setCompany(String name) {
        company.set(name);
    }

    public final double getPrice() {
        return units.get();
    }

    public final void setPrice(double price) {
        units.set(price);
    }

    public StringProperty getCompanyProperty() {
        return company;
    }

    public DoubleProperty getUnitsProperty() {
        return units;
    }
}
