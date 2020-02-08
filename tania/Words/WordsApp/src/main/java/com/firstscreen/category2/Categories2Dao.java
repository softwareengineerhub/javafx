package com.firstscreen.category2;

import com.backend.api.model.category.Category;
import com.backend.api.server.client.ServerClient;
import com.backend.api.server.client.ServerClientImpl;
import com.backend.api.server.data.MessageData;

import java.util.List;

public class Categories2Dao {
    private ServerClient serverClient;
    //private String host = "127.0.0.1";
    //private String host = "52.39.234.36";
    private String host = "134.209.244.234";
    private int port = 8083;
    private volatile List<Category> currentCategories;

    public void findAll() {
        Thread t = new Thread() {

            public void run() {
                MessageData messageData = new MessageData();
                messageData.setCategoryRequest(true);
                serverClient = new ServerClientImpl(host, port);
                currentCategories = (List<Category>) serverClient.readData(messageData);
            }
        };
        t.start();

    }


    public List<Category> getCurrentCategories() {
        return currentCategories;
    }

}
