/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.api.cache.details;

import com.backend.api.model.details.Details;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author asusadmin
 */
public class DetailsCacheImpl implements DetailsCache {
    
    //private static final File TMP_FILE = ;
    //

    @Override
    public List<Details> findDetailsByCategory(String categoryName) {
        //File.
       // System.getProperty("java.io.tmp.dir");
        File file = new File(System.getProperty("java.io.tmpdir"), File.separator+categoryName+".txt");
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            return (List<Details>) in.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ArrayList();
        }
    }

    @Override
    public void updateDetailsPerCategory(String categoryName, List<Details> detailsList) {
        File file = new File(System.getProperty("java.io.tmpdir"), File.separator+categoryName+".txt");
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            out.writeObject(detailsList);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
