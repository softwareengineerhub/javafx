package com.middleware;

import com.backend.api.model.category.Category;
import com.backend.api.server.client.ServerClient;
import com.backend.api.server.client.ServerClientImpl;
import com.backend.api.server.data.MessageData;

import java.util.List;

public class Categories2Dao {
    private ServerClient serverClient;
    private String host = AppConfig.HOST;
    private int port = 8083;
    private volatile List<Category> currentCategories;
    private volatile int version;

    public void findAll() {
        Thread t = new Thread() {

            public void run() {

                //needToRefreshByVersion();

                MessageData messageData = new MessageData();
                messageData.setCategoryVersionRequest(true);
                serverClient = new ServerClientImpl(host, port);
                version = (Integer) serverClient.readData(messageData);

                messageData = new MessageData();
                messageData.setCategoryRequest(true);
                serverClient = new ServerClientImpl(host, port);               
                currentCategories = (List<Category>) serverClient.readData(messageData);                

            }
        };
        t.start();

    }

    public boolean needToRefreshByVersion() {
        MessageData messageData = new MessageData();
        messageData.setCategoryVersionRequest(true);
        serverClient = new ServerClientImpl(host, port);
        int serverVersion = (Integer) serverClient.readData(messageData);
        if (serverVersion != version) {
            //version = serverVersion;
            return true;
        }
        return false;
    }


    public List<Category> getCurrentCategories() {
        return currentCategories;
    }

    public void setCurrentCategories(List<Category> currentCategories) {
        this.currentCategories=currentCategories;
    }

}
