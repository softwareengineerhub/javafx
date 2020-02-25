package com.firstscreen.details2;

import com.backend.api.config.AppConfig;
import com.backend.api.model.category.Category;
import com.backend.api.model.details.Details;
import com.backend.api.server.client.ServerClient;
import com.backend.api.server.client.ServerClientImpl;
import com.backend.api.server.data.MessageData;
import com.firstscreen.details2.data.*;
import javafx.scene.image.Image;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class DetailsDao2 {
    private List<Details> lastVisited;


    private ServerClient serverClient;
    //private String host = "127.0.0.1";
    //private String host = "52.39.234.36";
    //private String host = "134.209.244.234";
    private String host = AppConfig.HOST;


    private int port = 8083;

    public void cleanup(){
        lastVisited=null;
    }

    public List<Details> findAllDetails(String categoryName) {
        MessageData messageData = new MessageData();
        messageData.setCategoryName(categoryName);
        serverClient = new ServerClientImpl(host, port);
        lastVisited =  (List<Details>) serverClient.readData(messageData);
        return  lastVisited;
    }

    private Details findDetailsByIndex(String categoryName, int detailsIndex) {
        MessageData messageData = new MessageData();
        messageData.setCategoryName(categoryName);
        messageData.setDetailsIndex(detailsIndex);
        serverClient = new ServerClientImpl(host, port);
        return (Details) serverClient.readData(messageData);
    }

    public void initAllDetailsPerCategory(String categoryName){
        Thread t = new Thread(){

            public void run(){
                findAllDetails(categoryName);
            }
        };
        t.start();
    }


    public Details findDetail(String categoryName, int index) {

        if(index<0){
            return null;
        }

        if(lastVisited==null){
            Details details = findDetailsByIndex(categoryName, index);
            initImage(details, categoryName, index);
            initDescriptions(details, categoryName, index);
            return details;
        }

        if(index>=lastVisited.size()){
            return null;
        }

        Details details = lastVisited.get(index);
        initImage(details, categoryName, index);
        initDescriptions(details, categoryName, index);
        return details;
    }

    private void initImage(Details details, String categoryName, int index) {
        byte[] data = details.getImageData();
        try(InputStream in = new ByteArrayInputStream(data)){
            details.setImage(new Image(in));
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }

    private void initDescriptions(Details details, String categoryName, int index) {

    }



    public Details findDetailOld(String categoryName, int index) {
        try {
            Details details = new Details();
            initImage(details, categoryName, index);
            initDescriptions(details, categoryName, index);
            initSounds(details, categoryName, index);
            return details;
        }catch(Exception ex){
            return null;
        }
    }

    private void initImageOld(Details details, String categoryName, int index) {
        String filePath = String.format("/details2/%s/Details%s/picture.jpg", categoryName, index);

        try (InputStream in = getClass().getResourceAsStream(filePath)) {
            Image img = new Image(in);
            details.setImage(img);
        } catch (Throwable ex) {
            filePath = String.format("/details2/%s/Details%s/picture.png", categoryName, index);
            try (InputStream in = getClass().getResourceAsStream(filePath)) {
                Image img = new Image(in);
                details.setImage(img);

            } catch (Throwable ex2) {
                throw new RuntimeException(ex2);
            }
        }
    }

    private void initDescriptionsOld(Details details, String categoryName, int index) {
      //  Map<String, String> map = getDescriptions(categoryName);
       // details.setNameA(map.get("ch"+index));
        //details.setNameB(map.get("ch"+index+".meta"));
        //details.setNameC(map.get("en"+index));
        //details.setNameD(map.get("ru"+index));


        /*Properties props = new Properties();
        try (InputStream in = getClass().getResourceAsStream(String.format("/details2/%s/Details%s/word.properties", categoryName, index))) {
            props.load(in);
            details.setNameA(props.getProperty("en"));
            details.setNameB(props.getProperty("ch"));
            details.setNameC(props.getProperty("ru"));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }*/
    }

    private void initSounds(Details details, String categoryName, int index) {
    //    details.setSoundA(String.format("details2/%s/Details%s/en.mp3", categoryName, index));
  //      details.setSoundB(String.format("details2/%s/Details%s/ch.mp3", categoryName, index));
//        details.setSoundC(String.format("details2/%s/Details%s/ru.mp3", categoryName, index));
    }







    private Map<String, String> getDescriptions(String categoryName){
        Map<String, String> map = new HashMap<>();
        if(categoryName.equalsIgnoreCase("c0")){
            return FamilyData.getData();
        }
        if(categoryName.equalsIgnoreCase("c1")){
            return BankData.getData();
        }
        if(categoryName.equalsIgnoreCase("c2")){
            return FaceData.getData();
        }
        if(categoryName.equalsIgnoreCase("c4")){
            return LifeEventsData.getData();
        }
        if(categoryName.equalsIgnoreCase("c5")){
            return NutsSeeds.getData();
        }
        if(categoryName.equalsIgnoreCase("c6")){
            return Sport.getData();
        }
        if(categoryName.equalsIgnoreCase("c7")){
            return Drinks.getData();
        }
        if(categoryName.equalsIgnoreCase("c8")){
            return HorseRiding.getData();
        }
        if(categoryName.equalsIgnoreCase("c9")){
            return Seasons.getData();
        }
        if(categoryName.equalsIgnoreCase("c10")){
            return Mashrooms.getData();
        }
        if(categoryName.equalsIgnoreCase("c11")){
            return Animals.getData();
        }
        if(categoryName.equalsIgnoreCase("c12")){
            return GrainsAndBeans.getData();
        }
        if(categoryName.equalsIgnoreCase("c13")){
            return PoisonBerry.getData();
        }
        if(categoryName.equalsIgnoreCase("c14")){
            return Berries.getData();
        }
        return map;
    }

}
