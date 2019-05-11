/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.api.model.details;

import java.io.Serializable;

/**
 *
 * @author Denys.Prokopiuk
 */
public class Details implements Serializable {

    private byte[] image;
    private byte[] soundA;
    private byte[] soundB;
    private byte[] soundC;
    private String name;

    private static final long serialVersionUID = 7L;

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
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

}
