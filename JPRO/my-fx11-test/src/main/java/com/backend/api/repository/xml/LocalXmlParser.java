package com.backend.api.repository.xml;

import com.backend.api.model.details.Details;

import java.lang.reflect.Field;
import java.util.List;

public class LocalXmlParser {

    public static int[] detailsSizeArray = findAllDetailsSize();

    public static List<Details> findAllDetailsPerCategory(String category){
        try {
            Object obj = Class.forName("com.backend.api.repository.xml.content."+category.toUpperCase()).newInstance();
            Field field = obj.getClass().getDeclaredField("detailsList");
           return (List<Details>) field.get(obj);
        } catch(Exception ex){
            throw  new RuntimeException(ex);
        }
    }

    public static int findAllDetailsSizePerCategory(String category){
        return findAllDetailsPerCategory(category).size();
    }

    public static int[] findAllDetailsSize(){
        int[] data = new int[90];
        for(int i=0;i<data.length;i++){
            data[i] = findAllDetailsSizePerCategory("C"+i);
        }
        return data;
    }

}
