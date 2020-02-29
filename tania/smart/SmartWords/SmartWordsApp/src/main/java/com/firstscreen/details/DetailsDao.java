/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firstscreen.details;

import com.backend.api.model.category.Category;
import com.backend.api.model.details.Details;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.backend.api.server.client.ServerClient;
import com.backend.api.server.client.ServerClientImpl;
import com.backend.api.server.data.MessageData;
import javafx.scene.image.Image;

/**
 *
 * @author asusadmin
 */
public class DetailsDao {


    private ServerClient serverClient;
    private String host = "127.0.0.1";
    private int port = 8083;

    public List<Category> findAllDetails(String categoryName) {
        MessageData messageData = new MessageData();
        messageData.setCategoryName(categoryName);
        serverClient = new ServerClientImpl(host, port);
        return (List<Category>) serverClient.readData(messageData);
    }



    /*
    private void initSounds(Details details, String categoryName, int index) {
        details.setSoundA(String.format("details/%s/Details%s/en.mp3", categoryName, index));
        details.setSoundA(String.format("details/%s/Details%s/ch.mp3", categoryName, index));
        details.setSoundA(String.format("details/%s/Details%s/ru.mp3", categoryName, index));
    }*/

}
