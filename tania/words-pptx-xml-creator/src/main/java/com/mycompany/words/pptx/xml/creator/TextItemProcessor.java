/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.words.pptx.xml.creator;

import com.mycompany.wrods.xml.creator.Item;
import java.io.BufferedReader;
import java.io.CharArrayReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author asusadmin
 */
public class TextItemProcessor {

    private List<Item> items = new ArrayList<>();

    public void addText(String text) {
        try {
            Item item = createItemFromText(text);
            items.add(item);
            item.setId(items.size()-1);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }

    private Item createItemFromText(String text) throws Exception {
        Item item = new Item();
        BufferedReader bufferedReader = new BufferedReader(new CharArrayReader(text.toCharArray()));
        String line = null;
        int index = 0;
        while ((line = bufferedReader.readLine()) != null) {
            if (line.trim().isEmpty()) {
                continue;
            }
            String content = new String(line.getBytes(), "UTF-8");

            switch (index) {
                case 0:
                    item.setCh(content);
                    break;
                case 1:
                    item.setChMeta(content);
                    break;
                case 2:
                    item.setEn(content);
                    break;
                case 3:
                    item.setUa(content);
                    break;
            }
            index++;
        }

        return item;
    }

    public List<Item> getItems() {
        return items;
    }
    
}
