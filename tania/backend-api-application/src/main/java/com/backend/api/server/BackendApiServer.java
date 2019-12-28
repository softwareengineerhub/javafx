/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.api.server;

import com.backend.api.server.data.MessageData;
import com.backend.api.service.category.CategoryService;
import com.backend.api.service.details.DetailsService;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Denys.Prokopiuk
 */
public class BackendApiServer extends Thread {

    private boolean needToRun = true;
    private ServerSocket serverSocket;
    private CategoryService categoryService;
    private DetailsService detailsService;

    public BackendApiServer(int port, CategoryService categoryService, DetailsService detailsService) {
        try {
            this.categoryService = categoryService;
            this.detailsService = detailsService;
            serverSocket = new ServerSocket(port);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void run() {
        while (needToRun) {
            try {
                Socket socket = serverSocket.accept();
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                MessageData messageData = (MessageData) in.readObject();
                System.out.println(messageData.isCategoryRequest());
                Object resultData = processIncommingMessage(messageData);
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                out.writeObject(resultData);
                out.flush();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private Object processIncommingMessage(MessageData messageData) {
        String categoryName = messageData.getCategoryName();
        String name = messageData.getName();
        if (messageData.isCategoryRequest()) {
            return categoryService.getAllCategories();
        } else  {          
    //            System.out.println("else");
            System.out.println(categoryName);
            if (categoryName != null && !categoryName.trim().isEmpty()) {
                System.out.println("details service");
                
                if(messageData.getDetailsIndex()!=-1){
                        System.out.println("Details by index"+categoryName+"; "+messageData.getDetailsIndex());
                        return detailsService.getDetailsByIndex(categoryName, messageData.getDetailsIndex());
                    }                    
                
                if (name != null && !name.trim().isEmpty()) {
                    
                    return detailsService.getDetailsByName(categoryName, name);
                } else {
                    System.out.println("detailsService.getAllDetailsPerCategory()");
                    return detailsService.getAllDetailsPerCategory(categoryName);
                }
        }
        }
        return "";
    }

    public void stopServer() {
        needToRun = false;
    }

}
