package com.firstscreen.category2;

import com.backend.api.model.category.Category;
import com.backend.api.server.client.ServerClient;
import com.backend.api.server.client.ServerClientImpl;
import com.backend.api.server.data.MessageData;
import com.example.utils.CategoriesModel;
import com.example.utils.CategoriesReader;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public class Categories2Dao {
    private ServerClient serverClient;
    //private String host = "127.0.0.1";
    //private String host = "52.39.234.36";
   // private String host = "134.209.244.234";
    //private String host = "159.89.202.2";
   // private String host = "128.199.185.171";
    
   // private int port = 8083;
    private List<Category> currentCategories;

    public void findAll(int pathNumber) {
        currentCategories = new ArrayList<>();
        int step = pathNumber*10;
        for(int i=0;i<10;i++){
            Category category = findCategory(step+i);
            if(category!=null) {
                currentCategories.add(category);
            }
            //currentCategories.add(findCategory(i));
        }
        /*Thread t = new Thread() {

            public void run() {
                MessageData messageData = new MessageData();
                messageData.setCategoryRequest(true);
                serverClient = new ServerClientImpl(host, port);
                currentCategories = (List<Category>) serverClient.readData(messageData);
            }
        };
        t.start();*/

    }


    public List<Category> getCurrentCategories() {
        //findAll(pathNumber);
        return currentCategories;
    }

    private Category findCategory(int index){
        if(index>88){
            return null;
        }
        Category category = new Category();
        //category.setDescriptionA("a"+index);
        //category.setDescriptionB("b"+index);
        //category.setDescriptionC("c"+index);
        //category.setDescriptionD("d"+index);


        CategoriesModel cm = CategoriesReader.readAllCategories()[index];
        category.setDescriptionA(cm.getCh());
        category.setDescriptionB(cm.getChMeta());
        category.setDescriptionC(cm.getEng());
        category.setDescriptionD(cm.getRu());


        try {
            if(index<3) {
                category.setImage(new Image(getClass().getResourceAsStream("/categories/c" + index + ".jpg")));
            }else if(index==81){
                category.setImage(new Image(getClass().getResourceAsStream("/categories/b" + index + ".JPG")));
            } else {
                category.setImage(new Image(getClass().getResourceAsStream("/categories/b" + index + ".jpg")));
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return category;
    }

}
