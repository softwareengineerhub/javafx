/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.api.model.category;

import com.backend.api.model.details.Details;
import java.io.Serializable;

/**
 *
 * @author Denys.Prokopiuk
 */
public class Category implements Serializable {

    private String descriptionA;
    private String descriptionB;
    private String descriptionC;
    private String descriptionD;
    private byte[] imageData;
    private String name;
    private Details firstDetails;

    private static final long serialVersionUID = 7L;

    public String getDescriptionA() {
        return descriptionA;
    }

    public void setDescriptionA(String descriptionA) {
        this.descriptionA = descriptionA;
    }

    public String getDescriptionB() {
        return descriptionB;
    }

    public void setDescriptionB(String descriptionB) {
        this.descriptionB = descriptionB;
    }

    public String getDescriptionC() {
        return descriptionC;
    }

    public void setDescriptionC(String descriptionC) {
        this.descriptionC = descriptionC;
    }

    public String getDescriptionD() {
        return descriptionD;
    }

    public void setDescriptionD(String descriptionD) {
        this.descriptionD = descriptionD;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Details getFirstDetails() {
        return firstDetails;
    }

    public void setFirstDetails(Details firstDetails) {
        this.firstDetails = firstDetails;
    }
    
    
    

}
