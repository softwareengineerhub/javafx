/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firstscreen.details;

import com.backend.api.model.details.Details;
import java.util.List;

/**
 *
 * @author asusadmin
 */
public class DetailsCache {

    private static DetailsCache instance = new DetailsCache();
    private List<Details> detailses; 
    
    private DetailsCache(){
    }

    public List<Details> getDetailses() {
        return detailses;
    }

    public void setDetailses(List<Details> detailses) {
        this.detailses = detailses;
    }
    
    public static DetailsCache getInstance(){
        return instance;
    }

}
