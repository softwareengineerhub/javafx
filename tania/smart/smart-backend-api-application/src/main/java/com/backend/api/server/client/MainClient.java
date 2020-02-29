/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.api.server.client;

import com.backend.api.model.category.Category;
import com.backend.api.server.data.MessageData;
import java.util.List;

/**
 *
 * @author asusadmin
 */
public class MainClient {

    public static void main(String[] args) {
        //ServerClient serverClient = new ServerClientImpl("52.39.234.36", 8083);
        ServerClient serverClient = new ServerClientImpl("127.0.0.1", 8083);
        
        MessageData messageData = new MessageData();
        messageData.setCategoryRequest(true);
        List<Category> categories = (List<Category>) serverClient.readData(messageData);
        System.out.println("categories.size=" + categories.size());
    }

}
