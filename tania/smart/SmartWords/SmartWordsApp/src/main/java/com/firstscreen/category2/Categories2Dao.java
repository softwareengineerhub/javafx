package com.firstscreen.category2;

import com.backend.api.config.AppConfig;
import com.backend.api.model.category.Category;
import com.backend.api.model.version.VersionAmountData;
import com.backend.api.server.client.ServerClient;
import com.backend.api.server.client.ServerClientImpl;
import com.backend.api.server.data.MessageData;
import com.firstscreen.file.storage.CategoryFileStorage;
import com.firstscreen.file.storage.CategoryFileStorageImpl;

import java.util.List;

public class Categories2Dao {
    private ServerClient serverClient;
    private String host = AppConfig.HOST;

    private int port = 8083;
    private volatile List<Category> currentCategories;
    private volatile VersionAmountData version;


    public void callForVersion() {
        MessageData messageData = new MessageData();
        messageData.setCategoryVersionRequest(true);
        serverClient = new ServerClientImpl(host, port);
        version = (VersionAmountData) serverClient.readData(messageData);
    }


    public void clear() {
        CategoryFileStorage categoryFileStorage = new CategoryFileStorageImpl();
        categoryFileStorage.clear();
    }

    public void findAll() {
        MessageData messageData = new MessageData();
        messageData.setCategoryVersionRequest(false);
        messageData.setCategoryRequest(true);
        messageData.setCategoryPaginationIndex(0);
        System.out.println("Here");
        serverClient = new ServerClientImpl(host, port);
        currentCategories = (List<Category>) serverClient.readData(messageData);
        System.out.println("currentCategories.size()=" + currentCategories.size());
        CategoryFileStorage categoryFileStorage = new CategoryFileStorageImpl();
        categoryFileStorage.save(currentCategories, 0);
    }

    public boolean needToRefreshByVersion() {
        MessageData messageData = new MessageData();
        messageData.setCategoryVersionRequest(true);
        serverClient = new ServerClientImpl(host, port);
        VersionAmountData serverVersion = (VersionAmountData) serverClient.readData(messageData);
        if (serverVersion.getVersion() != version.getVersion()) {
            version = serverVersion;
            return true;
        }
        return false;
    }


    /*public List<Category> getCurrentCategories() {
        CategoryFileStorage categoryFileStorage = new CategoryFileStorageImpl();
        return categoryFileStorage.load(0);
    }*/

    public List<Category> getCurrentCategories() {
        return currentCategories;
    }

    public void setCurrentCategories(List<Category> currentCategories) {
        this.currentCategories = currentCategories;
    }

}
