/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.api.model.details;

import javafx.scene.image.Image;

import java.io.Serializable;

/**
 *
 * @author Denys.Prokopiuk
 */
public class Details implements Serializable {

    private byte[] imageData;
    private byte[] soundA;
    private byte[] soundB;
    private byte[] soundC;

    private String descriptionA;
    private String descriptionB;
    private String descriptionC;
    private String descriptionD;

    private String name;

    private Image image;

    private static final long serialVersionUID = 7L;

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }

    public byte[] getSoundA() {
        return soundA;
    }

    public void setSoundA(byte[] soundA) {
        this.soundA = soundA;
    }

    public byte[] getSoundB() {
        return soundB;
    }

    public void setSoundB(byte[] soundB) {
        this.soundB = soundB;
    }

    public byte[] getSoundC() {
        return soundC;
    }

    public void setSoundC(byte[] soundC) {
        this.soundC = soundC;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}
