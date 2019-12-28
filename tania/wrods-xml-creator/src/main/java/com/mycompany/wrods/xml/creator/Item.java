/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.wrods.xml.creator;

/**
 *
 * @author asusadmin
 */
public class Item {

    private int id;
    private String ch;
    private String chMeta;
    private String en;
    private String ua;

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

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }

    public String getUa() {
        return ua;
    }

    public void setUa(String ua) {
        this.ua = ua;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString() {
        return String.format("<detail id=\"%s\">\n"
                + "        <ch>%s</ch>\n"
                + "        <ch.meta>%s</ch.meta>\n"
                + "        <en>%s</en>\n"
                + "        <ru>%s</ru>\n"
                + "    </detail>", id, ch, chMeta, en, ua);
    }
}
