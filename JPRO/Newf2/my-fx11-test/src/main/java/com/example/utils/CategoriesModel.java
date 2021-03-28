package com.example.utils;

public class CategoriesModel {
    private String ch;
    private String chMeta;
    private String eng;
    private String ru;

    public CategoriesModel() {
    }

    public CategoriesModel(String ch, String chMeta, String eng, String ru) {
        this.ch = ch;
        this.chMeta = chMeta;
        this.eng = eng;
        this.ru = ru;
    }

    public String getCh() {
        return ch;
    }

    public void setCh(String ch) {
        this.ch = ch;
    }

    public String getChMeta() {
        return chMeta;
    }

    public void setChMeta(String chMeta) {
        this.chMeta = chMeta;
    }

    public String getEng() {
        return eng;
    }

    public void setEng(String eng) {
        this.eng = eng;
    }

    public String getRu() {
        return ru;
    }

    public void setRu(String ru) {
        this.ru = ru;
    }
}
