package com.middleware;

import com.backend.api.model.details.Details;
import com.backend.api.server.client.ServerClient;
import com.backend.api.server.client.ServerClientImpl;
import com.backend.api.server.data.MessageData;
import javafx.scene.image.Image;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.*;

public class Details2Dao {

    private List<Details> lastVisited;
    private ServerClient serverClient;
    private String host = "134.209.244.234";
    private int port = 8083;

    public void cleanup() {
        lastVisited = null;
    }

    public List<Details> findAllDetails(String categoryName) {
        MessageData messageData = new MessageData();
        messageData.setCategoryName(categoryName);
        serverClient = new ServerClientImpl(host, port);
        lastVisited = (List<Details>) serverClient.readData(messageData);
        return lastVisited;
    }

    private Details findDetailsByIndex(String categoryName, int detailsIndex) {
        MessageData messageData = new MessageData();
        messageData.setCategoryName(categoryName);
        messageData.setDetailsIndex(detailsIndex);
        serverClient = new ServerClientImpl(host, port);
        return (Details) serverClient.readData(messageData);
    }

    public void initAllDetailsPerCategory(String categoryName) {
        Thread t = new Thread() {

            public void run() {
                findAllDetails(categoryName);
            }
        };
        t.start();
    }


    public Details findDetail(String categoryName, int index) {
        if (index < 0) {
            return null;
        }

        if (lastVisited == null) {
            Details details = findDetailsByIndex(categoryName, index);
            initImage(details, categoryName, index);
            return details;
        }

        if (index >= lastVisited.size()) {
            return null;
        }

        Details details = lastVisited.get(index);
        initImage(details, categoryName, index);
        return details;
    }

    private void initImage(Details details, String categoryName, int index) {
        byte[] data = details.getImageData();
        try (InputStream in = new ByteArrayInputStream(data)) {
            details.setImage(new Image(in));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}
