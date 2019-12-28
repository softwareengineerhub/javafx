/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.api.server.client;

import com.backend.api.model.category.Category;
import com.backend.api.model.details.Details;
import com.backend.api.server.data.MessageData;
import java.util.List;

/**
 *
 * @author asusadmin
 */
public class DetailsClient {
//    Category0
    
    public static void main(String[] args) {
        ServerClient serverClient = new ServerClientImpl("localhost", 8083);
        MessageData messageData = new MessageData();
        messageData.setCategoryRequest(false);
        messageData.setCategoryName("Category0");
        List<Details> detailsList = (List<Details>) serverClient.readData(messageData);
        System.out.println("detailsList.size=" + detailsList.size());
        for(Details item: detailsList){
            //System.out.println(item.getName());
        }
    }
    
}
